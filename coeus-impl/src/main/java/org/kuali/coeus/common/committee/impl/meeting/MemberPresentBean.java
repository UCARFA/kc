/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import java.io.Serializable;

/**
 * 
 * This class is form data for member present.
 */
public class MemberPresentBean implements Serializable, Comparable<MemberPresentBean> {

    private static final long serialVersionUID = 7765741433539494399L;
    private CommitteeScheduleAttendanceBase attendance;

    public CommitteeScheduleAttendanceBase getAttendance() {
        return attendance;
    }

    public void setAttendance(CommitteeScheduleAttendanceBase attendance) {
        this.attendance = attendance;
    }

    @Override
    public int compareTo(MemberPresentBean arg) {
            return this.getAttendance().getPersonName().compareTo(arg.getAttendance().getPersonName());
        
    }

}
