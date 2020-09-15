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

import de.dlr.sc.overtarget.language.generator.OvertargetGenerator;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * This class handles getting files, such as target resources (.tmodel) or targetFiles (.target).
 */
@SuppressWarnings("all")
public class TargetFileHandler {
  /**
   * This method gets a targetModel
   * 
   * @param file	target file (.target) located in a project
   * @param rs	resourceSet which can include tmodels
   * @return targetModel
   */
  public TargetModel getTargetModel(final IFile file, final ResourceSet rs) {
    final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
    ResourceSet resourceSet = rs;
    if ((rs == null)) {
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      resourceSet = _resourceSetImpl;
    }
    final Resource resource = resourceSet.getResource(uri, true);
    EObject _get = resource.getContents().get(0);
    final TargetModel targetModel = ((TargetModel) _get);
    return targetModel;
  }
  
  /**
   * In the project the targetFile is searched with the outputPath.
   * Checks if the targetFile is located directly in the project folder or in an extra folder.
   * 
   * @param file targetFile which is searched for
   * @param outputDirectory output directory of generated targetFile
   * @param fileName name of the tmodel/targetFile
   * @return targetFile
   */
  public IFile findTargetFile(final IFile file, final String outputDirectory, final String fileName) {
    final IProject project = file.getProject();
    final String targetFileName = fileName.replace(".tmodel", OvertargetGenerator.TARGET_FILE_EXTENSION);
    final String outputPath = outputDirectory.toString().replaceFirst(".", "");
    boolean _equals = outputPath.equals("/");
    if (_equals) {
      final IFile targetFile = project.getFile(targetFileName);
      boolean _exists = targetFile.exists();
      if (_exists) {
        return targetFile;
      }
    } else {
      final String targetPath = ((outputPath + "/") + targetFileName);
      final IFile targetFileWithFolder = project.getFile(targetPath);
      boolean _exists_1 = targetFileWithFolder.exists();
      if (_exists_1) {
        return targetFileWithFolder;
      }
    }
    return null;
  }
}
