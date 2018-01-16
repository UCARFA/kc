/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.copy;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.krad.bo.BusinessObjectBase;

/**
 * The <b>ProposalCopyCriteria</b> is user-specified criteria used
 * when copying a proposal development document.  There are four 
 * criteria.
 * <ul>
 * <li>Include Attachments: should attachments also be copied?</li>
 * <li>Include Budget: should the budget(s) also be copied?</li>
 * <li>Include Questionnaires:  Should the questionnaires also be copied if possible?</li>
 * <li>Budget Versions: if the budget(s) is copied, do we copy all of the versions or only the final version?</li>
 * </ul>
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class ProposalCopyCriteria extends BusinessObjectBase {
    
    /**
     * <code>BUDGET_ALL_VERSIONS</code> is the value for BudgetVersions
     * to indicate that all budget versions are to be copied.
     */
    public static final String BUDGET_ALL_VERSIONS = "ALL";
    
    /**
     * <code>BUDGET_FINAL_VERSION</code> is the value for BudgetVersions
     * to indicate that only the final budget is to be copied.
     */
    public static final String BUDGET_FINAL_VERSION = "FINAL";
    
    private boolean includeAttachments;
    private boolean includeBudget;
    private boolean includeQuestionnaire;
    private String budgetVersions;
    private String leadUnitNumber;
    private String originalLeadUnitNumber;


    public ProposalCopyCriteria() {
        this.includeAttachments = false;
        this.includeBudget = false;
        this.includeQuestionnaire = true;
        this.budgetVersions = BUDGET_ALL_VERSIONS;
        this.leadUnitNumber = "";
        this.originalLeadUnitNumber = "";
    }

    /**
     * Constructs a ProposalCopyCriteria.
     * @param doc the proposal development document
     */
    public ProposalCopyCriteria(ProposalDevelopmentDocument doc) {
        this.includeAttachments = false;
        this.includeBudget = false;
        this.budgetVersions = BUDGET_ALL_VERSIONS;
        this.leadUnitNumber = "";
        this.includeQuestionnaire = true;
        this.originalLeadUnitNumber = doc.getDevelopmentProposal().getOwnedByUnitNumber();
    }
    
    /**
     * Get the Include Attachments.
     * 
     * @return true to copy the attachments; otherwise false.
     */
    public boolean getIncludeAttachments() {
        return includeAttachments;
    }

    /**
     * Gets the includeQuestionnaires attribute. 
     * @return Returns the includeQuestionnaires.
     */
    public boolean getIncludeQuestionnaire() {
        return includeQuestionnaire;
    }

    /**
     * Sets the includeQuestionnaires attribute value.
     * @param includeQuestionnaire The includeQuestionnaires to set.
     */
    public void setIncludeQuestionnaire(boolean includeQuestionnaire) {
        this.includeQuestionnaire = includeQuestionnaire;
    }

    /**
     * Set the Include Attachments.
     * 
     * @param includeAttachments set to true to copy the attachments; otherwise false.
     */
    public void setIncludeAttachments(boolean includeAttachments) {
        this.includeAttachments = includeAttachments;
    }

    /**
     * Get the Include Budget.
     * 
     * @return true to copy the budget(s); otherwise false.
     */
    public boolean getIncludeBudget() {
        return includeBudget;
    }

    /**
     * Set the Include Budget.
     * 
     * @param includeBudget set to true to copy the budget(s); otherwise false.
     */
    public void setIncludeBudget(boolean includeBudget) {
        this.includeBudget = includeBudget;
    }

    /**
     * Get the Budget Versions.  Only applicable if IncludeBudget is true.
     * 
     * @return the budget version(s) to copy: all or final.
     */
    public String getBudgetVersions() {
        return budgetVersions;
    }

    /**
     * Set the Budget Versions.  Only applicable if IncludeBudget is true.
     * 
     * @param budgetVersions set to all (BUDGET_ALL_VERSIONS) or final (BUDGET_FINAL_VERSION).
     */
    public void setBudgetVersions(String budgetVersions) {
        this.budgetVersions = budgetVersions;
    }

    /**
     * Get the lead unit number.
     * @return the lead unit number
     */
    public String getLeadUnitNumber() {
        return leadUnitNumber;
    }

    /**
     * Set the lead unit number.
     * @param leadUnitNumber the lead unit number
     */
    public void setLeadUnitNumber(String leadUnitNumber) {
        this.leadUnitNumber = leadUnitNumber;
    }
    
    /**
     * Get the original lead unit number.
     * @return the original lead unit number
     */
    public String getOriginalLeadUnitNumber() {
        return this.originalLeadUnitNumber;
    }
    
    /**
     * Set the original lead unit number.
     * @param originalLeadUnitNumber the original lead unit number
     */
    public void setOriginalLeadUnitNumber(String originalLeadUnitNumber) {
        this.originalLeadUnitNumber = originalLeadUnitNumber;
    }

    @Override
    public void refresh() {
        // do nothing
    }
}
