/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.validation;

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider;
import de.dlr.sc.overtarget.language.validation.OvertargetValidator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OvertargetInjectorProvider.class)
@SuppressWarnings("all")
public class OvertargetValidatorTest {
  @Inject
  @Extension
  private ParseHelper<TargetModel> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testCheckFileNameAndTargetName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Target targetName {}");
      _builder.newLine();
      final String target = _builder.toString();
      this._validationTestHelper.assertWarning(this._parseHelper.parse(target), TargetmodelPackage.Literals.TARGET_MODEL, OvertargetValidator.FILE_NAME_LIKE_TARGET_NAME, "File name and tmodel name are not the same!");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCheckIfWorkingSysUsed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Target __synthetic0 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("WorkingSystem cocoa");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String workingSystemUsed = _builder.toString();
      this._validationTestHelper.assertWarning(this._parseHelper.parse(workingSystemUsed), 
        TargetmodelPackage.Literals.TARGET_MODEL, OvertargetValidator.DEPRECATED_WS_STATEMENT, "Please use WindowingSystem instead of WorkingSystem!");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCheckIfTmodelExtendsOwnTmodel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Target tmodel extends tmodel {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String tmodelExtendsOwnTmodel = _builder.toString();
      this._validationTestHelper.assertError(this._parseHelper.parse(tmodelExtendsOwnTmodel), TargetmodelPackage.Literals.TARGET_MODEL, OvertargetValidator.TMODEL_EXTENDS_OWN_TMODEL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
