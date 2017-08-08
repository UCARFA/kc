/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.common.impl.core.rolodex;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.auth.CoreUsersPushStatus;
import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.sys.framework.auth.AuthUser;
import org.kuali.coeus.sys.framework.auth.CoreGroupsService;
import org.kuali.coeus.sys.framework.auth.GroupDto;
import org.kuali.coeus.sys.impl.auth.CoreGroupsServiceImpl;

public class RoldoexToCorePushServiceTest {
	
	private static final String TOP_LEVEL_UNIT_NUMBER = "000001";
	
	private Rolodex person1;
	private Rolodex person2;
	private Rolodex person3;
	
	private List<AuthUser> addedUsers;
	private List<AuthUser> updatedUsers;
	
	private Map<String, String> groupIds;
	
	@Before
	public void setup() {
		person1 = new PersonMock(1, "test1");
		person2 = new PersonMock(2, "test2");
		person3 = new PersonMock(3, "test3");
		
		addedUsers = new ArrayList<>();
		updatedUsers = new ArrayList<>();
		groupIds = new HashMap<>();
		groupIds.put("000001", "univTopLevelGroupId");
	}	
	
	@Test
	public void testPushAllUsersSame() {
		RolodexToCorePushServiceImpl service = new RolodexToCorePushServiceImpl() {
			@Override
			protected List<Rolodex> getAllPeople() {
				List<Rolodex> result = new ArrayList<>();
				result.add(person1);
				result.add(person2);
				result.add(person3);
				return result;
			}
			
			@Override
			protected List<AuthUser> getAllAuthServiceUsers() {
				List<AuthUser> authServiceUserList = new ArrayList<AuthUser>();
				authServiceUserList.add(this.generateAuthUserFromPerson(person1, groupIds));
				authServiceUserList.add(this.generateAuthUserFromPerson(person2, groupIds));
				authServiceUserList.add(this.generateAuthUserFromPerson(person3, groupIds));
				return authServiceUserList;
			}
			
			@Override
			protected boolean useDevPassword() {
				return false;
			}
		};
		service.setCoreGroupsService(buildMockCoreGroupsService());
		CoreUsersPushStatus status = service.pushAllUsers();
		assertNotNull(status);
		assertEquals(3, status.getNumberOfUsers());
		assertEquals(3, status.getNumberSame());
		assertEquals(0, status.getNumberAdded());
		assertEquals(0, status.getNumberUpdated());
	}
	
	@Test
	public void testPushAllUsers() {
		RolodexToCorePushServiceImpl service = new RolodexToCorePushServiceImpl() {
			@Override
			protected List<Rolodex> getAllPeople() {
				List<Rolodex> result = new ArrayList<>();
				result.add(person1);
				result.add(person2);
				result.add(person3);
				return result;
			}
			
			@Override
			protected List<AuthUser> getAllAuthServiceUsers() {
				List<AuthUser> authServiceUserList = new ArrayList<AuthUser>();
				authServiceUserList.add(this.generateAuthUserFromPerson(person1, groupIds));
				authServiceUserList.add(this.generateAuthUserFromPerson(person2, groupIds));
				authServiceUserList.get(1).setName("Testing Name Change");
				return authServiceUserList;
			}
			
			@Override
			protected void addUserToAuthService(AuthUser newUser, String userPassword) { }
			
			@Override
			protected void updateUserInAuthService(AuthUser updatedUser, String userId) { }
			
			@Override
			protected boolean useDevPassword() {
				return false;
			}
		};
		service.setCoreGroupsService(buildMockCoreGroupsService());
		CoreUsersPushStatus status = service.pushAllUsers();
		assertNotNull(status);
		assertEquals(3, status.getNumberOfUsers());
		assertEquals(1, status.getNumberSame());
		assertEquals(1, status.getNumberAdded());
		assertEquals(1, status.getNumberUpdated());
	}
	
	@Test
	public void testPushAllUsers_homeUnitChange() {
		RolodexToCorePushServiceImpl service = new RolodexToCorePushServiceImpl() {
			@Override
			protected List<Rolodex> getAllPeople() {
				List<Rolodex> result = new ArrayList<>();
				result.add(person1);
				result.add(person2);
				result.add(person3);
				return result;
			}
			
			@Override
			protected List<AuthUser> getAllAuthServiceUsers() {
				List<AuthUser> authServiceUserList = new ArrayList<AuthUser>();
				authServiceUserList.add(this.generateAuthUserFromPerson(person1, groupIds));
				authServiceUserList.add(this.generateAuthUserFromPerson(person2, groupIds));
				authServiceUserList.get(1).setGroupId("notTopLevelUnit");
				return authServiceUserList;
			}
			
			@Override
			protected void addUserToAuthService(AuthUser newUser, String userPassword) { }
			
			@Override
			protected void updateUserInAuthService(AuthUser updatedUser, String userId) { }
			
			@Override
			protected boolean useDevPassword() {
				return false;
			}
		};
		service.setCoreGroupsService(buildMockCoreGroupsService());
		CoreUsersPushStatus status = service.pushAllUsers();
		assertNotNull(status);
		assertEquals(3, status.getNumberOfUsers());
		assertEquals(1, status.getNumberSame());
		assertEquals(1, status.getNumberAdded());
		assertEquals(1, status.getNumberUpdated());
	}
	
