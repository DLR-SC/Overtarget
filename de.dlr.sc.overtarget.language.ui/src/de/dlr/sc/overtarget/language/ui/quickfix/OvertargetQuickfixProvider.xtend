/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.ui.editor.quickfix.Fix
import de.dlr.sc.overtarget.language.validation.OvertargetValidator
import javax.inject.Inject
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess

/**
 * Custom quickfixes.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class OvertargetQuickfixProvider extends DefaultQuickfixProvider {

	@Inject
	OvertargetGrammarAccess grammarAccess 
	
	@Fix(OvertargetValidator.DEPRECATED_WS_STATEMENT)
	def fixDeprecatedWsStatement(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Fix Working System', 'Replace with Correct Windowing System.', 'upcase.png') [
			context |
			val windowingSystemKeyword = grammarAccess.targetModelAccess.windowingSystemKeyword_6_0_0.value
			val deprecatedWorkingSystemKeyword = grammarAccess.targetModelAccess.workingSystemKeyword_6_0_1.value
			val WHITESPACE_SEPARATOR  = 1
			
			val xtextDocument = context.xtextDocument
			xtextDocument.replace(issue.offset - WHITESPACE_SEPARATOR - deprecatedWorkingSystemKeyword.length, deprecatedWorkingSystemKeyword.length, windowingSystemKeyword)
		]
	}
}
