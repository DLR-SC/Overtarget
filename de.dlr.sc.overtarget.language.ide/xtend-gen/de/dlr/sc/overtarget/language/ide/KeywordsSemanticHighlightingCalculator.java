/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ide;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.CancelIndicator;

@SuppressWarnings("all")
public class KeywordsSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
  @Inject
  /* OvertargetGrammarAccess */Object grammar;
  
  @Override
  protected boolean highlightElement(final EObject object, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    throw new Error("Unresolved compilation problems:"
      + "\nUnit cannot be resolved to a type."
      + "\nRepositoryLocation cannot be resolved to a type."
      + "\nExcludeLocation cannot be resolved to a type."
      + "\nThe method or field TargetmodelPackage is undefined"
      + "\nThe method or field TargetmodelPackage is undefined"
      + "\nThe method or field TargetmodelPackage is undefined"
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\neINSTANCE cannot be resolved"
      + "\ngetUnit_Source cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ngetRepositoryLocation_Name cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\nexcludeLocation_RepositoryLocation cannot be resolved");
  }
}
