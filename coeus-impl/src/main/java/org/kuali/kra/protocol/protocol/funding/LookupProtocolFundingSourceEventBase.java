/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.funding;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.ProtocolEventBase;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class provide rule processing for Funding Source lookup events. It is tightly coupled with the
 * rule class itself, and uses the generic type extension to avoid the monolithic document rule interface implementation.
 * 
 */
public abstract class LookupProtocolFundingSourceEventBase extends ProtocolEventBase<LookupProtocolFundingSourceRule> {
    
    private String fundingSourceTypeCode;

    public LookupProtocolFundingSourceEventBase(String errorPathPrefix, ProtocolDocumentBase document, String fundingSourceTypeCode, ErrorType type) {
        super("looking up a funding source for ProtocolBase document " + getDocumentId(document), errorPathPrefix, document, type);
        this.fundingSourceTypeCode = fundingSourceTypeCode;
    }
    
    public LookupProtocolFundingSourceEventBase(String errorPathPrefix, Document document, String fundingSourceTypeCode, ErrorType type) {
        this(errorPathPrefix, (ProtocolDocumentBase) document, fundingSourceTypeCode, type);
    }
    
    @Override
    public abstract LookupProtocolFundingSourceRule getRule();
    
    
    
    public String getFundingSourceTypeCode() {
        return fundingSourceTypeCode;
    }

    public void setFundingSourceTypeCode(String fundingSourceTypeCode) {
        this.fundingSourceTypeCode = fundingSourceTypeCode;
    }
    
}
