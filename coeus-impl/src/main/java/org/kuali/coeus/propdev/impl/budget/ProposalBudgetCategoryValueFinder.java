/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.budget.framework.core.category.BudgetCategoryValuesFinder;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetForm;
import org.kuali.rice.core.api.criteria.Predicate;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("proposalBudgetCategoryValueFinder")
public class ProposalBudgetCategoryValueFinder extends BudgetCategoryValuesFinder {

    public static final String BUDGET_CATEGORY_TYPE_CODE = "budgetCategoryTypeCode";
    public static final String SELECT = "Select";

    @Override
    public List<KeyValue> getKeyValues(ViewModel model) {
        List<KeyValue> keyValues = super.getKeyValues(getPredicates((ProposalBudgetForm) model));
        keyValues.add(0, new ConcreteKeyValue(StringUtils.EMPTY, SELECT));
        return keyValues;
    }

    protected List<Predicate> getPredicates(ProposalBudgetForm model) {
        String budgetCategoryTypeCode = model.getAddProjectBudgetLineItemHelper().getBudgetCategoryTypeCode();
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotEmpty(budgetCategoryTypeCode)) {
            predicates.add(PredicateFactory.equal(BUDGET_CATEGORY_TYPE_CODE, budgetCategoryTypeCode));
        }
        return predicates;
    }
}
