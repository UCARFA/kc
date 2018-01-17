/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.protocol.funding;

import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.protocol.ProtocolEventBase;
import org.kuali.kra.protocol.protocol.funding.LookupProtocolFundingSourceEventBase;
import org.kuali.kra.protocol.protocol.funding.LookupProtocolFundingSourceRule;

public class LookupIacucProtocolFundingSourceEvent extends LookupProtocolFundingSourceEventBase {

    public LookupIacucProtocolFundingSourceEvent(String errorPathPrefix, IacucProtocolDocument document, String fundingSourceTypeCode, ProtocolEventBase.ErrorType type) {
        super(errorPathPrefix, document, fundingSourceTypeCode, type);
    }

    @Override
    public LookupProtocolFundingSourceRule getRule() {
        return new LookupIacucProtocolFundingSourceRule();
    }

}
