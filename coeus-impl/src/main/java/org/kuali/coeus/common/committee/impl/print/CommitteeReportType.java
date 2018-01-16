/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.print;

/**
 * This class represents different types of reports for committee.
 */
public enum CommitteeReportType {
    /** Report type for the committee reports that utilize templates. */
    COMMITTEE_TEMPLATE ("committee_template"),

    /** Report type for the committee schedule reports that utilize templates. */
    SCHEDULE_TEMPLATE ("schedule_template"),

    /** Report type for the protocol correspondence reports that utilize templates. */
    PROTOCOL_CORRESPONDENCE_TEMPLATE ("protocol_correspondence_template"),

    /** Report type for the committee roster. */
    ROSTER ("roster"),

    /** Report type for the committee future scheduled meetings. */
    FUTURE_SCHEDULED_MEETINGS ("futureScheduledMeetings"),
    
    PROTOCOL_BATCH_CORRESPONDENCE("prtocolBatchCorrespondence");

    private String committeeReportType;

    /**
     * 
     * Constructs a CommitteeReportType.java.
     * @param committeeReportType
     */
    CommitteeReportType(String committeeReportType) {
        this.committeeReportType = committeeReportType;
    }
    
    public String getCommitteeReportType() {
        return committeeReportType;
    }
}
