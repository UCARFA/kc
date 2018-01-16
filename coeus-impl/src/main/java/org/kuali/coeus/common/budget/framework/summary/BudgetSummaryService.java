/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.summary;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;

import java.sql.Date;
import java.util.List;

public interface BudgetSummaryService {

    public List<BudgetPeriod> generateBudgetPeriods(Budget budget);
    public void addBudgetPeriod(Budget budget, BudgetPeriod newBudgetPeriod);
    public void deleteBudgetPeriod(Budget budget, int delPeriod);
    public boolean budgetLineItemExists(Budget budget, Integer budgetPeriod);
    public void generateAllPeriods(Budget budget);
    public void calculateBudget(Budget budget);

    /**
     * 
     * This method to get on/off campus flag description.
     * @param onOffCampusFlag
     */
    public String getOnOffCampusFlagDescription(String onOffCampusFlag);
    
    /**
     * 
     * This method to update the on/off campus flag for line item detail if on/off campus flag is changed in budget level.
     * @param budget
     * @param onOffCampusFlag
     */
    public void updateOnOffCampusFlag(Budget budget, String onOffCampusFlag);
    
    /**
     * 
     * This method to adjust the start/end dates of budget line items if budget period's start/end
     * date was adjusted
     * @param budget
     */
    public void adjustStartEndDatesForLineItems(Budget budget);
    
    /**
     * 
     * This method hold the old start/end date, so it can be used for comparison upon save.
     * 
     * @param budget
     */
    public void setupOldStartEndDate (Budget budget, boolean resetAll);

    public List<Date> getNewStartEndDates(List<Date> startEndDates, int gap, int duration, Date prevDate, boolean leapDayInPeriod, boolean leapDayInGap);

    public boolean isLeapDaysInPeriod(Date sDate, Date eDate);
    
    /** 
     * 
     * This method is to generate default periods when default button is clicked.
     * Generally does this when project period is adjusted
     * @param budget
     */
    public void defaultBudgetPeriods(Budget budget);

    public String defaultWarningMessage(Budget budget);
    
    public void adjustStartEndDatesForLineItems(BudgetPeriod budgetPeriod);
    
    /**
     * This method is to sync personnel salary details to new budget period changes.
     * @param budget
     */
    public void syncBudgetPersonSalaryDetails(Budget budget);
        
}
