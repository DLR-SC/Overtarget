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
 * A representation of the model object '<em><b>Base Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getName <em>Name</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getImportedModels <em>Imported Models</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getOs <em>Os</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getWs <em>Ws</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getArch <em>Arch</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getLoc <em>Loc</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getTargetJre <em>Target Jre</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getVariables <em>Variables</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getExcludedLocations <em>Excluded Locations</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getRepositoryLocations <em>Repository Locations</em>}</li>
 * </ul>
 *
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel()
 * @model
 * @generated
 */
public interface BaseModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Imported Models</b></em>' reference list.
   * The list contents are of type {@link de.dlr.sc.overtarget.language.targetmodel.TargetFile}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imported Models</em>' reference list.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_ImportedModels()
   * @model
   * @generated
   */
  EList<TargetFile> getImportedModels();

  /**
   * Returns the value of the '<em><b>Os</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Os</em>' attribute.
   * @see #setOs(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_Os()
   * @model
   * @generated
   */
  String getOs();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getOs <em>Os</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Os</em>' attribute.
   * @see #getOs()
   * @generated
   */
  void setOs(String value);

  /**
   * Returns the value of the '<em><b>Ws</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ws</em>' attribute.
   * @see #setWs(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_Ws()
   * @model
   * @generated
   */
  String getWs();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getWs <em>Ws</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ws</em>' attribute.
   * @see #getWs()
   * @generated
   */
  void setWs(String value);

  /**
   * Returns the value of the '<em><b>Arch</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arch</em>' attribute.
   * @see #setArch(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_Arch()
   * @model
   * @generated
   */
  String getArch();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getArch <em>Arch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arch</em>' attribute.
   * @see #getArch()
   * @generated
   */
  void setArch(String value);

  /**
   * Returns the value of the '<em><b>Loc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loc</em>' attribute.
   * @see #setLoc(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_Loc()
   * @model
   * @generated
   */
  String getLoc();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getLoc <em>Loc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loc</em>' attribute.
   * @see #getLoc()
   * @generated
   */
  void setLoc(String value);

  /**
   * Returns the value of the '<em><b>Target Jre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Jre</em>' attribute.
   * @see #setTargetJre(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_TargetJre()
   * @model
   * @generated
   */
  String getTargetJre();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getTargetJre <em>Target Jre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Jre</em>' attribute.
   * @see #getTargetJre()
   * @generated
   */
  void setTargetJre(String value);

  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link de.dlr.sc.overtarget.language.targetmodel.VariableDefinition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_Variables()
   * @model containment="true"
   * @generated
   */
  EList<VariableDefinition> getVariables();

  /**
   * Returns the value of the '<em><b>Excluded Locations</b></em>' containment reference list.
   * The list contents are of type {@link de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Excluded Locations</em>' containment reference list.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_ExcludedLocations()
   * @model containment="true"
   * @generated
   */
  EList<ExcludeLocation> getExcludedLocations();

  /**
   * Returns the value of the '<em><b>Repository Locations</b></em>' containment reference list.
   * The list contents are of type {@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repository Locations</em>' containment reference list.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getBaseModel_RepositoryLocations()
   * @model containment="true"
   * @generated
   */
  EList<RepositoryLocation> getRepositoryLocations();

} // BaseModel
