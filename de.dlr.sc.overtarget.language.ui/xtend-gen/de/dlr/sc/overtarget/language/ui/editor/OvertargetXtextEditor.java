/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ui.editor;

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.ui.contentassist.UnitManager;
import de.dlr.sc.overtarget.language.ui.editor.UpdateUnitManagerAction;
import java.util.ResourceBundle;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

@SuppressWarnings("all")
public class OvertargetXtextEditor extends XtextEditor {
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
  @Override
  public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
    super.init(site, input);
    this.prepareUnitsLoading(input);
  }
  
  public void prepareUnitsLoading(final IEditorInput input) {
    final TargetFile target = this.getTargetFile(input);
    if ((target != null)) {
      final UnitManager unitManager = UnitManager.getInstance();
      EList<RepositoryLocation> _repositoryLocations = target.getRepositoryLocations();
      for (final RepositoryLocation reposLoc : _repositoryLocations) {
        unitManager.loadUnits(reposLoc);
      }
    } else {
      return;
    }
  }
  
  /**
   * This method tries to get the targetFile of the given input
   * 
   * @param input	the editor input
   * @return		<code>targetFile</code> if the input contains a targetFile <br>
   * 				<code>null</code> if the input does not contain a targetFile
   */
  public TargetFile getTargetFile(final IEditorInput input) {
    if ((input instanceof IFileEditorInput)) {
      final IFile file = ((IFileEditorInput)input).getFile();
      final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
      final IProject project = file.getProject();
      final ResourceSet rs = this.resourceSetProvider.get(project);
      final Resource r = rs.getResource(uri, true);
      boolean _isEmpty = r.getContents().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EObject _get = r.getContents().get(0);
        final TargetFile targetFile = ((TargetFile) _get);
        return targetFile;
      } else {
        return null;
      }
    }
    return null;
  }
  
  public XtextResource getXtextDocument() {
    XtextResource _xifexpression = null;
    XtextEditor _activeXtextEditor = EditorUtils.getActiveXtextEditor();
    boolean _tripleNotEquals = (_activeXtextEditor != null);
    if (_tripleNotEquals) {
      XtextResource _xblockexpression = null;
      {
        IXtextDocument xtextdocument = EditorUtils.getActiveXtextEditor().getDocument();
        _xblockexpression = xtextdocument.<XtextResource>readOnly(new IUnitOfWork<XtextResource, XtextResource>() {
          @Override
          public XtextResource exec(final XtextResource state) throws Exception {
            return state;
          }
        });
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  @Override
  public void createActions() {
    super.createActions();
    ResourceBundle _resourceBundle = XtextUIMessages.getResourceBundle();
    final UpdateUnitManagerAction updateUnitManagerAction = new UpdateUnitManagerAction(_resourceBundle, 
      "Update Unit Manager", this);
    this.setAction("Update Unit Manager", updateUnitManagerAction);
    this.markAsContentDependentAction("Update Unit Manager", true);
  }
}
