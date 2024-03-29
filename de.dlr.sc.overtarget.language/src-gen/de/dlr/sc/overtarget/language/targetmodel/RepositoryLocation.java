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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#isReferencedTarget <em>Referenced Target</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getName <em>Name</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getUrl <em>Url</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getUnits <em>Units</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#isAddAll <em>Add All</em>}</li>
 * </ul>
 *
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getRepositoryLocation()
 * @model
 * @generated
 */
public interface RepositoryLocation extends EObject
{
  /**
   * Returns the value of the '<em><b>Referenced Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Target</em>' attribute.
   * @see #setReferencedTarget(boolean)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getRepositoryLocation_ReferencedTarget()
   * @model
   * @generated
   */
  boolean isReferencedTarget();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#isReferencedTarget <em>Referenced Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Target</em>' attribute.
   * @see #isReferencedTarget()
   * @generated
   */
  void setReferencedTarget(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getRepositoryLocation_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Url</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Url</em>' containment reference.
   * @see #setUrl(UrlExpression)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getRepositoryLocation_Url()
   * @model containment="true"
   * @generated
   */
  UrlExpression getUrl();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getUrl <em>Url</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Url</em>' containment reference.
   * @see #getUrl()
   * @generated
   */
  void setUrl(UrlExpression value);

  /**
   * Returns the value of the '<em><b>Units</b></em>' containment reference list.
   * The list contents are of type {@link de.dlr.sc.overtarget.language.targetmodel.Unit}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Units</em>' containment reference list.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getRepositoryLocation_Units()
   * @model containment="true"
   * @generated
   */
  EList<Unit> getUnits();

  /**
   * Returns the value of the '<em><b>Add All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Add All</em>' attribute.
   * @see #setAddAll(boolean)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getRepositoryLocation_AddAll()
   * @model
   * @generated
   */
  boolean isAddAll();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#isAddAll <em>Add All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Add All</em>' attribute.
   * @see #isAddAll()
   * @generated
   */
  void setAddAll(boolean value);

} // RepositoryLocation
