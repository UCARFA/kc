/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;

import org.kuali.coeus.common.budget.api.personnel.BudgetPersonnelCalculatedAmountContract;
import org.kuali.coeus.common.budget.framework.nonpersonnel.AbstractBudgetCalculatedAmount;
import javax.persistence.*;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;

@Entity
@Table(name = "BUDGET_PERSONNEL_CAL_AMTS")
public class BudgetPersonnelCalculatedAmount extends AbstractBudgetCalculatedAmount implements BudgetPersonnelCalculatedAmountContract {

    private static final long serialVersionUID = 3100896964798965084L;

    @Column(name = "PERSON_NUMBER")
    private Integer personNumber;

    @PortableSequenceGenerator(name = "SEQ_BUDGET_PER_CAL_AMTS_ID")
    @GeneratedValue(generator = "SEQ_BUDGET_PER_CAL_AMTS_ID")
    @Id
    @Column(name = "BUDGET_PERSONNEL_CAL_AMTS_ID")
    private Long budgetPersonnelCalculatedAmountId;

    @Column(name = "BUDGET_PERSONNEL_DETAILS_ID", insertable = false, updatable = false)
    private Long budgetPersonnelLineItemId;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "BUDGET_PERSONNEL_DETAILS_ID", referencedColumnName = "BUDGET_PERSONNEL_DETAILS_ID")
    private BudgetPersonnelDetails budgetPersonnelLineItem;

    @Override
    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    @Override
    public Long getBudgetPersonnelCalculatedAmountId() {
        return budgetPersonnelCalculatedAmountId;
    }

    public void setBudgetPersonnelCalculatedAmountId(Long budgetPersonnelCalculatedAmountId) {
        this.budgetPersonnelCalculatedAmountId = budgetPersonnelCalculatedAmountId;
    }

    @Override
    public Long getBudgetPersonnelLineItemId() {
        return budgetPersonnelLineItemId;
    }

    public void setBudgetPersonnelLineItemId(Long budgetPersonnelLineItemId) {
        this.budgetPersonnelLineItemId = budgetPersonnelLineItemId;
    }

	public BudgetPersonnelDetails getBudgetPersonnelLineItem() {
		return budgetPersonnelLineItem;
	}

	public void setBudgetPersonnelLineItem(
			BudgetPersonnelDetails budgetPersonnelLineItem) {
		this.budgetPersonnelLineItem = budgetPersonnelLineItem;
	}

	@Override
    public Long getBudgetLineItemId() {
        return getBudgetPersonnelLineItem().getBudgetLineItemId();
    }

}
