/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.meeting;

import org.kuali.coeus.common.committee.impl.meeting.MeetingAddMinuteEventBase;
import org.kuali.coeus.common.committee.impl.meeting.MeetingAddMinuteRuleBase;
import org.kuali.kra.iacuc.committee.document.CommonCommitteeDocument;
import org.kuali.rice.krad.document.Document;

public class IacucMeetingAddMinuteEvent extends MeetingAddMinuteEventBase {

    public IacucMeetingAddMinuteEvent(String errorPathPrefix, CommonCommitteeDocument document, IacucMeetingHelper meetingHelper,
            org.kuali.coeus.common.committee.impl.meeting.MeetingEventBase.ErrorType type) {
        super(errorPathPrefix, document, meetingHelper, type);
    }
    
    public IacucMeetingAddMinuteEvent(String errorPathPrefix, Document document, IacucMeetingHelper meetingHelper,
            org.kuali.coeus.common.committee.impl.meeting.MeetingEventBase.ErrorType type) {
        this(errorPathPrefix, (CommonCommitteeDocument) document, meetingHelper, type);
    }

    @Override
    protected MeetingAddMinuteRuleBase getMeetingAddMinuteRuleInstanceHook() {
        return new IacucMeetingAddMinuteRule();
    }

}
