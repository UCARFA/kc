/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.distribution;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetEventBase;
import org.kuali.coeus.common.budget.framework.distribution.BudgetUnrecoveredFandA;

public class AddBudgetUnrecoveredFandAEvent extends BudgetEventBase {
	
    private BudgetUnrecoveredFandA budgetUnrecoveredFandA;
    
    public AddBudgetUnrecoveredFandAEvent(Budget budget, BudgetUnrecoveredFandA budgetUnrecoveredFandA) {
        super(budget);
        this.budgetUnrecoveredFandA = budgetUnrecoveredFandA;
    }

    public BudgetUnrecoveredFandA getBudgetUnrecoveredFandA() {
        return budgetUnrecoveredFandA;
    }

	public void setBudgetUnrecoveredFandA(
			BudgetUnrecoveredFandA budgetUnrecoveredFandA) {
		this.budgetUnrecoveredFandA = budgetUnrecoveredFandA;
	}

}
