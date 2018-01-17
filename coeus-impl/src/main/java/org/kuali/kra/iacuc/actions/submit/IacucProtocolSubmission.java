/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.submit;

import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeSchedule;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionQualifierTypeBase;

/**
 * 
 * This class tracks the data associated with the submission of a protocol for review.
 */
public class IacucProtocolSubmission extends ProtocolSubmissionBase {
    

    private static final long serialVersionUID = 4270551170133689515L;

    @Override
    protected ProtocolSubmissionQualifierTypeBase getNewInstanceProtocolSubmissionQualifierTypeHook() {
        return new IacucProtocolSubmissionQualifierType();
    }
    
    
    public IacucCommittee getIacucCommittee() {
        return (IacucCommittee) super.getCommittee();
    }

    
    public IacucCommitteeSchedule getIacucCommitteeSchedule() {
        return (IacucCommitteeSchedule) super.getCommitteeSchedule();
    }
}
