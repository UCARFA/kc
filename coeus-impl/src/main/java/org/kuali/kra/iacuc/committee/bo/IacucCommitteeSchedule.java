/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.bo;

import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionLite;
import org.kuali.kra.iacuc.committee.meeting.IacucCommitteeScheduleMinute;

public class IacucCommitteeSchedule extends CommitteeScheduleBase<IacucCommitteeSchedule, IacucCommittee, IacucProtocolSubmissionLite, IacucCommitteeScheduleMinute> {


    private static final long serialVersionUID = -579662475857490755L;
    
    private IacucCommittee committee;
    
    @Override
    public IacucCommittee getParentCommittee() {
        return this.getCommittee();
    }
    
    public IacucCommittee getCommittee() {
        if (committee == null && getCommitteeIdFk() == null) {
            committee = new IacucCommittee();
        }
        return committee;
    }
    
    @Override
    public void setCommittee(IacucCommittee committee) {
        this.committee = committee;
    }
    
}
