/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.generator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;

/**
 * Output Configuration provider that sets up output directories of XTend
 * generated output.
 * 
 * @author fisc_ph
 *
 */
public class OvertargetOutputConfigurationProvider implements IOutputConfigurationProvider {

	public static final String GENERATOR_OUTPUT_ID_OVERTARGET = "de.dlr.sc.overtarget.output";
	public static final String GENERATOR_OUTPUT_FOLDER_CONCEPT = "./";
	public static final String GENERATOR_OUTPUT_DESCRIPTION_OVERTARGET = "Xtend Overtarget Serialzation Output";
	
	public static final String GENERATOR_OUTPUT_ID_DEFAULT = IFileSystemAccess.DEFAULT_OUTPUT;
	public static final String GENERATOR_OUTPUT_FOLDER_DEFAULT = "./default-gen";
	public static final String GENERATOR_OUTPUT_DESCRIPTION_DEFAULT = "Xtend Default Output";

	/**
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	public Set<OutputConfiguration> getOutputConfigurations() {
		Set<OutputConfiguration> outputConfigurations = new HashSet<>();
		
		OutputConfiguration overtargetOutput = new OutputConfiguration(GENERATOR_OUTPUT_ID_OVERTARGET);
		overtargetOutput.setDescription(GENERATOR_OUTPUT_DESCRIPTION_OVERTARGET);
		overtargetOutput.setOutputDirectory(GENERATOR_OUTPUT_FOLDER_CONCEPT);
		overtargetOutput.setOverrideExistingResources(true);
		overtargetOutput.setCreateOutputDirectory(true);
		overtargetOutput.setCleanUpDerivedResources(false);
		overtargetOutput.setSetDerivedProperty(false);
		
		outputConfigurations.add(overtargetOutput);
		
		OutputConfiguration defaultOutput = new OutputConfiguration(GENERATOR_OUTPUT_ID_DEFAULT);
		defaultOutput.setDescription(GENERATOR_OUTPUT_DESCRIPTION_DEFAULT);
		defaultOutput.setOutputDirectory(GENERATOR_OUTPUT_FOLDER_DEFAULT);
		defaultOutput.setOverrideExistingResources(true);
		defaultOutput.setCreateOutputDirectory(true);
		defaultOutput.setCleanUpDerivedResources(false);
		defaultOutput.setSetDerivedProperty(false);
		
		outputConfigurations.add(defaultOutput);
		
		
		return outputConfigurations;
	}
}
