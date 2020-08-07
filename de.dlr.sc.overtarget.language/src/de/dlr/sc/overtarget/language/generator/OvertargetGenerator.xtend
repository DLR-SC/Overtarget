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

import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import de.dlr.sc.overtarget.language.targetmodel.Unit
import java.util.ArrayList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelper
import de.dlr.sc.overtarget.language.util.QueryManager

/**
 * Generates target files from tmodel files
 * 
 * 
 */
class OvertargetGenerator extends AbstractGenerator {
	static val DEFAULT_JRE_CONTAINER = "org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/";
	public static val TARGET_FILE_EXTENSION = ".target"
	val RefTargetHelper = new ReferencedTargetHelper

	/**
	 * This method generates a new target from a tmodel.
	 * If the tmodel has unresolved references, 
	 * it calls the method generateTargetToResolveReferences().
	 */
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (model : resource.allContents.toIterable.filter(TargetModel)) {
			EcoreUtil.resolveAll(resource) // resolve proxies in resource before checking if there are any unresolved references left
			if (RefTargetHelper.hasUnresolvedReferences(model)) {
				generateTargetToResolveReferences(model, fsa)
			} else {
				fsa.generateFile(model.name + TARGET_FILE_EXTENSION, OvertargetOutputConfigurationProvider.GENERATOR_OUTPUT_ID_OVERTARGET, model.compile)
			}
		}
	}

	/**
	 * This method generates a target with references to unresolved targets 
	 * and sets the target as active target in eclipse
	 *  -> unresolved references are resolved
	 * 
	 * @Param model original tmodel with unresolved references
	 * @Param fsa file system access
	 */
	
	def generateTargetToResolveReferences(TargetModel model, IFileSystemAccess2 fsa) {
		val tmodelWithReference = RefTargetHelper.getReferencedModelToGenerate(model)
		fsa.generateFile(tmodelWithReference.name + TARGET_FILE_EXTENSION, OvertargetOutputConfigurationProvider.GENERATOR_OUTPUT_ID_OVERTARGET, tmodelWithReference.compile)
	}

	/** 
	 * Compiles the target model into a file
	 */
	def CharSequence compile(TargetModel target) {
		arragenceProperties(target);
		addInheritedRepositories(target)
		printModel(target);
	}

	/**
	 * If properties are defined use them, if not, gets the properties from the super target model
	 */
	def arragenceProperties(TargetModel target) {
		target.os = GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__OS).toString;
		target.ws = GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__WS).toString;
		target.arch = GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__ARCH).toString;
		target.loc = GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__LOC).toString;
		target.targetJre = GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__TARGET_JRE).toString;
	}

	/**
	 * Checks if a location is not excluded by the target model and if so, 
	 * adds it to the list of locations
	 */
	def addIfNotExcluded(TargetModel model, ArrayList<RepositoryLocation> locations, RepositoryLocation location) {
		var repo = GeneratorHelper.isRepositoryExcluded(model.excludedLocations, location);
		if (repo !== null) {
			if (repo.units.length != 0) {
				GeneratorHelper.removeAllUnits(location, repo.units);
				if (location.units.length > 0) {
					GeneratorHelper.addLocationWithMerge(locations, location);
				}
			}
		} else {
			GeneratorHelper.addLocationWithMerge(locations, location);
		}
	}	

	/**
	 * Adds all inherited locations to the target model
	 */
	def addInheritedRepositories(TargetModel target){
		var locations = new ArrayList<RepositoryLocation>();
		var targetfiles = new ArrayList<TargetFile>;
		GeneratorHelper.getAllParentTargetFiles(target,targetfiles);
		for (TargetFile tm : targetfiles) {
			for (RepositoryLocation rl : tm.repositoryLocations) {
				addIfNotExcluded(target, locations, rl);
			}
		}
		for (RepositoryLocation rl : locations) {
			GeneratorHelper.addLocationWithMerge(target.repositoryLocations, rl);
		}
	}

/**
	 * If "addAll" is used, add all units to repository location
	 */
	def static addAllUnitsToRepositoryLocation(Unit unit) {
		var queryManager = new QueryManager()
		val allUnitsFromReposLoc = queryManager.getUnits(unit)
		return allUnitsFromReposLoc
	}

	/**
	 * replaces "newest" with "0.0.0"
	 */
	def printVersion(Unit unit){
		if(unit.vers.equals("newest")){
			return "0.0.0"
		}
		return unit.vers;
	}

	/**
	 * prints the target model
	 */
	def printModel(TargetModel target) {
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
					<?pde version="3.8"?><target name="«target.name»" sequenceNumber="1">
					<locations>
					«FOR repositoryLocation : target.repositoryLocations»
						<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
						«FOR unit : repositoryLocation.units»
							«IF unit.addAll»
								«val allUnitsFromReposLoc = addAllUnitsToRepositoryLocation(unit)»
								«FOR u : allUnitsFromReposLoc»
									<unit id="«u.source»" version="«printVersion(u)»"/>
								«ENDFOR»
							«ELSE»
							<unit id="«unit.source»" version="«printVersion(unit)»"/>
						«ENDIF»
						«ENDFOR»
						<repository location="«GeneratorHelper.getUrlAsString(repositoryLocation.url, target)»"/>
						</location>
					«ENDFOR»
					</locations>
					<environment>
					<os>«target.os»</os>
					<ws>«target.ws»</ws>
					<arch>«target.arch»</arch>
					<nl>«target.loc»</nl> 
					</environment>
					«getJRE(target)»
					</target>
		'''
	}

	/**
	 * prints the targetJRE
	 */
	def getJRE(TargetModel target) {
		if(target.targetJre === null){
			return "";
		} else {
			return "<targetJRE path="+ "\"" + de.dlr.sc.overtarget.language.generator.OvertargetGenerator.DEFAULT_JRE_CONTAINER + target.targetJre + "\"/>";
		}
	}
}