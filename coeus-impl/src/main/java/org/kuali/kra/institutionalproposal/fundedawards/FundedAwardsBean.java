/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.fundedawards;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.version.history.VersionHistory;
import org.kuali.coeus.common.framework.version.history.VersionHistoryService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.fundingproposal.AwardFundingProposal;
import org.kuali.kra.institutionalproposal.ProposalStatus;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.GlobalVariables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Web tier helper bean for Funded Awards panel in Institutional Proposal Actions.
 */
public class FundedAwardsBean implements Serializable {
    

    private static final long serialVersionUID = 7202420195219545687L;
    
    private static final String ERROR_UNLOCK_PENDING_AWARDS = "error.institutionalProposal.unlockAward.pendingVersion";
    
    private InstitutionalProposalForm institutionalProposalForm;
    
    private transient BusinessObjectService businessObjectService;
    
	public FundedAwardsBean() {
        super();
    }
    
    /**
     * Constructs a FundedAwardsBean.java.
     * @param institutionalProposalForm the Form.
     */
    public FundedAwardsBean(InstitutionalProposalForm institutionalProposalForm) {
        this();
        this.institutionalProposalForm = institutionalProposalForm;
    }
    
    /**
     * Unlock the selected awards.  If all awards are unlocked, proposal status should be set to 'pending'.
     */
    public void removeUnlockedAwards() {
        InstitutionalProposal institutionalProposal = institutionalProposalForm.getInstitutionalProposalDocument().getInstitutionalProposal();
        
        Set<String> linkedPendingAwards = getLinkedPendingAwards(institutionalProposal, institutionalProposalForm.getSelectedAwardFundingProposals());
        if (!linkedPendingAwards.isEmpty()) {
            String awardNumbers = StringUtils.join(linkedPendingAwards, ", ");
            GlobalVariables.getMessageMap().putError("noKey", 
                    ERROR_UNLOCK_PENDING_AWARDS, 
                    awardNumbers);
        } else {
        	List<AwardFundingProposal> removedFundingProposals = new ArrayList();
            ArrayUtils.reverse(institutionalProposalForm.getSelectedAwardFundingProposals());
            for (String indexToRemove : institutionalProposalForm.getSelectedAwardFundingProposals()) {
            	removedFundingProposals.add(institutionalProposal.getAllFundingProposals().get(Integer.parseInt(indexToRemove)));
                institutionalProposal.getAllFundingProposals().remove(Integer.parseInt(indexToRemove));
            }
            getBusinessObjectService().delete(removedFundingProposals);
            if (institutionalProposal.getAllFundingProposals().isEmpty()) {
                institutionalProposal.setStatusCode(ProposalStatus.PENDING);
            }
            institutionalProposalForm.setSelectedAwardFundingProposals(null);
        }
    }
    
    /**
     * Mark all funded awards in the list as selected.
     */
    public void selectAllFundedAwards() {
        String[] selectedAwardFundingProposals = 
            new String[institutionalProposalForm.getInstitutionalProposalDocument().getInstitutionalProposal().getAwardFundingProposals().size()];
        for (int i = 0; i < institutionalProposalForm.getInstitutionalProposalDocument().getInstitutionalProposal().getAwardFundingProposals().size(); i++) {
            selectedAwardFundingProposals[i] = Integer.toString(i);
        }
        institutionalProposalForm.setSelectedAwardFundingProposals(selectedAwardFundingProposals);
    }
    
    /*
     * Find linked awards to be unlocked that have a version status of Pending.
     */
    private Set<String> getLinkedPendingAwards(InstitutionalProposal institutionalProposal, String[] awardsToUnlock) {
        Set<String> linkedPendingAwards = new HashSet<String>();
        VersionHistoryService versionHistoryService = KcServiceLocator.getService(VersionHistoryService.class);
        for (String index : awardsToUnlock) {
            AwardFundingProposal fundingProposal = institutionalProposal.getAllFundingProposals().get(Integer.parseInt(index));
            VersionHistory pendingVersionHistory = versionHistoryService.findPendingVersion(Award.class, 
                    fundingProposal.getAward().getAwardNumber(), fundingProposal.getAward().getSequenceNumber().toString());
            if (pendingVersionHistory != null) {
                linkedPendingAwards.add(fundingProposal.getAward().getAwardNumber());
            }
        }
        return linkedPendingAwards;
    }

    public BusinessObjectService getBusinessObjectService() {
    	  if (this.businessObjectService == null) {
              this.businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
          }
          return this.businessObjectService;
	}

	public void setBusinessObjectService(BusinessObjectService businessObjectService) {
		this.businessObjectService = businessObjectService;
	}
}
