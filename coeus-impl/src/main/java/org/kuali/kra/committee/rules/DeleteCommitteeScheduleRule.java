/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.kuali.coeus.common.committee.impl.rules.DeleteCommitteeScheduleRuleBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.kra.committee.service.CommitteeService;

/**
 * 
 * This class implements rule for deleting committee schedule.
 */
public class DeleteCommitteeScheduleRule extends DeleteCommitteeScheduleRuleBase {

    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook() {
        return CommitteeService.class;
    }
}
