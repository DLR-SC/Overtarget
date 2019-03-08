/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.util

import de.dlr.sc.overtarget.language.generator.GeneratorHelper
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelFactory
import de.dlr.sc.overtarget.language.targetmodel.Unit
import java.net.URI
import java.util.ArrayList
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.EObject
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider
import org.eclipse.equinox.p2.query.QueryUtil
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager
import de.dlr.sc.overtarget.language.Activator

/**
 * This class queries a p2 Repository for the available installable units
 */
public class QueryManager {
	def getUnits(EObject model) {
		val bundleContext = Activator.^default.bundle.bundleContext;
		val providerRef = bundleContext.getServiceReference(IProvisioningAgentProvider.SERVICE_NAME);
		val provider = bundleContext.getService(providerRef) as IProvisioningAgentProvider;
		val provisioningAgent = provider.createAgent(null);
		val metadataRepositoryManager = provisioningAgent.getService(
			IMetadataRepositoryManager.SERVICE_NAME) as IMetadataRepositoryManager;
		val unit = model as Unit;
		val location = unit.eContainer as RepositoryLocation;
		val target = location.eContainer as TargetModel;
		val uri = new URI(GeneratorHelper.getUrlAsString(location.url, target));
		val metadataRepository = metadataRepositoryManager.loadRepository(uri, new NullProgressMonitor());
		val results = metadataRepository.query(QueryUtil.createIUGroupQuery, new NullProgressMonitor());
		bundleContext.ungetService(providerRef);
		
		var resultsAsUnits = new ArrayList<Unit>;
		for(result:results ){
			var unitFromResult = TargetmodelFactory.eINSTANCE.createUnit;
			unitFromResult.source = result.id;
			unitFromResult.vers = result.version.toString;
			resultsAsUnits.add(unitFromResult);
		}
		return resultsAsUnits;
	}
}
