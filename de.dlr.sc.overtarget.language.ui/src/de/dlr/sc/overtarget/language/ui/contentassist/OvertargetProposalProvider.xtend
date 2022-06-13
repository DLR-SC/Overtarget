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

import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation
import de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl
import java.text.DateFormat
import java.util.ArrayList
import javax.inject.Inject
import org.eclipse.core.runtime.Platform
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor

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

	override completeRepositoryLocation_AddAll(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		val proposal = createCompletionProposal("addAll;", "addAll;", getImage(grammarAccess.repositoryLocationRule),
			context) as ConfigurableCompletionProposal;
		getPriorityHelper().adjustKeywordPriority(proposal, context.getPrefix())
		if (proposal !== null) {
			proposal.setPriority(proposal.getPriority() * 2)
			acceptor.accept(proposal)
		}
	}

	override complete_Version(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		val versionProposals = new ArrayList
		val unit = model as UnitImpl
		val reposLoc = unit.eContainer as RepositoryLocation
		val reposLocName = reposLoc.name
		val unitManager = UnitManager.instance
		val mapOfUnits = unitManager.mapOfUnits
		if (mapOfUnits.containsKey(reposLocName)) {
			val listOfUnits = mapOfUnits.get(reposLocName)
			if (listOfUnits !== null) {
				for (u : listOfUnits) {
					versionProposals.add(u)
					acceptor.accept(createCompletionProposal(u.vers + ";", context))
				}
			}
		}
		super.complete_Version(model, ruleCall, context, acceptor)
	}

	override complete_Source(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		val sourceProposals = new ArrayList
		val unitManager = UnitManager.instance
		val reposLoc = unitManager.getRepositoryLocation(model)
		val reposLocName = reposLoc.name
		val listOfUnits = unitManager.getUnits(reposLocName)
		if (listOfUnits !== null) {
			for (u : listOfUnits) {
				sourceProposals.add(u)
				acceptor.accept(createCompletionProposal(u.source, context));
			}
			super.complete_Version(model, ruleCall, context, acceptor)
		}
	}
}
