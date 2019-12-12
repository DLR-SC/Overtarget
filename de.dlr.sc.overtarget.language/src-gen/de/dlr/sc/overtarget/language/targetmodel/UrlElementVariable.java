/**
 * ******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *  *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *  *
 * SPDX-License-Identifier: EPL-2.0
 *  ******************************************************************************
 */
package de.dlr.sc.overtarget.language.targetmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Url Element Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getUrlElementVariable()
 * @model
 * @generated
 */
public interface UrlElementVariable extends UrlElement
{
  /**
   * Returns the value of the '<em><b>Content</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' reference.
   * @see #setContent(VariableDefinition)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getUrlElementVariable_Content()
   * @model
   * @generated
   */
  VariableDefinition getContent();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable#getContent <em>Content</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' reference.
   * @see #getContent()
   * @generated
   */
  void setContent(VariableDefinition value);

} // UrlElementVariable
