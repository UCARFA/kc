/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.rule.event.CommitteeScheduleDeadlineEvent;
import org.kuali.kra.infrastructure.KeyConstants;

import java.sql.Date;
import java.util.List;

public class CommitteeScheduleDeadlineDateRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<CommitteeScheduleDeadlineEvent> {
    
    public static final String ID = "document.committeeList[0].committeeSchedules[%1$s].protocolSubDeadline";
    
    @Override
    public boolean processRules(CommitteeScheduleDeadlineEvent deadlineCommitteeScheduleEvent) {
        
        boolean rulePassed = true;
        
        List<CommitteeSchedule> committeeSchedules = deadlineCommitteeScheduleEvent.getCommitteeSchedules();
        int count = 0;
        for(CommitteeSchedule committeeSchedule : committeeSchedules) {
            
            Date deadline = committeeSchedule.getProtocolSubDeadline();
            Date schedule = committeeSchedule.getScheduledDate();
            
            if ((schedule != null) && (deadline != null) && (schedule.before(deadline))) {
                reportError(String.format(ID, count), KeyConstants.ERROR_COMMITTEESCHEDULE_DEADLINE, deadline.toString(), schedule.toString());
                rulePassed = false;
            }
            count++;
        }
        
        return rulePassed;
    }

}
