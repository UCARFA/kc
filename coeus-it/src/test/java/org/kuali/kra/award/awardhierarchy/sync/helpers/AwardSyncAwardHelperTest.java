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
import static org.junit.Assert.*;
public class AwardSyncAwardHelperTest extends AwardSyncHelperTestBase {
    
    private String sponsorCode = "0005000";
    private Integer statusCode = 1;
    
    public AwardSyncAwardHelperTest() {
        super("Award");
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        award.setSponsorCode(sponsorCode);
        award.setStatusCode(statusCode);
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testBuildXmlExport() throws Exception {
        AwardSyncXmlExport xmlExport = awardSyncHelper.buildXmlExport(award, "sponsorCode");
        assertNotNull(xmlExport);
        assertFalse(xmlExport.getValues().isEmpty());
        assertEquals(xmlExport.getValues().get("sponsorCode"), sponsorCode);
        
        xmlExport = awardSyncHelper.buildXmlExport(award, "statusCode");
        assertNotNull(xmlExport);
        assertFalse(xmlExport.getValues().isEmpty());
        assertEquals(xmlExport.getValues().get("statusCode"), statusCode);
    }
    
    @Test
    public void testCreateAwardSyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, award, null, "sponsorCode");
        assertNotNull(change);
        assertNotNull(change.getXmlExport());
    }
    
    @Test
    public void testApplySyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, award, "sponsorCode", "sponsorCode");
        award.setSponsorCode("0009906");
        awardSyncHelper.applySyncChange(award, change);
        assertEquals(award.getSponsorCode(), sponsorCode);
    }
}
