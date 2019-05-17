/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.tests

import com.google.inject.Inject
import de.dlr.sc.overtarget.language.generator.OvertargetGenerator
import de.dlr.sc.overtarget.language.targetmodel.TargetModel
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelFactory
import de.dlr.sc.overtarget.language.targetmodel.Unit
import de.dlr.sc.overtarget.language.util.QueryManager
import de.dlr.sc.overtarget.language.util.VersionHandlerHelper
import java.util.ArrayList
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(OvertargetInjectorProvider)

class OvertargetParsingTest {

	@Inject extension ParseHelper<TargetModel>
	TargetModel baseModel;
	TargetModel oldVersionModel;
	TargetModel extendedModel;
	TargetModel extendedModelWithEnvironment;
	CharSequence target;
	CharSequence extendedTarget; 
	CharSequence extendedTargetWithEnvironment; 
	
	@Before
	def void setUp() {
		baseModel = parse('''       Target baseTarget   { 
	 	OperatingSystem aix 
		WorkingSystem carbon   
		Architecture ia64_32  
		Locale ar_AE  
		TargetJRE JavaSE-1.1   
		RepositoryLocation V url "http://p2-mirror.sc.dlr.de/tools/orbit/downloads/drops/R20160520211859/repository/" {  
			Unit org.antlr.runtime version 4.3.0.v201502022030;
		}  
		RepositoryLocation A url "http://download.eclipse.org/technology/swtbot/releases/2.5.0"{  
			Unit org.eclipse.swtbot.eclipse.feature.group version 2.5.0.v201609021837 ;
			Unit org.eclipse.swtbot.eclipse.test.junit.feature.group version 2.5.0.201609021837;
			Unit org.eclipse.swtbot.feature.group version newest;
		}  
		RepositoryLocation B url "http://p2-mirror.sc.dlr.de/edapt/releases/12x/120/" {   
			Unit org.eclipse.emf.edapt.runtime.feature.feature.group version 1.2.0.201606020942;   
		}   
		RepositoryLocation C url "http://download.eclipse.org/nebula/releases/latest"{   
			Unit org.eclipse.nebula.widgets.gallery.feature.feature.group version 1.0.0.201706221838;   
		}  
		RepositoryLocation D url "http://p2-mirror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"{  
			Unit org.polarion.eclipse.team.svn.connector.svnkit18.feature.group version 6.0.4.I20161211-1700;   
		}
		RepositoryLocation E url "http://p2-mirror.sc.dlr.de/releases/oxygen/" {  
			Unit org.eclipse.emf.compare.ide.ui.feature.group version 3.3.2.201709090201;
			Unit org.eclipse.emf.sdk.feature.group version 2.13.0.v20170609-0928;
			Unit org.eclipse.emf.transaction.sdk.feature.group version 1.11.0.201706061339;
			Unit org.eclipse.equinox.executable.feature.group version 3.7.1.v20170811-1325;
			Unit org.eclipse.graphiti.sdk.feature.feature.group version 0.14.0.201705161212;
			Unit org.eclipse.jdt.source.feature.group version 3.13.1.v20170906-1700; 
			Unit org.eclipse.ocl.all.sdk.feature.group version 5.3.0.v20170607-1133;
			Unit org.eclipse.pde.source.feature.group version 3.13.1.v20170906-1700;
			Unit org.eclipse.platform.sdk version 4.7.1.M20170906-1700;
			Unit org.eclipse.xtext.sdk.feature.group version 2.12.0.v20170519-1412;
		}   
	 }       ''')
	 val resourceSet = baseModel.eResource.resourceSet;
	 
	 
	 oldVersionModel = parse('''		Target oldVersionTarget {
	 	OperatingSystem aix  
	 		 	WorkingSystem carbon   
	 		 	Architecture ia64_32  
	 		 	Locale ar_AE  
	 		 	TargetJRE JavaSE-1.1   
	 		 	
	 
	 	 	RepositoryLocation F url "http://p2-mirror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"{  
	 	 				Unit org.polarion.eclipse.team.svn.connector.svnkit18.feature.group version 1.1.1;   
	 	 			}
	 	 			RepositoryLocation G url "http://p2-mirror.sc.dlr.de/releases/oxygen/" {  
	 	 				Unit org.eclipse.emf.compare.ide.ui.feature.group version 1.1.1;
	 	 				Unit org.eclipse.emf.sdk.feature.group version 1.1.1;
	 	 				Unit org.eclipse.emf.transaction.sdk.feature.group version newest;;
	 	 				Unit org.eclipse.equinox.executable.feature.group version newest;;
	 	 			} 
	 	 			}
	 	''', resourceSet )
	 
	 
	 	parse('''		Target toBeImported {
	 	OperatingSystem aix  
	 	WorkingSystem carbon   
	 	Architecture ia64_32  
	 	Locale ar_AE  
	 	TargetJRE JavaSE-1.1   
	 	
	 	RepositoryLocation H url "http://p2-misdsdrror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"{  
	 		Unit org.polarion.llllllas.eclipse.team.svn.connector.svnkit18.feature.group version 6.0.4.I20161211-1700;   
	 	}
	 	RepositoryLocation I url "http://p2-mirror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"{
	 		Unit org.polarion.llllllas.eclipse.team.svn.connector.svnkit18.feature.group version 6.0.4.I20161211-1700;   
	 	} 
	 }
''', resourceSet )
extendedModel = parse('''    Target  extendedTarget  extends baseTarget {    
	 	Import toBeImported    
	 	ExcludeLocation baseTarget.V 
		}     
		ExcludeLocation baseTarget.E{
			Unit org.eclipse.equinox.executable.feature.group version 3.7.1.v20170811-1325;
			Unit org.eclipse.graphiti.sdk.feature.feature.group version 0.14.0.201705161212; 
			Unit org.eclipse.jdt.source.feature.group version 3.13.1.v20170906-1700;   
		}         
	}      
''', resourceSet )
extendedModelWithEnvironment = parse('''    Target  extendedTargetWithEnvironment  extends baseTarget {    
	 	Import toBeImported    
	 	OperatingSystem win32 
		WorkingSystem win32   
		Architecture x86_64  
		Locale de_DE  
		TargetJRE JavaSE-1.4   
	 	ExcludeLocation baseTarget.V {  
			Unit org.antlr.runtime version 4.3.0.v201502022030;
		}     
		ExcludeLocation baseTarget.E{
			Unit org.eclipse.equinox.executable.feature.group version 3.7.1.v20170811-1325;
			Unit org.eclipse.graphiti.sdk.feature.feature.group version 0.14.0.201705161212; 
			Unit org.eclipse.jdt.source.feature.group version 3.13.1.v20170906-1700;   
		}         
	}      
''', resourceSet )
target = '''<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde version="3.8"?><target name="baseTarget" sequenceNumber="1">
		<locations>
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.antlr.runtime" version="4.3.0.v201502022030"/>
		<repository location="http://p2-mirror.sc.dlr.de/tools/orbit/downloads/drops/R20160520211859/repository/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.swtbot.eclipse.feature.group" version="2.5.0.v201609021837"/>
		<unit id="org.eclipse.swtbot.eclipse.test.junit.feature.group" version="2.5.0.201609021837"/>
		<unit id="org.eclipse.swtbot.feature.group" version="0.0.0"/>
		<repository location="http://download.eclipse.org/technology/swtbot/releases/2.5.0"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.emf.edapt.runtime.feature.feature.group" version="1.2.0.201606020942"/>
		<repository location="http://p2-mirror.sc.dlr.de/edapt/releases/12x/120/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.nebula.widgets.gallery.feature.feature.group" version="1.0.0.201706221838"/>
		<repository location="http://download.eclipse.org/nebula/releases/latest"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.polarion.eclipse.team.svn.connector.svnkit18.feature.group" version="6.0.4.I20161211-1700"/>
		<repository location="http://p2-mirror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.emf.compare.ide.ui.feature.group" version="3.3.2.201709090201"/>
		<unit id="org.eclipse.emf.sdk.feature.group" version="2.13.0.v20170609-0928"/>
		<unit id="org.eclipse.emf.transaction.sdk.feature.group" version="1.11.0.201706061339"/>
		<unit id="org.eclipse.equinox.executable.feature.group" version="3.7.1.v20170811-1325"/>
		<unit id="org.eclipse.graphiti.sdk.feature.feature.group" version="0.14.0.201705161212"/>
		<unit id="org.eclipse.jdt.source.feature.group" version="3.13.1.v20170906-1700"/>
		<unit id="org.eclipse.ocl.all.sdk.feature.group" version="5.3.0.v20170607-1133"/>
		<unit id="org.eclipse.pde.source.feature.group" version="3.13.1.v20170906-1700"/>
		<unit id="org.eclipse.platform.sdk" version="4.7.1.M20170906-1700"/>
		<unit id="org.eclipse.xtext.sdk.feature.group" version="2.12.0.v20170519-1412"/>
		<repository location="http://p2-mirror.sc.dlr.de/releases/oxygen/"/>
		</location>              
		</locations>
		<environment>
		<os>aix</os>
		<ws>carbon</ws>
		<arch>ia64_32</arch>
		<nl>ar_AE</nl> 
		</environment>
		<targetJRE path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.1"/>
		</target>
	     '''
 	extendedTarget = '''<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde version="3.8"?><target name="extendedTarget" sequenceNumber="1">
		<locations>
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.swtbot.eclipse.feature.group" version="2.5.0.v201609021837"/>
		<unit id="org.eclipse.swtbot.eclipse.test.junit.feature.group" version="2.5.0.201609021837"/>
		<unit id="org.eclipse.swtbot.feature.group" version="0.0.0"/>
		<repository location="http://download.eclipse.org/technology/swtbot/releases/2.5.0"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.emf.edapt.runtime.feature.feature.group" version="1.2.0.201606020942"/>
		<repository location="http://p2-mirror.sc.dlr.de/edapt/releases/12x/120/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.nebula.widgets.gallery.feature.feature.group" version="1.0.0.201706221838"/>
		<repository location="http://download.eclipse.org/nebula/releases/latest"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.polarion.eclipse.team.svn.connector.svnkit18.feature.group" version="6.0.4.I20161211-1700"/>
		<repository location="http://p2-mirror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.emf.compare.ide.ui.feature.group" version="3.3.2.201709090201"/>
		<unit id="org.eclipse.emf.sdk.feature.group" version="2.13.0.v20170609-0928"/>
		<unit id="org.eclipse.emf.transaction.sdk.feature.group" version="1.11.0.201706061339"/>
		<unit id="org.eclipse.ocl.all.sdk.feature.group" version="5.3.0.v20170607-1133"/>
		<unit id="org.eclipse.pde.source.feature.group" version="3.13.1.v20170906-1700"/>
		<unit id="org.eclipse.platform.sdk" version="4.7.1.M20170906-1700"/>
		<unit id="org.eclipse.xtext.sdk.feature.group" version="2.12.0.v20170519-1412"/>
		<repository location="http://p2-mirror.sc.dlr.de/releases/oxygen/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.polarion.llllllas.eclipse.team.svn.connector.svnkit18.feature.group" version="6.0.4.I20161211-1700"/>
		<repository location="http://p2-misdsdrror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.polarion.llllllas.eclipse.team.svn.connector.svnkit18.feature.group" version="6.0.4.I20161211-1700"/>
		<repository location="http://p2-mirror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"/>
		</location>              
		</locations>
		<environment>
		<os>aix</os>
		<ws>carbon</ws>
		<arch>ia64_32</arch>
		<nl>ar_AE</nl> 
		</environment>
		<targetJRE path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.1"/>
		</target>
 	''' 
 	
 	
 	
 	extendedTargetWithEnvironment = '''<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde version="3.8"?><target name="extendedTargetWithEnvironment" sequenceNumber="1">
		<locations>
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.swtbot.eclipse.feature.group" version="2.5.0.v201609021837"/>
		<unit id="org.eclipse.swtbot.eclipse.test.junit.feature.group" version="2.5.0.201609021837"/>
		<unit id="org.eclipse.swtbot.feature.group" version="0.0.0"/>
		<repository location="http://download.eclipse.org/technology/swtbot/releases/2.5.0"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.emf.edapt.runtime.feature.feature.group" version="1.2.0.201606020942"/>
		<repository location="http://p2-mirror.sc.dlr.de/edapt/releases/12x/120/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.nebula.widgets.gallery.feature.feature.group" version="1.0.0.201706221838"/>
		<repository location="http://download.eclipse.org/nebula/releases/latest"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.polarion.eclipse.team.svn.connector.svnkit18.feature.group" version="6.0.4.I20161211-1700"/>
		<repository location="http://p2-mirror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.eclipse.emf.compare.ide.ui.feature.group" version="3.3.2.201709090201"/>
		<unit id="org.eclipse.emf.sdk.feature.group" version="2.13.0.v20170609-0928"/>
		<unit id="org.eclipse.emf.transaction.sdk.feature.group" version="1.11.0.201706061339"/>
		<unit id="org.eclipse.ocl.all.sdk.feature.group" version="5.3.0.v20170607-1133"/>
		<unit id="org.eclipse.pde.source.feature.group" version="3.13.1.v20170906-1700"/>
		<unit id="org.eclipse.platform.sdk" version="4.7.1.M20170906-1700"/>
		<unit id="org.eclipse.xtext.sdk.feature.group" version="2.12.0.v20170519-1412"/>
		<repository location="http://p2-mirror.sc.dlr.de/releases/oxygen/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.polarion.llllllas.eclipse.team.svn.connector.svnkit18.feature.group" version="6.0.4.I20161211-1700"/>
		<repository location="http://p2-misdsdrror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"/>
		</location>              
		<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
		<unit id="org.polarion.llllllas.eclipse.team.svn.connector.svnkit18.feature.group" version="6.0.4.I20161211-1700"/>
		<repository location="http://p2-mirror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/"/>
		</location>              
		</locations>
		<environment>
		<os>win32</os>
		<ws>win32</ws>
		<arch>x86_64</arch>
		<nl>de_DE</nl> 
		</environment>
		<targetJRE path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.4"/>
		</target>
	''' 
	}
		
