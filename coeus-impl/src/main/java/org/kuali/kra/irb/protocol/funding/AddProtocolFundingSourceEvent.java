/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.funding;

import org.kuali.kra.protocol.protocol.funding.AddProtocolFundingSourceEventBase;
import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * 
 * This class implements the tightly coupled Event-Rule approach to Kuali Rule processing for Adding a Protocol Funding Source.
 */
public class AddProtocolFundingSourceEvent extends AddProtocolFundingSourceEventBase  {
    
    public AddProtocolFundingSourceEvent(String description, Document document, ProtocolFundingSource fundingSource, List<ProtocolFundingSource> protocolFundingSources) {
            super(description, document, fundingSource, (List)protocolFundingSources);
    }
    
    protected AddProtocolFundingSourceEvent(String description, String errorPathPrefix, Document document) {
        super(description, errorPathPrefix, document);
    }
    
    @Override
    public ProtocolFundingSourceRule getRule() {
        return new ProtocolFundingSourceRule();
    }
    
}
