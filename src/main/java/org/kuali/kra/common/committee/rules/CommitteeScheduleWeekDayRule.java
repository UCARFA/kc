/*
 * Copyright 2005-2010 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.common.committee.rules;

import org.kuali.kra.common.committee.rule.event.CommitteeScheduleWeekDayEvent;
import org.kuali.kra.common.committee.web.struts.form.schedule.ScheduleData;
import org.kuali.kra.common.committee.web.struts.form.schedule.StyleKey;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.rule.BusinessRuleInterface;
import org.kuali.kra.rules.ResearchDocumentRuleBase;

public class CommitteeScheduleWeekDayRule extends ResearchDocumentRuleBase implements  BusinessRuleInterface<CommitteeScheduleWeekDayEvent>{
    
    public static final String ID = "committeeHelper.scheduleData.weeklySchedule.daysOfWeek";
            

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
