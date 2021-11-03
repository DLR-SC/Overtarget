/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.dlr.sc.overtarget.language.OvertargetRuntimeModule;
import de.dlr.sc.overtarget.language.OvertargetStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class OvertargetIdeSetup extends OvertargetStandaloneSetup {
  @Override
  public Injector createInjector() {
    OvertargetRuntimeModule _overtargetRuntimeModule = new OvertargetRuntimeModule();
    OvertargetIdeModule _overtargetIdeModule = new OvertargetIdeModule();
    return Guice.createInjector(Modules2.mixin(_overtargetRuntimeModule, _overtargetIdeModule));
  }
}
