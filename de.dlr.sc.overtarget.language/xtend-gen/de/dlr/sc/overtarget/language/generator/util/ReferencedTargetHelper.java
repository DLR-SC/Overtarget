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

import de.dlr.sc.overtarget.language.generator.OvertargetGenerator;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * This class processes the model data for generation
 */
@SuppressWarnings("all")
public class ReferencedTargetHelper {
  public static final String TARGET_NAME = "targetForReferences";
  
  /**
   * This method copies the original tmodel and
   * looks for all repositoryLocations without a referenced target
   * 
   * @param model original tmodel with unresolved references
   * @return tmodelWithReference tmodel with repositoryLocations containing the keyword referencedTarget
   */
  public TargetModel getReferencedModelToGenerate(final TargetModel model) {
    final TargetModel tmodelWithReference = EcoreUtil.<TargetModel>copy(model);
    final ArrayList<RepositoryLocation> list = CollectionLiterals.<RepositoryLocation>newArrayList();
    EList<RepositoryLocation> _repositoryLocations = tmodelWithReference.getRepositoryLocations();
    for (final RepositoryLocation repos : _repositoryLocations) {
      boolean _isReferencedTarget = repos.isReferencedTarget();
      boolean _equals = (_isReferencedTarget == false);
      if (_equals) {
        CollectionExtensions.<RepositoryLocation>addAll(list, repos);
      }
    }
    this.deleteRepositoryLocation(list);
    this.renameTmodel(tmodelWithReference);
    return tmodelWithReference;
  }
  
  public ArrayList<RepositoryLocation> deleteRepositoryLocation(final ArrayList<RepositoryLocation> list) {
    for (final RepositoryLocation reposLoc : list) {
      EcoreUtil.delete(reposLoc);
    }
    return list;
  }
  
  public String renameTmodel(final TargetModel model) {
    final String renamedTmodel = ReferencedTargetHelper.TARGET_NAME;
    model.setName(renamedTmodel);
    return model.getName();
  }
  
  public boolean hasUnresolvedReferences(final TargetModel model) {
    return ((this.importedModelIsProxy(model) == true) || (this.parentIsProxy(model) == true));
  }
  
  public boolean importedModelIsProxy(final TargetModel model) {
    EList<TargetFile> _importedModels = model.getImportedModels();
    for (final TargetFile file : _importedModels) {
      boolean _eIsProxy = file.eIsProxy();
      boolean _equals = (_eIsProxy == true);
      if (_equals) {
        return file.eIsProxy();
      }
    }
    return false;
  }
  
  public boolean parentIsProxy(final TargetModel model) {
    final TargetModel parentTarget = model.getSuper();
    if ((parentTarget != null)) {
      return parentTarget.eIsProxy();
    } else {
      return false;
    }
  }
  
  /**
   * In the project the targetFile is searched with the outputPath.
   * Checks if the targetFile is located directly in the project folder or in an extra folder.
   * 
   * @param file targetFile which is searched for
   * @param outputDirectory output directory of generated targetFile
   * @return targetFile
   */
  public IFile findTargetFileInProject(final IFile file, final String outputDirectory) {
    final IProject project = file.getProject();
    String _name = file.getName();
    final String fileName = ("/" + _name);
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
      final String targetPath = (outputPath + targetFileName);
      final IFile targetFileWithFolder = project.getFile(targetPath);
      boolean _exists_1 = targetFileWithFolder.exists();
      if (_exists_1) {
        return targetFileWithFolder;
      }
    }
    return null;
  }
  
  /**
   * In the project the targetForReferences file is searched with the outputPath.
   * Checks if the file is located directly in the project folder or in an extra folder.
   * 
   * @param file targetFile with unresolved references
   * @param outputDirectory output directory of generated targetFile
   * @return targetForReferences
   */
  public IFile findTargetForReferencesFile(final IFile file, final String outputDirectory) {
    final IProject project = file.getProject();
    final String fileName = (("/" + ReferencedTargetHelper.TARGET_NAME) + OvertargetGenerator.TARGET_FILE_EXTENSION);
    final String outputPath = outputDirectory.toString().replaceFirst(".", "");
    boolean _equals = outputPath.equals("/");
    if (_equals) {
      final IFile targetForReferences = project.getFile(fileName);
      boolean _exists = targetForReferences.exists();
      if (_exists) {
        return targetForReferences;
      }
    } else {
      final String targetPath = (outputPath + fileName);
      final IFile targetForReferencesWithFolder = project.getFile(targetPath);
      boolean _exists_1 = targetForReferencesWithFolder.exists();
      if (_exists_1) {
        return targetForReferencesWithFolder;
      }
    }
    return null;
  }
}
