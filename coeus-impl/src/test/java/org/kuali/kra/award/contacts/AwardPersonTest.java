/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.unit.Unit;

/**
 * This class tests AwardContact
 */
public class AwardPersonTest {
    private AwardPerson contact;
    private Unit unitA;
    private Unit unitB;
    
    @Before
    public void setUp() throws Exception {
        contact = new AwardPerson();
        unitA = new Unit();
        unitA.setUnitName("UnitA");
        unitB = new Unit();
        unitB.setUnitName("UnitB");        
    }
    
    @After
    public void tearDown() throws Exception {
        contact = null;
        unitA = null;
        unitB = null;
    }
    
    @Test
    public void testFindingPrincipalInvestigator() {
        contact.setContactRole(ContactRoleFixtureFactory.MOCK_COI);
        Assert.assertFalse("PI misidentified", contact.isPrincipalInvestigator());
        
        contact.setContactRole(ContactRoleFixtureFactory.MOCK_PI);
        Assert.assertTrue("PI not identified", contact.isPrincipalInvestigator());
    }
}
