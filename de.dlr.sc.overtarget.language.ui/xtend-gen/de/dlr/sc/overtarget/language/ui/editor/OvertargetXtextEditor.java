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
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.ui.contentassist.UnitManager;
import de.dlr.sc.overtarget.language.ui.editor.UpdateUnitManagerAction;
import java.util.ResourceBundle;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
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
    final TargetFile target = this.getModel(input);
    final UnitManager unitManager = UnitManager.getInstance();
    unitManager.loadUnits(target);
  }
  
  public TargetFile getModel(final IEditorInput input) {
    if ((input instanceof IFileEditorInput)) {
      final IFile file = ((IFileEditorInput)input).getFile();
      final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
      final IProject project = file.getProject();
      final ResourceSet rs = this.resourceSetProvider.get(project);
      final Resource r = rs.getResource(uri, true);
      EObject _get = r.getContents().get(0);
      final TargetFile target = ((TargetFile) _get);
      return target;
    }
    return null;
  }
  
  @Override
  public void updateState(final IEditorInput input) {
    final IXtextDocument document = this.getDocument();
    XtextResource xtextResource = document.<XtextResource>readOnly(new IUnitOfWork<XtextResource, XtextResource>() {
      @Override
      public XtextResource exec(final XtextResource state) throws Exception {
        return state;
      }
    });
    EObject _get = xtextResource.getContents().get(0);
    final TargetFile model = ((TargetFile) _get);
    final UnitManager unitManager = UnitManager.getInstance();
    unitManager.loadUnits(model);
    super.updateState(input);
  }
  
  @Override
  public void createActions() {
    super.createActions();
    ResourceBundle _resourceBundle = XtextUIMessages.getResourceBundle();
    final UpdateUnitManagerAction updateUnitManagerAction = new UpdateUnitManagerAction(_resourceBundle, 
      "Unit Manager", this);
    updateUnitManagerAction.update();
    this.setAction("Update Unit Manager", updateUnitManagerAction);
  }
}
