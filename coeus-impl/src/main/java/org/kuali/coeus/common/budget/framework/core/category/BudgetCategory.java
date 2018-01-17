/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core.category;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.budget.api.core.category.BudgetCategoryContract;

import javax.persistence.*;

@Entity
@Table(name = "BUDGET_CATEGORY")
public class BudgetCategory extends KcPersistableBusinessObjectBase implements BudgetCategoryContract {

    @Id
    @Column(name = "BUDGET_CATEGORY_CODE")
    private String code;

    @Column(name = "CATEGORY_TYPE")
    private String budgetCategoryTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "CATEGORY_TYPE", referencedColumnName = "BUDGET_CATEGORY_TYPE_CODE", insertable = false, updatable = false)
    private BudgetCategoryType budgetCategoryType;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBudgetCategoryTypeCode() {
        return budgetCategoryTypeCode;
    }

    public void setBudgetCategoryTypeCode(String budgetCategoryTypeCode) {
        this.budgetCategoryTypeCode = budgetCategoryTypeCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public BudgetCategoryType getBudgetCategoryType() {
        return budgetCategoryType;
    }

    public void setBudgetCategoryType(BudgetCategoryType budgetCategoryType) {
        this.budgetCategoryType = budgetCategoryType;
    }
}
