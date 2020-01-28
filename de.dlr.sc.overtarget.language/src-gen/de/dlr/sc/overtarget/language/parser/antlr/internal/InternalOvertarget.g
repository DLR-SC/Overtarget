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
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package de.dlr.sc.overtarget.language.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package de.dlr.sc.overtarget.language.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;

}

@parser::members {

 	private OvertargetGrammarAccess grammarAccess;

    public InternalOvertargetParser(TokenStream input, OvertargetGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "TargetFile";
   	}

   	@Override
   	protected OvertargetGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleTargetFile
entryRuleTargetFile returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTargetFileRule()); }
	iv_ruleTargetFile=ruleTargetFile
	{ $current=$iv_ruleTargetFile.current; }
	EOF;

// Rule TargetFile
ruleTargetFile returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTargetFileAccess().getTargetModelParserRuleCall_0());
		}
		this_TargetModel_0=ruleTargetModel
		{
			$current = $this_TargetModel_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTargetFileAccess().getTargetLibraryParserRuleCall_1());
		}
		this_TargetLibrary_1=ruleTargetLibrary
		{
			$current = $this_TargetLibrary_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTargetLibrary
entryRuleTargetLibrary returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTargetLibraryRule()); }
	iv_ruleTargetLibrary=ruleTargetLibrary
	{ $current=$iv_ruleTargetLibrary.current; }
	EOF;

// Rule TargetLibrary
ruleTargetLibrary returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='TargetLibrary'
		{
			newLeafNode(otherlv_0, grammarAccess.getTargetLibraryAccess().getTargetLibraryKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getTargetLibraryAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTargetLibraryRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getTargetLibraryAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTargetLibraryAccess().getVariablesVariableDefinitionParserRuleCall_3_0());
				}
				lv_variables_3_0=ruleVariableDefinition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTargetLibraryRule());
					}
					add(
						$current,
						"variables",
						lv_variables_3_0,
						"de.dlr.sc.overtarget.language.Overtarget.VariableDefinition");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getTargetLibraryAccess().getRepositoryLocationsRepositoryLocationParserRuleCall_4_0());
				}
				lv_repositoryLocations_4_0=ruleRepositoryLocation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTargetLibraryRule());
					}
					add(
						$current,
						"repositoryLocations",
						lv_repositoryLocations_4_0,
						"de.dlr.sc.overtarget.language.Overtarget.RepositoryLocation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getTargetLibraryAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleTargetModel
entryRuleTargetModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTargetModelRule()); }
	iv_ruleTargetModel=ruleTargetModel
	{ $current=$iv_ruleTargetModel.current; }
	EOF;

