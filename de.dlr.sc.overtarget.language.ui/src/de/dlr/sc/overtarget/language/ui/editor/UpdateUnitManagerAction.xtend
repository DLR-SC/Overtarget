/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.ui.editor

import org.eclipse.ui.texteditor.TextEditorAction
import org.eclipse.ui.texteditor.ITextEditor
import java.util.ResourceBundle
import org.eclipse.ui.IFileEditorInput
import org.eclipse.emf.common.util.URI
import com.google.inject.Inject
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import de.dlr.sc.overtarget.language.ui.contentassist.UnitManager
import org.eclipse.jface.text.ITextOperationTarget

class UpdateUnitManagerAction extends TextEditorAction {
	
	/** The text operation target */
	ITextOperationTarget fOperationTarget;
	
	protected new(ResourceBundle bundle, String prefix, ITextEditor editor) {
		super(bundle, prefix, editor)
	}
	
	@Inject
	IResourceSetProvider resourceSetProvider;
	
	override run() {
		super.run()
		if (fOperationTarget !== null) {
			val editor= getTextEditor();
			val input = editor.editorInput
			if (input instanceof IFileEditorInput) {
				val file = input.getFile();
				val uri = URI.createPlatformResourceURI(file.fullPath.toString(), true);
				val project = file.getProject();
				val rs = resourceSetProvider.get(project);
				val r = rs.getResource(uri, true);
				val target = r.contents.get(0) as TargetFile
				val unitManager = UnitManager.instance
				unitManager.loadUnits(target)
			}
		}
	}
	
}