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
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncException;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncType;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncXmlExport;
import org.kuali.kra.award.paymentreports.awardreports.AwardReportTerm;
import org.kuali.rice.krad.util.ObjectUtils;
import static org.junit.Assert.*;
public class AwardSyncReportRecipientHelperTest extends AwardSyncReportHelperTest {

    public AwardSyncReportRecipientHelperTest() { 
        super("AwardReportTermRecipient");
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.setUp();
    }
    
    @Override
    @Test
    public void testBuildXmlExport() throws Exception {
        AwardSyncXmlExport xmlExport = awardSyncHelper.buildXmlExport(recipient, null);
        AwardSyncXmlExport recipientExport = (AwardSyncXmlExport) xmlExport.getValues().get("awardReportTermRecipients");
        assertNotNull(recipientExport);
        assertFalse(recipientExport.getKeys().isEmpty());
        assertFalse(recipientExport.getValues().isEmpty());
        assertEquals(recipient.getRolodexId(), recipientExport.getKeys().get("rolodexId"));
        assertEquals(recipient.getNumberOfCopies(), recipientExport.getValues().get("numberOfCopies"));
    }
    
    @Override
    @Test
    public void testCreateAwardSyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, recipient, "awardReportTermItems", null);
        assertNotNull(change);
        assertNotNull(change.getXmlExport());
    }
    
    @Override
    @Test
    public void testApplySyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, recipient, "awardReportTermItems", null);
        AwardReportTerm newReport = (AwardReportTerm) ObjectUtils.deepCopy(report);
        newReport.getAwardReportTermRecipients().clear();
        award.add(newReport);
        awardSyncHelper.applySyncChange(award, change);
        assertFalse(award.getAwardReportTermItems().get(0).getAwardReportTermRecipients().isEmpty());
        assertEquals(recipient.getNumberOfCopies(), award.getAwardReportTermItems().get(0).getAwardReportTermRecipients().get(0).getNumberOfCopies());
        
        change = awardSyncHelper.createAwardSyncChange(AwardSyncType.DELETE_SYNC, recipient, "awardReportTermItems", null);
        awardSyncHelper.applySyncChange(award, change);
        assertTrue(award.getAwardReportTermItems().get(0).getAwardReportTermRecipients().isEmpty());
    }
    
    @Test(expected=AwardSyncException.class)
    public void testApplySyncChangeWithException() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, recipient, "awardReportTermItems", null);
        awardSyncHelper.applySyncChange(award, change);
    }

}
