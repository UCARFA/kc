/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions;

import org.kuali.kra.protocol.actions.ProtocolStatusBase;

public class ProtocolStatus extends ProtocolStatusBase {


    private static final long serialVersionUID = -5947289991209122441L;

    public static final String IN_PROGRESS = "100";

    public static final String SUBMITTED_TO_IRB = "101";

    public static final String SPECIFIC_MINOR_REVISIONS_REQUIRED = "102";

    public static final String DEFERRED = "103";

    public static final String SUBSTANTIVE_REVISIONS_REQUIRED = "104";

    public static final String AMENDMENT_IN_PROGRESS = "105";

    public static final String RENEWAL_IN_PROGRESS = "106";

    public static final String FYI_IN_PROGRESS = "900";
    
    public static final String RETURN_TO_PI = "107";

    public static final String ACTIVE_OPEN_TO_ENROLLMENT = "200";

    public static final String ACTIVE_CLOSED_TO_ENROLLMENT = "201";

    public static final String ACTIVE_DATA_ANALYSIS_ONLY = "202";

    public static final String EXEMPT = "203";

    public static final String CLOSED_ADMINISTRATIVELY = "300";

    public static final String CLOSED_BY_INVESTIGATOR = "301";

    public static final String SUSPENDED_BY_PI = "302";

    public static final String DELETED = "303";

    public static final String WITHDRAWN = "304";

    public static final String EXPIRED = "305";

    public static final String DISAPPROVED = "306";

    public static final String TERMINATED_BY_IRB = "307";

    public static final String SUSPENDED_BY_IRB = "308";

    public static final String IRB_REVIEW_NOT_REQUIRED = "310";

    public static final String SUSPENDED_BY_DSMB = "311";

    public static final String AMENDMENT_MERGED = "400";

    public static final String RENEWAL_MERGED = "401";

    public static final String FYI_MERGED = "901";
    
    public static final String RECALLED_IN_ROUTING = "402";
}
