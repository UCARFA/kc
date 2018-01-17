/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.onlinereview.authorization;

import org.kuali.coeus.common.framework.auth.KcTransactionalDocumentAuthorizerBase;
import org.kuali.coeus.common.framework.auth.task.ApplicationTask;
import org.kuali.coeus.common.framework.auth.task.TaskAuthorizationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.ProtocolOnlineReviewDocument;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kns.authorization.AuthorizationConstants;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.HashSet;
import java.util.Set;

public class ProtocolOnlineReviewDocumentAuthorizer extends KcTransactionalDocumentAuthorizerBase {

    private transient KcWorkflowService kraWorkflowService;
    
    @Override
    public Set<String> getEditModes(Document document, Person user, Set<String> currentEditModes) {
        Set<String> editModes = new HashSet<String>();
        
        ProtocolOnlineReviewDocument protocolOnlineReviewDocument = (ProtocolOnlineReviewDocument) document;
        String userId = user.getPrincipalId();
        
        if (canExecuteProtocolOnlineReviewTask(userId, protocolOnlineReviewDocument, TaskName.MAINTAIN_PROTOCOL_ONLINEREVIEWS)) {  
            editModes.add(AuthorizationConstants.EditMode.FULL_ENTRY);
        } else if (canExecuteProtocolOnlineReviewTask( userId, protocolOnlineReviewDocument, TaskName.MODIFY_PROTOCOL_ONLINEREVIEW)
                   && getKraWorkflowService().isUserApprovalRequested(protocolOnlineReviewDocument, GlobalVariables.getUserSession().getPrincipalId())) {
            editModes.add(AuthorizationConstants.EditMode.FULL_ENTRY);
        } else if (canExecuteProtocolOnlineReviewTask(userId, protocolOnlineReviewDocument, TaskName.VIEW_PROTOCOL_ONLINEREVIEW)) {
            editModes.add(AuthorizationConstants.EditMode.VIEW_ONLY);
        } else {
            editModes.add(AuthorizationConstants.EditMode.UNVIEWABLE);
        }
            
        return editModes;
    }

    @Override
    public boolean canInitiate(String documentTypeName, Person user) {
        return true;
    }


    @Override
    public boolean canOpen(Document document, Person user) {
        ProtocolOnlineReviewDocument protocolOnlineReviewDocument = (ProtocolOnlineReviewDocument) document;
        if (protocolOnlineReviewDocument.getProtocolOnlineReview() == null) {
            return canCreateProtocolOnlineReview(user);
        }
        return canExecuteProtocolOnlineReviewTask(user.getPrincipalId(), (ProtocolOnlineReviewDocument) document, TaskName.VIEW_PROTOCOL_ONLINEREVIEW);
    }
    
    /**
     * Does the user have permission to create a protocol?
     * @param user the user
     * @return true if the user can create a protocol; otherwise false
     */
    private boolean canCreateProtocolOnlineReview(Person user) {
        ApplicationTask task = new ApplicationTask(TaskName.CREATE_PROTOCOL_ONLINEREVIEW);       
        TaskAuthorizationService taskAuthenticationService = KcServiceLocator.getService(TaskAuthorizationService.class);
        return taskAuthenticationService.isAuthorized(user.getPrincipalId(), task);
    }
    
    /**
     * Does the user have permission to execute the given task for a protocol?
     * @param username the user's username
     * @param doc the protocol document
     * @param taskName the name of the task
     * @return true if has permission; otherwise false
     */
    private boolean canExecuteProtocolOnlineReviewTask(String userId, ProtocolOnlineReviewDocument doc, String taskName) {
        ProtocolOnlineReviewTask task = new ProtocolOnlineReviewTask(taskName, (ProtocolOnlineReview)doc.getProtocolOnlineReview());       
        TaskAuthorizationService taskAuthenticationService = KcServiceLocator.getService(TaskAuthorizationService.class);
        return taskAuthenticationService.isAuthorized(userId, task);
    }
    
    @Override
    public boolean canEdit(Document document, Person user) {
        return canExecuteProtocolOnlineReviewTask(user.getPrincipalId(), (ProtocolOnlineReviewDocument) document, TaskName.MODIFY_PROTOCOL_ONLINEREVIEW) 
               || canExecuteProtocolOnlineReviewTask(user.getPrincipalId(), (ProtocolOnlineReviewDocument) document, TaskName.MAINTAIN_PROTOCOL_ONLINEREVIEWS); 
    }
    
    @Override
    public boolean canSave(Document document, Person user) {
        return canEdit(document, user);
    }
    
    @Override
    public boolean canCopy(Document document, Person user) {
        return false;
    }
    
    @Override
    public boolean canCancel(Document document, Person user) {
        return false;
    }
    
    @Override
    public boolean canRoute(Document document, Person user) {
        return false;
    }
    
    @Override
    public boolean canApprove(Document document, Person user) {
       return super.canApprove(document, user);
    } 
    
    //we only let the IRB Admin disapprove these documents.
    @Override
    public boolean canDisapprove(Document document, Person user) {
        boolean result = super.canDisapprove(document, user);
        result &= canExecuteProtocolOnlineReviewTask(user.getPrincipalId(), (ProtocolOnlineReviewDocument) document, TaskName.MAINTAIN_PROTOCOL_ONLINEREVIEWS); 
        return result;
    }
    
    private KcWorkflowService getKraWorkflowService() {
        if (kraWorkflowService==null) {
            kraWorkflowService = KcServiceLocator.getService(KcWorkflowService.class);
        }
        return kraWorkflowService;
    }

    @Override
    public boolean canSendNoteFyi(Document document, Person user) {
        return false;
    }
    
    @Override
    public boolean canFyi(Document document, Person user) {
        return false;
    }

    
}
