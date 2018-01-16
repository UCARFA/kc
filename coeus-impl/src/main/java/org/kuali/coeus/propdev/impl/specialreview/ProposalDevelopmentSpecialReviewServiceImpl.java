/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.specialreview;

import org.kuali.coeus.common.framework.compliance.core.AddSpecialReviewEvent;
import org.kuali.coeus.common.framework.compliance.core.ComplianceConstants;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.common.framework.compliance.core.SpecialReviewApprovalType;
import org.kuali.coeus.common.framework.compliance.core.SpecialReviewType;
import org.kuali.kra.iacuc.protocol.funding.IacucProtocolProposalDevelopmentProtocolDocumentService;
import org.kuali.kra.iacuc.specialreview.IacucProtocolSpecialReviewService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.protocol.funding.ProposalDevelopmentProtocolDocumentService;
import org.kuali.kra.irb.specialreview.ProtocolSpecialReviewService;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.service.KualiRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("proposalDevelopmentSpecialReviewService")
public class ProposalDevelopmentSpecialReviewServiceImpl implements ProposalDevelopmentSpecialReviewService {

    @Autowired
    @Qualifier("proposalDevelopmentProtocolDocumentService")
    private ProposalDevelopmentProtocolDocumentService proposalDevelopmentProtocolDocumentService;
    @Autowired
    @Qualifier("iacucProtocolProposalDevelopmentProtocolDocumentService")
    private IacucProtocolProposalDevelopmentProtocolDocumentService iacucProtocolProposalDevelopmentProtocolDocumentService;
    @Autowired
    @Qualifier("protocolSpecialReviewService")
    private ProtocolSpecialReviewService protocolSpecialReviewService;
    @Autowired
    @Qualifier("iacucProtocolSpecialReviewService")
    private IacucProtocolSpecialReviewService iacucProtocolSpecialReviewService;
    @Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService;
    @Autowired
    @Qualifier("kualiRuleService")
    private KualiRuleService kualiRuleService;

	@Override
    public boolean createProtocol(ProposalSpecialReview specialReview, ProposalDevelopmentDocument document) throws Exception {
        if (SpecialReviewType.HUMAN_SUBJECTS.equals(specialReview.getSpecialReviewTypeCode())) {
            if (isCreateIrbProtocolEnabled()) {
                ProposalDevelopmentProtocolDocumentService service = getProposalDevelopmentProtocolDocumentService(); 
                ProtocolDocument protocolDocument = service.createProtocolDocument(document);
                if (protocolDocument != null )
                {
                    specialReview.setSpecialReviewTypeCode(SpecialReviewType.HUMAN_SUBJECTS);
                    if(specialReview.getSpecialReviewNumber() == null) {
                    	specialReview.setSpecialReviewNumber(generateSpecialReviewNumber(document));
                    }
                    specialReview.setApprovalTypeCode(SpecialReviewApprovalType.PENDING);
                    specialReview.setProtocolNumber(protocolDocument.getProtocol().getProtocolNumber());
                    specialReview.setDevelopmentProposal(document.getDevelopmentProposal());
                    specialReview.setProtocolStatus(protocolDocument.getProtocol().getProtocolStatus().getDescription());
                    specialReview.setComments(ComplianceConstants.NEW_SPECIAL_REVIEW_COMMENT);

                    prepareProtocolLinkViewFields(specialReview);
                    if (getKualiRuleService().applyRules(new AddSpecialReviewEvent<ProposalSpecialReview>(document, specialReview, 
                            document.getDevelopmentProposal().getPropSpecialReviews(), isIrbLinkingEnabled()))) {
                        document.getDevelopmentProposal().getPropSpecialReviews().add(specialReview);
                        return true;
                    }
                }
            }
        } else if (SpecialReviewType.ANIMAL_USAGE.equals(specialReview.getSpecialReviewTypeCode())) {
            if (isCreateIacucProtocolEnabled()) {
                IacucProtocolProposalDevelopmentProtocolDocumentService service = getIacucProtocolProposalDevelopmentProtocolDocumentService(); 
                ProtocolDocumentBase protocolDocument = service.createProtocolDocument(document);
                if (protocolDocument != null) {
                    specialReview.setSpecialReviewTypeCode(SpecialReviewType.ANIMAL_USAGE);
                    if(specialReview.getSpecialReviewNumber() == null) {
                    	specialReview.setSpecialReviewNumber(generateSpecialReviewNumber(document));
                    }
                    specialReview.setApprovalTypeCode(SpecialReviewApprovalType.PENDING);
                    specialReview.setProtocolNumber(protocolDocument.getProtocol().getProtocolNumber());
                    specialReview.setDevelopmentProposal(document.getDevelopmentProposal());
                    specialReview.setProtocolStatus(protocolDocument.getProtocol().getProtocolStatus().getDescription());
                    specialReview.setComments(ComplianceConstants.NEW_SPECIAL_REVIEW_COMMENT);
        
                    prepareProtocolLinkViewFields(specialReview);
                    if (getKualiRuleService().applyRules(new AddSpecialReviewEvent<ProposalSpecialReview>(document, specialReview, 
                            document.getDevelopmentProposal().getPropSpecialReviews(), isIacucLinkingEnabled()))) {
                        document.getDevelopmentProposal().getPropSpecialReviews().add(specialReview);
                        return true;
                    }
                }
            }
        }
        return false;
    }
	
	@Override
	public Integer generateSpecialReviewNumber(ProposalDevelopmentDocument document) {
		return document.getDocumentNextValue(Constants.PROPOSAL_SPECIALREVIEW_NUMBER);
	}
    
