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
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * The Budget Modify Authorizer checks to see if the user has 
 * the necessary permission to modify a specific budget.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class ViewAwardBudgetSalariesAuthorizer extends BudgetAuthorizer {

    @Override
    public boolean isAuthorized(String userId, Task task) {
            AwardBudgetTask budgetTask = (AwardBudgetTask) task;
            AwardBudgetDocument budgetDocument = budgetTask.getAwardBudgetDocument();
            return hasUnitPermission(userId, 
                    budgetDocument.getBudget().getBudgetParent().getDocument().getLeadUnitNumber(), 
                    Constants.MODULE_NAMESPACE_BUDGET, PermissionConstants.VIEW_SALARIES);
    }
}
