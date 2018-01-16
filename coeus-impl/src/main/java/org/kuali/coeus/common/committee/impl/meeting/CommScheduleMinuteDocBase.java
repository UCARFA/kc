/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;


/**
 * 
 * This class is for meeting generated minute doc.
 */
public abstract class CommScheduleMinuteDocBase extends GeneratedMeetingDocBase {

    private static final long serialVersionUID = 2574809115702106379L;

    private Long commScheduleMinuteDocId;

    private Integer minuteNumber;

    private String minuteName;

    public CommScheduleMinuteDocBase() {
    }

    public Long getCommScheduleMinuteDocId() {
        return commScheduleMinuteDocId;
    }

    public void setCommScheduleMinuteDocId(Long commScheduleMinuteDocId) {
        this.commScheduleMinuteDocId = commScheduleMinuteDocId;
    }

    public Integer getMinuteNumber() {
        return minuteNumber;
    }

    public void setMinuteNumber(Integer minuteNumber) {
        this.minuteNumber = minuteNumber;
    }

    public String getMinuteName() {
        return minuteName;
    }

    public void setMinuteName(String minuteName) {
        this.minuteName = minuteName;
    }
}
