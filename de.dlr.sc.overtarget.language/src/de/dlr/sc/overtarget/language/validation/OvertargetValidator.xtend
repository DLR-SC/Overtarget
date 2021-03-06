/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.validation

import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import javax.inject.Inject
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class OvertargetValidator extends AbstractOvertargetValidator {
	
	public static val FILE_NAME_LIKE_TARGET_NAME = "fileNameLikeTargetName"
	
	@Check
	def checkFileNameAndTargetName(TargetFile target) {
		var helper = new ValidatorHelper();
		val fileName = helper.getFileName(target);
		if (!fileName.equals(target.name)) {
			warning('File name and tmodel name are not the same!', target, target.eContainingFeature, FILE_NAME_LIKE_TARGET_NAME)
		}
	}
	
	@Inject
	OvertargetGrammarAccess grammarAccess 
	
	public static val DEPRECATED_WS_STATEMENT = "deprecatedWS"
	
	@Check
	def checkIfWorkingSysUsed(TargetModel target) {
		val node = NodeModelUtils.getNode(target);
		val nodeText = node.getText().toString();
		
		val deprecatedWorkingSystemKeyword = grammarAccess.targetModelAccess.workingSystemKeyword_6_0_1.value
		val windowingSystemKeyword = grammarAccess.targetModelAccess.windowingSystemKeyword_6_0_0.value
		
		if (nodeText.contains(deprecatedWorkingSystemKeyword)) {
			warning('Please use ' + windowingSystemKeyword + ' instead of ' + deprecatedWorkingSystemKeyword + '!', target, TargetmodelPackage.eINSTANCE.targetModel_Ws, DEPRECATED_WS_STATEMENT)
		}
	}
	
	public static val TMODEL_EXTENDS_OWN_TMODEL = "tmodelExtendsOwnTmodel"
	
	@Check
	def checkIfTmodelExtendsOwnTmodel(TargetModel target) {
		var tmodelName = target.name;
		var extendModel = target.super
		var extendName = extendModel.name
		if (tmodelName.equals(extendName)) {
			error('A tmodel cannot extend its own tmodel.', target, TargetmodelPackage.eINSTANCE.targetModel_Super, TMODEL_EXTENDS_OWN_TMODEL)
		}
	}
}