/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.SkipVersioning;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionQualifierTypeBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class tracks the data associated with the submisison of a protocol for review.
 */
public class ProtocolSubmission extends ProtocolSubmissionBase {

    //hiding the protocolbase inherited from the parent for lookups based on the protocol to work.
    private Protocol protocol;

    //hiding the committeeScheduleBase inherited from the parent for lookups based on the CommitteeSchedule to work.
    @SkipVersioning
    private transient CommitteeSchedule committeeSchedule;

    private static final long serialVersionUID = 2158830045312905591L;
    
    private List<ProtocolExemptStudiesCheckListItem> exemptStudiesCheckList = new ArrayList<ProtocolExemptStudiesCheckListItem>();

    private List<ProtocolExpeditedReviewCheckListItem> expeditedReviewCheckList = new ArrayList<ProtocolExpeditedReviewCheckListItem>();
    
    public void setExemptStudiesCheckList(List<ProtocolExemptStudiesCheckListItem> exemptStudiesCheckList) {
        this.exemptStudiesCheckList = exemptStudiesCheckList;
    }

    public List<ProtocolExemptStudiesCheckListItem> getExemptStudiesCheckList() {
        return exemptStudiesCheckList;
    }

    public void setExpeditedReviewCheckList(List<ProtocolExpeditedReviewCheckListItem> expeditedReviewCheckList) {
        this.expeditedReviewCheckList = expeditedReviewCheckList;
    }

    public List<ProtocolExpeditedReviewCheckListItem> getExpeditedReviewCheckList() {
        return expeditedReviewCheckList;
    }

    /**
     * This method returns true if this submission has the same submission id as the passed in submission id.
     * @param o a ProtocolSubmission object to compare for equality
     * @return a boolean
     */
    @Override
    public boolean equals(Object o) {
        ProtocolSubmission ps = (ProtocolSubmission) o;
        try {
            return this.getSubmissionId().equals(ps.getSubmissionId());
        } catch (Exception e) {
            //an NPE would happen if the submission IDs aren't set.  
            return false;
        }
    }

    @Override
    protected ProtocolSubmissionQualifierTypeBase getNewInstanceProtocolSubmissionQualifierTypeHook() {
        return new ProtocolSubmissionQualifierType();
    }
    
    @Override
    public Committee getCommittee() {
        return (Committee)super.getCommittee();
    }
    
    @Override
    public CommitteeSchedule getCommitteeSchedule() {
       if (committeeSchedule == null) {
           committeeSchedule = (CommitteeSchedule) super.getCommitteeSchedule();
       }
        return committeeSchedule;
    }

    public void setCommitteeSchedule(CommitteeSchedule committeeSchedule) {
        super.setCommitteeSchedule(committeeSchedule);
        this.committeeSchedule = committeeSchedule;
    }

    @Override
    public Protocol getProtocol() {
        if (protocol == null) {
            protocol = (Protocol) super.getProtocol();
        }
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        super.setProtocol(protocol);
        this.protocol = protocol;
    }


}
