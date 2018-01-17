/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.infrastructure.RoleConstants;

public class AdminApproveIacucProtocolAuthorizer extends IacucProtocolAuthorizer {
    private static final String NAMESPACE = "KC-UNT";
    
    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        return  canExecuteAction(task.getProtocol(), IacucProtocolActionType.ADMINISTRATIVE_APPROVAL) && 
                systemAuthorizationService.hasRole(userId, NAMESPACE, RoleConstants.IACUC_ADMINISTRATOR);
    }

}
