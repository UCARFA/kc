/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.attachment;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.person.attachment.AddPersonnelAttachmentEvent;
import org.kuali.coeus.propdev.impl.person.attachment.ProposalPersonBiography;
import org.kuali.coeus.propdev.impl.person.attachment.ReplacePersonnelAttachmentRule;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class ReplacePersonnelAttachmentEvent extends AddPersonnelAttachmentEvent {

    /**
     * Constructs a ReplacePersonnelAttachmentEvent with the given errorPathPrefix, document, and ProposalPersonBiography.
     * 
     * @param errorPathPrefix
     * @param document
     * @param proposalPersonBiography
     */
    public ReplacePersonnelAttachmentEvent(String errorPathPrefix, ProposalDevelopmentDocument document,
            ProposalPersonBiography proposalPersonBiography) {
        super(errorPathPrefix, document, proposalPersonBiography);
    }

    @Override
    public Class getRuleInterfaceClass() {
        return ReplacePersonnelAttachmentRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((ReplacePersonnelAttachmentRule) rule).processReplacePersonnelAttachmentBusinessRules(this);
    }
    
}
