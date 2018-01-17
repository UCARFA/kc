/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.attachment;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class AddPersonnelAttachmentEvent extends PersonnelAttachmentEventBase {
    /**
     * Constructs an AddPersonnelAttachmentEvent with the given errorPathPrefix, document, and proposalPersonBiography.
     * 
     * @param errorPathPrefix
     * @param proposalDevelopmentDocument
     * @param proposalPersonBiography
     */
    public AddPersonnelAttachmentEvent(String errorPathPrefix, ProposalDevelopmentDocument document, ProposalPersonBiography proposalPersonBiography) {
        super("adding personnel attachment to document " + getDocumentId(document), errorPathPrefix, document, proposalPersonBiography);
    }

    /**
     * Constructs an AddPersonnelAttachmentEvent with the given errorPathPrefix, document, and proposalPersonBiography.
     * 
     * @param errorPathPrefix
     * @param document
     * @param narrative
     */
    public AddPersonnelAttachmentEvent(String errorPathPrefix, Document document, ProposalPersonBiography proposalPersonBiography) {
        this(errorPathPrefix, (ProposalDevelopmentDocument) document, proposalPersonBiography);
    }

    @Override
    public Class getRuleInterfaceClass() {
        return AddPersonnelAttachmentRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddPersonnelAttachmentRule) rule).processAddPersonnelAttachmentBusinessRules(this);
    }

}
