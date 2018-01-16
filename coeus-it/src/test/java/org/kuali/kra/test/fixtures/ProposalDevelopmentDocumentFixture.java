/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.test.fixtures;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.propdev.impl.location.ProposalSite;
import org.kuali.rice.krad.service.DocumentService;

import java.sql.Date;
import java.text.SimpleDateFormat;

import static org.kuali.coeus.sys.framework.service.KcServiceLocator.getService;

/**
 * Fixture class for creating valid <code>{@link ProposalDevelopmentDocument}</code> instances.
 * 
 * @see org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument
 */
public enum ProposalDevelopmentDocumentFixture {
    NORMAL_DOCUMENT();
    
    private String description;
    private String sponsorCode;
    private String title;
    private String startDateInitial;
    private String endDateInitial;
    private String activityTypeCode;
    private String proposalTypeCode;
    private String ownedByUnit;

    private ProposalDevelopmentDocumentFixture() {
        this("KeyPersonnelAuditRuleTest test", "005889", "Project title", "08/14/2007", "08/21/2007", "1", "1", "000001");
    }
    
    private ProposalDevelopmentDocumentFixture(String description, String sponsorCode, String title, String startDateInitial, String endDateInitial, String activityTypeCode, String proposalTypeCode, String ownedByUnit) {
        this.description      = description;
        this.sponsorCode      = sponsorCode;
        this.title            = title;
        this.startDateInitial = startDateInitial;
        this.endDateInitial   = endDateInitial;
        this.activityTypeCode = activityTypeCode;
        this.proposalTypeCode = proposalTypeCode;
        this.ownedByUnit      = ownedByUnit;
    }

    public ProposalDevelopmentDocument getDocument() {
        ProposalDevelopmentDocument retval = null;
        try {
            Date requestedStartDateInitial = new Date(new SimpleDateFormat("MM/dd/yyyy").parse(startDateInitial).getTime());
            Date requestedEndDateInitial = new Date(new SimpleDateFormat("MM/dd/yyyy").parse(endDateInitial).getTime());
            retval = (ProposalDevelopmentDocument) getDocumentService().getNewDocument(ProposalDevelopmentDocument.class);
            setRequiredDocumentFields(retval, description, sponsorCode, title, requestedStartDateInitial, requestedEndDateInitial, activityTypeCode, proposalTypeCode, ownedByUnit);
        }
        catch (Exception e) {
            throw new RuntimeException(e);   
        }
        
        return retval;
    }

    
    /**
     * This method sets required document fields
     * @param document ProposalDevelopmentDocument to set fields for
     * @param description String financialdescription for the document header
     * @param sponsorCode String Sponsor code for the document
     * @param title String title of document
     * @param requestedStartDateInitial String start date
     * @param requestedEndDateInitial String end date
     * @param activityTypeCode String activity type code
     * @param proposalTypeCode String proposal type code
     * @param ownedByUnit String owned by unit
     */
    private void setRequiredDocumentFields(ProposalDevelopmentDocument document, String description, String sponsorCode, String title, Date requestedStartDateInitial, Date requestedEndDateInitial, String activityTypeCode, String proposalTypeCode, String ownedByUnit) {
        document.getDocumentHeader().setDocumentDescription(description);
        document.getDevelopmentProposal().setSponsorCode(sponsorCode);
        document.getDevelopmentProposal().setTitle(title);
        document.getDevelopmentProposal().setRequestedStartDateInitial(requestedStartDateInitial);
        document.getDevelopmentProposal().setRequestedEndDateInitial(requestedEndDateInitial);
        document.getDevelopmentProposal().setActivityTypeCode(activityTypeCode);
        document.getDevelopmentProposal().setProposalTypeCode(proposalTypeCode);
        document.getDevelopmentProposal().setOwnedByUnitNumber(ownedByUnit);
        
        for (ProposalSite site : document.getDevelopmentProposal().getProposalSites()) {
            site.setSiteNumber(document.getDocumentNextValue(Constants.PROPOSAL_LOCATION_SEQUENCE_NUMBER));
        }
    }
    
    private DocumentService getDocumentService() {  
        return getService(DocumentService.class);
    }
}
