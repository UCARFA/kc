/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.location;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * Rule event class for adding a Proposal Site to a proposal
 */
public class AddProposalSiteEvent extends BasicProposalSiteEvent {
    
    /**
     * Constructs an AddProposalSiteEvent with the given errorPathPrefix, document, and proposalSite.
     * 
     * @param errorPathPrefix
     * @param document
     * @param proposalSite
     */
    public AddProposalSiteEvent(String errorPathPrefix, ProposalDevelopmentDocument document, ProposalSite proposalSite) {
        super("adding site to document " + getDocumentId(document), errorPathPrefix, document, proposalSite);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class getRuleInterfaceClass() {
        return AddProposalSiteRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddProposalSiteRule) rule).processAddProposalSiteBusinessRules(this);
    }

}
