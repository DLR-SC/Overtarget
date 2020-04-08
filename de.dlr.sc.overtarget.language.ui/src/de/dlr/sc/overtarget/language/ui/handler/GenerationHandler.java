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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;
import com.google.inject.Provider;

import de.dlr.sc.overtarget.language.generator.OvertargetGenerator;
import de.dlr.sc.overtarget.language.ui.internal.LanguageActivator;

public class GenerationHandler extends AbstractHandler implements IHandler {

	public GenerationHandler() {
		setupInjector();
	}
	
	protected void setupInjector() {
		LanguageActivator.getInstance().getInjector(LanguageActivator.DE_DLR_SC_OVERTARGET_LANGUAGE_OVERTARGET).injectMembers(this);
	}
	
	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;
	
	@Inject
	private Provider<EclipseOutputConfigurationProvider> eclipseOutputConfigProvider;
	
	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (editor instanceof ITextEditor) {
			IEditorInput input = null;
			if (editor != null) {
				input = editor.getEditorInput();
			}
			
			IFile file = ((FileEditorInput) input).getFile();
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			IProject project = file.getProject();
			ResourceSet rs = resourceSetProvider.get(project);
			Resource r = rs.getResource(uri, true);

			final IGeneratorContext context = new IGeneratorContext() {
				
				@Override
				public CancelIndicator getCancelIndicator() {
					return null;
				}
			};
			
			final EclipseResourceFileSystemAccess2 fsa = fileSystemAccessProvider.get();
			fsa.setMonitor(new NullProgressMonitor());
			
			final EclipseOutputConfigurationProvider configProvider = eclipseOutputConfigProvider.get();
			String outputPath = configProvider.getPreferenceStoreAccess().getContextPreferenceStore(project).getString("outlet.de.dlr.sc.overtarget.output.directory");
			configProvider.getOutputConfigurations().iterator().next().setOutputDirectory(outputPath);
			fsa.setOutputPath(outputPath);
			fsa.setOutputPath("de.dlr.sc.overtarget.output", outputPath);
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