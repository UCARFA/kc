/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.proposaldevelopment.rules;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.attachment.ProposalDevelopmentProposalAttachmentsAuditRule;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.GlobalVariables;

import static org.junit.Assert.*;
import static org.kuali.coeus.propdev.impl.datavalidation.ProposalDevelopmentDataValidationConstants.*;

public class ProposalDevelopmentProposalAttachmentsAuditRuleTest extends ProposalDevelopmentRuleTestBase {
    
    ProposalDevelopmentProposalAttachmentsAuditRule rule;
    ProposalDevelopmentDocument proposalDevelopmentDocument;
    DevelopmentProposal developmentProposal;
    Narrative narrativeComplete;
    Narrative narrativeIncomplete;
    
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        rule = new ProposalDevelopmentProposalAttachmentsAuditRule();
        proposalDevelopmentDocument = this.getNewProposalDevelopmentDocument();
        developmentProposal = proposalDevelopmentDocument.getDevelopmentProposal();
        narrativeComplete = new Narrative();
        narrativeComplete.setModuleStatusCode("C");
        narrativeIncomplete = new Narrative();
        narrativeIncomplete.setModuleStatusCode("I");
    }
    
    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    @Test
    public void testIncompleteAttachments() {
        developmentProposal.getNarratives().add(narrativeComplete);
        assertTrue(rule.checkForIncompleteAttachments(developmentProposal));
        assertTrue(GlobalVariables.getAuditErrorMap().get(ATTACHMENT_PAGE_NAME + "." + ATTACHMENT_PROPOSAL_SECTION_NAME) == null);
        
        developmentProposal.getNarratives().add(narrativeIncomplete);
        assertFalse(rule.checkForIncompleteAttachments(developmentProposal));
        assertFalse(((AuditCluster) GlobalVariables.getAuditErrorMap().get(ATTACHMENT_PAGE_NAME + "." + ATTACHMENT_PROPOSAL_SECTION_NAME)).getAuditErrorList().isEmpty());
    }

}
