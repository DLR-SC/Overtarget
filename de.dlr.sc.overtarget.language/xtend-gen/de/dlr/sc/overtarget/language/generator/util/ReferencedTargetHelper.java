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
import de.dlr.sc.overtarget.language.util.TargetPlatformHelper;
import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * This class processes the model data for generation
 */
@SuppressWarnings("all")
public class ReferencedTargetHelper {
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
    final String renamedTmodel = "referencedTarget";
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
   * Locates the tmodelFile and finds the project.
   * In the project the targetFile is searched with the outputPath.
   * Checks if the targetFile is located directly in the project folder or in an extra folder.
   * 
   * @param model tmodel with references
   * @param outputDirectory output directory of generated targetFile
   * @param uri uri of original tmodel
   * @return targetFile
   */
  public IFile findTargetfileOfTmodel(final TargetModel model, final String outputDirectory, final URI uri) {
    String _name = model.getName();
    String _plus = ("/" + _name);
    final String tmodelName = (_plus + OvertargetGenerator.TARGET_FILE_EXTENSION);
    final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
    String _platformString = uri.toPlatformString(true);
    Path _path = new Path(_platformString);
    final IFile tmodelFile = workspace.getFile(_path);
    final IProject project = tmodelFile.getProject();
    final String outputPath = outputDirectory.toString().replaceFirst(".", "");
    boolean _equals = outputPath.equals("/");
    if (_equals) {
      final IFile targetFile = project.getFile(tmodelName);
      boolean _exists = targetFile.exists();
      if (_exists) {
        return targetFile;
      }
    } else {
      final String targetPath = (outputPath + tmodelName);
      final IFile targetFileWithFolder = project.getFile(targetPath);
      boolean _exists_1 = targetFileWithFolder.exists();
      if (_exists_1) {
        return targetFileWithFolder;
      }
    }
    return null;
  }
  
  public void setFileAsActiveTarget(final IFile targetFile) {
    try {
      final TargetPlatformHelper targetPlatHelper = new TargetPlatformHelper();
      targetPlatHelper.setAsActiveTarget(targetFile);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
