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
import java.util.ResourceBundle;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

@SuppressWarnings("all")
public class UpdateUnitManagerAction extends TextEditorAction {
  protected UpdateUnitManagerAction(final ResourceBundle bundle, final String prefix, final ITextEditor editor) {
    super(bundle, prefix, editor);
  }
  
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
  @Override
  public void update() {
    super.update();
    final ITextEditor editor = this.getTextEditor();
    final IEditorInput input = editor.getEditorInput();
    if ((input instanceof IFileEditorInput)) {
      final IFile file = ((IFileEditorInput)input).getFile();
      final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
      final IProject project = file.getProject();
      final ResourceSetImpl set = new ResourceSetImpl();
      final Resource r = set.getResource(uri, true);
      EObject _get = r.getContents().get(0);
      final TargetFile target = ((TargetFile) _get);
      final UnitManager unitManager = UnitManager.getInstance();
      unitManager.loadUnits(target);
    }
  }
}
