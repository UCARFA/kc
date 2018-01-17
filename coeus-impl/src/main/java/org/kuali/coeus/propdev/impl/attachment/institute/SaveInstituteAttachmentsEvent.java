/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment.institute;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.attachment.NarrativeEventBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class SaveInstituteAttachmentsEvent extends NarrativeEventBase {
    /**
     * Constructs an SaveInstituteAttachmentsEvent with the given errorPathPrefix, document, and proposalPerson.
     * 
     * @param errorPathPrefix
     * @param proposalDevelopmentDocument
     */
    public SaveInstituteAttachmentsEvent(String errorPathPrefix, ProposalDevelopmentDocument document) {
        super("Adding institute attachment to document " + getDocumentId(document), errorPathPrefix, document);
    }

    /**
     * Constructs an SaveInstituteAttachmentsEvent with the given errorPathPrefix, document, and proposalPerson.
     * 
     * @param errorPathPrefix
     * @param document
     */
    public SaveInstituteAttachmentsEvent(String errorPathPrefix, Document document) {
        this(errorPathPrefix, (ProposalDevelopmentDocument) document);
    }

    @Override
    public Class getRuleInterfaceClass() {
        return SaveInstituteAttachmentsRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((SaveInstituteAttachmentsRule) rule).processSaveInstituteAttachmentsBusinessRules(this);
    }
    

}
