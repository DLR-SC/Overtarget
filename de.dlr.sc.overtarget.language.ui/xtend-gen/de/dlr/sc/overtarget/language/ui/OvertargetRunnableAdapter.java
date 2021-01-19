/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.ui;

import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

@SuppressWarnings("all")
public abstract class OvertargetRunnableAdapter implements ICoreRunnable, Runnable, IRunnableWithProgress {
  @Override
  public void run(final IProgressMonitor monitor) {
    this.doRun(monitor);
  }
  
  @Override
  public void run() {
    this.doRun(null);
  }
  
  public abstract void doRun(final IProgressMonitor monitor);
}
