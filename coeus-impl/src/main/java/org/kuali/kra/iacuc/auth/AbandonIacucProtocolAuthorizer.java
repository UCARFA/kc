/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.infrastructure.PermissionConstants;

public class AbandonIacucProtocolAuthorizer extends IacucProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        //TODO : permission : PI and protocol has never been approved. protocol status is SRR/SMR
        return canExecuteAction(task.getProtocol(), IacucProtocolActionType.IACUC_ABANDON) 
            && (hasPermission(userId, task.getProtocol(), PermissionConstants.SUBMIT_IACUC_PROTOCOL)
                    || hasPermission(userId, task.getProtocol(), PermissionConstants.MODIFY_ANY_IACUC_PROTOCOL));
    }
    
}
