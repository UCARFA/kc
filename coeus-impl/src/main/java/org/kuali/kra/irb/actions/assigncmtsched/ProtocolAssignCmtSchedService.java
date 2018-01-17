/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.assigncmtsched;

import org.kuali.kra.irb.Protocol;

/**
 * Handles the processing of assigning a protocol to a committee/schedule.
 */
public interface ProtocolAssignCmtSchedService {

    /**
     * Get the committee currently assigned to the protocol.
     * @param protocol
     * @return the committeeId or null if there is none
     */
    public String getAssignedCommitteeId(Protocol protocol);
    
    /**
     * Get the schedule currently assigned to the protocol.
     * @param protocol
     * @return the scheduleId or null if there is none
     */
    public String getAssignedScheduleId(Protocol protocol);
    
    /**
     * Assign a protocol to a committee/schedule.
     * @param protocol the protocol
     * @param actionBean contains committee/schedule
     * @throws Exception 
     */
    public void assignToCommitteeAndSchedule(Protocol protocol, ProtocolAssignCmtSchedBean actionBean) throws Exception;

    /**
     * Assign a protocol to a committee/schedule after the protocol has already been assigned to an agenda.
     * @param protocol the protocol
     * @param actionBean contains committee/schedule
     * @throws Exception 
     */
    public void assignToCommitteeAndSchedulePostAgendaAssignment(Protocol protocol, ProtocolAssignCmtSchedBean cmtAssignBean) throws Exception;
}
