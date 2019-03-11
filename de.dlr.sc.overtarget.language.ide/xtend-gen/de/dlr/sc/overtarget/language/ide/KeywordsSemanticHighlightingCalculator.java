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
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.CancelIndicator;

@SuppressWarnings("all")
public class KeywordsSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
  @Inject
  OvertargetGrammarAccess grammar;
  
  @Override
  protected boolean highlightElement(final EObject object, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (object instanceof Unit) {
      _matched=true;
      this.highlightFeature(acceptor, object, TargetmodelPackage.eINSTANCE.getUnit_Source(), HighlightingStyles.DEFAULT_ID);
      return true;
    }
    if (!_matched) {
      if (object instanceof RepositoryLocation) {
        _matched=true;
        this.highlightFeature(acceptor, object, TargetmodelPackage.eINSTANCE.getRepositoryLocation_Name(), HighlightingStyles.DEFAULT_ID);
        return true;
      }
    }
    if (!_matched) {
      if (object instanceof ExcludeLocation) {
        _matched=true;
        this.highlightFeature(acceptor, object, TargetmodelPackage.eINSTANCE.getExcludeLocation_RepositoryLocation(), HighlightingStyles.DEFAULT_ID);
        return true;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
