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
  public static TargetModel getReferencedModelToGenerate(final TargetModel model) {
    final TargetModel referencedModel = EcoreUtil.<TargetModel>copy(model);
    final ArrayList<RepositoryLocation> list = CollectionLiterals.<RepositoryLocation>newArrayList();
    EList<RepositoryLocation> _repositoryLocations = referencedModel.getRepositoryLocations();
    for (final RepositoryLocation repos : _repositoryLocations) {
      boolean _isReferencedTarget = repos.isReferencedTarget();
      boolean _equals = (_isReferencedTarget == false);
      if (_equals) {
        CollectionExtensions.<RepositoryLocation>addAll(list, repos);
      }
    }
    ReferencedTargetHelper.deleteRepositoryLocation(list);
    ReferencedTargetHelper.renameTarget(referencedModel);
    return referencedModel;
  }
  
  public static ArrayList<RepositoryLocation> deleteRepositoryLocation(final ArrayList<RepositoryLocation> list) {
    for (final RepositoryLocation reposLoc : list) {
      EcoreUtil.delete(reposLoc);
    }
    return list;
  }
  
  public static String renameTarget(final TargetModel model) {
    final String renamedTarget = "referencedTarget";
    model.setName(renamedTarget);
    return model.getName();
  }
  
  public static boolean importedModelIsProxy(final TargetModel model) {
    final ArrayList<Object> list = CollectionLiterals.<Object>newArrayList();
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
  
  public static boolean parentIsProxy(final TargetModel model) {
    final TargetModel parentTarget = model.getSuper();
    return parentTarget.eIsProxy();
  }
  
  public static IFile findTargetfileOfTmodel(final TargetModel model, final String outputDirectory) {
    String _name = model.getName();
    String _plus = ("/" + _name);
    final String targetName = (_plus + ".target");
    final URI uri = EcoreUtil.getURI(model);
    final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
    String _platformString = uri.toPlatformString(true);
    Path _path = new Path(_platformString);
    final IFile tmodelFile = workspace.getFile(_path);
    final IProject project = tmodelFile.getProject();
    final String outputPath = outputDirectory.toString().replaceFirst(".", "");
    boolean _equals = outputPath.equals("/");
    if (_equals) {
      final IFile targetFile = project.getFile(targetName);
      boolean _exists = targetFile.exists();
      if (_exists) {
        return targetFile;
      }
    } else {
      final String targetPath = (outputPath + targetName);
      final IFile targetFile_1 = project.getFile(targetPath);
      boolean _exists_1 = targetFile_1.exists();
      if (_exists_1) {
        return targetFile_1;
      }
    }
    return null;
  }
  
  public static void setFileAsTargetPlatform(final IFile targetFile) {
    try {
      TargetPlatformHelper.setAsTargetPlatform(targetFile);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
