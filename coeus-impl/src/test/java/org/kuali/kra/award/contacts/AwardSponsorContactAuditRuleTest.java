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
import org.kuali.kra.award.home.Award;

public class AwardSponsorContactAuditRuleTest {
    
    private Award award;
    private AwardSponsorContactAuditRule rule;
    
    @Before
    public void setUp() {
        rule = new AwardSponsorContactAuditRule();
        award = new Award();
    }
    
    @After
    public void tearDown() {
        rule = null;
        award = null;
    }
    
    @Test
    public void testCheckForAtLeastOneSponsorContact() {
        Assert.assertFalse("Require one sponsor contact rule failed.", rule.checkForAtLeastOneSponsorContact(award.getSponsorContacts()));
        AwardSponsorContact contact = new AwardSponsorContact();
        award.add(contact);
        Assert.assertTrue("Require one sponsor contact rule failed.", rule.checkForAtLeastOneSponsorContact(award.getSponsorContacts()));
    }
}
