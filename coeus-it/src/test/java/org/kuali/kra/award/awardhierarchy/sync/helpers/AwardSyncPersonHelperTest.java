/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.helpers;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncType;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncXmlExport;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.contacts.AwardPersonUnit;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import static org.junit.Assert.*;
public class AwardSyncPersonHelperTest extends AwardSyncHelperTestBase {
    
    protected AwardPerson person;
    protected static final String unitNumber = "000001";
    
    public AwardSyncPersonHelperTest() {
        super("AwardPerson");
    }
    protected AwardSyncPersonHelperTest(String className) {
        super(className);
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        person = new AwardPerson();
        person.setAward(award);
        person.setAcademicYearEffort(new ScaleTwoDecimal(100.00));
        person.setCalendarYearEffort(new ScaleTwoDecimal(100.00));
        person.setRoleCode("PI");
        person.setFaculty(false);
        person.setPersonId("10000000001");
        
        AwardPersonUnit unit = new AwardPersonUnit();
        unit.setAwardPerson(person);
        unit.setLeadUnit(true);
        unit.setUnitNumber(unitNumber);
        person.add(unit);
        unit.setAwardPerson(person);
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testBuildXmlExport() throws Exception {
        AwardSyncXmlExport xmlExport = awardSyncHelper.buildXmlExport(person, null);
        assertNotNull(xmlExport);
        assertFalse(xmlExport.getKeys().isEmpty());
        assertFalse(xmlExport.getValues().isEmpty());
        assertEquals(person.getFullName(), xmlExport.getValues().get("fullName")); 
        assertEquals(person.getRoleCode(), xmlExport.getKeys().get("roleCode"));
        assertEquals(person.getCalendarYearEffort(), xmlExport.getValues().get("calendarYearEffort"));
    }
    
    @Test
    public void testCreateAwardSyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, person, "projectPersons", null);
        assertNotNull(change);
        assertNotNull(change.getXmlExport());
    }
    
    @Test
    public void testApplySyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, person, "projectPersons", null);
        awardSyncHelper.applySyncChange(award, change);
        assertFalse(award.getProjectPersons().isEmpty());
        assertEquals(award.getProjectPerson(0).getFullName(), person.getFullName());
        assertFalse(award.getProjectPerson(0).getUnits().isEmpty());
        
        change = awardSyncHelper.createAwardSyncChange(AwardSyncType.DELETE_SYNC, person, "projectPersons", null);
        awardSyncHelper.applySyncChange(award, change);
        assertTrue(award.getProjectPersons().isEmpty());
    }
}
