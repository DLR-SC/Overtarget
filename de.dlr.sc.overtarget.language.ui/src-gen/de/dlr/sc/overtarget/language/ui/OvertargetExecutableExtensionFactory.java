/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.ui;

import com.google.inject.Injector;
import de.dlr.sc.overtarget.language.ui.internal.LanguageActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class OvertargetExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return LanguageActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return LanguageActivator.getInstance().getInjector(LanguageActivator.DE_DLR_SC_OVERTARGET_LANGUAGE_OVERTARGET);
	}
	
}
