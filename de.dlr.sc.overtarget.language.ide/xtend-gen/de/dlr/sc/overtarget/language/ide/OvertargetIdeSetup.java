/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ide;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class OvertargetIdeSetup /* implements OvertargetStandaloneSetup  */{
  @Override
  public Injector createInjector() {
    throw new Error("Unresolved compilation problems:"
      + "\nOvertargetRuntimeModule cannot be resolved.");
  }
}
