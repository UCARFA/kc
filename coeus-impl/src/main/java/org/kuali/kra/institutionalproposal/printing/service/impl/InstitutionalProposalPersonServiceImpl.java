/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.printing.service.impl;

import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.person.creditsplit.CreditSplitConstants;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPerson;
import org.kuali.kra.institutionalproposal.printing.service.InstitutionalProposalPersonService;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * These class have different methods to provide service like pass proposal
 * number get the list of proposal persons.
 */
public class InstitutionalProposalPersonServiceImpl implements
		InstitutionalProposalPersonService {
	private BusinessObjectService businessObjectService;
	
	@Autowired
	@Qualifier("dataObjectService")
	private DataObjectService dataObjectService;

    @Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService;

	/**
	 * This method will return the list of proposal persons if proposal person
	 * find in development proposal.
	 * 
	 * @param proposalNumber
	 *            is a number used to get the proposal persons for this proposal
	 *            number.
	 * @return list of proposal persons
	 */
	@Override
    public List<ProposalPerson> getInvestigatorsFromDevelopmentProposal(
			String proposalNumber) {
		List<ProposalPerson> proposalPersonsList = new ArrayList<ProposalPerson>();
		List<DevelopmentProposal> developmentProposals = (List<DevelopmentProposal>) dataObjectService
				.find(DevelopmentProposal.class, proposalNumber);
		if (developmentProposals != null && !developmentProposals.isEmpty()) {
			DevelopmentProposal developmentProposal = developmentProposals
					.get(0);
			if (developmentProposal.getProposalPersons() != null) {
				for(ProposalPerson proposalPerson:developmentProposal.getProposalPersons()){
					if(ContactRole.PI_CODE.equals(proposalPerson.getProjectRole()) || ContactRole.COI_CODE.equals(proposalPerson.getProjectRole())){
						proposalPersonsList.add(proposalPerson);
					}
				}
			}
		}
		return proposalPersonsList;
	}

    @Override
    public Boolean isCreditSplitOptInEnabled() {
        return parameterService.getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE,
                CreditSplitConstants.ENABLE_OPT_IN_PERSONNEL_CREDIT_SPLIT_FUNCTIONALITY);
    }

    @Override
    public Boolean generateCreditSplitForPerson(InstitutionalProposalPerson person) {
        final boolean optIn = isCreditSplitOptInEnabled();
        return (!optIn || person.getIncludeInCreditAllocation());
    }

    @Override
    public List<InstitutionalProposalPerson> getPersonsSelectedForCreditSplit(List<InstitutionalProposalPerson> projectPersons) {
        final List<InstitutionalProposalPerson> institutionalProposalPersons = projectPersons.stream()
                .filter(person -> generateCreditSplitForPerson(person))
                .collect(Collectors.toList());
        return institutionalProposalPersons;
    }

	public BusinessObjectService getBusinessObjectService() {
		return businessObjectService;
	}

	public void setBusinessObjectService(
			BusinessObjectService businessObjectService) {
		this.businessObjectService = businessObjectService;
	}

	protected DataObjectService getDataObjectService() {
		return dataObjectService;
	}

	public void setDataObjectService(DataObjectService dataObjectService) {
		this.dataObjectService = dataObjectService;
	}
}
