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

import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
import org.eclipse.emf.ecore.util.EcoreUtil
import java.util.ArrayList
import org.eclipse.core.resources.ResourcesPlugin
import de.dlr.sc.overtarget.language.util.TargetPlatformHelper
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI

/**
 * This class processes the model data for generation
 */
class ReferencedTargetHelper {
	
	/**
	 * This method copies the original tmodel and
	 * looks for all repositoryLocations without a referenced target
	 * 
	 * @param model original tmodel with unresolved references
	 * @return tmodelWithReference tmodel with repositoryLocations containing the keyword referencedTarget
	 */
	def getReferencedModelToGenerate(TargetModel model) {
		val tmodelWithReference = EcoreUtil.copy(model)
		val list = newArrayList
		for (RepositoryLocation repos : tmodelWithReference.repositoryLocations) {
			if (repos.referencedTarget == false) {
				list.addAll(repos)
			}
		}
		deleteRepositoryLocation(list)
		renameTmodel(tmodelWithReference)
		return tmodelWithReference
		}
	

	def deleteRepositoryLocation(ArrayList<RepositoryLocation> list) {
		for (RepositoryLocation reposLoc : list) {
			EcoreUtil.delete(reposLoc)
		}
		return list
	}

	def renameTmodel(TargetModel model) {
		val renamedTmodel = "referencedTarget"
		model.name = renamedTmodel
		return model.name
		}

	def hasUnresolvedReferences(TargetModel model) {
		importedModelIsProxy(model) == true || parentIsProxy(model) == true
	}

	def importedModelIsProxy(TargetModel model) {
		for (TargetFile file : model.importedModels) {
			if (file.eIsProxy == true) {
				return file.eIsProxy
			}
		}
		return false
	}
	
	def parentIsProxy(TargetModel model) {
		val parentTarget = model.super
		return parentTarget.eIsProxy
	}

	/**
	 * Locates the tmodelFile and finds the project. 
	 * In the project the targetFile is searched with the outputPath.
	 * Checks if the targetFile is located directly in the project folder or in an extra folder.
	 * 
	 * @param model tmodel with references
	 * @param outputDirectory output directory of generated targetFile
	 * @param uri uri of original tmodel
	 * @return targetFile
	 */
	def findTargetfileOfTmodel(TargetModel model, String outputDirectory, URI uri) {
		val tmodelName = "/" + model.name + ".target"
		val workspace = ResourcesPlugin.workspace.root
		val tmodelFile = workspace.getFile(new Path(uri.toPlatformString(true)))
		val project = tmodelFile.project
		val outputPath = outputDirectory.toString.replaceFirst(".","")
		if (outputPath.equals("/")) {
			val targetFile = project.getFile(tmodelName)
			if (targetFile.exists){
				return targetFile
			}
		} else {
			val targetPath = outputPath + tmodelName
			val targetFileWithFolder = project.getFile(targetPath)
			if (targetFileWithFolder.exists){
				return targetFileWithFolder
			}
		}
	}

	def setFileAsActiveTarget(IFile targetFile) {
		val targetPlatHelper = new TargetPlatformHelper()
		targetPlatHelper.setAsActiveTarget(targetFile)
	}
}