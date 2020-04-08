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
	
	val refTargetHelper = new ReferencedTargetHelper()
	
	TargetModel referencedTarget
	
	@Before
	def void setUp() {
		
		referencedTarget = '''
		Target referencedTarget extends proxy {
			
			Import proxyImport
			
			ReferencedTarget RepositoryLocation testTarget url "test\parentTarget.tmodel" {
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
		val target = refTargetHelper.getReferencedModelToGenerate(testTargetWithReference)
		
		val expectedTargetName = referencedTarget.name
		val expectedRepositoryLocation = referencedTarget.repositoryLocations.get(0).referencedTarget
				
		Assert.assertEquals(expectedRepositoryLocation, target.repositoryLocations.get(0).isReferencedTarget)
		Assert.assertEquals(expectedTargetName, target.name)
	}
	
	@Test
	def void testRenameTarget() {
		val testTarget = testTargetResource.contents.get(0) as TargetModel
		val renamedTarget = refTargetHelper.renameTarget(testTarget)
		val expectedRenamedTarget = "referencedTarget"
		
		Assert.assertEquals("The name of the renamed target is correct", expectedRenamedTarget, renamedTarget)
	}
	
	@Test
	def void testImportedModelIsProxy() {
		val testImportTarget = testTargetResource.contents.get(0) as TargetModel
		importedModelResource.contents.get(0) as TargetModel
		refTargetHelper.importedModelIsProxy(testImportTarget)
		
		Assert.assertFalse("Imported models can be resolved.", false)
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val proxyTargetResource = rs.getResource(uriProxyTarget,true)
		val proxyTarget = proxyTargetResource.contents.get(0) as TargetModel
		val modelIsProxy = refTargetHelper.importedModelIsProxy(proxyTarget)
		
		Assert.assertTrue("Imported models are proxy.", modelIsProxy)
	}
	
	@Test
	def void testParentIsProxy() {
		val testTarget = testTargetResource.contents.get(0) as TargetModel
		parentTargetResource.contents.get(0) as TargetModel
		refTargetHelper.parentIsProxy(testTarget)

		Assert.assertFalse("ParentTarget can be resolved", false)
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", resourceFactory);
		val proxyTargetResource = rs.getResource(uriProxyTarget,true)
		val proxyTarget = proxyTargetResource.contents.get(0) as TargetModel
		val parentIsProxy = refTargetHelper.parentIsProxy(proxyTarget)

		Assert.assertTrue("ParentTarget is proxy", parentIsProxy)
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
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel", resourceFactory);
		val testTargetResource = rs.getResource(URI.createPlatformResourceURI("/testProject/target/target.tmodel", true), true)
		val target = testTargetResource.contents.get(0) as TargetModel
		
		val targetFile = folder.getFile("target.target");
		val bytesTarget = 
			'''<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<?pde version="3.8"?><target name="target" sequenceNumber="1">
			<locations>
			</locations>
			<environment>
			<os></os>
			<ws>gtk</ws>
			<arch></arch>
			<nl></nl> 
			</environment>
			<targetJRE path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/"/>
			</target>'''.toString.getBytes();
		val sourceTarget = new ByteArrayInputStream(bytesTarget);
		targetFile.create(sourceTarget, false, null);
		
//		Assert.assertNotNull(refTargetHelper.findTargetfileOfTmodel(target, outputDirectory, uri))
		
		val project2  = root.getProject("testProject2");
		val folder2 = project2.getFolder("target");
		val tmodelFile2 = folder2.getFile("target.tmodel");
		project2.create(null);
		if (!project2.isOpen()) { 
			project2.open(null)
		}
		folder2.create(IResource.NONE, true, null);
		val bytes2 = "
			Target target {
				
			}".getBytes();
		val sourceTarget2 = new ByteArrayInputStream(bytes2);
		tmodelFile2.create(sourceTarget2, IResource.NONE, null);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel", resourceFactory);
		val testTargetResource2 = rs.getResource(URI.createPlatformResourceURI("/testProject2/target/target.tmodel", true), true)
		val target2 = testTargetResource2.contents.get(0) as TargetModel
		
//		Assert.assertNull(refTargetHelper.findTargetfileOfTmodel(target2, outputDirectory))
		}
}