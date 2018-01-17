/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetCommonService;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;

public interface ProposalBudgetService extends BudgetCommonService<DevelopmentProposal> {

    /**
     *
     * This method returns the final version of {@link org.kuali.coeus.common.budget.framework.core.Budget} for a given {@link org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument}
     *
     * @param parentDocument The parent document that has the budget.
     * @return parentDocument final version of budget corresponding to the parentDocument object.
     */
    ProposalDevelopmentBudgetExt getFinalBudgetVersion(ProposalDevelopmentDocument parentDocument);
    
    /**
     * Copy the specified budget, using the optional developmentProposal as the new budget parent if provided.
     */
    ProposalDevelopmentBudgetExt copyBudgetVersion(ProposalDevelopmentBudgetExt budget, boolean onlyOnePeriod, DevelopmentProposal developmentProposal);

    boolean isBudgetMarkedForSubmission(Budget finalBudget, Budget currentBudget);

    void syncBudgetReferencesForCopy(ProposalDevelopmentBudgetExt budget);

    boolean validateCostShare(ProposalDevelopmentBudgetExt budget);

    }
