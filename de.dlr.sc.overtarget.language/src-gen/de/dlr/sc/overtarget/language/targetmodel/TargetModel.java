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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getSuper <em>Super</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getImportedModels <em>Imported Models</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getOs <em>Os</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getWs <em>Ws</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getWks <em>Wks</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getArch <em>Arch</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getLoc <em>Loc</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getTargetJre <em>Target Jre</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getExcludedLocations <em>Excluded Locations</em>}</li>
 * </ul>
 *
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel()
 * @model
 * @generated
 */
public interface TargetModel extends TargetFile
{
  /**
   * Returns the value of the '<em><b>Super</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super</em>' reference.
   * @see #setSuper(TargetModel)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel_Super()
   * @model
   * @generated
   */
  TargetModel getSuper();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getSuper <em>Super</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super</em>' reference.
   * @see #getSuper()
   * @generated
   */
  void setSuper(TargetModel value);

  /**
   * Returns the value of the '<em><b>Imported Models</b></em>' reference list.
   * The list contents are of type {@link de.dlr.sc.overtarget.language.targetmodel.TargetFile}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imported Models</em>' reference list.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel_ImportedModels()
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
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel_Os()
   * @model
   * @generated
   */
  String getOs();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getOs <em>Os</em>}' attribute.
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
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel_Ws()
   * @model
   * @generated
   */
  String getWs();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getWs <em>Ws</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ws</em>' attribute.
   * @see #getWs()
   * @generated
   */
  void setWs(String value);

  /**
   * Returns the value of the '<em><b>Wks</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Wks</em>' attribute.
   * @see #setWks(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel_Wks()
   * @model
   * @generated
   */
  String getWks();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getWks <em>Wks</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Wks</em>' attribute.
   * @see #getWks()
   * @generated
   */
  void setWks(String value);

  /**
   * Returns the value of the '<em><b>Arch</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arch</em>' attribute.
   * @see #setArch(String)
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel_Arch()
   * @model
   * @generated
   */
  String getArch();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getArch <em>Arch</em>}' attribute.
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
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel_Loc()
   * @model
   * @generated
   */
  String getLoc();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getLoc <em>Loc</em>}' attribute.
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
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel_TargetJre()
   * @model
   * @generated
   */
  String getTargetJre();

  /**
   * Sets the value of the '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getTargetJre <em>Target Jre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Jre</em>' attribute.
   * @see #getTargetJre()
   * @generated
   */
  void setTargetJre(String value);

  /**
   * Returns the value of the '<em><b>Excluded Locations</b></em>' containment reference list.
   * The list contents are of type {@link de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Excluded Locations</em>' containment reference list.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#getTargetModel_ExcludedLocations()
   * @model containment="true"
   * @generated
   */
  EList<ExcludeLocation> getExcludedLocations();

} // TargetModel
