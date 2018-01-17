/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.org;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.org.FederalApprovingAgency;
import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.coeus.common.framework.org.OrganizationIndirectcost;
import org.kuali.coeus.common.framework.org.OrganizationYnq;
import org.kuali.coeus.common.api.rolodex.RolodexService;
import org.kuali.coeus.common.framework.org.audit.OrganizationAudit;
import org.kuali.coeus.common.framework.org.audit.OrganizationAuditAcceptedType;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.Collections;

public class OrganizationMaintenanceDocumentRule  extends KcMaintenanceDocumentRuleBase {

    private static final String FEDERAL_APPROVING_AGENCY_NAME = "organizationIdcs[%s].federalApprovingAgencyName";
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
        result &= checkIdcs(document);
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

    private boolean checkIdcs(MaintenanceDocument maintenanceDocument) {

        boolean valid = true;
        final Organization newOrganization = (Organization) maintenanceDocument.getNewMaintainableObject().getDataObject();
        int i = 0;
        for (OrganizationIndirectcost organizationIndirectcost : newOrganization.getOrganizationIdcs()) {
            if (FederalApprovingAgency.OTHER.getCode().equals(organizationIndirectcost.getFederalApprovingAgency()) && StringUtils.isBlank(organizationIndirectcost.getFederalApprovingAgencyName())) {
                getErrorReporter().reportError(String.format( KRADConstants.MAINTENANCE_NEW_MAINTAINABLE + FEDERAL_APPROVING_AGENCY_NAME, i ), KeyConstants.ERROR_INVALID_AGENCY_NAME_REQUIRED, FederalApprovingAgency.OTHER.getDescription());
                valid = false;
            } else if (!FederalApprovingAgency.OTHER.getCode().equals(organizationIndirectcost.getFederalApprovingAgency()) && StringUtils.isNotBlank(organizationIndirectcost.getFederalApprovingAgencyName())) {
                getErrorReporter().reportError(String.format( KRADConstants.MAINTENANCE_NEW_MAINTAINABLE + FEDERAL_APPROVING_AGENCY_NAME, i ), KeyConstants.ERROR_INVALID_AGENCY_NAME_NOT_ALLOWED, FederalApprovingAgency.OTHER.getDescription());
                valid = false;
            }
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
