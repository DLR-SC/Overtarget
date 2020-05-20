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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

import de.dlr.sc.overtarget.language.generator.OvertargetGenerator;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetLibrary;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.ui.internal.LanguageActivator;
import de.dlr.sc.overtarget.language.util.TargetPlatformHelper;

public class TargetActivationHandler extends AbstractHandler implements IHandler {

	public static final String OUTPUT_DIRECTORY_PREFERENCE_KEY = "outlet.de.dlr.sc.overtarget.output.directory";

	public TargetActivationHandler() {
		setupInjector();
	}

	protected void setupInjector() {
		LanguageActivator.getInstance().getInjector(LanguageActivator.DE_DLR_SC_OVERTARGET_LANGUAGE_OVERTARGET).injectMembers(this);
	}

	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	@Inject
	private Provider<EclipseOutputConfigurationProvider> eclipseOutputConfigProvider;
	
	@Inject 
	OvertargetGrammarAccess grammarAccess;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		if (editorPart instanceof ITextEditor) {
			IEditorInput input = null;
			if (editorPart != null) {
				input = editorPart.getEditorInput();
			}

			IFile file = ((FileEditorInput) input).getFile();
			String targetName = file.getName().replace(".tmodel", OvertargetGenerator.TARGET_FILE_EXTENSION);
			IProject project = file.getProject();
			String outputConfig = getOutputConfigurations(project);
			IFile targetFile;
			String outputPath = outputConfig.replace(".", "");
			
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			ResourceSet rs = resourceSetProvider.get(project);
			Resource r = rs.getResource(uri, true);
			
			TargetFile target = (TargetFile) r.getContents().get(0);
			
			if (outputPath.equals("/")) {
				targetFile = project.getFile("/" + targetName);
			} else {
				String targetPath = outputPath + "/" + targetName;
				targetFile = project.getFile(targetPath);
			}
			if (target instanceof TargetModel && targetFile.exists()) {
				try {
					TargetPlatformHelper targetPlatHelper = new TargetPlatformHelper();
					targetPlatHelper.setAsActiveTarget(targetFile);
				} catch (CoreException e) {
					MessageBox errorMessage = new MessageBox(
							Display.getCurrent().getActiveShell(), 
							SWT.OK | SWT.ICON_ERROR);
					errorMessage.setText("Error");
					errorMessage.setMessage(file.getName() + " could not be set as active target.");
					errorMessage.open();
				}
			} else if (target instanceof TargetLibrary) {
				MessageBox errorMessage = new MessageBox(
						Display.getCurrent().getActiveShell(), 
						SWT.OK | SWT.ICON_ERROR);
				errorMessage.setText("Error");
				errorMessage.setMessage("A TargetLibrary cannot be set as active target.");
				errorMessage.open();
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

	public String getOutputConfigurations(IProject project) {
		final EclipseOutputConfigurationProvider configProvider = eclipseOutputConfigProvider.get();
		String configValue = configProvider.getPreferenceStoreAccess().getContextPreferenceStore(project).getString(OUTPUT_DIRECTORY_PREFERENCE_KEY);
		return configValue;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}