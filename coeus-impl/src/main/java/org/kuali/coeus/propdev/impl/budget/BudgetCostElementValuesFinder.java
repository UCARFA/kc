/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget;

import org.kuali.coeus.common.budget.impl.core.CostElementValuesFinder;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetForm;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("budgetCostElementValuesFinder")
public class BudgetCostElementValuesFinder extends CostElementValuesFinder {
    @Override
    public List<KeyValue> getKeyValues(ViewModel model) {
        String budgetCategoryCode = ((ProposalBudgetForm)model).getAddProjectBudgetLineItemHelper().getBudgetLineItem().getBudgetCategoryCode();
        String budgetCategoryTypeCode = ((ProposalBudgetForm)model).getAddProjectBudgetLineItemHelper().getBudgetCategoryTypeCode();

        return super.getKeyValues(budgetCategoryTypeCode, true ,budgetCategoryCode);

    }
}
