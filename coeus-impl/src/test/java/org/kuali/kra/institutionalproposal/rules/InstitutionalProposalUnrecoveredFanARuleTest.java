/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.rules;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.institutionalproposal.IndirectcostRateType;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalUnrecoveredFandA;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RunWith(JMock.class)
public class InstitutionalProposalUnrecoveredFanARuleTest {

    final Map<String, Object> queryMap = new HashMap<String, Object>();
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
    
    private static final String TEST_SOURCE = "54321";
    private static final String TEST_FISCAL_YEAR = "2008";
    private static final String TEST_INVALID_FISCAL_YEAR = "1000";
    private static final Integer PERCENTAGE = 50;
    private static final Integer AMOUNT = 10000;
    private static final Integer RATE_TYPE_CODE = 1;
    InstitutionalProposalUnrecoveredFandARuleImpl institutionalProposalUnrecoveredFandARuleImpl;
    InstitutionalProposalUnrecoveredFandA institutionalProposalUnrecoveredFandA;


    @Before
    public void setUp() throws Exception {
        institutionalProposalUnrecoveredFandARuleImpl = new InstitutionalProposalUnrecoveredFandARuleImpl();
        institutionalProposalUnrecoveredFandARuleImpl.setErrorReporter(new ErrorReporterImpl());
        institutionalProposalUnrecoveredFandA = new InstitutionalProposalUnrecoveredFandA();
        institutionalProposalUnrecoveredFandA.setApplicableIndirectcostRate(new ScaleTwoDecimal(PERCENTAGE));
        institutionalProposalUnrecoveredFandA.setFiscalYear(TEST_FISCAL_YEAR);
        institutionalProposalUnrecoveredFandA.setSourceAccount(TEST_SOURCE);
        institutionalProposalUnrecoveredFandA.setUnderrecoveryOfIndirectcost(new ScaleTwoDecimal(AMOUNT));
        institutionalProposalUnrecoveredFandA.setIndirectcostRateTypeCode(RATE_TYPE_CODE);
        queryMap.put("indirectcostRateTypeCode", 1);
        GlobalVariables.setMessageMap(new MessageMap());
    }
    

    @After
    public void tearDown() throws Exception {
        institutionalProposalUnrecoveredFandARuleImpl = null;
        institutionalProposalUnrecoveredFandA = null;
    }
    
    /**
     * Test method for {@link org.kuali.kra.award.commitments.AwardCostShareRule
     * (org.kuali.kra.award.commitments.AwardCostShare)}.
     */
    @Test
    public final void testProcessCommonValidations() {
        final BusinessObjectService MOCKED_BUSINESS_OBJECT_SERVICE;
        MOCKED_BUSINESS_OBJECT_SERVICE = context.mock(BusinessObjectService.class);
        context.checking(new Expectations() {{
            one(MOCKED_BUSINESS_OBJECT_SERVICE).countMatching(IndirectcostRateType.class, queryMap); 
            will(returnValue(1));
        }});
        final ParameterService MOCKED_PARAMETER_SERVICE;
        MOCKED_PARAMETER_SERVICE = context.mock(ParameterService.class);
        context.checking(new Expectations() {{
            one(MOCKED_PARAMETER_SERVICE).getParameterValueAsBoolean(Budget.class, Constants.BUDGET_UNRECOVERED_F_AND_A_ENFORCEMENT_FLAG);
            will(returnValue(true));
            one(MOCKED_PARAMETER_SERVICE).getParameterValueAsBoolean(Budget.class, Constants.BUDGET_UNRECOVERED_F_AND_A_APPLICABILITY_FLAG);
            will(returnValue(true));
        }});
        institutionalProposalUnrecoveredFandARuleImpl.setBusinessObjectService(MOCKED_BUSINESS_OBJECT_SERVICE);
        institutionalProposalUnrecoveredFandARuleImpl.setParameterService(MOCKED_PARAMETER_SERVICE);
        Assert.assertTrue(institutionalProposalUnrecoveredFandARuleImpl.processCommonValidations(institutionalProposalUnrecoveredFandA, new ArrayList<InstitutionalProposalUnrecoveredFandA>()));
    }
    
    /**
     * Test method for {@link org.kuali.kra.award.commitments.AwardCostShareRule
     * (org.kuali.kra.award.commitments.AwardCostShare)}.
     */
    @Test
    public final void testValidateCostShareFiscalYearRange() {
        Assert.assertTrue(institutionalProposalUnrecoveredFandARuleImpl.validateUnrecoveredFandAFiscalYearRange(institutionalProposalUnrecoveredFandA));
        institutionalProposalUnrecoveredFandA.setFiscalYear(TEST_INVALID_FISCAL_YEAR);
        Assert.assertFalse(institutionalProposalUnrecoveredFandARuleImpl.validateUnrecoveredFandAFiscalYearRange(institutionalProposalUnrecoveredFandA));
        institutionalProposalUnrecoveredFandA.setSourceAccount(TEST_FISCAL_YEAR);
    }
}