// Rule TargetModel
ruleTargetModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Target'
		{
			newLeafNode(otherlv_0, grammarAccess.getTargetModelAccess().getTargetKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getTargetModelAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTargetModelRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_2='extends'
			{
				newLeafNode(otherlv_2, grammarAccess.getTargetModelAccess().getExtendsKeyword_2_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTargetModelRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getTargetModelAccess().getSuperTargetModelCrossReference_2_1_0());
					}
				)
			)
		)?
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getTargetModelAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			otherlv_5='Import'
			{
				newLeafNode(otherlv_5, grammarAccess.getTargetModelAccess().getImportKeyword_4_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTargetModelRule());
						}
					}
					otherlv_6=RULE_ID
					{
						newLeafNode(otherlv_6, grammarAccess.getTargetModelAccess().getImportedModelsTargetFileCrossReference_4_1_0());
					}
				)
			)
		)*
		(
			otherlv_7='OperatingSystem'
			{
				newLeafNode(otherlv_7, grammarAccess.getTargetModelAccess().getOperatingSystemKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTargetModelAccess().getOsOperatingSysParserRuleCall_5_1_0());
					}
					lv_os_8_0=ruleOperatingSys
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTargetModelRule());
						}
						set(
							$current,
							"os",
							lv_os_8_0,
							"de.dlr.sc.overtarget.language.Overtarget.OperatingSys");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_9='WindowingSystem'
			{
				newLeafNode(otherlv_9, grammarAccess.getTargetModelAccess().getWindowingSystemKeyword_6_0());
			}
			    |
			otherlv_10='WorkingSystem'
			{
				newLeafNode(otherlv_10, grammarAccess.getTargetModelAccess().getWorkingSystemKeyword_6_1());
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getTargetModelAccess().getWsWindowingSysParserRuleCall_7_0());
				}
				lv_ws_11_0=ruleWindowingSys
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTargetModelRule());
					}
					set(
						$current,
						"ws",
						lv_ws_11_0,
						"de.dlr.sc.overtarget.language.Overtarget.WindowingSys");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_12='Architecture'
			{
				newLeafNode(otherlv_12, grammarAccess.getTargetModelAccess().getArchitectureKeyword_8_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTargetModelAccess().getArchArchitectureParserRuleCall_8_1_0());
					}
					lv_arch_13_0=ruleArchitecture
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTargetModelRule());
						}
						set(
							$current,
							"arch",
							lv_arch_13_0,
							"de.dlr.sc.overtarget.language.Overtarget.Architecture");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_14='Locale'
			{
				newLeafNode(otherlv_14, grammarAccess.getTargetModelAccess().getLocaleKeyword_9_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTargetModelAccess().getLocLocaleParserRuleCall_9_1_0());
					}
					lv_loc_15_0=ruleLocale
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTargetModelRule());
						}
						set(
							$current,
							"loc",
							lv_loc_15_0,
							"de.dlr.sc.overtarget.language.Overtarget.Locale");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_16='TargetJRE'
			{
				newLeafNode(otherlv_16, grammarAccess.getTargetModelAccess().getTargetJREKeyword_10_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTargetModelAccess().getTargetJreJreParserRuleCall_10_1_0());
					}
					lv_targetJre_17_0=rulejre
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTargetModelRule());
						}
						set(
							$current,
							"targetJre",
							lv_targetJre_17_0,
							"de.dlr.sc.overtarget.language.Overtarget.jre");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getTargetModelAccess().getVariablesVariableDefinitionParserRuleCall_11_0());
				}
				lv_variables_18_0=ruleVariableDefinition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTargetModelRule());
					}
					add(
						$current,
						"variables",
						lv_variables_18_0,
						"de.dlr.sc.overtarget.language.Overtarget.VariableDefinition");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getTargetModelAccess().getExcludedLocationsExcludeLocationParserRuleCall_12_0());
				}
				lv_excludedLocations_19_0=ruleExcludeLocation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTargetModelRule());
					}
					add(
						$current,
						"excludedLocations",
						lv_excludedLocations_19_0,
						"de.dlr.sc.overtarget.language.Overtarget.ExcludeLocation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getTargetModelAccess().getRepositoryLocationsRepositoryLocationParserRuleCall_13_0());
				}
				lv_repositoryLocations_20_0=ruleRepositoryLocation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTargetModelRule());
					}
					add(
						$current,
						"repositoryLocations",
						lv_repositoryLocations_20_0,
						"de.dlr.sc.overtarget.language.Overtarget.RepositoryLocation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_21='}'
		{
			newLeafNode(otherlv_21, grammarAccess.getTargetModelAccess().getRightCurlyBracketKeyword_14());
		}
	)
;

// Entry rule entryRuleVersion
entryRuleVersion returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getVersionRule()); }
	iv_ruleVersion=ruleVersion
	{ $current=$iv_ruleVersion.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Version
ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		this_INT_0=RULE_INT
		{
			$current.merge(this_INT_0);
		}
		{
			newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0());
		}
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1());
		}
		this_INT_2=RULE_INT
		{
			$current.merge(this_INT_2);
		}
		{
			newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_2());
		}
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_3());
		}
		this_INT_4=RULE_INT
		{
			$current.merge(this_INT_4);
		}
		{
			newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_4());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_5_0());
			}
			{
				newCompositeNode(grammarAccess.getVersionAccess().getQualifierParserRuleCall_5_1());
			}
			this_qualifier_6=rulequalifier
			{
				$current.merge(this_qualifier_6);
			}
			{
				afterParserOrEnumRuleCall();
			}
		)?
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleSimpleVersion
entryRuleSimpleVersion returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSimpleVersionRule()); }
	iv_ruleSimpleVersion=ruleSimpleVersion
	{ $current=$iv_ruleSimpleVersion.current.getText(); }
	EOF;

// Rule SimpleVersion
ruleSimpleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_INT_0=RULE_INT
		{
			$current.merge(this_INT_0);
		}
		{
			newLeafNode(this_INT_0, grammarAccess.getSimpleVersionAccess().getINTTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSimpleVersionAccess().getFullStopKeyword_1_0());
			}
			this_INT_2=RULE_INT
			{
				$current.merge(this_INT_2);
			}
			{
				newLeafNode(this_INT_2, grammarAccess.getSimpleVersionAccess().getINTTerminalRuleCall_1_1());
			}
		)*
	)
