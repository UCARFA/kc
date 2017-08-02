package org.kuali.coeus.propdev.impl.attachment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.s2s.S2sOpportunity;

public class ProposalDevelopmentProposalAttachmentsAuditRuleTest {
    private DevelopmentProposal developmentProposal;
    private ProposalDevelopmentDocument proposalDevelopmentDocument;
    private Narrative narrative;
    private NarrativeType narrativeType;
    private ProposalDevelopmentProposalAttachmentsAuditRule rule;

    @Before
    public void before() {
        developmentProposal = new DevelopmentProposal();
        developmentProposal.setS2sOpportunity(new S2sOpportunity());

        proposalDevelopmentDocument = new ProposalDevelopmentDocument();
        proposalDevelopmentDocument.setDevelopmentProposal(developmentProposal);

        rule = new ProposalDevelopmentProposalAttachmentsAuditRule();

        narrative = new Narrative();
        narrative.setModuleTitle("valid title");
        narrativeType = new NarrativeType();
        narrativeType.setAllowMultiple(true);

        narrative.setNarrativeType(narrativeType);
    }

    @Test
    public void testWithInvalidModuleTitleContainingAmpersand() {
        narrative.setModuleTitle("foo & bar");
        Assert.assertFalse(rule.validModuleTitle(narrative, developmentProposal, 0));
    }

    @Test
    public void testWithValidModuleTitle() {
        Assert.assertTrue(rule.validModuleTitle(narrative, developmentProposal, 0));
    }

    @Test
    public void testWithInvalidModuleTitleEmptyS2SOpportunity() {
        narrative.setModuleTitle("foo & bar");
        developmentProposal.setS2sOpportunity(null);
        Assert.assertTrue(rule.validModuleTitle(narrative, developmentProposal, 0));
    }

    @Test
    public void testWithInvalidModuleTitleNotAllowMultiple() {
        narrative.setModuleTitle("foo & bar");
        narrativeType.setAllowMultiple(false);
        Assert.assertTrue(rule.validModuleTitle(narrative, developmentProposal, 0));
    }

    @Test
    public void testWithInvalidModuleTitleNotAllowMultipleValidS2sOpportunity() {
        narrative.setModuleTitle("foo & bar");
        narrativeType.setAllowMultiple(false);
        developmentProposal.setS2sOpportunity(new S2sOpportunity());
        Assert.assertTrue(rule.validModuleTitle(narrative, developmentProposal, 0));
    }
}
