/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.auth.AuthServicePushService;
import org.kuali.coeus.sys.framework.auth.AuthUser;
import org.kuali.rice.kim.api.KimConstants;
import org.kuali.rice.kim.api.common.assignee.Assignee;
import org.kuali.rice.kim.api.group.GroupService;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kim.api.identity.PersonService;
import org.kuali.rice.kim.api.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("authServicePushService")
public class AuthServicePushServiceImpl extends AbstractCoreUserPushService<Person> implements AuthServicePushService {
	
	private static final String ADMIN_ROLE = "admin";
	private static final String USER_ROLE = "user";
	
	@Autowired
	@Qualifier("personService")
	private PersonService personService;
	
	@Autowired
	@Qualifier("permissionService")
	private PermissionService permissionService;
	
	@Autowired
	@Qualifier("groupService")
	private GroupService groupService;
	
	@Value("#{{'kc', 'kr', 'guest'}}") List<String> ignoredUsers = new ArrayList<>();
		
	@Override
	protected String getUserRole(Person person, final List<String> admins) {
		return admins.contains(person.getPrincipalId()) ? ADMIN_ROLE : USER_ROLE;
	}

	@Override
	protected List<String> getAdminUsers() {
		return getAdminAssignees().stream()
				.map(this::getAdminUsersFrom)
				.flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}

	protected List<Assignee> getAdminAssignees() {
		return permissionService.getPermissionAssignees(KimConstants.NAMESPACE_CODE, KimConstants.PermissionNames.MODIFY_ENTITY, Collections.emptyMap());
	}
	
	protected List<String> getAdminUsersFrom(Assignee assignee) {
		if (StringUtils.isNotBlank(assignee.getPrincipalId())) {
			return Collections.singletonList(assignee.getPrincipalId());
		} else if (StringUtils.isNotBlank(assignee.getGroupId())) {
			return getGroupMembers(assignee);
		} else {
			return Collections.emptyList();
		}
	}

	protected List<String> getGroupMembers(Assignee assignee) {
		return groupService.getMemberPrincipalIds(assignee.getGroupId());
	}

	@Override
	protected AuthUser generateAuthUserFromPerson(Person person, Map<String, String> groupIdsByUnitNumber) {
		AuthUser kimAuthUser = new AuthUser();
		kimAuthUser.setUsername(person.getPrincipalName());
		kimAuthUser.setSchoolId(person.getPrincipalId());
		kimAuthUser.setEmail(person.getEmailAddress());
		kimAuthUser.setName(person.getName());
		kimAuthUser.setFirstName(person.getFirstName());
		kimAuthUser.setLastName(person.getLastName());
		kimAuthUser.setPhone(person.getPhoneNumber());
		kimAuthUser.setActive(person.isActive());
		kimAuthUser.setRole(USER_ROLE);
		kimAuthUser.setGroupId(groupIdsByUnitNumber.get(person.getPrimaryDepartmentCode()));
		kimAuthUser.setActive(person.isActive());
		return kimAuthUser;
	}

	@Override
	protected List<Person> getAllPeople() {
		return personService.findPeople(Collections.emptyMap());
	}
	
	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public List<String> getIgnoredUsers() {
		return ignoredUsers;
	}

	public void setIgnoredUsers(List<String> ignoredUsers) {
		this.ignoredUsers = ignoredUsers;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	@Override
	protected boolean validUserToPush(Person person) {
		return !ignoredUsers.contains(person.getPrincipalName()); 
	}

}