;

// Entry rule entryRuleUnit
entryRuleUnit returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnitRule()); }
	iv_ruleUnit=ruleUnit
	{ $current=$iv_ruleUnit.current; }
	EOF;

// Rule Unit
ruleUnit returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Unit'
		{
			newLeafNode(otherlv_0, grammarAccess.getUnitAccess().getUnitKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getUnitAccess().getSourceSourceParserRuleCall_1_0());
				}
				lv_source_1_0=ruleSource
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnitRule());
					}
					set(
						$current,
						"source",
						lv_source_1_0,
						"de.dlr.sc.overtarget.language.Overtarget.Source");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='version'
		{
			newLeafNode(otherlv_2, grammarAccess.getUnitAccess().getVersionKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getUnitAccess().getVersVersionParserRuleCall_3_0_0());
					}
					lv_vers_3_1=ruleVersion
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getUnitRule());
						}
						set(
							$current,
							"vers",
							lv_vers_3_1,
							"de.dlr.sc.overtarget.language.Overtarget.Version");
						afterParserOrEnumRuleCall();
					}
					    |
					lv_vers_3_2='newest'
					{
						newLeafNode(lv_vers_3_2, grammarAccess.getUnitAccess().getVersNewestKeyword_3_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getUnitRule());
						}
						setWithLastConsumed($current, "vers", lv_vers_3_2, null);
					}
				)
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getUnitAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleSource
entryRuleSource returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getSourceRule()); }
	iv_ruleSource=ruleSource
	{ $current=$iv_ruleSource.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Source
ruleSource returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSourceAccess().getValidIDParserRuleCall_0());
		}
		this_ValidID_0=ruleValidID
		{
			$current.merge(this_ValidID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSourceAccess().getDotParserRuleCall_1_0_0());
				}
				this_dot_1=ruledot
				{
					$current.merge(this_dot_1);
				}
				{
					afterParserOrEnumRuleCall();
				}
				{
					newCompositeNode(grammarAccess.getSourceAccess().getValidIDParserRuleCall_1_0_1());
				}
				this_ValidID_2=ruleValidID
				{
					$current.merge(this_ValidID_2);
				}
				{
					afterParserOrEnumRuleCall();
				}
			)
			    |
			(
				{
					newCompositeNode(grammarAccess.getSourceAccess().getHypenParserRuleCall_1_1_0());
				}
				this_hypen_3=rulehypen
				{
					$current.merge(this_hypen_3);
				}
				{
					afterParserOrEnumRuleCall();
				}
				{
					newCompositeNode(grammarAccess.getSourceAccess().getValidIDParserRuleCall_1_1_1());
				}
				this_ValidID_4=ruleValidID
				{
					$current.merge(this_ValidID_4);
				}
				{
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			kw=':'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSourceAccess().getColonKeyword_2());
			}
		)?
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleUrlExpression
entryRuleUrlExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUrlExpressionRule()); }
	iv_ruleUrlExpression=ruleUrlExpression
	{ $current=$iv_ruleUrlExpression.current; }
	EOF;

// Rule UrlExpression
ruleUrlExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getUrlExpressionAccess().getUrlElementParserRuleCall_0());
		}
		this_UrlElement_0=ruleUrlElement
		{
			$current = $this_UrlElement_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getUrlExpressionAccess().getUrlExpressionLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='+'
			{
				newLeafNode(otherlv_2, grammarAccess.getUrlExpressionAccess().getPlusSignKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getUrlExpressionAccess().getRightUrlElementParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleUrlElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getUrlExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"de.dlr.sc.overtarget.language.Overtarget.UrlElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleUrlElement
entryRuleUrlElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUrlElementRule()); }
	iv_ruleUrlElement=ruleUrlElement
	{ $current=$iv_ruleUrlElement.current; }
	EOF;

// Rule UrlElement
ruleUrlElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getUrlElementAccess().getUrlElementVariableParserRuleCall_0());
		}
		this_UrlElementVariable_0=ruleUrlElementVariable
		{
			$current = $this_UrlElementVariable_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getUrlElementAccess().getUrlElementStringParserRuleCall_1());
		}
		this_UrlElementString_1=ruleUrlElementString
		{
			$current = $this_UrlElementString_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleUrlElementString
entryRuleUrlElementString returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUrlElementStringRule()); }
	iv_ruleUrlElementString=ruleUrlElementString
	{ $current=$iv_ruleUrlElementString.current; }
	EOF;

