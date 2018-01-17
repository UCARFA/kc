/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.nonpersonnel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.kuali.coeus.common.budget.api.nonpersonnel.BudgetLineItemCalculatedAmountContract;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;

@Entity
@Table(name = "BUDGET_DETAILS_CAL_AMTS")
public class BudgetLineItemCalculatedAmount extends AbstractBudgetCalculatedAmount implements BudgetLineItemCalculatedAmountContract {

    @PortableSequenceGenerator(name = "SEQ_BUDGET_DETAILS_CAL_AMTS_ID")
    @GeneratedValue(generator = "SEQ_BUDGET_DETAILS_CAL_AMTS_ID")
    @Id
    @Column(name = "BUDGET_DETAILS_CAL_AMTS_ID")
    private Long budgetLineItemCalculatedAmountId;
    
    @Column(name = "BUDGET_DETAILS_ID", insertable = false, updatable = false)
    private Long budgetLineItemId;    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "BUDGET_DETAILS_ID", referencedColumnName = "BUDGET_DETAILS_ID")
    private BudgetLineItem budgetLineItem;
    
    private static final long serialVersionUID = -1755216989884993632L;

    public BudgetLineItemCalculatedAmount() {
    }

    @Override
    public Long getBudgetLineItemCalculatedAmountId() {
        return budgetLineItemCalculatedAmountId;
    }

    public void setBudgetLineItemCalculatedAmountId(Long budgetLineItemCalculatedAmountId) {
        this.budgetLineItemCalculatedAmountId = budgetLineItemCalculatedAmountId;
    }

    @Override
    public Long getBudgetLineItemId() {
        return budgetLineItemId;
    }

    public void setBudgetLineItemId(Long budgetLineItemId) {
        this.budgetLineItemId = budgetLineItemId;
    }

	public BudgetLineItem getBudgetLineItem() {
		return budgetLineItem;
	}

	public void setBudgetLineItem(BudgetLineItem budgetLineItem) {
		this.budgetLineItem = budgetLineItem;
	}
}
