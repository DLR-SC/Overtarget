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
import de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelper;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider;
import java.io.ByteArrayInputStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
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
public class ReferencedTargetHelperTest {
  private static final String TEST_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/testTarget.tmodel";
  
  private static final String PARENT_TMODEl_PATH = "/de.dlr.sc.overtarget.language.tests/resources/parentTarget.tmodel";
  
  private static final String IMPORTED_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/importedModel.tmodel";
  
  private static final String PROXY_TMODEL_PATH = "/de.dlr.sc.overtarget.language.tests/resources/proxyTarget.tmodel_inv";
  
  @Inject
  private IResourceFactory resourceFactory;
  
  private final ResourceSetImpl rs = new ResourceSetImpl();
  
  private final URI uriTestTmodel = URI.createPlatformPluginURI(ReferencedTargetHelperTest.TEST_TMODEL_PATH, true);
  
  private final Resource testTmodelResource = this.rs.getResource(this.uriTestTmodel, true);
  
  private final URI uriParentTmodel = URI.createPlatformPluginURI(ReferencedTargetHelperTest.PARENT_TMODEl_PATH, true);
  
  private final Resource parentTmodelResource = this.rs.getResource(this.uriParentTmodel, true);
  
  private final URI uriImportedModelTmodel = URI.createPlatformPluginURI(ReferencedTargetHelperTest.IMPORTED_TMODEL_PATH, true);
  
  private final Resource importedModelTmodelResource = this.rs.getResource(this.uriImportedModelTmodel, true);
  
  private final URI uriProxyTmodel = URI.createPlatformPluginURI(ReferencedTargetHelperTest.PROXY_TMODEL_PATH, true);
  
  @Inject
  @Extension
  private ParseHelper<TargetModel> _parseHelper;
  
  private final ReferencedTargetHelper refTargetHelper = new ReferencedTargetHelper();
  
  private TargetModel referencedTarget;
  
  @Before
  public void setUp() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Target referencedTarget extends proxy {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Import proxyImport");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ReferencedTarget RepositoryLocation testTarget url \"test\\parentTarget.tmodel\" {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Unit parentTargetUnit version newest;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.referencedTarget = this._parseHelper.parse(_builder);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGetReferencedModelToGenerate() {
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource testTmodelWithReferenceResource = this.rs.getResource(this.uriProxyTmodel, true);
    EObject _get = testTmodelWithReferenceResource.getContents().get(0);
    final TargetModel testTmodelWithReference = ((TargetModel) _get);
    final TargetModel tmodelWithReference = this.refTargetHelper.getReferencedModelToGenerate(testTmodelWithReference);
    final String expectedTmodelName = this.referencedTarget.getName();
    final boolean expectedRepositoryLocation = this.referencedTarget.getRepositoryLocations().get(0).isReferencedTarget();
    Assert.assertEquals(Boolean.valueOf(expectedRepositoryLocation), Boolean.valueOf(tmodelWithReference.getRepositoryLocations().get(0).isReferencedTarget()));
    Assert.assertEquals(expectedTmodelName, tmodelWithReference.getName());
  }
  
  @Test
  public void testRenameTmodel() {
    EObject _get = this.testTmodelResource.getContents().get(0);
    final TargetModel testTmodel = ((TargetModel) _get);
    final String renamedTmodel = this.refTargetHelper.renameTmodel(testTmodel);
    final String expectedRenamedTmodel = ReferencedTargetHelper.TARGET_NAME;
    Assert.assertEquals("The name of the renamed target is correct", expectedRenamedTmodel, renamedTmodel);
  }
  
  @Test
  public void testImportedModelIsProxy() {
    EObject _get = this.testTmodelResource.getContents().get(0);
    final TargetModel testImportTmodel = ((TargetModel) _get);
    this.importedModelTmodelResource.getContents().get(0);
    final boolean tmodelIsNotProxy = this.refTargetHelper.importedModelIsProxy(testImportTmodel);
    Assert.assertFalse("Imported models can be resolved.", tmodelIsNotProxy);
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource proxyTmodelResource = this.rs.getResource(this.uriProxyTmodel, true);
    EObject _get_1 = proxyTmodelResource.getContents().get(0);
    final TargetModel proxyTmodel = ((TargetModel) _get_1);
    final boolean tmodelIsProxy = this.refTargetHelper.importedModelIsProxy(proxyTmodel);
    Assert.assertTrue("Imported models are proxy.", tmodelIsProxy);
  }
  
