/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.subaward.document.authorization;

import java.util.HashSet;
import java.util.Set;

import org.kuali.coeus.common.framework.auth.KcTransactionalDocumentAuthorizerBase;
import org.kuali.coeus.common.framework.auth.task.ApplicationTask;
import org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kns.authorization.AuthorizationConstants;
import org.kuali.rice.krad.document.Document;


public class SubAwardDocumentAuthorizer
extends KcTransactionalDocumentAuthorizerBase {

	/**.
	 * Thismethod is for getting edit modes
	 * @param document the Document
	 * @param user the Person
	 * @param currentEditModes
	 *  the currentEditmodes ...
	 */
    @Override
    public Set<String> getEditModes(
    Document document, Person user, Set<String> currentEditModes) {
        Set<String> editModes = new HashSet<String>();
        String userId = user.getPrincipalId();

        SubAwardDocument subawardDocument = (SubAwardDocument) document;

        if (subawardDocument.getSubAward().getSubAwardId() == null) {
            if (canCreateSubAward(user.getPrincipalId())) {
        editModes.add(AuthorizationConstants.EditMode.FULL_ENTRY);
            } else {
                editModes.add(AuthorizationConstants.EditMode.UNVIEWABLE);
            }
        } else {
            if (canExecuteSubAwardTask(userId,
            subawardDocument, TaskName.MODIFY_SUBAWARD)) {
                editModes.add(AuthorizationConstants.EditMode.FULL_ENTRY);
            } else if (canExecuteSubAwardTask(
            	userId, subawardDocument, TaskName.VIEW_SUBAWARD)) {
                editModes.add(AuthorizationConstants.EditMode.VIEW_ONLY);
            } else {
                editModes.add(AuthorizationConstants.EditMode.UNVIEWABLE);
            }
            if (canExecuteSubAwardTask(userId,
            	subawardDocument, TaskName.CREATE_SUBAWARD)) {
                editModes.add("createSubaward");
            }
        }

        return editModes;
    }



    /**.
     * This method is for checking whether user
     * can execute subAwardtask SubAwardDocument
     * @param taskName the taskName
     * @param userId the userId
     * @return boolean
     */
    private boolean canExecuteSubAwardTask(String userId,
    SubAwardDocument subawardDocument, String taskName) {
        SubAwardTask task = new SubAwardTask(taskName, subawardDocument);
        return this.getTaskAuthorizationService().isAuthorized(userId, task);
    }

    /**
     * Does the user have permission to create a Subaward?
     * @param userId the userId
     * @return true if the user can create a award; otherwise false
     */
    private boolean canCreateSubAward(String userId) {
        ApplicationTask task = new ApplicationTask(TaskName.CREATE_SUBAWARD);
        return getTaskAuthorizationService().isAuthorized(userId, task);
    }

    /**
     * This method is for checking whether user can open
     * @param document the Document
     * @param user the Person
     * @return boolean
     */
    @Override
    public boolean canOpen(Document document, Person user) {
        SubAwardDocument subAwardDocument = (SubAwardDocument) document;
        if (subAwardDocument.getSubAward().getSubAwardId() == null) {
            return canCreateSubAward(user.getPrincipalId());
        }
        return canExecuteSubAwardTask(user.getPrincipalId(),
                (SubAwardDocument) document, TaskName.VIEW_SUBAWARD);
    }

    @Override
    public boolean canRoute(Document document, Person user) {
        SubAwardDocument subawardDocument = (SubAwardDocument) document;
        return (!(isFinal(document) || isProcessed (document)) && !subawardDocument.isViewOnly()
                        && hasPermission(subawardDocument, user, PermissionConstants.SUBMIT_SUBAWARD));
    }

    @Override
    public boolean canBlanketApprove(Document document, Person user) {
        return !((KcTransactionalDocumentBase)document).isViewOnly() && super.canBlanketApprove(document,user);
    }
    
    @Override
    protected boolean isFinal(Document document) {
        return KewApiConstants.ROUTE_HEADER_FINAL_CD.equals(
                document.getDocumentHeader().getWorkflowDocument().getStatus().getCode());
    }
    
    protected boolean isProcessed (Document document){
       boolean isProcessed = false;
       String status = document.getDocumentHeader().getWorkflowDocument().getStatus().getCode();
       // if document is in processed state
       if (status.equalsIgnoreCase(KewApiConstants.ROUTE_HEADER_PROCESSED_CD))
               isProcessed = true;
       return isProcessed;   
   }
    
    private boolean hasPermission(SubAwardDocument subAwardDocument, Person user, String permissionName) {
        return isAuthorized(subAwardDocument, Constants.MODULE_NAMESPACE_SUBAWARD, permissionName, user.getPrincipalId());
    }
    
    /**
     * @see org.kuali.rice.krad.document.DocumentAuthorizer#canInitiate(java.lang.String, org.kuali.rice.kim.api.identity.Person)
     */

    @Override
    public boolean canInitiate(String documentTypeName, Person user) {
        return canCreateSubAward(user.getPrincipalId());
    }
    @Override
    public boolean canEdit(Document document, Person user) {
        return canExecuteSubAwardTask(user.getPrincipalId(),
        (SubAwardDocument) document, TaskName.MODIFY_SUBAWARD);
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
