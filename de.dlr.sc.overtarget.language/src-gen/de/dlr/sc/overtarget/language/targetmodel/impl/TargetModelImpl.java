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
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl#getSuper <em>Super</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl#getImportedModels <em>Imported Models</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl#getOs <em>Os</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl#getWs <em>Ws</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl#getArch <em>Arch</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl#getLoc <em>Loc</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl#getTargetJre <em>Target Jre</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl#getExcludedLocations <em>Excluded Locations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetModelImpl extends TargetFileImpl implements TargetModel
{
  /**
   * The cached value of the '{@link #getSuper() <em>Super</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuper()
   * @generated
   * @ordered
   */
  protected TargetModel super_;

  /**
   * The cached value of the '{@link #getImportedModels() <em>Imported Models</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportedModels()
   * @generated
   * @ordered
   */
  protected EList<TargetFile> importedModels;

  /**
   * The default value of the '{@link #getOs() <em>Os</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOs()
   * @generated
   * @ordered
   */
  protected static final String OS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOs() <em>Os</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOs()
   * @generated
   * @ordered
   */
  protected String os = OS_EDEFAULT;

  /**
   * The default value of the '{@link #getWs() <em>Ws</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWs()
   * @generated
   * @ordered
   */
  protected static final String WS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getWs() <em>Ws</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWs()
   * @generated
   * @ordered
   */
  protected String ws = WS_EDEFAULT;

  /**
   * The default value of the '{@link #getArch() <em>Arch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArch()
   * @generated
   * @ordered
   */
  protected static final String ARCH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getArch() <em>Arch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArch()
   * @generated
   * @ordered
   */
  protected String arch = ARCH_EDEFAULT;

  /**
   * The default value of the '{@link #getLoc() <em>Loc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoc()
   * @generated
   * @ordered
   */
  protected static final String LOC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLoc() <em>Loc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoc()
   * @generated
   * @ordered
   */
  protected String loc = LOC_EDEFAULT;

  /**
   * The default value of the '{@link #getTargetJre() <em>Target Jre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetJre()
   * @generated
   * @ordered
   */
  protected static final String TARGET_JRE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTargetJre() <em>Target Jre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetJre()
   * @generated
   * @ordered
   */
  protected String targetJre = TARGET_JRE_EDEFAULT;

  /**
   * The cached value of the '{@link #getExcludedLocations() <em>Excluded Locations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExcludedLocations()
   * @generated
   * @ordered
   */
  protected EList<ExcludeLocation> excludedLocations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TargetModelImpl()
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
    return TargetmodelPackage.Literals.TARGET_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TargetModel getSuper()
  {
    if (super_ != null && super_.eIsProxy())
    {
      InternalEObject oldSuper = (InternalEObject)super_;
      super_ = (TargetModel)eResolveProxy(oldSuper);
      if (super_ != oldSuper)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetmodelPackage.TARGET_MODEL__SUPER, oldSuper, super_));
      }
    }
    return super_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TargetModel basicGetSuper()
  {
    return super_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSuper(TargetModel newSuper)
  {
    TargetModel oldSuper = super_;
    super_ = newSuper;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.TARGET_MODEL__SUPER, oldSuper, super_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TargetFile> getImportedModels()
  {
    if (importedModels == null)
    {
      importedModels = new EObjectResolvingEList<TargetFile>(TargetFile.class, this, TargetmodelPackage.TARGET_MODEL__IMPORTED_MODELS);
    }
    return importedModels;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOs()
  {
    return os;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOs(String newOs)
  {
    String oldOs = os;
    os = newOs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.TARGET_MODEL__OS, oldOs, os));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getWs()
  {
    return ws;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setWs(String newWs)
  {
    String oldWs = ws;
    ws = newWs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.TARGET_MODEL__WS, oldWs, ws));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getArch()
  {
    return arch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setArch(String newArch)
  {
    String oldArch = arch;
    arch = newArch;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.TARGET_MODEL__ARCH, oldArch, arch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLoc()
  {
    return loc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLoc(String newLoc)
  {
    String oldLoc = loc;
    loc = newLoc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.TARGET_MODEL__LOC, oldLoc, loc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getTargetJre()
  {
    return targetJre;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTargetJre(String newTargetJre)
  {
    String oldTargetJre = targetJre;
    targetJre = newTargetJre;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.TARGET_MODEL__TARGET_JRE, oldTargetJre, targetJre));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ExcludeLocation> getExcludedLocations()
  {
    if (excludedLocations == null)
    {
      excludedLocations = new EObjectContainmentEList<ExcludeLocation>(ExcludeLocation.class, this, TargetmodelPackage.TARGET_MODEL__EXCLUDED_LOCATIONS);
    }
    return excludedLocations;
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
      case TargetmodelPackage.TARGET_MODEL__EXCLUDED_LOCATIONS:
        return ((InternalEList<?>)getExcludedLocations()).basicRemove(otherEnd, msgs);
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
      case TargetmodelPackage.TARGET_MODEL__SUPER:
        if (resolve) return getSuper();
        return basicGetSuper();
      case TargetmodelPackage.TARGET_MODEL__IMPORTED_MODELS:
        return getImportedModels();
      case TargetmodelPackage.TARGET_MODEL__OS:
        return getOs();
      case TargetmodelPackage.TARGET_MODEL__WS:
        return getWs();
      case TargetmodelPackage.TARGET_MODEL__ARCH:
        return getArch();
      case TargetmodelPackage.TARGET_MODEL__LOC:
        return getLoc();
      case TargetmodelPackage.TARGET_MODEL__TARGET_JRE:
        return getTargetJre();
      case TargetmodelPackage.TARGET_MODEL__EXCLUDED_LOCATIONS:
        return getExcludedLocations();
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
      case TargetmodelPackage.TARGET_MODEL__SUPER:
        setSuper((TargetModel)newValue);
        return;
      case TargetmodelPackage.TARGET_MODEL__IMPORTED_MODELS:
        getImportedModels().clear();
        getImportedModels().addAll((Collection<? extends TargetFile>)newValue);
        return;
      case TargetmodelPackage.TARGET_MODEL__OS:
        setOs((String)newValue);
        return;
      case TargetmodelPackage.TARGET_MODEL__WS:
        setWs((String)newValue);
        return;
      case TargetmodelPackage.TARGET_MODEL__ARCH:
        setArch((String)newValue);
        return;
      case TargetmodelPackage.TARGET_MODEL__LOC:
        setLoc((String)newValue);
        return;
      case TargetmodelPackage.TARGET_MODEL__TARGET_JRE:
        setTargetJre((String)newValue);
        return;
      case TargetmodelPackage.TARGET_MODEL__EXCLUDED_LOCATIONS:
        getExcludedLocations().clear();
        getExcludedLocations().addAll((Collection<? extends ExcludeLocation>)newValue);
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
      case TargetmodelPackage.TARGET_MODEL__SUPER:
        setSuper((TargetModel)null);
        return;
      case TargetmodelPackage.TARGET_MODEL__IMPORTED_MODELS:
        getImportedModels().clear();
        return;
      case TargetmodelPackage.TARGET_MODEL__OS:
        setOs(OS_EDEFAULT);
        return;
      case TargetmodelPackage.TARGET_MODEL__WS:
        setWs(WS_EDEFAULT);
        return;
      case TargetmodelPackage.TARGET_MODEL__ARCH:
        setArch(ARCH_EDEFAULT);
        return;
      case TargetmodelPackage.TARGET_MODEL__LOC:
        setLoc(LOC_EDEFAULT);
        return;
      case TargetmodelPackage.TARGET_MODEL__TARGET_JRE:
        setTargetJre(TARGET_JRE_EDEFAULT);
        return;
      case TargetmodelPackage.TARGET_MODEL__EXCLUDED_LOCATIONS:
        getExcludedLocations().clear();
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
      case TargetmodelPackage.TARGET_MODEL__SUPER:
        return super_ != null;
      case TargetmodelPackage.TARGET_MODEL__IMPORTED_MODELS:
        return importedModels != null && !importedModels.isEmpty();
      case TargetmodelPackage.TARGET_MODEL__OS:
        return OS_EDEFAULT == null ? os != null : !OS_EDEFAULT.equals(os);
      case TargetmodelPackage.TARGET_MODEL__WS:
        return WS_EDEFAULT == null ? ws != null : !WS_EDEFAULT.equals(ws);
      case TargetmodelPackage.TARGET_MODEL__ARCH:
        return ARCH_EDEFAULT == null ? arch != null : !ARCH_EDEFAULT.equals(arch);
      case TargetmodelPackage.TARGET_MODEL__LOC:
        return LOC_EDEFAULT == null ? loc != null : !LOC_EDEFAULT.equals(loc);
      case TargetmodelPackage.TARGET_MODEL__TARGET_JRE:
        return TARGET_JRE_EDEFAULT == null ? targetJre != null : !TARGET_JRE_EDEFAULT.equals(targetJre);
      case TargetmodelPackage.TARGET_MODEL__EXCLUDED_LOCATIONS:
        return excludedLocations != null && !excludedLocations.isEmpty();
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
    result.append(" (os: ");
    result.append(os);
    result.append(", ws: ");
    result.append(ws);
    result.append(", arch: ");
    result.append(arch);
    result.append(", loc: ");
    result.append(loc);
    result.append(", targetJre: ");
    result.append(targetJre);
    result.append(')');
    return result.toString();
  }

} //TargetModelImpl
