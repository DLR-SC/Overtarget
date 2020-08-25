/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.targetmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Already Declared Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getAlreadyDeclaredVariable()
 * @model
 * @generated
 */
public interface AlreadyDeclaredVariable extends VariableDefinition
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(NewVariableDefinition)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getAlreadyDeclaredVariable_Ref()
   * @model
   * @generated
   */
  NewVariableDefinition getRef();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(NewVariableDefinition value);

} // AlreadyDeclaredVariable
