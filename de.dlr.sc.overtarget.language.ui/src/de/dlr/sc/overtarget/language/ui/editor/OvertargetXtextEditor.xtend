/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.ui.editor;

import org.eclipse.xtext.ui.editor.XtextEditor;
import de.dlr.sc.overtarget.language.ui.contentassist.UnitManager;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.IEditorSite;
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import com.google.inject.Inject
import org.eclipse.ui.IFileEditorInput
import org.eclipse.emf.common.util.URI
import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.XtextUIMessages
import org.eclipse.ui.texteditor.ResourceAction
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds
import org.eclipse.ui.texteditor.ITextEditorActionConstants
import org.eclipse.ui.texteditor.EditorMessages
import org.eclipse.ui.texteditor.ContentAssistAction
import org.eclipse.ui.texteditor.IAbstractTextEditorHelpContextIds

class OvertargetXtextEditor extends XtextEditor {
	
	@Inject
	IResourceSetProvider resourceSetProvider;
	
	override init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		prepareUnitsLoading(input)
	}
	
	def prepareUnitsLoading(IEditorInput input) {
		val target = getModel(input)
		val unitManager = UnitManager.instance;
		unitManager.loadUnits(target)
	}
	
	def getModel(IEditorInput input) {
		if (input instanceof IFileEditorInput) {
			val file = input.getFile();
			val uri = URI.createPlatformResourceURI(file.fullPath.toString(), true);
			val project = file.getProject();
			val rs = resourceSetProvider.get(project);
			val r = rs.getResource(uri, true);
			val target = r.contents.get(0) as TargetFile
			
			return target
		}
	}
	
//	override updateState(IEditorInput input) {
//		val document = document
//		var XtextResource xtextResource = document.readOnly(new IUnitOfWork<XtextResource, XtextResource>(){
//			override XtextResource exec(XtextResource state) throws Exception {
//				return state
//			}
//		})
//		val model = xtextResource.contents.get(0) as TargetFile
//		val unitManager = UnitManager.instance
//		unitManager.loadUnits(model)
// 		super.updateState(input)
//	}
	
	override createActions() {
		super.createActions
		val updateUnitManagerAction = new UpdateUnitManagerAction(XtextUIMessages.getResourceBundle(),
					"Update Unit Manager", this)
		updateUnitManagerAction.update
		updateUnitManagerAction.run
		setAction("Update Unit Manager", updateUnitManagerAction)
//		markAsStateDependentAction("Update Unit Manager", true);
		markAsContentDependentAction("Update Unit Manager", true);
		
		
	}
//	def getChangesInModel() {
//		val document = document
//		var XtextResource xtextResource = document.readOnly(new IUnitOfWork<XtextResource, XtextResource>(){
//			override XtextResource exec(XtextResource state) throws Exception {
//				return state
//			}
//		})
//		val model = xtextResource.contents.get(0) as TargetFile 
//		val reposLoc = model.repositoryLocations
//		return reposLoc
//	} 

}