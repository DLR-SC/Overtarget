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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelFactory
 * @model kind="package"
 * @generated
 */
public interface TargetmodelPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "targetmodel";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "de.dlr.sc.overtarget.language";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "targetmodel";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TargetmodelPackage eINSTANCE = de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl.init();

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetFileImpl <em>Target File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetFileImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getTargetFile()
   * @generated
   */
  int TARGET_FILE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_FILE__NAME = 0;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_FILE__VARIABLES = 1;

  /**
   * The feature id for the '<em><b>Repository Locations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_FILE__REPOSITORY_LOCATIONS = 2;

  /**
   * The number of structural features of the '<em>Target File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_FILE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetLibraryImpl <em>Target Library</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetLibraryImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getTargetLibrary()
   * @generated
   */
  int TARGET_LIBRARY = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_LIBRARY__NAME = TARGET_FILE__NAME;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_LIBRARY__VARIABLES = TARGET_FILE__VARIABLES;

  /**
   * The feature id for the '<em><b>Repository Locations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_LIBRARY__REPOSITORY_LOCATIONS = TARGET_FILE__REPOSITORY_LOCATIONS;

  /**
   * The number of structural features of the '<em>Target Library</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_LIBRARY_FEATURE_COUNT = TARGET_FILE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl <em>Base Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getBaseModel()
   * @generated
   */
  int BASE_MODEL = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Imported Models</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__IMPORTED_MODELS = 1;

  /**
   * The feature id for the '<em><b>Os</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__OS = 2;

  /**
   * The feature id for the '<em><b>Ws</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__WS = 3;

  /**
   * The feature id for the '<em><b>Arch</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__ARCH = 4;

  /**
   * The feature id for the '<em><b>Loc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__LOC = 5;

  /**
   * The feature id for the '<em><b>Target Jre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__TARGET_JRE = 6;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__VARIABLES = 7;

  /**
   * The feature id for the '<em><b>Excluded Locations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__EXCLUDED_LOCATIONS = 8;

  /**
   * The feature id for the '<em><b>Repository Locations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__REPOSITORY_LOCATIONS = 9;

  /**
   * The number of structural features of the '<em>Base Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl <em>Target Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getTargetModel()
   * @generated
   */
  int TARGET_MODEL = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__NAME = TARGET_FILE__NAME;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__VARIABLES = TARGET_FILE__VARIABLES;

  /**
   * The feature id for the '<em><b>Repository Locations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__REPOSITORY_LOCATIONS = TARGET_FILE__REPOSITORY_LOCATIONS;

  /**
   * The feature id for the '<em><b>Super</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__SUPER = TARGET_FILE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Imported Models</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__IMPORTED_MODELS = TARGET_FILE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Os</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__OS = TARGET_FILE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Ws</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__WS = TARGET_FILE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Arch</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__ARCH = TARGET_FILE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Loc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__LOC = TARGET_FILE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Target Jre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__TARGET_JRE = TARGET_FILE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Excluded Locations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL__EXCLUDED_LOCATIONS = TARGET_FILE_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Target Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_MODEL_FEATURE_COUNT = TARGET_FILE_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl <em>Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUnit()
   * @generated
   */
  int UNIT = 4;

  /**
   * The feature id for the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT__SOURCE = 0;

  /**
   * The feature id for the '<em><b>Vers</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT__VERS = 1;

  /**
   * The number of structural features of the '<em>Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UrlExpressionImpl <em>Url Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.UrlExpressionImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUrlExpression()
   * @generated
   */
  int URL_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Url Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementImpl <em>Url Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUrlElement()
   * @generated
   */
  int URL_ELEMENT = 6;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT__LEFT = URL_EXPRESSION__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT__RIGHT = URL_EXPRESSION__RIGHT;

  /**
   * The number of structural features of the '<em>Url Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT_FEATURE_COUNT = URL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementStringImpl <em>Url Element String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementStringImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUrlElementString()
   * @generated
   */
  int URL_ELEMENT_STRING = 7;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT_STRING__LEFT = URL_ELEMENT__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT_STRING__RIGHT = URL_ELEMENT__RIGHT;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT_STRING__CONTENT = URL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Url Element String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT_STRING_FEATURE_COUNT = URL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementVariableImpl <em>Url Element Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementVariableImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUrlElementVariable()
   * @generated
   */
  int URL_ELEMENT_VARIABLE = 8;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT_VARIABLE__LEFT = URL_ELEMENT__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT_VARIABLE__RIGHT = URL_ELEMENT__RIGHT;

  /**
   * The feature id for the '<em><b>Content</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT_VARIABLE__CONTENT = URL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Url Element Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URL_ELEMENT_VARIABLE_FEATURE_COUNT = URL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.RepositoryLocationImpl <em>Repository Location</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.RepositoryLocationImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getRepositoryLocation()
   * @generated
   */
  int REPOSITORY_LOCATION = 9;

  /**
   * The feature id for the '<em><b>Referenced Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPOSITORY_LOCATION__REFERENCED_TARGET = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPOSITORY_LOCATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Url</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPOSITORY_LOCATION__URL = 2;

  /**
   * The feature id for the '<em><b>Units</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPOSITORY_LOCATION__UNITS = 3;

  /**
   * The number of structural features of the '<em>Repository Location</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPOSITORY_LOCATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.ExcludeLocationImpl <em>Exclude Location</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.ExcludeLocationImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getExcludeLocation()
   * @generated
   */
  int EXCLUDE_LOCATION = 10;

  /**
   * The feature id for the '<em><b>Repository Location</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_LOCATION__REPOSITORY_LOCATION = 0;

  /**
   * The feature id for the '<em><b>Units</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_LOCATION__UNITS = 1;

  /**
   * The number of structural features of the '<em>Exclude Location</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_LOCATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.VariableDefinitionImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getVariableDefinition()
   * @generated
   */
  int VARIABLE_DEFINITION = 11;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__VALUE = 0;

  /**
   * The number of structural features of the '<em>Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.AlreadyDeclaredVariableImpl <em>Already Declared Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.AlreadyDeclaredVariableImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getAlreadyDeclaredVariable()
   * @generated
   */
  int ALREADY_DECLARED_VARIABLE = 12;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALREADY_DECLARED_VARIABLE__VALUE = VARIABLE_DEFINITION__VALUE;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALREADY_DECLARED_VARIABLE__REF = VARIABLE_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Already Declared Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALREADY_DECLARED_VARIABLE_FEATURE_COUNT = VARIABLE_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.NewVariableDefinitionImpl <em>New Variable Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.NewVariableDefinitionImpl
   * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getNewVariableDefinition()
   * @generated
   */
  int NEW_VARIABLE_DEFINITION = 13;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_VARIABLE_DEFINITION__VALUE = VARIABLE_DEFINITION__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_VARIABLE_DEFINITION__NAME = VARIABLE_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>New Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_VARIABLE_DEFINITION_FEATURE_COUNT = VARIABLE_DEFINITION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.TargetFile <em>Target File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target File</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetFile
   * @generated
   */
  EClass getTargetFile();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.TargetFile#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetFile#getName()
   * @see #getTargetFile()
   * @generated
   */
  EAttribute getTargetFile_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.dlr.sc.overtarget.language.targetmodel.TargetFile#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetFile#getVariables()
   * @see #getTargetFile()
   * @generated
   */
  EReference getTargetFile_Variables();

  /**
   * Returns the meta object for the containment reference list '{@link de.dlr.sc.overtarget.language.targetmodel.TargetFile#getRepositoryLocations <em>Repository Locations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Repository Locations</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetFile#getRepositoryLocations()
   * @see #getTargetFile()
   * @generated
   */
  EReference getTargetFile_RepositoryLocations();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.TargetLibrary <em>Target Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target Library</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetLibrary
   * @generated
   */
  EClass getTargetLibrary();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel <em>Base Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Base Model</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel
   * @generated
   */
  EClass getBaseModel();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getName()
   * @see #getBaseModel()
   * @generated
   */
  EAttribute getBaseModel_Name();

  /**
   * Returns the meta object for the reference list '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getImportedModels <em>Imported Models</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Imported Models</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getImportedModels()
   * @see #getBaseModel()
   * @generated
   */
  EReference getBaseModel_ImportedModels();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getOs <em>Os</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Os</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getOs()
   * @see #getBaseModel()
   * @generated
   */
  EAttribute getBaseModel_Os();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getWs <em>Ws</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ws</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getWs()
   * @see #getBaseModel()
   * @generated
   */
  EAttribute getBaseModel_Ws();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getArch <em>Arch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Arch</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getArch()
   * @see #getBaseModel()
   * @generated
   */
  EAttribute getBaseModel_Arch();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getLoc <em>Loc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Loc</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getLoc()
   * @see #getBaseModel()
   * @generated
   */
  EAttribute getBaseModel_Loc();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getTargetJre <em>Target Jre</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Jre</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getTargetJre()
   * @see #getBaseModel()
   * @generated
   */
  EAttribute getBaseModel_TargetJre();

  /**
   * Returns the meta object for the containment reference list '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getVariables()
   * @see #getBaseModel()
   * @generated
   */
  EReference getBaseModel_Variables();

  /**
   * Returns the meta object for the containment reference list '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getExcludedLocations <em>Excluded Locations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Excluded Locations</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getExcludedLocations()
   * @see #getBaseModel()
   * @generated
   */
  EReference getBaseModel_ExcludedLocations();

  /**
   * Returns the meta object for the containment reference list '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel#getRepositoryLocations <em>Repository Locations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Repository Locations</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel#getRepositoryLocations()
   * @see #getBaseModel()
   * @generated
   */
  EReference getBaseModel_RepositoryLocations();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel <em>Target Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target Model</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel
   * @generated
   */
  EClass getTargetModel();

  /**
   * Returns the meta object for the reference '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getSuper <em>Super</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Super</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel#getSuper()
   * @see #getTargetModel()
   * @generated
   */
  EReference getTargetModel_Super();

  /**
   * Returns the meta object for the reference list '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getImportedModels <em>Imported Models</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Imported Models</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel#getImportedModels()
   * @see #getTargetModel()
   * @generated
   */
  EReference getTargetModel_ImportedModels();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getOs <em>Os</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Os</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel#getOs()
   * @see #getTargetModel()
   * @generated
   */
  EAttribute getTargetModel_Os();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getWs <em>Ws</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ws</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel#getWs()
   * @see #getTargetModel()
   * @generated
   */
  EAttribute getTargetModel_Ws();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getArch <em>Arch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Arch</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel#getArch()
   * @see #getTargetModel()
   * @generated
   */
  EAttribute getTargetModel_Arch();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getLoc <em>Loc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Loc</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel#getLoc()
   * @see #getTargetModel()
   * @generated
   */
  EAttribute getTargetModel_Loc();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getTargetJre <em>Target Jre</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Jre</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel#getTargetJre()
   * @see #getTargetModel()
   * @generated
   */
  EAttribute getTargetModel_TargetJre();

  /**
   * Returns the meta object for the containment reference list '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel#getExcludedLocations <em>Excluded Locations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Excluded Locations</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel#getExcludedLocations()
   * @see #getTargetModel()
   * @generated
   */
  EReference getTargetModel_ExcludedLocations();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.Unit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.Unit
   * @generated
   */
  EClass getUnit();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.Unit#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.Unit#getSource()
   * @see #getUnit()
   * @generated
   */
  EAttribute getUnit_Source();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.Unit#getVers <em>Vers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Vers</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.Unit#getVers()
   * @see #getUnit()
   * @generated
   */
  EAttribute getUnit_Vers();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.UrlExpression <em>Url Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Url Expression</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlExpression
   * @generated
   */
  EClass getUrlExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.dlr.sc.overtarget.language.targetmodel.UrlExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlExpression#getLeft()
   * @see #getUrlExpression()
   * @generated
   */
  EReference getUrlExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.dlr.sc.overtarget.language.targetmodel.UrlExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlExpression#getRight()
   * @see #getUrlExpression()
   * @generated
   */
  EReference getUrlExpression_Right();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.UrlElement <em>Url Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Url Element</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlElement
   * @generated
   */
  EClass getUrlElement();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.UrlElementString <em>Url Element String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Url Element String</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlElementString
   * @generated
   */
  EClass getUrlElementString();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.UrlElementString#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlElementString#getContent()
   * @see #getUrlElementString()
   * @generated
   */
  EAttribute getUrlElementString_Content();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable <em>Url Element Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Url Element Variable</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable
   * @generated
   */
  EClass getUrlElementVariable();

  /**
   * Returns the meta object for the reference '{@link de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Content</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable#getContent()
   * @see #getUrlElementVariable()
   * @generated
   */
  EReference getUrlElementVariable_Content();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation <em>Repository Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Repository Location</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
   * @generated
   */
  EClass getRepositoryLocation();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#isReferencedTarget <em>Referenced Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Referenced Target</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#isReferencedTarget()
   * @see #getRepositoryLocation()
   * @generated
   */
  EAttribute getRepositoryLocation_ReferencedTarget();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getName()
   * @see #getRepositoryLocation()
   * @generated
   */
  EAttribute getRepositoryLocation_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Url</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getUrl()
   * @see #getRepositoryLocation()
   * @generated
   */
  EReference getRepositoryLocation_Url();

  /**
   * Returns the meta object for the containment reference list '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Units</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation#getUnits()
   * @see #getRepositoryLocation()
   * @generated
   */
  EReference getRepositoryLocation_Units();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation <em>Exclude Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exclude Location</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation
   * @generated
   */
  EClass getExcludeLocation();

  /**
   * Returns the meta object for the reference '{@link de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation#getRepositoryLocation <em>Repository Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Repository Location</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation#getRepositoryLocation()
   * @see #getExcludeLocation()
   * @generated
   */
  EReference getExcludeLocation_RepositoryLocation();

  /**
   * Returns the meta object for the containment reference list '{@link de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Units</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation#getUnits()
   * @see #getExcludeLocation()
   * @generated
   */
  EReference getExcludeLocation_Units();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Definition</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.VariableDefinition
   * @generated
   */
  EClass getVariableDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.VariableDefinition#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.VariableDefinition#getValue()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Value();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable <em>Already Declared Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Already Declared Variable</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable
   * @generated
   */
  EClass getAlreadyDeclaredVariable();

  /**
   * Returns the meta object for the reference '{@link de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable#getRef()
   * @see #getAlreadyDeclaredVariable()
   * @generated
   */
  EReference getAlreadyDeclaredVariable_Ref();

  /**
   * Returns the meta object for class '{@link de.dlr.sc.overtarget.language.targetmodel.NewVariableDefinition <em>New Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>New Variable Definition</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.NewVariableDefinition
   * @generated
   */
  EClass getNewVariableDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.dlr.sc.overtarget.language.targetmodel.NewVariableDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dlr.sc.overtarget.language.targetmodel.NewVariableDefinition#getName()
   * @see #getNewVariableDefinition()
   * @generated
   */
  EAttribute getNewVariableDefinition_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TargetmodelFactory getTargetmodelFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetFileImpl <em>Target File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetFileImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getTargetFile()
     * @generated
     */
    EClass TARGET_FILE = eINSTANCE.getTargetFile();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET_FILE__NAME = eINSTANCE.getTargetFile_Name();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET_FILE__VARIABLES = eINSTANCE.getTargetFile_Variables();

    /**
     * The meta object literal for the '<em><b>Repository Locations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET_FILE__REPOSITORY_LOCATIONS = eINSTANCE.getTargetFile_RepositoryLocations();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetLibraryImpl <em>Target Library</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetLibraryImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getTargetLibrary()
     * @generated
     */
    EClass TARGET_LIBRARY = eINSTANCE.getTargetLibrary();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl <em>Base Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getBaseModel()
     * @generated
     */
    EClass BASE_MODEL = eINSTANCE.getBaseModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_MODEL__NAME = eINSTANCE.getBaseModel_Name();

    /**
     * The meta object literal for the '<em><b>Imported Models</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_MODEL__IMPORTED_MODELS = eINSTANCE.getBaseModel_ImportedModels();

    /**
     * The meta object literal for the '<em><b>Os</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_MODEL__OS = eINSTANCE.getBaseModel_Os();

    /**
     * The meta object literal for the '<em><b>Ws</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_MODEL__WS = eINSTANCE.getBaseModel_Ws();

    /**
     * The meta object literal for the '<em><b>Arch</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_MODEL__ARCH = eINSTANCE.getBaseModel_Arch();

    /**
     * The meta object literal for the '<em><b>Loc</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_MODEL__LOC = eINSTANCE.getBaseModel_Loc();

    /**
     * The meta object literal for the '<em><b>Target Jre</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_MODEL__TARGET_JRE = eINSTANCE.getBaseModel_TargetJre();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_MODEL__VARIABLES = eINSTANCE.getBaseModel_Variables();

    /**
     * The meta object literal for the '<em><b>Excluded Locations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_MODEL__EXCLUDED_LOCATIONS = eINSTANCE.getBaseModel_ExcludedLocations();

    /**
     * The meta object literal for the '<em><b>Repository Locations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_MODEL__REPOSITORY_LOCATIONS = eINSTANCE.getBaseModel_RepositoryLocations();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl <em>Target Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getTargetModel()
     * @generated
     */
    EClass TARGET_MODEL = eINSTANCE.getTargetModel();

    /**
     * The meta object literal for the '<em><b>Super</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET_MODEL__SUPER = eINSTANCE.getTargetModel_Super();

    /**
     * The meta object literal for the '<em><b>Imported Models</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET_MODEL__IMPORTED_MODELS = eINSTANCE.getTargetModel_ImportedModels();

    /**
     * The meta object literal for the '<em><b>Os</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET_MODEL__OS = eINSTANCE.getTargetModel_Os();

    /**
     * The meta object literal for the '<em><b>Ws</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET_MODEL__WS = eINSTANCE.getTargetModel_Ws();

    /**
     * The meta object literal for the '<em><b>Arch</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET_MODEL__ARCH = eINSTANCE.getTargetModel_Arch();

    /**
     * The meta object literal for the '<em><b>Loc</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET_MODEL__LOC = eINSTANCE.getTargetModel_Loc();

    /**
     * The meta object literal for the '<em><b>Target Jre</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET_MODEL__TARGET_JRE = eINSTANCE.getTargetModel_TargetJre();

    /**
     * The meta object literal for the '<em><b>Excluded Locations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET_MODEL__EXCLUDED_LOCATIONS = eINSTANCE.getTargetModel_ExcludedLocations();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl <em>Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUnit()
     * @generated
     */
    EClass UNIT = eINSTANCE.getUnit();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT__SOURCE = eINSTANCE.getUnit_Source();

    /**
     * The meta object literal for the '<em><b>Vers</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT__VERS = eINSTANCE.getUnit_Vers();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UrlExpressionImpl <em>Url Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.UrlExpressionImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUrlExpression()
     * @generated
     */
    EClass URL_EXPRESSION = eINSTANCE.getUrlExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference URL_EXPRESSION__LEFT = eINSTANCE.getUrlExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference URL_EXPRESSION__RIGHT = eINSTANCE.getUrlExpression_Right();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementImpl <em>Url Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUrlElement()
     * @generated
     */
    EClass URL_ELEMENT = eINSTANCE.getUrlElement();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementStringImpl <em>Url Element String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementStringImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUrlElementString()
     * @generated
     */
    EClass URL_ELEMENT_STRING = eINSTANCE.getUrlElementString();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute URL_ELEMENT_STRING__CONTENT = eINSTANCE.getUrlElementString_Content();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementVariableImpl <em>Url Element Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.UrlElementVariableImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getUrlElementVariable()
     * @generated
     */
    EClass URL_ELEMENT_VARIABLE = eINSTANCE.getUrlElementVariable();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference URL_ELEMENT_VARIABLE__CONTENT = eINSTANCE.getUrlElementVariable_Content();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.RepositoryLocationImpl <em>Repository Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.RepositoryLocationImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getRepositoryLocation()
     * @generated
     */
    EClass REPOSITORY_LOCATION = eINSTANCE.getRepositoryLocation();

    /**
     * The meta object literal for the '<em><b>Referenced Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPOSITORY_LOCATION__REFERENCED_TARGET = eINSTANCE.getRepositoryLocation_ReferencedTarget();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPOSITORY_LOCATION__NAME = eINSTANCE.getRepositoryLocation_Name();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REPOSITORY_LOCATION__URL = eINSTANCE.getRepositoryLocation_Url();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REPOSITORY_LOCATION__UNITS = eINSTANCE.getRepositoryLocation_Units();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.ExcludeLocationImpl <em>Exclude Location</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.ExcludeLocationImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getExcludeLocation()
     * @generated
     */
    EClass EXCLUDE_LOCATION = eINSTANCE.getExcludeLocation();

    /**
     * The meta object literal for the '<em><b>Repository Location</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCLUDE_LOCATION__REPOSITORY_LOCATION = eINSTANCE.getExcludeLocation_RepositoryLocation();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCLUDE_LOCATION__UNITS = eINSTANCE.getExcludeLocation_Units();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.VariableDefinitionImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getVariableDefinition()
     * @generated
     */
    EClass VARIABLE_DEFINITION = eINSTANCE.getVariableDefinition();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__VALUE = eINSTANCE.getVariableDefinition_Value();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.AlreadyDeclaredVariableImpl <em>Already Declared Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.AlreadyDeclaredVariableImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getAlreadyDeclaredVariable()
     * @generated
     */
    EClass ALREADY_DECLARED_VARIABLE = eINSTANCE.getAlreadyDeclaredVariable();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALREADY_DECLARED_VARIABLE__REF = eINSTANCE.getAlreadyDeclaredVariable_Ref();

    /**
     * The meta object literal for the '{@link de.dlr.sc.overtarget.language.targetmodel.impl.NewVariableDefinitionImpl <em>New Variable Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.NewVariableDefinitionImpl
     * @see de.dlr.sc.overtarget.language.targetmodel.impl.TargetmodelPackageImpl#getNewVariableDefinition()
     * @generated
     */
    EClass NEW_VARIABLE_DEFINITION = eINSTANCE.getNewVariableDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEW_VARIABLE_DEFINITION__NAME = eINSTANCE.getNewVariableDefinition_Name();

  }

} //TargetmodelPackage
