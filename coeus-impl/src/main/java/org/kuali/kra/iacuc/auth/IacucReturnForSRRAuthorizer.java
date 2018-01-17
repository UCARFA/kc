/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.iacuc.actions.IacucProtocolAction;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmission;
import org.kuali.kra.infrastructure.PermissionConstants;


/**
 * Is the user allowed to return protocols for major revisions and the action is currently not available?
 */
public class IacucReturnForSRRAuthorizer extends IacucProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {        
        IacucProtocolAction lastAction = (IacucProtocolAction) task.getProtocol().getLastProtocolAction();
        IacucProtocolSubmission lastSubmission = (IacucProtocolSubmission) task.getProtocol().getProtocolSubmission();
        
        return canPerform(lastAction, lastSubmission) && hasPermission(userId, task.getProtocol(), PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO);
    }
    
    private boolean canPerform(IacucProtocolAction lastAction, IacucProtocolSubmission lastSubmission) {
        return canPerformSRR(lastAction, lastSubmission);
    }
    
}
