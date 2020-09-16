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

import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider;
import de.dlr.sc.overtarget.language.util.QueryManager;
import java.util.ArrayList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OvertargetInjectorProvider.class)
@SuppressWarnings("all")
public class QueryManagerTest {
  private final QueryManager queryManager = new QueryManager();
  
  private static final String TEST_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/tmodelWithUnits.tmodel";
  
  private final ResourceSetImpl rs = new ResourceSetImpl();
  
  private final URI uriTmodelWithUnits = URI.createPlatformPluginURI(QueryManagerTest.TEST_TMODEL_PATH, true);
  
  private final Resource tmodelWithUnitsResource = this.rs.getResource(this.uriTmodelWithUnits, true);
  
  private final TargetFile expectedTmodelWithUnits = ((TargetFile) this.tmodelWithUnitsResource.getContents().get(0));
  
  private final RepositoryLocation expectedReposLoc = ((RepositoryLocation) this.expectedTmodelWithUnits.getRepositoryLocations().get(0));
  
  @Test
  public void getReposLocOfUnitTest() {
    Unit _get = this.expectedReposLoc.getUnits().get(0);
    final Unit expectedUnit = ((Unit) _get);
    final RepositoryLocation locationWithUnit = this.queryManager.getReposLocOfUnit(expectedUnit);
    final RepositoryLocation locationWithReposLoc = this.queryManager.getReposLocOfUnit(this.expectedReposLoc);
    Assert.assertEquals(this.expectedReposLoc, locationWithUnit);
    Assert.assertEquals(this.expectedReposLoc, locationWithReposLoc);
  }
  
  @Test
  public void loadUnitsTest() {
    final ArrayList<Unit> units = this.queryManager.loadUnits(this.expectedTmodelWithUnits, this.expectedReposLoc);
    Assert.assertNull("Units are loaded", units);
  }
}