	@Test
	public void testPushAllUsers_updatedName() {
		RolodexToCorePushServiceImpl service = new RolodexToCorePushServiceImpl() {
			@Override
			protected List<Rolodex> getAllPeople() {
				List<Rolodex> result = new ArrayList<>();
				result.add(person1);
				result.add(person2);
				result.add(person3);
				return result;
			}
			
			@Override
			protected List<AuthUser> getAllAuthServiceUsers() {
				List<AuthUser> authServiceUserList = new ArrayList<AuthUser>();
				authServiceUserList.add(this.generateAuthUserFromPerson(person1, groupIds));
				authServiceUserList.add(this.generateAuthUserFromPerson(person2, groupIds));
				authServiceUserList.get(1).setName("Testing Name Change");
				return authServiceUserList;
			}
			
			@Override
			protected void addUserToAuthService(AuthUser newUser, String userPassword) {
				addedUsers.add(newUser);
			}
			
			@Override
			protected void updateUserInAuthService(AuthUser updatedUser, String userId) {
				updatedUsers.add(updatedUser);
			}
			
			@Override
			protected boolean useDevPassword() {
				return false;
			}
		};
		service.setCoreGroupsService(buildMockCoreGroupsService());
		CoreUsersPushStatus status = service.pushAllUsers();
		assertNotNull(status);
		assertEquals(3, status.getNumberOfUsers());
		assertEquals(1, status.getNumberSame());
		assertEquals(1, status.getNumberAdded());
		assertEquals(1, status.getNumberUpdated());
		assertEquals(1, addedUsers.size());
		assertEquals(0L, updatedUsers.stream().filter(user -> user.getRole().equals("admin")).collect(Collectors.counting()).longValue());
	
	}
	
	final class PersonMock extends Rolodex {

		private Integer rolodexId;
		private String firstName;
		private String lastName;
		private String name;
		private String emailAddress;
		private String phoneNumber;
		private String ownedByUnit;
		
		public PersonMock(Integer rolodexId, String firstName, String lastName,
				String name, String emailAddress, String phoneNumber, String ownedByUnit) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.name = name;
			this.emailAddress = emailAddress;
			this.phoneNumber = phoneNumber;
			this.ownedByUnit = ownedByUnit;
			this.rolodexId = rolodexId;
		}
		
		public PersonMock(Integer rolodexId, String emailAddress, String firstName, String lastName, String phoneNumber) {
			this(rolodexId, firstName, lastName, 
					firstName + " " + lastName, 
					emailAddress, 
					phoneNumber, TOP_LEVEL_UNIT_NUMBER);
		}
		
		public PersonMock(Integer rolodexId, String firstName) {
			this(rolodexId, firstName + "@kuali.dev", firstName, firstName, "555-555-5555");
		}
		
		@Override
		public String getFullName() {
			return name;
		}

		@Override
		public String getFirstName() {
			return firstName;
		}

		@Override
		public String getLastName() {
			return lastName;
		}

		@Override
		public String getEmailAddress() {
			return emailAddress;
		}

		@Override
		public String getPhoneNumber() {
			return phoneNumber;
		}
		
		@Override
		public boolean isActive() {
			return true;
		}

		@Override
        public Integer getRolodexId() {
			return rolodexId;
		}
		
		@Override
		public String getOwnedByUnit() {
			return ownedByUnit;
		}
	}
	
	CoreGroupsService buildMockCoreGroupsService() {
		CoreGroupsService coreGroupsService = mock(CoreGroupsServiceImpl.class);
		when(coreGroupsService.getAllGroups()).thenReturn(Arrays.asList(buildGroupDto(groupIds.get(TOP_LEVEL_UNIT_NUMBER), TOP_LEVEL_UNIT_NUMBER)));
		when(coreGroupsService.getUnitNumberForGroup(any())).thenCallRealMethod();
		return coreGroupsService;
	}
	
	GroupDto buildGroupDto(String id, String unitNumber) {
		GroupDto group = new GroupDto();
		group.setId(id);
		group.getFields().add(new GroupDto.GroupFields(CoreGroupsService.UNIT_NUMBER_FIELD_ID, unitNumber));
		return group;
	}
}
