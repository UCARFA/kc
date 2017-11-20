package edu.ucar.fanda.kuali.kra.institutionalproposal.service.impl;

import org.kuali.coeus.sys.framework.util.CollectionUtils;
import org.kuali.kra.institutionalproposal.document.authorization.InstitutionalProposalDocumentAuthorizer;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.service.impl.InstitutionalProposalLookupableHelperServiceImpl;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.krad.util.GlobalVariables;
import edu.ucar.fanda.kuali.kra.institutionalproposal.document.authorization.UcarInstitutionalProposalDocumentAuthorizer;
import java.util.List;
import java.util.stream.Collectors;

public class UcarInstitutionalProposalLookupableHelperServiceImpl extends InstitutionalProposalLookupableHelperServiceImpl {

    /**
     * This method filters results so that the person doing the lookup only gets back the documents he can view.
     */
    @Override
    protected List<InstitutionalProposal> filterForPermissions(List<InstitutionalProposal> results) {
        Person user = GlobalVariables.getUserSession().getPerson();
        UcarInstitutionalProposalDocumentAuthorizer authorizer = new UcarInstitutionalProposalDocumentAuthorizer();
        List<InstitutionalProposal> filteredResults = CollectionUtils.createCorrectImplementationForCollection(results);
        filteredResults.addAll(results.stream().filter(institutionalProposal -> authorizer.canOpen(institutionalProposal.getInstitutionalProposalDocument(), user)).collect(Collectors.toList()));

        return filteredResults;
    }
}
