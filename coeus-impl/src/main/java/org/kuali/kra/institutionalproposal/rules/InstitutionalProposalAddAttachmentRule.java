/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.rules;

import org.kuali.rice.krad.rules.rule.BusinessRule;


public interface InstitutionalProposalAddAttachmentRule extends BusinessRule {

    /**
     * This method checks the Cost Share fields for validity.  Used for adding
     * @param institutionalProposalAddAttachmentRuleEvent
     * @return true if valid, false otherwise
     */
    boolean processAddInstitutionalProposalAttachmentBusinessRules(InstitutionalProposalAddAttachmentRuleEvent institutionalProposalAddAttachmentRuleEvent);
    boolean processSaveInstitutionalProposalAttachment(InstitutionalProposalAddAttachmentRuleEvent institutionalProposalAttachment, int i);
    
}
