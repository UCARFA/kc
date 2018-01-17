/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rules;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.rule.event.CommitteeScheduleDayEvent;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.MonthlyScheduleDetails;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.ScheduleData;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.StyleKey;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.YearlyScheduleDetails;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

public class CommitteeScheduleDayRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<CommitteeScheduleDayEvent> {
    
    public static final String SCHEDULEDATA_MONTHLY_DAY = "committeeHelper.scheduleData.monthlySchedule.day";

    public static final String SCHEDULEDATA_YEARLY_DAY = "committeeHelper.scheduleData.yearlySchedule.day";
    
    @Override
    @SuppressWarnings("MissingCasesInEnumSwitch")
    public boolean processRules(CommitteeScheduleDayEvent event) {
        boolean rulePassed = true;
        ScheduleData scheduleData = event.getScheduleData();
        StyleKey key = StyleKey.valueOf(scheduleData.getRecurrenceType());        
        switch (key) {
            case MONTHLY :
                MonthlyScheduleDetails.optionValues monthOption = MonthlyScheduleDetails.optionValues.valueOf(scheduleData.getMonthlySchedule().getMonthOption());
                switch(monthOption) {
                    case XDAYANDXMONTH :
                        rulePassed = validateDay(scheduleData.getMonthlySchedule().getDay(), SCHEDULEDATA_MONTHLY_DAY);
                        break;
                }                
                break;
            case YEARLY : 
                YearlyScheduleDetails.yearOptionValues yearOption = YearlyScheduleDetails.yearOptionValues.valueOf(scheduleData.getYearlySchedule().getYearOption());
                switch(yearOption) {
                    case XDAY :
                        rulePassed = validateDay(scheduleData.getYearlySchedule().getDay(), scheduleData.getYearlySchedule().getSelectedOption1Month(), SCHEDULEDATA_YEARLY_DAY);   
                        break;
                }
                break;              
        }
        return rulePassed;
    }
    
    private boolean validateDay(Integer day, String key) {
        boolean rulePassed = true;
        if((day != null) && (day.compareTo(31) > 0)) {
            rulePassed = false;
            reportError(key, KeyConstants.ERROR_COMMITTEESCHEDULE_DAY, "31");
        }
        return rulePassed;     
    }

    private boolean validateDay(Integer day, String month, String key) {
        boolean rulePassed = true;
        int maxDay;
        
        if (StringUtils.equalsIgnoreCase(month, "FEBRUARY")) {
            maxDay = 29;
        } else if(StringUtils.equalsIgnoreCase(month, "APRIL") || StringUtils.equalsIgnoreCase(month, "JUNE")
                || StringUtils.equalsIgnoreCase(month, "SEPTEMBER") || StringUtils.equalsIgnoreCase(month, "NOVEMBER")) {
            maxDay = 30;
        } else {
            maxDay = 31;
        }

        if((day != null) && (day.compareTo(maxDay) > 0)) {
            rulePassed = false;
            reportError(key, KeyConstants.ERROR_COMMITTEESCHEDULE_DAY, "31");
        }

        return rulePassed;     
    }

}
