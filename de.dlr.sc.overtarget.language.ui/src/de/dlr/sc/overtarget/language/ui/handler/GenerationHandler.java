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

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;

import de.dlr.sc.overtarget.language.generator.OvertargetGenerator;

public class GenerationHandler extends AbstractHandler implements IHandler {

//	@Inject
//	private OvertargetGenerator generator;

	@Inject
	IResourceDescriptions resourceDescriptions;

	@Inject
	IResourceSetProvider resourceSetProvider;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IEditorPart editor = HandlerUtil.getActiveEditor(event);
//		ITextEditor textEditor = null;
		if (editor instanceof ITextEditor) {
			IEditorInput input = 
				editor == null ? null : editor.getEditorInput();
			IPath path = input instanceof FileEditorInput 
				? ((FileEditorInput)input).getFile().getFullPath()
					: null;
			
			URI uri = URI.createPlatformResourceURI(path.toString(), true);

			ResourceSet rs = new ResourceSetImpl();
			Resource r = rs.getResource(uri, true);
	
			final IGeneratorContext context = new IGeneratorContext() {
				
				@Override
				public CancelIndicator getCancelIndicator() {
					// TODO Auto-generated method stub
					return null;
				}
			};
			final EclipseResourceFileSystemAccess2 fsa = new EclipseResourceFileSystemAccess2();
			
			OvertargetGenerator generator = new OvertargetGenerator();
			generator.doGenerate(r, fsa, context);
		}

		return null;
 	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}