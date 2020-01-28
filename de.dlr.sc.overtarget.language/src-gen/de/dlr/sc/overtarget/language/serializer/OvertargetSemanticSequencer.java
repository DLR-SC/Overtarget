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
import de.dlr.sc.overtarget.language.targetmodel.AlreadyDeclaredVariable;
import de.dlr.sc.overtarget.language.targetmodel.BaseModel;
import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation;
import de.dlr.sc.overtarget.language.targetmodel.NewVariableDefinition;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetLibrary;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.targetmodel.UrlElementString;
import de.dlr.sc.overtarget.language.targetmodel.UrlElementVariable;
import de.dlr.sc.overtarget.language.targetmodel.UrlExpression;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class OvertargetSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private OvertargetGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TargetmodelPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TargetmodelPackage.ALREADY_DECLARED_VARIABLE:
				sequence_AlreadyDeclaredVariable(context, (AlreadyDeclaredVariable) semanticObject); 
				return; 
			case TargetmodelPackage.BASE_MODEL:
				sequence_BaseModel(context, (BaseModel) semanticObject); 
				return; 
			case TargetmodelPackage.EXCLUDE_LOCATION:
				sequence_ExcludeLocation(context, (ExcludeLocation) semanticObject); 
				return; 
			case TargetmodelPackage.NEW_VARIABLE_DEFINITION:
				sequence_NewVariableDefinition(context, (NewVariableDefinition) semanticObject); 
				return; 
			case TargetmodelPackage.REPOSITORY_LOCATION:
				sequence_RepositoryLocation(context, (RepositoryLocation) semanticObject); 
				return; 
			case TargetmodelPackage.TARGET_LIBRARY:
				sequence_TargetLibrary(context, (TargetLibrary) semanticObject); 
				return; 
			case TargetmodelPackage.TARGET_MODEL:
				sequence_TargetModel(context, (TargetModel) semanticObject); 
				return; 
			case TargetmodelPackage.UNIT:
				sequence_Unit(context, (Unit) semanticObject); 
				return; 
			case TargetmodelPackage.URL_ELEMENT_STRING:
				sequence_UrlElementString(context, (UrlElementString) semanticObject); 
				return; 
			case TargetmodelPackage.URL_ELEMENT_VARIABLE:
				sequence_UrlElementVariable(context, (UrlElementVariable) semanticObject); 
				return; 
			case TargetmodelPackage.URL_EXPRESSION:
				sequence_UrlExpression(context, (UrlExpression) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     VariableDefinition returns AlreadyDeclaredVariable
	 *     AlreadyDeclaredVariable returns AlreadyDeclaredVariable
	 *
	 * Constraint:
	 *     (ref=[NewVariableDefinition|QualifiedName] value=STRING)
	 */
	protected void sequence_AlreadyDeclaredVariable(ISerializationContext context, AlreadyDeclaredVariable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TargetmodelPackage.Literals.ALREADY_DECLARED_VARIABLE__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetmodelPackage.Literals.ALREADY_DECLARED_VARIABLE__REF));
			if (transientValues.isValueTransient(semanticObject, TargetmodelPackage.Literals.VARIABLE_DEFINITION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetmodelPackage.Literals.VARIABLE_DEFINITION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAlreadyDeclaredVariableAccess().getRefNewVariableDefinitionQualifiedNameParserRuleCall_1_0_1(), semanticObject.eGet(TargetmodelPackage.Literals.ALREADY_DECLARED_VARIABLE__REF, false));
		feeder.accept(grammarAccess.getAlreadyDeclaredVariableAccess().getValueSTRINGTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     BaseModel returns BaseModel
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         importedModels+=[TargetFile|ID]* 
	 *         os=OperatingSys 
	 *         ws=WindowingSys 
	 *         arch=Architecture 
	 *         loc=Locale 
	 *         targetJre=jre? 
	 *         variables+=VariableDefinition* 
	 *         excludedLocations+=ExcludeLocation* 
	 *         repositoryLocations+=RepositoryLocation*
	 *     )
	 */
	protected void sequence_BaseModel(ISerializationContext context, BaseModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ExcludeLocation returns ExcludeLocation
	 *
	 * Constraint:
	 *     (repositoryLocation=[RepositoryLocation|QualifiedName] units+=Unit*)
	 */
	protected void sequence_ExcludeLocation(ISerializationContext context, ExcludeLocation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VariableDefinition returns NewVariableDefinition
	 *     NewVariableDefinition returns NewVariableDefinition
	 *
	 * Constraint:
	 *     (name=ID value=STRING)
	 */
	protected void sequence_NewVariableDefinition(ISerializationContext context, NewVariableDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TargetmodelPackage.Literals.NEW_VARIABLE_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetmodelPackage.Literals.NEW_VARIABLE_DEFINITION__NAME));
			if (transientValues.isValueTransient(semanticObject, TargetmodelPackage.Literals.VARIABLE_DEFINITION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetmodelPackage.Literals.VARIABLE_DEFINITION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNewVariableDefinitionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getNewVariableDefinitionAccess().getValueSTRINGTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RepositoryLocation returns RepositoryLocation
	 *
	 * Constraint:
	 *     (name=ID url=UrlExpression units+=Unit*)
	 */
	protected void sequence_RepositoryLocation(ISerializationContext context, RepositoryLocation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TargetFile returns TargetLibrary
	 *     TargetLibrary returns TargetLibrary
	 *
	 * Constraint:
	 *     (name=ID variables+=VariableDefinition* repositoryLocations+=RepositoryLocation*)
	 */
	protected void sequence_TargetLibrary(ISerializationContext context, TargetLibrary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TargetFile returns TargetModel
	 *     TargetModel returns TargetModel
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         super=[TargetModel|ID]? 
	 *         importedModels+=[TargetFile|ID]* 
	 *         os=OperatingSys? 
	 *         ws=WindowingSys 
	 *         arch=Architecture? 
	 *         loc=Locale? 
	 *         targetJre=jre? 
	 *         variables+=VariableDefinition* 
	 *         excludedLocations+=ExcludeLocation* 
	 *         repositoryLocations+=RepositoryLocation*
	 *     )
	 */
	protected void sequence_TargetModel(ISerializationContext context, TargetModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Unit returns Unit
	 *
	 * Constraint:
	 *     (source=Source (vers=Version | vers='newest'))
	 */
	protected void sequence_Unit(ISerializationContext context, Unit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UrlExpression returns UrlElementString
	 *     UrlExpression.UrlExpression_1_0 returns UrlElementString
	 *     UrlElement returns UrlElementString
	 *     UrlElementString returns UrlElementString
	 *
	 * Constraint:
	 *     content=STRING
	 */
	protected void sequence_UrlElementString(ISerializationContext context, UrlElementString semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TargetmodelPackage.Literals.URL_ELEMENT_STRING__CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetmodelPackage.Literals.URL_ELEMENT_STRING__CONTENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUrlElementStringAccess().getContentSTRINGTerminalRuleCall_0(), semanticObject.getContent());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     UrlExpression returns UrlElementVariable
	 *     UrlExpression.UrlExpression_1_0 returns UrlElementVariable
	 *     UrlElement returns UrlElementVariable
	 *     UrlElementVariable returns UrlElementVariable
	 *
	 * Constraint:
	 *     content=[VariableDefinition|QualifiedName]
	 */
	protected void sequence_UrlElementVariable(ISerializationContext context, UrlElementVariable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TargetmodelPackage.Literals.URL_ELEMENT_VARIABLE__CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetmodelPackage.Literals.URL_ELEMENT_VARIABLE__CONTENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUrlElementVariableAccess().getContentVariableDefinitionQualifiedNameParserRuleCall_0_1(), semanticObject.eGet(TargetmodelPackage.Literals.URL_ELEMENT_VARIABLE__CONTENT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     UrlExpression returns UrlExpression
	 *     UrlExpression.UrlExpression_1_0 returns UrlExpression
	 *
	 * Constraint:
	 *     (left=UrlExpression_UrlExpression_1_0 right=UrlElement)
	 */
	protected void sequence_UrlExpression(ISerializationContext context, UrlExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TargetmodelPackage.Literals.URL_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetmodelPackage.Literals.URL_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, TargetmodelPackage.Literals.URL_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetmodelPackage.Literals.URL_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUrlExpressionAccess().getUrlExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getUrlExpressionAccess().getRightUrlElementParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
}
