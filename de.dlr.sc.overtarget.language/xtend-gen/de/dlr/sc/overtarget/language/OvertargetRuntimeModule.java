/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language;

import de.dlr.sc.overtarget.language.AbstractOvertargetRuntimeModule;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class OvertargetRuntimeModule extends AbstractOvertargetRuntimeModule {
  @Override
  public Object configure(final /* Binder */Object binder) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method configure(Binder) is undefined for the type AbstractOvertargetRuntimeModule"
      + "\nThe method or field IOutputConfigurationProvider is undefined"
      + "\nThe method or field Singleton is undefined"
      + "\nbind cannot be resolved"
      + "\nto cannot be resolved"
      + "\nin cannot be resolved");
  }
}
