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
import org.eclipse.xtext.ui.XtextUIMessages
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.utils.EditorUtils

class OvertargetXtextEditor extends XtextEditor {
	
	@Inject
	IResourceSetProvider resourceSetProvider;
	
	override init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		prepareUnitsLoading(input)
	}
	
	def prepareUnitsLoading(IEditorInput input) {
		val target = getTargetFile(input)
		if (target !== null) {
			val unitManager = UnitManager.instance;
			unitManager.loadUnits(target)
		} else return
	}
	
	/**
	 * This method tries to get the targetFile of the given input
	 * 
	 * @param input	the editor input
	 * @return		<code>targetFile</code> if the input contains a targetFile <br>
	 * 				<code>null</code> if the input does not contain a targetFile
	 */
	def getTargetFile(IEditorInput input) {
		if (input instanceof IFileEditorInput) {
			val file = input.getFile();
			val uri = URI.createPlatformResourceURI(file.fullPath.toString(), true);
			val project = file.getProject();
			val rs = resourceSetProvider.get(project);
			val r = rs.getResource(uri, true);
			if (!r.contents.empty) {
				val targetFile = r.contents.get(0) as TargetFile
				return targetFile
			} else return null
		}
	}
	
	def getXtextDocument() {
		if (EditorUtils.activeXtextEditor !== null) {
			var xtextdocument = EditorUtils.getActiveXtextEditor().getDocument() 
			xtextdocument.readOnly(new IUnitOfWork<XtextResource, XtextResource>() {
				override XtextResource exec(XtextResource state) throws Exception {
				return state 
			}})
		}
	}
	
	override createActions() {
		super.createActions
		val updateUnitManagerAction = new UpdateUnitManagerAction(XtextUIMessages.getResourceBundle(),
					"Update Unit Manager", this)
		setAction("Update Unit Manager", updateUnitManagerAction)
		markAsContentDependentAction("Update Unit Manager", true);
	}
}