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

import com.google.common.base.Objects;
import de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable;
import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation;
import de.dlr.sc.overtarget.language.targetmodel.NewVariableDefinition;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.targetmodel.UrlElementString;
import de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable;
import de.dlr.sc.overtarget.language.targetmodel.UrlExpression;
import de.dlr.sc.overtarget.language.targetmodel.VariableDefinition;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;

/**
 * This class processes the model data for generation
 */
@SuppressWarnings("all")
public class GeneratorHelper {
  /**
   * Adds the units in the other repository into the target repository
   */
  public static boolean mergeUnits(final RepositoryLocation targetRep, final RepositoryLocation otherRep) {
    boolean _xifexpression = false;
    String _name = targetRep.getName();
    String _name_1 = otherRep.getName();
    boolean _equals = Objects.equal(_name, _name_1);
    if (_equals) {
      boolean _xblockexpression = false;
      {
        ArrayList<Unit> unitsToAdd = new ArrayList<Unit>();
        EList<Unit> _units = otherRep.getUnits();
        for (final Unit otherUnit : _units) {
          boolean _containsUnit = GeneratorHelper.containsUnit(otherUnit, targetRep);
          boolean _not = (!_containsUnit);
          if (_not) {
            unitsToAdd.add(otherUnit);
          }
        }
        _xblockexpression = targetRep.getUnits().addAll(unitsToAdd);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  /**
   * Checks if a unit exists in a repository
   */
  public static boolean containsUnit(final Unit unit, final RepositoryLocation location) {
    EList<Unit> _units = location.getUnits();
    for (final Unit repUnit : _units) {
      if ((Objects.equal(repUnit.getSource(), unit.getSource()) && repUnit.getVers().equals(unit.getVers()))) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Removes all units in the repositoryLocation
   */
  public static boolean removeAllUnits(final RepositoryLocation location, final EList<Unit> list) {
    boolean _xblockexpression = false;
    {
      final ArrayList<Unit> toRemove = new ArrayList<Unit>();
      EList<Unit> _units = location.getUnits();
      for (final Unit unit : _units) {
        for (final Unit unit2 : list) {
          if ((unit.getSource().equals(unit2.getSource()) && unit.getVers().equals(unit2.getVers()))) {
            toRemove.add(unit);
          }
        }
      }
      _xblockexpression = location.getUnits().removeAll(toRemove);
    }
    return _xblockexpression;
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
    boolean _xblockexpression = false;
    {
      RepositoryLocation locationToAdd = GeneratorHelper.contains(locations, location);
      boolean _xifexpression = false;
      if ((locationToAdd == null)) {
        _xifexpression = locations.add(location);
      } else {
        _xifexpression = GeneratorHelper.mergeUnits(locationToAdd, location);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * If the ExcludedLocation list contains the repositoryLocation, returns it, otherwise returns null
   */
  public static ExcludeLocation isRepositoryExcluded(final EList<ExcludeLocation> list, final RepositoryLocation location) {
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
  public static Object getAttribute(final TargetModel target, final EAttribute attribute) {
    final Object attr = target.eGet(attribute);
    if ((attr != null)) {
      return attr;
    } else {
      TargetModel _super = target.getSuper();
      boolean _tripleNotEquals = (_super != null);
      if (_tripleNotEquals) {
        return GeneratorHelper.getAttribute(target.getSuper(), attribute);
      } else {
        return "";
      }
    }
  }
  
  /**
   * Gets all super target files of a given target model
   */
  public static Object getAllParentTargetFiles(final TargetModel target, final ArrayList<TargetFile> targetfiles) {
    boolean _xblockexpression = false;
    {
      TargetModel _super = target.getSuper();
      boolean _tripleNotEquals = (_super != null);
      if (_tripleNotEquals) {
        GeneratorHelper.getAllParentTargetFiles(target.getSuper(), targetfiles);
        targetfiles.add(target.getSuper());
      }
      EList<TargetFile> _importedModels = target.getImportedModels();
      for (final TargetFile tf : _importedModels) {
        if ((tf instanceof TargetModel)) {
          GeneratorHelper.getAllParentTargetFiles(((TargetModel)tf), targetfiles);
        }
      }
      _xblockexpression = targetfiles.addAll(target.getImportedModels());
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  /**
   * If the Url is an variable it looks if its overwritten or not and returns the correct value.
   */
  public static String getVariableValue(final UrlElementVariable url, final TargetFile target) {
    final ArrayList<AlreadyDeclaredVariable> overrides = new ArrayList<AlreadyDeclaredVariable>();
    EList<VariableDefinition> _variables = target.getVariables();
    for (final VariableDefinition variable : _variables) {
      if ((variable instanceof AlreadyDeclaredVariable)) {
        overrides.add(((AlreadyDeclaredVariable)variable));
      }
    }
    VariableDefinition variable_1 = ((UrlElementVariable) url).getContent();
    for (final AlreadyDeclaredVariable alreadyDeclaredVariable : overrides) {
      NewVariableDefinition _ref = alreadyDeclaredVariable.getRef();
      boolean _tripleEquals = (_ref == variable_1);
      if (_tripleEquals) {
        return alreadyDeclaredVariable.getValue();
      }
    }
    return variable_1.getValue();
  }
  
  /**
   * Evaluates an URL Expression containing variables.
   */
  public static String getUrlAsString(final UrlExpression url, final TargetFile target) {
    if ((url instanceof UrlElementString)) {
      return ((UrlElementString) url).getContent();
    }
    if ((url instanceof UrlElementVariable)) {
      return GeneratorHelper.getVariableValue(((UrlElementVariable)url), target);
    }
    String _urlAsString = GeneratorHelper.getUrlAsString(url.getLeft(), target);
    String _urlAsString_1 = GeneratorHelper.getUrlAsString(url.getRight(), target);
    return (_urlAsString + _urlAsString_1);
  }
}
