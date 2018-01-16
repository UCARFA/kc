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
import org.kuali.rice.kew.api.WorkflowDocument;

/**
 * This authorizer determines if the user has the permission
 * to reject a proposal.  You can reject if:
 * 1) The document does not have a completion requested.
 * 2) You have an approval pending on the document.
 * 3) The document state is enroute.
 * 
 * 
 */
public class RejectAwardBudgetAuthorizer extends BudgetAuthorizer {

    @Override
    public boolean isAuthorized(String username, Task task) {
    	if(task instanceof AwardBudgetTask) {
	        AwardBudgetDocument doc = ((AwardBudgetTask) task).getAwardBudgetDocument();
	        WorkflowDocument workDoc = doc.getDocumentHeader().getWorkflowDocument();
	        return !workDoc.isCompletionRequested() 
	            && workDoc.isApprovalRequested() 
	            && workDoc.isEnroute();
    	}
    	else { 
    		return super.isAuthorized(username, task);
    	}
    }
}
