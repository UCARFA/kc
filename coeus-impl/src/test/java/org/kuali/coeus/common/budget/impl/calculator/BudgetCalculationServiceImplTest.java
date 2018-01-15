/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2018 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kuali.coeus.common.budget.impl.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetCommonService;
import org.kuali.coeus.common.budget.framework.core.BudgetCommonServiceFactory;
import org.kuali.coeus.common.budget.framework.core.CostElement;
import org.kuali.coeus.common.budget.framework.core.category.BudgetCategory;
import org.kuali.coeus.common.budget.framework.core.category.BudgetCategoryType;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.kra.award.budget.AwardBudgetExt;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.service.LegacyAppFrameworkAdapterService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@PrepareForTest({ BudgetCommonServiceFactory.class, KNSServiceLocator.class })
@RunWith(PowerMockRunner.class)
public class BudgetCalculationServiceImplTest {

    private static final String FACULTY_CATEGORY_CODE = "Faculty";
    private static final String PERSONNEL_CATEGORY_TYPE_CODE = "P";
    private static final String TEST_OBJECT_DESCRIPTION = "Test";
    private static final String TEST_OBJECT_CODE = "TEST";

    @Mock
    private BudgetCommonService budgetCommonService;

    @Mock
    private DataObjectService dataObjectService;

    @Mock
    private ParameterService parameterService;

    @InjectMocks
    private BudgetCalculationServiceImpl budgetCalculationService;

    private int lineItemNumber;
    private BudgetCategoryType personnelCategoryType;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        PowerMockito.mockStatic(KNSServiceLocator.class);
        when(KNSServiceLocator.getLegacyAppFrameworkAdapterService()).thenReturn(mock(LegacyAppFrameworkAdapterService.class));

        PowerMockito.mockStatic(BudgetCommonServiceFactory.class);
        when(BudgetCommonServiceFactory.createInstance(any())).thenReturn(budgetCommonService);

        personnelCategoryType = new BudgetCategoryType();
        personnelCategoryType.setCode(PERSONNEL_CATEGORY_TYPE_CODE);

        when(budgetCommonService.isRateOverridden(any())).thenReturn(false);
        when(dataObjectService.find(BudgetCategoryType.class, PERSONNEL_CATEGORY_TYPE_CODE))
                .thenReturn(personnelCategoryType);
        when(parameterService.getParameterValueAsString(Constants.MODULE_NAMESPACE_BUDGET, ParameterConstants.DOCUMENT_COMPONENT, Constants.BUDGET_CATEGORY_TYPE_PERSONNEL))
                .thenReturn(PERSONNEL_CATEGORY_TYPE_CODE);

        lineItemNumber = 1;
    }

    @Test
    public void testBudgetSummaryTotalsCalculatedCorrectlyForSummaryPersonnel() {
        Budget budget = budget(
                lineItem(TEST_OBJECT_CODE, new ScaleTwoDecimal(2000)),
                lineItem(TEST_OBJECT_CODE, new ScaleTwoDecimal(3000))
        );
        budgetCalculationService.calculateBudgetSummaryTotals(budget);
        assertEquals(new ScaleTwoDecimal(5000), budget.getBudgetSummaryTotals().get("personnelSalaryTotals").get(0));
    }

    private BudgetLineItem lineItem(String objectCode, ScaleTwoDecimal cost) {
        BudgetLineItem lineItem = new BudgetLineItem();
        BudgetCategoryType budgetCategoryType = personnelCategoryType;
        BudgetCategory budgetCategory = new BudgetCategory();
        budgetCategory.setCode(FACULTY_CATEGORY_CODE);
        budgetCategory.setBudgetCategoryType(budgetCategoryType);
        budgetCategory.setBudgetCategoryTypeCode(budgetCategoryType.getCode());
        CostElement costElement = new CostElement();
        costElement.setCostElement(objectCode);
        costElement.setBudgetCategory(budgetCategory);
        costElement.setBudgetCategoryCode(budgetCategory.getCode());
        costElement.setBudgetCategoryTypeCode(budgetCategoryType.getCode());
        costElement.setDescription(TEST_OBJECT_DESCRIPTION);
        lineItem.setCostElementBO(costElement);
        lineItem.setCostElement(objectCode);
        lineItem.setLineItemCost(cost);
        lineItem.setLineItemNumber(lineItemNumber);
        lineItemNumber++;
        return lineItem;
    }

    private Budget budget(BudgetLineItem... lineItems) {
        Budget budget = new AwardBudgetExt();

        BudgetPeriod period = new BudgetPeriod();
        period.setBudgetPeriod(1);
        period.getBudgetLineItems().addAll(Arrays.asList(lineItems));
        budget.getBudgetPeriods().add(period);

        budget.setBudgetCalculationService(budgetCalculationService);

        return budget;
    }

}
