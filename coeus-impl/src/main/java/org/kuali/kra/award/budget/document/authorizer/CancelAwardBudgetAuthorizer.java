/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget.document.authorizer;



import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.workflow.KcDocumentRejectionService;
import org.kuali.kra.award.budget.document.AwardBudgetDocument;
import org.kuali.kra.award.budget.document.authorization.AwardBudgetTask;
import org.kuali.rice.kew.api.WorkflowDocument;

/**
 * This authorizer determines if the user has the permission
 * to cancel an award budget. This is only for after the 
 * budget has been submitted into workflow and is to
 * authorize the routing user to pull back the budget
 * using a super user action
 * 
 */
public class CancelAwardBudgetAuthorizer extends BudgetAuthorizer {
    
    private KcDocumentRejectionService kraDocumentRejectionService;

    public boolean isAuthorized(String username, AwardBudgetTask task) {
        AwardBudgetDocument doc = task.getAwardBudgetDocument();
        WorkflowDocument workDoc = doc.getDocumentHeader().getWorkflowDocument();
        return !workDoc.isCompletionRequested() 
            && !getKraDocumentRejectionService().isDocumentOnInitialNode(doc.getDocumentHeader().getWorkflowDocument())
            && StringUtils.equals(username, workDoc.getRoutedByPrincipalId())
            && workDoc.isEnroute();
    }
    
    protected KcDocumentRejectionService getKraDocumentRejectionService() {
        return kraDocumentRejectionService;
    }
    public void setKraDocumentRejectionService(KcDocumentRejectionService kraDocumentRejectionService) {
        this.kraDocumentRejectionService = kraDocumentRejectionService;
    }
    
    
}
