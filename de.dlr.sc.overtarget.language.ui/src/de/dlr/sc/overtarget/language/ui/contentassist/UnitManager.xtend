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

import java.util.HashMap
import java.util.ArrayList
import de.dlr.sc.overtarget.language.targetmodel.Unit
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.IProgressMonitor
import de.dlr.sc.overtarget.language.util.QueryManager
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.CoreException
import java.io.IOException
import de.dlr.sc.overtarget.language.Activator
import org.eclipse.ui.statushandlers.StatusManager
import de.dlr.sc.overtarget.language.targetmodel.TargetFile

class UnitManager {
	
	static UnitManager instance;
	
	private new () {
	}
	
	def static synchronized UnitManager getInstance() {
		if (UnitManager.instance === null) {
			UnitManager.instance = new UnitManager() 
		}
		return instance 
	}
	
	val HashMap<String, ArrayList<Unit>> mapOfUnits = new HashMap<String, ArrayList<Unit>>
	
	def getMapOfUnits(){
		return mapOfUnits
	}
	
	def unitsLoaded(String reposLoc) {
		if (!mapOfUnits.containsKey(reposLoc)) {
			return false
		} else return true
	}

	def loadUnits(TargetFile target) {
		for (reposLoc : target.repositoryLocations) {
			if (unitsLoaded(reposLoc.name) == false){
				val job = new Job("Loading units") {
					override protected IStatus run(IProgressMonitor monitor) {
						try { 
							val queryManager = new QueryManager();
							val units = queryManager.getUnits(reposLoc)
							mapOfUnits.put(reposLoc.name, units)
							return Status.OK_STATUS;
						} catch (CoreException | IOException e) {
							val status = new Status(Status.ERROR, Activator.getPluginId(), 
								"Loading units failed", e);
							StatusManager.getManager().handle(status, StatusManager.SHOW);
							return Status.CANCEL_STATUS;
						}
					}
				}
				job.schedule();
			}
		}
	}
}