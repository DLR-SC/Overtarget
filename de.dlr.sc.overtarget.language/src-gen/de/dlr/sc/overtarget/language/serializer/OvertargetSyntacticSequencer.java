/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.serializer;

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class OvertargetSyntacticSequencer extends AbstractSyntacticSequencer {

	protected OvertargetGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ExcludeLocation_AllKeyword_4_1_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (OvertargetGrammarAccess) access;
		match_ExcludeLocation_AllKeyword_4_1_q = new TokenAlias(false, true, grammarAccess.getExcludeLocationAccess().getAllKeyword_4_1());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_ExcludeLocation_AllKeyword_4_1_q.equals(syntax))
				emit_ExcludeLocation_AllKeyword_4_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'all;'?
	 *
	 * This ambiguous syntax occurs at:
	 *     repositoryLocation=[RepositoryLocation|QualifiedName] '{' (ambiguity) '}' (rule end)
	 */
	protected void emit_ExcludeLocation_AllKeyword_4_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
