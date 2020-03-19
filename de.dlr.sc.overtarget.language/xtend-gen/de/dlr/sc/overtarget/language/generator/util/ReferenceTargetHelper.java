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
import java.util.List;
import java.util.function.Predicate;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * This class processes the model data for generation
 */
@SuppressWarnings("all")
public class ReferenceTargetHelper {
  public static TargetModel getModelToGenerate(final TargetModel model) {
    EList<RepositoryLocation> _repositoryLocations = model.getRepositoryLocations();
    for (final RepositoryLocation repos : _repositoryLocations) {
      {
        boolean _isReferenceTarget = repos.isReferenceTarget();
        boolean _equals = (_isReferenceTarget == true);
        if (_equals) {
          final ArrayList<RepositoryLocation> list = CollectionLiterals.<RepositoryLocation>newArrayList();
          EList<RepositoryLocation> _repositoryLocations_1 = model.getRepositoryLocations();
          for (final RepositoryLocation repos2 : _repositoryLocations_1) {
            boolean _isReferenceTarget_1 = repos2.isReferenceTarget();
            boolean _equals_1 = (_isReferenceTarget_1 == false);
            if (_equals_1) {
              CollectionExtensions.<RepositoryLocation>addAll(list, repos2);
            }
          }
          ReferenceTargetHelper.deleteRepositoryLocation(list);
        }
        ReferenceTargetHelper.renameTarget(model);
        return model;
      }
    }
    return null;
  }
  
  public static ArrayList<RepositoryLocation> deleteRepositoryLocation(final ArrayList<RepositoryLocation> list) {
    for (final RepositoryLocation reposLoc : list) {
      {
        EcoreUtil.delete(reposLoc);
        return list;
      }
    }
    return null;
  }
  
  public static String renameTarget(final TargetModel model) {
    final String renamedTarget = "referenceTarget";
    model.setName(renamedTarget);
    return model.getName();
  }
  
  public static boolean importedModelIsProxy(final TargetModel model) {
    final ArrayList<TargetFile> list = CollectionLiterals.<TargetFile>newArrayList();
    EList<TargetFile> _importedModels = model.getImportedModels();
    for (final TargetFile files : _importedModels) {
      EList<TargetFile> _importedModels_1 = model.getImportedModels();
      for (final TargetFile file : _importedModels_1) {
        boolean _eIsProxy = file.eIsProxy();
        boolean _equals = (_eIsProxy == true);
        if (_equals) {
          CollectionExtensions.<TargetFile>addAll(list, file);
        }
      }
    }
    boolean _isEmpty = list.isEmpty();
    if (_isEmpty) {
      return false;
    } else {
      return true;
    }
  }
  
  public static boolean parentIsProxy(final TargetModel model) {
    final TargetModel parentTarget = model.getSuper();
    boolean _eIsProxy = parentTarget.eIsProxy();
    if (_eIsProxy) {
      return true;
    } else {
      return false;
    }
  }
  
  public static void setFileAsTargetPlatform(final TargetModel model) {
    try {
      String _name = model.getName();
      final String targetName = (_name + ".target");
      final IWorkspace workspace = ResourcesPlugin.getWorkspace();
      final IProject[] projects = workspace.getRoot().getProjects();
      final Predicate<IProject> _function = (IProject p) -> {
        return p.getFile(targetName).exists();
      };
      final IProject project = ((List<IProject>)Conversions.doWrapArray(projects)).stream().filter(_function).findFirst().orElse(null);
      final IFile file = project.getFile(targetName);
      TargetPlatformHelper.setAsTargetPlatform(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
