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

import java.util.List;

/**
 * Event class for deleting a congressional district from a Proposal Site.
 */
public class DeleteProposalCongressionalDistrictEvent extends BasicProposalSiteEvent {
    private String districtIndex;

    /**
     * Constructor for use with a ProposalSite reference.
     * @param errorPathPrefix
     * @param proposalDevelopmentDocument
     * @param proposalSite
     * @param districtIndex
     */
    public DeleteProposalCongressionalDistrictEvent(String errorPathPrefix, ProposalDevelopmentDocument proposalDevelopmentDocument, ProposalSite proposalSite, String districtIndex) {
        super(getEventDescription(proposalDevelopmentDocument), errorPathPrefix, proposalDevelopmentDocument, proposalSite);
        this.districtIndex = districtIndex;
    }

    /**
     * Constructor for use with a List of ProposalSites, and an index into the List.
     * @param errorPathPrefix
     * @param proposalDevelopmentDocument
     * @param proposalSites
     * @param siteIndex
     * @param districtIndex
     */
    public DeleteProposalCongressionalDistrictEvent(String errorPathPrefix, ProposalDevelopmentDocument proposalDevelopmentDocument, List<ProposalSite> proposalSites, String siteIndex, String districtIndex) {
        super(getEventDescription(proposalDevelopmentDocument), errorPathPrefix, proposalDevelopmentDocument, proposalSites, siteIndex);
        this.districtIndex = districtIndex;
    }

    public String getDistrictIndex() {
        return districtIndex;
    }

    private static String getEventDescription(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        return "deleting congressional district from document " + getDocumentId(proposalDevelopmentDocument);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Class getRuleInterfaceClass() {
        return DeleteCongressionalDistrictRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((DeleteCongressionalDistrictRule)rule).processDeleteCongressionalDistrictRules(this);
    }
}
