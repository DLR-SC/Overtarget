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

class OvertargetXtextEditor extends XtextEditor {
	
	@Inject
	IResourceSetProvider resourceSetProvider;
	
	override init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		prepareUnitsLoading(input)
	}
	
	def prepareUnitsLoading(IEditorInput input) {
		val target = getModel(input)
		val unitManager = new UnitManager();
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
}