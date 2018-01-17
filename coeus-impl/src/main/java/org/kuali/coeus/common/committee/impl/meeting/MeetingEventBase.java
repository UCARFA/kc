/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class is the event base class for all meeting event.
 */
@SuppressWarnings("unchecked")
public abstract class MeetingEventBase<Z extends KcBusinessRule> extends KcDocumentEventBaseExtension {
    
    /**
     * Enum helps identify type of error to respond.
     */
    public enum ErrorType {HARDERROR, SOFTERROR};
    
    
    private MeetingHelperBase meetingHelper;
    
    private ErrorType type;
    
    public MeetingEventBase(String description, String errorPathPrefix, Document document,  MeetingHelperBase meetingHelper, ErrorType type) {        
        super(description, errorPathPrefix, document);
        this.meetingHelper = meetingHelper;
        this.type = type;
    }
    
    
    /**
     * This method should return instance of MeetingHelperBase.
     * @return
     */
    public MeetingHelperBase getMeetingHelper(){
        return this.meetingHelper;
    }
    
    /**
     * This method should return Error type.
     * @return
     */
    public ErrorType getType() {
        return this.type;
    }


}
