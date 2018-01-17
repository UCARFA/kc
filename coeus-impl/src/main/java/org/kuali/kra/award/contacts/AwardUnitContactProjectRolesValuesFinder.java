/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.award.home.ContactType;

/**
 * This class finds Award Unit Contact Project Roles
 */
public class AwardUnitContactProjectRolesValuesFinder extends AwardContactsProjectRoleValuesFinder {

    @Override
    protected Class<? extends ContactRole> getRoleType() {
        return ContactType.class;
    }    
    
}
