/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget.document.authorizer;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.coeus.common.budget.framework.core.Budget;

/**
 * A Budget Task is a task that performs an action against a
 * Budget Document.  To assist authorization, the
 * Budget Document is available.
 */
public final class BudgetTask extends Task {
    
    private Budget budget;
    
    /**
     * Constructs a BudgetTask.
     * @param taskName the name of the task
     * @param taskGroupName the name of the task group
     * @param budgetDocument the Budget Document
     */
    public BudgetTask(String taskGroupName, String taskName, Budget budget) {
        super(taskGroupName,taskName);
        this.budget = budget;
    }    
    /**
     * Get the Budget Document.
     * @return the Budget Document
     */
    public Budget getBudget() {
        return budget;
    }
}
