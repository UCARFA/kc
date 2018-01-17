/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRoleQualifier;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.rice.kim.api.KimConstants;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Implements the DevelopmentProposalNotificationRoleQualifierService.
 */
@Component("proposalDevelopmentNotificationRoleQualifierService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProposalDevelopmentNotificationRoleQualifierServiceImpl implements ProposalDevelopmentNotificationRoleQualifierService {

    private DevelopmentProposal developmentProposal;
    
    @Override
    public String getRoleQualifierValue(NotificationModuleRoleQualifier qualifier) {
        String roleQualifierValue = null;
        if (StringUtils.equals(qualifier.getQualifier(), KcKimAttributes.PROPOSAL)) {
            roleQualifierValue = developmentProposal.getProposalNumber();
        }
        else if (StringUtils.equals(qualifier.getQualifier(), KcKimAttributes.UNIT_NUMBER)) {
            if (developmentProposal.getUnitNumber() != null) {
                roleQualifierValue = developmentProposal.getUnitNumber();
            }
        } else if (StringUtils.equals(qualifier.getQualifier(), KimConstants.AttributeConstants.DOCUMENT_NUMBER)) {
            roleQualifierValue = developmentProposal.getProposalDocument().getDocumentNumber();
        }
        
        return roleQualifierValue;
    }

    @Override
    public DevelopmentProposal getDevelopmentProposal() {
        return developmentProposal;
    }
    
    @Override
    public void setDevelopmentProposal(DevelopmentProposal developmentProposal) {
        this.developmentProposal = developmentProposal;
    }

}
