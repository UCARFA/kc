/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget.calculator;

import org.kuali.coeus.common.budget.framework.core.CostElement;
import org.kuali.coeus.common.budget.framework.core.category.BudgetCategoryType;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.common.budget.framework.rate.RateType;
import org.kuali.coeus.common.budget.impl.calculator.BudgetCalculationServiceImpl;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.kra.award.budget.AwardBudgetExt;
import org.kuali.kra.award.budget.AwardBudgetLineItemExt;

import java.util.*;

/**
 * Subclass for Award budget calculations needs
 */
public class AwardBudgetCalculationServiceImpl extends BudgetCalculationServiceImpl implements AwardBudgetCalculationService {

    @Override
    public void calculateBudgetSummaryTotals(AwardBudgetExt budget, boolean includePrevious) {
        calculateBudgetSummaryTotals(budget);
        aggregatePeriodSummaryTotals(budget);
        if (includePrevious) {
            AwardBudgetExt prevBudget;
            for (AwardBudgetExt prevBudgetOverview = budget.getPrevBudget();
                    prevBudgetOverview != null && prevBudgetOverview.getBudgetId() != null; 
                    prevBudgetOverview = prevBudget.getPrevBudget()) {
                prevBudget = getBusinessObjectService().findBySinglePrimaryKey(AwardBudgetExt.class, 
                        prevBudgetOverview.getBudgetId());
                if (prevBudget == null) {
                    break;
                }
                calculateBudgetSummaryTotals(prevBudget);
                aggregatePeriodSummaryTotals(prevBudget);
                mergePrevSummary(budget, prevBudget);
            }
        }
    }

    /**
     * Aggregate period totals to the budget for summary items on the budget.
     * @param budget
     */
    @SuppressWarnings("unchecked")
    protected void aggregatePeriodSummaryTotals(AwardBudgetExt budget) {
        budget.setObjectCodeBudgetTotals((SortedMap<CostElement, ScaleTwoDecimal>) getSumOfElements(budget.getObjectCodeTotals()));
        budget.setCalculatedExpenseBudgetTotals((SortedMap<RateType, ScaleTwoDecimal>) getSumOfElements(budget.getCalculatedExpenseTotals()));
        budget.setTotalBudgetSummaryTotals((SortedMap<String, ScaleTwoDecimal>) getSumOfElements(budget.getBudgetSummaryTotals()));
        budget.setObjectCodePersonnelFringeBudgetTotals((SortedMap<String, ScaleTwoDecimal>) getSumOfElements(budget.getObjectCodePersonnelFringeTotals()));
        budget.setPersonnelCalculatedExpenseBudgetTotals((SortedMap<RateType, ScaleTwoDecimal>) getSumOfElements(budget.getPersonnelCalculatedExpenseTotals()));
        budget.setNonPersonnelCalculatedExpenseBudgetTotals((SortedMap<RateType, ScaleTwoDecimal>) getSumOfElements(budget.getNonPersonnelCalculatedExpenseTotals()));
    }
    