// Rule UrlElementString
ruleUrlElementString returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_content_0_0=RULE_STRING
			{
				newLeafNode(lv_content_0_0, grammarAccess.getUrlElementStringAccess().getContentSTRINGTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getUrlElementStringRule());
				}
				setWithLastConsumed(
					$current,
					"content",
					lv_content_0_0,
					"org.eclipse.xtext.common.Terminals.STRING");
			}
		)
	)
;

// Entry rule entryRuleUrlElementVariable
entryRuleUrlElementVariable returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUrlElementVariableRule()); }
	iv_ruleUrlElementVariable=ruleUrlElementVariable
	{ $current=$iv_ruleUrlElementVariable.current; }
	EOF;

// Rule UrlElementVariable
ruleUrlElementVariable returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getUrlElementVariableRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getUrlElementVariableAccess().getContentVariableDefinitionCrossReference_0());
			}
			ruleQualifiedName
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleRepositoryLocation
entryRuleRepositoryLocation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRepositoryLocationRule()); }
	iv_ruleRepositoryLocation=ruleRepositoryLocation
	{ $current=$iv_ruleRepositoryLocation.current; }
	EOF;

// Rule RepositoryLocation
ruleRepositoryLocation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='RepositoryLocation'
		{
			newLeafNode(otherlv_0, grammarAccess.getRepositoryLocationAccess().getRepositoryLocationKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getRepositoryLocationAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRepositoryLocationRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='url'
		{
			newLeafNode(otherlv_2, grammarAccess.getRepositoryLocationAccess().getUrlKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRepositoryLocationAccess().getUrlUrlExpressionParserRuleCall_3_0());
				}
				lv_url_3_0=ruleUrlExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRepositoryLocationRule());
					}
					set(
						$current,
						"url",
						lv_url_3_0,
						"de.dlr.sc.overtarget.language.Overtarget.UrlExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getRepositoryLocationAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRepositoryLocationAccess().getUnitsUnitParserRuleCall_5_0());
				}
				lv_units_5_0=ruleUnit
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRepositoryLocationRule());
					}
					add(
						$current,
						"units",
						lv_units_5_0,
						"de.dlr.sc.overtarget.language.Overtarget.Unit");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getRepositoryLocationAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleExcludeLocation
entryRuleExcludeLocation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExcludeLocationRule()); }
	iv_ruleExcludeLocation=ruleExcludeLocation
	{ $current=$iv_ruleExcludeLocation.current; }
	EOF;

// Rule ExcludeLocation
ruleExcludeLocation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getExcludeLocationAccess().getExcludeLocationAction_0(),
					$current);
			}
		)
		otherlv_1='ExcludeLocation'
		{
			newLeafNode(otherlv_1, grammarAccess.getExcludeLocationAccess().getExcludeLocationKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getExcludeLocationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getExcludeLocationAccess().getRepositoryLocationRepositoryLocationCrossReference_2_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getExcludeLocationAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getExcludeLocationAccess().getUnitsUnitParserRuleCall_4_0_0());
					}
					lv_units_4_0=ruleUnit
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExcludeLocationRule());
						}
						add(
							$current,
							"units",
							lv_units_4_0,
							"de.dlr.sc.overtarget.language.Overtarget.Unit");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			    |
			otherlv_5='all;'
			{
				newLeafNode(otherlv_5, grammarAccess.getExcludeLocationAccess().getAllKeyword_4_1());
			}
		)
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getExcludeLocationAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleVariableDefinition
entryRuleVariableDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableDefinitionRule()); }
	iv_ruleVariableDefinition=ruleVariableDefinition
	{ $current=$iv_ruleVariableDefinition.current; }
	EOF;

// Rule VariableDefinition
ruleVariableDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getVariableDefinitionAccess().getAlreadyDeclaredVariableParserRuleCall_0());
		}
		this_AlreadyDeclaredVariable_0=ruleAlreadyDeclaredVariable
		{
			$current = $this_AlreadyDeclaredVariable_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNewVariableDefinitionParserRuleCall_1());
		}
		this_NewVariableDefinition_1=ruleNewVariableDefinition
		{
			$current = $this_NewVariableDefinition_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAlreadyDeclaredVariable
entryRuleAlreadyDeclaredVariable returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAlreadyDeclaredVariableRule()); }
	iv_ruleAlreadyDeclaredVariable=ruleAlreadyDeclaredVariable
	{ $current=$iv_ruleAlreadyDeclaredVariable.current; }
	EOF;

