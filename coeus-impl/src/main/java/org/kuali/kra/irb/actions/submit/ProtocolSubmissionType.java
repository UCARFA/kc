/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionTypeBase;

public class ProtocolSubmissionType extends ProtocolSubmissionTypeBase {


    private static final long serialVersionUID = -1232083217368314655L;

    public static final String INITIAL_SUBMISSION = "100";

    public static final String CONTINUATION = "101";

    public static final String AMENDMENT = "102";

    public static final String RESPONSE_TO_PREV_IRB_NOTIFICATION = "103";

    public static final String REQUEST_TO_CLOSE = "109";

    public static final String CONTINUATION_WITH_AMENDMENT = "115";

    public static final String REQUEST_FOR_SUSPENSION = "110";

    public static final String REQUEST_TO_CLOSE_ENROLLMENT = "111";

    public static final String REQUEST_TO_REOPEN_ENROLLMENT = "114";

    public static final String REQUEST_FOR_DATA_ANALYSIS_ONLY = "113";

    public static final String NOTIFY_IRB = "112";      // also known as FYI

    public static final String REQUEST_FOR_TERMINATION = "108";

    public static final String RESUBMISSION = "116";


    @Override
    public String getSubmissionTypeCode() {
        return super.getSubmissionTypeCode();
    }

}
