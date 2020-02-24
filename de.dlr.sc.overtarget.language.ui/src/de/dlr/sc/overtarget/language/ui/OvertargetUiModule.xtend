/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import de.dlr.sc.overtarget.language.ide.KeywordsSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class OvertargetUiModule extends AbstractOvertargetUiModule {
	def Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator () {
		KeywordsSemanticHighlightingCalculator
	}
}
