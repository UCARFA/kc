/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.users;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.unit.Unit;

public class ResearchUsersRestControllerTest {

    public static final String UNIT_NUMBER = "1234";
    public static final String PERSON_ID = "5678";
    public static final String TESTER = "TESTER";

    private class MockKcPerson extends KcPerson {
        @Override
        public Unit getUnit() {
            Unit unit = new Unit();
            unit.setUnitNumber(UNIT_NUMBER);
            return unit;
        }

        @Override
        public String getUserName() {
            return TESTER;
        }

        @Override
        public String getPersonId(){
            return PERSON_ID;
        }
    }

    @Test
    public void testConvertToUserDTO() {
        ResearchUsersRestController researchUsersRestController = new ResearchUsersRestController();

        MockKcPerson kcPerson = new MockKcPerson();
        UserDTO user = researchUsersRestController.convertToUserDTO(kcPerson);
        assertEquals(UNIT_NUMBER,user.getPrimaryDepartmentCode());
        assertEquals(PERSON_ID, user.getPersonId());
        assertEquals(TESTER, user.getUserName());
    }
}