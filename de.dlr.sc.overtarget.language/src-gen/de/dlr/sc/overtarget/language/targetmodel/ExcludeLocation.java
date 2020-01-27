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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exclude Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation#getRepositoryLocation <em>Repository Location</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation#getUnits <em>Units</em>}</li>
 * </ul>
 *
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getExcludeLocation()
 * @model
 * @generated
 */
public interface ExcludeLocation extends EObject
{
  /**
   * Returns the value of the '<em><b>Repository Location</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repository Location</em>' reference.
   * @see #setRepositoryLocation(RepositoryLocation)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getExcludeLocation_RepositoryLocation()
   * @model
   * @generated
   */
  RepositoryLocation getRepositoryLocation();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation#getRepositoryLocation <em>Repository Location</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Repository Location</em>' reference.
   * @see #getRepositoryLocation()
   * @generated
   */
  void setRepositoryLocation(RepositoryLocation value);

  /**
   * Returns the value of the '<em><b>Units</b></em>' containment reference list.
   * The list contents are of type {@link de.dlr.sc.overtarget.language.targetmodel.Unit}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Units</em>' containment reference list.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getExcludeLocation_Units()
   * @model containment="true"
   * @generated
   */
  EList<Unit> getUnits();

} // ExcludeLocation
