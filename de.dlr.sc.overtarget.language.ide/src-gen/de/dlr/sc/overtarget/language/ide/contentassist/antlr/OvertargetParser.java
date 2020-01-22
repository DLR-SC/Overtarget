/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.ide.contentassist.antlr;

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.ide.contentassist.antlr.internal.InternalOvertargetParser;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class OvertargetParser extends AbstractContentAssistParser {

	@Inject
	private OvertargetGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalOvertargetParser createParser() {
		InternalOvertargetParser result = new InternalOvertargetParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getTargetFileAccess().getAlternatives(), "rule__TargetFile__Alternatives");
					put(grammarAccess.getUnitAccess().getVersAlternatives_3_0(), "rule__Unit__VersAlternatives_3_0");
					put(grammarAccess.getSourceAccess().getAlternatives_1(), "rule__Source__Alternatives_1");
					put(grammarAccess.getUrlElementAccess().getAlternatives(), "rule__UrlElement__Alternatives");
					put(grammarAccess.getExcludeLocationAccess().getAlternatives_4(), "rule__ExcludeLocation__Alternatives_4");
					put(grammarAccess.getVariableDefinitionAccess().getAlternatives(), "rule__VariableDefinition__Alternatives");
					put(grammarAccess.getQualifierAccess().getAlternatives_0(), "rule__Qualifier__Alternatives_0");
					put(grammarAccess.getQualifierAccess().getAlternatives_1_1(), "rule__Qualifier__Alternatives_1_1");
					put(grammarAccess.getOperatingSysAccess().getAlternatives(), "rule__OperatingSys__Alternatives");
					put(grammarAccess.getWorkingSysAccess().getAlternatives(), "rule__WorkingSys__Alternatives");
					put(grammarAccess.getArchitectureAccess().getAlternatives(), "rule__Architecture__Alternatives");
					put(grammarAccess.getJreAccess().getAlternatives(), "rule__Jre__Alternatives");
					put(grammarAccess.getValidIDAccess().getAlternatives(), "rule__ValidID__Alternatives");
					put(grammarAccess.getKEYWORDAccess().getAlternatives(), "rule__KEYWORD__Alternatives");
					put(grammarAccess.getTargetLibraryAccess().getGroup(), "rule__TargetLibrary__Group__0");
					put(grammarAccess.getBaseModelAccess().getGroup(), "rule__BaseModel__Group__0");
					put(grammarAccess.getBaseModelAccess().getGroup_3(), "rule__BaseModel__Group_3__0");
					put(grammarAccess.getBaseModelAccess().getGroup_12(), "rule__BaseModel__Group_12__0");
					put(grammarAccess.getTargetModelAccess().getGroup(), "rule__TargetModel__Group__0");
					put(grammarAccess.getTargetModelAccess().getGroup_2(), "rule__TargetModel__Group_2__0");
					put(grammarAccess.getTargetModelAccess().getGroup_4(), "rule__TargetModel__Group_4__0");
					put(grammarAccess.getTargetModelAccess().getGroup_5(), "rule__TargetModel__Group_5__0");
					put(grammarAccess.getTargetModelAccess().getGroup_6(), "rule__TargetModel__Group_6__0");
					put(grammarAccess.getTargetModelAccess().getGroup_7(), "rule__TargetModel__Group_7__0");
					put(grammarAccess.getTargetModelAccess().getGroup_8(), "rule__TargetModel__Group_8__0");
					put(grammarAccess.getTargetModelAccess().getGroup_9(), "rule__TargetModel__Group_9__0");
					put(grammarAccess.getVersionAccess().getGroup(), "rule__Version__Group__0");
					put(grammarAccess.getVersionAccess().getGroup_5(), "rule__Version__Group_5__0");
					put(grammarAccess.getSimpleVersionAccess().getGroup(), "rule__SimpleVersion__Group__0");
					put(grammarAccess.getSimpleVersionAccess().getGroup_1(), "rule__SimpleVersion__Group_1__0");
					put(grammarAccess.getUnitAccess().getGroup(), "rule__Unit__Group__0");
					put(grammarAccess.getSourceAccess().getGroup(), "rule__Source__Group__0");
					put(grammarAccess.getSourceAccess().getGroup_1_0(), "rule__Source__Group_1_0__0");
					put(grammarAccess.getSourceAccess().getGroup_1_1(), "rule__Source__Group_1_1__0");
					put(grammarAccess.getUrlExpressionAccess().getGroup(), "rule__UrlExpression__Group__0");
					put(grammarAccess.getUrlExpressionAccess().getGroup_1(), "rule__UrlExpression__Group_1__0");
					put(grammarAccess.getRepositoryLocationAccess().getGroup(), "rule__RepositoryLocation__Group__0");
					put(grammarAccess.getExcludeLocationAccess().getGroup(), "rule__ExcludeLocation__Group__0");
					put(grammarAccess.getAlreadyDeclaredVariableAccess().getGroup(), "rule__AlreadyDeclaredVariable__Group__0");
					put(grammarAccess.getNewVariableDefinitionAccess().getGroup(), "rule__NewVariableDefinition__Group__0");
					put(grammarAccess.getQualifierAccess().getGroup(), "rule__Qualifier__Group__0");
					put(grammarAccess.getQualifierAccess().getGroup_1(), "rule__Qualifier__Group_1__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getTargetLibraryAccess().getNameAssignment_1(), "rule__TargetLibrary__NameAssignment_1");
					put(grammarAccess.getTargetLibraryAccess().getVariablesAssignment_3(), "rule__TargetLibrary__VariablesAssignment_3");
					put(grammarAccess.getTargetLibraryAccess().getRepositoryLocationsAssignment_4(), "rule__TargetLibrary__RepositoryLocationsAssignment_4");
					put(grammarAccess.getBaseModelAccess().getNameAssignment_1(), "rule__BaseModel__NameAssignment_1");
					put(grammarAccess.getBaseModelAccess().getImportedModelsAssignment_3_1(), "rule__BaseModel__ImportedModelsAssignment_3_1");
					put(grammarAccess.getBaseModelAccess().getOsAssignment_5(), "rule__BaseModel__OsAssignment_5");
					put(grammarAccess.getBaseModelAccess().getWsAssignment_7(), "rule__BaseModel__WsAssignment_7");
					put(grammarAccess.getBaseModelAccess().getArchAssignment_9(), "rule__BaseModel__ArchAssignment_9");
					put(grammarAccess.getBaseModelAccess().getLocAssignment_11(), "rule__BaseModel__LocAssignment_11");
					put(grammarAccess.getBaseModelAccess().getTargetJreAssignment_12_1(), "rule__BaseModel__TargetJreAssignment_12_1");
					put(grammarAccess.getBaseModelAccess().getVariablesAssignment_13(), "rule__BaseModel__VariablesAssignment_13");
					put(grammarAccess.getBaseModelAccess().getExcludedLocationsAssignment_14(), "rule__BaseModel__ExcludedLocationsAssignment_14");
					put(grammarAccess.getBaseModelAccess().getRepositoryLocationsAssignment_15(), "rule__BaseModel__RepositoryLocationsAssignment_15");
					put(grammarAccess.getTargetModelAccess().getNameAssignment_1(), "rule__TargetModel__NameAssignment_1");
					put(grammarAccess.getTargetModelAccess().getSuperAssignment_2_1(), "rule__TargetModel__SuperAssignment_2_1");
					put(grammarAccess.getTargetModelAccess().getImportedModelsAssignment_4_1(), "rule__TargetModel__ImportedModelsAssignment_4_1");
					put(grammarAccess.getTargetModelAccess().getOsAssignment_5_1(), "rule__TargetModel__OsAssignment_5_1");
					put(grammarAccess.getTargetModelAccess().getWsAssignment_6_1(), "rule__TargetModel__WsAssignment_6_1");
					put(grammarAccess.getTargetModelAccess().getArchAssignment_7_1(), "rule__TargetModel__ArchAssignment_7_1");
					put(grammarAccess.getTargetModelAccess().getLocAssignment_8_1(), "rule__TargetModel__LocAssignment_8_1");
					put(grammarAccess.getTargetModelAccess().getTargetJreAssignment_9_1(), "rule__TargetModel__TargetJreAssignment_9_1");
					put(grammarAccess.getTargetModelAccess().getVariablesAssignment_10(), "rule__TargetModel__VariablesAssignment_10");
					put(grammarAccess.getTargetModelAccess().getExcludedLocationsAssignment_11(), "rule__TargetModel__ExcludedLocationsAssignment_11");
					put(grammarAccess.getTargetModelAccess().getRepositoryLocationsAssignment_12(), "rule__TargetModel__RepositoryLocationsAssignment_12");
					put(grammarAccess.getUnitAccess().getSourceAssignment_1(), "rule__Unit__SourceAssignment_1");
					put(grammarAccess.getUnitAccess().getVersAssignment_3(), "rule__Unit__VersAssignment_3");
					put(grammarAccess.getUrlExpressionAccess().getRightAssignment_1_2(), "rule__UrlExpression__RightAssignment_1_2");
					put(grammarAccess.getUrlElementStringAccess().getContentAssignment(), "rule__UrlElementString__ContentAssignment");
					put(grammarAccess.getUrlElementVariableAccess().getContentAssignment(), "rule__UrlElementVariable__ContentAssignment");
					put(grammarAccess.getRepositoryLocationAccess().getNameAssignment_1(), "rule__RepositoryLocation__NameAssignment_1");
					put(grammarAccess.getRepositoryLocationAccess().getUrlAssignment_3(), "rule__RepositoryLocation__UrlAssignment_3");
					put(grammarAccess.getRepositoryLocationAccess().getUnitsAssignment_5(), "rule__RepositoryLocation__UnitsAssignment_5");
					put(grammarAccess.getExcludeLocationAccess().getRepositoryLocationAssignment_2(), "rule__ExcludeLocation__RepositoryLocationAssignment_2");
					put(grammarAccess.getExcludeLocationAccess().getUnitsAssignment_4_0(), "rule__ExcludeLocation__UnitsAssignment_4_0");
					put(grammarAccess.getAlreadyDeclaredVariableAccess().getRefAssignment_1(), "rule__AlreadyDeclaredVariable__RefAssignment_1");
					put(grammarAccess.getAlreadyDeclaredVariableAccess().getValueAssignment_3(), "rule__AlreadyDeclaredVariable__ValueAssignment_3");
					put(grammarAccess.getNewVariableDefinitionAccess().getNameAssignment_1(), "rule__NewVariableDefinition__NameAssignment_1");
					put(grammarAccess.getNewVariableDefinitionAccess().getValueAssignment_3(), "rule__NewVariableDefinition__ValueAssignment_3");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public OvertargetGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(OvertargetGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
