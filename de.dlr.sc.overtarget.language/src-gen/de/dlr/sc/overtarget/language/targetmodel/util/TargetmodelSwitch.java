/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.targetmodel.util;

import de.dlr.sc.overtarget.language.targetmodel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage
 * @generated
 */
public class TargetmodelSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TargetmodelPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TargetmodelSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TargetmodelPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case TargetmodelPackage.TARGET_FILE:
      {
        TargetFile targetFile = (TargetFile)theEObject;
        T result = caseTargetFile(targetFile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.TARGET_LIBRARY:
      {
        TargetLibrary targetLibrary = (TargetLibrary)theEObject;
        T result = caseTargetLibrary(targetLibrary);
        if (result == null) result = caseTargetFile(targetLibrary);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.BASE_MODEL:
      {
        BaseModel baseModel = (BaseModel)theEObject;
        T result = caseBaseModel(baseModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.TARGET_MODEL:
      {
        TargetModel targetModel = (TargetModel)theEObject;
        T result = caseTargetModel(targetModel);
        if (result == null) result = caseTargetFile(targetModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.UNIT:
      {
        Unit unit = (Unit)theEObject;
        T result = caseUnit(unit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.URL_EXPRESSION:
      {
        UrlExpression urlExpression = (UrlExpression)theEObject;
        T result = caseUrlExpression(urlExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.URL_ELEMENT:
      {
        UrlElement urlElement = (UrlElement)theEObject;
        T result = caseUrlElement(urlElement);
        if (result == null) result = caseUrlExpression(urlElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.URL_ELEMENT_STRING:
      {
        UrlElementString urlElementString = (UrlElementString)theEObject;
        T result = caseUrlElementString(urlElementString);
        if (result == null) result = caseUrlElement(urlElementString);
        if (result == null) result = caseUrlExpression(urlElementString);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.URL_ELEMENT_VARIABLE:
      {
        UrlElementVariable urlElementVariable = (UrlElementVariable)theEObject;
        T result = caseUrlElementVariable(urlElementVariable);
        if (result == null) result = caseUrlElement(urlElementVariable);
        if (result == null) result = caseUrlExpression(urlElementVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.REPOSITORY_LOCATION:
      {
        RepositoryLocation repositoryLocation = (RepositoryLocation)theEObject;
        T result = caseRepositoryLocation(repositoryLocation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.EXCLUDE_LOCATION:
      {
        ExcludeLocation excludeLocation = (ExcludeLocation)theEObject;
        T result = caseExcludeLocation(excludeLocation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.VARIABLE_DEFINITION:
      {
        VariableDefinition variableDefinition = (VariableDefinition)theEObject;
        T result = caseVariableDefinition(variableDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.ALREADY_DECLARED_VARIABLE:
      {
        AlreadyDeclaredVariable alreadyDeclaredVariable = (AlreadyDeclaredVariable)theEObject;
        T result = caseAlreadyDeclaredVariable(alreadyDeclaredVariable);
        if (result == null) result = caseVariableDefinition(alreadyDeclaredVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TargetmodelPackage.NEW_VARIABLE_DEFINITION:
      {
        NewVariableDefinition newVariableDefinition = (NewVariableDefinition)theEObject;
        T result = caseNewVariableDefinition(newVariableDefinition);
        if (result == null) result = caseVariableDefinition(newVariableDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Target File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Target File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTargetFile(TargetFile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Target Library</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Target Library</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTargetLibrary(TargetLibrary object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Base Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Base Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBaseModel(BaseModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Target Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Target Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTargetModel(TargetModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnit(Unit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Url Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Url Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUrlExpression(UrlExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Url Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Url Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUrlElement(UrlElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Url Element String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Url Element String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUrlElementString(UrlElementString object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Url Element Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Url Element Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUrlElementVariable(UrlElementVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Repository Location</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Repository Location</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRepositoryLocation(RepositoryLocation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exclude Location</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exclude Location</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExcludeLocation(ExcludeLocation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDefinition(VariableDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Already Declared Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Already Declared Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlreadyDeclaredVariable(AlreadyDeclaredVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>New Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>New Variable Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNewVariableDefinition(NewVariableDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //TargetmodelSwitch
