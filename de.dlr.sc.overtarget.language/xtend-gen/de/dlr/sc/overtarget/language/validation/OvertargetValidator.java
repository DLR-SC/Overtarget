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
import de.dlr.sc.overtarget.language.validation.AbstractOvertargetValidator;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class OvertargetValidator extends AbstractOvertargetValidator {
  /* @Check
   */public Object checkFileNameAndTargetNamel(final TargetFile target) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getFileName(TargetFile) is undefined for the type ValidatorHelper"
      + "\nThe method warning(String, TargetFile, Object) is undefined"
      + "\nThe method or field eContainingFeature is undefined for the type TargetFile"
      + "\nequals cannot be resolved"
      + "\n! cannot be resolved");
  }
}
