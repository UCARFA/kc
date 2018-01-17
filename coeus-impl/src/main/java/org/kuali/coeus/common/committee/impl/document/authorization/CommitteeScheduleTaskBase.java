/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.document.authorization;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;

/**
 * A CommitteeBase Task is a task that performs an action against a
 * CommitteeBase.  To assist authorization, the CommitteeBase is available.
 * 
 * This extension is for checking authorization for the schedules
 * both the committee and schedule are needed to do this.
 * 
 */
public abstract class CommitteeScheduleTaskBase<CMT extends CommitteeBase<CMT, ?, CS>, 
                                            CS extends CommitteeScheduleBase<CS, CMT, ?, ?>> 
    
                                            extends CommitteeTaskBase<CMT> {

    protected CS schedule;
    
    public CommitteeScheduleTaskBase(String taskGroupName, String taskName, CMT committee, CS schedule) {
        super(taskGroupName, taskName, committee);
        this.schedule = schedule;
    }

    public CS getCommitteeSchedule() {
        return schedule;
    }
    
}
