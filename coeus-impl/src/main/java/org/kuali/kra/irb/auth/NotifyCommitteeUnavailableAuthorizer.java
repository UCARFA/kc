/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;

/**
 * Is the user allowed to notify the IRB office and the action is currently not available?
 */
public class NotifyCommitteeUnavailableAuthorizer extends ProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        return !isStatusValid(task.getProtocol()) ||
               !canExecuteAction(task.getProtocol(), ProtocolActionType.NOTIFIED_COMMITTEE) ||
               !hasPermission(userId, task.getProtocol(), PermissionConstants.PERFORM_IRB_ACTIONS_ON_PROTO) || 
               !hasCommitteeId(task.getProtocol());
    }

    private boolean isStatusValid(Protocol protocol) {
        String submissionStatusCode = protocol.getProtocolSubmission().getSubmissionStatus().getProtocolSubmissionStatusCode();
        return StringUtils.isNotBlank(submissionStatusCode) &&
              (ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE.equals(submissionStatusCode));
    }
}
