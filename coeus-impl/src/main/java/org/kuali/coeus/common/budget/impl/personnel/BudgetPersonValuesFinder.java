/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.personnel;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetConstants;
import org.kuali.coeus.common.budget.framework.core.BudgetContainer;
import org.kuali.coeus.common.budget.framework.personnel.BudgetPerson;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.util.KNSGlobalVariables;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Finds the available set of supported Narrative Statuses.  See
 * the method <code>getKeyValues()</code> for a full description.
 * 
 * @author KRADEV team
 */
@Component("budgetPersonValuesFinder")
public class BudgetPersonValuesFinder extends UifKeyValuesFinderBase {
    
    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;
    /**
     * Constructs the list of Budget Persons.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * person sequence number and the "value" is the person name that is viewed
     * by a user.  The list is obtained from the BudgetDocument if any are defined there. 
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types.  The first entry
     * is always &lt;"", "select:"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        BudgetContainer form = (BudgetContainer) KNSGlobalVariables.getKualiForm();
    	Budget budget = form.getBudget();
        return buildKeyValues(budget.getBudgetPersons());
    }
    
    @Override
    public List<KeyValue> getKeyValues(ViewModel model) {
    	setAddBlankOption(false);
    	return buildKeyValues(((BudgetContainer) model).getBudget().getBudgetPersons());
    }

    private List<KeyValue> buildKeyValues(List<BudgetPerson> budgetPersons) {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        Set<String> distinctKeys = new HashSet<String>();
    	for(BudgetPerson budgetPerson : budgetPersons) {
    		boolean duplicatePerson = false;
            if (StringUtils.isNotBlank(budgetPerson.getJobCode()) && StringUtils.isNotBlank(budgetPerson.getAppointmentTypeCode()) && budgetPerson.getCalculationBase().isGreaterEqual(ScaleTwoDecimal.ZERO) && budgetPerson.getEffectiveDate() != null) {
            	duplicatePerson = !distinctKeys.add(getPersonUniqueKey(budgetPerson));
            }
            if (!duplicatePerson) {
            	keyValues.add(new ConcreteKeyValue(budgetPerson.getPersonSequenceNumber().toString(), getBudgetPersonLabel(budgetPerson)));
            }
    	}
    	keyValues.add(new ConcreteKeyValue(BudgetConstants.BudgetPerson.SUMMARYPERSON.getPersonId(), BudgetConstants.BudgetPerson.SUMMARYPERSON.getPersonName()));
        return keyValues;
    }
    
    private String getPersonUniqueKey(BudgetPerson budgetPerson) {
    	StringBuffer uniqueKey = new StringBuffer();
    	uniqueKey.append(budgetPerson.getPersonRolodexTbnId());
    	uniqueKey.append(budgetPerson.getJobCode());
    	uniqueKey.append(budgetPerson.getEffectiveDate());
        if(Objects.nonNull(budgetPerson.getTbnId())) {
            uniqueKey.append('-' + budgetPerson.getPersonSequenceNumber());
        }
    	return uniqueKey.toString();
    }
    
    protected String getBudgetPersonLabel(BudgetPerson budgetPerson) {
    	StringBuffer personLabel = new StringBuffer();
    	String personName = budgetPerson.getPersonName() != null ? budgetPerson.getPersonName() : "";
    	personLabel.append(personName);
    	if(budgetPerson.getJobCode() != null) {
        	personLabel.append(" (");
        	personLabel.append(budgetPerson.getJobCode());
        	personLabel.append(") ");
    	}
    	return personLabel.toString();
    }

	public DataObjectService getDataObjectService() {
		return dataObjectService;
	}

	public void setDataObjectService(DataObjectService dataObjectService) {
		this.dataObjectService = dataObjectService;
	}
}
