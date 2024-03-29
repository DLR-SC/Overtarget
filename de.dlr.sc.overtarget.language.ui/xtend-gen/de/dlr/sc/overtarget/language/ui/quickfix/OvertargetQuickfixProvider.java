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

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.generator.util.ReferencedTargetHelper;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.ui.handler.GenerationHandler;
import de.dlr.sc.overtarget.language.util.TargetFileHandler;
import de.dlr.sc.overtarget.language.util.TargetPlatformHelper;
import de.dlr.sc.overtarget.language.validation.OvertargetValidator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
    acceptor.accept(issue, "Fix Working System", "Replace with correct Windowing System.", "upcase.png", _function);
  }
  
  @Fix(Diagnostic.LINKING_DIAGNOSTIC)
  public void fixPlaceholderForReferencedTarget(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final String placeholder = (((("\n\t" + "ReferencedTarget RepositoryLocation <placeholder:virsat> url \"<location>\" {") + "\n \t \t") + "// add necessary Units here;") + "\n \t}");
    acceptor.accept(issue, "Create placeholder for referencedTarget", "", "", 
      new IModification() {
        @Override
        public void apply(final IModificationContext context) throws Exception {
          final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
          if ((editor instanceof ITextEditor)) {
            final IDocumentProvider dp = ((ITextEditor)editor).getDocumentProvider();
            final IDocument doc = dp.getDocument(((ITextEditor)editor).getEditorInput());
            int _numberOfLines = doc.getNumberOfLines();
            int _minus = (_numberOfLines - 1);
            final int offset = doc.getLineOffset(_minus);
            doc.replace(offset, 0, (placeholder + "\n"));
          }
        }
      }, 1);
  }
  
  @Fix(Diagnostic.LINKING_DIAGNOSTIC)
  public void fixCannotResolveReference(final Issue issue, final IssueResolutionAcceptor acceptor) {
    acceptor.accept(issue, "Use temporary target to resolve tmodel references", "Generates a temporary target for resolving tmodel references and sets it as active target.", "", 
      new IModification() {
        @Override
        public void apply(final IModificationContext context) throws Exception {
          boolean _contains = issue.getMessage().contains("Couldn\'t resolve reference to");
          if (_contains) {
            final GenerationHandler genHandler = new GenerationHandler();
            final ReferencedTargetHelper refTargetHelper = new ReferencedTargetHelper();
            final TargetPlatformHelper targetPlatHelper = new TargetPlatformHelper();
            final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
            if ((editor instanceof ITextEditor)) {
              final NullProgressMonitor progressMonitor = new NullProgressMonitor();
              ((ITextEditor)editor).doSave(progressMonitor);
              final ITextEditor ite = ((ITextEditor) editor);
              final IEditorInput input = ite.getEditorInput();
              genHandler.runGeneration(input);
              final IFileEditorInput fileEditorInput = ((IFileEditorInput) input);
              final IFile file = fileEditorInput.getFile();
              final TargetFileHandler targetFileHandler = new TargetFileHandler();
              final TargetFile model = targetFileHandler.getTmodel(file, null);
              final Function1<RepositoryLocation, Boolean> _function = (RepositoryLocation it) -> {
                return Boolean.valueOf(it.isReferencedTarget());
              };
              final RepositoryLocation referencedTarget = IterableExtensions.<RepositoryLocation>findFirst(model.getRepositoryLocations(), _function);
              if ((referencedTarget == null)) {
                Shell _activeShell = Display.getCurrent().getActiveShell();
                final MessageBox errorMessage = new MessageBox(_activeShell, 
                  (SWT.OK + SWT.ICON_INFORMATION));
                errorMessage.setText("Could not generate a ReferencedTarget!");
                errorMessage.setMessage("Please specify one of the RepositoryLocations as ReferencedTarget container! (See Section 6.1 of the user manual for more information)");
                errorMessage.open();
              } else {
                boolean _isReferencedTarget = referencedTarget.isReferencedTarget();
                if (_isReferencedTarget) {
                  final String outputDirectory = genHandler.getOutputConfigurations(input);
                  final IFile targetForReferencesFile = refTargetHelper.findTargetForReferencesFile(file, outputDirectory);
                  targetPlatHelper.setAsActiveTarget(targetForReferencesFile);
                  genHandler.runGeneration(input);
                }
              }
            }
          }
        }
      }, 1);
  }
  
  @Fix(OvertargetValidator.FILE_NAME_LIKE_TARGET_NAME)
  public void fixFileNameLikeTargetName(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = (IModificationContext context) -> {
      final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      if ((editor instanceof ITextEditor)) {
        final NullProgressMonitor progressMonitor = new NullProgressMonitor();
        ((ITextEditor)editor).doSave(progressMonitor);
        final ITextEditor ite = ((ITextEditor) editor);
        final IEditorInput input = ite.getEditorInput();
        final IFileEditorInput fileEditorInput = ((IFileEditorInput) input);
        final IFile file = fileEditorInput.getFile();
        final String fileName = file.getName().replace(".tmodel", "");
        final IXtextDocument xtextDocument = context.getXtextDocument();
        xtextDocument.replace((issue.getOffset()).intValue(), (issue.getLength()).intValue(), fileName);
      }
    };
    acceptor.accept(issue, "Replace with correct tmodel name", "", "upcase.png", _function);
  }
}
