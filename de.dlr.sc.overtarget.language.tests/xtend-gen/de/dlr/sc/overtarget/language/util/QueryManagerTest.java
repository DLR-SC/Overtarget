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

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider;
import de.dlr.sc.overtarget.language.util.MockupQueryResult;
import de.dlr.sc.overtarget.language.util.TestQueryManager;
import java.util.ArrayList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.internal.p2.metadata.InstallableUnit;
import org.eclipse.equinox.internal.p2.metadata.OSGiVersion;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OvertargetInjectorProvider.class)
@SuppressWarnings("all")
public class QueryManagerTest {
  @Inject
  private IResourceFactory resourceFactory;
  
  private TestQueryManager testQueryManager = new TestQueryManager();
  
  private static final String TEST_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/testModelWithAddAllUnits.tmodel_inv";
  
  private static final String UNIT_ID = "www.testLink.de";
  
  private final ResourceSetImpl rs = new ResourceSetImpl();
  
  private final URI uriTmodelWithUnits = URI.createPlatformPluginURI(QueryManagerTest.TEST_TMODEL_PATH, true);
  
  @Test
  public void getReposLocOfUnitTest() {
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource tmodelWithUnitsResource = this.rs.getResource(this.uriTmodelWithUnits, true);
    EObject _get = tmodelWithUnitsResource.getContents().get(0);
    final TargetFile expectedTmodelWithUnits = ((TargetFile) _get);
    RepositoryLocation _get_1 = expectedTmodelWithUnits.getRepositoryLocations().get(1);
    final RepositoryLocation expectedReposLoc = ((RepositoryLocation) _get_1);
    Unit _get_2 = expectedReposLoc.getUnits().get(0);
    final Unit expectedUnit = ((Unit) _get_2);
    final RepositoryLocation locationWithUnit = this.testQueryManager.getReposLocOfUnit(expectedUnit);
    final RepositoryLocation locationWithReposLoc = this.testQueryManager.getReposLocOfUnit(expectedReposLoc);
    Assert.assertEquals(expectedReposLoc, locationWithUnit);
    Assert.assertEquals(expectedReposLoc, locationWithReposLoc);
  }
  
  @Test
  public void loadUnitsTest() {
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource tmodelWithUnitsResource = this.rs.getResource(this.uriTmodelWithUnits, true);
    EObject _get = tmodelWithUnitsResource.getContents().get(0);
    final TargetFile testTmodelWithUnits = ((TargetFile) _get);
    RepositoryLocation _get_1 = testTmodelWithUnits.getRepositoryLocations().get(2);
    final RepositoryLocation testReposLoc = ((RepositoryLocation) _get_1);
    final InstallableUnit dummyUnit = new InstallableUnit();
    dummyUnit.setId(QueryManagerTest.UNIT_ID);
    OSGiVersion _oSGiVersion = new OSGiVersion(0, 0, 0, "1234");
    dummyUnit.setVersion(_oSGiVersion);
    final MockupQueryResult<IInstallableUnit> dummyList = new MockupQueryResult<IInstallableUnit>();
    dummyList.add(dummyUnit);
    this.testQueryManager.setUnits(dummyList);
    final ArrayList<Unit> unitList = this.testQueryManager.getUnitsInList(testTmodelWithUnits, testReposLoc);
    final String unitListID = unitList.get(0).getSource();
    Assert.assertEquals(QueryManagerTest.UNIT_ID, unitListID);
  }
}
