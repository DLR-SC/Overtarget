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


import java.io.File;
import java.net.URI;
import java.nio.file.Path;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.pde.core.target.LoadTargetDefinitionJob;
import org.eclipse.pde.internal.core.PDECore;



public class ResolveTargetHandler extends AbstractHandler implements IHandler {

	private ITargetDefinition fTarget;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		if (editorPart instanceof ITextEditor) {
			IEditorInput input = null;
			if (editorPart != null) {
				input = editorPart.getEditorInput();
			}
			
			IFile file = ((FileEditorInput) input).getFile();
			IPath path = file.getFullPath().removeFileExtension().addFileExtension("target");


			IWorkspace workspace = ResourcesPlugin.getWorkspace();	
			IFile targetFile = workspace.getRoot().getFile(path);
			
			if (targetFile.exists()) {
				ITargetPlatformService service = getTargetPlatformService();
				org.eclipse.pde.core.target.ITargetHandle fileHandle = service.getTarget(targetFile);
				ITargetDefinition target = null;
				try {
					target = fileHandle.getTargetDefinition();
				} catch (CoreException e1) {
					e1.printStackTrace();
				}
				LoadTargetDefinitionJob.load(target);
			}
		
		}
		
		return null;
	}

	private ITargetPlatformService getTargetPlatformService() {
		@SuppressWarnings("restriction")
		ITargetPlatformService service = PDECore.getDefault().acquireService(ITargetPlatformService.class);
		
		return service;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}