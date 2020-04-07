/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ui.quickfix;

import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import de.dlr.sc.overtarget.language.ui.handler.GenerationHandler;
import de.dlr.sc.overtarget.language.validation.OvertargetValidator;
import javax.inject.Inject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
@SuppressWarnings("all")
public class OvertargetQuickfixProvider extends DefaultQuickfixProvider {
  @Inject
  private OvertargetGrammarAccess grammarAccess;
  
  @Fix(OvertargetValidator.DEPRECATED_WS_STATEMENT)
  public void fixDeprecatedWsStatement(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = (IModificationContext context) -> {
      final String windowingSystemKeyword = this.grammarAccess.getTargetModelAccess().getWindowingSystemKeyword_6_0_0().getValue();
      final String deprecatedWorkingSystemKeyword = this.grammarAccess.getTargetModelAccess().getWorkingSystemKeyword_6_0_1().getValue();
      final int WHITESPACE_SEPARATOR = 1;
      final IXtextDocument xtextDocument = context.getXtextDocument();
      Integer _offset = issue.getOffset();
      int _minus = ((_offset).intValue() - WHITESPACE_SEPARATOR);
      int _length = deprecatedWorkingSystemKeyword.length();
      int _minus_1 = (_minus - _length);
      xtextDocument.replace(_minus_1, deprecatedWorkingSystemKeyword.length(), windowingSystemKeyword);
    };
    acceptor.accept(issue, "Fix Working System", "Replace with Correct Windowing System.", "upcase.png", _function);
  }
  
  @Fix(Diagnostic.LINKING_DIAGNOSTIC)
  public void fixCannotResolveReference(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = (IModificationContext it) -> {
      boolean _contains = issue.getMessage().contains("Couldn\'t resolve reference to");
      if (_contains) {
        final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if ((editor instanceof ITextEditor)) {
          final ITextEditor ite = ((ITextEditor) editor);
          final IEditorInput input = ite.getEditorInput();
          new GenerationHandler().runGeneration(input);
        }
      }
    };
    acceptor.accept(issue, "Generate Reference Target", "Generate a reference target to resolve the target.", "upcase.png", _function);
  }
}
