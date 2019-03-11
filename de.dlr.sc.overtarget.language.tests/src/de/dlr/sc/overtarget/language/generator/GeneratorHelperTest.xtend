/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.generator

import com.google.inject.Inject
import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import de.dlr.sc.overtarget.language.tests.OvertargetInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(OvertargetInjectorProvider)
class GeneratorHelperTest {

	@Inject extension ParseHelper<TargetModel>
	TargetFile targetFile;
	
	@Before
	def void setUp() {
		targetFile = parse('''       TargetLibrary target   { 
		
		Variable testVar1 = "value1"
		Variable testVar2 = "value2"
		Variable testVar3 = "value3"
		Variable testVar4 = "value4"
		Variable testVar5 = "value5"
		
		Override testVar3 = "newValue6"
		Override testVar5 = "newValue7"
		
		
		RepositoryLocation repo0 url "testUrl" {  

		}  
		RepositoryLocation repo1 url "testUrl" + testVar1 {  

		}
		RepositoryLocation repo2 url testVar1{
			  
		}
		RepositoryLocation repo3 url testVar1 + "testUrl2"  {
			
		}
		RepositoryLocation repo4 url "testUrl3" + "testUrl4"{
			
		}
		RepositoryLocation repo5 url testVar1 + testVar2{
			
		}
		RepositoryLocation repo6 url testVar3{
			
		}
		RepositoryLocation repo7 url "testUrl4" + testVar4 + testVar5{
			
		}
		RepositoryLocation repo8 url "testUrl5" + testVar1 + testVar2{
			
		}
		RepositoryLocation repo9 url testVar3 + testVar5{
			
		}
	      ''')
	}
	
	@Test
	def void testGetUrlAsString(){
		val urlNoVariables = targetFile.repositoryLocations.get(0).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlNoVariables, targetFile), "testUrl");
		
		val urlConcatinatedWithVariable = targetFile.repositoryLocations.get(1).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlConcatinatedWithVariable, targetFile), "testUrlvalue1");
		
		val urlNoString = targetFile.repositoryLocations.get(2).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlNoString, targetFile), "value1");
		
		val urlConcatinatedWithVariableReverse = targetFile.repositoryLocations.get(3).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlConcatinatedWithVariableReverse, targetFile), "value1testUrl2");
		
		val urlDoubleString = targetFile.repositoryLocations.get(4).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlDoubleString, targetFile), "testUrl3testUrl4");
		
		val urlDoubleVariables = targetFile.repositoryLocations.get(5).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlDoubleVariables, targetFile), "value1value2");
		
		val urlOverrideVariable = targetFile.repositoryLocations.get(6).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlOverrideVariable, targetFile), "newValue6");
		
		val urlTestAll = targetFile.repositoryLocations.get(7).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlTestAll, targetFile), "testUrl4value4newValue7");
		
		val urlStringDoubleVariable = targetFile.repositoryLocations.get(8).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlStringDoubleVariable, targetFile), "testUrl5value1value2");
		
		val urlTwoOverwrittenVariable = targetFile.repositoryLocations.get(9).url;
		Assert.assertEquals(GeneratorHelper.getUrlAsString(urlTwoOverwrittenVariable, targetFile), "newValue6newValue7");
	}
}

