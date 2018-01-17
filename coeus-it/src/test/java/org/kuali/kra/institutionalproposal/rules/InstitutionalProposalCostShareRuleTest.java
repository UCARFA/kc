/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.rules;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.coeus.common.framework.costshare.CostShareService;
import org.kuali.kra.costshare.CostShareServiceTest;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalCostShare;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;


public class InstitutionalProposalCostShareRuleTest extends KcIntegrationTestBase {

    private static final String TEST_SOURCE = "54321";
    private static final String TEST_FISCAL_YEAR = "2008";
    private static final String TEST_INVALID_FISCAL_YEAR = "1500";
    private static final Integer PERCENTAGE = 50;
    private static final Integer AMOUNT = 10000;
    InstitutionalProposalAddCostShareRuleImpl institutionalProposalAddCostShareRule;
    InstitutionalProposalCostShare institutionalProposalCostShare;

    @Before
    public void setUp() throws Exception {
        institutionalProposalAddCostShareRule = new InstitutionalProposalAddCostShareRuleImpl();
        institutionalProposalAddCostShareRule.setErrorReporter(new ErrorReporterImpl());
        institutionalProposalCostShare = new InstitutionalProposalCostShare();
        institutionalProposalCostShare.setCostSharePercentage(new ScaleTwoDecimal(PERCENTAGE));
        institutionalProposalCostShare.setProjectPeriod(TEST_FISCAL_YEAR);
        institutionalProposalCostShare.setSourceAccount(TEST_SOURCE);
        institutionalProposalCostShare.setAmount(new ScaleTwoDecimal(AMOUNT));
        GlobalVariables.setMessageMap(new MessageMap());
    }

    @After
    public void tearDown() throws Exception {
        institutionalProposalAddCostShareRule = null;
        institutionalProposalCostShare = null;
    }

    @Test
    public final void testProcessCommonValidations() {
        Assert.assertTrue(institutionalProposalAddCostShareRule.processCommonValidations(institutionalProposalCostShare));
    }
    

    @Test
    public final void testValidateCostShareFiscalYearRange() {
        updateParameterForTesting(CostShareServiceTest.class, "CostShareProjectPeriodNameLabel", "Fiscal Year"); 
        CostShareService costShareService = KcServiceLocator.getService(CostShareService.class);
        costShareService.getCostShareLabel();
        institutionalProposalAddCostShareRule.setCostShareService(costShareService);
        
        Assert.assertTrue(institutionalProposalAddCostShareRule.validateCostShareFiscalYearRange(institutionalProposalCostShare));
        institutionalProposalCostShare.setProjectPeriod(TEST_INVALID_FISCAL_YEAR);
        Assert.assertFalse(institutionalProposalAddCostShareRule.validateCostShareFiscalYearRange(institutionalProposalCostShare));
        institutionalProposalCostShare.setSourceAccount(TEST_FISCAL_YEAR);
    }

    @Test
    public void testValidateCostShareUnit() {
        Assert.assertTrue(institutionalProposalAddCostShareRule.validateUnit("abc", "aField"));
        Assert.assertTrue(GlobalVariables.getMessageMap().getWarningMessages().size() == 1);
        Assert.assertTrue(GlobalVariables.getMessageMap().getWarningMessages().get("aField") != null);    }
}

