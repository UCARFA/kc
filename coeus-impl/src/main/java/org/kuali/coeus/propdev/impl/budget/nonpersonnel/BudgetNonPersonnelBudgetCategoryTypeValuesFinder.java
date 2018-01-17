/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.nonpersonnel;

import org.kuali.coeus.common.budget.framework.core.category.BudgetCategoryTypeValuesFinder;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.api.criteria.Predicate;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("budgetNonPersonnelBudgetCategoryTypeValuesFinder")
public class BudgetNonPersonnelBudgetCategoryTypeValuesFinder extends BudgetCategoryTypeValuesFinder {
	@Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService;

	@Override
    public List<KeyValue> getKeyValues() {
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(PredicateFactory.notEqual("code", getPersonnelBudgetCategoryTypeCode()));
        List<KeyValue> keyValues = super.getKeyValues(predicates);
        keyValues.add(0, ValuesFinderUtils.getSelectOption());
        return keyValues;
    }

    private String getPersonnelBudgetCategoryTypeCode() {
        return this.getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_BUDGET, ParameterConstants.DOCUMENT_COMPONENT,Constants.BUDGET_CATEGORY_TYPE_PERSONNEL);
    }
    
	public ParameterService getParameterService() {
		return parameterService;
	}

	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

}
