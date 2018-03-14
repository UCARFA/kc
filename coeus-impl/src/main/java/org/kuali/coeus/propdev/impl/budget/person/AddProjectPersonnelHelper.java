/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.person;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.budget.framework.personnel.BudgetPerson;
import org.kuali.coeus.common.budget.framework.personnel.BudgetPersonnelDetails;
import org.kuali.coeus.common.budget.framework.personnel.TbnPerson;
import org.kuali.coeus.propdev.impl.budget.nonpersonnel.AddProjectBudgetLineItemHelper;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.krad.data.DataObjectService;


public class AddProjectPersonnelHelper extends AddProjectBudgetLineItemHelper {

	public static final String JOB_CODE_REF = "jobCodeRef";
	public static final String BUDGET_PERSON = "budgetPerson";

	private BudgetPerson editBudgetPerson;
    private transient DataObjectService dataObjectService;
    private List<TbnPerson> tbnPersons;
    private BudgetPersonnelDetails budgetPersonnelDetail;
    private BudgetPersonnelDetails editBudgetPersonnelDetail;
    private String budgetPersonGroupName;
    
    public AddProjectPersonnelHelper() {
       super();
       initPersonDetails();
    }
    
    @Override
    public void reset() {
        super.reset();
        initPersonDetails();
    }
    
    private void initPersonDetails() {
        editBudgetPerson = new BudgetPerson();
        budgetPersonnelDetail = new BudgetPersonnelDetails();
        editBudgetPersonnelDetail = new BudgetPersonnelDetails();
        budgetPersonGroupName=StringUtils.EMPTY;
        tbnPersons = new ArrayList<>();
    }
    
	public BudgetPerson getEditBudgetPerson() {
		return editBudgetPerson;
	}

	public void setEditBudgetPerson(BudgetPerson editBudgetPerson) {
		this.editBudgetPerson = editBudgetPerson;
	}

	public DataObjectService getDataObjectService() {
        if (dataObjectService == null) {
        	dataObjectService = KcServiceLocator.getService(DataObjectService.class);
        }
		return dataObjectService;
	}

	public void setDataObjectService(DataObjectService dataObjectService) {
		this.dataObjectService = dataObjectService;
	}

	public List<TbnPerson> getTbnPersons() {
		if(tbnPersons.isEmpty()) {
			this.tbnPersons = getDataObjectService().findAll(TbnPerson.class).getResults();
		}
		return tbnPersons;
	}

	public void setTbnPersons(List<TbnPerson> tbnPersons) {
		this.tbnPersons = tbnPersons;
	}

	public BudgetPersonnelDetails getBudgetPersonnelDetail() {
		return budgetPersonnelDetail;
	}

	public void setBudgetPersonnelDetail(
			BudgetPersonnelDetails budgetPersonnelDetail) {
		this.budgetPersonnelDetail = budgetPersonnelDetail;
	}

	public String getBudgetPersonGroupName() {
		return budgetPersonGroupName;
	}

	public void setBudgetPersonGroupName(String budgetPersonGroupName) {
		this.budgetPersonGroupName = budgetPersonGroupName;
	}
	
	public String getJobTitle() {
		if(getEditBudgetPerson().getJobCode() != null) {
			getDataObjectService().wrap(getEditBudgetPerson()).fetchRelationship(JOB_CODE_REF);
		}
		return getEditBudgetPerson().getJobCodeRef() != null ? getEditBudgetPerson().getJobCodeRef().getJobTitle() : StringUtils.EMPTY;
	}

	public String getAppointmentType() {
		getDataObjectService().wrap(getBudgetPersonnelDetail()).fetchRelationship(BUDGET_PERSON);
		BudgetPerson budgetPerson = getBudgetPersonnelDetail().getBudgetPerson();
		return budgetPerson != null ? budgetPerson.getAppointmentType().getDescription() : StringUtils.EMPTY;
	}

	public BudgetPersonnelDetails getEditBudgetPersonnelDetail() {
		return editBudgetPersonnelDetail;
	}

	public void setEditBudgetPersonnelDetail(
			BudgetPersonnelDetails editBudgetPersonnelDetail) {
		this.editBudgetPersonnelDetail = editBudgetPersonnelDetail;
	}

}
