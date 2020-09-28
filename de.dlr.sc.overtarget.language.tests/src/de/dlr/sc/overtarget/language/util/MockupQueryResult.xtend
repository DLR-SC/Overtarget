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

import java.util.ArrayList
import org.eclipse.equinox.p2.query.IQueryResult
import org.eclipse.equinox.p2.query.IQuery
import org.eclipse.core.runtime.IProgressMonitor

/**
 * This class is necessary to mock units as a query result 
 * to test the class QueryManager
 */

class MockupQueryResult<T> extends ArrayList<T> implements IQueryResult<T> {
	
	override toArray(Class<T> clazz) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override toSet() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override toUnmodifiableSet() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override query(IQuery<T> query, IProgressMonitor monitor) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
}