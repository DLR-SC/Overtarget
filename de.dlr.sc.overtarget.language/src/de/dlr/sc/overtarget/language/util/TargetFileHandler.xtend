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

import org.eclipse.core.resources.IFile
import de.dlr.sc.overtarget.language.generator.OvertargetGenerator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import org.eclipse.core.resources.IProject

class TargetFileHandler {
	
	def getTargetFile(IFile file, ResourceSet rs) {
		val uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		if (rs === null) {
			val set = new ResourceSetImpl
			val r = set.getResource(uri, true)
			val targetFile = r.contents.get(0) as TargetFile
			return targetFile
		} else {
			val r = rs.getResource(uri, true)
			val targetFile = r.contents.get(0) as TargetFile
			return targetFile
		}
	}
	
	def getTargetFile(IFile file, String outputConfig, IProject project) {
		val targetName = file.getName().replace(".tmodel", OvertargetGenerator.TARGET_FILE_EXTENSION) 
		val outputPath = outputConfig.replace(".", "") 
		if (outputPath.equals("/")) {
			val targetFile = project.getFile("/" + targetName);
			return targetFile
		} else {
			val targetPath = outputPath + "/" + targetName;
			val targetFile = project.getFile(targetPath); 
			return targetFile
		}
	}
	
	/**
	 * In the project the targetFile is searched with the outputPath.
	 * Checks if the targetFile is located directly in the project folder or in an extra folder.
	 * 
	 * @param file targetFile which is searched for
	 * @param outputDirectory output directory of generated targetFile
	 * @param fileName name of the tmodel/targetFile
	 * @return targetFile
	 */
	def findTargetFile(IFile file, String outputDirectory, String fileName) {
		if (fileName !== null) {
			fileName.replace("", "/" + file.name)
		}
		val project = file.getProject
		val targetFileName = fileName.replace(".tmodel", OvertargetGenerator.TARGET_FILE_EXTENSION)
		val outputPath = outputDirectory.toString.replaceFirst(".","")
		if (outputPath.equals("/")) {
			val targetFile = project.getFile(targetFileName)
			if (targetFile.exists){
				return targetFile
			}
		} else {
			val targetPath = outputPath + targetFileName
			val targetFileWithFolder = project.getFile(targetPath)
			if (targetFileWithFolder.exists){
				return targetFileWithFolder
			}
		}
	}
}