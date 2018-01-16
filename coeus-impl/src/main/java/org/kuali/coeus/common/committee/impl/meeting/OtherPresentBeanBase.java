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
 * This class is form data for other present.
 */
public abstract class OtherPresentBeanBase implements Serializable, Comparable<OtherPresentBeanBase> {

    private static final long serialVersionUID = 4831035284455868528L;
    private CommitteeScheduleAttendanceBase attendance;
    private boolean member;

    public CommitteeScheduleAttendanceBase getAttendance() {
        if(attendance == null) {

            attendance = getNewCommitteeScheduleAttendanceInstanceHook();
        }
        return attendance;
    }
    
    protected abstract CommitteeScheduleAttendanceBase getNewCommitteeScheduleAttendanceInstanceHook();
    
    

    public void setAttendance(CommitteeScheduleAttendanceBase attendance) {
        this.attendance = attendance;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    @Override
    public int compareTo(OtherPresentBeanBase arg) {
        return this.getAttendance().getPersonName().compareTo(arg.getAttendance().getPersonName());

    }

}
