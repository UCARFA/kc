/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * Is the user allowed to add risk levels for a protocol?
 */
public class EnterRiskLevelProtocolAuthorizer extends ProtocolAuthorizer {

    /**
     * Can the user add a risk level at this stage of protocol submission and is the user allowed to do so?
     * 
     * @see org.kuali.kra.irb.auth.ProtocolAuthorizer#isAuthorized(java.lang.String, org.kuali.kra.irb.auth.ProtocolTask)
     */
    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        return hasPermission(userId, task.getProtocol(), PermissionConstants.PERFORM_IRB_ACTIONS_ON_PROTO);
    }
}
