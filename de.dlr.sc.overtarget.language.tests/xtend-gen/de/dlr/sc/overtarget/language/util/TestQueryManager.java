/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.util;

import de.dlr.sc.overtarget.language.util.MockupQueryResult;
import de.dlr.sc.overtarget.language.util.QueryManager;
import java.net.URI;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQueryResult;

/**
 * This class loads dummy units for testing the class QueryManager
 */
@SuppressWarnings("all")
public class TestQueryManager extends QueryManager {
  private MockupQueryResult<IInstallableUnit> dummyUnits = new MockupQueryResult<IInstallableUnit>();
  
  @Override
  public IQueryResult<IInstallableUnit> doLoadUnits(final URI uri) {
    return this.dummyUnits;
  }
  
  public MockupQueryResult<IInstallableUnit> setUnits(final MockupQueryResult<IInstallableUnit> dummyUnits) {
    return this.dummyUnits = dummyUnits;
  }
}