	@Test
	def void testName() {
		val targetModel = '''        Target baseTarget {}      '''.parse
		Assert.assertEquals("baseTarget", targetModel.name)
	}

	@Test
	def void testSuperName() {
		val resourceSet = baseModel.eResource.resourceSet;
		val targetModel = parse('''        Target testTarget extends baseTarget {Import importedModel}      ''', resourceSet)

		val superTarget = targetModel.super;
		Assert.assertEquals(baseModel.name, superTarget.name)
	}
	
	@Test
	def void testEnvironment() {
		val resourceSet = baseModel.eResource.resourceSet;
		val targetModel = parse('''        Target testTarget extends baseTarget {Import importedModel}      ''', resourceSet)
		val superTarget = targetModel.super;
		Assert.assertEquals(baseModel.ws, superTarget.ws)
		Assert.assertEquals(baseModel.os, superTarget.os)
		Assert.assertEquals(baseModel.loc, superTarget.loc)
		Assert.assertEquals(baseModel.arch, superTarget.arch)
		Assert.assertEquals(baseModel.targetJre, superTarget.targetJre)
		Assert.assertEquals(baseModel.variables, superTarget.variables)
		Assert.assertEquals(baseModel.repositoryLocations.size, superTarget.repositoryLocations.size)
	}
	
