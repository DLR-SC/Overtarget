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

import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable;
import de.dlr.sc.overtarget.language.targetmodel.UrlExpression;
import java.util.ArrayList;
import java.util.List;

/**
 * This class processes the model data for generation
 */
@SuppressWarnings("all")
public class GeneratorHelper {
  /**
   * Adds the units in the other repository into the target repository
   */
  public static Object mergeUnits(final RepositoryLocation targetRep, final RepositoryLocation otherRep) {
    throw new Error("Unresolved compilation problems:"
      + "\n== cannot be resolved."
      + "\nThe method or field units is undefined for the type RepositoryLocation"
      + "\n! cannot be resolved."
      + "\nThe method or field units is undefined for the type RepositoryLocation"
      + "\naddAll cannot be resolved");
  }
  
  /**
   * Checks if a unit exists in a repository
   */
  public static boolean containsUnit(final Unit unit, final RepositoryLocation location) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field units is undefined for the type RepositoryLocation"
      + "\n== cannot be resolved."
      + "\n&& cannot be resolved");
  }
  
  /**
   * Removes all units in the repositoryLocation
   */
  public static Object removeAllUnits(final RepositoryLocation location, final /* EList<Unit> */Object list) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field units is undefined for the type RepositoryLocation"
      + "\n&& cannot be resolved."
      + "\nThe method or field units is undefined for the type RepositoryLocation"
      + "\nremoveAll cannot be resolved");
  }
  
  /**
   * Checks if a given list contains a repository by name
   */
  public static RepositoryLocation contains(final List<RepositoryLocation> locations, final RepositoryLocation location) {
    for (final RepositoryLocation loc : locations) {
      boolean _equals = loc.getName().equals(location.getName());
      if (_equals) {
        return loc;
      }
    }
    return null;
  }
  
  /**
   * If the location is not in the list, simply adds it.
   * If it is in the list, merges the units.
   */
  public static boolean addLocationWithMerge(final List<RepositoryLocation> locations, final RepositoryLocation location) {
    throw new Error("Unresolved compilation problems:"
      + "\n=== cannot be resolved."
      + "\nThe method mergeUnits(RepositoryLocation, RepositoryLocation) from the type GeneratorHelper refers to the missing type Object");
  }
  
  /**
   * If the ExcludedLocation list contains the repositoryLocation, returns it, otherwise returns null
   */
  public static ExcludeLocation isRepositoryExcluded(final /* EList<ExcludeLocation> */Object list, final RepositoryLocation location) {
    for (final ExcludeLocation el : list) {
      boolean _equals = el.getRepositoryLocation().equals(location);
      if (_equals) {
        return el;
      }
    }
    return null;
  }
  
  /**
   * Generic method for obtaining the value of an attribute from a target model
   * while resolving inheritance. If the value is not defined in the model,
   * it will check the super target model.
   * Returns the attribute value of the target model, or that of the parent model if its undefined
   */
  public static Object getAttribute(final TargetModel target, final /* EAttribute */Object attribute) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method eGet(EAttribute) is undefined for the type TargetModel"
      + "\n!== cannot be resolved."
      + "\nThe method getAttribute(TargetModel, EAttribute) from the type GeneratorHelper refers to the missing type EAttribute"
      + "\n!== cannot be resolved");
  }
  
  /**
   * Gets all super target files of a given target model
   */
  public static Object getAllParentTargetFiles(final TargetModel target, final ArrayList<TargetFile> targetfiles) {
    throw new Error("Unresolved compilation problems:"
      + "\n!== cannot be resolved."
      + "\nThe method or field importedModels is undefined for the type TargetModel"
      + "\nThe method or field importedModels is undefined for the type TargetModel");
  }
  
  /**
   * If the Url is an variable it looks if its overwritten or not and returns the correct value.
   */
  public static String getVariableValue(final UrlElementVariable url, final TargetFile target) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field variables is undefined for the type TargetFile"
      + "\n=== cannot be resolved.");
  }
  
  /**
   * Evaluates an URL Expression containing variables.
   */
  public static String getUrlAsString(final UrlExpression url, final TargetFile target) {
    throw new Error("Unresolved compilation problems:"
      + "\n+ cannot be resolved.");
  }
}
