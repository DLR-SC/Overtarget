/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.junit.Test;

import de.dlr.sc.overtarget.language.generator.OvertargetOutputConfigurationProvider;
/**
 * Testcase for OvertargetOutputConfigurationProvider
 * @author kuja_tj
 *
 */
public class OvertargetOutputConfigurationProviderTest {

	@Test
	public void testGetOutputConfigurations() {
		final int NUMBER_OF_OUTPUTS = 2;

		final String GENERATOR_OUTPUT_ID_OVERTARGET = "de.dlr.sc.overtarget.output";
		final String GENERATOR_OUTPUT_FOLDER_CONCEPT = "./";
		final String GENERATOR_OUTPUT_DESCRIPTION_CONCEPT = "Xtend Overtarget Serialzation Output";

		final String GENERATOR_OUTPUT_ID_DEFAULT = IFileSystemAccess.DEFAULT_OUTPUT;
		final String GENERATOR_OUTPUT_FOLDER_DEFAULT = "./default-gen";
		final String GENERATOR_OUTPUT_DESCRIPTION_DEFAULT = "Xtend Default Output";
		
		OvertargetOutputConfigurationProvider oocp = new OvertargetOutputConfigurationProvider();
		Set<OutputConfiguration> outputConfigurations = oocp.getOutputConfigurations();
		
		assertEquals("The number of Output Configurations is correct", NUMBER_OF_OUTPUTS, outputConfigurations.size());

		for (OutputConfiguration outputConf : outputConfigurations) {
			String confName = outputConf.getName();
			switch (confName) {
				case GENERATOR_OUTPUT_ID_OVERTARGET:
					assertEquals("Description is set correctly", GENERATOR_OUTPUT_DESCRIPTION_CONCEPT, outputConf.getDescription());
					assertEquals("Folder is set correctly", GENERATOR_OUTPUT_FOLDER_CONCEPT, outputConf.getOutputDirectory());
					assertTrue("OverrideExistingResources is set correctly", outputConf.isOverrideExistingResources());
					assertTrue("CreateOutputDirectory is set correctly", outputConf.isCreateOutputDirectory());
					assertFalse("CleanUpDerivedResources is set correctly", outputConf.isCleanUpDerivedResources());
					assertFalse("SetDerivedProperty is set correctly", outputConf.isSetDerivedProperty());
					break;
				case GENERATOR_OUTPUT_ID_DEFAULT:
					assertEquals("Description is set correctly", GENERATOR_OUTPUT_DESCRIPTION_DEFAULT, outputConf.getDescription());
					assertEquals("Folder is set correctly", GENERATOR_OUTPUT_FOLDER_DEFAULT, outputConf.getOutputDirectory());
					assertTrue("OverrideExistingResources is set correctly", outputConf.isOverrideExistingResources());
					assertTrue("CreateOutputDirectory is set correctly", outputConf.isCreateOutputDirectory());
					assertFalse("CleanUpDerivedResources is set correctly", outputConf.isCleanUpDerivedResources());
					assertFalse("SetDerivedProperty is set correctly", outputConf.isSetDerivedProperty());
					break;
				default:
					assertTrue("All names are correct", false);
					break;
			}
		}
	}
}
	
