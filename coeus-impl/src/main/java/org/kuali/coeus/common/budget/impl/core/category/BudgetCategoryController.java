/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core.category;


import org.kuali.coeus.common.budget.framework.core.category.BudgetCategory;
import org.kuali.coeus.sys.framework.controller.rest.SimpleCrudDtoRestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller(value="budgetCategoryController")
@RequestMapping(value="/api/v1/budget-categories/")
public class BudgetCategoryController extends SimpleCrudDtoRestController<BudgetCategory, BudgetCategoryDto> {

	private static final String BUDGET_CATEGORY_DO_CLASS = "org.kuali.coeus.common.budget.framework.core.category.BudgetCategory";
	private static final String BUDGET_CATEGORY_DTO_CLASS = "org.kuali.coeus.common.budget.impl.core.category.BudgetCategoryDto";
	private static final String PRIMARY_KEY_COLUMN = "code";
	private static final String REGISTER_MAPPING = "false";

	@Value(BUDGET_CATEGORY_DO_CLASS)
	@Override
	public void setDataObjectClazz(Class<BudgetCategory> dataObjectClazz) {
		super.setDataObjectClazz(dataObjectClazz);
	}

	@Value(BUDGET_CATEGORY_DTO_CLASS)
	@Override
	public void setDtoObjectClazz(Class<BudgetCategoryDto> dtoObjectClazz) {
		super.setDtoObjectClazz(dtoObjectClazz);
	}

	@Value(PRIMARY_KEY_COLUMN)
	@Override
	public void setPrimaryKeyColumn(String primaryKeyColumn) {
		super.setPrimaryKeyColumn(primaryKeyColumn);
	}

	@Value(REGISTER_MAPPING)
	@Override
	public void setRegisterMapping(boolean registerMapping) {
		super.setRegisterMapping(registerMapping);
	}
}
