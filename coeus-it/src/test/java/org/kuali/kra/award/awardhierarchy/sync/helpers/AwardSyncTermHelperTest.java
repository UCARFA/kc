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
import org.kuali.coeus.common.framework.sponsor.term.SponsorTerm;
import org.kuali.coeus.common.framework.sponsor.term.SponsorTermType;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncType;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncXmlExport;
import org.kuali.kra.award.home.AwardSponsorTerm;
import static org.junit.Assert.*;
public class AwardSyncTermHelperTest extends AwardSyncHelperTestBase {

    protected AwardSponsorTerm term;
    protected SponsorTerm sponsorTerm;
    protected static final Long sponsorTermId = 1L;
    
    public AwardSyncTermHelperTest() {
        super("AwardSponsorTerm");
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        sponsorTerm = new SponsorTerm();
        sponsorTerm.setSponsorTermId(sponsorTermId);
        sponsorTerm.setDescription("Test Sponsor Term");
        SponsorTermType type = new SponsorTermType();
        type.setDescription("Test Sponsor Term Type");
        type.setSponsorTermTypeCode("1");
        sponsorTerm.setSponsorTermType(type);
        term = new AwardSponsorTerm();
        term.setSponsorTerm(sponsorTerm);
        term.setSponsorTermId(sponsorTermId);
    }

    @Override
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testBuildXmlExport() throws Exception {
        AwardSyncXmlExport xmlExport = awardSyncHelper.buildXmlExport(term, null);
        assertNotNull(xmlExport);
        assertFalse(xmlExport.getKeys().isEmpty());
        assertEquals(sponsorTermId, xmlExport.getKeys().get("sponsorTermId"));
    }
    
    @Test
    public void testCreateAwardSyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, term, "awardSponsorTerms", null);
        assertNotNull(change);
        assertNotNull(change.getXmlExport());
    }
    
    @Test
    public void testApplySyncChange() throws Exception {
        AwardSyncChange change = 
            awardSyncHelper.createAwardSyncChange(AwardSyncType.ADD_SYNC, term, "awardSponsorTerms", null);
        awardSyncHelper.applySyncChange(award, change);
        assertFalse(award.getAwardSponsorTerms().isEmpty());
        assertEquals(sponsorTermId, award.getAwardSponsorTerms().get(0).getSponsorTermId());
    }
}
