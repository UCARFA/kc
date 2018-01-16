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

public class MeetingAddAttachmentsEvent extends MeetingEventBase<MeetingAddAttachmentsRule>
{
    private static final String MSG = "Add meeting attachments ";
    
    public MeetingAddAttachmentsEvent(String errorPathPrefix, CommitteeDocumentBase document, MeetingHelperBase meetingHelper, ErrorType type) {
       super(MSG + getDocumentId(document), errorPathPrefix, document, meetingHelper, type);
    }
    
    public MeetingAddAttachmentsEvent(String errorPathPrefix, Document document, MeetingHelperBase meetingHelper, ErrorType type) {
        this(errorPathPrefix, (CommitteeDocumentBase)document, meetingHelper, type);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {
        return new MeetingAddAttachmentsRule();
    }

}
