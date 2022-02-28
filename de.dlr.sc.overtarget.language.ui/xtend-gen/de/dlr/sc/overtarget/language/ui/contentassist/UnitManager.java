/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ui.contentassist;

import de.dlr.sc.overtarget.language.Activator;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.targetmodel.UrlExpression;
import de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementStringImpl;
import de.dlr.sc.overtarget.language.ui.OvertargetRunnableAdapter;
import de.dlr.sc.overtarget.language.util.QueryManager;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class UnitManager {
  private static UnitManager instance;
  
  private Job job = null;
  
  private OvertargetRunnableAdapter runnable = null;
  
  private UnitManager() {
  }
  
  public static synchronized UnitManager getInstance() {
    if ((UnitManager.instance == null)) {
      UnitManager _unitManager = new UnitManager();
      UnitManager.instance = _unitManager;
    }
    return UnitManager.instance;
  }
  
  private final HashMap<String, ArrayList<Unit>> mapOfUnits = new HashMap<String, ArrayList<Unit>>();
  
  public HashMap<String, ArrayList<Unit>> getMapOfUnits() {
    return this.mapOfUnits;
  }
  
  /**
   * This method checks if the String reposLocName is contained in the mapOfUnits
   * -> units are already loaded
   * 
   * @param reposLocName	the name of the given repository location
   * @return				<code>true</code> if mapOfUnits does contain the units of the given repository location <br>
   * 						<code>false</code> if mapOfUnits does not contain the units of the given repository location
   */
  public boolean checkIfUnitsLoaded(final String reposLocName) {
    boolean _containsKey = this.mapOfUnits.containsKey(reposLocName);
    boolean _not = (!_containsKey);
    if (_not) {
      return false;
    } else {
      return true;
    }
  }
  
  public ArrayList<Unit> getUnits(final String reposLocName) {
    try {
      final HashMap<String, ArrayList<Unit>> mapOfUnits = this.mapOfUnits;
      boolean _containsKey = mapOfUnits.containsKey(reposLocName);
      if (_containsKey) {
        final ArrayList<Unit> listOfUnits = mapOfUnits.get(reposLocName);
        return listOfUnits;
      } else {
        if (((this.job != null) && (this.runnable != null))) {
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().setActive();
          PlatformUI.getWorkbench().getProgressService().busyCursorWhile(this.runnable);
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * This method starts for every repository location of a given TargetFile a job to load units in the background
   * 
   * @param reposLoc	the repository location which contains units that have to be loaded
   * @return			<code>Status.OK_STATUS</code> if the units are loaded successfully <br>
   * 					<code>Status.CANCEL_STATUS</code> if loading units failed
   */
  public void loadUnits(final RepositoryLocation reposLoc) {
    boolean _checkUriIsValid = this.checkUriIsValid(reposLoc);
    if (_checkUriIsValid) {
      this.runnable = new OvertargetRunnableAdapter() {
        @Override
        public void doRun(final IProgressMonitor monitor) {
          final QueryManager queryManager = new QueryManager();
          try {
            final ArrayList<Unit> units = queryManager.getUnits(reposLoc);
            boolean _isEmpty = units.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              UnitManager.this.mapOfUnits.put(reposLoc.getName(), units);
            }
          } catch (final Throwable _t) {
            if (_t instanceof CoreException || _t instanceof IOException) {
              final Exception e = (Exception)_t;
              String _pluginId = Activator.getPluginId();
              final Status status = new Status(Status.ERROR, _pluginId, "Loading units failed", e);
              StatusManager.getManager().handle(status, StatusManager.SHOW);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
      this.job = Job.create("Loading units", this.runnable);
      this.job.schedule();
    }
  }
  
  /**
   * This method checks if the uri of a repository location is not empty and valid
   * 
   * @param reposLoc	the repository location which contains a uri to a repository
   * @return false	if the uri is empty or not valid
   * @return true		if the uri is valid
   */
  public boolean checkUriIsValid(final RepositoryLocation reposLoc) {
    final UrlExpression uri = reposLoc.getUrl();
    if ((uri instanceof UrlElementStringImpl)) {
      boolean _isEmpty = ((UrlElementStringImpl)uri).getContent().isEmpty();
      if (_isEmpty) {
        return false;
      }
      try {
        String _string = ((UrlElementStringImpl)uri).getContent().toString();
        new URI(_string);
        return true;
      } catch (final Throwable _t) {
        if (_t instanceof URISyntaxException) {
          final URISyntaxException e = (URISyntaxException)_t;
          ILog _log = Activator.getDefault().getLog();
          String _pluginId = Activator.getPluginId();
          Status _status = new Status(Status.ERROR, _pluginId, "Could not resolve URI", e);
          _log.log(_status);
          return false;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return false;
  }
  
  /**
   * This method gets the current repository location out of the tmodel
   * 
   * @param model		the current tmodel
   * @return reposLoc 	the repository location, either from a unit or a repository location
   */
  public RepositoryLocation getRepositoryLocation(final EObject model) {
    if ((model instanceof RepositoryLocation)) {
      final RepositoryLocation reposLoc = ((RepositoryLocation) model);
      return reposLoc;
    } else {
      if ((model instanceof Unit)) {
        final Unit unit = ((Unit) model);
        EObject _eContainer = unit.eContainer();
        final RepositoryLocation reposLoc_1 = ((RepositoryLocation) _eContainer);
        return reposLoc_1;
      }
    }
    return null;
  }
}
