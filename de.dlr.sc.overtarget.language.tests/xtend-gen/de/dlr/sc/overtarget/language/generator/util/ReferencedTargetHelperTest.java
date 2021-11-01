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
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider;
import java.io.ByteArrayInputStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
  
  private TargetModel targetForReferences;
  
  @Before
  public void setUp() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Target targetForReferences extends proxy {");
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
      this.targetForReferences = this._parseHelper.parse(_builder);
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
    final String expectedTmodelName = this.targetForReferences.getName();
    final boolean expectedRepositoryLocation = this.targetForReferences.getRepositoryLocations().get(0).isReferencedTarget();
    Assert.assertEquals(Boolean.valueOf(expectedRepositoryLocation), Boolean.valueOf(tmodelWithReference.getRepositoryLocations().get(0).isReferencedTarget()));
    Assert.assertEquals(expectedTmodelName, tmodelWithReference.getName());
  }
  
  @Test
  public void testRenameTmodel() {
    EObject _get = this.testTmodelResource.getContents().get(0);
    final TargetModel testTmodel = ((TargetModel) _get);
    final String renamedTmodel = this.refTargetHelper.renameTmodel(testTmodel);
    final String expectedRenamedTmodel = ReferencedTargetHelper.TARGET_FOR_REFERENCES_NAME;
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
    EObject _get_2 = this.parentTmodelResource.getContents().get(0);
    final TargetModel tmodelWithoutParent = ((TargetModel) _get_2);
    Assert.assertFalse("Tmodel has no parent tmodel.", this.refTargetHelper.parentIsProxy(tmodelWithoutParent));
  }
  
  @Test
  public void testFindTargetForReferencesFile() {
    try {
      final String outputDirectory = "./target";
      final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      final IProject projectWithTarget = root.getProject("testProjectWithTargetForReferences");
      boolean _exists = projectWithTarget.exists();
      if (_exists) {
        projectWithTarget.delete(true, null);
      }
      projectWithTarget.create(null);
      boolean _isOpen = projectWithTarget.isOpen();
      boolean _not = (!_isOpen);
      if (_not) {
        projectWithTarget.open(null);
      }
      final IFolder folder = projectWithTarget.getFolder("target");
      folder.create(IResource.NONE, true, null);
      final IFile tmodelFile = folder.getFile("targetForReferences.tmodel");
      final byte[] bytes = "\r\n\t\t\tTarget targetForReferences {\r\n\t\t\t\t\r\n\t\t\t}".getBytes();
      final ByteArrayInputStream source = new ByteArrayInputStream(bytes);
      tmodelFile.create(source, IResource.NONE, null);
      final IFile targetFile = folder.getFile("targetForReferences.target");
      StringConcatenation _builder = new StringConcatenation();
      final byte[] bytesTarget = _builder.toString().getBytes();
      final ByteArrayInputStream sourceTarget = new ByteArrayInputStream(bytesTarget);
      targetFile.create(sourceTarget, false, null);
      Assert.assertEquals(targetFile, this.refTargetHelper.findTargetForReferencesFile(tmodelFile, outputDirectory));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFindTargetForReferencesFileNonExistendFile() {
    try {
      final String outputDirectory = "./target";
      final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      final IProject projectWithoutTarget = root.getProject("testProjectWithoutTargetForReferences");
      boolean _exists = projectWithoutTarget.exists();
      if (_exists) {
        projectWithoutTarget.delete(true, null);
      }
      projectWithoutTarget.create(null);
      boolean _isOpen = projectWithoutTarget.isOpen();
      boolean _not = (!_isOpen);
      if (_not) {
        projectWithoutTarget.open(null);
      }
      final IFolder folder = projectWithoutTarget.getFolder("target");
      folder.create(IResource.NONE, true, null);
      final IFile tmodelFile = folder.getFile("targetForReferences.tmodel");
      final byte[] bytes = "\r\n\t\t\tTarget targetForReferences {\r\n\t\t\t\t\r\n\t\t\t}".getBytes();
      final ByteArrayInputStream sourceTarget = new ByteArrayInputStream(bytes);
      tmodelFile.create(sourceTarget, IResource.NONE, null);
      Assert.assertNull("File does not exist, so should be null", this.refTargetHelper.findTargetForReferencesFile(tmodelFile, outputDirectory));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
