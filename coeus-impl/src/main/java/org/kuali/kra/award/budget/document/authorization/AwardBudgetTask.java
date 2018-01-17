/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget.document.authorization;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.kra.award.budget.document.AwardBudgetDocument;
import org.kuali.kra.infrastructure.TaskGroupName;

public class AwardBudgetTask extends Task {
    
    private AwardBudgetDocument awardBudgetDocument;
    public AwardBudgetTask(String taskName, AwardBudgetDocument awardBudgetDocument) {
        super(TaskGroupName.AWARD_BUDGET, taskName);
        this.awardBudgetDocument = awardBudgetDocument;
    }
    /**
     * Gets the awardBudgetDocument attribute. 
     * @return Returns the awardBudgetDocument.
     */
    public AwardBudgetDocument getAwardBudgetDocument() {
        return awardBudgetDocument;
    }
    /**
     * Sets the awardBudgetDocument attribute value.
     * @param awardBudgetDocument The awardBudgetDocument to set.
     */
    public void setAwardBudgetDocument(AwardBudgetDocument awardBudgetDocument) {
        this.awardBudgetDocument = awardBudgetDocument;
    }

}
