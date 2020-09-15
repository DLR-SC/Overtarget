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

import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.targetmodel.UrlExpression;

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
 * An implementation of the model object '<em><b>Repository Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.RepositoryLocationImpl#isReferencedTarget <em>Referenced Target</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.RepositoryLocationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.RepositoryLocationImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.RepositoryLocationImpl#isAddAll <em>Add All</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.RepositoryLocationImpl#getUnits <em>Units</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryLocationImpl extends MinimalEObjectImpl.Container implements RepositoryLocation
{
  /**
   * The default value of the '{@link #isReferencedTarget() <em>Referenced Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReferencedTarget()
   * @generated
   * @ordered
   */
  protected static final boolean REFERENCED_TARGET_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isReferencedTarget() <em>Referenced Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReferencedTarget()
   * @generated
   * @ordered
   */
  protected boolean referencedTarget = REFERENCED_TARGET_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getUrl() <em>Url</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrl()
   * @generated
   * @ordered
   */
  protected UrlExpression url;

  /**
   * The default value of the '{@link #isAddAll() <em>Add All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAddAll()
   * @generated
   * @ordered
   */
  protected static final boolean ADD_ALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAddAll() <em>Add All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAddAll()
   * @generated
   * @ordered
   */
  protected boolean addAll = ADD_ALL_EDEFAULT;

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
  protected RepositoryLocationImpl()
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
    return TargetmodelPackage.Literals.REPOSITORY_LOCATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isReferencedTarget()
  {
    return referencedTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReferencedTarget(boolean newReferencedTarget)
  {
    boolean oldReferencedTarget = referencedTarget;
    referencedTarget = newReferencedTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.REPOSITORY_LOCATION__REFERENCED_TARGET, oldReferencedTarget, referencedTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.REPOSITORY_LOCATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UrlExpression getUrl()
  {
    return url;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUrl(UrlExpression newUrl, NotificationChain msgs)
  {
    UrlExpression oldUrl = url;
    url = newUrl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetmodelPackage.REPOSITORY_LOCATION__URL, oldUrl, newUrl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUrl(UrlExpression newUrl)
  {
    if (newUrl != url)
    {
      NotificationChain msgs = null;
      if (url != null)
        msgs = ((InternalEObject)url).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetmodelPackage.REPOSITORY_LOCATION__URL, null, msgs);
      if (newUrl != null)
        msgs = ((InternalEObject)newUrl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetmodelPackage.REPOSITORY_LOCATION__URL, null, msgs);
      msgs = basicSetUrl(newUrl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.REPOSITORY_LOCATION__URL, newUrl, newUrl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAddAll()
  {
    return addAll;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAddAll(boolean newAddAll)
  {
    boolean oldAddAll = addAll;
    addAll = newAddAll;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.REPOSITORY_LOCATION__ADD_ALL, oldAddAll, addAll));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Unit> getUnits()
  {
    if (units == null)
    {
      units = new EObjectContainmentEList<Unit>(Unit.class, this, TargetmodelPackage.REPOSITORY_LOCATION__UNITS);
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
      case TargetmodelPackage.REPOSITORY_LOCATION__URL:
        return basicSetUrl(null, msgs);
      case TargetmodelPackage.REPOSITORY_LOCATION__UNITS:
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
      case TargetmodelPackage.REPOSITORY_LOCATION__REFERENCED_TARGET:
        return isReferencedTarget();
      case TargetmodelPackage.REPOSITORY_LOCATION__NAME:
        return getName();
      case TargetmodelPackage.REPOSITORY_LOCATION__URL:
        return getUrl();
      case TargetmodelPackage.REPOSITORY_LOCATION__ADD_ALL:
        return isAddAll();
      case TargetmodelPackage.REPOSITORY_LOCATION__UNITS:
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
      case TargetmodelPackage.REPOSITORY_LOCATION__REFERENCED_TARGET:
        setReferencedTarget((Boolean)newValue);
        return;
      case TargetmodelPackage.REPOSITORY_LOCATION__NAME:
        setName((String)newValue);
        return;
      case TargetmodelPackage.REPOSITORY_LOCATION__URL:
        setUrl((UrlExpression)newValue);
        return;
      case TargetmodelPackage.REPOSITORY_LOCATION__ADD_ALL:
        setAddAll((Boolean)newValue);
        return;
      case TargetmodelPackage.REPOSITORY_LOCATION__UNITS:
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
      case TargetmodelPackage.REPOSITORY_LOCATION__REFERENCED_TARGET:
        setReferencedTarget(REFERENCED_TARGET_EDEFAULT);
        return;
      case TargetmodelPackage.REPOSITORY_LOCATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TargetmodelPackage.REPOSITORY_LOCATION__URL:
        setUrl((UrlExpression)null);
        return;
      case TargetmodelPackage.REPOSITORY_LOCATION__ADD_ALL:
        setAddAll(ADD_ALL_EDEFAULT);
        return;
      case TargetmodelPackage.REPOSITORY_LOCATION__UNITS:
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
      case TargetmodelPackage.REPOSITORY_LOCATION__REFERENCED_TARGET:
        return referencedTarget != REFERENCED_TARGET_EDEFAULT;
      case TargetmodelPackage.REPOSITORY_LOCATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TargetmodelPackage.REPOSITORY_LOCATION__URL:
        return url != null;
      case TargetmodelPackage.REPOSITORY_LOCATION__ADD_ALL:
        return addAll != ADD_ALL_EDEFAULT;
      case TargetmodelPackage.REPOSITORY_LOCATION__UNITS:
        return units != null && !units.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (referencedTarget: ");
    result.append(referencedTarget);
    result.append(", name: ");
    result.append(name);
    result.append(", addAll: ");
    result.append(addAll);
    result.append(')');
    return result.toString();
  }

} //RepositoryLocationImpl
