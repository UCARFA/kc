/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.dataoverride;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetForm;
import org.kuali.coeus.propdev.impl.dataovveride.common.AbstractDataOverrideInputField;


public class DataOverrideInputField extends AbstractDataOverrideInputField {

    @Override
    public String getEntryName() {
        return "Budget";
    }

    @Override
    public void performInitialization(Object model){
        if(!isInCollection()) {
            this.setDictionaryAttributeName(((ProposalBudgetForm)model).getNewBudgetChangedData().getAttributeName());
            if(this.getDictionaryAttributeName() == null) {
                this.setDictionaryAttributeName("title");
            }
        }
        this.setDictionaryObjectEntry(Budget.class.getName());


        super.performInitialization(model);
    }
}
