/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.auth;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

public abstract class CreateContinuationUnavailableAuthorizerBase extends ContinuationAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTaskBase task) {
        return hasPermission(userId, task.getProtocol(), getPermissionCreateContinuationHook()) &&
               (isAmendmentOrRenewalOrContinuation(task.getProtocol()) ||
                (isRequestForSuspension(findSubmisionHook(task.getProtocol()), getProtocolSubmissionTypeHook()) & !isAdmin(userId, getAdminNamespaceHook(), getAdminRoleHook())) ||
                !canExecuteAction(task.getProtocol(), getActionTypeContinuationCreatedHook())
               );
    }

    protected abstract String getActionTypeContinuationCreatedHook();
    protected abstract String getPermissionCreateContinuationHook();
    protected abstract String getAdminNamespaceHook();
    protected abstract String getAdminRoleHook();
    protected abstract String getProtocolSubmissionTypeHook();
    protected abstract ProtocolSubmissionBase findSubmisionHook(ProtocolBase protocol);

}
