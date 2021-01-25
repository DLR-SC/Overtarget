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
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import de.dlr.sc.overtarget.language.targetmodel.TargetLibrary
import de.dlr.sc.overtarget.language.targetmodel.TargetFile

/**
 * This class handles getting files, such as target resources (.tmodel) or targetFiles (.target).
 */
class TargetFileHandler {
	
	/**
	 * This method gets a targetModel
	 * 
	 * @param file	target file (.target) located in a project
	 * @param rs	resourceSet which can include tmodels, can be null
	 * @return targetModel
	 */
	
	def getTmodel(IFile file, ResourceSet rs) {
		val uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		var resourceSet = rs
		if (rs === null) {
			resourceSet = new ResourceSetImpl
		}
		try {
			val resource = resourceSet.getResource(uri, true)
			val tmodel = resource.contents.get(0) as TargetFile
			if (tmodel instanceof TargetModel) {
				var targetModel = tmodel
				return targetModel
			} else if (tmodel instanceof TargetLibrary) {
				var targetLibrary = tmodel
				return targetLibrary
			}
		} catch (Exception e) {
			println("Tmodel file does not exist.")
			return null
		}
	}
	
	/**
	 * In the project the targetFile is searched within the outputPath.
	 * Checks if the targetFile is located directly in the project folder or in an extra folder.
	 * 
	 * @param file targetFile which is searched for
	 * @param outputDirectory output directory of generated targetFile
	 * @param fileName name of the tmodel/targetFile
	 * @return targetFile
	 */
	def findTargetFile(IFile file, String outputDirectory, String fileName) {
		val project = file.getProject
		val targetFileName = fileName.replace(".tmodel", OvertargetGenerator.TARGET_FILE_EXTENSION)
		val outputPath = outputDirectory.toString.replaceFirst(".","")
		if (outputPath.equals("/")) {
			val targetFile = project.getFile(targetFileName)
			if (targetFile.exists){
				return targetFile
			}
		} else {
			val targetPath = outputPath + "/" + targetFileName
			val targetFileWithFolder = project.getFile(targetPath)
			if (targetFileWithFolder.exists){
				return targetFileWithFolder
			}
		}
	}
}