/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.generator;

import com.google.inject.Inject;
import de.dlr.sc.overtarget.language.generator.GeneratorHelper;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.UrlExpression;
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
public class GeneratorHelperTest {
  @Inject
  @Extension
  private ParseHelper<TargetModel> _parseHelper;
  
  private TargetFile targetFile;
  
  @Before
  public void setUp() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("       ");
      _builder.append("TargetLibrary target   { ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Variable testVar1 = \"value1\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Variable testVar2 = \"value2\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Variable testVar3 = \"value3\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Variable testVar4 = \"value4\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Variable testVar5 = \"value5\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Override testVar3 = \"newValue6\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Override testVar5 = \"newValue7\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo0 url \"testUrl\" {  ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}  ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo1 url \"testUrl\" + testVar1 {  ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo2 url testVar1{");
      _builder.newLine();
      _builder.append("\t\t\t  ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo3 url testVar1 + \"testUrl2\"  {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo4 url \"testUrl3\" + \"testUrl4\"{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo5 url testVar1 + testVar2{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo6 url testVar3{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo7 url \"testUrl4\" + testVar4 + testVar5{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo8 url \"testUrl5\" + testVar1 + testVar2{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RepositoryLocation repo9 url testVar3 + testVar5{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      this.targetFile = this._parseHelper.parse(_builder);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGetUrlAsString() {
    final UrlExpression urlNoVariables = this.targetFile.getRepositoryLocations().get(0).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlNoVariables, this.targetFile), "testUrl");
    final UrlExpression urlConcatinatedWithVariable = this.targetFile.getRepositoryLocations().get(1).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlConcatinatedWithVariable, this.targetFile), "testUrlvalue1");
    final UrlExpression urlNoString = this.targetFile.getRepositoryLocations().get(2).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlNoString, this.targetFile), "value1");
    final UrlExpression urlConcatinatedWithVariableReverse = this.targetFile.getRepositoryLocations().get(3).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlConcatinatedWithVariableReverse, this.targetFile), "value1testUrl2");
    final UrlExpression urlDoubleString = this.targetFile.getRepositoryLocations().get(4).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlDoubleString, this.targetFile), "testUrl3testUrl4");
    final UrlExpression urlDoubleVariables = this.targetFile.getRepositoryLocations().get(5).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlDoubleVariables, this.targetFile), "value1value2");
    final UrlExpression urlOverrideVariable = this.targetFile.getRepositoryLocations().get(6).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlOverrideVariable, this.targetFile), "newValue6");
    final UrlExpression urlTestAll = this.targetFile.getRepositoryLocations().get(7).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlTestAll, this.targetFile), "testUrl4value4newValue7");
    final UrlExpression urlStringDoubleVariable = this.targetFile.getRepositoryLocations().get(8).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlStringDoubleVariable, this.targetFile), "testUrl5value1value2");
    final UrlExpression urlTwoOverwrittenVariable = this.targetFile.getRepositoryLocations().get(9).getUrl();
    Assert.assertEquals(GeneratorHelper.getUrlAsString(urlTwoOverwrittenVariable, this.targetFile), "newValue6newValue7");
  }
}
