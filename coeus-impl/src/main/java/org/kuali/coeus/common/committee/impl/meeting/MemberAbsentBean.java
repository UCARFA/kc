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
 * This class is form data for member absent in meeting page
 */
public class MemberAbsentBean implements Serializable, Comparable<MemberAbsentBean> {

    private static final long serialVersionUID = -5220883072192174587L;
    private CommitteeScheduleAttendanceBase attendance;

    public CommitteeScheduleAttendanceBase getAttendance() {
        return attendance;
    }

    public void setAttendance(CommitteeScheduleAttendanceBase attendance) {
        this.attendance = attendance;
    }

    @Override
    public int compareTo(MemberAbsentBean arg) {
        return this.getAttendance().getPersonName().compareTo(arg.getAttendance().getPersonName());

    }

}
