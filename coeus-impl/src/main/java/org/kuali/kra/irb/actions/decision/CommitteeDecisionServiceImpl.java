/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.decision;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.meeting.ProtocolVoteAbstaineeBase;
import org.kuali.coeus.common.committee.impl.meeting.ProtocolVoteRecusedBase;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.kra.meeting.ProtocolVoteAbstainee;
import org.kuali.kra.meeting.ProtocolVoteRecused;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.decision.CommitteeDecisionServiceImplBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * The CommitteeDecisionService implementation.
 */
public class CommitteeDecisionServiceImpl extends CommitteeDecisionServiceImplBase<CommitteeDecision> implements CommitteeDecisionService {

    @Override
    protected String getProtocolActionTypeCodeForRecordCommitteeDecisionHook() {
        return ProtocolActionType.RECORD_COMMITTEE_DECISION;
    }

    @Override
    protected ProtocolActionBase getNewProtocolActionInstanceHook(ProtocolBase protocol, ProtocolSubmissionBase submission, String recordCommitteeDecisionActionCode) {
        return new ProtocolAction((Protocol) protocol, (ProtocolSubmission) submission, recordCommitteeDecisionActionCode);
    }
    
    @Override
    protected Class<? extends ProtocolVoteAbstaineeBase> getProtocolVoteAbstaineeBOClassHook() {
        return ProtocolVoteAbstainee.class;
    }

    @Override
    protected ProtocolVoteAbstaineeBase getNewProtocolVoteAbstaineeInstanceHook() {
        return new ProtocolVoteAbstainee();
    }
        
    @Override
    protected ProtocolVoteRecusedBase getNewProtocolVoteRecusedInstanceHook() {
        return new ProtocolVoteRecused();
    }
  
    @Override
    protected Class<? extends ProtocolVoteRecusedBase> getProtocolVoteRecusedBOClassHook() {
        return ProtocolVoteRecused.class;
    }
    
    @Override
    protected Map<String, Object> getFieldValuesMap(Long protocolId, Long scheduleIdFk, String personId, Integer rolodexId, Long submissionIdFk) {
        Map<String, Object> fieldValues = new HashMap<String, Object>();
        fieldValues.put("PROTOCOL_ID_FK", protocolId.toString());
        //fieldValues.put("SCHEDULE_ID_FK", scheduleIdFk.toString());
        fieldValues.put("PERSON_ID", personId);
        fieldValues.put("ROLODEX_ID", rolodexId);
        fieldValues.put("SUBMISSION_ID_FK", submissionIdFk.toString());
        return fieldValues;
    }

    @Override
    protected ProtocolSubmission getSubmission(ProtocolBase protocol) {
        // There are 'findCommission' in other classes.  Consider to create a utility static method for this
        // need to loop thru to find the last submission.
        // it may have submit/Wd/notify irb/submit, and this will cause problem if don't loop thru.
        ProtocolSubmission protocolSubmission = null;
        for (ProtocolSubmissionBase submission : protocol.getProtocolSubmissions()) {
            if (StringUtils.equals(submission.getSubmissionStatusCode(), ProtocolSubmissionStatus.IN_AGENDA)
                    || StringUtils.equals(submission.getSubmissionStatusCode(), ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE)) {
                protocolSubmission = (ProtocolSubmission) submission;
            }
        }
        return protocolSubmission;
    }    
}
