/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ui;

import de.dlr.sc.overtarget.language.ide.KeywordsSemanticHighlightingCalculator;
import de.dlr.sc.overtarget.language.ui.AbstractOvertargetUiModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class OvertargetUiModule extends AbstractOvertargetUiModule {
  public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
    return KeywordsSemanticHighlightingCalculator.class;
  }
  
  public OvertargetUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
