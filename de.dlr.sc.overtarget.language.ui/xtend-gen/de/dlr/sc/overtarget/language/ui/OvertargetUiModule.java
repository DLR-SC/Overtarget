/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ui;

import de.dlr.sc.overtarget.language.ide.KeywordsSemanticHighlightingCalculator;
import de.dlr.sc.overtarget.language.ui.editor.OvertargetXtextEditor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class OvertargetUiModule extends AbstractOvertargetUiModule {
  public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
    return KeywordsSemanticHighlightingCalculator.class;
  }
  
  public Class<? extends XtextEditor> bindXtextEditor() {
    return OvertargetXtextEditor.class;
  }
  
  public OvertargetUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
