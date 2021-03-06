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
import org.eclipse.core.resources.IFile
import de.dlr.sc.overtarget.language.generator.OvertargetGenerator
import de.dlr.sc.overtarget.language.util.TargetFileHandler

/**
 * This class processes the model data for generation
 */
class ReferencedTargetHelper {
	public static val TARGET_FOR_REFERENCES_NAME = "targetForReferences"
	
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
		val renamedTmodel = TARGET_FOR_REFERENCES_NAME
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
		if (parentTarget !== null) {
		return parentTarget.eIsProxy
		} else {
			return false
		}
	}
	
	/**
	 * In the project the targetForReferences file is searched with the outputPath.
	 * Checks if the file is located directly in the project folder or in an extra folder.
	 * 
	 * @param file targetFile with unresolved references
	 * @param outputDirectory output directory of generated targetFile
	 * @return targetForReferences 
	 */
	def findTargetForReferencesFile(IFile file, String outputDirectory) {
		val fileName = TARGET_FOR_REFERENCES_NAME + OvertargetGenerator.TARGET_FILE_EXTENSION
		val targetFileHandler = new TargetFileHandler
		return targetFileHandler.findTargetFile(file, outputDirectory, fileName)
	}
}