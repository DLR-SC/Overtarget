/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.targetmodel.impl;

import de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable;
import de.dlr.sc.overtarget.language.targetmodel.BaseModel;
import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation;
import de.dlr.sc.overtarget.language.targetmodel.NewVariableDefinition;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetLibrary;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelFactory;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.targetmodel.UrlElement;
import de.dlr.sc.overtarget.language.targetmodel.UrlElementString;
import de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable;
import de.dlr.sc.overtarget.language.targetmodel.UrlExpression;
import de.dlr.sc.overtarget.language.targetmodel.VariableDefinition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetmodelPackageImpl extends EPackageImpl implements TargetmodelPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass targetFileEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass targetLibraryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass baseModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass targetModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass urlExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass urlElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass urlElementStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass urlElementVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass repositoryLocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass excludeLocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alreadyDeclaredVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass newVariableDefinitionEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TargetmodelPackageImpl()
  {
    super(eNS_URI, TargetmodelFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link TargetmodelPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TargetmodelPackage init()
  {
    if (isInited) return (TargetmodelPackage)EPackage.Registry.INSTANCE.getEPackage(TargetmodelPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredTargetmodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    TargetmodelPackageImpl theTargetmodelPackage = registeredTargetmodelPackage instanceof TargetmodelPackageImpl ? (TargetmodelPackageImpl)registeredTargetmodelPackage : new TargetmodelPackageImpl();

    isInited = true;

    // Create package meta-data objects
    theTargetmodelPackage.createPackageContents();

    // Initialize created meta-data
    theTargetmodelPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTargetmodelPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TargetmodelPackage.eNS_URI, theTargetmodelPackage);
    return theTargetmodelPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTargetFile()
  {
    return targetFileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTargetFile_Name()
  {
    return (EAttribute)targetFileEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTargetFile_Variables()
  {
    return (EReference)targetFileEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTargetFile_RepositoryLocations()
  {
    return (EReference)targetFileEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTargetLibrary()
  {
    return targetLibraryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBaseModel()
  {
    return baseModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBaseModel_Name()
  {
    return (EAttribute)baseModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBaseModel_ImportedModels()
  {
    return (EReference)baseModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBaseModel_Os()
  {
    return (EAttribute)baseModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBaseModel_Ws()
  {
    return (EAttribute)baseModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBaseModel_Arch()
  {
    return (EAttribute)baseModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBaseModel_Loc()
  {
    return (EAttribute)baseModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBaseModel_TargetJre()
  {
    return (EAttribute)baseModelEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBaseModel_Variables()
  {
    return (EReference)baseModelEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBaseModel_ExcludedLocations()
  {
    return (EReference)baseModelEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBaseModel_RepositoryLocations()
  {
    return (EReference)baseModelEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTargetModel()
  {
    return targetModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTargetModel_Super()
  {
    return (EReference)targetModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTargetModel_ImportedModels()
  {
    return (EReference)targetModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTargetModel_Os()
  {
    return (EAttribute)targetModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTargetModel_Ws()
  {
    return (EAttribute)targetModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTargetModel_Arch()
  {
    return (EAttribute)targetModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTargetModel_Loc()
  {
    return (EAttribute)targetModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTargetModel_TargetJre()
  {
    return (EAttribute)targetModelEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTargetModel_ExcludedLocations()
  {
    return (EReference)targetModelEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUnit()
  {
    return unitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUnit_Source()
  {
    return (EAttribute)unitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUnit_Vers()
  {
    return (EAttribute)unitEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUrlExpression()
  {
    return urlExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getUrlExpression_Left()
  {
    return (EReference)urlExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getUrlExpression_Right()
  {
    return (EReference)urlExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUrlElement()
  {
    return urlElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUrlElementString()
  {
    return urlElementStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getUrlElementString_Content()
  {
    return (EAttribute)urlElementStringEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUrlElementVariable()
  {
    return urlElementVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getUrlElementVariable_Content()
  {
    return (EReference)urlElementVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRepositoryLocation()
  {
    return repositoryLocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRepositoryLocation_ReferencedTarget()
  {
    return (EAttribute)repositoryLocationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRepositoryLocation_Name()
  {
    return (EAttribute)repositoryLocationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRepositoryLocation_Url()
  {
    return (EReference)repositoryLocationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRepositoryLocation_AddAll()
  {
    return (EAttribute)repositoryLocationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRepositoryLocation_Units()
  {
    return (EReference)repositoryLocationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getExcludeLocation()
  {
    return excludeLocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getExcludeLocation_RepositoryLocation()
  {
    return (EReference)excludeLocationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getExcludeLocation_Units()
  {
    return (EReference)excludeLocationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVariableDefinition()
  {
    return variableDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVariableDefinition_Value()
  {
    return (EAttribute)variableDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAlreadyDeclaredVariable()
  {
    return alreadyDeclaredVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAlreadyDeclaredVariable_Ref()
  {
    return (EReference)alreadyDeclaredVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNewVariableDefinition()
  {
    return newVariableDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getNewVariableDefinition_Name()
  {
    return (EAttribute)newVariableDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TargetmodelFactory getTargetmodelFactory()
  {
    return (TargetmodelFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    targetFileEClass = createEClass(TARGET_FILE);
    createEAttribute(targetFileEClass, TARGET_FILE__NAME);
    createEReference(targetFileEClass, TARGET_FILE__VARIABLES);
    createEReference(targetFileEClass, TARGET_FILE__REPOSITORY_LOCATIONS);

    targetLibraryEClass = createEClass(TARGET_LIBRARY);

    baseModelEClass = createEClass(BASE_MODEL);
    createEAttribute(baseModelEClass, BASE_MODEL__NAME);
    createEReference(baseModelEClass, BASE_MODEL__IMPORTED_MODELS);
    createEAttribute(baseModelEClass, BASE_MODEL__OS);
    createEAttribute(baseModelEClass, BASE_MODEL__WS);
    createEAttribute(baseModelEClass, BASE_MODEL__ARCH);
    createEAttribute(baseModelEClass, BASE_MODEL__LOC);
    createEAttribute(baseModelEClass, BASE_MODEL__TARGET_JRE);
    createEReference(baseModelEClass, BASE_MODEL__VARIABLES);
    createEReference(baseModelEClass, BASE_MODEL__EXCLUDED_LOCATIONS);
    createEReference(baseModelEClass, BASE_MODEL__REPOSITORY_LOCATIONS);

    targetModelEClass = createEClass(TARGET_MODEL);
    createEReference(targetModelEClass, TARGET_MODEL__SUPER);
    createEReference(targetModelEClass, TARGET_MODEL__IMPORTED_MODELS);
    createEAttribute(targetModelEClass, TARGET_MODEL__OS);
    createEAttribute(targetModelEClass, TARGET_MODEL__WS);
    createEAttribute(targetModelEClass, TARGET_MODEL__ARCH);
    createEAttribute(targetModelEClass, TARGET_MODEL__LOC);
    createEAttribute(targetModelEClass, TARGET_MODEL__TARGET_JRE);
    createEReference(targetModelEClass, TARGET_MODEL__EXCLUDED_LOCATIONS);

    unitEClass = createEClass(UNIT);
    createEAttribute(unitEClass, UNIT__SOURCE);
    createEAttribute(unitEClass, UNIT__VERS);

    urlExpressionEClass = createEClass(URL_EXPRESSION);
    createEReference(urlExpressionEClass, URL_EXPRESSION__LEFT);
    createEReference(urlExpressionEClass, URL_EXPRESSION__RIGHT);

    urlElementEClass = createEClass(URL_ELEMENT);

    urlElementStringEClass = createEClass(URL_ELEMENT_STRING);
    createEAttribute(urlElementStringEClass, URL_ELEMENT_STRING__CONTENT);

    urlElementVariableEClass = createEClass(URL_ELEMENT_VARIABLE);
    createEReference(urlElementVariableEClass, URL_ELEMENT_VARIABLE__CONTENT);

    repositoryLocationEClass = createEClass(REPOSITORY_LOCATION);
    createEAttribute(repositoryLocationEClass, REPOSITORY_LOCATION__REFERENCED_TARGET);
    createEAttribute(repositoryLocationEClass, REPOSITORY_LOCATION__NAME);
    createEReference(repositoryLocationEClass, REPOSITORY_LOCATION__URL);
    createEAttribute(repositoryLocationEClass, REPOSITORY_LOCATION__ADD_ALL);
    createEReference(repositoryLocationEClass, REPOSITORY_LOCATION__UNITS);

    excludeLocationEClass = createEClass(EXCLUDE_LOCATION);
    createEReference(excludeLocationEClass, EXCLUDE_LOCATION__REPOSITORY_LOCATION);
    createEReference(excludeLocationEClass, EXCLUDE_LOCATION__UNITS);

    variableDefinitionEClass = createEClass(VARIABLE_DEFINITION);
    createEAttribute(variableDefinitionEClass, VARIABLE_DEFINITION__VALUE);

    alreadyDeclaredVariableEClass = createEClass(ALREADY_DECLARED_VARIABLE);
    createEReference(alreadyDeclaredVariableEClass, ALREADY_DECLARED_VARIABLE__REF);

    newVariableDefinitionEClass = createEClass(NEW_VARIABLE_DEFINITION);
    createEAttribute(newVariableDefinitionEClass, NEW_VARIABLE_DEFINITION__NAME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    targetLibraryEClass.getESuperTypes().add(this.getTargetFile());
    targetModelEClass.getESuperTypes().add(this.getTargetFile());
    urlElementEClass.getESuperTypes().add(this.getUrlExpression());
    urlElementStringEClass.getESuperTypes().add(this.getUrlElement());
    urlElementVariableEClass.getESuperTypes().add(this.getUrlElement());
    alreadyDeclaredVariableEClass.getESuperTypes().add(this.getVariableDefinition());
    newVariableDefinitionEClass.getESuperTypes().add(this.getVariableDefinition());

    // Initialize classes and features; add operations and parameters
    initEClass(targetFileEClass, TargetFile.class, "TargetFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTargetFile_Name(), ecorePackage.getEString(), "name", null, 0, 1, TargetFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTargetFile_Variables(), this.getVariableDefinition(), null, "variables", null, 0, -1, TargetFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTargetFile_RepositoryLocations(), this.getRepositoryLocation(), null, "repositoryLocations", null, 0, -1, TargetFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(targetLibraryEClass, TargetLibrary.class, "TargetLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(baseModelEClass, BaseModel.class, "BaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBaseModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBaseModel_ImportedModels(), this.getTargetFile(), null, "importedModels", null, 0, -1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBaseModel_Os(), ecorePackage.getEString(), "os", null, 0, 1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBaseModel_Ws(), ecorePackage.getEString(), "ws", null, 0, 1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBaseModel_Arch(), ecorePackage.getEString(), "arch", null, 0, 1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBaseModel_Loc(), ecorePackage.getEString(), "loc", null, 0, 1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBaseModel_TargetJre(), ecorePackage.getEString(), "targetJre", null, 0, 1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBaseModel_Variables(), this.getVariableDefinition(), null, "variables", null, 0, -1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBaseModel_ExcludedLocations(), this.getExcludeLocation(), null, "excludedLocations", null, 0, -1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBaseModel_RepositoryLocations(), this.getRepositoryLocation(), null, "repositoryLocations", null, 0, -1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(targetModelEClass, TargetModel.class, "TargetModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTargetModel_Super(), this.getTargetModel(), null, "super", null, 0, 1, TargetModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTargetModel_ImportedModels(), this.getTargetFile(), null, "importedModels", null, 0, -1, TargetModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTargetModel_Os(), ecorePackage.getEString(), "os", null, 0, 1, TargetModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTargetModel_Ws(), ecorePackage.getEString(), "ws", null, 0, 1, TargetModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTargetModel_Arch(), ecorePackage.getEString(), "arch", null, 0, 1, TargetModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTargetModel_Loc(), ecorePackage.getEString(), "loc", null, 0, 1, TargetModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTargetModel_TargetJre(), ecorePackage.getEString(), "targetJre", null, 0, 1, TargetModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTargetModel_ExcludedLocations(), this.getExcludeLocation(), null, "excludedLocations", null, 0, -1, TargetModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unitEClass, Unit.class, "Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnit_Source(), ecorePackage.getEString(), "source", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnit_Vers(), ecorePackage.getEString(), "vers", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(urlExpressionEClass, UrlExpression.class, "UrlExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUrlExpression_Left(), this.getUrlExpression(), null, "left", null, 0, 1, UrlExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUrlExpression_Right(), this.getUrlElement(), null, "right", null, 0, 1, UrlExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(urlElementEClass, UrlElement.class, "UrlElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(urlElementStringEClass, UrlElementString.class, "UrlElementString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUrlElementString_Content(), ecorePackage.getEString(), "content", null, 0, 1, UrlElementString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(urlElementVariableEClass, UrlElementVariable.class, "UrlElementVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUrlElementVariable_Content(), this.getVariableDefinition(), null, "content", null, 0, 1, UrlElementVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(repositoryLocationEClass, RepositoryLocation.class, "RepositoryLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRepositoryLocation_ReferencedTarget(), ecorePackage.getEBoolean(), "referencedTarget", null, 0, 1, RepositoryLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRepositoryLocation_Name(), ecorePackage.getEString(), "name", null, 0, 1, RepositoryLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRepositoryLocation_Url(), this.getUrlExpression(), null, "url", null, 0, 1, RepositoryLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRepositoryLocation_AddAll(), ecorePackage.getEBoolean(), "addAll", null, 0, 1, RepositoryLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRepositoryLocation_Units(), this.getUnit(), null, "units", null, 0, -1, RepositoryLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(excludeLocationEClass, ExcludeLocation.class, "ExcludeLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExcludeLocation_RepositoryLocation(), this.getRepositoryLocation(), null, "repositoryLocation", null, 0, 1, ExcludeLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExcludeLocation_Units(), this.getUnit(), null, "units", null, 0, -1, ExcludeLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableDefinitionEClass, VariableDefinition.class, "VariableDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableDefinition_Value(), ecorePackage.getEString(), "value", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(alreadyDeclaredVariableEClass, AlreadyDeclaredVariable.class, "AlreadyDeclaredVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAlreadyDeclaredVariable_Ref(), this.getNewVariableDefinition(), null, "ref", null, 0, 1, AlreadyDeclaredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(newVariableDefinitionEClass, NewVariableDefinition.class, "NewVariableDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNewVariableDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, NewVariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TargetmodelPackageImpl
