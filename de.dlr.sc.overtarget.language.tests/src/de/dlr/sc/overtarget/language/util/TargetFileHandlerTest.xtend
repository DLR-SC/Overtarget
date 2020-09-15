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

class TargetFileHandlerTest {
	
	val targetFileHandler = new TargetFileHandler
	
	@Rule 
	public TemporaryFolder tempFolder = new TemporaryFolder()
	
	@Test
	def void testGetTargetModel() {
		val root = ResourcesPlugin.getWorkspace().getRoot()
		val testProject = root.getProject("de.dlr.sc.overtarget.language.tests")
		if (testProject.exists) {
			testProject.delete(true, null)
		}
		testProject.create(null)
		if (!testProject.isOpen()) {
			testProject.open(null)
		}
		val folder = testProject.getFolder("resources")
		folder.create(IResource.NONE, true, null)
		
		val tmodelFile = folder.getFile("target.tmodel")
		val bytes = "
			Target target {
				
			}".getBytes()
		val source = new ByteArrayInputStream(bytes)
		tmodelFile.create(source, IResource.NONE, null)

		val tmodel = targetFileHandler.getTargetModel(tmodelFile, null)
		
		val tmodelPath = "/de.dlr.sc.overtarget.language.tests/resources/target.tmodel"
		val uriTmodel = URI.createPlatformPluginURI(tmodelPath, true)
		val rs = new ResourceSetImpl()
		val tmodelResource = rs.getResource(uriTmodel, true)
		
		val expectedTmodel = tmodelResource.contents.get(0) as TargetModel
		Assert.assertEquals(expectedTmodel.name, tmodel.name)
	}
	
	@Test 
	def void testFindTargetFile() {
		val outputDirectoryWithFolder = "./target"
		val root = ResourcesPlugin.getWorkspace().getRoot()
		val projectWithTarget = root.getProject("testProjectWithTarget")
		if (projectWithTarget.exists) {
			projectWithTarget.delete(true, null)
		}
		projectWithTarget.create(null)
		if (!projectWithTarget.isOpen()) { 
			projectWithTarget.open(null)
		}
		val folder = projectWithTarget.getFolder("target")
		folder.create(IResource.NONE, true, null)
		
		val tmodelFile = folder.getFile("target.tmodel")
		val bytes = "
			Target target {
				
			}".getBytes()
		val source = new ByteArrayInputStream(bytes)
		tmodelFile.create(source, IResource.NONE, null)

		val targetFile = folder.getFile("target.target")

		val bytesTarget = 
			''''''.toString.getBytes()
		val sourceTarget = new ByteArrayInputStream(bytesTarget)
		targetFile.create(sourceTarget, false, null)

		Assert.assertEquals(targetFile, targetFileHandler.findTargetFile(tmodelFile, outputDirectoryWithFolder, tmodelFile.name))
	}
	
	@Test
	def void testFindTargetFileNonExistendFile() {
		val outputDirectoryWithFolder = "./target"
		val root = ResourcesPlugin.getWorkspace().getRoot()
		val projectWithoutTarget = root.getProject("testProjectWithoutTarget")
		if (projectWithoutTarget.exists) {
			projectWithoutTarget.delete(true, null)
		}
		projectWithoutTarget.create(null)
		
		if (!projectWithoutTarget.isOpen()) { 
			projectWithoutTarget.open(null)
		}
		val folder = projectWithoutTarget.getFolder("target")
		folder.create(IResource.NONE, true, null)
		
		val tmodelFile = folder.getFile("target.tmodel")
		val bytes = "
			Target target {
				
			}".getBytes()
		val sourceTarget = new ByteArrayInputStream(bytes)
		tmodelFile.create(sourceTarget, IResource.NONE, null)
		
		Assert.assertNull("File does not exist, so should be null", targetFileHandler.findTargetFile(tmodelFile, outputDirectoryWithFolder, tmodelFile.name))
	}
}