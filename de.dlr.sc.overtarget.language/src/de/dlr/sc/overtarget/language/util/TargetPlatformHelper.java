/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.util;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.pde.core.target.LoadTargetDefinitionJob;
import org.eclipse.pde.internal.core.PDECore;

/**
 * Class to set target platforms from tmodel editor
 * 
 */

@SuppressWarnings("restriction")
public class TargetPlatformHelper {

	
	private TargetPlatformHelper() {
	}
	
	/**
	 * @param targetFile
	 *            the target file to be set
	*/
	
	public static void setAsTargetPlatform(IFile targetFile) {
		ITargetPlatformService service = getTargetPlatformService();
		org.eclipse.pde.core.target.ITargetHandle fileHandle = service.getTarget((IFile) targetFile);
		ITargetDefinition target = null;
		try {
			target = fileHandle.getTargetDefinition();
		} catch (CoreException e) {
			JOptionPane.showMessageDialog(null, "Could not get target definition!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
		}
		LoadTargetDefinitionJob.load(target);
	}
	
	private static ITargetPlatformService getTargetPlatformService() {
		ITargetPlatformService service = PDECore.getDefault().acquireService(ITargetPlatformService.class);
		
		return service;
	}
}