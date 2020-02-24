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

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import de.dlr.sc.overtarget.language.util.QueryManager;
import de.dlr.sc.overtarget.language.util.VersionHandlerHelper;

/**
 * Class for updating to the latest version
 * 
 * @author bell_er
 *
 */
public class VersionHandler extends AbstractHandler implements IHandler {
	private static final int TOTAL_WORK_TIME = 100;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String selectedLines = HandlerUtil.getCurrentSelection(event).toString();
		XtextEditor xTextEditor = EditorUtils.getActiveXtextEditor(event);
		Job job = new Job("Updating the versions") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ArrayList<Unit> units = new ArrayList<Unit>();
				monitor.beginTask("Updating the versions", TOTAL_WORK_TIME);
				xTextEditor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						TargetFile targetFile = (TargetFile) state.getContents().get(0);
						QueryManager queryManager = new QueryManager();
						units.addAll(VersionHandlerHelper.getNewestUnits(targetFile, selectedLines, queryManager, monitor));
					}
				});	
				
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						xTextEditor.getDocument().modify(new IUnitOfWork.Void<XtextResource>() {
							@Override
							public void process(XtextResource state) throws Exception {
								TargetFile targetFile = (TargetFile) state.getContents().get(0);
								VersionHandlerHelper.updateVersions(targetFile, units);						
							}
						});	
					}
				});
				return Status.OK_STATUS;
			}
		};
		job.setPriority(Job.SHORT);
		job.schedule();
		return null;
	}
}
