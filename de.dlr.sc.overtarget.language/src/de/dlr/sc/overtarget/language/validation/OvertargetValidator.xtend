/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
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
	@Check
	def checkFileNameAndTargetName(TargetFile target) {
		var helper = new ValidatorHelper();
		val fileName = helper.getFileName(target);
		if (!fileName.equals(target.name)) {
			warning('File name and model name are not the same!', target, target.eContainingFeature)
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
}