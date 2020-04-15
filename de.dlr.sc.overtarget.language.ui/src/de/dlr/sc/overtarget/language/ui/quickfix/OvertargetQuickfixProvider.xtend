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
import de.dlr.sc.overtarget.language.ui.handler.GenerationHandler
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtext.ui.editor.model.edit.IModification
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext

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
		acceptor.accept(issue, 'Fix Working System', 'Replace with correct Windowing System.', 'upcase.png') [
			context |
			val windowingSystemKeyword = grammarAccess.targetModelAccess.windowingSystemKeyword_6_0_0.value
			val deprecatedWorkingSystemKeyword = grammarAccess.targetModelAccess.workingSystemKeyword_6_0_1.value
			val WHITESPACE_SEPARATOR = 1
			
			val xtextDocument = context.xtextDocument
			xtextDocument.replace(issue.offset - WHITESPACE_SEPARATOR - deprecatedWorkingSystemKeyword.length, deprecatedWorkingSystemKeyword.length, windowingSystemKeyword)
		]
	}
	
	@Fix(Diagnostic.LINKING_DIAGNOSTIC)
	def fixCannotResolveReference(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Generate Target for References', '', '', 
			new IModification() {
			
			override apply(IModificationContext context) throws Exception {
				if (issue.message.contains("Couldn't resolve reference to")) {
					val editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
					if (editor instanceof ITextEditor) {
						val ite = editor as ITextEditor
						val input = ite.editorInput
						new GenerationHandler().runGeneration(input);
					}
				}
			}
		}, 1)
	}
}
