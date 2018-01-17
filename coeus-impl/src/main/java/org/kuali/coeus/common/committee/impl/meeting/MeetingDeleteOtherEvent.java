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
 * Provides necessary accessor for checking the deletion of an Other Action.
 */
public class MeetingDeleteOtherEvent extends MeetingEventBase<MeetingDeleteOtherRule> {
    
    private static final String MSG = "Delete meeting present other  ";
    
    private int otherNumber;
    
    /**
     * Constructs a MeetingDeleteOtherEvent.
     * 
     * @param errorPathPrefix Prefix of document ID of where to put the error message
     * @param document The document being modified
     * @param meetingHelper Helper class for meetings
     * @param type The type of error
     * @param otherNumber The index of the Other Action in the Other Action list.
     */
    public MeetingDeleteOtherEvent(String errorPathPrefix, CommitteeDocumentBase document, MeetingHelperBase meetingHelper, ErrorType type, int otherNumber) {
        super(MSG + getDocumentId(document), errorPathPrefix, document, meetingHelper, type);
        this.otherNumber = otherNumber;
    }
    
    /**
     * Constructs a MeetingDeleteOtherEvent.
     * 
     * @param errorPathPrefix Prefix of document ID of where to put the error message
     * @param document The document being modified
     * @param meetingHelper Helper class for meetings
     * @param type The type of error
     * @param otherNumber The index of the Other Action in the Other Action list.
     */
    public MeetingDeleteOtherEvent(String errorPathPrefix, Document document, MeetingHelperBase meetingHelper, ErrorType type, int otherNumber) {
        this(errorPathPrefix, (CommitteeDocumentBase) document, meetingHelper, type, otherNumber);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {
        return new MeetingDeleteOtherRule();
    }
    
    public int getOtherNumber() {
        return otherNumber;
    }

}
