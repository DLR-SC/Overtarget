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
  private static final String TEST_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/testTarget.tmodel";
  
  private static final String PARENT_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/parentTarget.tmodel";
  
  private static final String PROXY_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/proxyTarget.tmodel_inv";
  
  private static final String IMPORT_TARGET_PATH = "/de.dlr.sc.overtarget.language.tests/resources/importedModel.tmodel";
  
  @Inject
  private IResourceFactory resourceFactory;
  
  private final ResourceSetImpl rs = new ResourceSetImpl();
  
  private final URI uriTestTarget = URI.createPlatformPluginURI(ReferencedTargetHelperTest.TEST_TARGET_PATH, true);
  
  private final Resource testTargetResource = this.rs.getResource(this.uriTestTarget, true);
  
  private final URI uriParentTarget = URI.createPlatformPluginURI(ReferencedTargetHelperTest.PARENT_TARGET_PATH, true);
  
  private final Resource parentTargetResource = this.rs.getResource(this.uriParentTarget, true);
  
  private final URI uriProxyTarget = URI.createPlatformPluginURI(ReferencedTargetHelperTest.PROXY_TARGET_PATH, true);
  
  private final URI uriImportedModel = URI.createPlatformPluginURI(ReferencedTargetHelperTest.IMPORT_TARGET_PATH, true);
  
  private final Resource importedModelResource = this.rs.getResource(this.uriImportedModel, true);
  
  @Inject
  @Extension
  private ParseHelper<TargetModel> _parseHelper;
  
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
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.referencedTarget = this._parseHelper.parse(_builder);
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
    final TargetModel target = ReferencedTargetHelper.getModelToGenerate(testTargetWithReference);
    final String expectedTargetName = this.referencedTarget.getName();
    final boolean expectedRepositoryLocation = this.referencedTarget.getRepositoryLocations().get(0).isReferencedTarget();
    Assert.assertEquals(Boolean.valueOf(expectedRepositoryLocation), Boolean.valueOf(target.getRepositoryLocations().get(0).isReferencedTarget()));
    Assert.assertEquals(expectedTargetName, target.getName());
  }
  
  @Test
  public void testRenameTarget() {
    EObject _get = this.testTargetResource.getContents().get(0);
    final TargetModel testTarget = ((TargetModel) _get);
    final String renamedTarget = ReferencedTargetHelper.renameTarget(testTarget);
    final String expectedRenamedTarget = "referencedTarget";
    Assert.assertEquals("The name of the renamed target is correct", expectedRenamedTarget, renamedTarget);
  }
  
  @Test
  public void testImportedModelIsProxy() {
    EObject _get = this.testTargetResource.getContents().get(0);
    final TargetModel testImportTarget = ((TargetModel) _get);
    this.importedModelResource.getContents().get(0);
    ReferencedTargetHelper.importedModelIsProxy(testImportTarget);
    Assert.assertFalse("Imported models can be resolved.", false);
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource proxyTargetResource = this.rs.getResource(this.uriProxyTarget, true);
    EObject _get_1 = proxyTargetResource.getContents().get(0);
    final TargetModel proxyTarget = ((TargetModel) _get_1);
    final boolean modelIsProxy = ReferencedTargetHelper.importedModelIsProxy(proxyTarget);
    Assert.assertTrue("Imported models are proxy.", modelIsProxy);
  }
  
  @Test
  public void testParentIsProxy() {
    EObject _get = this.testTargetResource.getContents().get(0);
    final TargetModel testTarget = ((TargetModel) _get);
    this.parentTargetResource.getContents().get(0);
    ReferencedTargetHelper.parentIsProxy(testTarget);
    Assert.assertFalse("ParentTarget can be resolved", false);
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel_inv", this.resourceFactory);
    final Resource proxyTargetResource = this.rs.getResource(this.uriProxyTarget, true);
    EObject _get_1 = proxyTargetResource.getContents().get(0);
    final TargetModel proxyTarget = ((TargetModel) _get_1);
    final boolean parentIsProxy = ReferencedTargetHelper.parentIsProxy(proxyTarget);
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
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel", this.resourceFactory);
      final Resource testTargetResource = this.rs.getResource(URI.createPlatformResourceURI("/testProject/target/target.tmodel", true), true);
      EObject _get = testTargetResource.getContents().get(0);
      final TargetModel target = ((TargetModel) _get);
      final IFile targetFile = folder.getFile("target.target");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<?pde version=\"3.8\"?><target name=\"target\" sequenceNumber=\"1\">");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<locations>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</locations>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<environment>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<os></os>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<ws>gtk</ws>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<arch></arch>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<nl></nl> ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</environment>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<targetJRE path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/\"/>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</target>");
      final byte[] bytesTarget = _builder.toString().getBytes();
      final ByteArrayInputStream sourceTarget = new ByteArrayInputStream(bytesTarget);
      targetFile.create(sourceTarget, false, null);
      Assert.assertNotNull(ReferencedTargetHelper.findTargetfileOfTmodel(target, outputDirectory));
      final IProject project2 = root.getProject("testProject2");
      final IFolder folder2 = project2.getFolder("target");
      final IFile tmodelFile2 = folder2.getFile("target.tmodel");
      project2.create(null);
      boolean _isOpen_1 = project2.isOpen();
      boolean _not_1 = (!_isOpen_1);
      if (_not_1) {
        project2.open(null);
      }
      folder2.create(IResource.NONE, true, null);
      final byte[] bytes2 = "\r\n\t\t\tTarget target {\r\n\t\t\t\t\r\n\t\t\t}".getBytes();
      final ByteArrayInputStream sourceTarget2 = new ByteArrayInputStream(bytes2);
      tmodelFile2.create(sourceTarget2, IResource.NONE, null);
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tmodel", this.resourceFactory);
      final Resource testTargetResource2 = this.rs.getResource(URI.createPlatformResourceURI("/testProject2/target/target.tmodel", true), true);
      EObject _get_1 = testTargetResource2.getContents().get(0);
      final TargetModel target2 = ((TargetModel) _get_1);
      Assert.assertNull(ReferencedTargetHelper.findTargetfileOfTmodel(target2, outputDirectory));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
