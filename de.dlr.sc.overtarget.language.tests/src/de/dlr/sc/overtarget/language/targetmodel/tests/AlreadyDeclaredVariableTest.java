/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.targetmodel.tests;

import de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Already Declared Variable</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlreadyDeclaredVariableTest extends VariableDefinitionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AlreadyDeclaredVariableTest.class);
	}

	/**
	 * Constructs a new Already Declared Variable test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlreadyDeclaredVariableTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Already Declared Variable test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AlreadyDeclaredVariable getFixture() {
		return (AlreadyDeclaredVariable)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TargetmodelFactory.eINSTANCE.createAlreadyDeclaredVariable());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //AlreadyDeclaredVariableTest
