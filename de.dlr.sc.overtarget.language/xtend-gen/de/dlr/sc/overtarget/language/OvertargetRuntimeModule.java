/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language;

import com.google.inject.Binder;
import com.google.inject.Singleton;
import de.dlr.sc.overtarget.language.generator.OvertargetOutputConfigurationProvider;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class OvertargetRuntimeModule extends AbstractOvertargetRuntimeModule {
  @Override
  public void configure(final Binder binder) {
    super.configure(binder);
    binder.<IOutputConfigurationProvider>bind(IOutputConfigurationProvider.class).to(OvertargetOutputConfigurationProvider.class).in(Singleton.class);
  }
}
