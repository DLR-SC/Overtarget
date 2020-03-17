/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.generator.util;

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.generator.util.ReferenceTargetHelper;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OvertargetInjectorProvider.class)
@SuppressWarnings("all")
public class ReferenceTargetHelperTest {
  @Inject
  @Extension
  private ParseHelper<TargetModel> _parseHelper;
  
  private TargetModel testTarget;
  
  private final String targetName = "testTarget";
  
  @Before
  public void setUp() {
    try {
      TargetmodelPackage.eINSTANCE.eClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Target ");
      _builder.append(this.targetName);
      _builder.append(" {}");
      _builder.newLineIfNotEmpty();
      this.testTarget = this._parseHelper.parse(_builder);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGetModelToGenerate() {
  }
  
  @Test
  public void testDeleteRepositoryLocation() {
  }
  
  @Test
  public void testRenameTarget() {
    final String renamedTarget = ReferenceTargetHelper.renameTarget(this.testTarget);
    final String expectedRenamedTarget = "referenceTarget";
    Assert.assertEquals("The name of the renamed target is correct", expectedRenamedTarget, renamedTarget);
  }
  
  @Test
  public void testImportedModelIsProxy() {
  }
  
  @Test
  public void testParentIsProxy() {
  }
  
  @Test
  public void testGetTargetFile() {
  }
}
