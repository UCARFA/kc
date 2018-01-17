/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;


import org.kuali.coeus.common.budget.framework.calculator.BudgetCalculationService;
import org.kuali.coeus.common.budget.framework.core.*;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetFormulatedCostDetail;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.common.framework.ruleengine.KcBusinessRulesEngine;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component("awardBudgetPeriodCalculationService")
public class AwardBudgetPeriodCalculationServiceImpl implements AwardBudgetPeriodCalculationService {

    @Autowired
    @Qualifier("kcBusinessRulesEngine")
    private KcBusinessRulesEngine kcBusinessRulesEngine;

    @Autowired
    @Qualifier("budgetCalculationService")
    private BudgetCalculationService budgetCalculationService;


    @Override
    public void calculateBudgetPeriod(boolean forceCalculation, Budget budget, BudgetPeriod budgetPeriod) {
        budgetPeriod.setBudget(budget);
        for(BudgetLineItem budgetLineItem:budgetPeriod.getBudgetLineItems()){
            budgetCalculationService.updatePersonnelBudgetRate(budgetLineItem);
            if(budgetLineItem.getFormulatedCostElementFlag()){
                calculateAndUpdateFormulatedCost(budgetLineItem);
            }
        }
        if (kcBusinessRulesEngine.applyRules(new AwardBudgetSaveEvent(budget))) {
            if(forceCalculation){
                recalculateBudgetPeriod(budget, budgetPeriod);
            }else{
                calculateBudgetPeriod(budget, budgetPeriod);
            }
        }
    }

    @Override
    public void calculateBudgetPeriod(Budget budget, BudgetPeriod budgetPeriod) {
        budgetCalculationService.calculateBudgetPeriod(budget, budgetPeriod);
    }

    protected BudgetCommonService<BudgetParent> getBudgetCommonService(BudgetParent budgetParent) {
        return BudgetCommonServiceFactory.createInstance(budgetParent);
    }

    @Override
    public void recalculateBudgetPeriod(Budget budget, BudgetPeriod budgetPeriod) {
        getBudgetCommonService(budget.getBudgetParent()).recalculateBudgetPeriod(budget, budgetPeriod);
    }

    @Override
    public void calculateAndUpdateFormulatedCost(BudgetLineItem budgetLineItem) {
        if(budgetLineItem.getFormulatedCostElementFlag()){
            ScaleTwoDecimal formulatedCostTotal = getFormulatedCostsTotal(budgetLineItem);
            if(formulatedCostTotal!=null){
                budgetLineItem.setLineItemCost(formulatedCostTotal);
            }
        }
    }

    @Override
    public void calculateBudgetFormulatedCost(BudgetFormulatedCostDetail budgetFormulatedCost) {
        BigDecimal unitCost = budgetFormulatedCost.getUnitCost().bigDecimalValue();
        BigDecimal count = new ScaleTwoDecimal(budgetFormulatedCost.getCount()).bigDecimalValue();
        BigDecimal frequency = new ScaleTwoDecimal(budgetFormulatedCost.getFrequency()).bigDecimalValue();
        BigDecimal calculatedExpense = unitCost.multiply(count).multiply(frequency);
        budgetFormulatedCost.setCalculatedExpenses(new ScaleTwoDecimal(calculatedExpense));
    }


    @Override
    public ScaleTwoDecimal getFormulatedCostsTotal(BudgetLineItem budgetLineItem) {
        List<BudgetFormulatedCostDetail> budgetFormulatedCosts = budgetLineItem.getBudgetFormulatedCosts();
        ScaleTwoDecimal formulatedExpenses = ScaleTwoDecimal.ZERO;
        for (BudgetFormulatedCostDetail budgetFormulatedCostDetail : budgetFormulatedCosts) {
            calculateBudgetFormulatedCost(budgetFormulatedCostDetail);
            formulatedExpenses = formulatedExpenses.add(budgetFormulatedCostDetail.getCalculatedExpenses());
        }
        return formulatedExpenses;
    }


}