// Rule AlreadyDeclaredVariable
ruleAlreadyDeclaredVariable returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Override'
		{
			newLeafNode(otherlv_0, grammarAccess.getAlreadyDeclaredVariableAccess().getOverrideKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAlreadyDeclaredVariableRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getAlreadyDeclaredVariableAccess().getRefNewVariableDefinitionCrossReference_1_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getAlreadyDeclaredVariableAccess().getEqualsSignKeyword_2());
		}
		(
			(
				lv_value_3_0=RULE_STRING
				{
					newLeafNode(lv_value_3_0, grammarAccess.getAlreadyDeclaredVariableAccess().getValueSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAlreadyDeclaredVariableRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_3_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleNewVariableDefinition
entryRuleNewVariableDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNewVariableDefinitionRule()); }
	iv_ruleNewVariableDefinition=ruleNewVariableDefinition
	{ $current=$iv_ruleNewVariableDefinition.current; }
	EOF;

// Rule NewVariableDefinition
ruleNewVariableDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Variable'
		{
			newLeafNode(otherlv_0, grammarAccess.getNewVariableDefinitionAccess().getVariableKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getNewVariableDefinitionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNewVariableDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getNewVariableDefinitionAccess().getEqualsSignKeyword_2());
		}
		(
			(
				lv_value_3_0=RULE_STRING
				{
					newLeafNode(lv_value_3_0, grammarAccess.getNewVariableDefinitionAccess().getValueSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNewVariableDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_3_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRulequalifier
entryRulequalifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifierRule()); }
	iv_rulequalifier=rulequalifier
	{ $current=$iv_rulequalifier.current.getText(); }
	EOF;

// Rule qualifier
rulequalifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			this_INT_0=RULE_INT
			{
				$current.merge(this_INT_0);
			}
			{
				newLeafNode(this_INT_0, grammarAccess.getQualifierAccess().getINTTerminalRuleCall_0_0());
			}
			    |
			this_ID_1=RULE_ID
			{
				$current.merge(this_ID_1);
			}
			{
				newLeafNode(this_ID_1, grammarAccess.getQualifierAccess().getIDTerminalRuleCall_0_1());
			}
		)+
		(
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifierAccess().getHyphenMinusKeyword_1_0());
			}
			(
				this_INT_3=RULE_INT
				{
					$current.merge(this_INT_3);
				}
				{
					newLeafNode(this_INT_3, grammarAccess.getQualifierAccess().getINTTerminalRuleCall_1_1_0());
				}
				    |
				this_ID_4=RULE_ID
				{
					$current.merge(this_ID_4);
				}
				{
					newLeafNode(this_ID_4, grammarAccess.getQualifierAccess().getIDTerminalRuleCall_1_1_1());
				}
			)
		)?
	)
;

// Entry rule entryRuleOperatingSys
entryRuleOperatingSys returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOperatingSysRule()); }
	iv_ruleOperatingSys=ruleOperatingSys
	{ $current=$iv_ruleOperatingSys.current.getText(); }
	EOF;

// Rule OperatingSys
ruleOperatingSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='aix'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getAixKeyword_0());
		}
		    |
		kw='hpux'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getHpuxKeyword_1());
		}
		    |
		kw='linux'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getLinuxKeyword_2());
		}
		    |
		kw='macosx'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getMacosxKeyword_3());
		}
		    |
		kw='qnx'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getQnxKeyword_4());
		}
		    |
		kw='solaris'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getSolarisKeyword_5());
		}
		    |
		kw='win32'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getWin32Keyword_6());
		}
	)
;

// Entry rule entryRuleWindowingSys
entryRuleWindowingSys returns [String current=null]:
	{ newCompositeNode(grammarAccess.getWindowingSysRule()); }
	iv_ruleWindowingSys=ruleWindowingSys
	{ $current=$iv_ruleWindowingSys.current.getText(); }
	EOF;

