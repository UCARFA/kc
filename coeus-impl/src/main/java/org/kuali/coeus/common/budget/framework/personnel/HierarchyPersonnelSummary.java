/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;

import org.kuali.coeus.common.budget.framework.core.Budget;

import java.io.Serializable;
import java.util.List;

public class HierarchyPersonnelSummary implements Serializable {

    private static final long serialVersionUID = -460546077977104498L;
    
    private String proposalNumber;
    private List<Budget> hierarchyBudgets;
    
    public String getProposalNumber() {
        return proposalNumber;
    }
    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }
    public List<Budget> getHierarchyBudgets() {
        return hierarchyBudgets;
    }
    public void setHierarchyBudgets(List<Budget> budgets) {
        this.hierarchyBudgets = budgets;
    }

}