    /**
     * Prepares the linked fields on the Special Review that are pulled directly from the Protocol and not from the local object.
     * @param specialReview the Special Review to update
     */
    public void prepareProtocolLinkViewFields(ProposalSpecialReview specialReview) {
        if (isIrbLinkingEnabled() || isIacucLinkingEnabled()) {
            if (specialReview != null && SpecialReviewType.HUMAN_SUBJECTS.equals(specialReview.getSpecialReviewTypeCode())) {
                ProtocolSpecialReviewService protocolSpecialReviewService = getProtocolSpecialReviewService();
                protocolSpecialReviewService.populateSpecialReview(specialReview);
            }
            else if (specialReview != null && SpecialReviewType.ANIMAL_USAGE.equals(specialReview.getSpecialReviewTypeCode())) {
                IacucProtocolSpecialReviewService iacucProtocolSpecialReviewService = getIacucProtocolSpecialReviewService();
                iacucProtocolSpecialReviewService.populateSpecialReview(specialReview);
            }

        }
    }

    @Override
    public boolean isCreateIrbProtocolEnabled() {
    	return isIrbLinkingEnabled() &&	isCreateProtocolFromProposalEnabled(Constants.PROPOSAL_DEVELOPMENT_CREATE_IRB_PROTOCOL_ENABLED_PARAMETER);
    }

    @Override
    public boolean isCreateIacucProtocolEnabled() {
    	return isIacucLinkingEnabled() && isCreateProtocolFromProposalEnabled(Constants.PROPOSAL_DEVELOPMENT_CREATE_IACUC_PROTOCOL_ENABLED_PARAMETER);
    }
    
    @Override
    public boolean isIrbLinkingEnabled() {
    	return isProtocolLinkEnabled(Constants.MODULE_NAMESPACE_IRB, Constants.PROTOCOL_DEVELOPMENT_PROPOSAL_LINKING_ENABLED_PARAMETER);
    }

    @Override
    public boolean isIacucLinkingEnabled() {
    	return isProtocolLinkEnabled(Constants.MODULE_NAMESPACE_IACUC, Constants.IACUC_PROTOCOL_PROPOSAL_DEVELOPMENT_LINKING_ENABLED_PARAMETER);
    }

    /**
     * Method to check proposal to protocol link is enabled
     * @param moduleNameSpace
     * @param proposalLinkParam
     * @return
     */
    private boolean isProtocolLinkEnabled(String moduleNameSpace, String proposalLinkParam) {
    	return getParameterService().getParameterValueAsBoolean(moduleNameSpace, Constants.PARAMETER_COMPONENT_DOCUMENT, proposalLinkParam);
    }

    /**
     * Method to check create protocol from proposal is enabled
     * @param protocolLinkParam
     * @return
     */
    @Override
    public boolean isCreateProtocolFromProposalEnabled(String protocolLinkParam) {
    	return getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, Constants.PARAMETER_COMPONENT_DOCUMENT, protocolLinkParam);
    }
    
    @Override
    public boolean canCreateIrbProtocol(ProposalDevelopmentDocument document) {
        return getProposalDevelopmentProtocolDocumentService().isAuthorizedCreateProtocol(document); 
    }
    
    @Override
    public boolean canCreateIacucProtocol(ProposalDevelopmentDocument document) {
        return getIacucProtocolProposalDevelopmentProtocolDocumentService().isAuthorizedCreateProtocol(document);
    }

    protected ProposalDevelopmentProtocolDocumentService getProposalDevelopmentProtocolDocumentService() {
        return proposalDevelopmentProtocolDocumentService;
    }

    public void setProposalDevelopmentProtocolDocumentService(
            ProposalDevelopmentProtocolDocumentService proposalDevelopmentProtocolDocumentService) {
        this.proposalDevelopmentProtocolDocumentService = proposalDevelopmentProtocolDocumentService;
    }

    public ParameterService getParameterService() {
        return parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    public IacucProtocolProposalDevelopmentProtocolDocumentService getIacucProtocolProposalDevelopmentProtocolDocumentService() {
        return iacucProtocolProposalDevelopmentProtocolDocumentService;
    }

    public void setIacucProtocolProposalDevelopmentProtocolDocumentService(
            IacucProtocolProposalDevelopmentProtocolDocumentService iacucProtocolProposalDevelopmentProtocolDocumentService) {
        this.iacucProtocolProposalDevelopmentProtocolDocumentService = iacucProtocolProposalDevelopmentProtocolDocumentService;
    }

    protected ProtocolSpecialReviewService getProtocolSpecialReviewService() {
        return protocolSpecialReviewService;
    }

    public void setProtocolSpecialReviewService(ProtocolSpecialReviewService protocolSpecialReviewService) {
        this.protocolSpecialReviewService = protocolSpecialReviewService;
    }

    protected IacucProtocolSpecialReviewService getIacucProtocolSpecialReviewService() {
        return iacucProtocolSpecialReviewService;
    }

    public void setIacucProtocolSpecialReviewService(IacucProtocolSpecialReviewService iacucProtocolSpecialReviewService) {
        this.iacucProtocolSpecialReviewService = iacucProtocolSpecialReviewService;
    }
    
    public KualiRuleService getKualiRuleService() {
  		return kualiRuleService;
  	}

  	public void setKualiRuleService(KualiRuleService kualiRuleService) {
  		this.kualiRuleService = kualiRuleService;
  	}

}
