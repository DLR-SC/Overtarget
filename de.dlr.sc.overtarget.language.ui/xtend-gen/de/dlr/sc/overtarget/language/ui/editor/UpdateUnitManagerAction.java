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

import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.ui.contentassist.UnitManager;
import java.util.ResourceBundle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;

@SuppressWarnings("all")
public class UpdateUnitManagerAction extends TextEditorAction {
  protected UpdateUnitManagerAction(final ResourceBundle bundle, final String prefix, final ITextEditor editor) {
    super(bundle, prefix, editor);
  }
  
  /**
   * This method calls the UnitManager to load units
   * whenever there is a change in the editor
   */
  @Override
  public void update() {
    super.update();
    final ITextEditor editor = this.getTextEditor();
    if ((editor instanceof XtextEditor)) {
      final IEditorInput input = ((XtextEditor)editor).getEditorInput();
      if ((input instanceof IFileEditorInput)) {
        final OvertargetXtextEditor overtargetEditor = new OvertargetXtextEditor();
        final XtextResource document = overtargetEditor.getXtextDocument();
        if ((document != null)) {
          EObject _get = document.getContents().get(0);
          final TargetFile target = ((TargetFile) _get);
          final EList<RepositoryLocation> repositoryLocations = target.getRepositoryLocations();
          for (final RepositoryLocation reposLoc : repositoryLocations) {
            {
              final UnitManager unitManager = UnitManager.getInstance();
              boolean _checkIfUnitsLoaded = unitManager.checkIfUnitsLoaded(reposLoc.getName());
              boolean _not = (!_checkIfUnitsLoaded);
              if (_not) {
                unitManager.loadUnits(reposLoc);
              }
            }
          }
        }
      }
    }
  }
}
