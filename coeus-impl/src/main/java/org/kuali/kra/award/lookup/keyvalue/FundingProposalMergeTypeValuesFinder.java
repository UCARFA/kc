/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.fundingproposal.FundingProposalMergeType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

public class FundingProposalMergeTypeValuesFinder extends FormViewAwareUifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> values = new ArrayList<KeyValue>();
        if (isNewAward()) {
            values.add(new ConcreteKeyValue(FundingProposalMergeType.NEWAWARD.getKey(), FundingProposalMergeType.NEWAWARD.getDesc()));
        } else {
            for (FundingProposalMergeType type : FundingProposalMergeType.values()) {
                if (type != FundingProposalMergeType.NEWAWARD) {
                    values.add(new ConcreteKeyValue(type.getKey(), type.getDesc()));
                }
            }
        }
        return values;
    }
    
    protected boolean isNewAward() {
        Award award = ((AwardDocument) getDocument()).getAward();
        return award.isNew() && award.getSequenceNumber() <= 1 && award.getFundingProposals().isEmpty();
    }

}
