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
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionType;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

/**
 * 
 * This class to check the authorization to perform IRB acknowledgement action and the action is currently not available.
 */
public class IrbAcknowledgementUnavailableAuthorizer extends ProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        return !isValidToPerform(task)
                && hasPermission(userId, task.getProtocol(), PermissionConstants.PERFORM_IRB_ACTIONS_ON_PROTO);
    }

    private boolean isValidToPerform(ProtocolTask task) {
        boolean isValid = false;
        Protocol protocol = task.getProtocol();
        if (protocol.getNotifyIrbSubmissionId() != null) {
            // not the current submission, then check programically
            for (ProtocolSubmissionBase submission : protocol.getProtocolSubmissions()) {
                if (submission.getSubmissionId().equals(protocol.getNotifyIrbSubmissionId())) {
                    isValid = isValidFYI((ProtocolSubmission) submission);
                }
            }
        }
        if (!isValid) {
            // if not valid, then this submission is not for ack, so not needed.
            protocol.setNotifyIrbSubmissionId(null);
            isValid = canExecuteAction(task.getProtocol(), ProtocolActionType.IRB_ACKNOWLEDGEMENT);
        }
        return isValid;
    }

    private boolean isValidFYI(ProtocolSubmission submission) {
        return isFYISubmission(submission.getSubmissionTypeCode()) && isFYIReview(submission.getProtocolReviewTypeCode())
                && isStatusValid(submission.getSubmissionStatusCode());
    }


    private boolean isFYISubmission(String submissionTypeCode) {
        return StringUtils.isNotBlank(submissionTypeCode) && ProtocolSubmissionType.NOTIFY_IRB.equals(submissionTypeCode);
    }

    private boolean isFYIReview(String reviewTypeCode) {
        // in coeus 4.4, it does not check whether its FYI or not.
        return StringUtils.isNotBlank(reviewTypeCode);
    }

    private boolean isStatusValid(String submissionStatusCode) {
        return StringUtils.isNotBlank(submissionStatusCode)
                && (ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE.equals(submissionStatusCode) || ProtocolSubmissionStatus.IN_AGENDA
                        .equals(submissionStatusCode));
    }
}
