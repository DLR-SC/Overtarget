/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
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

/**
 * Custom quickfixes.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class OvertargetQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(OvertargetValidator.DEPRECATED_WS_STATEMENT)
	def fixDeprecatedWsStatement(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Fix Working System', 'Replace with Correct Windowing System.', 'upcase.png') [
			context |
			val xtextDocument = context.xtextDocument
			
			val firstLetter = xtextDocument.get(issue.offset , 1)
			xtextDocument.replace(issue.offset, 1, firstLetter.toUpperCase)
		]
	}

//	@Fix(OvertargetValidator.INVALID_NAME)
//	def capitalizeName(Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, 'Capitalize name', 'Capitalize the name.', 'upcase.png') [
//			context |
//			val xtextDocument = context.xtextDocument
//			val firstLetter = xtextDocument.get(issue.offset, 1)
//			xtextDocument.replace(issue.offset, 1, firstLetter.toUpperCase)
//		]
//	}
}
