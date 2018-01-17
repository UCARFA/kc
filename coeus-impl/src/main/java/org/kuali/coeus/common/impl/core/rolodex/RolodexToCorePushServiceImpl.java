/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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
