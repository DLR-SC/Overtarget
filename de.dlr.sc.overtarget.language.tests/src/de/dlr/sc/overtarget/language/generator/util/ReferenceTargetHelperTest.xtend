/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.generator.util

import org.junit.Test
import org.junit.Assert
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import org.junit.Before
import com.google.inject.Inject
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.testing.util.ParseHelper

@RunWith(XtextRunner)
@InjectWith(OvertargetInjectorProvider)

class ReferenceTargetHelperTest {
	

	static final String TEST_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/testTarget.tmodel"
	static final String PARENT_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/parentTarget.tmodel"
	static final String PROXY_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/proxyTarget.tmodel_inv"
	static final String IMPORT_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/importedModel.tmodel"
	
	@Inject
	IResourceFactory resourceFactory
	
	val rs = new ResourceSetImpl()
	val uriTestTarget = URI.createPlatformPluginURI(TEST_TARGET_PATH, true)
	val testTargetResource = rs.getResource(uriTestTarget,true)
	
	val uriParentTarget = URI.createPlatformPluginURI(PARENT_TARGET_PATH, true)
	val parentTargetResource = rs.getResource(uriParentTarget, true)
	
	val uriProxyTarget = URI.createPlatformPluginURI(PROXY_TARGET_PATH, true)
	
	val uriImportedModel = URI.createPlatformPluginURI(IMPORT_TARGET_PATH, true)
	val importedModelResource = rs.getResource(uriImportedModel, true)
	
	@Inject extension ParseHelper<TargetModel>
	
	
	TargetModel referenceTarget
	
	@Before
	def void setUp() {
		
		referenceTarget = '''
		Target referenceTarget extends proxy {
			
			Import proxyImport
			
			ReferenceTarget RepositoryLocation testTarget url "test\parentTarget.tmodel" {
				Unit parentTargetUnit version newest;
			}
				
			
		}
		'''.parse
	}
	
	@Test
	def void testGetModelToGenerate() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val testTargetWithReferenceResource = rs.getResource(uriProxyTarget,true)
		val testTargetWithReference = testTargetWithReferenceResource.contents.get(0) as TargetModel
		ReferenceTargetHelper.getModelToGenerate(testTargetWithReference)
		
		val expectedTargetName = referenceTarget.name
		val expectedRepositoryLocation = referenceTarget.repositoryLocations.get(0).referenceTarget
				
		Assert.assertEquals(expectedRepositoryLocation, testTargetWithReference.repositoryLocations.get(0).isReferenceTarget)
		Assert.assertEquals(expectedTargetName, testTargetWithReference.name)
	}
	
	@Test
	def void testRenameTarget() {
		val testTarget = testTargetResource.contents.get(0) as TargetModel
		val renamedTarget = ReferenceTargetHelper.renameTarget(testTarget)
		val expectedRenamedTarget = "referenceTarget"
		
		Assert.assertEquals("The name of the renamed target is correct", expectedRenamedTarget, renamedTarget)
	}
	
	@Test
	def void testImportedModelIsProxy() {
		val testImportTarget = testTargetResource.contents.get(0) as TargetModel
		importedModelResource.contents.get(0) as TargetModel
		ReferenceTargetHelper.importedModelIsProxy(testImportTarget)
		
		Assert.assertFalse("Imported models can be resolved.", false)
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val proxyTargetResource = rs.getResource(uriProxyTarget,true)
		val proxyTarget = proxyTargetResource.contents.get(0) as TargetModel
		ReferenceTargetHelper.importedModelIsProxy(proxyTarget)
		
		Assert.assertTrue("Imported models are proxy.", true)
	}
	
	@Test
	def void testParentIsProxy() {
		val testTarget = testTargetResource.contents.get(0) as TargetModel
		parentTargetResource.contents.get(0) as TargetModel
		ReferenceTargetHelper.parentIsProxy(testTarget)

		Assert.assertFalse("ParentTarget can be resolved", false)
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val proxyTargetResource = rs.getResource(uriProxyTarget,true)
		val proxyTarget = proxyTargetResource.contents.get(0) as TargetModel
		ReferenceTargetHelper.parentIsProxy(proxyTarget)

		Assert.assertTrue("ParentTarget is proxy", true)
	}
	
	@Test
	def void testSetFileAsTargetPlatform() {
		
	}
}