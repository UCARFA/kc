/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRoleQualifier;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kim.api.KimConstants;

/**
 * Implements the InstitutionalProposalNotificationRoleQualifierService.
 */
public class InstitutionalProposalNotificationRoleQualifierServiceImpl implements InstitutionalProposalNotificationRoleQualifierService {

    private InstitutionalProposal institutionalProposal;
    
    @Override
    public String getRoleQualifierValue(NotificationModuleRoleQualifier qualifier) {
        String roleQualifierValue = null;
        if (StringUtils.equals(qualifier.getQualifier(), KcKimAttributes.PROPOSAL)) {
            roleQualifierValue = institutionalProposal.getProposalId().toString();
        }
        else if (StringUtils.equals(qualifier.getQualifier(), KcKimAttributes.UNIT_NUMBER)) {
            if (institutionalProposal.getUnitNumber() != null) {
                roleQualifierValue = institutionalProposal.getUnitNumber();
            }
        } else if (StringUtils.equals(qualifier.getQualifier(), KimConstants.AttributeConstants.DOCUMENT_NUMBER)) {
            roleQualifierValue = institutionalProposal.getInstitutionalProposalDocument().getDocumentNumber();
        }
        
        return roleQualifierValue;
    }

    @Override
    public InstitutionalProposal getInstitutionalProposal() {
        return institutionalProposal;
    }
    
    @Override
    public void setInstitutionalProposal(InstitutionalProposal institutionalProposal) {
        this.institutionalProposal = institutionalProposal;
    }

}
