/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.generator

import de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable
import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import de.dlr.sc.overtarget.language.targetmodel.Unit
import de.dlr.sc.overtarget.language.targetmodel.UrlElementString
import de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable
import de.dlr.sc.overtarget.language.targetmodel.UrlExpression
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EAttribute
import de.dlr.sc.overtarget.language.util.QueryManager

/**
 * This class processes the model data for generation
 */
class GeneratorHelper {
	
	/**
	 * Adds the units in the other repository into the target repository
	 */
	def static mergeUnits(RepositoryLocation targetRep, RepositoryLocation otherRep) {
		if (targetRep.name == otherRep.name) {
			var unitsToAdd = new ArrayList<Unit>();
			for (Unit otherUnit : otherRep.units) {
				if (!containsUnit(otherUnit, targetRep)) {
					unitsToAdd.add(otherUnit);
				}
			}
			targetRep.units.addAll(unitsToAdd);
		}
	}
	
	/**
	 * Checks if a unit exists in a repository
	 */
	def static containsUnit(Unit unit, RepositoryLocation location) {
		for (Unit repUnit : location.units) {
			if (repUnit.source == unit.source && repUnit.vers.equals(unit.vers)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * Removes all units in the repositoryLocation
	 */
	def static removeAllUnits(RepositoryLocation location, EList<Unit> list) {
		val toRemove = new ArrayList<Unit>();
		for (Unit unit : location.units) {
			for (Unit unit2 : list) {
				if (unit.source.equals(unit2.source) && unit.vers.equals(unit2.vers)) {
					toRemove.add(unit);
				}
			}
		}
		location.units.removeAll(toRemove);
	}
	
	/**
	 * Checks if a given list contains a repository by name
	 */
	def static contains(List<RepositoryLocation> locations, RepositoryLocation location) {
		for (loc : locations) {
			if (loc.name.equals(location.name)) {
				return loc;
			}
		}
		return null;
	}
	
	/**
	 * If the location is not in the list, simply adds it. 
	 * If it is in the list, merges the units.
	 */
	def static addLocationWithMerge(List<RepositoryLocation> locations, RepositoryLocation location){
		var locationToAdd = contains(locations, location);
		if (locationToAdd === null) {
			locations.add(location);
		} else {
			mergeUnits(locationToAdd, location);
		}
	}
	
	/**
	 * If the ExcludedLocation list contains the repositoryLocation, returns it, otherwise returns null
	 */
	def static isRepositoryExcluded(EList<ExcludeLocation> list, RepositoryLocation location) {
		for (ExcludeLocation el : list) {
			if (el.repositoryLocation.equals(location)) {
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
	def static Object getAttribute(TargetModel target, EAttribute attribute){
		val attr = target.eGet(attribute);
		if(attr !== null){
			return attr; 
		} else if( target.super !== null){
			return getAttribute(target.super, attribute);
		} else {
			return "";
		}
	}
	
	/**
	 * Gets all super target files of a given target model
	 */
	def static Object getAllParentTargetFiles(TargetModel target, ArrayList<TargetFile> targetfiles){
		if (target.super !== null){
			getAllParentTargetFiles(target.super, targetfiles);
			targetfiles.add(target.super);
		}	
			
		for (TargetFile tf : target.importedModels){
			if(tf instanceof TargetModel){
				getAllParentTargetFiles(tf,targetfiles);
			}
		}
		targetfiles.addAll(target.importedModels);
	}
	
	/**
	 * If the Url is an variable it looks if its overwritten or not and returns the correct value.
	 */
	def static String getVariableValue(UrlElementVariable url, TargetFile target){
		val overrides = new ArrayList<AlreadyDeclaredVariable>();
		for(variable : target.variables) {
			if (variable instanceof AlreadyDeclaredVariable){
				overrides.add(variable);
			}
		}
		var variable = (url as UrlElementVariable).content;
		for (alreadyDeclaredVariable : overrides) {
			if (alreadyDeclaredVariable.ref === variable) {
				return alreadyDeclaredVariable.value;
			} 
		}
		return variable.value
	}
	
	/**
	 * Evaluates an URL Expression containing variables.
	 */
	def static String getUrlAsString(UrlExpression url, TargetFile target) {
		if (url instanceof UrlElementString) {
			return (url as UrlElementString).content;
		}
		if (url instanceof UrlElementVariable){
			return getVariableValue(url, target);
		}

		return getUrlAsString(url.left, target) + getUrlAsString(url.right, target)
	}
}
