/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.parser.antlr;

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.parser.antlr.internal.InternalOvertargetParser;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class OvertargetParser extends AbstractAntlrParser {

	@Inject
	private OvertargetGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalOvertargetParser createParser(XtextTokenStream stream) {
		return new InternalOvertargetParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "TargetFile";
	}

	public OvertargetGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(OvertargetGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