    /**
     * Merge and sum up the summary items from the previous budget to the current budget.
     * @param budget
     * @param prevBudget
     */
    @SuppressWarnings("unchecked")
    protected void mergePrevSummary(AwardBudgetExt budget, AwardBudgetExt prevBudget) {
        for (Map.Entry<BudgetCategoryType, List<CostElement>> entry : prevBudget.getObjectCodeListByBudgetCategoryType().entrySet()) {
            List<CostElement> curElements = budget.getObjectCodeListByBudgetCategoryType().get(entry.getKey());
            if (curElements == null) {
                budget.getObjectCodeListByBudgetCategoryType().put(entry.getKey(), new ArrayList<CostElement>(entry.getValue()));
            } else {
                HashSet uniqueSet = new HashSet<CostElement>(curElements);
                uniqueSet.addAll(entry.getValue());
                budget.getObjectCodeListByBudgetCategoryType().put(entry.getKey(), new ArrayList<CostElement>(uniqueSet));
            }            
        }
        budget.setObjectCodeBudgetTotals((SortedMap<CostElement, ScaleTwoDecimal>) mergeMaps(budget.getObjectCodeBudgetTotals(),
                prevBudget.getObjectCodeBudgetTotals()));
        budget.setCalculatedExpenseBudgetTotals((SortedMap<RateType, ScaleTwoDecimal>) mergeMaps(budget.getCalculatedExpenseBudgetTotals(),
                prevBudget.getCalculatedExpenseBudgetTotals()));
        budget.setTotalBudgetSummaryTotals((SortedMap<String, ScaleTwoDecimal>) mergeMaps(budget.getTotalBudgetSummaryTotals(),
                prevBudget.getTotalBudgetSummaryTotals()));
        budget.setObjectCodePersonnelFringeBudgetTotals((SortedMap<String, ScaleTwoDecimal>) mergeMaps(budget.getObjectCodePersonnelFringeBudgetTotals(),
                prevBudget.getObjectCodePersonnelFringeBudgetTotals()));
        budget.setPersonnelCalculatedExpenseBudgetTotals((SortedMap<RateType, ScaleTwoDecimal>) mergeMaps(budget.getPersonnelCalculatedExpenseBudgetTotals(),
                prevBudget.getPersonnelCalculatedExpenseBudgetTotals()));
        budget.setNonPersonnelCalculatedExpenseBudgetTotals((SortedMap<RateType, ScaleTwoDecimal>) mergeMaps(budget.getNonPersonnelCalculatedExpenseBudgetTotals(),
                prevBudget.getNonPersonnelCalculatedExpenseBudgetTotals()));
    }
    
    /**
     * Merges or adds the 2 maps into the return value.
     * @param totals
     * @param previous
     * @return
     */
    protected SortedMap<? extends Object, ScaleTwoDecimal> mergeMaps(Map<? extends Object, ScaleTwoDecimal> totals, Map<? extends Object, ScaleTwoDecimal> previous) {
        SortedMap<Object, ScaleTwoDecimal> result = new TreeMap<Object, ScaleTwoDecimal>();
        for (Map.Entry<? extends Object, ScaleTwoDecimal> entry : totals.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<? extends Object, ScaleTwoDecimal> entry : previous.entrySet()) {
            Object key = entry.getKey();
            ScaleTwoDecimal total = totals.get(key);
            if (total != null) {
                if (total == null) {
                    result.put(key, entry.getValue());
                } else {
                    result.put(key, total.add(entry.getValue()));
                }
            }
        }
        return result;
    }
    
    /**
     * Sums up the list of budget decimals included in the map and returns those totals.
     * This is used to sum up the summary totals included in the budget which is a  list
     * of totals per budget period
     * @param map
     * @return
     */
    protected SortedMap<? extends Object, ScaleTwoDecimal> getSumOfElements(Map<? extends Object, List<ScaleTwoDecimal>> map) {
        SortedMap<Object, ScaleTwoDecimal> result = new TreeMap<Object, ScaleTwoDecimal>();
        for (Map.Entry<? extends Object, List<ScaleTwoDecimal>> entry : map.entrySet()) {
            ScaleTwoDecimal total = ScaleTwoDecimal.ZERO;
            for (ScaleTwoDecimal amt : entry.getValue()) {
                total = total.add(amt);
            }
            //if the key is a string and has a comma, remove everything after the comma
            //this is for items aggregated by object code and person id. For this summary
            //we only care about the object code
            Object key = entry.getKey();
            if (key instanceof String) {
                String strKey = (String) entry.getKey();
                key = strKey.replaceAll(",.*", "");
            }
            result.put(key, total);
        }
        return result;
    }
    
    @Override
	protected Collection<? extends BudgetLineItem> getLineItemsFromDatabase(
			final BudgetPeriod budgetPeriod) {
		final Map<String, Object> fieldValues = new HashMap<>();

		fieldValues.put("budgetId", budgetPeriod.getBudgetId());
		fieldValues.put("budgetPeriod", budgetPeriod.getBudgetPeriod());
		

		final Collection<? extends BudgetLineItem> deletedLineItems
		    = this.getBusinessObjectService().findMatching(AwardBudgetLineItemExt.class, fieldValues);
		return deletedLineItems;
	}
}
