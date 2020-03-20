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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OvertargetInjectorProvider.class)
@SuppressWarnings("all")
public class ReferenceTargetHelperTest {
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
  
  @Inject
  @Extension
  private ParseHelper<TargetModel> _parseHelper;
  
  private TargetModel referenceTarget;
  
  @Before
  public void setUp() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Target referenceTarget extends proxy {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Import proxyImport");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ReferenceTarget RepositoryLocation testTarget url \"test\\parentTarget.tmodel\" {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Unit parentTargetUnit version newest;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.referenceTarget = this._parseHelper.parse(_builder);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGetModelToGenerate() {
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource testTargetWithReferenceResource = this.rs.getResource(this.uriProxyTarget, true);
    EObject _get = testTargetWithReferenceResource.getContents().get(0);
    final TargetModel testTargetWithReference = ((TargetModel) _get);
    ReferenceTargetHelper.getModelToGenerate(testTargetWithReference);
    final String expectedTargetName = this.referenceTarget.getName();
    final boolean expectedRepositoryLocation = this.referenceTarget.getRepositoryLocations().get(0).isReferenceTarget();
    Assert.assertEquals(Boolean.valueOf(expectedRepositoryLocation), Boolean.valueOf(testTargetWithReference.getRepositoryLocations().get(0).isReferenceTarget()));
    Assert.assertEquals(expectedTargetName, testTargetWithReference.getName());
  }
  
  @Test
  public void testRenameTarget() {
    EObject _get = this.testTargetResource.getContents().get(0);
    final TargetModel testTarget = ((TargetModel) _get);
    final String renamedTarget = ReferenceTargetHelper.renameTarget(testTarget);
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
  public void testSetFileAsTargetPlatform() {
  }
}
