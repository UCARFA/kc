/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.framework.core.groups;

public class GroupsPushStatus {

	private int numberOfUnits;
	private int categoriesAdded;
	private int categoriesUpdated;
	private int groupsAdded;
	private int groupsUpdated;

	public int getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public int getCategoriesAdded() {
		return categoriesAdded;
	}

	public void setCategoriesAdded(int categoriesAdded) {
		this.categoriesAdded = categoriesAdded;
	}

	public int getCategoriesUpdated() {
		return categoriesUpdated;
	}

	public void setCategoriesUpdated(int categoriesUpdated) {
		this.categoriesUpdated = categoriesUpdated;
	}

	public int getGroupsAdded() {
		return groupsAdded;
	}

	public void setGroupsAdded(int groupsAdded) {
		this.groupsAdded = groupsAdded;
	}

	public int getGroupsUpdated() {
		return groupsUpdated;
	}

	public void setGroupsUpdated(int groupsUpdated) {
		this.groupsUpdated = groupsUpdated;
	}
}
