/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.budget.bo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.common.budget.framework.core.Budget.FiscalYearSummary;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class BudgetCostShareTest extends BudgetDistributionAndIncomeTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    @Test
    public void testCalculatingTotalCostSharing() {
        createAndAddBudgetPeriod().setCostSharingAmount(FY_2007_Q3_AMT);
        Assert.assertEquals(FY_2007_Q3_AMT, budgetDocument.getAvailableCostSharing());
        
        createAndAddBudgetPeriod().setCostSharingAmount(FY_2007_Q4_AMT);
        Assert.assertEquals(FY_2007_Q3_AMT.add(FY_2007_Q4_AMT), budgetDocument.getAvailableCostSharing());
        
        createAndAddBudgetPeriod().setCostSharingAmount(FY_2008_Q1_AMT);
        Assert.assertEquals(FY_2007_Q3_AMT.add(FY_2007_Q4_AMT).add(FY_2008_Q1_AMT), budgetDocument.getAvailableCostSharing());
        
        Assert.assertTrue(budgetDocument.isCostSharingAvailable());
    }
    
    @Test
    public void testGettingFiscalYearCostShareTotals() {
        createBudgetPeriodsForThreeFiscalYears();
        
        List<FiscalYearSummary> fiscalYearCostShareTotals = budgetDocument.getFiscalYearCostShareTotals();
        Assert.assertEquals(3, fiscalYearCostShareTotals.size());
        
        FiscalYearSummary fiscalYearSummary = fiscalYearCostShareTotals.get(0); 
        Assert.assertEquals(YEAR_2007, fiscalYearSummary.getFiscalYear());
        Assert.assertEquals(getDate(YEAR_2007, Calendar.JANUARY, DAY_1), fiscalYearSummary.getAssignedBudgetPeriod().getStartDate());
        Assert.assertEquals(FY_2007_Q3_AMT.add(FY_2007_Q4_AMT), fiscalYearSummary.getCostShare());
        
        fiscalYearSummary = fiscalYearCostShareTotals.get(1); 
        Assert.assertEquals(YEAR_2008, fiscalYearSummary.getFiscalYear());
        Assert.assertEquals(getDate(YEAR_2007, Calendar.JULY, DAY_1), fiscalYearSummary.getAssignedBudgetPeriod().getStartDate());
        Assert.assertEquals(FY_2008_Q1_AMT.add(FY_2008_Q2_AMT), fiscalYearSummary.getCostShare());
        
        fiscalYearSummary = fiscalYearCostShareTotals.get(2); 
        Assert.assertEquals(YEAR_2009, fiscalYearSummary.getFiscalYear());
        Assert.assertEquals(getDate(YEAR_2008, Calendar.OCTOBER, DAY_1), fiscalYearSummary.getAssignedBudgetPeriod().getStartDate());
        Assert.assertEquals(FY_2009_Q1_AMT.add(FY_2009_Q2_AMT), fiscalYearSummary.getCostShare());
    }
    
    @Test
    public void testIfCostSharingIsAvailable_BudgetPeriodPresentWithNonZeroCostSharing() {
        Assert.assertFalse(budgetDocument.isCostSharingAvailable());
        
        createAndAddBudgetPeriod().setCostSharingAmount(FY_2007_Q3_AMT);
        Assert.assertTrue(budgetDocument.isCostSharingAvailable());
    }
    
    @Test
    public void testCorrectBudgetPeriodAssignedForFiscalYear() {
        createAndAddBudgetPeriod(getDate(YEAR_2007, Calendar.NOVEMBER, DAY_1), getDate(YEAR_2007, Calendar.DECEMBER, DAY_30)).setCostSharingAmount(FY_2007_Q3_AMT);
        createAndAddBudgetPeriod(getDate(YEAR_2007, Calendar.JULY, DAY_1), getDate(YEAR_2007, Calendar.SEPTEMBER, DAY_30)).setCostSharingAmount(FY_2008_Q1_AMT);
        createAndAddBudgetPeriod(getDate(YEAR_2007, Calendar.APRIL, DAY_1), getDate(YEAR_2007, Calendar.JUNE, DAY_30)).setCostSharingAmount(FY_2007_Q4_AMT);
        
        Date startDate = getDate(YEAR_2007, Calendar.JANUARY, DAY_1);
        createAndAddBudgetPeriod(startDate, getDate(YEAR_2007, Calendar.MARCH, DAY_30)).setCostSharingAmount(FY_2007_Q3_AMT);        
                
        List<FiscalYearSummary> fiscalYearCostShareTotals = budgetDocument.getFiscalYearCostShareTotals();
        FiscalYearSummary fiscalYearSummary = fiscalYearCostShareTotals.get(0); 
        Assert.assertEquals(startDate, fiscalYearSummary.getAssignedBudgetPeriod().getStartDate());        
    }
    
    @Test
    public void testFindingCostSharingForFiscalYear() throws Exception {
        createBudgetPeriodsForThreeFiscalYears();
        Assert.assertEquals(FY_2007_Q3_AMT.add(FY_2007_Q4_AMT), budgetDocument.findCostSharingForFiscalYear(YEAR_2007));
        Assert.assertEquals(FY_2008_Q1_AMT.add(FY_2008_Q2_AMT), budgetDocument.findCostSharingForFiscalYear(YEAR_2008));
        Assert.assertEquals(FY_2009_Q1_AMT.add(FY_2009_Q2_AMT), budgetDocument.findCostSharingForFiscalYear(YEAR_2009));
        Assert.assertEquals(ScaleTwoDecimal.ZERO, budgetDocument.findCostSharingForFiscalYear(YEAR_2000));
    }
    
    @Test
    public void testIfCostSharingIsAvailable_BudgetPeriodPresentWithZeroCostSharing() {
        createAndAddBudgetPeriod().setCostSharingAmount(ScaleTwoDecimal.ZERO);
        Assert.assertFalse(budgetDocument.isCostSharingAvailable());
    }
    
    @Test
    public void testIfCostSharingIsAvailable_BudgetPeriodPresentButNoCostSharing() {
        Assert.assertFalse(budgetDocument.isCostSharingAvailable());
    }

    @Test
    public void testIfCostSharingIsAvailable_NoBudgetPeriods() {
        budgetDocument.getBudgetPeriods().clear();
        Assert.assertFalse(budgetDocument.isCostSharingAvailable());
    }
    
    @Test
    public void testIfCostSharingIsAvailable_BudgetPeriodsPresentWithCostSharingInOne() {
        createAndAddBudgetPeriod().setCostSharingAmount(ScaleTwoDecimal.ZERO);
        createAndAddBudgetPeriod().setCostSharingAmount(FY_2007_Q3_AMT);        
        createAndAddBudgetPeriod().setCostSharingAmount(ScaleTwoDecimal.ZERO);
        
        Assert.assertTrue(budgetDocument.isCostSharingAvailable());
    }
    
    @Test
    public void testCostSharingIsApplicable() {        
        Assert.assertTrue(budgetDocument.isCostSharingApplicable());
    }
    
    @Test
    public void testCostSharingIsNotApplicable() {
        // replace budgetDocument with one where cost sharing is not applicable
        budgetDocument = new BudgetDocument_CostShareAndUnrecoveredFandANotApplicable();
        
        createAndAddBudgetPeriod().setCostSharingAmount(FY_2007_Q3_AMT);        
        createAndAddBudgetPeriod().setCostSharingAmount(FY_2007_Q4_AMT);        
        createAndAddBudgetPeriod().setCostSharingAmount(FY_2008_Q1_AMT);
        
        Assert.assertFalse(budgetDocument.isCostSharingApplicable());
    }
}
