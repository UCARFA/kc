/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core;

import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetForm;
import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.keyvalue.KeyValueFinderService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.award.budget.document.AwardBudgetDocument;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.uif.view.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds the available set of supported Narrative Statuses.  See
 * the method <code>getKeyValues()</code> for a full description.
 * 
 * @author KRADEV team
 */
public class BudgetPeriodValuesFinder extends FormViewAwareUifKeyValuesFinderBase {
    KeyValueFinderService keyValueFinderService= (KeyValueFinderService) KcServiceLocator.getService("keyValueFinderService");
    
    /**
     * Constructs the list of Budget Periods.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * status code and the "value" is the textual description that is viewed
     * by a user.  The list is obtained from the BudgetDocument if any are defined there. 
     * Otherwise, it is obtained from a lookup of the BUDGET_PERIOD database table
     * via the "KeyValueFinderService".
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types.  The first entry
     * is always &lt;"", "select:"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    
    private String selectAllOption;
    
    public BudgetPeriodValuesFinder() {
    	this("Select");
    }
    
    public BudgetPeriodValuesFinder(String selectAllOption) {
    	this.selectAllOption = selectAllOption;
    }
    
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> KeyValues = null;

        Document doc = getDocument();
        if(doc instanceof AwardBudgetDocument) {
            List<BudgetPeriod> budgetPeriods = ((AwardBudgetDocument)doc).getBudget().getBudgetPeriods();
            if (budgetPeriods.size() > 0) {
                KeyValues = buildKeyValues(budgetPeriods);
            }
        }
        
        return KeyValues; 
    }
    private List<KeyValue> buildKeyValues(List<BudgetPeriod> budgetPeriods) {
        List<KeyValue> KeyValues = new ArrayList<KeyValue>();
        KeyValues.add(ValuesFinderUtils.getSelectOption());
        for(BudgetPeriod budgetPeriod: budgetPeriods) {
            KeyValues.add(new ConcreteKeyValue(budgetPeriod.getBudgetPeriod().toString(), budgetPeriod.getLabel()));
        }
        return KeyValues;
    }

    @Override
    public List<KeyValue> getKeyValues(ViewModel viewModel) {
        List<KeyValue> keyValues = null;
        List<BudgetPeriod> budgetPeriods = ((ProposalBudgetForm)viewModel).getBudget().getBudgetPeriods();
        if (budgetPeriods.size() > 0) {
            keyValues = buildKeyValues(budgetPeriods);
        }
        return keyValues;
    }
    
	public String getSelectAllOption() {
		return selectAllOption;
	}
	public void setSelectAllOption(String selectAllOption) {
		this.selectAllOption = selectAllOption;
	}
}
