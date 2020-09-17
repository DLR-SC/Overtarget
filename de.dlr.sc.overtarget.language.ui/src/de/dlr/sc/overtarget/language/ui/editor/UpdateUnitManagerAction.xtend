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
import de.dlr.sc.overtarget.language.targetmodel.TargetFile
import de.dlr.sc.overtarget.language.ui.contentassist.UnitManager
import org.eclipse.xtext.ui.editor.XtextEditor

class UpdateUnitManagerAction extends TextEditorAction {
		
	protected new(ResourceBundle bundle, String prefix, ITextEditor editor) {
		super(bundle, prefix, editor)
	}

	/**
	 * This method calls the UnitManager to load units 
	 * whenever there is a change in the editor
	 */
	override update() {
		super.update()
		val editor= getTextEditor();
		if (editor instanceof XtextEditor) {
			val input = editor.editorInput
			if (input instanceof IFileEditorInput) {
				val overtargetEditor = new OvertargetXtextEditor
				val document = overtargetEditor.getXtextDocument
				if (document !== null) {
					val target = document.contents.get(0) as TargetFile
					val unitManager = UnitManager.instance
					unitManager.loadUnits(target)
				}
			}
		}
	}
}