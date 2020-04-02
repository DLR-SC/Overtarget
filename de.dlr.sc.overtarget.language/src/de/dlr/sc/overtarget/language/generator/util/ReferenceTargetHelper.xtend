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

/**
 * This class processes the model data for generation
 */
class ReferenceTargetHelper {

	def static getModelToGenerate(TargetModel model) {
		for (RepositoryLocation repos : model.repositoryLocations) {
			if (repos.referenceTarget == true) {
				val list = newArrayList
				for (RepositoryLocation repos2 : model.repositoryLocations) {
					if (repos2.referenceTarget == false) {
						list.addAll(repos2)
					}
				}
				deleteRepositoryLocation(list)
			}
			renameTarget(model)
			return model
		}
	}

	def static deleteRepositoryLocation(ArrayList<RepositoryLocation> list) {
		for (RepositoryLocation reposLoc : list) {
			EcoreUtil.delete(reposLoc)
		}
		return list
	}

	def static renameTarget(TargetModel model) {
		val renamedTarget = "referenceTarget"
		model.name = renamedTarget
		return model.name
		}

	def static importedModelIsProxy(TargetModel model) {
		val list = newArrayList
		for (TargetFile files : model.importedModels) {
			for (TargetFile file : model.importedModels) {
				if (file.eIsProxy == true) {
					list.addAll(file)
				}
			}
		}
		if (list.empty) {
			return false
		} else {
			return true
		}
	}
	
	def static parentIsProxy(TargetModel model) {
		val parentTarget = model.super
		if (parentTarget.eIsProxy) {
			return true
		} else {
			return false
		}
	}

	def static findTargetfileOfTmodel(TargetModel model, String outputDirectory) {
		val targetName = "/" + model.name + ".target"
		val uri = EcoreUtil.getURI(model)
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

	def static setFileAsTargetPlatform(IFile targetFile) {
		TargetPlatformHelper.setAsTargetPlatform(targetFile)
	}
}