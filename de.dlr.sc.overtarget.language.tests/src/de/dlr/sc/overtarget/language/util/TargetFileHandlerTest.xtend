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

import org.junit.Test
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IResource
import java.io.ByteArrayInputStream
import org.junit.Assert
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith
import de.dlr.sc.overtarget.language.targetmodel.TargetLibrary

@RunWith(XtextRunner)
@InjectWith(OvertargetInjectorProvider)
class TargetFileHandlerTest {
	
	val targetFileHandler = new TargetFileHandler

	static final String PROJECT_NAME = "de.dlr.sc.overtarget.language.tests"
	static final String TMODEL_PATH = "de.dlr.sc.overtarget.language.tests/resources/test.tmodel"
	static final String TMODEL_LIBRARY_PATH = "de.dlr.sc.overtarget.language.tests/resources/testLibrary.tmodel"
	static final String TMODEL_NAME = "test.tmodel"
	static final String TARGET_NAME = "test.target"
	
	@Rule 
	public TemporaryFolder tempFolder = new TemporaryFolder()
	
	def cleanCreateProject() {
		val root = ResourcesPlugin.getWorkspace().getRoot()
		val testProject = root.getProject(PROJECT_NAME)
		if (testProject.exists) {
			testProject.delete(true, null)
		}
		testProject.create(null)
		if (!testProject.isOpen()) {
			testProject.open(null)
		}
		return testProject
	}
	
	@Test
	def void testGetTmodel() {
		var testProject = cleanCreateProject
		val folder = testProject.getFolder("resources")
		folder.create(IResource.NONE, true, null)
		
		val tmodelFile = folder.getFile(TMODEL_NAME)
		val bytes = "
			Target test {
				
			}".getBytes()
		val source = new ByteArrayInputStream(bytes)
		tmodelFile.create(source, IResource.NONE, null)

		val tmodel = targetFileHandler.getTmodel(tmodelFile, null)
		val uriTmodel = URI.createPlatformPluginURI(TMODEL_PATH, true)
		val rs = new ResourceSetImpl()
		val tmodelResource = rs.getResource(uriTmodel, true)
		
		val expectedTmodel = tmodelResource.contents.get(0) as TargetModel
		Assert.assertEquals(expectedTmodel.name, tmodel.name)
	}
	
	@Test
	def void testGetTmodelIsLibrary() {
		var testProject = cleanCreateProject
		val folder = testProject.getFolder("resources")
		folder.create(IResource.NONE, true, null)
		
		val tmodelFile = folder.getFile(TMODEL_NAME)
		val bytes = "
			Target testLibrary {
				
			}".getBytes()
		val source = new ByteArrayInputStream(bytes)
		tmodelFile.create(source, IResource.NONE, null)

		val tmodel = targetFileHandler.getTmodel(tmodelFile, null)
		val uriTmodel = URI.createPlatformPluginURI(TMODEL_LIBRARY_PATH, true)
		val rs = new ResourceSetImpl()
		val tmodelResource = rs.getResource(uriTmodel, true)
		
		val expectedTmodel = tmodelResource.contents.get(0) as TargetLibrary
		Assert.assertEquals(expectedTmodel.name, tmodel.name)
	}
	
	@Test
	def void testGetmodelNonExistent() {
		var testProject = cleanCreateProject
		val folder = testProject.getFolder("resources")
		folder.create(IResource.NONE, true, null)
		
		val tmodelFile = folder.getFile(TMODEL_NAME)

		Assert.assertNull("Tmodel does not exist, so should be null", targetFileHandler.getTmodel(tmodelFile, null))
	}
	
	@Test 
	def void testFindTargetFile() {
		val outputDirectoryWithFolder = "./target"
		var projectWithTarget = cleanCreateProject
		val folder = projectWithTarget.getFolder("target")
		folder.create(IResource.NONE, true, null)
		
		val tmodelFile = folder.getFile(TMODEL_NAME)
		val bytes = "
			Target test {
				
			}".getBytes()
		val source = new ByteArrayInputStream(bytes)
		tmodelFile.create(source, IResource.NONE, null)
		val targetFile = folder.getFile(TARGET_NAME)

		val bytesTarget = 
			''''''.toString.getBytes()
		val sourceTarget = new ByteArrayInputStream(bytesTarget)
		targetFile.create(sourceTarget, false, null)

		Assert.assertEquals(targetFile, targetFileHandler.findTargetFile(tmodelFile, outputDirectoryWithFolder, tmodelFile.name))
	}
	
	@Test
	def void testFindTargetFileNonExistentFile() {
		val outputDirectoryWithFolder = "./target"
		var projectWithoutTarget = cleanCreateProject
		val folder = projectWithoutTarget.getFolder("target")
		folder.create(IResource.NONE, true, null)
		
		val tmodelFile = folder.getFile(TMODEL_NAME)
		val bytes = "
			Target test {
				
			}".getBytes()
		val sourceTarget = new ByteArrayInputStream(bytes)
		tmodelFile.create(sourceTarget, IResource.NONE, null)
		
		Assert.assertNull("File does not exist, so should be null", targetFileHandler.findTargetFile(tmodelFile, outputDirectoryWithFolder, tmodelFile.name))
	}
}