/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * Class to help validation
 * 
 * @author bell_er
 *
 */
public class ValidatorHelper {
	
	/**
	 * @param eObject the object whose file name is required
	 * @return the file name
	 */
	public String getFileName(EObject eObject) {
		if (eObject != null && eObject.eResource() != null) {
			URI eResourceUri = eObject.eResource().getURI();
			if (eResourceUri != null) {
				return eResourceUri.trimFileExtension().lastSegment();
			} else {
				return noFile();
			}
		}
		return null;
	}
	
	/**
	 * Handling of no file
	 * @return simply returns null
	 */
	public String noFile() {
		return null;
	}
}
