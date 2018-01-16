/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.meeting;

import org.kuali.coeus.common.committee.impl.meeting.MeetingAddMinuteEventBase;
import org.kuali.kra.committee.document.CommitteeDocument;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class for the event to add committee schedule minute
 */
public class MeetingAddMinuteEvent extends MeetingAddMinuteEventBase {
    
    public MeetingAddMinuteEvent(String errorPathPrefix, CommitteeDocument document, MeetingHelper meetingHelper, ErrorType type) {
        super(errorPathPrefix, document, meetingHelper, type);
    }
    
    public MeetingAddMinuteEvent(String errorPathPrefix, Document document, MeetingHelper meetingHelper, ErrorType type) {
        this(errorPathPrefix, (CommitteeDocument) document, meetingHelper, type);
    }

    @Override
    protected MeetingAddMinuteRule getMeetingAddMinuteRuleInstanceHook() {
        return new MeetingAddMinuteRule();
    }
}
