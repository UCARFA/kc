/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notesandattachments.notes;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class is the event base class for all award note event.
 */
@SuppressWarnings("unchecked")
public abstract class AwardNoteEventBase<Z extends KcBusinessRule> extends KcDocumentEventBaseExtension {
    
    /**
     * Enum helps identify type of error to respond.
     */
    public enum ErrorType {HARDERROR, SOFTERROR};
    
    
    private AwardNotepad awardNotepad;
    
    private ErrorType type;
    
    public AwardNoteEventBase(String description, String errorPathPrefix, Document document,  AwardNotepad awardNotepad, ErrorType type) {        
        super(description, errorPathPrefix, document);
        this.awardNotepad = awardNotepad;
        this.type = type;
    }
    
    
    /**
     * This method should return instance of awardnotepad.
     * @return
     */
    public AwardNotepad getAwardNotepad(){
        return this.awardNotepad;
    }
    
    /**
     * This method should return Error type.
     * @return
     */
    public ErrorType getType() {
        return this.type;
    }


}
