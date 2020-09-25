/**
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.util;

import java.util.ArrayList;
import java.util.Set;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;

@SuppressWarnings("all")
public class MockupQueryResult<T extends Object> extends ArrayList<T> implements IQueryResult<T> {
  @Override
  public T[] toArray(final Class<T> clazz) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Set<T> toSet() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Set<T> toUnmodifiableSet() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IQueryResult<T> query(final IQuery<T> query, final IProgressMonitor monitor) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
