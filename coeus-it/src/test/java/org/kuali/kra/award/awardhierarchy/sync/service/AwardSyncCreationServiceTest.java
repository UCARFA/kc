/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncPendingChangeBean;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncType;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncXmlExport;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.contacts.AwardPersonUnit;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import static org.junit.Assert.*;
public class AwardSyncCreationServiceTest extends KcIntegrationTestBase {

    private Award award;
    private AwardSyncCreationService awardSyncCreationService;
    private AwardPerson person;
    private AwardPersonUnit personUnit;
    private AwardPersonUnit personUnit2;
    
    @Before
    public void setUp() throws Exception {
        awardSyncCreationService = KcServiceLocator.getService(AwardSyncCreationService.class);
        award = new Award();
        person = new AwardPerson();
        person.setPersonId("10000000001");
        person.setFullName("quickstart");
        person.setRoleCode("PI");
        Unit unit = new Unit();
        unit.setUnitName("TestUnit");
        unit.setUnitNumber("000001");
        personUnit = new AwardPersonUnit();
        personUnit.setAwardPerson(person);
        personUnit.setLeadUnit(true);
        personUnit.setUnit(unit);
        
        unit = new Unit();
        unit.setUnitName("TestUnit2");
        unit.setUnitNumber("BL-BL");
        personUnit2 = new AwardPersonUnit();
        personUnit2.setAwardPerson(person);
        personUnit2.setLeadUnit(false);
        personUnit2.setUnit(unit);

        person.add(personUnit);
        person.add(personUnit2);
        award.add(person);
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testCreateSyncChange() throws Exception {
        AwardSyncPendingChangeBean pendingChange = 
            new AwardSyncPendingChangeBean(AwardSyncType.ADD_SYNC, personUnit, "projectPersons", null);
        AwardSyncChange change = awardSyncCreationService.createAwardSyncChange(pendingChange);
        assertNotNull(change);
        assertTrue(change.getXml().length() > 0);
    }
    
    @Test
    public void testAddAwardSyncPendingChange() throws Exception {
        AwardSyncPendingChangeBean pendingChange = 
            new AwardSyncPendingChangeBean(AwardSyncType.ADD_SYNC, personUnit, "projectPersons", null);
        awardSyncCreationService.addAwardSyncChange(award, pendingChange);
        assertTrue(!award.getSyncChanges().isEmpty());
    }
    
    @Test
    public void testAddAwardSyncChange() throws Exception {
        AwardSyncPendingChangeBean pendingChange = 
            new AwardSyncPendingChangeBean(AwardSyncType.DELETE_SYNC, personUnit, "projectPersons", null);
        AwardSyncChange change = awardSyncCreationService.createAwardSyncChange(pendingChange);
        awardSyncCreationService.addAwardSyncChange(award, change);
        assertTrue(!award.getSyncChanges().isEmpty());
    }
    
    @Test
    public void testGetXmlExport() throws Exception {
        AwardSyncPendingChangeBean pendingChange = 
            new AwardSyncPendingChangeBean(AwardSyncType.DELETE_SYNC, personUnit, "projectPersons", null);
        AwardSyncChange change = awardSyncCreationService.createAwardSyncChange(pendingChange);
        change.setXmlExport(null);
        AwardSyncXmlExport xmlExport = awardSyncCreationService.getXmlExport(change);
        assertNotNull(xmlExport);
    }
    
    @Test
    public void testAddUniqueUnits() throws Exception {
        AwardSyncPendingChangeBean pendingChange = 
            new AwardSyncPendingChangeBean(AwardSyncType.DELETE_SYNC, personUnit, "projectPersons", null);
        AwardSyncChange change = awardSyncCreationService.createAwardSyncChange(pendingChange);
        awardSyncCreationService.addAwardSyncChange(award, change);
        assertTrue(!award.getSyncChanges().isEmpty());
        
        pendingChange = 
            new AwardSyncPendingChangeBean(AwardSyncType.DELETE_SYNC, personUnit2, "projectPersons", null);
        change = awardSyncCreationService.createAwardSyncChange(pendingChange);
        awardSyncCreationService.addAwardSyncChange(award, change);
        assertEquals(2, award.getSyncChanges().size());
    }
    
    @Test
    public void testAddDuplicateUnits() throws Exception {
        AwardSyncPendingChangeBean pendingChange = 
            new AwardSyncPendingChangeBean(AwardSyncType.DELETE_SYNC, personUnit, "projectPersons", null);
        AwardSyncChange change = awardSyncCreationService.createAwardSyncChange(pendingChange);
        awardSyncCreationService.addAwardSyncChange(award, change);
        assertTrue(!award.getSyncChanges().isEmpty());
        
        personUnit2.setUnit(personUnit.getUnit());
        pendingChange = 
            new AwardSyncPendingChangeBean(AwardSyncType.DELETE_SYNC, personUnit2, "projectPersons", null);
        change = awardSyncCreationService.createAwardSyncChange(pendingChange);
        awardSyncCreationService.addAwardSyncChange(award, change);
        assertEquals(1, award.getSyncChanges().size());
    }    
}
