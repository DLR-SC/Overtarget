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
package de.dlr.sc.overtarget.language.targetmodel.util;

import de.dlr.sc.overtarget.language.targetmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage
 * @generated
 */
public class TargetmodelAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TargetmodelPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TargetmodelAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TargetmodelPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TargetmodelSwitch<Adapter> modelSwitch =
    new TargetmodelSwitch<Adapter>()
    {
      @Override
      public Adapter caseTargetFile(TargetFile object)
      {
        return createTargetFileAdapter();
      }
      @Override
      public Adapter caseTargetLibrary(TargetLibrary object)
      {
        return createTargetLibraryAdapter();
      }
      @Override
      public Adapter caseBaseModel(BaseModel object)
      {
        return createBaseModelAdapter();
      }
      @Override
      public Adapter caseTargetModel(TargetModel object)
      {
        return createTargetModelAdapter();
      }
      @Override
      public Adapter caseUnit(Unit object)
      {
        return createUnitAdapter();
      }
      @Override
      public Adapter caseUrlExpression(UrlExpression object)
      {
        return createUrlExpressionAdapter();
      }
      @Override
      public Adapter caseUrlElement(UrlElement object)
      {
        return createUrlElementAdapter();
      }
      @Override
      public Adapter caseUrlElementString(UrlElementString object)
      {
        return createUrlElementStringAdapter();
      }
      @Override
      public Adapter caseUrlElementVariable(UrlElementVariable object)
      {
        return createUrlElementVariableAdapter();
      }
      @Override
      public Adapter caseRepositoryLocation(RepositoryLocation object)
      {
        return createRepositoryLocationAdapter();
      }
      @Override
      public Adapter caseExcludeLocation(ExcludeLocation object)
      {
        return createExcludeLocationAdapter();
      }
      @Override
      public Adapter caseVariableDefinition(VariableDefinition object)
      {
        return createVariableDefinitionAdapter();
      }
      @Override
      public Adapter caseAlreadyDeclaredVariable(AlreadyDeclaredVariable object)
      {
        return createAlreadyDeclaredVariableAdapter();
      }
      @Override
      public Adapter caseNewVariableDefinition(NewVariableDefinition object)
      {
        return createNewVariableDefinitionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.TargetFile <em>Target File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetFile
   * @generated
   */
  public Adapter createTargetFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.TargetLibrary <em>Target Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetLibrary
   * @generated
   */
  public Adapter createTargetLibraryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.BaseModel <em>Base Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.BaseModel
   * @generated
   */
  public Adapter createBaseModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.TargetModel <em>Target Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.TargetModel
   * @generated
   */
  public Adapter createTargetModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.Unit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.Unit
   * @generated
   */
  public Adapter createUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.UrlExpression <em>Url Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlExpression
   * @generated
   */
  public Adapter createUrlExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.UrlElement <em>Url Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlElement
   * @generated
   */
  public Adapter createUrlElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.UrlElementString <em>Url Element String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlElementString
   * @generated
   */
  public Adapter createUrlElementStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable <em>Url Element Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable
   * @generated
   */
  public Adapter createUrlElementVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation <em>Repository Location</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
   * @generated
   */
  public Adapter createRepositoryLocationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation <em>Exclude Location</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation
   * @generated
   */
  public Adapter createExcludeLocationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.VariableDefinition
   * @generated
   */
  public Adapter createVariableDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable <em>Already Declared Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable
   * @generated
   */
  public Adapter createAlreadyDeclaredVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dlr.sc.overtarget.language.targetmodel.NewVariableDefinition <em>New Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dlr.sc.overtarget.language.targetmodel.NewVariableDefinition
   * @generated
   */
  public Adapter createNewVariableDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //TargetmodelAdapterFactory
