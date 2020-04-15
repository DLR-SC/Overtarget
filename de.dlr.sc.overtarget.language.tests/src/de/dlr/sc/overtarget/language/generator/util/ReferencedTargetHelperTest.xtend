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
		val expectedRenamedTmodel = ReferencedTargetHelper.TARGET_NAME
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
	def void testFindTargetfileOfTmodel() {
		val outputDirectory = "./target"
		val workspace = ResourcesPlugin.getWorkspace();
		val root = workspace.getRoot();
		val project  = root.getProject("testProject");
		val folder = project.getFolder("target");
		val tmodelFile = folder.getFile("target.tmodel");
		project.create(null);
		if (!project.isOpen()) { 
			project.open(null)
		}
		folder.create(IResource.NONE, true, null);

		val bytes = "
			Target target {
				
			}".getBytes();
		val source = new ByteArrayInputStream(bytes);
		tmodelFile.create(source, IResource.NONE, null);
		
		val uri = URI.createPlatformResourceURI("/testProject/target/target.tmodel", true)
		val testTmodelResource = rs.getResource(uri, true)
		val tmodel = testTmodelResource.contents.get(0) as TargetModel
		val targetFile = folder.getFile("target.target");

		val bytesTarget = 
			''''''.toString.getBytes();
		val sourceTarget = new ByteArrayInputStream(bytesTarget)
		targetFile.create(sourceTarget, false, null)

		Assert.assertEquals(targetFile, refTargetHelper.findTargetfileOfTmodel(tmodel, outputDirectory, uri))

		val project2 = root.getProject("testProject2");
		val folder2 = project2.getFolder("target");
		val tmodelFile2 = folder2.getFile("target2.tmodel");
		project2.create(null);
		if (!project2.isOpen()) { 
			project2.open(null)
		}
		folder2.create(IResource.NONE, true, null);
		val bytes2 = "
			Target target2 {
				
			}".getBytes();
		val sourceTarget2 = new ByteArrayInputStream(bytes2);
		tmodelFile2.create(sourceTarget2, IResource.NONE, null);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel", resourceFactory);
		val testTmodelResource2 = rs.getResource(URI.createPlatformResourceURI("/testProject2/target/target2.tmodel", true), true)
		val tmodel2 = testTmodelResource2.contents.get(0) as TargetModel
		
		Assert.assertNull(refTargetHelper.findTargetfileOfTmodel(tmodel2, outputDirectory, uri))
	}
}