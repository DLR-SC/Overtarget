/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ui.contentassist;

import com.google.common.base.Objects;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.targetmodel.impl.UnitImpl;
import de.dlr.sc.overtarget.language.ui.contentassist.AbstractOvertargetProposalProvider;
import de.dlr.sc.overtarget.language.util.QueryManager;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import javax.inject.Inject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
@SuppressWarnings("all")
public class OvertargetProposalProvider extends AbstractOvertargetProposalProvider {
  @Override
  public void complete_OperatingSys(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final Consumer<String> _function = (String it) -> {
      acceptor.accept(this.createCompletionProposal(it, context));
    };
    ((List<String>)Conversions.doWrapArray(Platform.knownOSValues())).forEach(_function);
    super.complete_OperatingSys(model, ruleCall, context, acceptor);
  }
  
  @Override
  public void complete_Architecture(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final Consumer<String> _function = (String it) -> {
      acceptor.accept(this.createCompletionProposal(it, context));
    };
    ((List<String>)Conversions.doWrapArray(Platform.knownOSArchValues())).forEach(_function);
    super.complete_Architecture(model, ruleCall, context, acceptor);
  }
  
  @Override
  public void complete_WindowingSys(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final Consumer<String> _function = (String it) -> {
      acceptor.accept(this.createCompletionProposal(it, context));
    };
    ((List<String>)Conversions.doWrapArray(Platform.knownWSValues())).forEach(_function);
    super.complete_WindowingSys(model, ruleCall, context, acceptor);
  }
  
  @Override
  public void complete_Locale(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final Locale[] list = DateFormat.getAvailableLocales();
    int _size = ((List<Locale>)Conversions.doWrapArray(list)).size();
    ExclusiveRange _greaterThanDoubleDot = new ExclusiveRange(_size, 0, false);
    for (final Integer i : _greaterThanDoubleDot) {
      {
        final Locale element = list[(i).intValue()];
        String _country = element.getCountry();
        boolean _equals = Objects.equal(_country, "");
        if (_equals) {
          acceptor.accept(this.createCompletionProposal(element.getLanguage(), context));
        } else {
          String _language = element.getLanguage();
          String _plus = (_language + "_");
          String _country_1 = element.getCountry();
          String _plus_1 = (_plus + _country_1);
          acceptor.accept(this.createCompletionProposal(_plus_1, context));
        }
      }
    }
    super.complete_Locale(model, ruleCall, context, acceptor);
  }
  
  @Inject
  private OvertargetGrammarAccess grammarAccess;
  
  @Override
  public void completeRepositoryLocation_Units(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal("Unit", "Unit", this.getImage(this.grammarAccess.getUnitRule()), context));
    acceptor.accept(this.createCompletionProposal("version", "version", this.getImage(this.grammarAccess.getUnitRule()), context));
    super.completeRepositoryLocation_Units(model, assignment, context, acceptor);
  }
  
  @Override
  public void complete_Version(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final QueryManager queryManager = new QueryManager();
    final UnitImpl unit = ((UnitImpl) model);
    final ArrayList<Unit> results = queryManager.getUnits(model);
    final Function1<Unit, Boolean> _function = (Unit it) -> {
      String _source = it.getSource();
      String _source_1 = unit.getSource();
      return Boolean.valueOf(Objects.equal(_source, _source_1));
    };
    final Consumer<Unit> _function_1 = (Unit it) -> {
      acceptor.accept(this.createCompletionProposal(it.getVers(), context));
    };
    IterableExtensions.<Unit>filter(results, _function).forEach(_function_1);
    acceptor.accept(this.createCompletionProposal("version", context));
    super.complete_Version(model, ruleCall, context, acceptor);
  }
  
  @Override
  public void complete_Source(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final QueryManager queryManager = new QueryManager();
    acceptor.accept(this.createCompletionProposal("version", context));
    final ArrayList<Unit> results = queryManager.getUnits(model);
    final Consumer<Unit> _function = (Unit it) -> {
      acceptor.accept(this.createCompletionProposal(it.getSource(), context));
    };
    results.forEach(_function);
    super.complete_Source(model, ruleCall, context, acceptor);
  }
}
