/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.rules;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalNotepad;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class is for the event to add Institutional Proposal note
 */
public class InstitutionalProposalNoteAddEvent  extends InstitutionalProposalNoteEventBase<InstitutionalProposalNoteAddRule> {
    
    private static final String MSG = "Add Institutional Proposal note  ";
    
    public InstitutionalProposalNoteAddEvent(String errorPathPrefix, InstitutionalProposalDocument document, InstitutionalProposalNotepad institutionalProposalNotepad, ErrorType type) {
        super(MSG + getDocumentId(document), errorPathPrefix, document, institutionalProposalNotepad, type);
    }
    
    public InstitutionalProposalNoteAddEvent(String errorPathPrefix, Document document, InstitutionalProposalNotepad institutionalProposalNotepad, ErrorType type) {
        this(errorPathPrefix, (InstitutionalProposalDocument)document, institutionalProposalNotepad, type);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {
        return new InstitutionalProposalNoteAddRule();
    }

}
