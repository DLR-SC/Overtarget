/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.ide

import com.google.inject.Inject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.CancelIndicator
import de.dlr.sc.overtarget.language.targetmodel.Unit
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess

class KeywordsSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator  {
	@Inject package OvertargetGrammarAccess grammar

    override protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
        CancelIndicator cancelIndicator) {
        switch (object) {
            Unit: {
                highlightFeature(acceptor, object, TargetmodelPackage.eINSTANCE.getUnit_Source, HighlightingStyles.DEFAULT_ID)
                return true
            }
            RepositoryLocation:{
                highlightFeature(acceptor, object, TargetmodelPackage.eINSTANCE.getRepositoryLocation_Name(), HighlightingStyles.DEFAULT_ID)
                return true
            }
            ExcludeLocation:{
            	highlightFeature(acceptor, object, TargetmodelPackage.eINSTANCE.excludeLocation_RepositoryLocation, HighlightingStyles.DEFAULT_ID)
                return true
            }
            default: false
        }
    }
	
}
