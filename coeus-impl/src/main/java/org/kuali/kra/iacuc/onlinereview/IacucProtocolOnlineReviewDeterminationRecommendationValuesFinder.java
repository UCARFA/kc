/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.actions.IacucActionsKeyValuesBase;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeService;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Assembles the Protocol Reviewer Types to display in the drop-down menu when
 * reviewing a protocol and selecting a recommendation.
 */
public class IacucProtocolOnlineReviewDeterminationRecommendationValuesFinder extends IacucActionsKeyValuesBase {
    

    private static final long serialVersionUID = -1177665298157090424L;

    @Override
    public List<KeyValue> getKeyValues() {
        IacucProtocolDocument iacucProtocolDocument = (IacucProtocolDocument) getDocument();
        String reviewType = iacucProtocolDocument.getIacucProtocol().getProtocolSubmission().getProtocolReviewTypeCode();
        Collection<IacucProtocolOnlineReviewDeterminationRecommendation> recommendations = this.getKeyValuesService().findAll(IacucProtocolOnlineReviewDeterminationRecommendation.class);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        for (IacucProtocolOnlineReviewDeterminationRecommendation recommendation : recommendations) {
            if (recommendation.getIacucProtocolReviewTypeCode() != null && recommendation.getIacucProtocolReviewTypeCode().equals(reviewType)) {
                keyValues.add(new ConcreteKeyValue(recommendation.getProtocolOnlineReviewDeterminationRecommendationCode().toString(), recommendation.getIacucProtocolActionType().getDescription()));
            }
        }
        return keyValues;
    }
    
    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook() {
        return IacucCommitteeService.class;
    }
    
}
