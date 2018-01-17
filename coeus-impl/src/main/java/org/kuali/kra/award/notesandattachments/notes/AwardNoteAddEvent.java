/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notesandattachments.notes;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class is for the event to add award note
 */
public class AwardNoteAddEvent  extends AwardNoteEventBase<AwardNoteAddRule> {
    
    private static final String MSG = "Add award note  ";
    
    public AwardNoteAddEvent(String errorPathPrefix, AwardDocument document, AwardNotepad awardNotepad, ErrorType type) {
        super(MSG + getDocumentId(document), errorPathPrefix, document, awardNotepad, type);
    }
    
    public AwardNoteAddEvent(String errorPathPrefix, Document document, AwardNotepad awardNotepad, ErrorType type) {
        this(errorPathPrefix, (AwardDocument)document, awardNotepad, type);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {
        return new AwardNoteAddRule();
    }

}
