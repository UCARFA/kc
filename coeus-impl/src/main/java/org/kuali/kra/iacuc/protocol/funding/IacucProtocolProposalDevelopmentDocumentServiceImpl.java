/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.protocol.funding;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.common.framework.compliance.core.SpecialReviewType;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.protocol.protocol.funding.impl.ProtocolProposalDevelopmentDocumentServiceImplBase;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

/**
 * 
 * This service creates Proposal Development Document from ProtocolBase for users authorized to create proposal. This created
 * proposal is then added to ProtocolBase Funding sources. 
 */
public class IacucProtocolProposalDevelopmentDocumentServiceImpl extends ProtocolProposalDevelopmentDocumentServiceImplBase implements IacucProtocolProposalDevelopmentDocumentService {

    public final static String IACUC_PROJECT_END_DATE_NUMBER_OF_YEARS = "iacucProtocolProjectEndDateNumberOfYears";
    ParameterService parameterService;
    @Override 
    protected String getSpecialReviewTypeHook()
    {
        return SpecialReviewType.ANIMAL_USAGE;
    }
    
    @Override
    protected String getProjectEndDateNumberOfYearsHook()
    {
        if ( parameterService ==null)
        {
            parameterService = KcServiceLocator.getService(ParameterService.class);
        }
        String parameter= parameterService.getParameterValueAsString(IacucProtocolDocument.class, IACUC_PROJECT_END_DATE_NUMBER_OF_YEARS);
        return parameter;
    }

}
