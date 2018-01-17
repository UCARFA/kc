/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.funding;

import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * Represents the event for saving a Protocol Funding Source.
 */
public class SaveProtocolFundingSourceLinkEvent extends org.kuali.kra.protocol.protocol.funding.SaveProtocolFundingSourceLinkEvent {

    public SaveProtocolFundingSourceLinkEvent(Document document, List<ProtocolFundingSource> protocolFundingSources, List<ProtocolFundingSource> deletedProtocolFundingSources) {
        super(document, (List) protocolFundingSources, (List) deletedProtocolFundingSources);
    }
}
