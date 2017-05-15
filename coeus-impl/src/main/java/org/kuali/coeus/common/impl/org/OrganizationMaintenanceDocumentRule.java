/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.common.impl.org;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.coeus.common.framework.org.OrganizationYnq;
import org.kuali.coeus.common.api.rolodex.RolodexService;
import org.kuali.coeus.common.framework.org.audit.OrganizationAudit;
import org.kuali.coeus.common.framework.org.audit.OrganizationAuditAcceptedType;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;

import java.util.Collections;

public class OrganizationMaintenanceDocumentRule  extends KcMaintenanceDocumentRuleBase {

    private transient ErrorReporter errorReporter;
    private transient RolodexService rolodexService;
    
    @Override
    public boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return isDocumentValidForSave(document);
    }
    
    @Override
    public boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return isDocumentValidForSave(document);
    }
    
   
    @Override
    public boolean processCustomSaveDocumentBusinessRules(MaintenanceDocument document) {
        return isDocumentValidForSave(document);
    }

    @Override
    public boolean isDocumentValidForSave( MaintenanceDocument document ) {
        boolean result = super.isDocumentValidForSave(document);
        
        result &= checkYNQ(document);
        result &= checkRolodexEntries(document);
        result &= checkAudits(document);
        return result;
    }

    /**
     * 
     * This method to check Ynq's explanation and review date is required field based on answer.
     */
    private boolean checkYNQ(MaintenanceDocument maintenanceDocument) {
        ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);
        boolean valid = true;
        if (LOG.isDebugEnabled()) {
            LOG.debug("new maintainable is: " + maintenanceDocument.getNewMaintainableObject().getClass());
        }
        Organization newOrganization = (Organization) maintenanceDocument.getNewMaintainableObject().getDataObject();

        int i = 0;
        for (OrganizationYnq organizationYnq : newOrganization.getOrganizationYnqs()) {
            organizationYnq.refreshReferenceObject("ynq");
            
            if( StringUtils.isBlank(organizationYnq.getAnswer()) ) {
                errorReporter.reportError(String.format( "document.newMaintainableObject.organizationYnqs[%s].answer", i ), 
                        KeyConstants.ERROR_ORGANIZATION_QUESTIONYNQ_ANSWER_REQUIRED,
                        organizationYnq.getYnq().getQuestionId());
                valid=false;
            }
            
            if (StringUtils.isNotBlank(organizationYnq.getAnswer()) && 
                    organizationYnq.getAnswer().equalsIgnoreCase(organizationYnq.getYnq().getExplanationRequiredFor()) && StringUtils.isBlank(organizationYnq.getExplanation())) {
                
                errorReporter.reportError(String.format( "document.newMaintainableObject.organizationYnqs[%s].explanation", i ), 
                        KeyConstants.ERROR_ORGANIZATION_QUESTIONYNQ_EXPLANATION_REQUIRED,
                        organizationYnq.getYnq().getQuestionId());
                
                valid = false;
            }
            if (StringUtils.isNotBlank(organizationYnq.getAnswer()) && 
                    organizationYnq.getAnswer().equalsIgnoreCase(organizationYnq.getYnq().getDateRequiredFor()) && 
                    organizationYnq.getReviewDate() == null
                   ) {
                    errorReporter.reportError(String.format( "document.newMaintainableObject.organizationYnqs[%s].reviewDate", i ), 
                            KeyConstants.ERROR_ORGANIZATION_QUESTIONYNQ_DATE_REQUIRED,
                            organizationYnq.getYnq().getQuestionId());
                    valid = false;
            }
            i++;
        }
        return valid;
    }
    
    private boolean checkRolodexEntries( MaintenanceDocument maintenanceDocument) {
        final Organization newOrganization = (Organization) maintenanceDocument.getNewMaintainableObject().getDataObject();

        boolean valid = isValidRolodex(newOrganization.getOnrResidentRep(), "document.newMaintainableObject.onrResidentRep");
        valid &= isValidRolodex(newOrganization.getContactAddressId(), "document.newMaintainableObject.contactAddressId");
        valid &= isValidRolodex(newOrganization.getCognizantAuditor(), "document.newMaintainableObject.cognizantAuditor");
        valid &= isValidRolodex(newOrganization.getLobbyingRegistrant(), "document.newMaintainableObject.lobbyingRegistrant");
        valid &= isValidRolodex(newOrganization.getLobbyingIndividual(), "document.newMaintainableObject.lobbyingIndividual");
        
        return valid;
    }

    private boolean isValidRolodex(Integer key, String field) {
        if( ( key != null ) && getRolodexService().getRolodex( key ) == null ) {
            getErrorReporter().reportError(field, KeyConstants.ERROR_INVALID_ROLODEX_ENTRY);
            return false;
        }
        return true;
    }

    private boolean checkAudits(MaintenanceDocument maintenanceDocument) {

        boolean valid = true;
        final Organization newOrganization = (Organization) maintenanceDocument.getNewMaintainableObject().getDataObject();
        int i = 0;
        for (OrganizationAudit organizationAudit : newOrganization.getOrganizationAudits()) {
            valid &= checkExistenceFromTable(OrganizationAuditAcceptedType.class, Collections.singletonMap("code", organizationAudit.getAuditAcceptedCode()), String.format( "organizationAudits[%s].auditAcceptedCode", i ), "Accepted Type");
            i++;
        }
        return valid;
    }

    public ErrorReporter getErrorReporter() {
        if (errorReporter == null) {
            errorReporter = KcServiceLocator.getService(ErrorReporter.class);
        }

        return errorReporter;
    }

    public RolodexService getRolodexService() {
        if (rolodexService == null) {
            rolodexService = KcServiceLocator.getService(RolodexService.class);
        }

        return rolodexService;
    }
}
