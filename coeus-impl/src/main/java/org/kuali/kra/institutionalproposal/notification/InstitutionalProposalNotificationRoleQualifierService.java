/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.notification;

import org.kuali.coeus.common.notification.impl.service.KcNotificationRoleQualifierService;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;

/**
 * Defines the service to fill in module role qualifier information for Institutional Proposal.
 */
public interface InstitutionalProposalNotificationRoleQualifierService extends KcNotificationRoleQualifierService {

    /**
     * Returns the Institutional Proposal.
     * 
     * @return the Institutional Proposal
     */
    InstitutionalProposal getInstitutionalProposal();
    
    /**
     * Sets the Institutional Proposal.
     *
     * @param institutionalProposal the Institutional Proposal to set
     */
    void setInstitutionalProposal(InstitutionalProposal institutionalProposal);
    
}
