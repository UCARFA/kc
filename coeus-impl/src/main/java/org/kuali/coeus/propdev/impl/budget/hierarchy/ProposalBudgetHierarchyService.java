/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.hierarchy;

import java.util.List;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.hierarchy.ProposalHierarchyErrorWarningDto;
import org.kuali.coeus.propdev.impl.hierarchy.ProposalHierarchyException;

public interface ProposalBudgetHierarchyService {
	
	/**
	 * Persists changes to child proposal and budget, but does not persist changes to hierarchy proposal. Caller is responsible for this
	 */
	void synchronizeAllChildBudgets(DevelopmentProposal hierarchyProposal);

	/**
	 * Does not persist changes to either proposal. Caller is responsible for this.
	 */
    void synchronizeChildBudget(DevelopmentProposal hierarchyProposal, DevelopmentProposal childProposal, List<BudgetPeriod> oldBudgetPeriods);
    
    /**
     * Does not persist changes to proposal or budget. Caller is responsible for this.
     */
    void synchronizeChildBudget(DevelopmentProposal hierarchyProposal, ProposalDevelopmentBudgetExt budget);
    
    void persistProposalHierarchyBudget(DevelopmentProposal hierarchyProposal);

    void removeMergeableChildBudgetElements(ProposalDevelopmentBudgetExt parentBudget);

    void removeChildBudgetElements(DevelopmentProposal parentProposal, ProposalDevelopmentBudgetExt parentBudget, String childProposalNumber);
    
    void initializeBudget (DevelopmentProposal hierarchyProposal, DevelopmentProposal childProposal) throws ProposalHierarchyException;
 
    List<ProposalHierarchyErrorWarningDto> validateChildBudgetPeriods(DevelopmentProposal hierarchyProposal,
            DevelopmentProposal childProposal, boolean allowEndDateChange) throws ProposalHierarchyException;
    
    ProposalDevelopmentBudgetExt getHierarchyBudget(DevelopmentProposal hierarchyProposal) throws ProposalHierarchyException;
    
    ProposalDevelopmentBudgetExt getSyncableBudget(DevelopmentProposal childProposal) throws ProposalHierarchyException;
    
    int computeHierarchyHashCode(Budget budget);
    
    List<ProposalDevelopmentBudgetExt> getHierarchyBudgets(DevelopmentProposal hierarchyProposal) throws ProposalHierarchyException;
}
