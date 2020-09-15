/**
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.dlr.sc.overtarget.language.targetmodel.provider;


import de.dlr.sc.overtarget.language.targetmodel.BaseModel;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelFactory;
import de.dlr.sc.overtarget.language.targetmodel.TargetmodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.dlr.sc.overtarget.language.targetmodel.BaseModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BaseModelItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addImportedModelsPropertyDescriptor(object);
			addOsPropertyDescriptor(object);
			addWsPropertyDescriptor(object);
			addArchPropertyDescriptor(object);
			addLocPropertyDescriptor(object);
			addTargetJrePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BaseModel_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BaseModel_name_feature", "_UI_BaseModel_type"),
				 TargetmodelPackage.Literals.BASE_MODEL__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Imported Models feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportedModelsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BaseModel_importedModels_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BaseModel_importedModels_feature", "_UI_BaseModel_type"),
				 TargetmodelPackage.Literals.BASE_MODEL__IMPORTED_MODELS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Os feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BaseModel_os_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BaseModel_os_feature", "_UI_BaseModel_type"),
				 TargetmodelPackage.Literals.BASE_MODEL__OS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ws feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BaseModel_ws_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BaseModel_ws_feature", "_UI_BaseModel_type"),
				 TargetmodelPackage.Literals.BASE_MODEL__WS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Arch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BaseModel_arch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BaseModel_arch_feature", "_UI_BaseModel_type"),
				 TargetmodelPackage.Literals.BASE_MODEL__ARCH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Loc feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLocPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BaseModel_loc_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BaseModel_loc_feature", "_UI_BaseModel_type"),
				 TargetmodelPackage.Literals.BASE_MODEL__LOC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Jre feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetJrePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BaseModel_targetJre_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BaseModel_targetJre_feature", "_UI_BaseModel_type"),
				 TargetmodelPackage.Literals.BASE_MODEL__TARGET_JRE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(TargetmodelPackage.Literals.BASE_MODEL__VARIABLES);
			childrenFeatures.add(TargetmodelPackage.Literals.BASE_MODEL__EXCLUDED_LOCATIONS);
			childrenFeatures.add(TargetmodelPackage.Literals.BASE_MODEL__REPOSITORY_LOCATIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns BaseModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BaseModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BaseModel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BaseModel_type") :
			getString("_UI_BaseModel_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(BaseModel.class)) {
			case TargetmodelPackage.BASE_MODEL__NAME:
			case TargetmodelPackage.BASE_MODEL__OS:
			case TargetmodelPackage.BASE_MODEL__WS:
			case TargetmodelPackage.BASE_MODEL__ARCH:
			case TargetmodelPackage.BASE_MODEL__LOC:
			case TargetmodelPackage.BASE_MODEL__TARGET_JRE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TargetmodelPackage.BASE_MODEL__VARIABLES:
			case TargetmodelPackage.BASE_MODEL__EXCLUDED_LOCATIONS:
			case TargetmodelPackage.BASE_MODEL__REPOSITORY_LOCATIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(TargetmodelPackage.Literals.BASE_MODEL__VARIABLES,
				 TargetmodelFactory.eINSTANCE.createVariableDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(TargetmodelPackage.Literals.BASE_MODEL__VARIABLES,
				 TargetmodelFactory.eINSTANCE.createAlreadyDeclaredVariable()));

		newChildDescriptors.add
			(createChildParameter
				(TargetmodelPackage.Literals.BASE_MODEL__VARIABLES,
				 TargetmodelFactory.eINSTANCE.createNewVariableDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(TargetmodelPackage.Literals.BASE_MODEL__EXCLUDED_LOCATIONS,
				 TargetmodelFactory.eINSTANCE.createExcludeLocation()));

		newChildDescriptors.add
			(createChildParameter
				(TargetmodelPackage.Literals.BASE_MODEL__REPOSITORY_LOCATIONS,
				 TargetmodelFactory.eINSTANCE.createRepositoryLocation()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OvertargetEditPlugin.INSTANCE;
	}

}
