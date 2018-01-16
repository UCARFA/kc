/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

@Entity
@Table(name = "BUDGET_PERIOD_TYPE")
public class BudgetPeriodType extends KcPersistableBusinessObjectBase {

    @Id
    @Column(name = "BUDGET_PERIOD_TYPE_CODE")
    private String budgetPeriodTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getBudgetPeriodTypeCode() {
        return budgetPeriodTypeCode;
    }

    public void setBudgetPeriodTypeCode(String budgetPeriodTypeCode) {
        this.budgetPeriodTypeCode = budgetPeriodTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
