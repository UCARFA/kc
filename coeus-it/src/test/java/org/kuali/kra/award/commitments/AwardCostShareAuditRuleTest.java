/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AwardCostShareAuditRuleTest extends KcIntegrationTestBase {
    
    private static final String TEST_SOURCE = "54321";
    private static final String TEST_DESTINATION = "12345";
    private static final String TEST_FISCAL_YEAR = "2008";
    private static final String TEST_FISCAL_YEAR_2 = "2009";
    private static final Integer TEST_COST_SHARE_TYPE = 1;
    private static final Integer PERCENTAGE = 50;
    private static final Integer COMMITMENT_AMOUNT = 10000;
    private AwardCostShareAuditRule awardCostShareAuditRule;
    private List<AwardCostShare> awardCostShares = new ArrayList<>();
    private List<AwardCostShare> awardCostSharesNullType = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
        awardCostShareAuditRule = new AwardCostShareAuditRule();
        AwardCostShare awardCostShare = new AwardCostShare();
        awardCostShare.setCostSharePercentage(new ScaleTwoDecimal(PERCENTAGE));
        awardCostShare.setCostShareTypeCode(TEST_COST_SHARE_TYPE);
        awardCostShare.setProjectPeriod(TEST_FISCAL_YEAR);
        awardCostShare.setDestination(TEST_DESTINATION);
        awardCostShare.setSource(TEST_SOURCE);
        awardCostShare.setCommitmentAmount(new ScaleTwoDecimal(COMMITMENT_AMOUNT));
        awardCostShares.add(awardCostShare);
        awardCostShare = new AwardCostShare();
        awardCostShare.setCostSharePercentage(new ScaleTwoDecimal(PERCENTAGE));
        awardCostShare.setCostShareTypeCode(TEST_COST_SHARE_TYPE);
        awardCostShare.setProjectPeriod(TEST_FISCAL_YEAR_2);
        awardCostShare.setDestination(TEST_DESTINATION);
        awardCostShare.setSource(TEST_SOURCE);
        awardCostShare.setCommitmentAmount(new ScaleTwoDecimal(COMMITMENT_AMOUNT));
        awardCostShares.add(awardCostShare);
        GlobalVariables.setMessageMap(new MessageMap());

        AwardCostShare awardCostShareNullType = new AwardCostShare();
        awardCostShareNullType.setCostSharePercentage(new ScaleTwoDecimal(PERCENTAGE));
        awardCostShareNullType.setCostShareTypeCode(null);
        awardCostShareNullType.setProjectPeriod(TEST_FISCAL_YEAR);
        awardCostShareNullType.setDestination(TEST_DESTINATION);
        awardCostShareNullType.setSource(TEST_SOURCE);
        awardCostShareNullType.setCommitmentAmount(new ScaleTwoDecimal(COMMITMENT_AMOUNT));
        awardCostSharesNullType.add(awardCostShareNullType);
    }

    @After
    public void tearDown() throws Exception {
        awardCostShareAuditRule = null;
        awardCostShares = null;
        awardCostSharesNullType = null;
    }
   
    @Test
    public void testCostShareUniqueCheck() throws Exception {
        assertTrue(awardCostShareAuditRule.validateCostShareDoesNotViolateUniqueConstraintNonNull(awardCostShares));
        awardCostShares.get(1).setProjectPeriod(TEST_FISCAL_YEAR);
        assertFalse(awardCostShareAuditRule.validateCostShareDoesNotViolateUniqueConstraintNonNull(awardCostShares));
    }


    @Test
    public void testCostShareNull() throws Exception {
        assertFalse(awardCostShareAuditRule.validateCostShareDoesNotViolateUniqueConstraintNonNull(awardCostSharesNullType));
        awardCostSharesNullType.get(0).setCostShareTypeCode(1);
        assertTrue(awardCostShareAuditRule.validateCostShareDoesNotViolateUniqueConstraintNonNull(awardCostSharesNullType));
    }
}