// Rule WindowingSys
ruleWindowingSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='carbon'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getCarbonKeyword_0());
		}
		    |
		kw='cocoa'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getCocoaKeyword_1());
		}
		    |
		kw='gtk'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getGtkKeyword_2());
		}
		    |
		kw='motif'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getMotifKeyword_3());
		}
		    |
		kw='photon'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getPhotonKeyword_4());
		}
		    |
		kw='wpf'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getWpfKeyword_5());
		}
		    |
		kw='win32'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getWin32Keyword_6());
		}
	)
;

// Entry rule entryRuleArchitecture
entryRuleArchitecture returns [String current=null]:
	{ newCompositeNode(grammarAccess.getArchitectureRule()); }
	iv_ruleArchitecture=ruleArchitecture
	{ $current=$iv_ruleArchitecture.current.getText(); }
	EOF;

// Rule Architecture
ruleArchitecture returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='PA_RISC'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArchitectureAccess().getPA_RISCKeyword_0());
		}
		    |
		kw='ia64'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArchitectureAccess().getIa64Keyword_1());
		}
		    |
		kw='ia64_32'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArchitectureAccess().getIa64_32Keyword_2());
		}
		    |
		kw='ppc'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArchitectureAccess().getPpcKeyword_3());
		}
		    |
		kw='sparc'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArchitectureAccess().getSparcKeyword_4());
		}
		    |
		kw='x86'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArchitectureAccess().getX86Keyword_5());
		}
		    |
		kw='x86_64'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArchitectureAccess().getX86_64Keyword_6());
		}
	)
;

// Entry rule entryRuleLocale
entryRuleLocale returns [String current=null]:
	{ newCompositeNode(grammarAccess.getLocaleRule()); }
	iv_ruleLocale=ruleLocale
	{ $current=$iv_ruleLocale.current.getText(); }
	EOF;

// Rule Locale
ruleLocale returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_ID_0=RULE_ID
	{
		$current.merge(this_ID_0);
	}
	{
		newLeafNode(this_ID_0, grammarAccess.getLocaleAccess().getIDTerminalRuleCall());
	}
;

// Entry rule entryRuledot
entryRuledot returns [String current=null]:
	{ newCompositeNode(grammarAccess.getDotRule()); }
	iv_ruledot=ruledot
	{ $current=$iv_ruledot.current.getText(); }
	EOF;

// Rule dot
ruledot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='.'
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getDotAccess().getFullStopKeyword());
	}
;

// Entry rule entryRulehypen
entryRulehypen returns [String current=null]:
	{ newCompositeNode(grammarAccess.getHypenRule()); }
	iv_rulehypen=rulehypen
	{ $current=$iv_rulehypen.current.getText(); }
	EOF;

// Rule hypen
rulehypen returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='-'
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getHypenAccess().getHyphenMinusKeyword());
	}
;

// Entry rule entryRulejre
entryRulejre returns [String current=null]:
	{ newCompositeNode(grammarAccess.getJreRule()); }
	iv_rulejre=rulejre
	{ $current=$iv_rulejre.current.getText(); }
	EOF;

// Rule jre
rulejre returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getJreAccess().getIDTerminalRuleCall_0());
		}
		    |
		kw='-'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getJreAccess().getHyphenMinusKeyword_1());
		}
		    |
		{
			newCompositeNode(grammarAccess.getJreAccess().getSimpleVersionParserRuleCall_2());
		}
		this_SimpleVersion_2=ruleSimpleVersion
		{
			$current.merge(this_SimpleVersion_2);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)+
;

// Entry rule entryRuleValidID
entryRuleValidID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getValidIDRule()); }
	iv_ruleValidID=ruleValidID
	{ $current=$iv_ruleValidID.current.getText(); }
	EOF;

// Rule ValidID
ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
		}
		    |
		{
			newCompositeNode(grammarAccess.getValidIDAccess().getKEYWORDParserRuleCall_1());
		}
		this_KEYWORD_1=ruleKEYWORD
		{
			$current.merge(this_KEYWORD_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleKEYWORD
entryRuleKEYWORD returns [String current=null]:
	{ newCompositeNode(grammarAccess.getKEYWORDRule()); }
	iv_ruleKEYWORD=ruleKEYWORD
	{ $current=$iv_ruleKEYWORD.current.getText(); }
	EOF;

// Rule KEYWORD
ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='Unit'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getUnitKeyword_0());
		}
		    |
		kw='Target'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTargetKeyword_1());
		}
	)
;

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	iv_ruleQualifiedName=ruleQualifiedName
	{ $current=$iv_ruleQualifiedName.current.getText(); }
	EOF;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
