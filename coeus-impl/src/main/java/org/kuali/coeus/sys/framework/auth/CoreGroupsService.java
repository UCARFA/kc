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
