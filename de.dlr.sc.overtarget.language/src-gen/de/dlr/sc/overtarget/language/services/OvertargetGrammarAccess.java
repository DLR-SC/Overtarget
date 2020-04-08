/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class OvertargetGrammarAccess extends AbstractGrammarElementFinder {
	
	public class TargetFileElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.TargetFile");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTargetModelParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTargetLibraryParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//TargetFile:
		//	TargetModel | TargetLibrary;
		@Override public ParserRule getRule() { return rule; }
		
		//TargetModel | TargetLibrary
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TargetModel
		public RuleCall getTargetModelParserRuleCall_0() { return cTargetModelParserRuleCall_0; }
		
		//TargetLibrary
		public RuleCall getTargetLibraryParserRuleCall_1() { return cTargetLibraryParserRuleCall_1; }
	}
	public class TargetLibraryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.TargetLibrary");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTargetLibraryKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cVariablesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cVariablesVariableDefinitionParserRuleCall_3_0 = (RuleCall)cVariablesAssignment_3.eContents().get(0);
		private final Assignment cRepositoryLocationsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cRepositoryLocationsRepositoryLocationParserRuleCall_4_0 = (RuleCall)cRepositoryLocationsAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//TargetLibrary:
		//	'TargetLibrary' name=ID '{'
		//	variables+=VariableDefinition*
		//	repositoryLocations+=RepositoryLocation*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'TargetLibrary' name=ID '{' variables+=VariableDefinition* repositoryLocations+=RepositoryLocation* '}'
		public Group getGroup() { return cGroup; }
		
		//'TargetLibrary'
		public Keyword getTargetLibraryKeyword_0() { return cTargetLibraryKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//variables+=VariableDefinition*
		public Assignment getVariablesAssignment_3() { return cVariablesAssignment_3; }
		
		//VariableDefinition
		public RuleCall getVariablesVariableDefinitionParserRuleCall_3_0() { return cVariablesVariableDefinitionParserRuleCall_3_0; }
		
		//repositoryLocations+=RepositoryLocation*
		public Assignment getRepositoryLocationsAssignment_4() { return cRepositoryLocationsAssignment_4; }
		
		//RepositoryLocation
		public RuleCall getRepositoryLocationsRepositoryLocationParserRuleCall_4_0() { return cRepositoryLocationsRepositoryLocationParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class BaseModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.BaseModel");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTargetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cImportKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cImportedModelsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cImportedModelsTargetFileCrossReference_3_1_0 = (CrossReference)cImportedModelsAssignment_3_1.eContents().get(0);
		private final RuleCall cImportedModelsTargetFileIDTerminalRuleCall_3_1_0_1 = (RuleCall)cImportedModelsTargetFileCrossReference_3_1_0.eContents().get(1);
		private final Keyword cOperatingSystemKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOsOperatingSysParserRuleCall_5_0 = (RuleCall)cOsAssignment_5.eContents().get(0);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Keyword cWindowingSystemKeyword_6_0 = (Keyword)cAlternatives_6.eContents().get(0);
		private final Keyword cWorkingSystemKeyword_6_1 = (Keyword)cAlternatives_6.eContents().get(1);
		private final Assignment cWsAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cWsWindowingSysParserRuleCall_7_0 = (RuleCall)cWsAssignment_7.eContents().get(0);
		private final Keyword cArchitectureKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Assignment cArchAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cArchArchitectureParserRuleCall_9_0 = (RuleCall)cArchAssignment_9.eContents().get(0);
		private final Keyword cLocaleKeyword_10 = (Keyword)cGroup.eContents().get(10);
		private final Assignment cLocAssignment_11 = (Assignment)cGroup.eContents().get(11);
		private final RuleCall cLocLocaleParserRuleCall_11_0 = (RuleCall)cLocAssignment_11.eContents().get(0);
		private final Group cGroup_12 = (Group)cGroup.eContents().get(12);
		private final Keyword cTargetJREKeyword_12_0 = (Keyword)cGroup_12.eContents().get(0);
		private final Assignment cTargetJreAssignment_12_1 = (Assignment)cGroup_12.eContents().get(1);
		private final RuleCall cTargetJreJreParserRuleCall_12_1_0 = (RuleCall)cTargetJreAssignment_12_1.eContents().get(0);
		private final Assignment cVariablesAssignment_13 = (Assignment)cGroup.eContents().get(13);
		private final RuleCall cVariablesVariableDefinitionParserRuleCall_13_0 = (RuleCall)cVariablesAssignment_13.eContents().get(0);
		private final Assignment cExcludedLocationsAssignment_14 = (Assignment)cGroup.eContents().get(14);
		private final RuleCall cExcludedLocationsExcludeLocationParserRuleCall_14_0 = (RuleCall)cExcludedLocationsAssignment_14.eContents().get(0);
		private final Assignment cRepositoryLocationsAssignment_15 = (Assignment)cGroup.eContents().get(15);
		private final RuleCall cRepositoryLocationsRepositoryLocationParserRuleCall_15_0 = (RuleCall)cRepositoryLocationsAssignment_15.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_16 = (Keyword)cGroup.eContents().get(16);
		
		//BaseModel:
		//	'Target' name=ID '{' ('Import' importedModels+=[TargetFile])*
		//	'OperatingSystem' os=OperatingSys ('WindowingSystem' | 'WorkingSystem') ws=WindowingSys
		//	'Architecture' arch=Architecture
		//	'Locale' loc=Locale ('TargetJRE' targetJre=jre)?
		//	variables+=VariableDefinition*
		//	excludedLocations+=ExcludeLocation*
		//	repositoryLocations+=RepositoryLocation*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'Target' name=ID '{' ('Import' importedModels+=[TargetFile])* 'OperatingSystem' os=OperatingSys ('WindowingSystem' |
		//'WorkingSystem') ws=WindowingSys 'Architecture' arch=Architecture 'Locale' loc=Locale ('TargetJRE' targetJre=jre)?
		//variables+=VariableDefinition* excludedLocations+=ExcludeLocation* repositoryLocations+=RepositoryLocation* '}'
		public Group getGroup() { return cGroup; }
		
		//'Target'
		public Keyword getTargetKeyword_0() { return cTargetKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('Import' importedModels+=[TargetFile])*
		public Group getGroup_3() { return cGroup_3; }
		
		//'Import'
		public Keyword getImportKeyword_3_0() { return cImportKeyword_3_0; }
		
		//importedModels+=[TargetFile]
		public Assignment getImportedModelsAssignment_3_1() { return cImportedModelsAssignment_3_1; }
		
		//[TargetFile]
		public CrossReference getImportedModelsTargetFileCrossReference_3_1_0() { return cImportedModelsTargetFileCrossReference_3_1_0; }
		
		//ID
		public RuleCall getImportedModelsTargetFileIDTerminalRuleCall_3_1_0_1() { return cImportedModelsTargetFileIDTerminalRuleCall_3_1_0_1; }
		
		//'OperatingSystem'
		public Keyword getOperatingSystemKeyword_4() { return cOperatingSystemKeyword_4; }
		
		//os=OperatingSys
		public Assignment getOsAssignment_5() { return cOsAssignment_5; }
		
		//OperatingSys
		public RuleCall getOsOperatingSysParserRuleCall_5_0() { return cOsOperatingSysParserRuleCall_5_0; }
		
		//'WindowingSystem' | 'WorkingSystem'
		public Alternatives getAlternatives_6() { return cAlternatives_6; }
		
		//'WindowingSystem'
		public Keyword getWindowingSystemKeyword_6_0() { return cWindowingSystemKeyword_6_0; }
		
		//'WorkingSystem'
		public Keyword getWorkingSystemKeyword_6_1() { return cWorkingSystemKeyword_6_1; }
		
		//ws=WindowingSys
		public Assignment getWsAssignment_7() { return cWsAssignment_7; }
		
		//WindowingSys
		public RuleCall getWsWindowingSysParserRuleCall_7_0() { return cWsWindowingSysParserRuleCall_7_0; }
		
		//'Architecture'
		public Keyword getArchitectureKeyword_8() { return cArchitectureKeyword_8; }
		
		//arch=Architecture
		public Assignment getArchAssignment_9() { return cArchAssignment_9; }
		
		//Architecture
		public RuleCall getArchArchitectureParserRuleCall_9_0() { return cArchArchitectureParserRuleCall_9_0; }
		
		//'Locale'
		public Keyword getLocaleKeyword_10() { return cLocaleKeyword_10; }
		
		//loc=Locale
		public Assignment getLocAssignment_11() { return cLocAssignment_11; }
		
		//Locale
		public RuleCall getLocLocaleParserRuleCall_11_0() { return cLocLocaleParserRuleCall_11_0; }
		
		//('TargetJRE' targetJre=jre)?
		public Group getGroup_12() { return cGroup_12; }
		
		//'TargetJRE'
		public Keyword getTargetJREKeyword_12_0() { return cTargetJREKeyword_12_0; }
		
		//targetJre=jre
		public Assignment getTargetJreAssignment_12_1() { return cTargetJreAssignment_12_1; }
		
		//jre
		public RuleCall getTargetJreJreParserRuleCall_12_1_0() { return cTargetJreJreParserRuleCall_12_1_0; }
		
		//variables+=VariableDefinition*
		public Assignment getVariablesAssignment_13() { return cVariablesAssignment_13; }
		
		//VariableDefinition
		public RuleCall getVariablesVariableDefinitionParserRuleCall_13_0() { return cVariablesVariableDefinitionParserRuleCall_13_0; }
		
		//excludedLocations+=ExcludeLocation*
		public Assignment getExcludedLocationsAssignment_14() { return cExcludedLocationsAssignment_14; }
		
		//ExcludeLocation
		public RuleCall getExcludedLocationsExcludeLocationParserRuleCall_14_0() { return cExcludedLocationsExcludeLocationParserRuleCall_14_0; }
		
		//repositoryLocations+=RepositoryLocation*
		public Assignment getRepositoryLocationsAssignment_15() { return cRepositoryLocationsAssignment_15; }
		
		//RepositoryLocation
		public RuleCall getRepositoryLocationsRepositoryLocationParserRuleCall_15_0() { return cRepositoryLocationsRepositoryLocationParserRuleCall_15_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_16() { return cRightCurlyBracketKeyword_16; }
	}
	public class TargetModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.TargetModel");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTargetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cExtendsKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cSuperAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cSuperTargetModelCrossReference_2_1_0 = (CrossReference)cSuperAssignment_2_1.eContents().get(0);
		private final RuleCall cSuperTargetModelIDTerminalRuleCall_2_1_0_1 = (RuleCall)cSuperTargetModelCrossReference_2_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cImportKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cImportedModelsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cImportedModelsTargetFileCrossReference_4_1_0 = (CrossReference)cImportedModelsAssignment_4_1.eContents().get(0);
		private final RuleCall cImportedModelsTargetFileIDTerminalRuleCall_4_1_0_1 = (RuleCall)cImportedModelsTargetFileCrossReference_4_1_0.eContents().get(1);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cOperatingSystemKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cOsAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cOsOperatingSysParserRuleCall_5_1_0 = (RuleCall)cOsAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Alternatives cAlternatives_6_0 = (Alternatives)cGroup_6.eContents().get(0);
		private final Keyword cWindowingSystemKeyword_6_0_0 = (Keyword)cAlternatives_6_0.eContents().get(0);
		private final Keyword cWorkingSystemKeyword_6_0_1 = (Keyword)cAlternatives_6_0.eContents().get(1);
		private final Assignment cWsAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cWsWindowingSysParserRuleCall_6_1_0 = (RuleCall)cWsAssignment_6_1.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cArchitectureKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cArchAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cArchArchitectureParserRuleCall_7_1_0 = (RuleCall)cArchAssignment_7_1.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cLocaleKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cLocAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cLocLocaleParserRuleCall_8_1_0 = (RuleCall)cLocAssignment_8_1.eContents().get(0);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cTargetJREKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cTargetJreAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final RuleCall cTargetJreJreParserRuleCall_9_1_0 = (RuleCall)cTargetJreAssignment_9_1.eContents().get(0);
		private final Assignment cVariablesAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cVariablesVariableDefinitionParserRuleCall_10_0 = (RuleCall)cVariablesAssignment_10.eContents().get(0);
		private final Assignment cExcludedLocationsAssignment_11 = (Assignment)cGroup.eContents().get(11);
		private final RuleCall cExcludedLocationsExcludeLocationParserRuleCall_11_0 = (RuleCall)cExcludedLocationsAssignment_11.eContents().get(0);
		private final Assignment cRepositoryLocationsAssignment_12 = (Assignment)cGroup.eContents().get(12);
		private final RuleCall cRepositoryLocationsRepositoryLocationParserRuleCall_12_0 = (RuleCall)cRepositoryLocationsAssignment_12.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_13 = (Keyword)cGroup.eContents().get(13);
		
		//TargetModel:
		//	'Target' name=ID ('extends' super=[TargetModel])? '{' ('Import' importedModels+=[TargetFile])* ('OperatingSystem'
		//	os=OperatingSys)? (('WindowingSystem' | 'WorkingSystem') ws=WindowingSys)? ('Architecture' arch=Architecture)?
		//	('Locale' loc=Locale)? ('TargetJRE' targetJre=jre)?
		//	variables+=VariableDefinition*
		//	excludedLocations+=ExcludeLocation*
		//	repositoryLocations+=RepositoryLocation*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'Target' name=ID ('extends' super=[TargetModel])? '{' ('Import' importedModels+=[TargetFile])* ('OperatingSystem'
		//os=OperatingSys)? (('WindowingSystem' | 'WorkingSystem') ws=WindowingSys)? ('Architecture' arch=Architecture)?
		//('Locale' loc=Locale)? ('TargetJRE' targetJre=jre)? variables+=VariableDefinition* excludedLocations+=ExcludeLocation*
		//repositoryLocations+=RepositoryLocation* '}'
		public Group getGroup() { return cGroup; }
		
		//'Target'
		public Keyword getTargetKeyword_0() { return cTargetKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//('extends' super=[TargetModel])?
		public Group getGroup_2() { return cGroup_2; }
		
		//'extends'
		public Keyword getExtendsKeyword_2_0() { return cExtendsKeyword_2_0; }
		
		//super=[TargetModel]
		public Assignment getSuperAssignment_2_1() { return cSuperAssignment_2_1; }
		
		//[TargetModel]
		public CrossReference getSuperTargetModelCrossReference_2_1_0() { return cSuperTargetModelCrossReference_2_1_0; }
		
		//ID
		public RuleCall getSuperTargetModelIDTerminalRuleCall_2_1_0_1() { return cSuperTargetModelIDTerminalRuleCall_2_1_0_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//('Import' importedModels+=[TargetFile])*
		public Group getGroup_4() { return cGroup_4; }
		
		//'Import'
		public Keyword getImportKeyword_4_0() { return cImportKeyword_4_0; }
		
		//importedModels+=[TargetFile]
		public Assignment getImportedModelsAssignment_4_1() { return cImportedModelsAssignment_4_1; }
		
		//[TargetFile]
		public CrossReference getImportedModelsTargetFileCrossReference_4_1_0() { return cImportedModelsTargetFileCrossReference_4_1_0; }
		
		//ID
		public RuleCall getImportedModelsTargetFileIDTerminalRuleCall_4_1_0_1() { return cImportedModelsTargetFileIDTerminalRuleCall_4_1_0_1; }
		
		//('OperatingSystem' os=OperatingSys)?
		public Group getGroup_5() { return cGroup_5; }
		
		//'OperatingSystem'
		public Keyword getOperatingSystemKeyword_5_0() { return cOperatingSystemKeyword_5_0; }
		
		//os=OperatingSys
		public Assignment getOsAssignment_5_1() { return cOsAssignment_5_1; }
		
		//OperatingSys
		public RuleCall getOsOperatingSysParserRuleCall_5_1_0() { return cOsOperatingSysParserRuleCall_5_1_0; }
		
		//(('WindowingSystem' | 'WorkingSystem') ws=WindowingSys)?
		public Group getGroup_6() { return cGroup_6; }
		
		//'WindowingSystem' | 'WorkingSystem'
		public Alternatives getAlternatives_6_0() { return cAlternatives_6_0; }
		
		//'WindowingSystem'
		public Keyword getWindowingSystemKeyword_6_0_0() { return cWindowingSystemKeyword_6_0_0; }
		
		//'WorkingSystem'
		public Keyword getWorkingSystemKeyword_6_0_1() { return cWorkingSystemKeyword_6_0_1; }
		
		//ws=WindowingSys
		public Assignment getWsAssignment_6_1() { return cWsAssignment_6_1; }
		
		//WindowingSys
		public RuleCall getWsWindowingSysParserRuleCall_6_1_0() { return cWsWindowingSysParserRuleCall_6_1_0; }
		
		//('Architecture' arch=Architecture)?
		public Group getGroup_7() { return cGroup_7; }
		
		//'Architecture'
		public Keyword getArchitectureKeyword_7_0() { return cArchitectureKeyword_7_0; }
		
		//arch=Architecture
		public Assignment getArchAssignment_7_1() { return cArchAssignment_7_1; }
		
		//Architecture
		public RuleCall getArchArchitectureParserRuleCall_7_1_0() { return cArchArchitectureParserRuleCall_7_1_0; }
		
		//('Locale' loc=Locale)?
		public Group getGroup_8() { return cGroup_8; }
		
		//'Locale'
		public Keyword getLocaleKeyword_8_0() { return cLocaleKeyword_8_0; }
		
		//loc=Locale
		public Assignment getLocAssignment_8_1() { return cLocAssignment_8_1; }
		
		//Locale
		public RuleCall getLocLocaleParserRuleCall_8_1_0() { return cLocLocaleParserRuleCall_8_1_0; }
		
		//('TargetJRE' targetJre=jre)?
		public Group getGroup_9() { return cGroup_9; }
		
		//'TargetJRE'
		public Keyword getTargetJREKeyword_9_0() { return cTargetJREKeyword_9_0; }
		
		//targetJre=jre
		public Assignment getTargetJreAssignment_9_1() { return cTargetJreAssignment_9_1; }
		
		//jre
		public RuleCall getTargetJreJreParserRuleCall_9_1_0() { return cTargetJreJreParserRuleCall_9_1_0; }
		
		//variables+=VariableDefinition*
		public Assignment getVariablesAssignment_10() { return cVariablesAssignment_10; }
		
		//VariableDefinition
		public RuleCall getVariablesVariableDefinitionParserRuleCall_10_0() { return cVariablesVariableDefinitionParserRuleCall_10_0; }
		
		//excludedLocations+=ExcludeLocation*
		public Assignment getExcludedLocationsAssignment_11() { return cExcludedLocationsAssignment_11; }
		
		//ExcludeLocation
		public RuleCall getExcludedLocationsExcludeLocationParserRuleCall_11_0() { return cExcludedLocationsExcludeLocationParserRuleCall_11_0; }
		
		//repositoryLocations+=RepositoryLocation*
		public Assignment getRepositoryLocationsAssignment_12() { return cRepositoryLocationsAssignment_12; }
		
		//RepositoryLocation
		public RuleCall getRepositoryLocationsRepositoryLocationParserRuleCall_12_0() { return cRepositoryLocationsRepositoryLocationParserRuleCall_12_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_13() { return cRightCurlyBracketKeyword_13; }
	}
	public class VersionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.Version");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final RuleCall cINTTerminalRuleCall_4 = (RuleCall)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cFullStopKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final RuleCall cQualifierParserRuleCall_5_1 = (RuleCall)cGroup_5.eContents().get(1);
		
		//Version hidden():
		//	INT '.' INT '.' INT ('.' qualifier)?;
		@Override public ParserRule getRule() { return rule; }
		
		//INT '.' INT '.' INT ('.' qualifier)?
		public Group getGroup() { return cGroup; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_2() { return cINTTerminalRuleCall_2; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_4() { return cINTTerminalRuleCall_4; }
		
		//('.' qualifier)?
		public Group getGroup_5() { return cGroup_5; }
		
		//'.'
		public Keyword getFullStopKeyword_5_0() { return cFullStopKeyword_5_0; }
		
		//qualifier
		public RuleCall getQualifierParserRuleCall_5_1() { return cQualifierParserRuleCall_5_1; }
	}
	public class SimpleVersionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.SimpleVersion");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//SimpleVersion:
		//	INT ('.' INT)*;
		@Override public ParserRule getRule() { return rule; }
		
		//INT ('.' INT)*
		public Group getGroup() { return cGroup; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }
		
		//('.' INT)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_1_1() { return cINTTerminalRuleCall_1_1; }
	}
	public class UnitElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.Unit");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cUnitKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cSourceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSourceSourceParserRuleCall_1_0 = (RuleCall)cSourceAssignment_1.eContents().get(0);
		private final Keyword cVersionKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cVersAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Alternatives cVersAlternatives_3_0 = (Alternatives)cVersAssignment_3.eContents().get(0);
		private final RuleCall cVersVersionParserRuleCall_3_0_0 = (RuleCall)cVersAlternatives_3_0.eContents().get(0);
		private final Keyword cVersNewestKeyword_3_0_1 = (Keyword)cVersAlternatives_3_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Unit:
		//	'Unit' source=Source 'version' vers=(Version | 'newest') ';';
		@Override public ParserRule getRule() { return rule; }
		
		//'Unit' source=Source 'version' vers=(Version | 'newest') ';'
		public Group getGroup() { return cGroup; }
		
		//'Unit'
		public Keyword getUnitKeyword_0() { return cUnitKeyword_0; }
		
		//source=Source
		public Assignment getSourceAssignment_1() { return cSourceAssignment_1; }
		
		//Source
		public RuleCall getSourceSourceParserRuleCall_1_0() { return cSourceSourceParserRuleCall_1_0; }
		
		//'version'
		public Keyword getVersionKeyword_2() { return cVersionKeyword_2; }
		
		//vers=(Version | 'newest')
		public Assignment getVersAssignment_3() { return cVersAssignment_3; }
		
		//(Version | 'newest')
		public Alternatives getVersAlternatives_3_0() { return cVersAlternatives_3_0; }
		
		//Version
		public RuleCall getVersVersionParserRuleCall_3_0_0() { return cVersVersionParserRuleCall_3_0_0; }
		
		//'newest'
		public Keyword getVersNewestKeyword_3_0_1() { return cVersNewestKeyword_3_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class SourceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.Source");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final RuleCall cDotParserRuleCall_1_0_0 = (RuleCall)cGroup_1_0.eContents().get(0);
		private final RuleCall cValidIDParserRuleCall_1_0_1 = (RuleCall)cGroup_1_0.eContents().get(1);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final RuleCall cHypenParserRuleCall_1_1_0 = (RuleCall)cGroup_1_1.eContents().get(0);
		private final RuleCall cValidIDParserRuleCall_1_1_1 = (RuleCall)cGroup_1_1.eContents().get(1);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//Source hidden():
		//	ValidID (dot ValidID | hypen ValidID)* ':'?;
		@Override public ParserRule getRule() { return rule; }
		
		//ValidID (dot ValidID | hypen ValidID)* ':'?
		public Group getGroup() { return cGroup; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_0() { return cValidIDParserRuleCall_0; }
		
		//(dot ValidID | hypen ValidID)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//dot ValidID
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//dot
		public RuleCall getDotParserRuleCall_1_0_0() { return cDotParserRuleCall_1_0_0; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_1_0_1() { return cValidIDParserRuleCall_1_0_1; }
		
		//hypen ValidID
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//hypen
		public RuleCall getHypenParserRuleCall_1_1_0() { return cHypenParserRuleCall_1_1_0; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_1_1_1() { return cValidIDParserRuleCall_1_1_1; }
		
		//':'?
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
	}
	public class UrlExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.UrlExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cUrlElementParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cUrlExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cPlusSignKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightUrlElementParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//UrlExpression:
		//	UrlElement ({UrlExpression.left=current} '+' right=UrlElement)*;
		@Override public ParserRule getRule() { return rule; }
		
		//UrlElement ({UrlExpression.left=current} '+' right=UrlElement)*
		public Group getGroup() { return cGroup; }
		
		//UrlElement
		public RuleCall getUrlElementParserRuleCall_0() { return cUrlElementParserRuleCall_0; }
		
		//({UrlExpression.left=current} '+' right=UrlElement)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{UrlExpression.left=current}
		public Action getUrlExpressionLeftAction_1_0() { return cUrlExpressionLeftAction_1_0; }
		
		//'+'
		public Keyword getPlusSignKeyword_1_1() { return cPlusSignKeyword_1_1; }
		
		//right=UrlElement
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//UrlElement
		public RuleCall getRightUrlElementParserRuleCall_1_2_0() { return cRightUrlElementParserRuleCall_1_2_0; }
	}
	public class UrlElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.UrlElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cUrlElementVariableParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cUrlElementStringParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//UrlElement:
		//	UrlElementVariable | UrlElementString;
		@Override public ParserRule getRule() { return rule; }
		
		//UrlElementVariable | UrlElementString
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//UrlElementVariable
		public RuleCall getUrlElementVariableParserRuleCall_0() { return cUrlElementVariableParserRuleCall_0; }
		
		//UrlElementString
		public RuleCall getUrlElementStringParserRuleCall_1() { return cUrlElementStringParserRuleCall_1; }
	}
	public class UrlElementStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.UrlElementString");
		private final Assignment cContentAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cContentSTRINGTerminalRuleCall_0 = (RuleCall)cContentAssignment.eContents().get(0);
		
		//UrlElementString:
		//	content=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//content=STRING
		public Assignment getContentAssignment() { return cContentAssignment; }
		
		//STRING
		public RuleCall getContentSTRINGTerminalRuleCall_0() { return cContentSTRINGTerminalRuleCall_0; }
	}
	public class UrlElementVariableElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.UrlElementVariable");
		private final Assignment cContentAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cContentVariableDefinitionCrossReference_0 = (CrossReference)cContentAssignment.eContents().get(0);
		private final RuleCall cContentVariableDefinitionQualifiedNameParserRuleCall_0_1 = (RuleCall)cContentVariableDefinitionCrossReference_0.eContents().get(1);
		
		//UrlElementVariable:
		//	content=[VariableDefinition|QualifiedName];
		@Override public ParserRule getRule() { return rule; }
		
		//content=[VariableDefinition|QualifiedName]
		public Assignment getContentAssignment() { return cContentAssignment; }
		
		//[VariableDefinition|QualifiedName]
		public CrossReference getContentVariableDefinitionCrossReference_0() { return cContentVariableDefinitionCrossReference_0; }
		
		//QualifiedName
		public RuleCall getContentVariableDefinitionQualifiedNameParserRuleCall_0_1() { return cContentVariableDefinitionQualifiedNameParserRuleCall_0_1; }
	}
	public class RepositoryLocationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.RepositoryLocation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cReferenceTargetAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cReferenceTargetReferenceTargetKeyword_0_0 = (Keyword)cReferenceTargetAssignment_0.eContents().get(0);
		private final Keyword cRepositoryLocationKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cUrlKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cUrlAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cUrlUrlExpressionParserRuleCall_4_0 = (RuleCall)cUrlAssignment_4.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cUnitsAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cUnitsUnitParserRuleCall_6_0 = (RuleCall)cUnitsAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//RepositoryLocation:
		//	referenceTarget?='ReferenceTarget'? 'RepositoryLocation' name=ID 'url' url=UrlExpression '{'
		//	units+=Unit*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//referenceTarget?='ReferenceTarget'? 'RepositoryLocation' name=ID 'url' url=UrlExpression '{' units+=Unit* '}'
		public Group getGroup() { return cGroup; }
		
		//referenceTarget?='ReferenceTarget'?
		public Assignment getReferenceTargetAssignment_0() { return cReferenceTargetAssignment_0; }
		
		//'ReferenceTarget'
		public Keyword getReferenceTargetReferenceTargetKeyword_0_0() { return cReferenceTargetReferenceTargetKeyword_0_0; }
		
		//'RepositoryLocation'
		public Keyword getRepositoryLocationKeyword_1() { return cRepositoryLocationKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'url'
		public Keyword getUrlKeyword_3() { return cUrlKeyword_3; }
		
		//url=UrlExpression
		public Assignment getUrlAssignment_4() { return cUrlAssignment_4; }
		
		//UrlExpression
		public RuleCall getUrlUrlExpressionParserRuleCall_4_0() { return cUrlUrlExpressionParserRuleCall_4_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//units+=Unit*
		public Assignment getUnitsAssignment_6() { return cUnitsAssignment_6; }
		
		//Unit
		public RuleCall getUnitsUnitParserRuleCall_6_0() { return cUnitsUnitParserRuleCall_6_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class ExcludeLocationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.ExcludeLocation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cExcludeLocationAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cExcludeLocationKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRepositoryLocationAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRepositoryLocationRepositoryLocationCrossReference_2_0 = (CrossReference)cRepositoryLocationAssignment_2.eContents().get(0);
		private final RuleCall cRepositoryLocationRepositoryLocationQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cRepositoryLocationRepositoryLocationCrossReference_2_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cUnitsAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cUnitsUnitParserRuleCall_4_0_0 = (RuleCall)cUnitsAssignment_4_0.eContents().get(0);
		private final Keyword cAllKeyword_4_1 = (Keyword)cAlternatives_4.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//ExcludeLocation:
		//	{ExcludeLocation}
		//	'ExcludeLocation' repositoryLocation=[RepositoryLocation|QualifiedName] '{' (units+=Unit* | 'all;')
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{ExcludeLocation} 'ExcludeLocation' repositoryLocation=[RepositoryLocation|QualifiedName] '{' (units+=Unit* | 'all;')
		//'}'
		public Group getGroup() { return cGroup; }
		
		//{ExcludeLocation}
		public Action getExcludeLocationAction_0() { return cExcludeLocationAction_0; }
		
		//'ExcludeLocation'
		public Keyword getExcludeLocationKeyword_1() { return cExcludeLocationKeyword_1; }
		
		//repositoryLocation=[RepositoryLocation|QualifiedName]
		public Assignment getRepositoryLocationAssignment_2() { return cRepositoryLocationAssignment_2; }
		
		//[RepositoryLocation|QualifiedName]
		public CrossReference getRepositoryLocationRepositoryLocationCrossReference_2_0() { return cRepositoryLocationRepositoryLocationCrossReference_2_0; }
		
		//QualifiedName
		public RuleCall getRepositoryLocationRepositoryLocationQualifiedNameParserRuleCall_2_0_1() { return cRepositoryLocationRepositoryLocationQualifiedNameParserRuleCall_2_0_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//units+=Unit* | 'all;'
		public Alternatives getAlternatives_4() { return cAlternatives_4; }
		
		//units+=Unit*
		public Assignment getUnitsAssignment_4_0() { return cUnitsAssignment_4_0; }
		
		//Unit
		public RuleCall getUnitsUnitParserRuleCall_4_0_0() { return cUnitsUnitParserRuleCall_4_0_0; }
		
		//'all;'
		public Keyword getAllKeyword_4_1() { return cAllKeyword_4_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class VariableDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.VariableDefinition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAlreadyDeclaredVariableParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNewVariableDefinitionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//VariableDefinition:
		//	AlreadyDeclaredVariable | NewVariableDefinition;
		@Override public ParserRule getRule() { return rule; }
		
		//AlreadyDeclaredVariable | NewVariableDefinition
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//AlreadyDeclaredVariable
		public RuleCall getAlreadyDeclaredVariableParserRuleCall_0() { return cAlreadyDeclaredVariableParserRuleCall_0; }
		
		//NewVariableDefinition
		public RuleCall getNewVariableDefinitionParserRuleCall_1() { return cNewVariableDefinitionParserRuleCall_1; }
	}
	public class AlreadyDeclaredVariableElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.AlreadyDeclaredVariable");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cOverrideKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRefAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRefNewVariableDefinitionCrossReference_1_0 = (CrossReference)cRefAssignment_1.eContents().get(0);
		private final RuleCall cRefNewVariableDefinitionQualifiedNameParserRuleCall_1_0_1 = (RuleCall)cRefNewVariableDefinitionCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueSTRINGTerminalRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//AlreadyDeclaredVariable:
		//	'Override' ref=[NewVariableDefinition|QualifiedName] '=' value=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//'Override' ref=[NewVariableDefinition|QualifiedName] '=' value=STRING
		public Group getGroup() { return cGroup; }
		
		//'Override'
		public Keyword getOverrideKeyword_0() { return cOverrideKeyword_0; }
		
		//ref=[NewVariableDefinition|QualifiedName]
		public Assignment getRefAssignment_1() { return cRefAssignment_1; }
		
		//[NewVariableDefinition|QualifiedName]
		public CrossReference getRefNewVariableDefinitionCrossReference_1_0() { return cRefNewVariableDefinitionCrossReference_1_0; }
		
		//QualifiedName
		public RuleCall getRefNewVariableDefinitionQualifiedNameParserRuleCall_1_0_1() { return cRefNewVariableDefinitionQualifiedNameParserRuleCall_1_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//value=STRING
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_3_0() { return cValueSTRINGTerminalRuleCall_3_0; }
	}
	public class NewVariableDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.NewVariableDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cVariableKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueSTRINGTerminalRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//NewVariableDefinition:
		//	'Variable' name=ID '=' value=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//'Variable' name=ID '=' value=STRING
		public Group getGroup() { return cGroup; }
		
		//'Variable'
		public Keyword getVariableKeyword_0() { return cVariableKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//value=STRING
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_3_0() { return cValueSTRINGTerminalRuleCall_3_0; }
	}
	public class QualifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.qualifier");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1_1_0 = (RuleCall)cAlternatives_1_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1_1 = (RuleCall)cAlternatives_1_1.eContents().get(1);
		
		//qualifier:
		//	(INT | ID)+ ('-' (INT | ID))?;
		@Override public ParserRule getRule() { return rule; }
		
		//(INT | ID)+ ('-' (INT | ID))?
		public Group getGroup() { return cGroup; }
		
		//(INT | ID)+
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_0_0() { return cINTTerminalRuleCall_0_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0_1() { return cIDTerminalRuleCall_0_1; }
		
		//('-' (INT | ID))?
		public Group getGroup_1() { return cGroup_1; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_1_0() { return cHyphenMinusKeyword_1_0; }
		
		//INT | ID
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_1_1_0() { return cINTTerminalRuleCall_1_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1_1() { return cIDTerminalRuleCall_1_1_1; }
	}
	public class OperatingSysElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.OperatingSys");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAixKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHpuxKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cLinuxKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cMacosxKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cQnxKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cSolarisKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cWin32Keyword_6 = (Keyword)cAlternatives.eContents().get(6);
		
		//OperatingSys:
		//	'aix' | 'hpux' | 'linux' | 'macosx' | 'qnx' | 'solaris' | 'win32';
		@Override public ParserRule getRule() { return rule; }
		
		//'aix' | 'hpux' | 'linux' | 'macosx' | 'qnx' | 'solaris' | 'win32'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'aix'
		public Keyword getAixKeyword_0() { return cAixKeyword_0; }
		
		//'hpux'
		public Keyword getHpuxKeyword_1() { return cHpuxKeyword_1; }
		
		//'linux'
		public Keyword getLinuxKeyword_2() { return cLinuxKeyword_2; }
		
		//'macosx'
		public Keyword getMacosxKeyword_3() { return cMacosxKeyword_3; }
		
		//'qnx'
		public Keyword getQnxKeyword_4() { return cQnxKeyword_4; }
		
		//'solaris'
		public Keyword getSolarisKeyword_5() { return cSolarisKeyword_5; }
		
		//'win32'
		public Keyword getWin32Keyword_6() { return cWin32Keyword_6; }
	}
	public class WindowingSysElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.WindowingSys");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cCarbonKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cCocoaKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cGtkKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cMotifKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cPhotonKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cWpfKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cWin32Keyword_6 = (Keyword)cAlternatives.eContents().get(6);
		
		//WindowingSys:
		//	'carbon' | 'cocoa' | 'gtk' | 'motif' | 'photon' | 'wpf' | 'win32';
		@Override public ParserRule getRule() { return rule; }
		
		//'carbon' | 'cocoa' | 'gtk' | 'motif' | 'photon' | 'wpf' | 'win32'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'carbon'
		public Keyword getCarbonKeyword_0() { return cCarbonKeyword_0; }
		
		//'cocoa'
		public Keyword getCocoaKeyword_1() { return cCocoaKeyword_1; }
		
		//'gtk'
		public Keyword getGtkKeyword_2() { return cGtkKeyword_2; }
		
		//'motif'
		public Keyword getMotifKeyword_3() { return cMotifKeyword_3; }
		
		//'photon'
		public Keyword getPhotonKeyword_4() { return cPhotonKeyword_4; }
		
		//'wpf'
		public Keyword getWpfKeyword_5() { return cWpfKeyword_5; }
		
		//'win32'
		public Keyword getWin32Keyword_6() { return cWin32Keyword_6; }
	}
	public class ArchitectureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.Architecture");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPA_RISCKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cIa64Keyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cIa64_32Keyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cPpcKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cSparcKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cX86Keyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cX86_64Keyword_6 = (Keyword)cAlternatives.eContents().get(6);
		
		//Architecture:
		//	'PA_RISC' | 'ia64' | 'ia64_32' | 'ppc' | 'sparc' | 'x86' | 'x86_64';
		@Override public ParserRule getRule() { return rule; }
		
		//'PA_RISC' | 'ia64' | 'ia64_32' | 'ppc' | 'sparc' | 'x86' | 'x86_64'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'PA_RISC'
		public Keyword getPA_RISCKeyword_0() { return cPA_RISCKeyword_0; }
		
		//'ia64'
		public Keyword getIa64Keyword_1() { return cIa64Keyword_1; }
		
		//'ia64_32'
		public Keyword getIa64_32Keyword_2() { return cIa64_32Keyword_2; }
		
		//'ppc'
		public Keyword getPpcKeyword_3() { return cPpcKeyword_3; }
		
		//'sparc'
		public Keyword getSparcKeyword_4() { return cSparcKeyword_4; }
		
		//'x86'
		public Keyword getX86Keyword_5() { return cX86Keyword_5; }
		
		//'x86_64'
		public Keyword getX86_64Keyword_6() { return cX86_64Keyword_6; }
	}
	public class LocaleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.Locale");
		private final RuleCall cIDTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//Locale:
		//	ID;
		@Override public ParserRule getRule() { return rule; }
		
		//ID
		public RuleCall getIDTerminalRuleCall() { return cIDTerminalRuleCall; }
	}
	public class HttpElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.http");
		private final Keyword cHttpKeyword = (Keyword)rule.eContents().get(1);
		
		//http:
		//	'http://';
		@Override public ParserRule getRule() { return rule; }
		
		//'http://'
		public Keyword getHttpKeyword() { return cHttpKeyword; }
	}
	public class FileElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.file");
		private final Keyword cFileKeyword = (Keyword)rule.eContents().get(1);
		
		//file:
		//	'file:/';
		@Override public ParserRule getRule() { return rule; }
		
		//'file:/'
		public Keyword getFileKeyword() { return cFileKeyword; }
	}
	public class DotElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.dot");
		private final Keyword cFullStopKeyword = (Keyword)rule.eContents().get(1);
		
		//dot:
		//	'.';
		@Override public ParserRule getRule() { return rule; }
		
		//'.'
		public Keyword getFullStopKeyword() { return cFullStopKeyword; }
	}
	public class HypenElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.hypen");
		private final Keyword cHyphenMinusKeyword = (Keyword)rule.eContents().get(1);
		
		//hypen:
		//	'-';
		@Override public ParserRule getRule() { return rule; }
		
		//'-'
		public Keyword getHyphenMinusKeyword() { return cHyphenMinusKeyword; }
	}
	public class JreElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.jre");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final RuleCall cSimpleVersionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//jre:
		//	(ID | '-' | SimpleVersion)+;
		@Override public ParserRule getRule() { return rule; }
		
		//(ID | '-' | SimpleVersion)+
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }
		
		//SimpleVersion
		public RuleCall getSimpleVersionParserRuleCall_2() { return cSimpleVersionParserRuleCall_2; }
	}
	public class ValidIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.ValidID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cKEYWORDParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//ValidID:
		//	ID | KEYWORD;
		@Override public ParserRule getRule() { return rule; }
		
		//ID | KEYWORD
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//KEYWORD
		public RuleCall getKEYWORDParserRuleCall_1() { return cKEYWORDParserRuleCall_1; }
	}
	public class KEYWORDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.KEYWORD");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cUnitKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cTargetKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//KEYWORD:
		//	'Unit' | 'Target';
		@Override public ParserRule getRule() { return rule; }
		
		//'Unit' | 'Target'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'Unit'
		public Keyword getUnitKeyword_0() { return cUnitKeyword_0; }
		
		//'Target'
		public Keyword getTargetKeyword_1() { return cTargetKeyword_1; }
	}
	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "de.dlr.sc.overtarget.language.Overtarget.QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QualifiedName:
		//	ID ('.' ID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('.' ID)*
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('.' ID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final TargetFileElements pTargetFile;
	private final TargetLibraryElements pTargetLibrary;
	private final BaseModelElements pBaseModel;
	private final TargetModelElements pTargetModel;
	private final VersionElements pVersion;
	private final SimpleVersionElements pSimpleVersion;
	private final UnitElements pUnit;
	private final SourceElements pSource;
	private final UrlExpressionElements pUrlExpression;
	private final UrlElementElements pUrlElement;
	private final UrlElementStringElements pUrlElementString;
	private final UrlElementVariableElements pUrlElementVariable;
	private final RepositoryLocationElements pRepositoryLocation;
	private final ExcludeLocationElements pExcludeLocation;
	private final VariableDefinitionElements pVariableDefinition;
	private final AlreadyDeclaredVariableElements pAlreadyDeclaredVariable;
	private final NewVariableDefinitionElements pNewVariableDefinition;
	private final QualifierElements pQualifier;
	private final OperatingSysElements pOperatingSys;
	private final WindowingSysElements pWindowingSys;
	private final ArchitectureElements pArchitecture;
	private final LocaleElements pLocale;
	private final HttpElements pHttp;
	private final FileElements pFile;
	private final DotElements pDot;
	private final HypenElements pHypen;
	private final JreElements pJre;
	private final ValidIDElements pValidID;
	private final KEYWORDElements pKEYWORD;
	private final QualifiedNameElements pQualifiedName;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public OvertargetGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pTargetFile = new TargetFileElements();
		this.pTargetLibrary = new TargetLibraryElements();
		this.pBaseModel = new BaseModelElements();
		this.pTargetModel = new TargetModelElements();
		this.pVersion = new VersionElements();
		this.pSimpleVersion = new SimpleVersionElements();
		this.pUnit = new UnitElements();
		this.pSource = new SourceElements();
		this.pUrlExpression = new UrlExpressionElements();
		this.pUrlElement = new UrlElementElements();
		this.pUrlElementString = new UrlElementStringElements();
		this.pUrlElementVariable = new UrlElementVariableElements();
		this.pRepositoryLocation = new RepositoryLocationElements();
		this.pExcludeLocation = new ExcludeLocationElements();
		this.pVariableDefinition = new VariableDefinitionElements();
		this.pAlreadyDeclaredVariable = new AlreadyDeclaredVariableElements();
		this.pNewVariableDefinition = new NewVariableDefinitionElements();
		this.pQualifier = new QualifierElements();
		this.pOperatingSys = new OperatingSysElements();
		this.pWindowingSys = new WindowingSysElements();
		this.pArchitecture = new ArchitectureElements();
		this.pLocale = new LocaleElements();
		this.pHttp = new HttpElements();
		this.pFile = new FileElements();
		this.pDot = new DotElements();
		this.pHypen = new HypenElements();
		this.pJre = new JreElements();
		this.pValidID = new ValidIDElements();
		this.pKEYWORD = new KEYWORDElements();
		this.pQualifiedName = new QualifiedNameElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("de.dlr.sc.overtarget.language.Overtarget".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//TargetFile:
	//	TargetModel | TargetLibrary;
	public TargetFileElements getTargetFileAccess() {
		return pTargetFile;
	}
	
	public ParserRule getTargetFileRule() {
		return getTargetFileAccess().getRule();
	}
	
	//TargetLibrary:
	//	'TargetLibrary' name=ID '{'
	//	variables+=VariableDefinition*
	//	repositoryLocations+=RepositoryLocation*
	//	'}';
	public TargetLibraryElements getTargetLibraryAccess() {
		return pTargetLibrary;
	}
	
	public ParserRule getTargetLibraryRule() {
		return getTargetLibraryAccess().getRule();
	}
	
	//BaseModel:
	//	'Target' name=ID '{' ('Import' importedModels+=[TargetFile])*
	//	'OperatingSystem' os=OperatingSys ('WindowingSystem' | 'WorkingSystem') ws=WindowingSys
	//	'Architecture' arch=Architecture
	//	'Locale' loc=Locale ('TargetJRE' targetJre=jre)?
	//	variables+=VariableDefinition*
	//	excludedLocations+=ExcludeLocation*
	//	repositoryLocations+=RepositoryLocation*
	//	'}';
	public BaseModelElements getBaseModelAccess() {
		return pBaseModel;
	}
	
	public ParserRule getBaseModelRule() {
		return getBaseModelAccess().getRule();
	}
	
	//TargetModel:
	//	'Target' name=ID ('extends' super=[TargetModel])? '{' ('Import' importedModels+=[TargetFile])* ('OperatingSystem'
	//	os=OperatingSys)? (('WindowingSystem' | 'WorkingSystem') ws=WindowingSys)? ('Architecture' arch=Architecture)?
	//	('Locale' loc=Locale)? ('TargetJRE' targetJre=jre)?
	//	variables+=VariableDefinition*
	//	excludedLocations+=ExcludeLocation*
	//	repositoryLocations+=RepositoryLocation*
	//	'}';
	public TargetModelElements getTargetModelAccess() {
		return pTargetModel;
	}
	
	public ParserRule getTargetModelRule() {
		return getTargetModelAccess().getRule();
	}
	
	//Version hidden():
	//	INT '.' INT '.' INT ('.' qualifier)?;
	public VersionElements getVersionAccess() {
		return pVersion;
	}
	
	public ParserRule getVersionRule() {
		return getVersionAccess().getRule();
	}
	
	//SimpleVersion:
	//	INT ('.' INT)*;
	public SimpleVersionElements getSimpleVersionAccess() {
		return pSimpleVersion;
	}
	
	public ParserRule getSimpleVersionRule() {
		return getSimpleVersionAccess().getRule();
	}
	
	//Unit:
	//	'Unit' source=Source 'version' vers=(Version | 'newest') ';';
	public UnitElements getUnitAccess() {
		return pUnit;
	}
	
	public ParserRule getUnitRule() {
		return getUnitAccess().getRule();
	}
	
	//Source hidden():
	//	ValidID (dot ValidID | hypen ValidID)* ':'?;
	public SourceElements getSourceAccess() {
		return pSource;
	}
	
	public ParserRule getSourceRule() {
		return getSourceAccess().getRule();
	}
	
	//UrlExpression:
	//	UrlElement ({UrlExpression.left=current} '+' right=UrlElement)*;
	public UrlExpressionElements getUrlExpressionAccess() {
		return pUrlExpression;
	}
	
	public ParserRule getUrlExpressionRule() {
		return getUrlExpressionAccess().getRule();
	}
	
	//UrlElement:
	//	UrlElementVariable | UrlElementString;
	public UrlElementElements getUrlElementAccess() {
		return pUrlElement;
	}
	
	public ParserRule getUrlElementRule() {
		return getUrlElementAccess().getRule();
	}
	
	//UrlElementString:
	//	content=STRING;
	public UrlElementStringElements getUrlElementStringAccess() {
		return pUrlElementString;
	}
	
	public ParserRule getUrlElementStringRule() {
		return getUrlElementStringAccess().getRule();
	}
	
	//UrlElementVariable:
	//	content=[VariableDefinition|QualifiedName];
	public UrlElementVariableElements getUrlElementVariableAccess() {
		return pUrlElementVariable;
	}
	
	public ParserRule getUrlElementVariableRule() {
		return getUrlElementVariableAccess().getRule();
	}
	
	//RepositoryLocation:
	//	referenceTarget?='ReferenceTarget'? 'RepositoryLocation' name=ID 'url' url=UrlExpression '{'
	//	units+=Unit*
	//	'}';
	public RepositoryLocationElements getRepositoryLocationAccess() {
		return pRepositoryLocation;
	}
	
	public ParserRule getRepositoryLocationRule() {
		return getRepositoryLocationAccess().getRule();
	}
	
	//ExcludeLocation:
	//	{ExcludeLocation}
	//	'ExcludeLocation' repositoryLocation=[RepositoryLocation|QualifiedName] '{' (units+=Unit* | 'all;')
	//	'}';
	public ExcludeLocationElements getExcludeLocationAccess() {
		return pExcludeLocation;
	}
	
	public ParserRule getExcludeLocationRule() {
		return getExcludeLocationAccess().getRule();
	}
	
	//VariableDefinition:
	//	AlreadyDeclaredVariable | NewVariableDefinition;
	public VariableDefinitionElements getVariableDefinitionAccess() {
		return pVariableDefinition;
	}
	
	public ParserRule getVariableDefinitionRule() {
		return getVariableDefinitionAccess().getRule();
	}
	
	//AlreadyDeclaredVariable:
	//	'Override' ref=[NewVariableDefinition|QualifiedName] '=' value=STRING;
	public AlreadyDeclaredVariableElements getAlreadyDeclaredVariableAccess() {
		return pAlreadyDeclaredVariable;
	}
	
	public ParserRule getAlreadyDeclaredVariableRule() {
		return getAlreadyDeclaredVariableAccess().getRule();
	}
	
	//NewVariableDefinition:
	//	'Variable' name=ID '=' value=STRING;
	public NewVariableDefinitionElements getNewVariableDefinitionAccess() {
		return pNewVariableDefinition;
	}
	
	public ParserRule getNewVariableDefinitionRule() {
		return getNewVariableDefinitionAccess().getRule();
	}
	
	//qualifier:
	//	(INT | ID)+ ('-' (INT | ID))?;
	public QualifierElements getQualifierAccess() {
		return pQualifier;
	}
	
	public ParserRule getQualifierRule() {
		return getQualifierAccess().getRule();
	}
	
	//OperatingSys:
	//	'aix' | 'hpux' | 'linux' | 'macosx' | 'qnx' | 'solaris' | 'win32';
	public OperatingSysElements getOperatingSysAccess() {
		return pOperatingSys;
	}
	
	public ParserRule getOperatingSysRule() {
		return getOperatingSysAccess().getRule();
	}
	
	//WindowingSys:
	//	'carbon' | 'cocoa' | 'gtk' | 'motif' | 'photon' | 'wpf' | 'win32';
	public WindowingSysElements getWindowingSysAccess() {
		return pWindowingSys;
	}
	
	public ParserRule getWindowingSysRule() {
		return getWindowingSysAccess().getRule();
	}
	
	//Architecture:
	//	'PA_RISC' | 'ia64' | 'ia64_32' | 'ppc' | 'sparc' | 'x86' | 'x86_64';
	public ArchitectureElements getArchitectureAccess() {
		return pArchitecture;
	}
	
	public ParserRule getArchitectureRule() {
		return getArchitectureAccess().getRule();
	}
	
	//Locale:
	//	ID;
	public LocaleElements getLocaleAccess() {
		return pLocale;
	}
	
	public ParserRule getLocaleRule() {
		return getLocaleAccess().getRule();
	}
	
	//http:
	//	'http://';
	public HttpElements getHttpAccess() {
		return pHttp;
	}
	
	public ParserRule getHttpRule() {
		return getHttpAccess().getRule();
	}
	
	//file:
	//	'file:/';
	public FileElements getFileAccess() {
		return pFile;
	}
	
	public ParserRule getFileRule() {
		return getFileAccess().getRule();
	}
	
	//dot:
	//	'.';
	public DotElements getDotAccess() {
		return pDot;
	}
	
	public ParserRule getDotRule() {
		return getDotAccess().getRule();
	}
	
	//hypen:
	//	'-';
	public HypenElements getHypenAccess() {
		return pHypen;
	}
	
	public ParserRule getHypenRule() {
		return getHypenAccess().getRule();
	}
	
	//jre:
	//	(ID | '-' | SimpleVersion)+;
	public JreElements getJreAccess() {
		return pJre;
	}
	
	public ParserRule getJreRule() {
		return getJreAccess().getRule();
	}
	
	//ValidID:
	//	ID | KEYWORD;
	public ValidIDElements getValidIDAccess() {
		return pValidID;
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//KEYWORD:
	//	'Unit' | 'Target';
	public KEYWORDElements getKEYWORDAccess() {
		return pKEYWORD;
	}
	
	public ParserRule getKEYWORDRule() {
		return getKEYWORDAccess().getRule();
	}
	
	//QualifiedName:
	//	ID ('.' ID)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' | "'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
