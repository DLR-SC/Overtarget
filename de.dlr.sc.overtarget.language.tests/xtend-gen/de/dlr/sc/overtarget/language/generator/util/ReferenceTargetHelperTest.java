/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.generator.util;

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.generator.util.ReferenceTargetHelper;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OvertargetInjectorProvider.class)
@SuppressWarnings("all")
public class ReferenceTargetHelperTest {
  private TargetModel testTarget;
  
  private static final String TEST_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/testTarget.tmodel";
  
  private static final String PARENT_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/parentTarget.tmodel";
  
  private static final String PROXY_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/proxyTarget.tmodel_inv";
  
  private static final String IMPORT_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/importedModel.tmodel";
  
  @Inject
  private IResourceFactory resourceFactory;
  
  private final ResourceSetImpl rs = new ResourceSetImpl();
  
  private final URI uriTestTarget = URI.createPlatformPluginURI(ReferenceTargetHelperTest.TEST_TARGET_PATH, true);
  
  private final Resource testTargetResource = this.rs.getResource(this.uriTestTarget, true);
  
  private final URI uriParentTarget = URI.createPlatformPluginURI(ReferenceTargetHelperTest.PARENT_TARGET_PATH, true);
  
  private final Resource parentTargetResource = this.rs.getResource(this.uriParentTarget, true);
  
  private final URI uriProxyTarget = URI.createPlatformPluginURI(ReferenceTargetHelperTest.PROXY_TARGET_PATH, true);
  
  private final URI uriImportedModel = URI.createPlatformPluginURI(ReferenceTargetHelperTest.IMPORT_TARGET_PATH, true);
  
  private final Resource importedModelResource = this.rs.getResource(this.uriImportedModel, true);
  
  @Before
  public void setUp() {
  }
  
  @Test
  public void testGetModelToGenerate() {
  }
  
  @Test
  public void testDeleteRepositoryLocation() {
  }
  
  @Test
  public void testRenameTarget() {
    final String renamedTarget = ReferenceTargetHelper.renameTarget(this.testTarget);
    final String expectedRenamedTarget = "referenceTarget";
    Assert.assertEquals("The name of the renamed target is correct", expectedRenamedTarget, renamedTarget);
  }
  
  @Test
  public void testImportedModelIsProxy() {
    EObject _get = this.testTargetResource.getContents().get(0);
    final TargetModel testImportTarget = ((TargetModel) _get);
    this.importedModelResource.getContents().get(0);
    ReferenceTargetHelper.importedModelIsProxy(testImportTarget);
    Assert.assertFalse("Imported models can be resolved.", false);
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource proxyTargetResource = this.rs.getResource(this.uriProxyTarget, true);
    EObject _get_1 = proxyTargetResource.getContents().get(0);
    final TargetModel proxyTarget = ((TargetModel) _get_1);
    ReferenceTargetHelper.importedModelIsProxy(proxyTarget);
    Assert.assertTrue("Imported models are proxy.", true);
  }
  
  @Test
  public void testParentIsProxy() {
    EObject _get = this.testTargetResource.getContents().get(0);
    final TargetModel testTarget = ((TargetModel) _get);
    this.parentTargetResource.getContents().get(0);
    ReferenceTargetHelper.parentIsProxy(testTarget);
    Assert.assertFalse("ParentTarget can be resolved", false);
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource proxyTargetResource = this.rs.getResource(this.uriProxyTarget, true);
    EObject _get_1 = proxyTargetResource.getContents().get(0);
    final TargetModel proxyTarget = ((TargetModel) _get_1);
    ReferenceTargetHelper.parentIsProxy(proxyTarget);
    Assert.assertTrue("ParentTarget is proxy", true);
  }
  
  @Test
  public void testGetTargetFile() {
  }
}
