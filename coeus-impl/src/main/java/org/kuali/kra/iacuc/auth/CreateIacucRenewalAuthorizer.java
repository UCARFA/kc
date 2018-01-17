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
import org.kuali.kra.protocol.auth.CreateRenewalAuthorizerBase;

public class CreateIacucRenewalAuthorizer extends CreateRenewalAuthorizerBase {

    private IacucProtocolAssignCmtService assignToCmtService;
    
    public void setAssignToCmtService(IacucProtocolAssignCmtService iacucProtocolAssignCmtService) {
        this.assignToCmtService = iacucProtocolAssignCmtService;
    }
    
    @Override
    protected String getAdminNamespaceHook() {
        return RoleConstants.DEPARTMENT_ROLE_TYPE;
    }
    
    @Override
    protected String getAdminRoleHook() {
        return RoleConstants.IACUC_ADMINISTRATOR;
    }
    
    @Override
    protected String getProtocolSubmissionTypeHook() {
        return IacucProtocolSubmissionType.REQUEST_SUSPEND;
    }
        
    @Override
    protected ProtocolSubmissionBase findSubmisionHook(ProtocolBase protocol) {
        return assignToCmtService.getLastSubmission(protocol);
    }

    @Override
    protected String getActionTypeRenewalCreatedHook() {
        return IacucProtocolActionType.RENEWAL_CREATED;
    }

    @Override
    protected String getPermissionCreateRenewalHook() {
        return PermissionConstants.CREATE_IACUC_RENEWAL;
    }

    @Override
    protected String getPermissionCreateAnyRenewalHook() {
        return PermissionConstants.CREATE_ANY_IACUC_RENEWAL;
    }

}
