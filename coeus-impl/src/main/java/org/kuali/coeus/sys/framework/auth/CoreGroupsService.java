/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.framework.auth;

import java.util.List;

public interface CoreGroupsService {

	public static final String ACTIVE_FIELD_ID = "ACTIVE";
	public static final String UNIT_NUMBER_FIELD_ID = "UNIT_NUMBER";

	public String getCategoriesApiUrl();

	public String getGroupsApiUrl();

	public List<GroupDto> getAllGroups();

	public String getUnitNumberForGroup(GroupDto group);

}
