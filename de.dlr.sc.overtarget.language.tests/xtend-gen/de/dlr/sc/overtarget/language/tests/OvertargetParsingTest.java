/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.tests;

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OvertargetInjectorProvider.class)
@SuppressWarnings("all")
public class OvertargetParsingTest {
  @Inject
  @Extension
  private /* ParseHelper<TargetModel> */Object _parseHelper;
  
  private /* TargetModel */Object baseModel;
  
  private /* TargetModel */Object oldVersionModel;
  
  private /* TargetModel */Object extendedModel;
  
  private /* TargetModel */Object extendedModelWithEnvironment;
  
  private /* TargetModel */Object importedModel;
  
  private CharSequence target;
  
  private CharSequence extendedTarget;
  
  private CharSequence extendedTargetWithEnvironment;
  
  @Before
  public void setUp() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest._parseHelper refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.oldVersionModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest._parseHelper refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.importedModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest._parseHelper refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.extendedModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest._parseHelper refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.extendedModelWithEnvironment refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest._parseHelper refers to the missing type TargetModel"
      + "\neResource cannot be resolved"
      + "\nresourceSet cannot be resolved");
  }
  
  @Test
  public void testName() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field OvertargetParsingTest._parseHelper refers to the missing type TargetModel"
      + "\nname cannot be resolved");
  }
  
  @Test
  public void testSuperName() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest._parseHelper refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\neResource cannot be resolved"
      + "\nresourceSet cannot be resolved"
      + "\nsuper cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  @Test
  public void testEnvironment() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest._parseHelper refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\neResource cannot be resolved"
      + "\nresourceSet cannot be resolved"
      + "\nsuper cannot be resolved"
      + "\nws cannot be resolved"
      + "\nws cannot be resolved"
      + "\nos cannot be resolved"
      + "\nos cannot be resolved"
      + "\nloc cannot be resolved"
      + "\nloc cannot be resolved"
      + "\narch cannot be resolved"
      + "\narch cannot be resolved"
      + "\ntargetJre cannot be resolved"
      + "\ntargetJre cannot be resolved"
      + "\nvariables cannot be resolved"
      + "\nvariables cannot be resolved"
      + "\nrepositoryLocations cannot be resolved"
      + "\nsize cannot be resolved"
      + "\nrepositoryLocations cannot be resolved"
      + "\nsize cannot be resolved");
  }
  
  @Test
  public void testExtendedModel() {
    throw new Error("Unresolved compilation problems:"
      + "\nOvertargetGenerator cannot be resolved."
      + "\nThe field OvertargetParsingTest.baseModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.extendedModel refers to the missing type TargetModel"
      + "\ncompile cannot be resolved"
      + "\ncompile cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\ntoString cannot be resolved");
  }
  
  @Test
  public void testExtendedModelWithEnvironment() {
    throw new Error("Unresolved compilation problems:"
      + "\nOvertargetGenerator cannot be resolved."
      + "\nThe field OvertargetParsingTest.extendedModelWithEnvironment refers to the missing type TargetModel"
      + "\ncompile cannot be resolved"
      + "\ntoString cannot be resolved");
  }
  
  @Test
  public void testUpdateVersions() {
    throw new Error("Unresolved compilation problems:"
      + "\nUnit cannot be resolved to a type."
      + "\nQueryManager cannot be resolved."
      + "\nThe method or field VersionHandlerHelper is undefined"
      + "\nThe method or field VersionHandlerHelper is undefined"
      + "\nThe method or field TargetmodelFactory is undefined"
      + "\nThe method or field TargetmodelFactory is undefined"
      + "\nThe method or field TargetmodelFactory is undefined"
      + "\nThe method or field TargetmodelFactory is undefined"
      + "\nThe method or field TargetmodelFactory is undefined"
      + "\nThe method getUnits(EObject) of type new Object(){} must override a superclass method."
      + "\nThe field OvertargetParsingTest.oldVersionModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.oldVersionModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.oldVersionModel refers to the missing type TargetModel"
      + "\nThe field OvertargetParsingTest.oldVersionModel refers to the missing type TargetModel"
      + "\ngetNewestUnits cannot be resolved"
      + "\nupdateVersions cannot be resolved"
      + "\nrepositoryLocations cannot be resolved"
      + "\nget cannot be resolved"
      + "\nunits cannot be resolved"
      + "\nsource cannot be resolved"
      + "\n== cannot be resolved"
      + "\nvers cannot be resolved"
      + "\nrepositoryLocations cannot be resolved"
      + "\nget cannot be resolved"
      + "\nunits cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nvers cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nvers cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nvers cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nvers cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateUnit cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nvers cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateUnit cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nvers cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateUnit cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nvers cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateUnit cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nvers cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateUnit cannot be resolved"
      + "\nsource cannot be resolved"
      + "\nvers cannot be resolved");
  }
}
