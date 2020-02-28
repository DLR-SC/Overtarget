/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package de.dlr.sc.overtarget.language.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

import de.dlr.sc.overtarget.language.ui.util.TargetPlatformHelper;

public class ResolveTargetHandler extends AbstractHandler implements IHandler {

	static String targetFileExtension = "target";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		if (editorPart instanceof ITextEditor) {
			IEditorInput input = null;
			if (editorPart != null) {
				input = editorPart.getEditorInput();
			}
			
			IFile file = ((FileEditorInput) input).getFile();
			IPath path = file.getFullPath().removeFileExtension().addFileExtension(targetFileExtension);

			IWorkspace workspace = ResourcesPlugin.getWorkspace();	
			IFile targetFile = workspace.getRoot().getFile(path);
			
			if (targetFile.exists()) {
				try {
					TargetPlatformHelper.setAsTargetPlatform(targetFile);
				} catch (CoreException e) {
					MessageBox errorMessage = new MessageBox(
							Display.getCurrent().getActiveShell(), 
							SWT.OK | SWT.ICON_ERROR);
					errorMessage.setText("Error");
					errorMessage.setMessage(file.getName() + " could not be set as active target.");
					errorMessage.open();
				}
			} else {
				MessageBox errorMessage = new MessageBox(
						Display.getCurrent().getActiveShell(), 
						SWT.OK | SWT.ICON_ERROR);
				errorMessage.setText("Target file not found");
				errorMessage.setMessage("Please check if the target file exists.");
				errorMessage.open();
			}
		}
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}