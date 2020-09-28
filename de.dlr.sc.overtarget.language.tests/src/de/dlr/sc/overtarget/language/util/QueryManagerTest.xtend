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
import org.eclipse.emf.ecore.resource.Resource
import com.google.inject.Inject
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.equinox.p2.metadata.IInstallableUnit
import org.eclipse.equinox.internal.p2.metadata.InstallableUnit
import org.eclipse.equinox.internal.p2.metadata.OSGiVersion

@RunWith(XtextRunner)
@InjectWith(OvertargetInjectorProvider)
class QueryManagerTest {

	@Inject
	IResourceFactory resourceFactory

	var testQueryManager = new TestQueryManager

	static final String TEST_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/testModelWithAddAllUnits.tmodel_inv"
	static final String UNIT_ID = "www.testLink.de"

	val rs = new ResourceSetImpl()
	val uriTmodelWithUnits = URI.createPlatformPluginURI(TEST_TMODEL_PATH, true)

	@Test
	def void getReposLocOfUnitTest() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val tmodelWithUnitsResource = rs.getResource(uriTmodelWithUnits, true)
		val expectedTmodelWithUnits = tmodelWithUnitsResource.contents.get(0) as TargetFile
		val expectedReposLoc = expectedTmodelWithUnits.repositoryLocations.get(1) as RepositoryLocation
		val expectedUnit = expectedReposLoc.units.get(0) as Unit

		val locationWithUnit = testQueryManager.getReposLocOfUnit(expectedUnit)
		val locationWithReposLoc = testQueryManager.getReposLocOfUnit(expectedReposLoc)

		Assert.assertEquals(expectedReposLoc, locationWithUnit)
		Assert.assertEquals(expectedReposLoc, locationWithReposLoc)
	}

	@Test
	def void loadUnitsTest() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val tmodelWithUnitsResource = rs.getResource(uriTmodelWithUnits, true)
		val testTmodelWithUnits = tmodelWithUnitsResource.contents.get(0) as TargetFile
		val testReposLoc = testTmodelWithUnits.repositoryLocations.get(2) as RepositoryLocation

		// create installableUnit with ID and version and add it to the dummyList
		val dummyUnit = new InstallableUnit
		dummyUnit.id = UNIT_ID
		dummyUnit.version = new OSGiVersion(0, 0, 0, "1234")
		val dummyList = new MockupQueryResult<IInstallableUnit>
		dummyList.add(dummyUnit)

		// set dummyList as a mockup for loading units from a repository
		testQueryManager.setUnits(dummyList)

		val unitList = testQueryManager.getUnitsInList(testTmodelWithUnits, testReposLoc)
		val unitListID = unitList.get(0).source

		Assert.assertEquals(UNIT_ID, unitListID)
	}
}