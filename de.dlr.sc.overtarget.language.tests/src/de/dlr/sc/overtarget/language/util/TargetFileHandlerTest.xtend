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

class TargetFileHandlerTest {
	
	val targetFileHandler = new TargetFileHandler
	
	@Test
	def void getTargetFileTest() {
	}
	
	@Test
	def void getTargetFileWithProject() {
		
	}
	
	@Test 
	def void testFindTargetFile() {
		val outputDirectoryWithFolder = "./target"
		val workspace = ResourcesPlugin.getWorkspace();
		val root = workspace.getRoot();
		val projectName = "testProjectWithTarget"
		val projectWithTarget = root.getProject(projectName);
		val folder = projectWithTarget.getFolder("target");
		val tmodelFile = folder.getFile("target.tmodel");
		projectWithTarget.create(null);
		if (!projectWithTarget.isOpen()) { 
			projectWithTarget.open(null)
		}
		folder.create(IResource.NONE, true, null);

		val bytes = "
			Target target {
				
			}".getBytes();
		val source = new ByteArrayInputStream(bytes);
		tmodelFile.create(source, IResource.NONE, null);
		val targetFile = folder.getFile("target.target");

		val bytesTarget = 
			''''''.toString.getBytes();
		val sourceTarget = new ByteArrayInputStream(bytesTarget)
		targetFile.create(sourceTarget, false, null)

		Assert.assertEquals(targetFile, targetFileHandler.findTargetFile(tmodelFile, outputDirectoryWithFolder, tmodelFile.name))
	}
	
	@Test
	def void testFindTargetFileNonExistendFile() {
		val outputDirectoryWithFolder = "./target"
		val workspace = ResourcesPlugin.getWorkspace();
		val root = workspace.getRoot();
		val PROJECT_NAME = "testProjectWithoutTarget"
		val projectWithoutTarget = root.getProject(PROJECT_NAME);
		val folder = projectWithoutTarget.getFolder("target");
		val tmodelFile = folder.getFile("target.tmodel");
		projectWithoutTarget.create(null);
		if (!projectWithoutTarget.isOpen()) { 
			projectWithoutTarget.open(null)
		}
		folder.create(IResource.NONE, true, null);
		val bytes = "
			Target target {
				
			}".getBytes();
		val sourceTarget = new ByteArrayInputStream(bytes);
		tmodelFile.create(sourceTarget, IResource.NONE, null);

		Assert.assertNull("File does not exist, so should be null", targetFileHandler.findTargetFile(tmodelFile, outputDirectoryWithFolder, tmodelFile.name))
	}
}