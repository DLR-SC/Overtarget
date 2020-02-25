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
import de.dlr.sc.overtarget.language.validation.ValidatorHelper

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class OvertargetValidator extends AbstractOvertargetValidator {
	@Check
	def checkFileNameAndTargetNamel(TargetFile target) {
		var helper = new ValidatorHelper();
		val fileName = helper.getFileName(target);
		if (!fileName.equals(target.name)) {
			warning('File name and model name are not the same!', target, target.eContainingFeature)
		}
	}
	
	@Check
	def checkIfWorkingSysUsed(TargetModel target) {
		var workingSys = target.getWs();
		if (workingSys !== null) {
			warning('Please use WindowingSys instead of WorkingSys!', target, TargetmodelPackage.eINSTANCE.targetModel_Ws)
		}
	}
}