/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.overtarget.language.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.Unit;

/**
 * Class to update versions
 * 
 * @author bell_er
 *
 */
public class VersionHandlerHelper {
	private static final int TOTAL_WORK_TIME = 100;
	

	/**
	* Simple constructor
	* 
	* @author  Bell_er
	*/
	private VersionHandlerHelper() {
	}
	
	/**
	 * @param targetFile
	 *            the target file to be updated
	 * @param selectedLines
	 *            the lines selected by the user
	 * @param queryManager
	 * 			the queryManager
	 * @param monitor
	 * 			the monitor
	 * @return units
	 */
	public static ArrayList<Unit> getNewestUnits(TargetFile targetFile, String selectedLines, QueryManager queryManager, IProgressMonitor monitor) {
		ArrayList<Unit> units = new ArrayList<>();
		List<String> unitNames = getUnitNames(selectedLines);
		int unitcount = unitNames.size();
		int worked = 0;
		int timeSpanNeededPerWork = TOTAL_WORK_TIME / unitcount;
		for (String unit : unitNames) {
			for (RepositoryLocation rl : targetFile.getRepositoryLocations()) {
				ArrayList<Unit> offeredUnits = null;
				for (Unit repositoryUnit : rl.getUnits()) {
					if (unit.equals(repositoryUnit.getSource().toString())) {
						if (!"newest".equals(repositoryUnit.getVers())) {
							if (offeredUnits == null) {
								offeredUnits = queryManager.getUnits(repositoryUnit);
							}
							for (Unit ir : offeredUnits) {
								if (ir.getSource().equals(repositoryUnit.getSource())) {
									units.add(ir);
								}
							}
						}
					}
				}
				
				monitor.worked(worked + timeSpanNeededPerWork / targetFile.getRepositoryLocations().size());
			}
			monitor.worked(worked + timeSpanNeededPerWork);
			
		}
		return units;
	}


	/**
	 * @param selectedLines
	 *            the lines selected by the user
	 * @return a list of units included in the selected lines
	 */
	public static List<String> getUnitNames(String selectedLines) {
		ArrayList<String> units = new ArrayList<>();
		String trimmed = selectedLines.substring(selectedLines.indexOf("Unit"), selectedLines.indexOf("document"));
		String[] tokens = trimmed.split("\\n");

		for (String s : tokens) {
			String	newToken = s.trim();
			if (newToken.startsWith(Unit.class.getSimpleName())) {
				newToken = newToken.substring(newToken.indexOf(" ") + 1, newToken.indexOf("version"));
				newToken = newToken.trim();
				units.add(newToken);
			}
		}
		return units;
	}
	
	/**
	 * @param target
	 *            the target file to be updated
	 * @param units a list of units which contains the newest versions
	 */
	public static void updateVersions(TargetFile target, List<Unit> units) {
		for (RepositoryLocation rl : target.getRepositoryLocations()) {
			for (Unit repositoryUnit : rl.getUnits()) {
				for (Unit queriedUnit: units) {
					if (repositoryUnit.getSource().equals(queriedUnit.getSource())) {
						repositoryUnit.setVers(queriedUnit.getVers());
					}
				}
			}
		}
	}
}