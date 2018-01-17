/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.core;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

/**
 * Common convenience methods for the Proposal Development module.
 */
public final class ProposalDevelopmentUtils {
    
    public static final String ACTIVITY_TYPE_CODE_CONSTRUCTION_PARM = "ACTIVITY_TYPE_CODE_CONSTRUCTION";
    public static final String ACTIVITY_TYPE_CODE_RESEARCH_PARM = "ACTIVITY_TYPE_CODE_RESEARCH";
    

    public static final String PROPOSAL_TYPE_CODE_NEW_PARM = "PROPOSAL_TYPE_CODE_NEW";
    public static final String PROPOSAL_TYPE_CODE_RESUBMISSION_PARM = "PROPOSAL_TYPE_CODE_RESUBMISSION";
    public static final String PROPOSAL_TYPE_CODE_RENEWAL_PARM = "PROPOSAL_TYPE_CODE_RENEWAL";
    public static final String PROPOSAL_TYPE_CODE_CONTINUATION_PARM = "PROPOSAL_TYPE_CODE_CONTINUATION";
    public static final String PROPOSAL_TYPE_CODE_REVISION_PARM = "PROPOSAL_TYPE_CODE_REVISION";
    public static final String PROPOSAL_TYPE_CODE_TASK_ORDER_PARM = "PROPOSAL_TYPE_CODE_TASK_ORDER";
    public static final String AUDIT_INCOMPLETE_PROPOSAL_ATTATCHMENTS_PARM = "AUDIT_INCOMPLETE_PROPOSAL_ATTACHMENTS";
    public static String KEY_PERSON_CERTIFICATION_DEFERRAL_PARM = "KEY_PERSON_CERTIFICATION_DEFERRAL";
    
    public static final String PROPOSAL_PI_CITIZENSHIP_TYPE_PARM = "PROPOSAL_PI_CITIZENSHIP_TYPE";
    
    private ProposalDevelopmentUtils() {
        
    }
    
    /**
     * Retrieve the parameter value from the system parameter service, using the Proposal 
     * Development namespace and Document component.
     * 
     * @param parmName The name of the parameter.
     * @return String
     */
    public static String getProposalDevelopmentDocumentParameter(final String parmName) {
        ParameterService parameterService = KcServiceLocator.getService(ParameterService.class);
        return parameterService.getParameterValueAsString(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, 
                ParameterConstants.DOCUMENT_COMPONENT, 
                parmName);
    }
    
}
        
