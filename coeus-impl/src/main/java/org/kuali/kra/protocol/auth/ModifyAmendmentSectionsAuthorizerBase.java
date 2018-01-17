/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.auth;


public abstract class ModifyAmendmentSectionsAuthorizerBase extends ProtocolAuthorizerBase {

    @Override
    public boolean isAuthorized(String userId, ProtocolTaskBase task) {
        return isAmendmentOrRenewal(task.getProtocol()) &&
               canExecuteAction(task.getProtocol(), getActionTypeModifyAmendmentHook()) &&
               hasPermission(userId, task.getProtocol(), getPermissionCreateAmendmentHook());
    }

    protected abstract String getActionTypeModifyAmendmentHook();
    protected abstract String getPermissionCreateAmendmentHook();

}
