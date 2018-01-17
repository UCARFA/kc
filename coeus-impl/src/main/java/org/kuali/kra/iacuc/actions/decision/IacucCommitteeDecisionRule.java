/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.decision;

import org.kuali.coeus.common.committee.impl.service.CommitteeScheduleAttendanceServiceBase;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeScheduleAttendanceService;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.protocol.actions.decision.CommitteeDecisionRuleBase;

public class IacucCommitteeDecisionRule extends CommitteeDecisionRuleBase<IacucCommitteeDecision> {

    @Override
    protected String getNoCommentsForRevisionsErrorMessageHook() {
        return KeyConstants.ERROR_PROTOCOL_RECORD_COMMITEE_NO_MINOR_MAJOR_DISAPPROVE_REVIEWER_COMMENTS;
    }

    @Override
    protected Class<? extends CommitteeScheduleAttendanceServiceBase> getCommitteeScheduleAttendanceServiceClassHook() {
        return IacucCommitteeScheduleAttendanceService.class;
    }
    
}
