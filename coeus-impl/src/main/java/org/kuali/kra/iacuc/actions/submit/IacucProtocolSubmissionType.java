/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.submit;

import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionTypeBase;

public class IacucProtocolSubmissionType extends ProtocolSubmissionTypeBase {

    public static final String INITIAL_SUBMISSION = "100";

    public static final String RESPONSE_TO_PREV_IACUC_NOTIFICATION = "101";

    public static final String REQUEST_TO_DEACTIVATE = "102";

    public static final String REQUEST_TO_LIFT_HOLD = "103";

    public static final String FYI = "104";

    public static final String AMENDMENT = "105";

    public static final String RENEWAL = "106";

    public static final String RENEWAL_WITH_AMENDMENT = "107";
    
    public static final String CONTINUATION = "108";

    public static final String CONTINUATION_WITH_AMENDMENT = "109";
    
    public static final String NOTIFY_IACUC = "110";
    
    public static final String REQUEST_SUSPEND = "111";

    public boolean isAmendment() {
        return AMENDMENT.equals(getSubmissionTypeCode()) || RENEWAL_WITH_AMENDMENT.equals(getSubmissionTypeCode());
    }

    public boolean isRenewal() {
        return RENEWAL.equals(getSubmissionTypeCode()) || RENEWAL_WITH_AMENDMENT.equals(getSubmissionTypeCode());
    }

    public boolean isContinuation() {
        return CONTINUATION.equals(getSubmissionTypeCode()) || CONTINUATION_WITH_AMENDMENT.equals(getSubmissionTypeCode());
    }
    
    @Override
    public String getSubmissionTypeCode() {
        return super.getSubmissionTypeCode();
    }

}
