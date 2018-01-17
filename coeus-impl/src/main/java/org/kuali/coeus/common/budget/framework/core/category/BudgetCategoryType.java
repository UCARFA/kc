/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core.category;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.budget.api.core.category.BudgetCategoryTypeContract;
import org.kuali.coeus.common.budget.framework.core.BudgetConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class representation of the BudgetCategory Type Business Object
 */
@Entity
@Table(name = "BUDGET_CATEGORY_TYPE")
public class BudgetCategoryType extends KcPersistableBusinessObjectBase implements Comparable<BudgetCategoryType>, BudgetCategoryTypeContract {

    @Id
    @Column(name = "BUDGET_CATEGORY_TYPE_CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SORT_ID")
    private Integer sortId;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    /**
     * This is for totals page 
     */
    @Override
    public int compareTo(BudgetCategoryType o) {
    	return new CompareToBuilder().append(this.sortId, o.sortId).toComparison();
    }

    public boolean isCategoryParticipantSupport() {
    	return getCode().equalsIgnoreCase(BudgetConstants.BUDGET_CATEGORY_TYPE_PARTICIPANT_SUPPORT);
    }
    
}
