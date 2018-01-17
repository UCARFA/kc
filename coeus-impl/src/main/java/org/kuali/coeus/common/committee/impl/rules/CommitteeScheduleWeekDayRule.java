/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rules;

import org.kuali.coeus.common.committee.impl.rule.event.CommitteeScheduleWeekDayEvent;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.ScheduleData;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.StyleKey;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

public class CommitteeScheduleWeekDayRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<CommitteeScheduleWeekDayEvent> {
    
    public static final String ID = "committeeHelper.scheduleData.weeklySchedule.daysOfWeek";
            

    @Override
    public boolean processRules(CommitteeScheduleWeekDayEvent weekdayCommitteeScheduleEvent) {
        
        boolean rulePassed = true;        
        ScheduleData scheduleData = weekdayCommitteeScheduleEvent.getScheduleData();  
        StyleKey key = StyleKey.valueOf(scheduleData.getRecurrenceType());
        if(key.equalsString(StyleKey.WEEKLY.toString()) && null == scheduleData.getWeeklySchedule().getDaysOfWeek()) {
            reportError(ID, KeyConstants.ERROR_COMMITTEESCHEDULE_WEEKDAY);
            rulePassed = false;
        }        
        return rulePassed;
    }

}
