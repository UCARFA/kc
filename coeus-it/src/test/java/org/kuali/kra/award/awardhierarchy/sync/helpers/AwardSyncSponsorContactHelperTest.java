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
import org.kuali.kra.award.contacts.AwardSponsorContact;
import static org.junit.Assert.*;
public class AwardSyncSponsorContactHelperTest extends AwardSyncHelperTestBase {
    
    protected AwardSponsorContact contact;

    public AwardSyncSponsorContactHelperTest() {
        super("AwardSponsorContact");
    }
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        contact = new AwardSponsorContact();
        contact.setRolodexId(1);
        contact.setRoleCode("1");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    @Test
    public void testBuildXmlExport() throws Exception {
        AwardSyncXmlExport xmlExport = awardSyncHelper.buildXmlExport(contact, null);
        assertNotNull(xmlExport);
        assertFalse(xmlExport.getKeys().isEmpty());
        assertFalse(xmlExport.getValues().isEmpty());
        assertEquals(contact.getRolodexId(), xmlExport.getKeys().get("rolodexId"));
        assertEquals(contact.getRoleCode(), xmlExport.getKeys().get("roleCode"));
    }
    
    @Test
    public void testCreateAwardSyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, contact, "sponsorContacts", null);
        assertNotNull(change);
        assertNotNull(change.getXmlExport());
    }
    
    @Test
    public void testApplySyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, contact, "sponsorContacts", null);
        awardSyncHelper.applySyncChange(award, change);
        assertFalse(award.getSponsorContacts().isEmpty());
        assertEquals(contact.getRoleCode(), award.getSponsorContacts().get(0).getRoleCode());

        change = awardSyncHelper.createAwardSyncChange(AwardSyncType.DELETE_SYNC, contact, "sponsorContacts", null);
        awardSyncHelper.applySyncChange(award, change);
        assertTrue(award.getSponsorContacts().isEmpty());
    }
    
}
