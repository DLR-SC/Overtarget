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
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IResource
import java.io.ByteArrayInputStream

@RunWith(XtextRunner)
@InjectWith(OvertargetInjectorProvider)

class ReferencedTargetHelperTest {

	static final String TEST_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/testTarget.tmodel"
	static final String PARENT_TMODEl_PATH = "/de.dlr.sc.overtarget.language.tests/resources/parentTarget.tmodel"
	static final String IMPORTED_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/importedModel.tmodel"
	static final String PROXY_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/proxyTarget.tmodel_inv"
	
	@Inject
	IResourceFactory resourceFactory
	
	val rs = new ResourceSetImpl()
	val uriTestTmodel = URI.createPlatformPluginURI(de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelperTest.TEST_TMODEL_PATH, true)
	val testTmodelResource = rs.getResource(uriTestTmodel,true)
	
	val uriParentTmodel = URI.createPlatformPluginURI(de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelperTest.PARENT_TMODEl_PATH, true)
	val parentTmodelResource = rs.getResource(uriParentTmodel, true)
	
	val uriImportedModelTmodel = URI.createPlatformPluginURI(de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelperTest.IMPORTED_TMODEL_PATH, true)
	val importedModelTmodelResource = rs.getResource(uriImportedModelTmodel, true)
	
	val uriProxyTmodel = URI.createPlatformPluginURI(de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelperTest.PROXY_TMODEL_PATH, true)

	@Inject extension ParseHelper<TargetModel>
	
	val refTargetHelper = new ReferencedTargetHelper()
	
	TargetModel targetForReferences
	
	@Before
	def void setUp() {
		
		targetForReferences = '''
		Target targetForReferences extends proxy {
			
			Import proxyImport
			
			ReferencedTarget RepositoryLocation testTarget url "test\parentTarget.tmodel" {
				Unit parentTargetUnit version newest;
			}
		}
		'''.parse
	}

	@Test
	def void testGetReferencedModelToGenerate() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val testTmodelWithReferenceResource = rs.getResource(uriProxyTmodel,true)
		val testTmodelWithReference = testTmodelWithReferenceResource.contents.get(0) as TargetModel
		val tmodelWithReference = refTargetHelper.getReferencedModelToGenerate(testTmodelWithReference)
		
		val expectedTmodelName = targetForReferences.name
		val expectedRepositoryLocation = targetForReferences.repositoryLocations.get(0).referencedTarget
				
		Assert.assertEquals(expectedRepositoryLocation, tmodelWithReference.repositoryLocations.get(0).isReferencedTarget)
		Assert.assertEquals(expectedTmodelName, tmodelWithReference.name)
	}

	@Test
	def void testRenameTmodel() {
		val testTmodel = testTmodelResource.contents.get(0) as TargetModel
		val renamedTmodel = refTargetHelper.renameTmodel(testTmodel)
		val expectedRenamedTmodel = ReferencedTargetHelper.TARGET_FOR_REFERENCES_NAME
		Assert.assertEquals("The name of the renamed target is correct", expectedRenamedTmodel, renamedTmodel)
	}

	@Test
	def void testImportedModelIsProxy() {
		val testImportTmodel = testTmodelResource.contents.get(0) as TargetModel
		importedModelTmodelResource.contents.get(0) as TargetModel
		val tmodelIsNotProxy = refTargetHelper.importedModelIsProxy(testImportTmodel)

		Assert.assertFalse("Imported models can be resolved.", tmodelIsNotProxy)

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val proxyTmodelResource = rs.getResource(uriProxyTmodel,true)
		val proxyTmodel = proxyTmodelResource.contents.get(0) as TargetModel
		val tmodelIsProxy = refTargetHelper.importedModelIsProxy(proxyTmodel)

		Assert.assertTrue("Imported models are proxy.", tmodelIsProxy)
	}

	@Test
	def void testParentIsProxy() {
		val testTmodel = testTmodelResource.contents.get(0) as TargetModel
		parentTmodelResource.contents.get(0) as TargetModel
		val parentIsNotProxy = refTargetHelper.parentIsProxy(testTmodel)

		Assert.assertFalse("ParentTarget can be resolved", parentIsNotProxy)

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val proxyTmodelResource = rs.getResource(uriProxyTmodel,true)
		val proxyTmodel = proxyTmodelResource.contents.get(0) as TargetModel
		val parentIsProxy = refTargetHelper.parentIsProxy(proxyTmodel)

		Assert.assertTrue("ParentTarget is proxy", parentIsProxy)
		
		val tmodelWithoutParent = parentTmodelResource.contents.get(0) as TargetModel
		Assert.assertFalse("Tmodel has no parent tmodel.", refTargetHelper.parentIsProxy(tmodelWithoutParent))
	}

	@Test
	def void testFindTargetForReferencesFile() {
		val outputDirectory = "./target"
		val root = ResourcesPlugin.getWorkspace().getRoot()
		val projectWithTarget = root.getProject("testProjectWithTargetForReferences")
		if (projectWithTarget.exists) {
			projectWithTarget.delete(true, null)
		}
		projectWithTarget.create(null);
		if (!projectWithTarget.isOpen()) { 
			projectWithTarget.open(null)
		}
		val folder = projectWithTarget.getFolder("target")
		folder.create(IResource.NONE, true, null)
	
		val tmodelFile = folder.getFile("targetForReferences.tmodel")
		val bytes = "
			Target targetForReferences {
				
			}".getBytes()
		val source = new ByteArrayInputStream(bytes)
		tmodelFile.create(source, IResource.NONE, null)
		val targetFile = folder.getFile("targetForReferences.target")

		val bytesTarget = 
			''''''.toString.getBytes()
		val sourceTarget = new ByteArrayInputStream(bytesTarget)
		targetFile.create(sourceTarget, false, null)

		Assert.assertEquals(targetFile, refTargetHelper.findTargetForReferencesFile(tmodelFile, outputDirectory))
	}
	
		@Test
		def void testFindTargetForReferencesFileNonExistendFile() {
		val outputDirectory = "./target"
		val root = ResourcesPlugin.getWorkspace().getRoot()
		val projectWithoutTarget = root.getProject("testProjectWithoutTargetForReferences")
		if (projectWithoutTarget.exists) {
			projectWithoutTarget.delete(true, null)
		}
		projectWithoutTarget.create(null);
		if (!projectWithoutTarget.isOpen()) { 
			projectWithoutTarget.open(null)
		}
		val folder = projectWithoutTarget.getFolder("target")
		folder.create(IResource.NONE, true, null);
		
		val tmodelFile = folder.getFile("targetForReferences.tmodel")
		val bytes = "
			Target targetForReferences {
				
			}".getBytes()
		val sourceTarget = new ByteArrayInputStream(bytes)
		tmodelFile.create(sourceTarget, IResource.NONE, null)

		Assert.assertNull("File does not exist, so should be null", refTargetHelper.findTargetForReferencesFile(tmodelFile, outputDirectory))
	}
}