	@Test
	def void testExtendedModel(){
		var generator = new OvertargetGenerator();
		var generatedTarget = generator.compile(baseModel)
		var generatedExtendedTarget = generator.compile(extendedModel)
		Assert.assertEquals(target.toString, generatedTarget.toString)
		Assert.assertEquals(extendedTarget.toString, generatedExtendedTarget.toString)
	}
	
	@Test
	def void testExtendedModelWithEnvironment(){
		var generator = new OvertargetGenerator();
		var generatedExtendedTargetWithEnvironment = generator.compile(extendedModelWithEnvironment)
		Assert.assertEquals(extendedTargetWithEnvironment.toString, generatedExtendedTargetWithEnvironment.toString)
	}	
	
	@Test
	def void testUpdateVersions(){
		var selectedLines = "TextSelection [offset: 123, startLine: 5, endLine: 16, length: 645, text: 	 TargetJRE JavaSE-1.1   
			 RepositoryLocation http://p2-mirror.sc.dlr.de/projects/subversive/download/eclipse/6.0/neon-site/{  
			 	 Unit org.polarion.eclipse.team.svn.connector.svnkit18.feature.group version 1.1.1;   
			 }
			 RepositoryLocation http://p2-mirror.sc.dlr.de/releases/oxygen/ {  
				 Unit org.eclipse.emf.compare.ide.ui.feature.group version 1.1.1;
			 	 Unit org.eclipse.emf.sdk.feature.group version 1.1.1;
			 	 Unit org.eclipse.emf.transaction.sdk.feature.group version newest;
			 	 Unit org.eclipse.equinox.executable.feature.group version newest;
			 } 
		}, document: org.eclipse.xtext.ui.editor.model.XtextDocument@1e060d4b]";
				
		var mockQueryManager = new QueryManager(){
			override getUnits(EObject model) {
				var resultsAsUnits = new ArrayList<Unit>;
				var unit = TargetmodelFactory.eINSTANCE.createUnit;
				unit.source = "org.polarion.eclipse.team.svn.connector.svnkit18.feature.group";
				unit.vers = "6.6.6";
				resultsAsUnits.add(unit);
				unit = TargetmodelFactory.eINSTANCE.createUnit;
				unit.source = "org.eclipse.emf.compare.ide.ui.feature.group";
				unit.vers = "6.6.6";
				resultsAsUnits.add(unit);
				unit = TargetmodelFactory.eINSTANCE.createUnit;
				unit.source = "org.eclipse.emf.sdk.feature.group";
				unit.vers = "6.6.6";
				resultsAsUnits.add(unit);
				unit = TargetmodelFactory.eINSTANCE.createUnit;
				unit.source = "org.eclipse.emf.transaction.sdk.feature.group";
				unit.vers = "newest";
				resultsAsUnits.add(unit);
				unit = TargetmodelFactory.eINSTANCE.createUnit;
				unit.source = "org.eclipse.equinox.executable.feature.group";
				unit.vers = "newest";
				resultsAsUnits.add(unit);
				return resultsAsUnits;
			}
			
		}
		
		var units = VersionHandlerHelper.getNewestUnits(oldVersionModel,selectedLines, mockQueryManager, new NullProgressMonitor());
		VersionHandlerHelper.updateVersions(oldVersionModel, units);
		for(unit : oldVersionModel.repositoryLocations.get(0).units ){
			if( unit.source == "org.polarion.eclipse.team.svn.connector.svnkit18.feature.group"){
				Assert.assertEquals("6.6.6", unit.vers);
			}
		}
		
		for(unit : oldVersionModel.repositoryLocations.get(1).units ){
			if( unit.source.equals("org.eclipse.emf.compare.ide.ui.feature.group")){
				Assert.assertEquals("6.6.6", unit.vers);
			}
			if( unit.source.equals("org.eclipse.emf.sdk.feature.group")){
				Assert.assertEquals("6.6.6", unit.vers);
			}
			if( unit.source.equals("org.eclipse.emf.transaction.sdk.feature.group")){
				Assert.assertEquals("newest", unit.vers);
			}
			if( unit.source.equals("org.eclipse.equinox.executable.feature.group")){
				Assert.assertEquals("newest", unit.vers);
			}
		}
	}	
}

