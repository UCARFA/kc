/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.notification;

import org.kuali.coeus.common.notification.impl.service.KcNotificationRoleQualifierService;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;

/**
 * Defines the service to fill in module role qualifier information for Proposal Development.
 */
public interface ProposalDevelopmentNotificationRoleQualifierService extends KcNotificationRoleQualifierService {

    /**
     * Returns the Development Proposal.
     * 
     * @return the Development Proposal
     */
    DevelopmentProposal getDevelopmentProposal();
    
    /**
     * Sets the Development Proposal.
     *
     * @param developmentProposal the Development Proposal to set
     */
    void setDevelopmentProposal(DevelopmentProposal developmentProposal);
    
}
