/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.funding;

import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.ProtocolEventBase;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class provide rule processing for Funding Source lookup events. It is tightly coupled with the
 * rule class itself, and uses the generic type extension to avoid the monolithic document rule interface implementation.
 * 
 */
public class LookupProtocolFundingSourceEvent extends ProtocolEventBase<LookupProtocolFundingSourceRule> {
    
    private String fundingSourceTypeCode;

    public LookupProtocolFundingSourceEvent(String errorPathPrefix, ProtocolDocument document, String fundingSourceTypeCode, ErrorType type) {
        super("looking up a funding source for Protocol document " + getDocumentId(document), errorPathPrefix, document, type);
        this.fundingSourceTypeCode = fundingSourceTypeCode;
    }
    
    public LookupProtocolFundingSourceEvent(String errorPathPrefix, Document document, String fundingSourceTypeCode, ErrorType type) {
        this(errorPathPrefix, (ProtocolDocument) document, fundingSourceTypeCode, type);
    }
    
    @Override
    public LookupProtocolFundingSourceRule getRule() {
        return new LookupProtocolFundingSourceRule();
    }
    
    public String getFundingSourceTypeCode() {
        return fundingSourceTypeCode;
    }

    public void setFundingSourceTypeCode(String fundingSourceTypeCode) {
        this.fundingSourceTypeCode = fundingSourceTypeCode;
    }
    
}
