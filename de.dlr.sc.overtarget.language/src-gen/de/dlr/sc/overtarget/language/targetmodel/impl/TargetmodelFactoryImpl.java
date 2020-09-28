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

import de.dlr.sc.overtarget.language.targetmodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetmodelFactoryImpl extends EFactoryImpl implements TargetmodelFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TargetmodelFactory init()
  {
    try
    {
      TargetmodelFactory theTargetmodelFactory = (TargetmodelFactory)EPackage.Registry.INSTANCE.getEFactory(TargetmodelPackage.eNS_URI);
      if (theTargetmodelFactory != null)
      {
        return theTargetmodelFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TargetmodelFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TargetmodelFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TargetmodelPackage.TARGET_FILE: return createTargetFile();
      case TargetmodelPackage.TARGET_LIBRARY: return createTargetLibrary();
      case TargetmodelPackage.BASE_MODEL: return createBaseModel();
      case TargetmodelPackage.TARGET_MODEL: return createTargetModel();
      case TargetmodelPackage.UNIT: return createUnit();
      case TargetmodelPackage.URL_EXPRESSION: return createUrlExpression();
      case TargetmodelPackage.URL_ELEMENT: return createUrlElement();
      case TargetmodelPackage.URL_ELEMENT_STRING: return createUrlElementString();
      case TargetmodelPackage.URL_ELEMENT_VARIABLE: return createUrlElementVariable();
      case TargetmodelPackage.REPOSITORY_LOCATION: return createRepositoryLocation();
      case TargetmodelPackage.EXCLUDE_LOCATION: return createExcludeLocation();
      case TargetmodelPackage.VARIABLE_DEFINITION: return createVariableDefinition();
      case TargetmodelPackage.ALREADY_DECLARED_VARIABLE: return createAlreadyDeclaredVariable();
      case TargetmodelPackage.NEW_VARIABLE_DEFINITION: return createNewVariableDefinition();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TargetFile createTargetFile()
  {
    TargetFileImpl targetFile = new TargetFileImpl();
    return targetFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TargetLibrary createTargetLibrary()
  {
    TargetLibraryImpl targetLibrary = new TargetLibraryImpl();
    return targetLibrary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BaseModel createBaseModel()
  {
    BaseModelImpl baseModel = new BaseModelImpl();
    return baseModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TargetModel createTargetModel()
  {
    TargetModelImpl targetModel = new TargetModelImpl();
    return targetModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Unit createUnit()
  {
    UnitImpl unit = new UnitImpl();
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UrlExpression createUrlExpression()
  {
    UrlExpressionImpl urlExpression = new UrlExpressionImpl();
    return urlExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UrlElement createUrlElement()
  {
    UrlElementImpl urlElement = new UrlElementImpl();
    return urlElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UrlElementString createUrlElementString()
  {
    UrlElementStringImpl urlElementString = new UrlElementStringImpl();
    return urlElementString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UrlElementVariable createUrlElementVariable()
  {
    UrlElementVariableImpl urlElementVariable = new UrlElementVariableImpl();
    return urlElementVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RepositoryLocation createRepositoryLocation()
  {
    RepositoryLocationImpl repositoryLocation = new RepositoryLocationImpl();
    return repositoryLocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExcludeLocation createExcludeLocation()
  {
    ExcludeLocationImpl excludeLocation = new ExcludeLocationImpl();
    return excludeLocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariableDefinition createVariableDefinition()
  {
    VariableDefinitionImpl variableDefinition = new VariableDefinitionImpl();
    return variableDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AlreadyDeclaredVariable createAlreadyDeclaredVariable()
  {
    AlreadyDeclaredVariableImpl alreadyDeclaredVariable = new AlreadyDeclaredVariableImpl();
    return alreadyDeclaredVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NewVariableDefinition createNewVariableDefinition()
  {
    NewVariableDefinitionImpl newVariableDefinition = new NewVariableDefinitionImpl();
    return newVariableDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TargetmodelPackage getTargetmodelPackage()
  {
    return (TargetmodelPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TargetmodelPackage getPackage()
  {
    return TargetmodelPackage.eINSTANCE;
  }

} //TargetmodelFactoryImpl
