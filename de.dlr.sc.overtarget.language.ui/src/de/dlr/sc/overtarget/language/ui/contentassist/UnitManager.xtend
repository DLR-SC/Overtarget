/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.ui.contentassist

import de.dlr.sc.overtarget.language.Activator
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
import de.dlr.sc.overtarget.language.targetmodel.Unit
import de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementStringImpl
import de.dlr.sc.overtarget.language.ui.OvertargetRunnableAdapter
import de.dlr.sc.overtarget.language.util.QueryManager
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException
import java.util.ArrayList
import java.util.HashMap
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.ecore.EObject
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.statushandlers.StatusManager
import java.net.MalformedURLException
import java.net.URL

class UnitManager {

	static UnitManager instance;
	Job job = null
	OvertargetRunnableAdapter runnable = null

	private new() {
	}

	def static synchronized UnitManager getInstance() {
		if (UnitManager.instance === null) {
			UnitManager.instance = new UnitManager()
		}
		return instance
	}

	val HashMap<String, ArrayList<Unit>> mapOfUnits = new HashMap<String, ArrayList<Unit>>

	def getMapOfUnits() {
		return mapOfUnits
	}

	/**
	 * This method checks if the String reposLocName is contained in the mapOfUnits 
	 * -> units are already loaded
	 * 
	 * @param reposLocName	the name of the given repository location
	 * @return				<code>true</code> if mapOfUnits does contain the units of the given repository location <br>
	 * 						<code>false</code> if mapOfUnits does not contain the units of the given repository location
	 */
	def checkIfUnitsLoaded(String reposLocName) {
		if (!mapOfUnits.containsKey(reposLocName)) {
			return false
		} else
			return true
	}

	def getUnits(String reposLocName) {
		val mapOfUnits = mapOfUnits
		if (mapOfUnits.containsKey(reposLocName)) {
			val listOfUnits = mapOfUnits.get(reposLocName)
			return listOfUnits
		} else {
			if (job !== null && runnable !== null) {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().setActive();
				PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable)
			}
		}
	}

	/**
	 * This method starts for every repository location of a given TargetFile a job to load units in the background
	 * 
	 * @param reposLoc	the repository location which contains units that have to be loaded
	 * @return			<code>Status.OK_STATUS</code> if the units are loaded successfully <br>
	 * 					<code>Status.CANCEL_STATUS</code> if loading units failed
	 */
	def loadUnits(RepositoryLocation reposLoc) {
		if (checkUriIsValid(reposLoc)) {
			runnable = new OvertargetRunnableAdapter() {
				override doRun(IProgressMonitor monitor) {
					val queryManager = new QueryManager();
					try {
						val units = queryManager.getUnits(reposLoc)
						if (!units.empty) {
							mapOfUnits.put(reposLoc.name, units)
						}
					} catch (CoreException | IOException e) {
						val status = new Status(Status.ERROR, Activator.getPluginId(), "Loading units failed", e);
						StatusManager.getManager().handle(status, StatusManager.SHOW);
					}
				}
			}

			job = Job.create("Loading units", runnable)
			job.schedule();

		}
	}

		/**
		 * This method checks if the uri of a repository location is not empty and valid
		 * 
		 * @param reposLoc	the repository location which contains a uri to a repository
		 * @return false	if the uri is empty or not valid
		 * @return true		if the uri is valid
		 */
	def checkUriIsValid(RepositoryLocation reposLoc) {
		val uri = reposLoc.url
		if (uri instanceof UrlElementStringImpl) {
			if (uri.content.empty) {
				return false
			}
			try {
				new URL(uri.content.toString)
				return true
			} catch (URISyntaxException e) {
				Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.getPluginId(), "Could not resolve URI", e));
				return false
			}
		}
	}

	/**
	* This method gets the current repository location out of the tmodel
	*
	* @param model		the current tmodel
	* @return reposLoc 	the repository location, either from a unit or a repository location
	*/
	def getRepositoryLocation(EObject model) {
		if (model instanceof RepositoryLocation) {
			val reposLoc = model as RepositoryLocation
			return reposLoc
		} else if (model instanceof Unit) {
			val unit = model as Unit
			val reposLoc = unit.eContainer as RepositoryLocation
			return reposLoc
		}
	}
}