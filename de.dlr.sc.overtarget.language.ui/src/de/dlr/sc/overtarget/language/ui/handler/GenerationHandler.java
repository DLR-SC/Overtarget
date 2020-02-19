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

import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;
import com.google.inject.Provider;

import de.dlr.sc.overtarget.language.generator.OvertargetGenerator;
import de.dlr.sc.overtarget.language.generator.OvertargetOutputConfigurationProvider;
import de.dlr.sc.overtarget.language.ui.internal.LanguageActivator;

public class GenerationHandler extends AbstractHandler implements IHandler {

	public GenerationHandler() {
		setupInjector();
	}
	
	protected void setupInjector() {
		LanguageActivator.getInstance().getInjector(LanguageActivator.DE_DLR_SC_OVERTARGET_LANGUAGE_OVERTARGET).injectMembers(this);
		System.out.println("");
	}
	
	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;
	
	@Inject
	IResourceDescriptions resourceDescriptions;

	@Inject
	IResourceSetProvider resourceSetProvider;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (editor instanceof ITextEditor) {
			IEditorInput input = 
				editor == null ? null : editor.getEditorInput();
			IFile file = input instanceof FileEditorInput 
				? ((FileEditorInput) input).getFile()
					: null;
			
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

			ResourceSet rs = new ResourceSetImpl();
			Resource r = rs.getResource(uri, true);
	
			final IGeneratorContext context = new IGeneratorContext() {
				
				@Override
				public CancelIndicator getCancelIndicator() {
					return null;
				}
			};
			
			final EclipseResourceFileSystemAccess2 fsa = fileSystemAccessProvider.get();
			fsa.setMonitor(new NullProgressMonitor());
			
			Set<OutputConfiguration> overtargetConfigurations = new OvertargetOutputConfigurationProvider().getOutputConfigurations();
			fsa.getOutputConfigurations().put(OvertargetOutputConfigurationProvider.GENERATOR_OUTPUT_ID_OVERTARGET, overtargetConfigurations.iterator().next());
			
			
			fsa.setProject(file.getProject());
			
			
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