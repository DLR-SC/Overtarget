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
	 * This method looks for all repositoryLocations without a referenced target
	 */
	def getReferencedModelToGenerate(TargetModel model) {
		val referencedModel = EcoreUtil.copy(model)
		val list = newArrayList
		for (RepositoryLocation repos : referencedModel.repositoryLocations) {
			if (repos.referencedTarget == false) {
				list.addAll(repos)
			}
		}
		deleteRepositoryLocation(list)
		renameTarget(referencedModel)
		return referencedModel
		}
	

	def deleteRepositoryLocation(ArrayList<RepositoryLocation> list) {
		for (RepositoryLocation reposLoc : list) {
			EcoreUtil.delete(reposLoc)
		}
		return list
	}

	def renameTarget(TargetModel model) {
		val renamedTarget = "referencedTarget"
		model.name = renamedTarget
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

	def findTargetfileOfTmodel(TargetModel model, String outputDirectory,URI uri) {
		val targetName = "/" + model.name + ".target"
		val workspace = ResourcesPlugin.workspace.root
		val tmodelFile = workspace.getFile(new Path(uri.toPlatformString(true)))
		val project = tmodelFile.project
		val outputPath = outputDirectory.toString.replaceFirst(".","")
		if (outputPath.equals("/")) {
			val targetFile = project.getFile(targetName)
			if (targetFile.exists){
				return targetFile
			}
		} else {
			val targetPath = outputPath + targetName
			val targetFile = project.getFile(targetPath)
			if (targetFile.exists){
				return targetFile
			}
		}
	}

	def setFileAsTargetPlatform(IFile targetFile) {
		TargetPlatformHelper.setAsTargetPlatform(targetFile)
	}
}