/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.dlr.sc.overtarget.language.validation.OvertargetValidatorTest;
import de.dlr.sc.overtarget.language.generator.GeneratorHelperTest;
import de.dlr.sc.overtarget.language.util.QueryManagerTest;
import de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelperTest;
import de.dlr.sc.overtarget.language.util.TargetFileHandlerTest;
import junit.framework.JUnit4TestAdapter;

/** * */
@RunWith(Suite.class)
@SuiteClasses({ 
	OvertargetParsingTest.class,
	OvertargetValidatorTest.class, 
	GeneratorHelperTest.class,
	QueryManagerTest.class,
	ReferencedTargetHelperTest.class,
	TargetFileHandlerTest.class
	})
/** * * Test Collection * */
public class AllTests {
	/** * Constructor */
	private AllTests() {
	}

	/** * Test Adapter *
	 * @return Executable JUnit Tests 
	 * */
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(AllTests.class);
	}
}