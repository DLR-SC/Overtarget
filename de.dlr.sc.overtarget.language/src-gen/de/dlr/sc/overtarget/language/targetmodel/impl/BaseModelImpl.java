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

import de.dlr.sc.overtarget.language.targetmodel.BaseModel;
import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.targetmodel.VariableDefinition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getImportedModels <em>Imported Models</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getOs <em>Os</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getWs <em>Ws</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getArch <em>Arch</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getLoc <em>Loc</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getTargetJre <em>Target Jre</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getExcludedLocations <em>Excluded Locations</em>}</li>
 *   <li>{@link de.dlr.sc.overtarget.language.targetmodel.impl.BaseModelImpl#getRepositoryLocations <em>Repository Locations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BaseModelImpl extends MinimalEObjectImpl.Container implements BaseModel
{
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
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<VariableDefinition> variables;

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
   * The cached value of the '{@link #getRepositoryLocations() <em>Repository Locations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepositoryLocations()
   * @generated
   * @ordered
   */
  protected EList<RepositoryLocation> repositoryLocations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BaseModelImpl()
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
    return TargetmodelPackage.Literals.BASE_MODEL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.BASE_MODEL__NAME, oldName, name));
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
      importedModels = new EObjectResolvingEList<TargetFile>(TargetFile.class, this, TargetmodelPackage.BASE_MODEL__IMPORTED_MODELS);
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
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.BASE_MODEL__OS, oldOs, os));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.BASE_MODEL__WS, oldWs, ws));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.BASE_MODEL__ARCH, oldArch, arch));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.BASE_MODEL__LOC, oldLoc, loc));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TargetmodelPackage.BASE_MODEL__TARGET_JRE, oldTargetJre, targetJre));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<VariableDefinition> getVariables()
  {
    if (variables == null)
    {
      variables = new EObjectContainmentEList<VariableDefinition>(VariableDefinition.class, this, TargetmodelPackage.BASE_MODEL__VARIABLES);
    }
    return variables;
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
      excludedLocations = new EObjectContainmentEList<ExcludeLocation>(ExcludeLocation.class, this, TargetmodelPackage.BASE_MODEL__EXCLUDED_LOCATIONS);
    }
    return excludedLocations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<RepositoryLocation> getRepositoryLocations()
  {
    if (repositoryLocations == null)
    {
      repositoryLocations = new EObjectContainmentEList<RepositoryLocation>(RepositoryLocation.class, this, TargetmodelPackage.BASE_MODEL__REPOSITORY_LOCATIONS);
    }
    return repositoryLocations;
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
      case TargetmodelPackage.BASE_MODEL__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case TargetmodelPackage.BASE_MODEL__EXCLUDED_LOCATIONS:
        return ((InternalEList<?>)getExcludedLocations()).basicRemove(otherEnd, msgs);
      case TargetmodelPackage.BASE_MODEL__REPOSITORY_LOCATIONS:
        return ((InternalEList<?>)getRepositoryLocations()).basicRemove(otherEnd, msgs);
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
      case TargetmodelPackage.BASE_MODEL__NAME:
        return getName();
      case TargetmodelPackage.BASE_MODEL__IMPORTED_MODELS:
        return getImportedModels();
      case TargetmodelPackage.BASE_MODEL__OS:
        return getOs();
      case TargetmodelPackage.BASE_MODEL__WS:
        return getWs();
      case TargetmodelPackage.BASE_MODEL__ARCH:
        return getArch();
      case TargetmodelPackage.BASE_MODEL__LOC:
        return getLoc();
      case TargetmodelPackage.BASE_MODEL__TARGET_JRE:
        return getTargetJre();
      case TargetmodelPackage.BASE_MODEL__VARIABLES:
        return getVariables();
      case TargetmodelPackage.BASE_MODEL__EXCLUDED_LOCATIONS:
        return getExcludedLocations();
      case TargetmodelPackage.BASE_MODEL__REPOSITORY_LOCATIONS:
        return getRepositoryLocations();
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
      case TargetmodelPackage.BASE_MODEL__NAME:
        setName((String)newValue);
        return;
      case TargetmodelPackage.BASE_MODEL__IMPORTED_MODELS:
        getImportedModels().clear();
        getImportedModels().addAll((Collection<? extends TargetFile>)newValue);
        return;
      case TargetmodelPackage.BASE_MODEL__OS:
        setOs((String)newValue);
        return;
      case TargetmodelPackage.BASE_MODEL__WS:
        setWs((String)newValue);
        return;
      case TargetmodelPackage.BASE_MODEL__ARCH:
        setArch((String)newValue);
        return;
      case TargetmodelPackage.BASE_MODEL__LOC:
        setLoc((String)newValue);
        return;
      case TargetmodelPackage.BASE_MODEL__TARGET_JRE:
        setTargetJre((String)newValue);
        return;
      case TargetmodelPackage.BASE_MODEL__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends VariableDefinition>)newValue);
        return;
      case TargetmodelPackage.BASE_MODEL__EXCLUDED_LOCATIONS:
        getExcludedLocations().clear();
        getExcludedLocations().addAll((Collection<? extends ExcludeLocation>)newValue);
        return;
      case TargetmodelPackage.BASE_MODEL__REPOSITORY_LOCATIONS:
        getRepositoryLocations().clear();
        getRepositoryLocations().addAll((Collection<? extends RepositoryLocation>)newValue);
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
      case TargetmodelPackage.BASE_MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TargetmodelPackage.BASE_MODEL__IMPORTED_MODELS:
        getImportedModels().clear();
        return;
      case TargetmodelPackage.BASE_MODEL__OS:
        setOs(OS_EDEFAULT);
        return;
      case TargetmodelPackage.BASE_MODEL__WS:
        setWs(WS_EDEFAULT);
        return;
      case TargetmodelPackage.BASE_MODEL__ARCH:
        setArch(ARCH_EDEFAULT);
        return;
      case TargetmodelPackage.BASE_MODEL__LOC:
        setLoc(LOC_EDEFAULT);
        return;
      case TargetmodelPackage.BASE_MODEL__TARGET_JRE:
        setTargetJre(TARGET_JRE_EDEFAULT);
        return;
      case TargetmodelPackage.BASE_MODEL__VARIABLES:
        getVariables().clear();
        return;
      case TargetmodelPackage.BASE_MODEL__EXCLUDED_LOCATIONS:
        getExcludedLocations().clear();
        return;
      case TargetmodelPackage.BASE_MODEL__REPOSITORY_LOCATIONS:
        getRepositoryLocations().clear();
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
      case TargetmodelPackage.BASE_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TargetmodelPackage.BASE_MODEL__IMPORTED_MODELS:
        return importedModels != null && !importedModels.isEmpty();
      case TargetmodelPackage.BASE_MODEL__OS:
        return OS_EDEFAULT == null ? os != null : !OS_EDEFAULT.equals(os);
      case TargetmodelPackage.BASE_MODEL__WS:
        return WS_EDEFAULT == null ? ws != null : !WS_EDEFAULT.equals(ws);
      case TargetmodelPackage.BASE_MODEL__ARCH:
        return ARCH_EDEFAULT == null ? arch != null : !ARCH_EDEFAULT.equals(arch);
      case TargetmodelPackage.BASE_MODEL__LOC:
        return LOC_EDEFAULT == null ? loc != null : !LOC_EDEFAULT.equals(loc);
      case TargetmodelPackage.BASE_MODEL__TARGET_JRE:
        return TARGET_JRE_EDEFAULT == null ? targetJre != null : !TARGET_JRE_EDEFAULT.equals(targetJre);
      case TargetmodelPackage.BASE_MODEL__VARIABLES:
        return variables != null && !variables.isEmpty();
      case TargetmodelPackage.BASE_MODEL__EXCLUDED_LOCATIONS:
        return excludedLocations != null && !excludedLocations.isEmpty();
      case TargetmodelPackage.BASE_MODEL__REPOSITORY_LOCATIONS:
        return repositoryLocations != null && !repositoryLocations.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", os: ");
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

} //BaseModelImpl