  @Test
  public void testParentIsProxy() {
    EObject _get = this.testTmodelResource.getContents().get(0);
    final TargetModel testTmodel = ((TargetModel) _get);
    this.parentTmodelResource.getContents().get(0);
    final boolean parentIsNotProxy = this.refTargetHelper.parentIsProxy(testTmodel);
    Assert.assertFalse("ParentTarget can be resolved", parentIsNotProxy);
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource proxyTmodelResource = this.rs.getResource(this.uriProxyTmodel, true);
    EObject _get_1 = proxyTmodelResource.getContents().get(0);
    final TargetModel proxyTmodel = ((TargetModel) _get_1);
    final boolean parentIsProxy = this.refTargetHelper.parentIsProxy(proxyTmodel);
    Assert.assertTrue("ParentTarget is proxy", parentIsProxy);
  }
  
  @Test
  public void testFindTargetfileOfTmodel() {
    try {
      final String outputDirectory = "./target";
      final IWorkspace workspace = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot root = workspace.getRoot();
      final IProject project = root.getProject("testProject");
      final IFolder folder = project.getFolder("target");
      final IFile tmodelFile = folder.getFile("target.tmodel");
      project.create(null);
      boolean _isOpen = project.isOpen();
      boolean _not = (!_isOpen);
      if (_not) {
        project.open(null);
      }
      folder.create(IResource.NONE, true, null);
      final byte[] bytes = "\r\n\t\t\tTarget target {\r\n\t\t\t\t\r\n\t\t\t}".getBytes();
      final ByteArrayInputStream source = new ByteArrayInputStream(bytes);
      tmodelFile.create(source, IResource.NONE, null);
      final URI uri = URI.createPlatformResourceURI("/testProject/target/target.tmodel", true);
      final Resource testTmodelResource = this.rs.getResource(uri, true);
      EObject _get = testTmodelResource.getContents().get(0);
      final TargetModel tmodel = ((TargetModel) _get);
      final IFile targetFile = folder.getFile("target.target");
      StringConcatenation _builder = new StringConcatenation();
      final byte[] bytesTarget = _builder.toString().getBytes();
      final ByteArrayInputStream sourceTarget = new ByteArrayInputStream(bytesTarget);
      targetFile.create(sourceTarget, false, null);
      Assert.assertEquals(targetFile, this.refTargetHelper.findTargetfileOfTmodel(tmodel, outputDirectory, uri));
      final IProject project2 = root.getProject("testProject2");
      final IFolder folder2 = project2.getFolder("target");
      final IFile tmodelFile2 = folder2.getFile("target2.tmodel");
      project2.create(null);
      boolean _isOpen_1 = project2.isOpen();
      boolean _not_1 = (!_isOpen_1);
      if (_not_1) {
        project2.open(null);
      }
      folder2.create(IResource.NONE, true, null);
      final byte[] bytes2 = "\r\n\t\t\tTarget target2 {\r\n\t\t\t\t\r\n\t\t\t}".getBytes();
      final ByteArrayInputStream sourceTarget2 = new ByteArrayInputStream(bytes2);
      tmodelFile2.create(sourceTarget2, IResource.NONE, null);
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel", this.resourceFactory);
      final Resource testTmodelResource2 = this.rs.getResource(URI.createPlatformResourceURI("/testProject2/target/target2.tmodel", true), true);
      EObject _get_1 = testTmodelResource2.getContents().get(0);
      final TargetModel tmodel2 = ((TargetModel) _get_1);
      Assert.assertNull(this.refTargetHelper.findTargetfileOfTmodel(tmodel2, outputDirectory, uri));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
