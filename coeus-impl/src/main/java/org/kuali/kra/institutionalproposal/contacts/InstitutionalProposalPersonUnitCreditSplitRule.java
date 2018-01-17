/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.kuali.coeus.common.framework.type.InvestigatorCreditType;



public interface InstitutionalProposalPersonUnitCreditSplitRule extends org.kuali.rice.krad.rules.rule.BusinessRule {

    String PROPOSAL_CREDIT_SPLIT_LIST_ERROR_KEY = "document.institutionalProposalList[0].projectPersons.institutionalProposalPersonCreditSplits";
    String PROPOSAL_PERSON_UNIT_CREDIT_SPLIT_ERROR_MSG_KEY = "error.award.person.unit.credit.split.error";
    
    /**
     * Check if the {@link InvestigatorCreditType} requires totals add to 100
     * @param event
     * @return
     */
    boolean checkInstitutionalProposalPersonUnitCreditSplitTotals(InstitutionalProposalPersonUnitCreditSplitRuleEvent event);
}
