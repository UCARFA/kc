/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.common.budget.framework.nonpersonnel.AbstractBudgetCalculatedAmount;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.personnel.BudgetPersonnelDetails;

public class AwardBudgetLineItemExt extends BudgetLineItem {


    private static final long serialVersionUID = 6909566795823678487L;
    private ScaleTwoDecimal obligatedAmount;
    /**
     * 
     * This method is to create new BudgetpersonnelDetails object
     * @return
     */
    @Override
    public BudgetPersonnelDetails getNewBudgetPersonnelLineItem() {
        return new AwardBudgetPersonnelDetailsExt();
    }
    @Override
    public AbstractBudgetCalculatedAmount getNewBudgetLineItemCalculatedAmount() {
        return new AwardBudgetLineItemCalculatedAmountExt();
    }

    /**
     * Gets the obligatedAmount attribute. 
     * @return Returns the obligatedAmount.
     */
    public ScaleTwoDecimal getObligatedAmount() {
        return obligatedAmount==null? ScaleTwoDecimal.ZERO:obligatedAmount;
    }
    /**
     * Sets the obligatedAmount attribute value.
     * @param obligatedAmount The obligatedAmount to set.
     */
    public void setObligatedAmount(ScaleTwoDecimal obligatedAmount) {
        this.obligatedAmount = obligatedAmount;
    }
    
}
