/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.funding;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.kra.bo.FundingSourceType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * Validates the conditions necessary for looking up a funding source in the system.
 */
public class LookupProtocolFundingSourceRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<LookupProtocolFundingSourceEventBase> {

    private final ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);
    
    @Override
    public boolean processRules(LookupProtocolFundingSourceEventBase event) {
        boolean valid = true;
        
        if (event.getFundingSourceTypeCode() == null) {
            errorReporter.reportError(Constants.PROTOCOL_FUNDING_SOURCE_TYPE_CODE_FIELD, KeyConstants.ERROR_FUNDING_LOOKUP_NOT_FOUND);
            valid = false;            
        } else {
            valid &= isValidLookup(event.getFundingSourceTypeCode());
        }
        
        return valid;
    }
    
    /**
     * Throws a validation error if the lookup is of type Other or an unknown type.
     * @param fundingSourceTypeCode
     * @return
     */
    private boolean isValidLookup(String fundingSourceTypeCode) {
        boolean isValid = true;
     
        if (!FundingSourceType.SPONSOR.equals(fundingSourceTypeCode)
                && !FundingSourceType.UNIT.equals(fundingSourceTypeCode)
                && !FundingSourceType.PROPOSAL_DEVELOPMENT.equals(fundingSourceTypeCode)
                && !FundingSourceType.INSTITUTIONAL_PROPOSAL.equals(fundingSourceTypeCode)
                && !FundingSourceType.AWARD.equals(fundingSourceTypeCode)) { 
            errorReporter.reportError(Constants.PROTOCOL_FUNDING_SOURCE_TYPE_CODE_FIELD, KeyConstants.ERROR_FUNDING_LOOKUP_UNAVAIL);
            isValid = false;
        }   
       
        return isValid;
    }
    
}
