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

import de.dlr.sc.overtarget.language.util.TargetFileHandler;
import java.io.ByteArrayInputStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TargetFileHandlerTest {
  private final TargetFileHandler targetFileHandler = new TargetFileHandler();
  
  @Test
  public void getTargetFileTest() {
  }
  
  @Test
  public void getTargetFileWithProject() {
  }
  
  @Test
  public void testFindTargetFile() {
    try {
      final String outputDirectoryWithFolder = "./target";
      final IWorkspace workspace = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot root = workspace.getRoot();
      final String projectName = "testProjectWithTarget";
      final IProject projectWithTarget = root.getProject(projectName);
      final IFolder folder = projectWithTarget.getFolder("target");
      final IFile tmodelFile = folder.getFile("target.tmodel");
      projectWithTarget.create(null);
      boolean _isOpen = projectWithTarget.isOpen();
      boolean _not = (!_isOpen);
      if (_not) {
        projectWithTarget.open(null);
      }
      folder.create(IResource.NONE, true, null);
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
      final IWorkspace workspace = ResourcesPlugin.getWorkspace();
      final IWorkspaceRoot root = workspace.getRoot();
      final String PROJECT_NAME = "testProjectWithoutTarget";
      final IProject projectWithoutTarget = root.getProject(PROJECT_NAME);
      final IFolder folder = projectWithoutTarget.getFolder("target");
      final IFile tmodelFile = folder.getFile("target.tmodel");
      projectWithoutTarget.create(null);
      boolean _isOpen = projectWithoutTarget.isOpen();
      boolean _not = (!_isOpen);
      if (_not) {
        projectWithoutTarget.open(null);
      }
      folder.create(IResource.NONE, true, null);
      final byte[] bytes = "\r\n\t\t\tTarget target {\r\n\t\t\t\t\r\n\t\t\t}".getBytes();
      final ByteArrayInputStream sourceTarget = new ByteArrayInputStream(bytes);
      tmodelFile.create(sourceTarget, IResource.NONE, null);
      Assert.assertNull("File does not exist, so should be null", this.targetFileHandler.findTargetFile(tmodelFile, outputDirectoryWithFolder, tmodelFile.getName()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
