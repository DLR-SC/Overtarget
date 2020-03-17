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

import org.junit.Test
import org.junit.Assert
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import org.junit.Before
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider

@RunWith(XtextRunner)
@InjectWith(OvertargetInjectorProvider)

class ReferenceTargetHelperTest {
	
	@Inject extension ParseHelper<TargetModel>

	TargetModel testTarget
	val targetName = "testTarget"
	
	
	@Before
	def void setUp() {
		TargetmodelPackage.eINSTANCE.eClass
		
		testTarget = '''
			Target «targetName» {}
		'''.parse
	}
	
	@Test
	def void testGetModelToGenerate() {
		
	}
	
	@Test
	def void testDeleteRepositoryLocation() {
		
	}
	
	@Test
	def void testRenameTarget() {
		val renamedTarget = ReferenceTargetHelper.renameTarget(testTarget)
		val expectedRenamedTarget = "referenceTarget"
		
		Assert.assertEquals("The name of the renamed target is correct", expectedRenamedTarget, renamedTarget)
		
	}
	
	@Test
	def void testImportedModelIsProxy() {
		
	}
	
	@Test
	def void testParentIsProxy() {
		
	}
	
	@Test
	def void testGetTargetFile() {
		
	}
}