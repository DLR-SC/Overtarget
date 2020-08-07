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

import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.targetmodel.Unit;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl#isAddAll <em>Add All</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl#getSource <em>Source</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl#getVers <em>Vers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnitImpl extends MinimalEObjectImpl.Container implements Unit
{
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
   * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected String source = SOURCE_EDEFAULT;

  /**
   * The default value of the '{@link #getVers() <em>Vers</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVers()
   * @generated
   * @ordered
   */
  protected static final String VERS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVers() <em>Vers</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVers()
   * @generated
   * @ordered
   */
  protected String vers = VERS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnitImpl()
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
    return TargetmodelPackage.Literals.UNIT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.UNIT__ADD_ALL, oldAddAll, addAll));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSource(String newSource)
  {
    String oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.UNIT__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getVers()
  {
    return vers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVers(String newVers)
  {
    String oldVers = vers;
    vers = newVers;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.UNIT__VERS, oldVers, vers));
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
      case TargetmodelPackage.UNIT__ADD_ALL:
        return isAddAll();
      case TargetmodelPackage.UNIT__SOURCE:
        return getSource();
      case TargetmodelPackage.UNIT__VERS:
        return getVers();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TargetmodelPackage.UNIT__ADD_ALL:
        setAddAll((Boolean)newValue);
        return;
      case TargetmodelPackage.UNIT__SOURCE:
        setSource((String)newValue);
        return;
      case TargetmodelPackage.UNIT__VERS:
        setVers((String)newValue);
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
      case TargetmodelPackage.UNIT__ADD_ALL:
        setAddAll(ADD_ALL_EDEFAULT);
        return;
      case TargetmodelPackage.UNIT__SOURCE:
        setSource(SOURCE_EDEFAULT);
        return;
      case TargetmodelPackage.UNIT__VERS:
        setVers(VERS_EDEFAULT);
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
      case TargetmodelPackage.UNIT__ADD_ALL:
        return addAll != ADD_ALL_EDEFAULT;
      case TargetmodelPackage.UNIT__SOURCE:
        return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
      case TargetmodelPackage.UNIT__VERS:
        return VERS_EDEFAULT == null ? vers != null : !VERS_EDEFAULT.equals(vers);
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
    result.append(" (addAll: ");
    result.append(addAll);
    result.append(", source: ");
    result.append(source);
    result.append(", vers: ");
    result.append(vers);
    result.append(')');
    return result.toString();
  }

} //UnitImpl
