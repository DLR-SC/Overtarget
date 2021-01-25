/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.util

import java.net.URI
import org.eclipse.equinox.p2.metadata.IInstallableUnit

/**
 * This class loads dummy units for testing the class QueryManager
 */

class TestQueryManager extends QueryManager{
	
	var dummyUnits = new MockupQueryResult<IInstallableUnit>
	
	override doLoadUnits(URI uri) {
		return dummyUnits
	}
	
	def setUnits(MockupQueryResult<IInstallableUnit> dummyUnits) {
		this.dummyUnits = dummyUnits
	}
}