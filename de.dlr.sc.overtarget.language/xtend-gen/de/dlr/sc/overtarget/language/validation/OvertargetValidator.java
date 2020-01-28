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

import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.impl.TargetModelImpl;
import de.dlr.sc.overtarget.language.validation.AbstractOvertargetValidator;
import de.dlr.sc.overtarget.language.validation.ValidatorHelper;
import org.eclipse.xtext.validation.Check;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class OvertargetValidator extends AbstractOvertargetValidator {
  @Check
  public void checkFileNameAndTargetNamel(final TargetFile target) {
    ValidatorHelper helper = new ValidatorHelper();
    final String fileName = helper.getFileName(target);
    boolean _equals = fileName.equals(target.getName());
    boolean _not = (!_equals);
    if (_not) {
      this.warning("File name and model name are not the same!", target, target.eContainingFeature());
    }
  }
  
  @Check
  public void checkIfWorkingSysUsed(final TargetModelImpl target) {
    String workingSys = target.getWks();
    if ((workingSys != null)) {
      this.warning("Please use WindowingSys instead of WorkingSys!", target, target.eContainingFeature());
    }
  }
}
