/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.service.impl;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.meeting.CommitteeScheduleAttendanceBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeScheduleAttendanceServiceBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public abstract class CommitteeScheduleAttendanceServiceImplBase<CSRV extends CommitteeServiceBase<CMT, CS>,
                                                             CMT extends CommitteeBase<CMT, CD, CS>, 
                                                             CD extends CommitteeDocumentBase<CD, CMT, CS>,
                                                             CS extends CommitteeScheduleBase<CS, CMT, ?, ?>>
                                                                
                                                             implements CommitteeScheduleAttendanceServiceBase {
    
    private CSRV committeeService;
    
    public void setCommitteeService(CSRV committeeService) {
        this.committeeService = committeeService;
    }
  
    protected abstract Class<CD> getCommitteeDocumentClassBOHook();
    

    protected Set<String> getActualVotingMembersPresent(String committeeId, String scheduleId) {
        Set<String> attendedMembers = new HashSet<String>();
        CMT committee = committeeService.getCommitteeById(committeeId);
        CS schedule = committeeService.getCommitteeSchedule(committee, scheduleId);
        List<CommitteeScheduleAttendanceBase> attendances = schedule.getCommitteeScheduleAttendances();
        for (CommitteeScheduleAttendanceBase attendance : attendances) {
             if(!attendance.getGuestFlag()) {
                 attendedMembers.add(attendance.getPersonId());
             }
        }
        return attendedMembers;
    }

    @Override
    public int getActualVotingMembersCount(String committeeId, String scheduleId) {
        return getActualVotingMembersPresent(committeeId, scheduleId).size();
    }
    
    
}
