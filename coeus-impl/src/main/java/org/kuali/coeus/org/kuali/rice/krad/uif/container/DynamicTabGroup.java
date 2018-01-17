/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.org.kuali.rice.krad.uif.container;

import java.util.Map;

import org.kuali.rice.krad.uif.container.Group;

/**
 * Dynamic Tab Group container
 *
 */
public interface DynamicTabGroup extends Group {

	/**
	 * Property name of a collection on that model that will be iterated over to create each
	 * individual tab in the tab group.
	 * @param tabCollectionPropertyName
	 */
	void setTabCollectionPropertyName(String tabCollectionPropertyName);
	
	/**
	 * A group prototype that will be copied for each item found in the <code>tabCollectionPropertyName</code>.
	 * @param groupPrototype
	 */
	void setGroupPrototype(Group groupPrototype);
	
	/**
	 * Map of SpEL context variable names and associated property names found on items within <code>tabCollectionPropertyName</code>
	 * that will be pushed into each group's SpEL context.
	 * @param expressionProperties
	 */
	void setExpressionProperties(Map<String, String> expressionProperties);
	
	/**
	 * Property name on items found within <code>tabCollectionPropertyName</code> whose value will be used to suffix the id's
	 * in each copy of the <code>groupPrototype</code>
	 * @param idSuffixPropertyName
	 */
	void setIdSuffixPropertyName(String idSuffixPropertyName);
	
	/**
	 * When set to true will set the prototype group's fieldBindingObjectPath to the path into the tab groups collection.
	 * @param setFieldBindingObjectPath
	 */
	void setSetFieldBindingObjectPath(Boolean setFieldBindingObjectPath);
	
	/**
	 * When set the dynamic tab group will attempt get a boolean value from the specified property on the form.
	 * This boolean value when true will cause lazy loading properties to be applied to each group in the tab group.
	 */
	void setApplyLazyLoadProperty(String applyLazyLoadProperty);
}
