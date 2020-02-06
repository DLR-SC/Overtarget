/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.validation;

import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.validation.AbstractOvertargetValidator;
import de.dlr.sc.overtarget.language.validation.ValidatorHelper;
import javax.inject.Inject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class OvertargetValidator extends AbstractOvertargetValidator {
  @Check
  public void checkFileNameAndTargetName(final TargetFile target) {
    ValidatorHelper helper = new ValidatorHelper();
    final String fileName = helper.getFileName(target);
    boolean _equals = fileName.equals(target.getName());
    boolean _not = (!_equals);
    if (_not) {
      this.warning("File name and model name are not the same!", target, target.eContainingFeature());
    }
  }
  
  @Inject
  private OvertargetGrammarAccess grammarAccess;
  
  public static final String DEPRECATED_WS_STATEMENT = "deprecatedWS";
  
  @Check
  public void checkIfWorkingSysUsed(final TargetModel target) {
    final ICompositeNode node = NodeModelUtils.getNode(target);
    final String nodeText = node.getText().toString();
    final String deprecatedWorkingSystemKeyword = this.grammarAccess.getTargetModelAccess().getWorkingSystemKeyword_6_0_1().getValue();
    final String windowingSystemKeyword = this.grammarAccess.getTargetModelAccess().getWindowingSystemKeyword_6_0_0().getValue();
    boolean _contains = nodeText.contains(deprecatedWorkingSystemKeyword);
    if (_contains) {
      this.warning((((("Please use " + windowingSystemKeyword) + " instead of ") + deprecatedWorkingSystemKeyword) + "!"), target, TargetmodelPackage.eINSTANCE.getTargetModel_Ws(), OvertargetValidator.DEPRECATED_WS_STATEMENT);
    }
  }
}
