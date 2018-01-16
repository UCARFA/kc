/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetFormulatedCostDetail;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

public interface AwardBudgetPeriodCalculationService {

    public void calculateBudgetPeriod(boolean forceCalculation, Budget budget, BudgetPeriod budgetPeriod);

    public void calculateBudgetPeriod(Budget budget, BudgetPeriod budgetPeriod);

    public void recalculateBudgetPeriod(Budget budget, BudgetPeriod budgetPeriod);

    public void calculateAndUpdateFormulatedCost(BudgetLineItem budgetLineItem);

    public void calculateBudgetFormulatedCost( BudgetFormulatedCostDetail budgetFormulatedCost);

    public ScaleTwoDecimal getFormulatedCostsTotal(BudgetLineItem budgetLineItem);

}
