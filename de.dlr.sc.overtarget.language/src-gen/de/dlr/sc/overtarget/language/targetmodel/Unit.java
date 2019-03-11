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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.Unit#getSource <em>Source</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.Unit#getVers <em>Vers</em>}</li>
 * </ul>
 *
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getUnit()
 * @model
 * @generated
 */
public interface Unit extends EObject
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' attribute.
   * @see #setSource(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getUnit_Source()
   * @model
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.Unit#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

  /**
   * Returns the value of the '<em><b>Vers</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vers</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vers</em>' attribute.
   * @see #setVers(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getUnit_Vers()
   * @model
   * @generated
   */
  String getVers();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.Unit#getVers <em>Vers</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vers</em>' attribute.
   * @see #getVers()
   * @generated
   */
  void setVers(String value);

} // Unit
