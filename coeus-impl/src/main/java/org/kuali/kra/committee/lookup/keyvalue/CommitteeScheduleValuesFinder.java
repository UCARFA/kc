/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.lookup.keyvalue;

import org.kuali.coeus.common.committee.impl.lookup.keyvalue.CommitteeScheduleValuesFinderBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.kra.committee.service.CommitteeService;

/**
 * Finds the available set of dates where a protocol can be scheduled
 * for a review by a committee.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class CommitteeScheduleValuesFinder extends CommitteeScheduleValuesFinderBase {
    

    private static final long serialVersionUID = 338230898950097350L;

    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook() {
        return CommitteeService.class;
    }
}
