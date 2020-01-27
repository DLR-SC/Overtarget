/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalOvertarget;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package de.dlr.sc.overtarget.language.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package de.dlr.sc.overtarget.language.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;

}
@parser::members {
	private OvertargetGrammarAccess grammarAccess;

	public void setGrammarAccess(OvertargetGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleTargetFile
entryRuleTargetFile
:
{ before(grammarAccess.getTargetFileRule()); }
	 ruleTargetFile
{ after(grammarAccess.getTargetFileRule()); } 
	 EOF 
;

// Rule TargetFile
ruleTargetFile 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTargetFileAccess().getAlternatives()); }
		(rule__TargetFile__Alternatives)
		{ after(grammarAccess.getTargetFileAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTargetLibrary
entryRuleTargetLibrary
:
{ before(grammarAccess.getTargetLibraryRule()); }
	 ruleTargetLibrary
{ after(grammarAccess.getTargetLibraryRule()); } 
	 EOF 
;

// Rule TargetLibrary
ruleTargetLibrary 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTargetLibraryAccess().getGroup()); }
		(rule__TargetLibrary__Group__0)
		{ after(grammarAccess.getTargetLibraryAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTargetModel
entryRuleTargetModel
:
{ before(grammarAccess.getTargetModelRule()); }
	 ruleTargetModel
{ after(grammarAccess.getTargetModelRule()); } 
	 EOF 
;

// Rule TargetModel
ruleTargetModel 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTargetModelAccess().getGroup()); }
		(rule__TargetModel__Group__0)
		{ after(grammarAccess.getTargetModelAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVersion
entryRuleVersion
@init { 
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
:
{ before(grammarAccess.getVersionRule()); }
	 ruleVersion
{ after(grammarAccess.getVersionRule()); } 
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Version
ruleVersion 
	@init {
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVersionAccess().getGroup()); }
		(rule__Version__Group__0)
		{ after(grammarAccess.getVersionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
	myHiddenTokenState.restore();
}

// Entry rule entryRuleSimpleVersion
entryRuleSimpleVersion
:
{ before(grammarAccess.getSimpleVersionRule()); }
	 ruleSimpleVersion
{ after(grammarAccess.getSimpleVersionRule()); } 
	 EOF 
;

// Rule SimpleVersion
ruleSimpleVersion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSimpleVersionAccess().getGroup()); }
		(rule__SimpleVersion__Group__0)
		{ after(grammarAccess.getSimpleVersionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUnit
entryRuleUnit
:
{ before(grammarAccess.getUnitRule()); }
	 ruleUnit
{ after(grammarAccess.getUnitRule()); } 
	 EOF 
;

// Rule Unit
ruleUnit 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUnitAccess().getGroup()); }
		(rule__Unit__Group__0)
		{ after(grammarAccess.getUnitAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSource
entryRuleSource
@init { 
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
:
{ before(grammarAccess.getSourceRule()); }
	 ruleSource
{ after(grammarAccess.getSourceRule()); } 
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Source
ruleSource 
	@init {
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSourceAccess().getGroup()); }
		(rule__Source__Group__0)
		{ after(grammarAccess.getSourceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
	myHiddenTokenState.restore();
}

// Entry rule entryRuleUrlExpression
entryRuleUrlExpression
:
{ before(grammarAccess.getUrlExpressionRule()); }
	 ruleUrlExpression
{ after(grammarAccess.getUrlExpressionRule()); } 
	 EOF 
;

// Rule UrlExpression
ruleUrlExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUrlExpressionAccess().getGroup()); }
		(rule__UrlExpression__Group__0)
		{ after(grammarAccess.getUrlExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUrlElement
entryRuleUrlElement
:
{ before(grammarAccess.getUrlElementRule()); }
	 ruleUrlElement
{ after(grammarAccess.getUrlElementRule()); } 
	 EOF 
;

// Rule UrlElement
ruleUrlElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUrlElementAccess().getAlternatives()); }
		(rule__UrlElement__Alternatives)
		{ after(grammarAccess.getUrlElementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUrlElementString
entryRuleUrlElementString
:
{ before(grammarAccess.getUrlElementStringRule()); }
	 ruleUrlElementString
{ after(grammarAccess.getUrlElementStringRule()); } 
	 EOF 
;

// Rule UrlElementString
ruleUrlElementString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUrlElementStringAccess().getContentAssignment()); }
		(rule__UrlElementString__ContentAssignment)
		{ after(grammarAccess.getUrlElementStringAccess().getContentAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUrlElementVariable
entryRuleUrlElementVariable
:
{ before(grammarAccess.getUrlElementVariableRule()); }
	 ruleUrlElementVariable
{ after(grammarAccess.getUrlElementVariableRule()); } 
	 EOF 
;

// Rule UrlElementVariable
ruleUrlElementVariable 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUrlElementVariableAccess().getContentAssignment()); }
		(rule__UrlElementVariable__ContentAssignment)
		{ after(grammarAccess.getUrlElementVariableAccess().getContentAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRepositoryLocation
entryRuleRepositoryLocation
:
{ before(grammarAccess.getRepositoryLocationRule()); }
	 ruleRepositoryLocation
{ after(grammarAccess.getRepositoryLocationRule()); } 
	 EOF 
;

// Rule RepositoryLocation
ruleRepositoryLocation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRepositoryLocationAccess().getGroup()); }
		(rule__RepositoryLocation__Group__0)
		{ after(grammarAccess.getRepositoryLocationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExcludeLocation
entryRuleExcludeLocation
:
{ before(grammarAccess.getExcludeLocationRule()); }
	 ruleExcludeLocation
{ after(grammarAccess.getExcludeLocationRule()); } 
	 EOF 
;

// Rule ExcludeLocation
ruleExcludeLocation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExcludeLocationAccess().getGroup()); }
		(rule__ExcludeLocation__Group__0)
		{ after(grammarAccess.getExcludeLocationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVariableDefinition
entryRuleVariableDefinition
:
{ before(grammarAccess.getVariableDefinitionRule()); }
	 ruleVariableDefinition
{ after(grammarAccess.getVariableDefinitionRule()); } 
	 EOF 
;

// Rule VariableDefinition
ruleVariableDefinition 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVariableDefinitionAccess().getAlternatives()); }
		(rule__VariableDefinition__Alternatives)
		{ after(grammarAccess.getVariableDefinitionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAlreadyDeclaredVariable
entryRuleAlreadyDeclaredVariable
:
{ before(grammarAccess.getAlreadyDeclaredVariableRule()); }
	 ruleAlreadyDeclaredVariable
{ after(grammarAccess.getAlreadyDeclaredVariableRule()); } 
	 EOF 
;

// Rule AlreadyDeclaredVariable
ruleAlreadyDeclaredVariable 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAlreadyDeclaredVariableAccess().getGroup()); }
		(rule__AlreadyDeclaredVariable__Group__0)
		{ after(grammarAccess.getAlreadyDeclaredVariableAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNewVariableDefinition
entryRuleNewVariableDefinition
:
{ before(grammarAccess.getNewVariableDefinitionRule()); }
	 ruleNewVariableDefinition
{ after(grammarAccess.getNewVariableDefinitionRule()); } 
	 EOF 
;

// Rule NewVariableDefinition
ruleNewVariableDefinition 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNewVariableDefinitionAccess().getGroup()); }
		(rule__NewVariableDefinition__Group__0)
		{ after(grammarAccess.getNewVariableDefinitionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulequalifier
entryRulequalifier
:
{ before(grammarAccess.getQualifierRule()); }
	 rulequalifier
{ after(grammarAccess.getQualifierRule()); } 
	 EOF 
;

// Rule qualifier
rulequalifier 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQualifierAccess().getGroup()); }
		(rule__Qualifier__Group__0)
		{ after(grammarAccess.getQualifierAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOperatingSys
entryRuleOperatingSys
:
{ before(grammarAccess.getOperatingSysRule()); }
	 ruleOperatingSys
{ after(grammarAccess.getOperatingSysRule()); } 
	 EOF 
;

// Rule OperatingSys
ruleOperatingSys 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOperatingSysAccess().getAlternatives()); }
		(rule__OperatingSys__Alternatives)
		{ after(grammarAccess.getOperatingSysAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleWindowingSys
entryRuleWindowingSys
:
{ before(grammarAccess.getWindowingSysRule()); }
	 ruleWindowingSys
{ after(grammarAccess.getWindowingSysRule()); } 
	 EOF 
;

// Rule WindowingSys
ruleWindowingSys 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getWindowingSysAccess().getAlternatives()); }
		(rule__WindowingSys__Alternatives)
		{ after(grammarAccess.getWindowingSysAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleArchitecture
entryRuleArchitecture
:
{ before(grammarAccess.getArchitectureRule()); }
	 ruleArchitecture
{ after(grammarAccess.getArchitectureRule()); } 
	 EOF 
;

// Rule Architecture
ruleArchitecture 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArchitectureAccess().getAlternatives()); }
		(rule__Architecture__Alternatives)
		{ after(grammarAccess.getArchitectureAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLocale
entryRuleLocale
:
{ before(grammarAccess.getLocaleRule()); }
	 ruleLocale
{ after(grammarAccess.getLocaleRule()); } 
	 EOF 
;

// Rule Locale
ruleLocale 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLocaleAccess().getIDTerminalRuleCall()); }
		RULE_ID
		{ after(grammarAccess.getLocaleAccess().getIDTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuledot
entryRuledot
:
{ before(grammarAccess.getDotRule()); }
	 ruledot
{ after(grammarAccess.getDotRule()); } 
	 EOF 
;

// Rule dot
ruledot 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDotAccess().getFullStopKeyword()); }
		'.'
		{ after(grammarAccess.getDotAccess().getFullStopKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulehypen
entryRulehypen
:
{ before(grammarAccess.getHypenRule()); }
	 rulehypen
{ after(grammarAccess.getHypenRule()); } 
	 EOF 
;

// Rule hypen
rulehypen 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getHypenAccess().getHyphenMinusKeyword()); }
		'-'
		{ after(grammarAccess.getHypenAccess().getHyphenMinusKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulejre
entryRulejre
:
{ before(grammarAccess.getJreRule()); }
	 rulejre
{ after(grammarAccess.getJreRule()); } 
	 EOF 
;

// Rule jre
rulejre 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		(
			{ before(grammarAccess.getJreAccess().getAlternatives()); }
			(rule__Jre__Alternatives)
			{ after(grammarAccess.getJreAccess().getAlternatives()); }
		)
		(
			{ before(grammarAccess.getJreAccess().getAlternatives()); }
			(rule__Jre__Alternatives)*
			{ after(grammarAccess.getJreAccess().getAlternatives()); }
		)
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleValidID
entryRuleValidID
:
{ before(grammarAccess.getValidIDRule()); }
	 ruleValidID
{ after(grammarAccess.getValidIDRule()); } 
	 EOF 
;

// Rule ValidID
ruleValidID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getValidIDAccess().getAlternatives()); }
		(rule__ValidID__Alternatives)
		{ after(grammarAccess.getValidIDAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleKEYWORD
entryRuleKEYWORD
:
{ before(grammarAccess.getKEYWORDRule()); }
	 ruleKEYWORD
{ after(grammarAccess.getKEYWORDRule()); } 
	 EOF 
;

// Rule KEYWORD
ruleKEYWORD 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getKEYWORDAccess().getAlternatives()); }
		(rule__KEYWORD__Alternatives)
		{ after(grammarAccess.getKEYWORDAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName
:
{ before(grammarAccess.getQualifiedNameRule()); }
	 ruleQualifiedName
{ after(grammarAccess.getQualifiedNameRule()); } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQualifiedNameAccess().getGroup()); }
		(rule__QualifiedName__Group__0)
		{ after(grammarAccess.getQualifiedNameAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetFile__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetFileAccess().getTargetModelParserRuleCall_0()); }
		ruleTargetModel
		{ after(grammarAccess.getTargetFileAccess().getTargetModelParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTargetFileAccess().getTargetLibraryParserRuleCall_1()); }
		ruleTargetLibrary
		{ after(grammarAccess.getTargetFileAccess().getTargetLibraryParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__VersAlternatives_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnitAccess().getVersVersionParserRuleCall_3_0_0()); }
		ruleVersion
		{ after(grammarAccess.getUnitAccess().getVersVersionParserRuleCall_3_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getUnitAccess().getVersNewestKeyword_3_0_1()); }
		'newest'
		{ after(grammarAccess.getUnitAccess().getVersNewestKeyword_3_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSourceAccess().getGroup_1_0()); }
		(rule__Source__Group_1_0__0)
		{ after(grammarAccess.getSourceAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getSourceAccess().getGroup_1_1()); }
		(rule__Source__Group_1_1__0)
		{ after(grammarAccess.getSourceAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlElement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUrlElementAccess().getUrlElementVariableParserRuleCall_0()); }
		ruleUrlElementVariable
		{ after(grammarAccess.getUrlElementAccess().getUrlElementVariableParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getUrlElementAccess().getUrlElementStringParserRuleCall_1()); }
		ruleUrlElementString
		{ after(grammarAccess.getUrlElementAccess().getUrlElementStringParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Alternatives_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExcludeLocationAccess().getUnitsAssignment_4_0()); }
		(rule__ExcludeLocation__UnitsAssignment_4_0)*
		{ after(grammarAccess.getExcludeLocationAccess().getUnitsAssignment_4_0()); }
	)
	|
	(
		{ before(grammarAccess.getExcludeLocationAccess().getAllKeyword_4_1()); }
		'all;'
		{ after(grammarAccess.getExcludeLocationAccess().getAllKeyword_4_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDefinition__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableDefinitionAccess().getAlreadyDeclaredVariableParserRuleCall_0()); }
		ruleAlreadyDeclaredVariable
		{ after(grammarAccess.getVariableDefinitionAccess().getAlreadyDeclaredVariableParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getVariableDefinitionAccess().getNewVariableDefinitionParserRuleCall_1()); }
		ruleNewVariableDefinition
		{ after(grammarAccess.getVariableDefinitionAccess().getNewVariableDefinitionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQualifierAccess().getINTTerminalRuleCall_0_0()); }
		RULE_INT
		{ after(grammarAccess.getQualifierAccess().getINTTerminalRuleCall_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getQualifierAccess().getIDTerminalRuleCall_0_1()); }
		RULE_ID
		{ after(grammarAccess.getQualifierAccess().getIDTerminalRuleCall_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Alternatives_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQualifierAccess().getINTTerminalRuleCall_1_1_0()); }
		RULE_INT
		{ after(grammarAccess.getQualifierAccess().getINTTerminalRuleCall_1_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getQualifierAccess().getIDTerminalRuleCall_1_1_1()); }
		RULE_ID
		{ after(grammarAccess.getQualifierAccess().getIDTerminalRuleCall_1_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperatingSys__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperatingSysAccess().getAixKeyword_0()); }
		'aix'
		{ after(grammarAccess.getOperatingSysAccess().getAixKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getOperatingSysAccess().getHpuxKeyword_1()); }
		'hpux'
		{ after(grammarAccess.getOperatingSysAccess().getHpuxKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getOperatingSysAccess().getLinuxKeyword_2()); }
		'linux'
		{ after(grammarAccess.getOperatingSysAccess().getLinuxKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getOperatingSysAccess().getMacosxKeyword_3()); }
		'macosx'
		{ after(grammarAccess.getOperatingSysAccess().getMacosxKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getOperatingSysAccess().getQnxKeyword_4()); }
		'qnx'
		{ after(grammarAccess.getOperatingSysAccess().getQnxKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getOperatingSysAccess().getSolarisKeyword_5()); }
		'solaris'
		{ after(grammarAccess.getOperatingSysAccess().getSolarisKeyword_5()); }
	)
	|
	(
		{ before(grammarAccess.getOperatingSysAccess().getWin32Keyword_6()); }
		'win32'
		{ after(grammarAccess.getOperatingSysAccess().getWin32Keyword_6()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__WindowingSys__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWindowingSysAccess().getCarbonKeyword_0()); }
		'carbon'
		{ after(grammarAccess.getWindowingSysAccess().getCarbonKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getWindowingSysAccess().getCocoaKeyword_1()); }
		'cocoa'
		{ after(grammarAccess.getWindowingSysAccess().getCocoaKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getWindowingSysAccess().getGtkKeyword_2()); }
		'gtk'
		{ after(grammarAccess.getWindowingSysAccess().getGtkKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getWindowingSysAccess().getMotifKeyword_3()); }
		'motif'
		{ after(grammarAccess.getWindowingSysAccess().getMotifKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getWindowingSysAccess().getPhotonKeyword_4()); }
		'photon'
		{ after(grammarAccess.getWindowingSysAccess().getPhotonKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getWindowingSysAccess().getWpfKeyword_5()); }
		'wpf'
		{ after(grammarAccess.getWindowingSysAccess().getWpfKeyword_5()); }
	)
	|
	(
		{ before(grammarAccess.getWindowingSysAccess().getWin32Keyword_6()); }
		'win32'
		{ after(grammarAccess.getWindowingSysAccess().getWin32Keyword_6()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Architecture__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArchitectureAccess().getPA_RISCKeyword_0()); }
		'PA_RISC'
		{ after(grammarAccess.getArchitectureAccess().getPA_RISCKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getArchitectureAccess().getIa64Keyword_1()); }
		'ia64'
		{ after(grammarAccess.getArchitectureAccess().getIa64Keyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getArchitectureAccess().getIa64_32Keyword_2()); }
		'ia64_32'
		{ after(grammarAccess.getArchitectureAccess().getIa64_32Keyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getArchitectureAccess().getPpcKeyword_3()); }
		'ppc'
		{ after(grammarAccess.getArchitectureAccess().getPpcKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getArchitectureAccess().getSparcKeyword_4()); }
		'sparc'
		{ after(grammarAccess.getArchitectureAccess().getSparcKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getArchitectureAccess().getX86Keyword_5()); }
		'x86'
		{ after(grammarAccess.getArchitectureAccess().getX86Keyword_5()); }
	)
	|
	(
		{ before(grammarAccess.getArchitectureAccess().getX86_64Keyword_6()); }
		'x86_64'
		{ after(grammarAccess.getArchitectureAccess().getX86_64Keyword_6()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Jre__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJreAccess().getIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getJreAccess().getIDTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getJreAccess().getHyphenMinusKeyword_1()); }
		'-'
		{ after(grammarAccess.getJreAccess().getHyphenMinusKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getJreAccess().getSimpleVersionParserRuleCall_2()); }
		ruleSimpleVersion
		{ after(grammarAccess.getJreAccess().getSimpleVersionParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ValidID__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getValidIDAccess().getKEYWORDParserRuleCall_1()); }
		ruleKEYWORD
		{ after(grammarAccess.getValidIDAccess().getKEYWORDParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__KEYWORD__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getKEYWORDAccess().getUnitKeyword_0()); }
		'Unit'
		{ after(grammarAccess.getKEYWORDAccess().getUnitKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getKEYWORDAccess().getTargetKeyword_1()); }
		'Target'
		{ after(grammarAccess.getKEYWORDAccess().getTargetKeyword_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetLibrary__Group__0__Impl
	rule__TargetLibrary__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetLibraryAccess().getTargetLibraryKeyword_0()); }
	'TargetLibrary'
	{ after(grammarAccess.getTargetLibraryAccess().getTargetLibraryKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetLibrary__Group__1__Impl
	rule__TargetLibrary__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetLibraryAccess().getNameAssignment_1()); }
	(rule__TargetLibrary__NameAssignment_1)
	{ after(grammarAccess.getTargetLibraryAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetLibrary__Group__2__Impl
	rule__TargetLibrary__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetLibraryAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getTargetLibraryAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetLibrary__Group__3__Impl
	rule__TargetLibrary__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetLibraryAccess().getVariablesAssignment_3()); }
	(rule__TargetLibrary__VariablesAssignment_3)*
	{ after(grammarAccess.getTargetLibraryAccess().getVariablesAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetLibrary__Group__4__Impl
	rule__TargetLibrary__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetLibraryAccess().getRepositoryLocationsAssignment_4()); }
	(rule__TargetLibrary__RepositoryLocationsAssignment_4)*
	{ after(grammarAccess.getTargetLibraryAccess().getRepositoryLocationsAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetLibrary__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetLibraryAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getTargetLibraryAccess().getRightCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TargetModel__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__0__Impl
	rule__TargetModel__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getTargetKeyword_0()); }
	'Target'
	{ after(grammarAccess.getTargetModelAccess().getTargetKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__1__Impl
	rule__TargetModel__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getNameAssignment_1()); }
	(rule__TargetModel__NameAssignment_1)
	{ after(grammarAccess.getTargetModelAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__2__Impl
	rule__TargetModel__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getGroup_2()); }
	(rule__TargetModel__Group_2__0)?
	{ after(grammarAccess.getTargetModelAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__3__Impl
	rule__TargetModel__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getTargetModelAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__4__Impl
	rule__TargetModel__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getGroup_4()); }
	(rule__TargetModel__Group_4__0)*
	{ after(grammarAccess.getTargetModelAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__5__Impl
	rule__TargetModel__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getGroup_5()); }
	(rule__TargetModel__Group_5__0)?
	{ after(grammarAccess.getTargetModelAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__6__Impl
	rule__TargetModel__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getGroup_6()); }
	(rule__TargetModel__Group_6__0)?
	{ after(grammarAccess.getTargetModelAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__7__Impl
	rule__TargetModel__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getGroup_7()); }
	(rule__TargetModel__Group_7__0)?
	{ after(grammarAccess.getTargetModelAccess().getGroup_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__8__Impl
	rule__TargetModel__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getGroup_8()); }
	(rule__TargetModel__Group_8__0)?
	{ after(grammarAccess.getTargetModelAccess().getGroup_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__9__Impl
	rule__TargetModel__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getGroup_9()); }
	(rule__TargetModel__Group_9__0)?
	{ after(grammarAccess.getTargetModelAccess().getGroup_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__10__Impl
	rule__TargetModel__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getVariablesAssignment_10()); }
	(rule__TargetModel__VariablesAssignment_10)*
	{ after(grammarAccess.getTargetModelAccess().getVariablesAssignment_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__11
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__11__Impl
	rule__TargetModel__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__11__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getExcludedLocationsAssignment_11()); }
	(rule__TargetModel__ExcludedLocationsAssignment_11)*
	{ after(grammarAccess.getTargetModelAccess().getExcludedLocationsAssignment_11()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__12
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__12__Impl
	rule__TargetModel__Group__13
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__12__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getRepositoryLocationsAssignment_12()); }
	(rule__TargetModel__RepositoryLocationsAssignment_12)*
	{ after(grammarAccess.getTargetModelAccess().getRepositoryLocationsAssignment_12()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__13
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group__13__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group__13__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getRightCurlyBracketKeyword_13()); }
	'}'
	{ after(grammarAccess.getTargetModelAccess().getRightCurlyBracketKeyword_13()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TargetModel__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_2__0__Impl
	rule__TargetModel__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getExtendsKeyword_2_0()); }
	'extends'
	{ after(grammarAccess.getTargetModelAccess().getExtendsKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getSuperAssignment_2_1()); }
	(rule__TargetModel__SuperAssignment_2_1)
	{ after(grammarAccess.getTargetModelAccess().getSuperAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TargetModel__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_4__0__Impl
	rule__TargetModel__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getImportKeyword_4_0()); }
	'Import'
	{ after(grammarAccess.getTargetModelAccess().getImportKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getImportedModelsAssignment_4_1()); }
	(rule__TargetModel__ImportedModelsAssignment_4_1)
	{ after(grammarAccess.getTargetModelAccess().getImportedModelsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TargetModel__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_5__0__Impl
	rule__TargetModel__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getOperatingSystemKeyword_5_0()); }
	'OperatingSystem'
	{ after(grammarAccess.getTargetModelAccess().getOperatingSystemKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getOsAssignment_5_1()); }
	(rule__TargetModel__OsAssignment_5_1)
	{ after(grammarAccess.getTargetModelAccess().getOsAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TargetModel__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_6__0__Impl
	rule__TargetModel__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getWindowingSystemKeyword_6_0()); }
	'WindowingSystem'
	{ after(grammarAccess.getTargetModelAccess().getWindowingSystemKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getWsAssignment_6_1()); }
	(rule__TargetModel__WsAssignment_6_1)
	{ after(grammarAccess.getTargetModelAccess().getWsAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TargetModel__Group_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_7__0__Impl
	rule__TargetModel__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getArchitectureKeyword_7_0()); }
	'Architecture'
	{ after(grammarAccess.getTargetModelAccess().getArchitectureKeyword_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getArchAssignment_7_1()); }
	(rule__TargetModel__ArchAssignment_7_1)
	{ after(grammarAccess.getTargetModelAccess().getArchAssignment_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TargetModel__Group_8__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_8__0__Impl
	rule__TargetModel__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_8__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getLocaleKeyword_8_0()); }
	'Locale'
	{ after(grammarAccess.getTargetModelAccess().getLocaleKeyword_8_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_8__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_8__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getLocAssignment_8_1()); }
	(rule__TargetModel__LocAssignment_8_1)
	{ after(grammarAccess.getTargetModelAccess().getLocAssignment_8_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TargetModel__Group_9__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_9__0__Impl
	rule__TargetModel__Group_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_9__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getTargetJREKeyword_9_0()); }
	'TargetJRE'
	{ after(grammarAccess.getTargetModelAccess().getTargetJREKeyword_9_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_9__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TargetModel__Group_9__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__Group_9__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTargetModelAccess().getTargetJreAssignment_9_1()); }
	(rule__TargetModel__TargetJreAssignment_9_1)
	{ after(grammarAccess.getTargetModelAccess().getTargetJreAssignment_9_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Version__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Version__Group__0__Impl
	rule__Version__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); }
	RULE_INT
	{ after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Version__Group__1__Impl
	rule__Version__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVersionAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getVersionAccess().getFullStopKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Version__Group__2__Impl
	rule__Version__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_2()); }
	RULE_INT
	{ after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Version__Group__3__Impl
	rule__Version__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVersionAccess().getFullStopKeyword_3()); }
	'.'
	{ after(grammarAccess.getVersionAccess().getFullStopKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Version__Group__4__Impl
	rule__Version__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVersionAccess().getINTTerminalRuleCall_4()); }
	RULE_INT
	{ after(grammarAccess.getVersionAccess().getINTTerminalRuleCall_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Version__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVersionAccess().getGroup_5()); }
	(rule__Version__Group_5__0)?
	{ after(grammarAccess.getVersionAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Version__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Version__Group_5__0__Impl
	rule__Version__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVersionAccess().getFullStopKeyword_5_0()); }
	'.'
	{ after(grammarAccess.getVersionAccess().getFullStopKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Version__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Version__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVersionAccess().getQualifierParserRuleCall_5_1()); }
	rulequalifier
	{ after(grammarAccess.getVersionAccess().getQualifierParserRuleCall_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SimpleVersion__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SimpleVersion__Group__0__Impl
	rule__SimpleVersion__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleVersion__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSimpleVersionAccess().getINTTerminalRuleCall_0()); }
	RULE_INT
	{ after(grammarAccess.getSimpleVersionAccess().getINTTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleVersion__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SimpleVersion__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleVersion__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSimpleVersionAccess().getGroup_1()); }
	(rule__SimpleVersion__Group_1__0)*
	{ after(grammarAccess.getSimpleVersionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SimpleVersion__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SimpleVersion__Group_1__0__Impl
	rule__SimpleVersion__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleVersion__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSimpleVersionAccess().getFullStopKeyword_1_0()); }
	'.'
	{ after(grammarAccess.getSimpleVersionAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleVersion__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SimpleVersion__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleVersion__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSimpleVersionAccess().getINTTerminalRuleCall_1_1()); }
	RULE_INT
	{ after(grammarAccess.getSimpleVersionAccess().getINTTerminalRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Unit__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Unit__Group__0__Impl
	rule__Unit__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnitAccess().getUnitKeyword_0()); }
	'Unit'
	{ after(grammarAccess.getUnitAccess().getUnitKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Unit__Group__1__Impl
	rule__Unit__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnitAccess().getSourceAssignment_1()); }
	(rule__Unit__SourceAssignment_1)
	{ after(grammarAccess.getUnitAccess().getSourceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Unit__Group__2__Impl
	rule__Unit__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnitAccess().getVersionKeyword_2()); }
	'version'
	{ after(grammarAccess.getUnitAccess().getVersionKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Unit__Group__3__Impl
	rule__Unit__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnitAccess().getVersAssignment_3()); }
	(rule__Unit__VersAssignment_3)
	{ after(grammarAccess.getUnitAccess().getVersAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Unit__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnitAccess().getSemicolonKeyword_4()); }
	';'
	{ after(grammarAccess.getUnitAccess().getSemicolonKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Source__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Source__Group__0__Impl
	rule__Source__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSourceAccess().getValidIDParserRuleCall_0()); }
	ruleValidID
	{ after(grammarAccess.getSourceAccess().getValidIDParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Source__Group__1__Impl
	rule__Source__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSourceAccess().getAlternatives_1()); }
	(rule__Source__Alternatives_1)*
	{ after(grammarAccess.getSourceAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Source__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSourceAccess().getColonKeyword_2()); }
	(':')?
	{ after(grammarAccess.getSourceAccess().getColonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Source__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Source__Group_1_0__0__Impl
	rule__Source__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSourceAccess().getDotParserRuleCall_1_0_0()); }
	ruledot
	{ after(grammarAccess.getSourceAccess().getDotParserRuleCall_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Source__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSourceAccess().getValidIDParserRuleCall_1_0_1()); }
	ruleValidID
	{ after(grammarAccess.getSourceAccess().getValidIDParserRuleCall_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Source__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Source__Group_1_1__0__Impl
	rule__Source__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSourceAccess().getHypenParserRuleCall_1_1_0()); }
	rulehypen
	{ after(grammarAccess.getSourceAccess().getHypenParserRuleCall_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Source__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSourceAccess().getValidIDParserRuleCall_1_1_1()); }
	ruleValidID
	{ after(grammarAccess.getSourceAccess().getValidIDParserRuleCall_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UrlExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UrlExpression__Group__0__Impl
	rule__UrlExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUrlExpressionAccess().getUrlElementParserRuleCall_0()); }
	ruleUrlElement
	{ after(grammarAccess.getUrlExpressionAccess().getUrlElementParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UrlExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUrlExpressionAccess().getGroup_1()); }
	(rule__UrlExpression__Group_1__0)*
	{ after(grammarAccess.getUrlExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UrlExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UrlExpression__Group_1__0__Impl
	rule__UrlExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUrlExpressionAccess().getUrlExpressionLeftAction_1_0()); }
	()
	{ after(grammarAccess.getUrlExpressionAccess().getUrlExpressionLeftAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UrlExpression__Group_1__1__Impl
	rule__UrlExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUrlExpressionAccess().getPlusSignKeyword_1_1()); }
	'+'
	{ after(grammarAccess.getUrlExpressionAccess().getPlusSignKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UrlExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUrlExpressionAccess().getRightAssignment_1_2()); }
	(rule__UrlExpression__RightAssignment_1_2)
	{ after(grammarAccess.getUrlExpressionAccess().getRightAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RepositoryLocation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RepositoryLocation__Group__0__Impl
	rule__RepositoryLocation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRepositoryLocationAccess().getRepositoryLocationKeyword_0()); }
	'RepositoryLocation'
	{ after(grammarAccess.getRepositoryLocationAccess().getRepositoryLocationKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RepositoryLocation__Group__1__Impl
	rule__RepositoryLocation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRepositoryLocationAccess().getNameAssignment_1()); }
	(rule__RepositoryLocation__NameAssignment_1)
	{ after(grammarAccess.getRepositoryLocationAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RepositoryLocation__Group__2__Impl
	rule__RepositoryLocation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRepositoryLocationAccess().getUrlKeyword_2()); }
	'url'
	{ after(grammarAccess.getRepositoryLocationAccess().getUrlKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RepositoryLocation__Group__3__Impl
	rule__RepositoryLocation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRepositoryLocationAccess().getUrlAssignment_3()); }
	(rule__RepositoryLocation__UrlAssignment_3)
	{ after(grammarAccess.getRepositoryLocationAccess().getUrlAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RepositoryLocation__Group__4__Impl
	rule__RepositoryLocation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRepositoryLocationAccess().getLeftCurlyBracketKeyword_4()); }
	'{'
	{ after(grammarAccess.getRepositoryLocationAccess().getLeftCurlyBracketKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RepositoryLocation__Group__5__Impl
	rule__RepositoryLocation__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRepositoryLocationAccess().getUnitsAssignment_5()); }
	(rule__RepositoryLocation__UnitsAssignment_5)*
	{ after(grammarAccess.getRepositoryLocationAccess().getUnitsAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RepositoryLocation__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRepositoryLocationAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getRepositoryLocationAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ExcludeLocation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExcludeLocation__Group__0__Impl
	rule__ExcludeLocation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExcludeLocationAccess().getExcludeLocationAction_0()); }
	()
	{ after(grammarAccess.getExcludeLocationAccess().getExcludeLocationAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExcludeLocation__Group__1__Impl
	rule__ExcludeLocation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExcludeLocationAccess().getExcludeLocationKeyword_1()); }
	'ExcludeLocation'
	{ after(grammarAccess.getExcludeLocationAccess().getExcludeLocationKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExcludeLocation__Group__2__Impl
	rule__ExcludeLocation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExcludeLocationAccess().getRepositoryLocationAssignment_2()); }
	(rule__ExcludeLocation__RepositoryLocationAssignment_2)
	{ after(grammarAccess.getExcludeLocationAccess().getRepositoryLocationAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExcludeLocation__Group__3__Impl
	rule__ExcludeLocation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExcludeLocationAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getExcludeLocationAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExcludeLocation__Group__4__Impl
	rule__ExcludeLocation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExcludeLocationAccess().getAlternatives_4()); }
	(rule__ExcludeLocation__Alternatives_4)
	{ after(grammarAccess.getExcludeLocationAccess().getAlternatives_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExcludeLocation__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExcludeLocationAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getExcludeLocationAccess().getRightCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AlreadyDeclaredVariable__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AlreadyDeclaredVariable__Group__0__Impl
	rule__AlreadyDeclaredVariable__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AlreadyDeclaredVariable__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAlreadyDeclaredVariableAccess().getOverrideKeyword_0()); }
	'Override'
	{ after(grammarAccess.getAlreadyDeclaredVariableAccess().getOverrideKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AlreadyDeclaredVariable__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AlreadyDeclaredVariable__Group__1__Impl
	rule__AlreadyDeclaredVariable__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AlreadyDeclaredVariable__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAlreadyDeclaredVariableAccess().getRefAssignment_1()); }
	(rule__AlreadyDeclaredVariable__RefAssignment_1)
	{ after(grammarAccess.getAlreadyDeclaredVariableAccess().getRefAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AlreadyDeclaredVariable__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AlreadyDeclaredVariable__Group__2__Impl
	rule__AlreadyDeclaredVariable__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AlreadyDeclaredVariable__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAlreadyDeclaredVariableAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getAlreadyDeclaredVariableAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AlreadyDeclaredVariable__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AlreadyDeclaredVariable__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AlreadyDeclaredVariable__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAlreadyDeclaredVariableAccess().getValueAssignment_3()); }
	(rule__AlreadyDeclaredVariable__ValueAssignment_3)
	{ after(grammarAccess.getAlreadyDeclaredVariableAccess().getValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NewVariableDefinition__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NewVariableDefinition__Group__0__Impl
	rule__NewVariableDefinition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NewVariableDefinition__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNewVariableDefinitionAccess().getVariableKeyword_0()); }
	'Variable'
	{ after(grammarAccess.getNewVariableDefinitionAccess().getVariableKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NewVariableDefinition__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NewVariableDefinition__Group__1__Impl
	rule__NewVariableDefinition__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NewVariableDefinition__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNewVariableDefinitionAccess().getNameAssignment_1()); }
	(rule__NewVariableDefinition__NameAssignment_1)
	{ after(grammarAccess.getNewVariableDefinitionAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NewVariableDefinition__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NewVariableDefinition__Group__2__Impl
	rule__NewVariableDefinition__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NewVariableDefinition__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNewVariableDefinitionAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getNewVariableDefinitionAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NewVariableDefinition__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NewVariableDefinition__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NewVariableDefinition__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNewVariableDefinitionAccess().getValueAssignment_3()); }
	(rule__NewVariableDefinition__ValueAssignment_3)
	{ after(grammarAccess.getNewVariableDefinitionAccess().getValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Qualifier__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Qualifier__Group__0__Impl
	rule__Qualifier__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getQualifierAccess().getAlternatives_0()); }
		(rule__Qualifier__Alternatives_0)
		{ after(grammarAccess.getQualifierAccess().getAlternatives_0()); }
	)
	(
		{ before(grammarAccess.getQualifierAccess().getAlternatives_0()); }
		(rule__Qualifier__Alternatives_0)*
		{ after(grammarAccess.getQualifierAccess().getAlternatives_0()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Qualifier__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifierAccess().getGroup_1()); }
	(rule__Qualifier__Group_1__0)?
	{ after(grammarAccess.getQualifierAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Qualifier__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Qualifier__Group_1__0__Impl
	rule__Qualifier__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifierAccess().getHyphenMinusKeyword_1_0()); }
	'-'
	{ after(grammarAccess.getQualifierAccess().getHyphenMinusKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Qualifier__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Qualifier__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifierAccess().getAlternatives_1_1()); }
	(rule__Qualifier__Alternatives_1_1)
	{ after(grammarAccess.getQualifierAccess().getAlternatives_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__0__Impl
	rule__QualifiedName__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
	{ after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
	(rule__QualifiedName__Group_1__0)*
	{ after(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__0__Impl
	rule__QualifiedName__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
	'.'
	{ after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
	{ after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TargetLibrary__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetLibraryAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getTargetLibraryAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__VariablesAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetLibraryAccess().getVariablesVariableDefinitionParserRuleCall_3_0()); }
		ruleVariableDefinition
		{ after(grammarAccess.getTargetLibraryAccess().getVariablesVariableDefinitionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetLibrary__RepositoryLocationsAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetLibraryAccess().getRepositoryLocationsRepositoryLocationParserRuleCall_4_0()); }
		ruleRepositoryLocation
		{ after(grammarAccess.getTargetLibraryAccess().getRepositoryLocationsRepositoryLocationParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getTargetModelAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__SuperAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getSuperTargetModelCrossReference_2_1_0()); }
		(
			{ before(grammarAccess.getTargetModelAccess().getSuperTargetModelIDTerminalRuleCall_2_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getTargetModelAccess().getSuperTargetModelIDTerminalRuleCall_2_1_0_1()); }
		)
		{ after(grammarAccess.getTargetModelAccess().getSuperTargetModelCrossReference_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__ImportedModelsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getImportedModelsTargetFileCrossReference_4_1_0()); }
		(
			{ before(grammarAccess.getTargetModelAccess().getImportedModelsTargetFileIDTerminalRuleCall_4_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getTargetModelAccess().getImportedModelsTargetFileIDTerminalRuleCall_4_1_0_1()); }
		)
		{ after(grammarAccess.getTargetModelAccess().getImportedModelsTargetFileCrossReference_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__OsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getOsOperatingSysParserRuleCall_5_1_0()); }
		ruleOperatingSys
		{ after(grammarAccess.getTargetModelAccess().getOsOperatingSysParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__WsAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getWsWindowingSysParserRuleCall_6_1_0()); }
		ruleWindowingSys
		{ after(grammarAccess.getTargetModelAccess().getWsWindowingSysParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__ArchAssignment_7_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getArchArchitectureParserRuleCall_7_1_0()); }
		ruleArchitecture
		{ after(grammarAccess.getTargetModelAccess().getArchArchitectureParserRuleCall_7_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__LocAssignment_8_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getLocLocaleParserRuleCall_8_1_0()); }
		ruleLocale
		{ after(grammarAccess.getTargetModelAccess().getLocLocaleParserRuleCall_8_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__TargetJreAssignment_9_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getTargetJreJreParserRuleCall_9_1_0()); }
		rulejre
		{ after(grammarAccess.getTargetModelAccess().getTargetJreJreParserRuleCall_9_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__VariablesAssignment_10
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getVariablesVariableDefinitionParserRuleCall_10_0()); }
		ruleVariableDefinition
		{ after(grammarAccess.getTargetModelAccess().getVariablesVariableDefinitionParserRuleCall_10_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__ExcludedLocationsAssignment_11
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getExcludedLocationsExcludeLocationParserRuleCall_11_0()); }
		ruleExcludeLocation
		{ after(grammarAccess.getTargetModelAccess().getExcludedLocationsExcludeLocationParserRuleCall_11_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TargetModel__RepositoryLocationsAssignment_12
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTargetModelAccess().getRepositoryLocationsRepositoryLocationParserRuleCall_12_0()); }
		ruleRepositoryLocation
		{ after(grammarAccess.getTargetModelAccess().getRepositoryLocationsRepositoryLocationParserRuleCall_12_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__SourceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnitAccess().getSourceSourceParserRuleCall_1_0()); }
		ruleSource
		{ after(grammarAccess.getUnitAccess().getSourceSourceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Unit__VersAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnitAccess().getVersAlternatives_3_0()); }
		(rule__Unit__VersAlternatives_3_0)
		{ after(grammarAccess.getUnitAccess().getVersAlternatives_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlExpression__RightAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUrlExpressionAccess().getRightUrlElementParserRuleCall_1_2_0()); }
		ruleUrlElement
		{ after(grammarAccess.getUrlExpressionAccess().getRightUrlElementParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlElementString__ContentAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUrlElementStringAccess().getContentSTRINGTerminalRuleCall_0()); }
		RULE_STRING
		{ after(grammarAccess.getUrlElementStringAccess().getContentSTRINGTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UrlElementVariable__ContentAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUrlElementVariableAccess().getContentVariableDefinitionCrossReference_0()); }
		(
			{ before(grammarAccess.getUrlElementVariableAccess().getContentVariableDefinitionQualifiedNameParserRuleCall_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getUrlElementVariableAccess().getContentVariableDefinitionQualifiedNameParserRuleCall_0_1()); }
		)
		{ after(grammarAccess.getUrlElementVariableAccess().getContentVariableDefinitionCrossReference_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRepositoryLocationAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getRepositoryLocationAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__UrlAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRepositoryLocationAccess().getUrlUrlExpressionParserRuleCall_3_0()); }
		ruleUrlExpression
		{ after(grammarAccess.getRepositoryLocationAccess().getUrlUrlExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RepositoryLocation__UnitsAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRepositoryLocationAccess().getUnitsUnitParserRuleCall_5_0()); }
		ruleUnit
		{ after(grammarAccess.getRepositoryLocationAccess().getUnitsUnitParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__RepositoryLocationAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExcludeLocationAccess().getRepositoryLocationRepositoryLocationCrossReference_2_0()); }
		(
			{ before(grammarAccess.getExcludeLocationAccess().getRepositoryLocationRepositoryLocationQualifiedNameParserRuleCall_2_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getExcludeLocationAccess().getRepositoryLocationRepositoryLocationQualifiedNameParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getExcludeLocationAccess().getRepositoryLocationRepositoryLocationCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExcludeLocation__UnitsAssignment_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExcludeLocationAccess().getUnitsUnitParserRuleCall_4_0_0()); }
		ruleUnit
		{ after(grammarAccess.getExcludeLocationAccess().getUnitsUnitParserRuleCall_4_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AlreadyDeclaredVariable__RefAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAlreadyDeclaredVariableAccess().getRefNewVariableDefinitionCrossReference_1_0()); }
		(
			{ before(grammarAccess.getAlreadyDeclaredVariableAccess().getRefNewVariableDefinitionQualifiedNameParserRuleCall_1_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getAlreadyDeclaredVariableAccess().getRefNewVariableDefinitionQualifiedNameParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getAlreadyDeclaredVariableAccess().getRefNewVariableDefinitionCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AlreadyDeclaredVariable__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAlreadyDeclaredVariableAccess().getValueSTRINGTerminalRuleCall_3_0()); }
		RULE_STRING
		{ after(grammarAccess.getAlreadyDeclaredVariableAccess().getValueSTRINGTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NewVariableDefinition__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNewVariableDefinitionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getNewVariableDefinitionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NewVariableDefinition__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNewVariableDefinitionAccess().getValueSTRINGTerminalRuleCall_3_0()); }
		RULE_STRING
		{ after(grammarAccess.getNewVariableDefinitionAccess().getValueSTRINGTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
