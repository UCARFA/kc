/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class is for the event to move member absent to present voting or present other.
 */
public class MeetingPresentOtherOrVotingEvent extends MeetingEventBase<MeetingPresentOtherOrVotingRule> {
    
    private static final String MSG = "Present other or voting ";
    
    private MemberAbsentBean memberAbsentBean;
    public MeetingPresentOtherOrVotingEvent(String errorPathPrefix, CommitteeDocumentBase document, MeetingHelperBase meetingHelper, ErrorType type) {
        super(MSG + getDocumentId(document), errorPathPrefix, document, meetingHelper, type);
    }
    
    public MeetingPresentOtherOrVotingEvent(String errorPathPrefix, Document document, MeetingHelperBase meetingHelper, MemberAbsentBean memberAbsentBean, ErrorType type) {
        this(errorPathPrefix, (CommitteeDocumentBase)document, meetingHelper, type);
        this.memberAbsentBean = memberAbsentBean;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {
        return new MeetingPresentOtherOrVotingRule();
    }

    public MemberAbsentBean getMemberAbsentBean() {
        return memberAbsentBean;
    }

    public void setMemberAbsentBean(MemberAbsentBean memberAbsentBean) {
        this.memberAbsentBean = memberAbsentBean;
    }

}
