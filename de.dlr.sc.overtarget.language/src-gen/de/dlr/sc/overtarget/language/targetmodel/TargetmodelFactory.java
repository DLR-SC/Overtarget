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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage
 * @generated
 */
public interface TargetmodelFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TargetmodelFactory eINSTANCE = de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Target File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Target File</em>'.
   * @generated
   */
  TargetFile createTargetFile();

  /**
   * Returns a new object of class '<em>Target Library</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Target Library</em>'.
   * @generated
   */
  TargetLibrary createTargetLibrary();

  /**
   * Returns a new object of class '<em>Base Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Base Model</em>'.
   * @generated
   */
  BaseModel createBaseModel();

  /**
   * Returns a new object of class '<em>Target Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Target Model</em>'.
   * @generated
   */
  TargetModel createTargetModel();

  /**
   * Returns a new object of class '<em>Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit</em>'.
   * @generated
   */
  Unit createUnit();

  /**
   * Returns a new object of class '<em>Url Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Url Expression</em>'.
   * @generated
   */
  UrlExpression createUrlExpression();

  /**
   * Returns a new object of class '<em>Url Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Url Element</em>'.
   * @generated
   */
  UrlElement createUrlElement();

  /**
   * Returns a new object of class '<em>Url Element String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Url Element String</em>'.
   * @generated
   */
  UrlElementString createUrlElementString();

  /**
   * Returns a new object of class '<em>Url Element Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Url Element Variable</em>'.
   * @generated
   */
  UrlElementVariable createUrlElementVariable();

  /**
   * Returns a new object of class '<em>Repository Location</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Repository Location</em>'.
   * @generated
   */
  RepositoryLocation createRepositoryLocation();

  /**
   * Returns a new object of class '<em>Exclude Location</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exclude Location</em>'.
   * @generated
   */
  ExcludeLocation createExcludeLocation();

  /**
   * Returns a new object of class '<em>Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Definition</em>'.
   * @generated
   */
  VariableDefinition createVariableDefinition();

  /**
   * Returns a new object of class '<em>Already Declared Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Already Declared Variable</em>'.
   * @generated
   */
  AlreadyDeclaredVariable createAlreadyDeclaredVariable();

  /**
   * Returns a new object of class '<em>New Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>New Variable Definition</em>'.
   * @generated
   */
  NewVariableDefinition createNewVariableDefinition();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TargetmodelPackage getTargetmodelPackage();

} //TargetmodelFactory
