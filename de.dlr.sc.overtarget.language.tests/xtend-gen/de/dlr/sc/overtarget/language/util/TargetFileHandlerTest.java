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

import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.util.TargetFileHandler;
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
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

@SuppressWarnings("all")
public class TargetFileHandlerTest {
  private final TargetFileHandler targetFileHandler = new TargetFileHandler();
  
  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();
  
  @Test
  public void testGetTargetModel() {
    try {
      final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      final IProject testProject = root.getProject("de.dlr.sc.overtarget.language.tests");
      boolean _exists = testProject.exists();
      if (_exists) {
        testProject.delete(true, null);
      }
      testProject.create(null);
      boolean _isOpen = testProject.isOpen();
      boolean _not = (!_isOpen);
      if (_not) {
        testProject.open(null);
      }
      final IFolder folder = testProject.getFolder("resources");
      folder.create(IResource.NONE, true, null);
      final IFile tmodelFile = folder.getFile("target.tmodel");
      final byte[] bytes = "\r\n\t\t\tTarget target {\r\n\t\t\t\t\r\n\t\t\t}".getBytes();
      final ByteArrayInputStream source = new ByteArrayInputStream(bytes);
      tmodelFile.create(source, IResource.NONE, null);
      final TargetModel tmodel = this.targetFileHandler.getTargetModel(tmodelFile, null);
      final String tmodelPath = "/de.dlr.sc.overtarget.language.tests/resources/target.tmodel";
      final URI uriTmodel = URI.createPlatformPluginURI(tmodelPath, true);
      final ResourceSetImpl rs = new ResourceSetImpl();
      final Resource tmodelResource = rs.getResource(uriTmodel, true);
      EObject _get = tmodelResource.getContents().get(0);
      final TargetModel expectedTmodel = ((TargetModel) _get);
      Assert.assertEquals(expectedTmodel.getName(), tmodel.getName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFindTargetFile() {
    try {
      final String outputDirectoryWithFolder = "./target";
      final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      final IProject projectWithTarget = root.getProject("testProjectWithTarget");
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
      final IFile tmodelFile = folder.getFile("target.tmodel");
      final byte[] bytes = "\r\n\t\t\tTarget target {\r\n\t\t\t\t\r\n\t\t\t}".getBytes();
      final ByteArrayInputStream source = new ByteArrayInputStream(bytes);
      tmodelFile.create(source, IResource.NONE, null);
      final IFile targetFile = folder.getFile("target.target");
      StringConcatenation _builder = new StringConcatenation();
      final byte[] bytesTarget = _builder.toString().getBytes();
      final ByteArrayInputStream sourceTarget = new ByteArrayInputStream(bytesTarget);
      targetFile.create(sourceTarget, false, null);
      Assert.assertEquals(targetFile, this.targetFileHandler.findTargetFile(tmodelFile, outputDirectoryWithFolder, tmodelFile.getName()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFindTargetFileNonExistendFile() {
    try {
      final String outputDirectoryWithFolder = "./target";
      final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      final IProject projectWithoutTarget = root.getProject("testProjectWithoutTarget");
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
      final IFile tmodelFile = folder.getFile("target.tmodel");
      final byte[] bytes = "\r\n\t\t\tTarget target {\r\n\t\t\t\t\r\n\t\t\t}".getBytes();
      final ByteArrayInputStream sourceTarget = new ByteArrayInputStream(bytes);
      tmodelFile.create(sourceTarget, IResource.NONE, null);
      Assert.assertNull("File does not exist, so should be null", this.targetFileHandler.findTargetFile(tmodelFile, outputDirectoryWithFolder, tmodelFile.getName()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
