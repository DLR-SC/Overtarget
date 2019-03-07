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
package de.dlr.sc.overtarget.language.targetmodel.impl;

import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.targetmodel.Unit;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exclude Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.ExcludeLocationImpl#getRepositoryLocation <em>Repository Location</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.ExcludeLocationImpl#getUnits <em>Units</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExcludeLocationImpl extends MinimalEObjectImpl.Container implements ExcludeLocation
{
  /**
   * The cached value of the '{@link #getRepositoryLocation() <em>Repository Location</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepositoryLocation()
   * @generated
   * @ordered
   */
  protected RepositoryLocation repositoryLocation;

  /**
   * The cached value of the '{@link #getUnits() <em>Units</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnits()
   * @generated
   * @ordered
   */
  protected EList<Unit> units;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExcludeLocationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TargetmodelPackage.Literals.EXCLUDE_LOCATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RepositoryLocation getRepositoryLocation()
  {
    if (repositoryLocation != null && repositoryLocation.eIsProxy())
    {
      InternalEObject oldRepositoryLocation = (InternalEObject)repositoryLocation;
      repositoryLocation = (RepositoryLocation)eResolveProxy(oldRepositoryLocation);
      if (repositoryLocation != oldRepositoryLocation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetmodelPackage.EXCLUDE_LOCATION__REPOSITORY_LOCATION, oldRepositoryLocation, repositoryLocation));
      }
    }
    return repositoryLocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RepositoryLocation basicGetRepositoryLocation()
  {
    return repositoryLocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRepositoryLocation(RepositoryLocation newRepositoryLocation)
  {
    RepositoryLocation oldRepositoryLocation = repositoryLocation;
    repositoryLocation = newRepositoryLocation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.EXCLUDE_LOCATION__REPOSITORY_LOCATION, oldRepositoryLocation, repositoryLocation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Unit> getUnits()
  {
    if (units == null)
    {
      units = new EObjectContainmentEList<Unit>(Unit.class, this, TargetmodelPackage.EXCLUDE_LOCATION__UNITS);
    }
    return units;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TargetmodelPackage.EXCLUDE_LOCATION__UNITS:
        return ((InternalEList<?>)getUnits()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TargetmodelPackage.EXCLUDE_LOCATION__REPOSITORY_LOCATION:
        if (resolve) return getRepositoryLocation();
        return basicGetRepositoryLocation();
      case TargetmodelPackage.EXCLUDE_LOCATION__UNITS:
        return getUnits();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TargetmodelPackage.EXCLUDE_LOCATION__REPOSITORY_LOCATION:
        setRepositoryLocation((RepositoryLocation)newValue);
        return;
      case TargetmodelPackage.EXCLUDE_LOCATION__UNITS:
        getUnits().clear();
        getUnits().addAll((Collection<? extends Unit>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TargetmodelPackage.EXCLUDE_LOCATION__REPOSITORY_LOCATION:
        setRepositoryLocation((RepositoryLocation)null);
        return;
      case TargetmodelPackage.EXCLUDE_LOCATION__UNITS:
        getUnits().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TargetmodelPackage.EXCLUDE_LOCATION__REPOSITORY_LOCATION:
        return repositoryLocation != null;
      case TargetmodelPackage.EXCLUDE_LOCATION__UNITS:
        return units != null && !units.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExcludeLocationImpl
