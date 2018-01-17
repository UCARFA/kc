/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.institutionalproposal.InstitutionalProposalConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

/**
 * This class is a set of common convenience methods used by Proposal Log related classes.
 */
public final class ProposalLogUtils {
    
    private ProposalLogUtils() {
        
    }
    
    public static String getProposalLogPendingStatusCode() {
        return getCodeValue("PROPOSAL_LOG_PENDING_STATUS_CODE");
    }
    
    public static String getProposalLogMergedStatusCode() {
        return getCodeValue("PROPOSAL_LOG_MERGED_STATUS_CODE");
    }
    
    public static String getProposalLogSubmittedStatusCode() {
        return getCodeValue("PROPOSAL_LOG_SUBMITTED_STATUS_CODE");
    }
    
    public static String getProposalLogVoidStatusCode() {
        return getCodeValue("PROPOSAL_LOG_VOID_STATUS_CODE");
    }
    
    public static String getProposalLogTemporaryStatusCode() {
        return getCodeValue("PROPOSAL_LOG_TEMPORARY_STATUS_CODE");
    }
    
    public static String getProposalLogPermanentTypeCode() {
        return getCodeValue("PROPOSAL_LOG_PERMANENT_TYPE_CODE");
    }
    
    public static String getProposalLogTemporaryTypeCode() {
        return getCodeValue("PROPOSAL_LOG_TEMPORARY_TYPE_CODE");
    }
    
    private static String getCodeValue(String paramName) {
        return KcServiceLocator.getService(ParameterService.class).getParameterValueAsString(
                InstitutionalProposalConstants.INSTITUTIONAL_PROPOSAL_NAMESPACE, ParameterConstants.DOCUMENT_COMPONENT, paramName);
    }

}
