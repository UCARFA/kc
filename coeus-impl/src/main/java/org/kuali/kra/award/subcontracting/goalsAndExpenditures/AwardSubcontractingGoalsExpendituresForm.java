/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.subcontracting.goalsAndExpenditures;

import org.kuali.kra.award.subcontracting.reporting.SubcontractingExpenditureCategoryAmounts;
import org.kuali.rice.kns.web.struts.form.KualiForm;

@SuppressWarnings("deprecation")
public class AwardSubcontractingGoalsExpendituresForm extends KualiForm {


    private static final long serialVersionUID = 4542622372669064380L;
    
    private boolean readOnly;
    private String awardNumber;
    private String awardId;
    private boolean displayGoalsExpendituresDetails;
    private boolean containingUnsavedChanges;
    
    private AwardSubcontractingBudgetedGoals awardSubcontractingBudgetedGoals;
    
    private SubcontractingExpenditureCategoryAmounts subcontractingExpenditureCategoryAmounts;  
    

    public AwardSubcontractingGoalsExpendituresForm() {
        this.setAwardSubcontractingBudgetedGoals(new AwardSubcontractingBudgetedGoals());
        this.setDisplayGoalsExpendituresDetails(true);
        
        this.setSubcontractingExpenditureCategoryAmounts(new SubcontractingExpenditureCategoryAmounts());
    }
    
    
    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardSubcontractingBudgetedGoals(AwardSubcontractingBudgetedGoals awardSubcontractingBudgetedGoals) {
        this.awardSubcontractingBudgetedGoals = awardSubcontractingBudgetedGoals;
    }

    public AwardSubcontractingBudgetedGoals getAwardSubcontractingBudgetedGoals() {
        return awardSubcontractingBudgetedGoals;
    }


    public void setDisplayGoalsExpendituresDetails(boolean displayGoalsExpendituresDetails) {
        this.displayGoalsExpendituresDetails = displayGoalsExpendituresDetails;
    }


    public boolean isDisplayGoalsExpendituresDetails() {
        return displayGoalsExpendituresDetails;
    }


    public void setContainingUnsavedChanges(boolean containingUnsavedChanges) {
        this.containingUnsavedChanges = containingUnsavedChanges;
    }


    public boolean isContainingUnsavedChanges() {
        return containingUnsavedChanges;
    }


    
    public void setSubcontractingExpenditureCategoryAmounts(SubcontractingExpenditureCategoryAmounts subcontractingExpenditureCategoryAmounts) {
        this.subcontractingExpenditureCategoryAmounts = subcontractingExpenditureCategoryAmounts;
    }


    public SubcontractingExpenditureCategoryAmounts getSubcontractingExpenditureCategoryAmounts() {
        return subcontractingExpenditureCategoryAmounts;
    }

}
