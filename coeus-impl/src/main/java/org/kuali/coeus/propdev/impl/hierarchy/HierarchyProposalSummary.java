/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.hierarchy;

import java.io.Serializable;



public class HierarchyProposalSummary implements Serializable {

    private static final long serialVersionUID = -4513320772280178341L;

    private String proposalNumber;
    private Boolean synced;
    private String syncableBudgetDocumentNumber;
    private Boolean budgetSynced;

    /**
     * Gets the proposalNumber attribute.
     * 
     * @return Returns the proposalNumber.
     */
    public String getProposalNumber() {
        return proposalNumber;
    }

    /**
     * Sets the proposalNumber attribute value.
     * 
     * @param proposalNumber The proposalNumber to set.
     */
    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    /**
     * Sets the synced attribute value.
     * 
     * @param synced The synced to set.
     */
    public void setSynced(Boolean synced) {
        this.synced = synced;
    }

    /**
     * Gets the synced attribute.
     * 
     * @return Returns the synced.
     */
    public Boolean getSynced() {
        return synced;
    }

    public Boolean getBudgetSynced() {
        return budgetSynced;
    }

    public void setBudgetSynced(Boolean budgetSynced) {
        this.budgetSynced = budgetSynced;
    }

    public String getSyncableBudgetDocumentNumber() {
        return syncableBudgetDocumentNumber;
    }

    public void setSyncableBudgetDocumentNumber(String syncableBudgetDocumentNumber) {
        this.syncableBudgetDocumentNumber = syncableBudgetDocumentNumber;
    }
}
