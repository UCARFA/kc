/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.kuali.coeus.common.framework.person.PropAwardPersonRole;
import org.kuali.coeus.common.framework.unit.UnitContactType;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorType;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.award.home.ContactType;

/**
 * This class defines some mock AwardContactRoles
 */
public final class ContactRoleFixtureFactory {
    public static final ContactRole MOCK_PI = getProposalPersonRole(ContactRole.PI_CODE, "Principal Investigator");
    public static final ContactRole MOCK_COI = getProposalPersonRole(ContactRole.COI_CODE, "Co-Investigator");
    public static final ContactRole MOCK_KEY_PERSON = getProposalPersonRole(ContactRole.KEY_PERSON_CODE, "Key Person");

    private ContactRoleFixtureFactory() {
        
    }
    
    private static ContactRole getProposalPersonRole(String code, String description) {
        PropAwardPersonRole role = new PropAwardPersonRole();
        role.setCode(code);
        role.setDescription(description);
        return role;
    }
    
    private static ContactRole getUnitAdministratorType(String code, String description, UnitContactType unitContactType) {
        UnitAdministratorType type = new UnitAdministratorType();
        type.setCode(code);
        type.setDescription(description);
        type.setUnitContactType(unitContactType);
        return type;
    }
    
    private static ContactRole getContactType(String code, String description) {
        ContactType role = new ContactType();
        role.setContactTypeCode(code);
        role.setDescription(description);
        return role;
    }
}
