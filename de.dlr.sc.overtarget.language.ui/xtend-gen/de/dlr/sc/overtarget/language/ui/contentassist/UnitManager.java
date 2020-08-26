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
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.util.QueryManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class UnitManager {
  private static UnitManager instance;
  
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
  
  /**
   * This method starts for every repository location of a given TargetFile a job to load units in the background
   * 
   * @param target	the targetFile with repository locations which contain units that have to be loaded
   * @return			<code>Status.OK_STATUS</code> if the units are loaded successfully <br>
   * 					<code>Status.CANCEL_STATUS</code> if loading units failed
   */
  public void loadUnits(final TargetFile target) {
    EList<RepositoryLocation> _repositoryLocations = target.getRepositoryLocations();
    for (final RepositoryLocation reposLoc : _repositoryLocations) {
      boolean _checkIfUnitsLoaded = this.checkIfUnitsLoaded(reposLoc.getName());
      boolean _equals = (_checkIfUnitsLoaded == false);
      if (_equals) {
        final Job job = new Job("Loading units") {
          @Override
          protected IStatus run(final IProgressMonitor monitor) {
            try {
              final QueryManager queryManager = new QueryManager();
              final ArrayList<Unit> units = queryManager.getUnits(reposLoc);
              UnitManager.this.mapOfUnits.put(reposLoc.getName(), units);
              return Status.OK_STATUS;
            } catch (final Throwable _t) {
              if (_t instanceof CoreException || _t instanceof IOException) {
                final Exception e = (Exception)_t;
                String _pluginId = Activator.getPluginId();
                final Status status = new Status(Status.ERROR, _pluginId, 
                  "Loading units failed", e);
                StatusManager.getManager().handle(status, StatusManager.SHOW);
                return Status.CANCEL_STATUS;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
        };
        job.schedule();
      }
    }
  }
}
