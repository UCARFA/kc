/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol;

import org.kuali.coeus.common.framework.sponsor.Sponsor;
import org.kuali.kra.protocol.protocol.funding.ProtocolFundingSourceBase;

public class MockProtocolKrmsTermServiceNullSponsor extends MockProtocolKrmsTermService {

    @Override
    protected Sponsor getSponsorByFundingSourceNumber(ProtocolFundingSourceBase fundingSource) {
        Sponsor sponsor = new Sponsor();
        sponsor.setSponsorTypeCode(null);
        sponsor.setSponsorType(null);
        return sponsor;
    }
}
