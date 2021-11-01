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

import com.google.inject.Inject
import de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelper
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess
import de.dlr.sc.overtarget.language.ui.handler.GenerationHandler
import de.dlr.sc.overtarget.language.util.TargetFileHandler
import de.dlr.sc.overtarget.language.util.TargetPlatformHelper
import de.dlr.sc.overtarget.language.validation.OvertargetValidator
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.MessageBox
import org.eclipse.ui.IFileEditorInput
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.ui.editor.model.edit.IModification
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue

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
		acceptor.accept(issue, 'Fix Working System', 'Replace with correct Windowing System.', 'upcase.png') [ context |
			val windowingSystemKeyword = grammarAccess.targetModelAccess.windowingSystemKeyword_6_0_0.value
			val deprecatedWorkingSystemKeyword = grammarAccess.targetModelAccess.workingSystemKeyword_6_0_1.value
			val WHITESPACE_SEPARATOR = 1
	
			val xtextDocument = context.xtextDocument
			xtextDocument.replace(issue.offset - WHITESPACE_SEPARATOR - deprecatedWorkingSystemKeyword.length,
				deprecatedWorkingSystemKeyword.length, windowingSystemKeyword)
		]
	}

	@Fix(Diagnostic.LINKING_DIAGNOSTIC)
	def fixPlaceholderForReferencedTarget(Issue issue, IssueResolutionAcceptor acceptor) {
		val placeholder = "\n\t" + "ReferencedTarget RepositoryLocation <placeholder:virsat> url \"<location>\" {" 
		+ "\n \t \t" 
		+ "// add necessary Units here;"
		+ "\n \t}" 
		acceptor.accept(issue, 'Create placeholder for referencedTarget', '', '',
			new IModification() {
				override apply(IModificationContext context) throws Exception {
					val editor = PlatformUI.workbench.activeWorkbenchWindow.activePage.activeEditor
					if (editor instanceof ITextEditor) {
						val dp = editor.getDocumentProvider()
						val doc = dp.getDocument(editor.getEditorInput())
						val offset = doc.getLineOffset(doc.getNumberOfLines() - 1)
						doc.replace(offset, 0, placeholder + "\n")
					}
				}
			}, 1)
	}

	@Fix(Diagnostic.LINKING_DIAGNOSTIC)
	def fixCannotResolveReference(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Use temporary target to resolve tmodel references',
			'Generates a temporary target for resolving tmodel references and sets it as active target.', '',
			new IModification() {
				override apply(IModificationContext context) throws Exception {
					if (issue.message.contains("Couldn't resolve reference to")) {
						val genHandler = new GenerationHandler();
						val refTargetHelper = new ReferencedTargetHelper()
						val targetPlatHelper = new TargetPlatformHelper()
	
						val editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
						if (editor instanceof ITextEditor) {
							val progressMonitor = new NullProgressMonitor()
							editor.doSave(progressMonitor) // saves the made changes in the file
							val ite = editor as ITextEditor
							val input = ite.editorInput

							genHandler.runGeneration(input);
	
							// find targetForReferences.target in directory and set it as active target
							val fileEditorInput = input as IFileEditorInput
							val file = fileEditorInput.file
	
							val targetFileHandler = new TargetFileHandler
							val model = targetFileHandler.getTmodel(file, null)
	
							// check if a referencedTarget is set
							val referencedTarget = model.repositoryLocations.findFirst[isReferencedTarget]
							if (referencedTarget === null) { // if no referencedTarget is set -> errorMessage
								val errorMessage = new MessageBox(
									Display.getCurrent().getActiveShell(),
									SWT::OK + SWT::ICON_INFORMATION
								);
								errorMessage.setText("Could not generate a ReferencedTarget!");
								errorMessage.setMessage(
									"Please specify one of the RepositoryLocations as ReferencedTarget container! (See Section 6.1 of the user manual for more information)");
								errorMessage.open();
							} else if (referencedTarget.referencedTarget) { // if referencedTarget set -> generate referencedTarget and set it
								val outputDirectory = genHandler.getOutputConfigurations(input)
								val targetForReferencesFile = refTargetHelper.
									findTargetForReferencesFile(file, outputDirectory)
								targetPlatHelper.asActiveTarget = targetForReferencesFile;
	
								genHandler.runGeneration(input);
							}
						}
					}
				}
			}, 1)
	}
	
	@Fix(OvertargetValidator.FILE_NAME_LIKE_TARGET_NAME)
	def fixFileNameLikeTargetName(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with correct tmodel name', '', 'upcase.png') [ context |
			val editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
			if (editor instanceof ITextEditor) {
				val progressMonitor = new NullProgressMonitor()
				editor.doSave(progressMonitor) // saves the made changes in the file
				val ite = editor as ITextEditor
				val input = ite.editorInput
				val fileEditorInput = input as IFileEditorInput
				val file = fileEditorInput.file
				val fileName = file.name.replace(".tmodel", "")
				val xtextDocument = context.xtextDocument
				xtextDocument.replace(issue.offset, issue.length, fileName)
			}
		]
	}
}
