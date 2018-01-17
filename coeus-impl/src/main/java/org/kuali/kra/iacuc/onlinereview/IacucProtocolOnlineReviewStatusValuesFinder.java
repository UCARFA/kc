/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.iacuc.actions.IacucActionsKeyValuesBase;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeService;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Assembles the Protocol Review Types to display in the drop-down menu when
 * submitting a protocol to the IRB office for review.
 */
public class IacucProtocolOnlineReviewStatusValuesFinder extends IacucActionsKeyValuesBase {
    

    private static final long serialVersionUID = -5957014216543794243L;

    @Override
    public List<KeyValue> getKeyValues() {
        Collection<IacucProtocolOnlineReviewStatus> reviewStatusCodes = this.getKeyValuesService().findAll(IacucProtocolOnlineReviewStatus.class);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        for (IacucProtocolOnlineReviewStatus status : reviewStatusCodes) {
            //we do not want users to assign the cancelled code.
            if (!StringUtils.equals(IacucProtocolOnlineReviewStatus.REMOVED_CANCELLED_STATUS_CD, status.getStatusCode())) {
                keyValues.add(new ConcreteKeyValue(status.getStatusCode(), status.getDescription()));
            }
        }
        return keyValues;
    }
    
    
    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook() {
        return IacucCommitteeService.class;
    }
    
}
