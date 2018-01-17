/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.period;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.sys.impl.gv.GlobalVariableServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class BudgetPeriodRuleTest {
    BudgetPeriodRule budgetPeriodRule;
    ProposalDevelopmentBudgetExt budget;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    private BudgetPeriod createBudgetPeriod(String startDate, String endDate) throws Exception {
        BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setStartDate(new Date(dateFormat.parse(startDate).getTime()));
        budgetPeriod.setEndDate(new Date(dateFormat.parse(endDate).getTime()));
        return budgetPeriod;
    }

    private DevelopmentProposal createDevelopmentProposal(String startDate, String endDate) throws Exception {
        DevelopmentProposal  developmentProposal = new DevelopmentProposal();
        developmentProposal.setRequestedStartDateInitial(new Date(dateFormat.parse(startDate).getTime()));
        developmentProposal.setRequestedEndDateInitial(new Date(dateFormat.parse(endDate).getTime()));
        return developmentProposal;
    }

    @Before
    public void setUp() throws Exception {
        budgetPeriodRule = new BudgetPeriodRule();
        budgetPeriodRule.setGlobalVariableService(new GlobalVariableServiceImpl());
        budget = new ProposalDevelopmentBudgetExt();
        budget.setDevelopmentProposal(createDevelopmentProposal("01/01/2016", "12/31/2019"));
    }

    @Test
    public void doBudgetPeriodsCoverProposalTest_continousPeriodsEndingAtYearEnd() throws Exception {
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2016", "12/31/2016"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2017", "12/31/2017"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2018", "12/31/2018"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2019", "12/31/2019"));
        boolean isValid = budgetPeriodRule.doBudgetPeriodsCoverProposal(budget);
        Assert.assertTrue("budget is valid", isValid);
    }

    @Test
    public void doBudgetPeriodsCoverProposalTest_continousPeriodsNotSorted() throws Exception {
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2018", "12/31/2018"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2016", "12/31/2016"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2017", "12/31/2017"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2019", "12/31/2019"));
        boolean isValid = budgetPeriodRule.doBudgetPeriodsCoverProposal(budget);
        Assert.assertTrue("budget is valid", isValid);
    }

    @Test
    public void doBudgetPeriodsCoverProposalTest_continousPeriodsMiscEnd() throws Exception {
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2016", "08/31/2016"));
        budget.getBudgetPeriods().add(createBudgetPeriod("09/01/2016", "03/31/2017"));
        budget.getBudgetPeriods().add(createBudgetPeriod("04/01/2017", "12/31/2019"));
        boolean isValid = budgetPeriodRule.doBudgetPeriodsCoverProposal(budget);
        Assert.assertTrue("budget is valid", isValid);
    }

    @Test
    public void doBudgetPeriodsCoverProposalTest_BudgetPeriodGap() throws Exception {
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2016", "12/31/2016"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2018", "12/31/2018"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2019", "12/31/2019"));
        boolean isValid = budgetPeriodRule.doBudgetPeriodsCoverProposal(budget);
        Assert.assertFalse("budget is invalid", isValid);
    }

    @Test
    public void doBudgetPeriodsCoverProposalTest_BudgetPeriodOverlap() throws Exception {
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2016", "12/31/2016"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2017", "12/31/2017"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2018", "12/31/2019"));
        budget.getBudgetPeriods().add(createBudgetPeriod("01/01/2019", "12/31/2019"));
        boolean isValid = budgetPeriodRule.doBudgetPeriodsCoverProposal(budget);
        Assert.assertFalse("budget is invalid", isValid);
    }
}
