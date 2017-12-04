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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.core.rolodex.RolodexToCorePushService;
import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.sys.framework.auth.AuthUser;
import org.kuali.coeus.sys.impl.auth.AbstractCoreUserPushService;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("rolodexToCorePushService")
public class RolodexToCorePushServiceImpl extends AbstractCoreUserPushService<Rolodex> implements RolodexToCorePushService {
	
	private static final String EXTERNAL_ROLE = "external";
	@Autowired
	@Qualifier("dataObjectService")
    private DataObjectService dataObjectService;
	
	@Override
	protected String getUserRole(Rolodex person, final List<String> admins) {
		return EXTERNAL_ROLE;
	}

	@Override
	protected AuthUser generateAuthUserFromPerson(Rolodex person, Map<String, String> groupIdsByUnitNumber) {
		AuthUser kimAuthUser = new AuthUser();
		kimAuthUser.setSchoolId(String.valueOf(person.getRolodexId()));
		kimAuthUser.setEmail(person.getEmailAddress());
		kimAuthUser.setName(person.getFullName());
		kimAuthUser.setFirstName(person.getFirstName());
		kimAuthUser.setLastName(person.getLastName());
		kimAuthUser.setPhone(person.getPhoneNumber());
		kimAuthUser.setActive(person.isActive());
		kimAuthUser.setRole(EXTERNAL_ROLE);
		kimAuthUser.setGroupId(groupIdsByUnitNumber.get(person.getOwnedByUnit()));
		kimAuthUser.setActive(person.isActive());
		return kimAuthUser;
	}

	@Override
	protected boolean validUserToPush(Rolodex person) {
		return StringUtils.isNotBlank(person.getEmailAddress()); 
	}

	@Override
	protected List<Rolodex> getAllPeople() {
		return dataObjectService.findAll(Rolodex.class).getResults();
	}

	@Override
	protected List<String> getAdminUsers() {
		return Collections.emptyList();
	}

}
