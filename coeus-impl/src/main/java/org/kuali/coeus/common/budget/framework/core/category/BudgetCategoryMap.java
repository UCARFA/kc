/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core.category;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.budget.api.core.category.BudgetCategoryMapContract;

import java.util.ArrayList;
import java.util.List;

public class BudgetCategoryMap extends KcPersistableBusinessObjectBase implements BudgetCategoryMapContract {

    private String mappingName;

    private String targetCategoryCode;

    private String categoryType;

    private String description;

    private List<BudgetCategoryMapping> budgetCategoryMappings;

    public BudgetCategoryMap() {
        budgetCategoryMappings = new ArrayList<BudgetCategoryMapping>();
    }

    @Override
    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }

    @Override
    public String getTargetCategoryCode() {
        return targetCategoryCode;
    }

    public void setTargetCategoryCode(String targetCategoryCode) {
        this.targetCategoryCode = targetCategoryCode;
    }

    @Override
    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<BudgetCategoryMapping> getBudgetCategoryMappings() {
        return budgetCategoryMappings;
    }


    public void setBudgetCategoryMappings(List<BudgetCategoryMapping> budgetCategoryMappings) {
        this.budgetCategoryMappings = budgetCategoryMappings;
    }
}
