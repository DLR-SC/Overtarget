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
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.ui.handler.GenerationHandler;
import de.dlr.sc.overtarget.language.util.TargetPlatformHelper;
import de.dlr.sc.overtarget.language.validation.OvertargetValidator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
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
    acceptor.accept(issue, "Fix Working System", "Replace with correct Windowing System.", "upcase.png", _function);
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
              final String outputDirectory = genHandler.getOutputConfigurations(input);
              final IFile targetForReferencesFile = refTargetHelper.findTargetForReferencesFile(file, outputDirectory);
              targetPlatHelper.setAsActiveTarget(targetForReferencesFile);
              genHandler.runGeneration(input);
            }
          }
        }
      }, 1);
  }
  
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
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
        final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        final IProject project = file.getProject();
        final ResourceSet rs = this.resourceSetProvider.get(project);
        final Resource r = rs.getResource(uri, true);
        EObject _get = r.getContents().get(0);
        final TargetModel model = ((TargetModel) _get);
        final String modelName = model.getName();
        final String targetKeyword = this.grammarAccess.getKEYWORDAccess().getTargetKeyword_1().getValue();
        final String targetLibraryKeyword = this.grammarAccess.getTargetLibraryRule().getName();
        final int WHITESPACE_SEPARATOR = 1;
        final IXtextDocument xtextDocument = context.getXtextDocument();
        final String fileName = ((ITextEditor)editor).getTitle().replace(".tmodel", "");
        Integer _offset = issue.getOffset();
        int _plus = ((_offset).intValue() + WHITESPACE_SEPARATOR);
        int _length = targetKeyword.length();
        int _plus_1 = (_plus + _length);
        xtextDocument.replace(_plus_1, modelName.length(), fileName);
      }
    };
    acceptor.accept(issue, "Replace with correct tmodel name", "", "upcase.png", _function);
  }
}
