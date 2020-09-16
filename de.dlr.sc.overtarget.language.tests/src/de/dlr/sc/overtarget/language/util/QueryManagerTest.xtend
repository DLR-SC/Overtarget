/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.util

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider
import org.junit.Test
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import de.dlr.sc.overtarget.language.targetmodel.Unit
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
import org.junit.Assert

@RunWith(XtextRunner)
@InjectWith(OvertargetInjectorProvider)
class QueryManagerTest {
	
	val queryManager = new QueryManager
	
 	static final String TEST_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/tmodelWithUnits.tmodel"
	
	val rs = new ResourceSetImpl()
	val uriTmodelWithUnits = URI.createPlatformPluginURI(TEST_TMODEL_PATH, true)
	val tmodelWithUnitsResource = rs.getResource(uriTmodelWithUnits,true)
	val expectedTmodelWithUnits = tmodelWithUnitsResource.contents.get(0) as TargetFile
	val expectedReposLoc = expectedTmodelWithUnits.repositoryLocations.get(0) as RepositoryLocation
	
	@Test
	def void getReposLocOfUnitTest() {
		
		val expectedUnit = expectedReposLoc.units.get(0) as Unit
		
		val locationWithUnit = queryManager.getReposLocOfUnit(expectedUnit)
		val locationWithReposLoc = queryManager.getReposLocOfUnit(expectedReposLoc)
		
		Assert.assertEquals(expectedReposLoc, locationWithUnit)
		Assert.assertEquals(expectedReposLoc, locationWithReposLoc)
	}
	
//	@Test
//	def void loadUnitsTest() {
//		val units = queryManager.loadUnits(expectedTmodelWithUnits, expectedReposLoc)
//		Assert.assertNotNull("Units are loaded", units)
//	}
}