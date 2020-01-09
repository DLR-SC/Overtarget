/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.generator;

import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import java.util.ArrayList;

/**
 * Generates target files from tmodel files
 */
@SuppressWarnings("all")
public class OvertargetGenerator /* implements AbstractGenerator  */{
  private static final String DEFAULT_JRE_CONTAINER = "org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/";
  
  @Override
  public void doGenerate(final /* Resource */Object resource, final /* IFileSystemAccess2 */Object fsa, final /* IGeneratorContext */Object context) {
    throw new Error("Unresolved compilation problems:"
      + "\nallContents cannot be resolved"
      + "\ntoIterable cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\ngenerateFile cannot be resolved"
      + "\nname cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ncompile cannot be resolved");
  }
  
  /**
   * Compiles the target model into a file
   */
  public CharSequence compile(final TargetModel target) {
    CharSequence _xblockexpression = null;
    {
      this.arragenceProperties(target);
      this.addInheritedRepositories(target);
      _xblockexpression = this.printModel(target);
    }
    return _xblockexpression;
  }
  
  /**
   * If properties are defined use them, if not, gets the properties from the super target model
   */
  public void arragenceProperties(final TargetModel target) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field TARGET_MODEL__OS is undefined for the type Class<Literals>"
      + "\nThe method or field TARGET_MODEL__WS is undefined for the type Class<Literals>"
      + "\nThe method or field TARGET_MODEL__ARCH is undefined for the type Class<Literals>"
      + "\nThe method or field TARGET_MODEL__LOC is undefined for the type Class<Literals>"
      + "\nThe method or field TARGET_MODEL__TARGET_JRE is undefined for the type Class<Literals>"
      + "\nThe method getAttribute(TargetModel, EAttribute) from the type GeneratorHelper refers to the missing type EAttribute"
      + "\nThe method getAttribute(TargetModel, EAttribute) from the type GeneratorHelper refers to the missing type EAttribute"
      + "\nThe method getAttribute(TargetModel, EAttribute) from the type GeneratorHelper refers to the missing type EAttribute"
      + "\nThe method getAttribute(TargetModel, EAttribute) from the type GeneratorHelper refers to the missing type EAttribute"
      + "\nThe method getAttribute(TargetModel, EAttribute) from the type GeneratorHelper refers to the missing type EAttribute");
  }
  
  /**
   * Checks if a location is not excluded by the target model and if so,
   * adds it to the list of locations
   */
  public boolean addIfNotExcluded(final TargetModel model, final ArrayList<RepositoryLocation> locations, final RepositoryLocation location) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field excludedLocations is undefined for the type TargetModel"
      + "\n!== cannot be resolved."
      + "\nThe method or field units is undefined for the type ExcludeLocation"
      + "\nThe method or field units is undefined for the type ExcludeLocation"
      + "\nThe method or field units is undefined for the type RepositoryLocation"
      + "\nThe method isRepositoryExcluded(EList, RepositoryLocation) from the type GeneratorHelper refers to the missing type EList"
      + "\nThe method removeAllUnits(RepositoryLocation, EList) from the type GeneratorHelper refers to the missing type Object"
      + "\nlength cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nlength cannot be resolved"
      + "\n> cannot be resolved");
  }
  
  /**
   * Adds all inherited locations to the target model
   */
  public void addInheritedRepositories(final TargetModel target) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field repositoryLocations is undefined for the type TargetFile"
      + "\nThe method or field repositoryLocations is undefined for the type TargetModel");
  }
  
  /**
   * replaces "newest" with "0.0.0"
   */
  public String printVersion(final Unit unit) {
    boolean _equals = unit.getVers().equals("newest");
    if (_equals) {
      return "0.0.0";
    }
    return unit.getVers();
  }
  
  /**
   * prints the target model
   */
  public CharSequence printModel(final TargetModel target) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field repositoryLocations is undefined for the type TargetModel"
      + "\nunits cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nurl cannot be resolved");
  }
  
  /**
   * prints the targetJRE
   */
  public String getJRE(final TargetModel target) {
    throw new Error("Unresolved compilation problems:"
      + "\n=== cannot be resolved."
      + "\n+ cannot be resolved."
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
}
