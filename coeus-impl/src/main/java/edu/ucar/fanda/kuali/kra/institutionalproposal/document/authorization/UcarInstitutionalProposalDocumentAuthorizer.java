package edu.ucar.fanda.kuali.kra.institutionalproposal.document.authorization;

import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.document.authorization.InstitutionalProposalDocumentAuthorizer;
import org.kuali.kra.kim.bo.KcKimAttributes;

import java.util.Map;

public class UcarInstitutionalProposalDocumentAuthorizer extends InstitutionalProposalDocumentAuthorizer {

    @Override
    protected void addRoleQualification(
            Object primaryBusinessObjectOrDocument,
            Map<String, String> attributes) {
        super.addRoleQualification(primaryBusinessObjectOrDocument, attributes);
        InstitutionalProposalDocument institutionalProposalDocument = (InstitutionalProposalDocument) primaryBusinessObjectOrDocument;
        if (institutionalProposalDocument.getInstitutionalProposal() != null
                && institutionalProposalDocument.getInstitutionalProposal().getLeadUnit() != null) {
            attributes.put(KcKimAttributes.UNIT_NUMBER, institutionalProposalDocument.getInstitutionalProposal().getLeadUnit().getUnitNumber());
            // KTW - add proposal id if there is one.
            if (  institutionalProposalDocument.getInstitutionalProposal().getProposalId() != null){
                attributes.put(KcKimAttributes.PROPOSAL,
                        institutionalProposalDocument
                                .getInstitutionalProposal().getProposalId().toString());
            }
        } else {
            attributes.put(KcKimAttributes.UNIT_NUMBER, "*");
            // KTW
            if (institutionalProposalDocument.getInstitutionalProposal() != null) {
                attributes.put(KcKimAttributes.PROPOSAL,
                        institutionalProposalDocument.getInstitutionalProposal().getProposalId().toString());
            }
        }
    }
}
