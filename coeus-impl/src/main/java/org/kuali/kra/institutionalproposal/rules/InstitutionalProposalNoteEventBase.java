/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.rules;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalNotepad;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class is the event base class for all INSP note event.
 */
@SuppressWarnings("unchecked")
public abstract class InstitutionalProposalNoteEventBase<Z extends KcBusinessRule> extends KcDocumentEventBaseExtension {
    
    /**
     * Enum helps identify type of error to respond.
     */
    public enum ErrorType {HARDERROR, SOFTERROR};
    
    
    private InstitutionalProposalNotepad institutionalProposalNotepad;
    
    private ErrorType type;
    
    public InstitutionalProposalNoteEventBase(String description, String errorPathPrefix, Document document,  InstitutionalProposalNotepad institutionalProposalNotepad, ErrorType type) {        
        super(description, errorPathPrefix, document);
        this.institutionalProposalNotepad = institutionalProposalNotepad;
        this.type = type;
    }
    
    
    /**
     * This method should return instance of institutionalProposalNotepad.
     * @return
     */
    public InstitutionalProposalNotepad getInstitutionalProposalNotepad(){
        return this.institutionalProposalNotepad;
    }
    
    /**
     * This method should return Error type.
     * @return
     */
    public ErrorType getType() {
        return this.type;
    }


}
