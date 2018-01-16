/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget.document.authorizer;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.kra.award.budget.document.AwardBudgetDocument;
import org.kuali.kra.award.budget.document.authorization.AwardBudgetTask;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.infrastructure.AwardPermissionConstants;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.coreservice.framework.CoreFrameworkServiceLocator;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kew.api.WorkflowDocument;

/**
 * The AwardBudget Modify Authorizer checks to see if the user has 
 * the necessary permission to modify a specific budget.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class ToggleAwardBudgetStatusAuthorizer extends BudgetAuthorizer {

    @Override
    public boolean isAuthorized(String userId, Task task) {
        AwardBudgetTask budgetTask = (AwardBudgetTask) task;
        
        AwardBudgetDocument budgetDocument = budgetTask.getAwardBudgetDocument();
        AwardDocument doc = (AwardDocument) budgetDocument.getBudget().getBudgetParent().getDocument();
        WorkflowDocument workflowDoc = getWorkflowDocument(budgetDocument);
        return workflowDoc.isFinal() && isToggleAwardBudgetStatusValid(budgetDocument) &&
            hasUnitPermission(userId, doc.getLeadUnitNumber(), Constants.MODULE_NAMESPACE_AWARD_BUDGET, 
                AwardPermissionConstants.MAINTAIN_AWARD_BUDGET_ROUTING.getAwardPermission());
    }

    private boolean isToggleAwardBudgetStatusValid(AwardBudgetDocument budgetDocument) {
        String toBePostedStatusCode = getParameterService().getParameterValueAsString(AwardBudgetDocument.class, KeyConstants.AWARD_BUDGET_STATUS_TO_BE_POSTED);
        String doNotPostStatusCode = getParameterService().getParameterValueAsString(AwardBudgetDocument.class, KeyConstants.AWARD_BUDGET_STATUS_DO_NOT_POST);
        String budgetStatusCode = budgetDocument.getAwardBudget().getAwardBudgetStatusCode();
        return budgetStatusCode.equals(toBePostedStatusCode) || budgetStatusCode.equals(doNotPostStatusCode);
    }

    /**
     * Gets the parameterService attribute. 
     * @return Returns the parameterService.
     */
    public ParameterService getParameterService() {
        return CoreFrameworkServiceLocator.getParameterService();
    }

}
