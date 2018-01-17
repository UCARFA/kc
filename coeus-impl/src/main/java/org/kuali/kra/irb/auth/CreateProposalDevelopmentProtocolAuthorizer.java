/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.protocol.funding.ProtocolFundingSource;
import org.kuali.kra.protocol.protocol.funding.ProtocolFundingSourceBase;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;
/**
 * This service class is used to do authorization for create proposal task for proposal development document.  
 */
public class CreateProposalDevelopmentProtocolAuthorizer extends ProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {

        Protocol protocol = (Protocol)task.getProtocol();

        return ( canCreateProposal() && hasProposalRequiredFields(protocol)); 
    }

    private boolean canCreateProposal() {
        return hasUnitPermission(GlobalVariables.getUserSession().getPrincipalId(), Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, PermissionConstants.CREATE_PROPOSAL);
    }
        
    private boolean hasProposalRequiredFields(Protocol protocol)
    {
        boolean isProtocolSaved = protocol.getProtocolDocument().getDocumentHeader().getWorkflowDocument().isSaved();
        boolean validProposalRequiredFields=true;

        if (!isProtocolSaved)
        {
            validProposalRequiredFields = false;
        }
        
        if (StringUtils.isEmpty(protocol.getTitle()))
        {
            validProposalRequiredFields = false;
        }
        if (StringUtils.isEmpty(protocol.getLeadUnitNumber()))
        {
            validProposalRequiredFields = false;
        }
        if (StringUtils.isEmpty(protocol.getPrincipalInvestigatorId()))
        {
            validProposalRequiredFields = false;
        }
        // find sponsor from funding source
        List<ProtocolFundingSourceBase> protocolFundingSources = protocol.getProtocolFundingSources();
        ProtocolFundingSource sponsorProtocolFundingSource = null; 
        for(ProtocolFundingSourceBase protocolFundingSource : protocolFundingSources)
        {
            if ( protocolFundingSource.isSponsorFunding() )
            {
                sponsorProtocolFundingSource = (ProtocolFundingSource) protocolFundingSource;
                break;
            }
        }
        if(sponsorProtocolFundingSource == null)
        {
            validProposalRequiredFields = false;
        }
        
        return validProposalRequiredFields;
    }

}
