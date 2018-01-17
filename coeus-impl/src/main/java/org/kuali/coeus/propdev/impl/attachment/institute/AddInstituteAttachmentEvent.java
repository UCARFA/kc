/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment.institute;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.attachment.NarrativeEventBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class AddInstituteAttachmentEvent extends NarrativeEventBase {
    /**
     * Constructs an AddInstituteAttachmentEvent with the given errorPathPrefix, document, and narrative.
     * 
     * @param errorPathPrefix
     * @param proposalDevelopmentDocument
     * @param narrative
     */
    public AddInstituteAttachmentEvent(String errorPathPrefix, ProposalDevelopmentDocument document, Narrative narrative) {
        super("adding institute attachment to document " + getDocumentId(document), errorPathPrefix, document, narrative);
    }

    /**
     * Constructs an AddInstituteAttachmentEvent with the given errorPathPrefix, document, and narrative.
     * 
     * @param errorPathPrefix
     * @param document
     * @param narrative
     */
    public AddInstituteAttachmentEvent(String errorPathPrefix, Document document, Narrative narrative) {
        this(errorPathPrefix, (ProposalDevelopmentDocument) document, narrative);
    }

    @Override
    public Class getRuleInterfaceClass() {
        return AddInstituteAttachmentRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddInstituteAttachmentRule) rule).processAddInstituteAttachmentBusinessRules(this);
    }

}
