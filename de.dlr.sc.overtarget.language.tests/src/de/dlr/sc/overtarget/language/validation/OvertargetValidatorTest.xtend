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

import com.google.inject.Inject
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage
import de.dlr.sc.overtarget.language.validation.OvertargetValidator

@RunWith(XtextRunner)
@InjectWith(OvertargetInjectorProvider)
class OvertargetValidatorTest {
	
	@Inject extension ParseHelper<TargetModel>
	@Inject extension ValidationTestHelper

	@Test
	def void testCheckFileNameAndTargetName() {
		val target = '''
			Target targetName {}
		'''
		target.parse.assertWarning(TargetmodelPackage.Literals.TARGET_MODEL, OvertargetValidator.FILE_NAME_LIKE_TARGET_NAME, 'File name and model name are not the same!')
	}

	@Test
	def void testCheckIfWorkingSysUsed() {

		val workingSystemUsed = '''
			Target __synthetic0 {
				WorkingSystem cocoa
			}
		'''
		
		workingSystemUsed.parse.assertWarning(
		TargetmodelPackage.Literals.TARGET_MODEL, OvertargetValidator.DEPRECATED_WS_STATEMENT, 'Please use WindowingSystem instead of WorkingSystem!'
		)
	}
}