/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.util;

import de.dlr.sc.overtarget.language.Activator;
import de.dlr.sc.overtarget.language.generator.GeneratorHelper;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelFactory;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import java.net.URI;
import java.util.ArrayList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * This class queries a p2 Repository for the available installable units
 */
@SuppressWarnings("all")
public class QueryManager {
  public RepositoryLocation getReposLocOfUnit(final EObject model) {
    if ((model instanceof Unit)) {
      final Unit unit = ((Unit) model);
      EObject _eContainer = unit.eContainer();
      final RepositoryLocation location = ((RepositoryLocation) _eContainer);
      return location;
    } else {
      if ((model instanceof RepositoryLocation)) {
        final RepositoryLocation location_1 = ((RepositoryLocation)model);
        return location_1;
      }
    }
    return null;
  }
  
  public ArrayList<Unit> getUnits(final EObject model) {
    ArrayList<Unit> _xblockexpression = null;
    {
      final RepositoryLocation location = this.getReposLocOfUnit(model);
      EObject _eContainer = location.eContainer();
      final TargetFile target = ((TargetFile) _eContainer);
      _xblockexpression = this.loadUnits(target, location);
    }
    return _xblockexpression;
  }
  
  public ArrayList<Unit> loadUnits(final TargetFile target, final RepositoryLocation reposLoc) {
    try {
      final BundleContext bundleContext = Activator.getDefault().getBundle().getBundleContext();
      final ServiceReference<?> providerRef = bundleContext.getServiceReference(IProvisioningAgentProvider.SERVICE_NAME);
      Object _service = bundleContext.getService(providerRef);
      final IProvisioningAgentProvider provider = ((IProvisioningAgentProvider) _service);
      final IProvisioningAgent provisioningAgent = provider.createAgent(null);
      Object _service_1 = provisioningAgent.getService(
        IMetadataRepositoryManager.SERVICE_NAME);
      final IMetadataRepositoryManager metadataRepositoryManager = ((IMetadataRepositoryManager) _service_1);
      try {
        String _urlAsString = GeneratorHelper.getUrlAsString(reposLoc.getUrl(), target);
        final URI uri = new URI(_urlAsString);
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        final IMetadataRepository metadataRepository = metadataRepositoryManager.loadRepository(uri, _nullProgressMonitor);
        IQuery<IInstallableUnit> _createIUGroupQuery = QueryUtil.createIUGroupQuery();
        NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
        final IQueryResult<IInstallableUnit> results = metadataRepository.query(_createIUGroupQuery, _nullProgressMonitor_1);
        bundleContext.ungetService(providerRef);
        ArrayList<Unit> resultsAsUnits = new ArrayList<Unit>();
        for (final IInstallableUnit result : results) {
          {
            Unit unitFromResult = TargetmodelFactory.eINSTANCE.createUnit();
            unitFromResult.setSource(result.getId());
            unitFromResult.setVers(result.getVersion().toString());
            resultsAsUnits.add(unitFromResult);
          }
        }
        return resultsAsUnits;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final ArrayList<Unit> emptyList = new ArrayList<Unit>();
          return emptyList;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
