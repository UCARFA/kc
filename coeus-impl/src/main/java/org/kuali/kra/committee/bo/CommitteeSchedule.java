/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.bo;

import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionLite;
import org.kuali.kra.meeting.CommitteeScheduleMinute;

/**
 * This is BO class to support CommitteeScheulde. It has three transient field to support UI.
 */
public class CommitteeSchedule extends CommitteeScheduleBase<CommitteeSchedule, Committee, ProtocolSubmissionLite, CommitteeScheduleMinute> {
    
    private static final long serialVersionUID = -360139608123017188L;
    
    private Committee committee;

    
    @Override
    public Committee getParentCommittee() {
        return this.getCommittee();
    }
    
    public Committee getCommittee() {
        if (committee == null && getCommitteeIdFk() == null) {
            committee = new Committee();
        }
        return committee;
    }
    
	@Override
    public void setCommittee(Committee committee) {
		this.committee = committee;
	}

}
