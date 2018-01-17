/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.modular;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

public interface BudgetModularService {

    void generateModularPeriod(BudgetPeriod budgetPeriod);

    BudgetModularSummary processModularSummary(Budget budget, boolean synchModular);

    void synchModularBudget(Budget budget, boolean recalculateFromModifiedDirectCost);

}
