/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.generator;

import com.google.common.collect.Iterables;
import de.dlr.sc.overtarget.language.generator.GeneratorHelper;
import de.dlr.sc.overtarget.language.generator.OvertargetOutputConfigurationProvider;
import de.dlr.sc.overtarget.language.targetmodel.ExcludeLocation;
import de.dlr.sc.overtarget.language.targetmodel.RepositoryLocation;
import de.dlr.sc.overtarget.language.targetmodel.TargetFile;
import de.dlr.sc.overtarget.language.targetmodel.TargetModel;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;
import de.dlr.sc.overtarget.language.targetmodel.Unit;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Generates target files from tmodel files
 */
@SuppressWarnings("all")
public class OvertargetGenerator extends AbstractGenerator {
  private final static String DEFAULT_JRE_CONTAINER = "org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/";
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<TargetModel> _filter = Iterables.<TargetModel>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), TargetModel.class);
    for (final TargetModel model : _filter) {
      String _name = model.getName();
      String _plus = (_name + ".target");
      fsa.generateFile(_plus, OvertargetOutputConfigurationProvider.GENERATOR_OUTPUT_ID_OVERTARGET, this.compile(model));
    }
  }
  
  /**
   * Compiles the target model into a file
   */
  public CharSequence compile(final TargetModel target) {
    CharSequence _xblockexpression = null;
    {
      this.arragenceProperties(target);
      this.addInheritedRepositories(target);
      _xblockexpression = this.printModel(target);
    }
    return _xblockexpression;
  }
  
  /**
   * If properties are defined use them, if not, gets the properties from the super target model
   */
  public void arragenceProperties(final TargetModel target) {
    target.setOs(GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__OS).toString());
    target.setWs(GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__WS).toString());
    target.setArch(GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__ARCH).toString());
    target.setLoc(GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__LOC).toString());
    target.setTargetJre(GeneratorHelper.getAttribute(target, TargetmodelPackage.Literals.TARGET_MODEL__TARGET_JRE).toString());
  }
  
  /**
   * Checks if a location is not excluded by the target model and if so,
   * adds it to the list of locations
   */
  public boolean addIfNotExcluded(final TargetModel model, final ArrayList<RepositoryLocation> locations, final RepositoryLocation location) {
    boolean _xblockexpression = false;
    {
      ExcludeLocation repo = GeneratorHelper.isRepositoryExcluded(model.getExcludedLocations(), location);
      boolean _xifexpression = false;
      if ((repo != null)) {
        boolean _xifexpression_1 = false;
        int _length = ((Object[])Conversions.unwrapArray(repo.getUnits(), Object.class)).length;
        boolean _notEquals = (_length != 0);
        if (_notEquals) {
          boolean _xblockexpression_1 = false;
          {
            GeneratorHelper.removeAllUnits(location, repo.getUnits());
            boolean _xifexpression_2 = false;
            int _length_1 = ((Object[])Conversions.unwrapArray(location.getUnits(), Object.class)).length;
            boolean _greaterThan = (_length_1 > 0);
            if (_greaterThan) {
              _xifexpression_2 = GeneratorHelper.addLocationWithMerge(locations, location);
            }
            _xblockexpression_1 = _xifexpression_2;
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xifexpression = _xifexpression_1;
      } else {
        _xifexpression = GeneratorHelper.addLocationWithMerge(locations, location);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Adds all inherited locations to the target model
   */
  public void addInheritedRepositories(final TargetModel target) {
    ArrayList<RepositoryLocation> locations = new ArrayList<RepositoryLocation>();
    ArrayList<TargetFile> targetfiles = new ArrayList<TargetFile>();
    GeneratorHelper.getAllParentTargetFiles(target, targetfiles);
    for (final TargetFile tm : targetfiles) {
      EList<RepositoryLocation> _repositoryLocations = tm.getRepositoryLocations();
      for (final RepositoryLocation rl : _repositoryLocations) {
        this.addIfNotExcluded(target, locations, rl);
      }
    }
    for (final RepositoryLocation rl_1 : locations) {
      GeneratorHelper.addLocationWithMerge(target.getRepositoryLocations(), rl_1);
    }
  }
  
  /**
   * replaces "newest" with "0.0.0"
   */
  public String printVersion(final Unit unit) {
    boolean _equals = unit.getVers().equals("newest");
    if (_equals) {
      return "0.0.0";
    }
    return unit.getVers();
  }
  
  /**
   * prints the target model
   */
  public CharSequence printModel(final TargetModel target) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<?pde version=\"3.8\"?><target name=\"");
    String _name = target.getName();
    _builder.append(_name, "\t\t");
    _builder.append("\" sequenceNumber=\"1\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<locations>");
    _builder.newLine();
    {
      EList<RepositoryLocation> _repositoryLocations = target.getRepositoryLocations();
      for(final RepositoryLocation repositoryLocation : _repositoryLocations) {
        _builder.append("\t\t");
        _builder.append("<location includeAllPlatforms=\"false\" includeConfigurePhase=\"true\" includeMode=\"planner\" includeSource=\"true\" type=\"InstallableUnit\">");
        _builder.newLine();
        {
          EList<Unit> _units = repositoryLocation.getUnits();
          for(final Unit unit : _units) {
            _builder.append("\t\t");
            _builder.append("<unit id=\"");
            String _source = unit.getSource();
            _builder.append(_source, "\t\t");
            _builder.append("\" version=\"");
            String _printVersion = this.printVersion(unit);
            _builder.append(_printVersion, "\t\t");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("<repository location=\"");
        String _urlAsString = GeneratorHelper.getUrlAsString(repositoryLocation.getUrl(), target);
        _builder.append(_urlAsString, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("</location>              ");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("</locations>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<environment>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<os>");
    String _os = target.getOs();
    _builder.append(_os, "\t\t");
    _builder.append("</os>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<ws>");
    String _ws = target.getWs();
    _builder.append(_ws, "\t\t");
    _builder.append("</ws>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<arch>");
    String _arch = target.getArch();
    _builder.append(_arch, "\t\t");
    _builder.append("</arch>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<nl>");
    String _loc = target.getLoc();
    _builder.append(_loc, "\t\t");
    _builder.append("</nl> ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</environment>");
    _builder.newLine();
    _builder.append("\t\t");
    String _jRE = this.getJRE(target);
    _builder.append(_jRE, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</target>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * prints the targetJRE
   */
  public String getJRE(final TargetModel target) {
    String _targetJre = target.getTargetJre();
    boolean _tripleEquals = (_targetJre == null);
    if (_tripleEquals) {
      return "";
    } else {
      String _targetJre_1 = target.getTargetJre();
      String _plus = ((("<targetJRE path=" + "\"") + OvertargetGenerator.DEFAULT_JRE_CONTAINER) + _targetJre_1);
      return (_plus + "\"/>");
    }
  }
}
