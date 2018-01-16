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
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncException;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncType;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncXmlExport;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.contacts.AwardPersonUnit;
import org.kuali.rice.krad.util.ObjectUtils;
import static org.junit.Assert.*;
public class AwardSyncUnitHelperTest extends AwardSyncPersonHelperTest {

    protected AwardPersonUnit unit;
    protected Unit leadUnit;
    
    public AwardSyncUnitHelperTest() { 
        super("AwardPersonUnit");
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        unit = person.getUnit(0);
        leadUnit = new Unit();
        leadUnit.setUnitNumber(unitNumber);
        unit.setUnit(leadUnit);
        award.setLeadUnit(leadUnit);
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.setUp();
    }
    
    @Override
    @Test
    public void testBuildXmlExport() throws Exception {
        AwardSyncXmlExport xmlExport = awardSyncHelper.buildXmlExport(unit, null);
        AwardSyncXmlExport unitExport =  (AwardSyncXmlExport) xmlExport.getValues().get("units");
        assertNotNull(unitExport);
        assertFalse(unitExport.getKeys().isEmpty());
        assertFalse(unitExport.getValues().isEmpty());
        assertEquals(unit.getUnitNumber(), unitExport.getKeys().get("unitNumber"));
        assertEquals(unit.isLeadUnit(), unitExport.getValues().get("leadUnit"));
    }
    
    @Override
    @Test
    public void testCreateAwardSyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, unit, "projectPersons", null);
        assertNotNull(change);
        assertNotNull(change.getXmlExport());
    }
    
    @Override
    @Test
    public void testApplySyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, unit, "projectPersons", null);
        AwardPerson newPerson = (AwardPerson) ObjectUtils.deepCopy(person);
        newPerson.getUnits().clear();
        award.add(newPerson);
        awardSyncHelper.applySyncChange(award, change);
        assertFalse(award.getProjectPerson(0).getUnits().isEmpty());
        assertTrue(award.getProjectPerson(0).getUnit(0).isLeadUnit());
        assertEquals("000001", award.getProjectPerson(0).getUnit(0).getUnitNumber());
        
        change = awardSyncHelper.createAwardSyncChange(AwardSyncType.DELETE_SYNC, unit, "projectPersons", null);
        awardSyncHelper.applySyncChange(award, change);
        assertTrue(award.getProjectPerson(0).getUnits().isEmpty());
    }
    
    @Test(expected=AwardSyncException.class)
    public void testApplySyncChangeWithException() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, unit, "projectPersons", null);
        awardSyncHelper.applySyncChange(award, change);
    }

}
