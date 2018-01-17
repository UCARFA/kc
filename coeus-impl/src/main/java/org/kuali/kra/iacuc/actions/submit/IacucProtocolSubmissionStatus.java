/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.submit;

import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionStatusBase;

public class IacucProtocolSubmissionStatus extends ProtocolSubmissionStatusBase {

    private static final long serialVersionUID = 7346700694406537435L;

    public static final String ROUTING_IN_PROGRESS = "100";

    public static final String PENDING = "101";

    public static final String SUBMITTED_TO_COMMITTEE = "102";

    public static final String IN_AGENDA = "103";

    public static final String IACUC_REVIEW_NOT_REQUIRED = "104";

    public static final String TEMPORARY_SUBMISSION = "105";

    public static final String APPROVED = "200";

    public static final String DISAPPROVED = "201";

    public static final String TERMINATED = "202";

    public static final String SUSPENDED = "203";

    public static final String WITHDRAWN = "204";

    public static final String IACUC_ACKNOWLEDGEMENT = "205";

    public static final String TABLED = "206";

    public static final String DEACTIVATED = "207";

    public static final String LIFT_HOLD = "208";

    public static final String RETURNED_TO_PI = "209";

    public static final String MINOR_REVISIONS_REQUIRED = "210";

    public static final String RETURNED_SUBMISSION = "211";

    public static final String MAJOR_REVISIONS_REQUIRED = "212";

    public static final String ADMINISTRATIVELY_APPROVED = "213";

    public static final String ADMINISTRATIVELY_INCOMPLETE = "214";
    
    public static final String RETURNED_IN_ROUTING = "401";

}
