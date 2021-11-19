/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.ui.contentassist

import de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl
import de.dlr.sc.overtarget.language.util.QueryManager
import java.text.DateFormat
import org.eclipse.core.runtime.Platform
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import javax.inject.Inject
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.jface.text.templates.TemplateContext

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
class OvertargetProposalProvider extends AbstractOvertargetProposalProvider {
	override complete_OperatingSys(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		Platform.knownOSValues().forEach[acceptor.accept(createCompletionProposal(it, context))]
		super.complete_OperatingSys(model, ruleCall, context, acceptor)
	}

	override complete_Architecture(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		Platform.knownOSArchValues().forEach[acceptor.accept(createCompletionProposal(it, context))]
		super.complete_Architecture(model, ruleCall, context, acceptor)
	}

	override complete_WindowingSys(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		Platform.knownWSValues().forEach[acceptor.accept(createCompletionProposal(it, context))]
		super.complete_WindowingSys(model, ruleCall, context, acceptor)
	}

	override complete_Locale(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		val list = DateFormat.getAvailableLocales()
		for (i : list.size >.. 0) {
			val element = list.get(i)
			if (element.country == "") {
				acceptor.accept(createCompletionProposal(element.language, context))
			} else {
				acceptor.accept(createCompletionProposal(element.language + '_' + element.country, context))
			}
		}
		super.complete_Locale(model, ruleCall, context, acceptor)
	}

	@Inject
	OvertargetGrammarAccess grammarAccess;
	
	override completeRepositoryLocation_Units(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("Unit", "Unit", getImage(grammarAccess.unitRule), context))
		super.completeRepositoryLocation_Units(model, assignment, context, acceptor)
	}

	override completeRepositoryLocation_AddAll(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val proposal = createCompletionProposal("addAll;", "addAll;", getImage(grammarAccess.repositoryLocationRule), context) as ConfigurableCompletionProposal;
  getPriorityHelper().adjustKeywordPriority(proposal, context.getPrefix())
		if (proposal !== null) {
			proposal.setPriority(proposal.getPriority() * 2)
			acceptor.accept(proposal)
		}
	}

	override complete_Version(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		val queryManager = new QueryManager()
		val unit = model as UnitImpl
		val results = queryManager.getUnits(model)
		results.filter[source == unit.source].forEach[acceptor.accept(createCompletionProposal(vers +";", context))]
		super.complete_Version(model, ruleCall, context, acceptor)
	}

	override complete_Source(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		val queryManager = new QueryManager()
		val results = queryManager.getUnits(model)
		for (result : results) {
			val unitName = queryManager.getNamefromUnit(result.source)
			acceptor.accept(createCompletionProposal(unitName + " – " + result.source, context))
		}
		super.complete_Source(model, ruleCall, context, acceptor)
	}
}
