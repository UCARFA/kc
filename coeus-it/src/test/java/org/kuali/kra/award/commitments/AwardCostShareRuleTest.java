/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.coeus.common.framework.costshare.CostShareService;
import org.kuali.kra.costshare.CostShareServiceTest;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

public class AwardCostShareRuleTest extends KcIntegrationTestBase {
    
    private static final String TEST_SOURCE = "54321";
    private static final String TEST_DESTINATION = "12345";
    private static final String TEST_FISCAL_YEAR = "2008";
    private static final String TEST_INVALID_FISCAL_YEAR = "1000";
    private static final Integer PERCENTAGE = 50;
    private static final Integer COMMITMENT_AMOUNT = 10000;
    AwardCostShareRuleImpl awardCostShareRule;
    AwardCostShare awardCostShare;

    @Before
    public void setUp() throws Exception {
        awardCostShareRule = new AwardCostShareRuleImpl();
        awardCostShareRule.setErrorReporter(new ErrorReporterImpl());
        awardCostShare = new AwardCostShare();
        awardCostShare.setCostSharePercentage(new ScaleTwoDecimal(PERCENTAGE));
        awardCostShare.setProjectPeriod(TEST_FISCAL_YEAR);
        awardCostShare.setDestination(TEST_DESTINATION);
        awardCostShare.setSource(TEST_SOURCE);
        awardCostShare.setCommitmentAmount(new ScaleTwoDecimal(COMMITMENT_AMOUNT));
        GlobalVariables.setMessageMap(new MessageMap());
          
    }

    @After
    public void tearDown() throws Exception {
        awardCostShareRule = null;
        awardCostShare = null;
    }

    @Test
    public final void testProcessCommonValidations() {
        Assert.assertTrue(awardCostShareRule.processCommonValidations(awardCostShare));
    }

    @Test
    public final void testValidateCostShareSourceAndDestinationForEquality() {
        Assert.assertTrue
            (awardCostShareRule.validateCostShareSourceAndDestinationForEquality(awardCostShare));
        awardCostShare.setSource(TEST_DESTINATION);
        Assert.assertFalse
            (awardCostShareRule.validateCostShareSourceAndDestinationForEquality(awardCostShare));
        awardCostShare.setSource(TEST_SOURCE);
    }

    @Test
    public final void testValidateCostShareFiscalYearRange() {
        updateParameterForTesting(CostShareServiceTest.class, "CostShareProjectPeriodNameLabel", "Fiscal Year");        
        CostShareService costShareService = KcServiceLocator.getService(CostShareService.class);
        costShareService.getCostShareLabel();
        awardCostShareRule.setCostShareService(costShareService);
        
        Assert.assertTrue(awardCostShareRule.validateCostShareFiscalYearRange(awardCostShare));
        awardCostShare.setProjectPeriod(TEST_INVALID_FISCAL_YEAR);
        Assert.assertFalse(awardCostShareRule.validateCostShareFiscalYearRange(awardCostShare));
        awardCostShare.setSource(TEST_FISCAL_YEAR);
    }

    @Test
    public void testValidateCostShareUnit() {
        Assert.assertTrue(awardCostShareRule.validateUnit("abc", "aField"));
        Assert.assertTrue(GlobalVariables.getMessageMap().getWarningMessages().size() == 1);
        Assert.assertTrue(GlobalVariables.getMessageMap().getWarningMessages().get("aField") != null);
    }

}
