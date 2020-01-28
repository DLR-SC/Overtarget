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

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.dlr.sc.overtarget.language.ide.contentassist.antlr.internal.InternalOvertargetParser;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class OvertargetParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(OvertargetGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, OvertargetGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getTargetFileAccess().getAlternatives(), "rule__TargetFile__Alternatives");
			builder.put(grammarAccess.getBaseModelAccess().getAlternatives(), "rule__BaseModel__Alternatives");
			builder.put(grammarAccess.getTargetModelAccess().getAlternatives_6(), "rule__TargetModel__Alternatives_6");
			builder.put(grammarAccess.getUnitAccess().getVersAlternatives_3_0(), "rule__Unit__VersAlternatives_3_0");
			builder.put(grammarAccess.getSourceAccess().getAlternatives_1(), "rule__Source__Alternatives_1");
			builder.put(grammarAccess.getUrlElementAccess().getAlternatives(), "rule__UrlElement__Alternatives");
			builder.put(grammarAccess.getExcludeLocationAccess().getAlternatives_4(), "rule__ExcludeLocation__Alternatives_4");
			builder.put(grammarAccess.getVariableDefinitionAccess().getAlternatives(), "rule__VariableDefinition__Alternatives");
			builder.put(grammarAccess.getQualifierAccess().getAlternatives_0(), "rule__Qualifier__Alternatives_0");
			builder.put(grammarAccess.getQualifierAccess().getAlternatives_1_1(), "rule__Qualifier__Alternatives_1_1");
			builder.put(grammarAccess.getOperatingSysAccess().getAlternatives(), "rule__OperatingSys__Alternatives");
			builder.put(grammarAccess.getWindowingSysAccess().getAlternatives(), "rule__WindowingSys__Alternatives");
			builder.put(grammarAccess.getWorkingSysAccess().getAlternatives(), "rule__WorkingSys__Alternatives");
			builder.put(grammarAccess.getArchitectureAccess().getAlternatives(), "rule__Architecture__Alternatives");
			builder.put(grammarAccess.getJreAccess().getAlternatives(), "rule__Jre__Alternatives");
			builder.put(grammarAccess.getValidIDAccess().getAlternatives(), "rule__ValidID__Alternatives");
			builder.put(grammarAccess.getKEYWORDAccess().getAlternatives(), "rule__KEYWORD__Alternatives");
			builder.put(grammarAccess.getTargetLibraryAccess().getGroup(), "rule__TargetLibrary__Group__0");
			builder.put(grammarAccess.getBaseModelAccess().getGroup_0(), "rule__BaseModel__Group_0__0");
			builder.put(grammarAccess.getBaseModelAccess().getGroup_0_3(), "rule__BaseModel__Group_0_3__0");
			builder.put(grammarAccess.getBaseModelAccess().getGroup_1(), "rule__BaseModel__Group_1__0");
			builder.put(grammarAccess.getBaseModelAccess().getGroup_1_6(), "rule__BaseModel__Group_1_6__0");
			builder.put(grammarAccess.getTargetModelAccess().getGroup(), "rule__TargetModel__Group__0");
			builder.put(grammarAccess.getTargetModelAccess().getGroup_2(), "rule__TargetModel__Group_2__0");
			builder.put(grammarAccess.getTargetModelAccess().getGroup_4(), "rule__TargetModel__Group_4__0");
			builder.put(grammarAccess.getTargetModelAccess().getGroup_5(), "rule__TargetModel__Group_5__0");
			builder.put(grammarAccess.getTargetModelAccess().getGroup_6_0(), "rule__TargetModel__Group_6_0__0");
			builder.put(grammarAccess.getTargetModelAccess().getGroup_6_1(), "rule__TargetModel__Group_6_1__0");
			builder.put(grammarAccess.getTargetModelAccess().getGroup_7(), "rule__TargetModel__Group_7__0");
			builder.put(grammarAccess.getTargetModelAccess().getGroup_8(), "rule__TargetModel__Group_8__0");
			builder.put(grammarAccess.getTargetModelAccess().getGroup_9(), "rule__TargetModel__Group_9__0");
			builder.put(grammarAccess.getVersionAccess().getGroup(), "rule__Version__Group__0");
			builder.put(grammarAccess.getVersionAccess().getGroup_5(), "rule__Version__Group_5__0");
			builder.put(grammarAccess.getSimpleVersionAccess().getGroup(), "rule__SimpleVersion__Group__0");
			builder.put(grammarAccess.getSimpleVersionAccess().getGroup_1(), "rule__SimpleVersion__Group_1__0");
			builder.put(grammarAccess.getUnitAccess().getGroup(), "rule__Unit__Group__0");
			builder.put(grammarAccess.getSourceAccess().getGroup(), "rule__Source__Group__0");
			builder.put(grammarAccess.getSourceAccess().getGroup_1_0(), "rule__Source__Group_1_0__0");
			builder.put(grammarAccess.getSourceAccess().getGroup_1_1(), "rule__Source__Group_1_1__0");
			builder.put(grammarAccess.getUrlExpressionAccess().getGroup(), "rule__UrlExpression__Group__0");
			builder.put(grammarAccess.getUrlExpressionAccess().getGroup_1(), "rule__UrlExpression__Group_1__0");
			builder.put(grammarAccess.getRepositoryLocationAccess().getGroup(), "rule__RepositoryLocation__Group__0");
			builder.put(grammarAccess.getExcludeLocationAccess().getGroup(), "rule__ExcludeLocation__Group__0");
			builder.put(grammarAccess.getAlreadyDeclaredVariableAccess().getGroup(), "rule__AlreadyDeclaredVariable__Group__0");
			builder.put(grammarAccess.getNewVariableDefinitionAccess().getGroup(), "rule__NewVariableDefinition__Group__0");
			builder.put(grammarAccess.getQualifierAccess().getGroup(), "rule__Qualifier__Group__0");
			builder.put(grammarAccess.getQualifierAccess().getGroup_1(), "rule__Qualifier__Group_1__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getTargetLibraryAccess().getNameAssignment_1(), "rule__TargetLibrary__NameAssignment_1");
			builder.put(grammarAccess.getTargetLibraryAccess().getVariablesAssignment_3(), "rule__TargetLibrary__VariablesAssignment_3");
			builder.put(grammarAccess.getTargetLibraryAccess().getRepositoryLocationsAssignment_4(), "rule__TargetLibrary__RepositoryLocationsAssignment_4");
			builder.put(grammarAccess.getBaseModelAccess().getNameAssignment_0_1(), "rule__BaseModel__NameAssignment_0_1");
			builder.put(grammarAccess.getBaseModelAccess().getImportedModelsAssignment_0_3_1(), "rule__BaseModel__ImportedModelsAssignment_0_3_1");
			builder.put(grammarAccess.getBaseModelAccess().getOsAssignment_0_5(), "rule__BaseModel__OsAssignment_0_5");
			builder.put(grammarAccess.getBaseModelAccess().getWsAssignment_0_7(), "rule__BaseModel__WsAssignment_0_7");
			builder.put(grammarAccess.getBaseModelAccess().getWksAssignment_1_1(), "rule__BaseModel__WksAssignment_1_1");
			builder.put(grammarAccess.getBaseModelAccess().getArchAssignment_1_3(), "rule__BaseModel__ArchAssignment_1_3");
			builder.put(grammarAccess.getBaseModelAccess().getLocAssignment_1_5(), "rule__BaseModel__LocAssignment_1_5");
			builder.put(grammarAccess.getBaseModelAccess().getTargetJreAssignment_1_6_1(), "rule__BaseModel__TargetJreAssignment_1_6_1");
			builder.put(grammarAccess.getBaseModelAccess().getVariablesAssignment_1_7(), "rule__BaseModel__VariablesAssignment_1_7");
			builder.put(grammarAccess.getBaseModelAccess().getExcludedLocationsAssignment_1_8(), "rule__BaseModel__ExcludedLocationsAssignment_1_8");
			builder.put(grammarAccess.getBaseModelAccess().getRepositoryLocationsAssignment_1_9(), "rule__BaseModel__RepositoryLocationsAssignment_1_9");
			builder.put(grammarAccess.getTargetModelAccess().getNameAssignment_1(), "rule__TargetModel__NameAssignment_1");
			builder.put(grammarAccess.getTargetModelAccess().getSuperAssignment_2_1(), "rule__TargetModel__SuperAssignment_2_1");
			builder.put(grammarAccess.getTargetModelAccess().getImportedModelsAssignment_4_1(), "rule__TargetModel__ImportedModelsAssignment_4_1");
			builder.put(grammarAccess.getTargetModelAccess().getOsAssignment_5_1(), "rule__TargetModel__OsAssignment_5_1");
			builder.put(grammarAccess.getTargetModelAccess().getWsAssignment_6_0_1(), "rule__TargetModel__WsAssignment_6_0_1");
			builder.put(grammarAccess.getTargetModelAccess().getWksAssignment_6_1_1(), "rule__TargetModel__WksAssignment_6_1_1");
			builder.put(grammarAccess.getTargetModelAccess().getArchAssignment_7_1(), "rule__TargetModel__ArchAssignment_7_1");
			builder.put(grammarAccess.getTargetModelAccess().getLocAssignment_8_1(), "rule__TargetModel__LocAssignment_8_1");
			builder.put(grammarAccess.getTargetModelAccess().getTargetJreAssignment_9_1(), "rule__TargetModel__TargetJreAssignment_9_1");
			builder.put(grammarAccess.getTargetModelAccess().getVariablesAssignment_10(), "rule__TargetModel__VariablesAssignment_10");
			builder.put(grammarAccess.getTargetModelAccess().getExcludedLocationsAssignment_11(), "rule__TargetModel__ExcludedLocationsAssignment_11");
			builder.put(grammarAccess.getTargetModelAccess().getRepositoryLocationsAssignment_12(), "rule__TargetModel__RepositoryLocationsAssignment_12");
			builder.put(grammarAccess.getUnitAccess().getSourceAssignment_1(), "rule__Unit__SourceAssignment_1");
			builder.put(grammarAccess.getUnitAccess().getVersAssignment_3(), "rule__Unit__VersAssignment_3");
			builder.put(grammarAccess.getUrlExpressionAccess().getRightAssignment_1_2(), "rule__UrlExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getUrlElementStringAccess().getContentAssignment(), "rule__UrlElementString__ContentAssignment");
			builder.put(grammarAccess.getUrlElementVariableAccess().getContentAssignment(), "rule__UrlElementVariable__ContentAssignment");
			builder.put(grammarAccess.getRepositoryLocationAccess().getNameAssignment_1(), "rule__RepositoryLocation__NameAssignment_1");
			builder.put(grammarAccess.getRepositoryLocationAccess().getUrlAssignment_3(), "rule__RepositoryLocation__UrlAssignment_3");
			builder.put(grammarAccess.getRepositoryLocationAccess().getUnitsAssignment_5(), "rule__RepositoryLocation__UnitsAssignment_5");
			builder.put(grammarAccess.getExcludeLocationAccess().getRepositoryLocationAssignment_2(), "rule__ExcludeLocation__RepositoryLocationAssignment_2");
			builder.put(grammarAccess.getExcludeLocationAccess().getUnitsAssignment_4_0(), "rule__ExcludeLocation__UnitsAssignment_4_0");
			builder.put(grammarAccess.getAlreadyDeclaredVariableAccess().getRefAssignment_1(), "rule__AlreadyDeclaredVariable__RefAssignment_1");
			builder.put(grammarAccess.getAlreadyDeclaredVariableAccess().getValueAssignment_3(), "rule__AlreadyDeclaredVariable__ValueAssignment_3");
			builder.put(grammarAccess.getNewVariableDefinitionAccess().getNameAssignment_1(), "rule__NewVariableDefinition__NameAssignment_1");
			builder.put(grammarAccess.getNewVariableDefinitionAccess().getValueAssignment_3(), "rule__NewVariableDefinition__ValueAssignment_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private OvertargetGrammarAccess grammarAccess;

	@Override
	protected InternalOvertargetParser createParser() {
		InternalOvertargetParser result = new InternalOvertargetParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
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
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
