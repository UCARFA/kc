/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment.institute;

import org.kuali.coeus.propdev.impl.attachment.institute.AddInstituteAttachmentEvent;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.attachment.institute.ReplaceInstituteAttachmentRule;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class ReplaceInstituteAttachmentEvent extends AddInstituteAttachmentEvent {

    public ReplaceInstituteAttachmentEvent(String errorPathPrefix, ProposalDevelopmentDocument document, Narrative narrative) {
        super(errorPathPrefix, document, narrative);
    }
    
    @Override
    public Class getRuleInterfaceClass() {
        return ReplaceInstituteAttachmentRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((ReplaceInstituteAttachmentRule) rule).processReplaceInstituteAttachmentBusinessRules(this);
    }

}
