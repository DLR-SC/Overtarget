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
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess
import de.dlr.sc.overtarget.language.ui.handler.GenerationHandler
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtext.ui.editor.model.edit.IModification
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import de.dlr.sc.overtarget.language.util.TargetPlatformHelper
import de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelper
import org.eclipse.ui.IFileEditorInput
import org.eclipse.core.runtime.NullProgressMonitor
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import com.google.inject.Inject
import de.dlr.sc.overtarget.language.targetmodel.TargetLibrary
import de.dlr.sc.overtarget.language.targetmodel.TargetFile

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
		acceptor.accept(issue, 'Use temporary target to resolve tmodel references', 'Generates a temporary target for resolving tmodel references and sets it as active target.', '', 
			new IModification() {
			
			override apply(IModificationContext context) throws Exception {
				if (issue.message.contains("Couldn't resolve reference to")) {
					val genHandler = new GenerationHandler();
					val refTargetHelper = new ReferencedTargetHelper()
					val targetPlatHelper = new TargetPlatformHelper()
				
					val editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
					if (editor instanceof ITextEditor) {
						val progressMonitor = new NullProgressMonitor()
						editor.doSave(progressMonitor) //saves the made changes in the file
						val ite = editor as ITextEditor
						val input = ite.editorInput
						genHandler.runGeneration(input);
						
						//find targetForReferences.target in directory and set it as active target
						val fileEditorInput = input as IFileEditorInput
						val file = fileEditorInput.file
						val outputDirectory = genHandler.getOutputConfigurations(input)
						val targetForReferencesFile = refTargetHelper.findTargetForReferencesFile(file, outputDirectory)
						targetPlatHelper.asActiveTarget = targetForReferencesFile;
						
						genHandler.runGeneration(input);
					}
				}
			}
		}, 1)
	}
	
	@Inject
	IResourceSetProvider resourceSetProvider
	
	@Fix(OvertargetValidator.FILE_NAME_LIKE_TARGET_NAME)
	def fixFileNameLikeTargetName(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with correct tmodel name', '', 'upcase.png') [
		
		context |
			val editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
			if (editor instanceof ITextEditor) {
				val progressMonitor = new NullProgressMonitor()
				editor.doSave(progressMonitor) //saves the made changes in the file
				val ite = editor as ITextEditor
				val input = ite.editorInput
				val fileEditorInput = input as IFileEditorInput
				val file = fileEditorInput.file
				val fileName = file.name.replace(".tmodel", "")

				val uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				val project = file.getProject();
				val rs = resourceSetProvider.get(project);
				val r = rs.getResource(uri, true);
				val model = r.contents.get(0) as TargetFile
				
				val xtextDocument = context.xtextDocument
				
				if (model instanceof TargetModel) {
					xtextDocument.replace(issue.offset, issue.length, fileName)
				} else if (model instanceof TargetLibrary) {
					xtextDocument.replace(issue.offset, issue.length, fileName)
				}
			}
		]
	}
}