/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.assignCmt.IacucProtocolAssignCmtService;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionType;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

public class RequesstSuspensionIacucProtocolUnavailableAuthorizer extends IacucProtocolAuthorizer {
   
    private IacucProtocolAssignCmtService assignToCmtService;
    
    public void setAssignToCmtService(IacucProtocolAssignCmtService iacucProtocolAssignCmtService) {
        this.assignToCmtService = iacucProtocolAssignCmtService;
    }
    
    protected ProtocolSubmissionBase findSubmisionHook(ProtocolBase protocol) {
        return assignToCmtService.getLastSubmission(protocol);
    }
    
    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        return  (!canExecuteAction(task.getProtocol(), IacucProtocolActionType.IACUC_REQUEST_SUSPEND) ||
                 (isRequestForSuspension(findSubmisionHook(task.getProtocol()), IacucProtocolSubmissionType.REQUEST_SUSPEND) 
                        & !isAdmin(userId, RoleConstants.DEPARTMENT_ROLE_TYPE, RoleConstants.IACUC_ADMINISTRATOR))
                ) &&
                (hasPermission(userId, task.getProtocol(), PermissionConstants.SUBMIT_IACUC_PROTOCOL)
                        || hasPermission(userId, task.getProtocol(), PermissionConstants.SUBMIT_ANY_IACUC_PROTOCOL)
                );
    }

}
