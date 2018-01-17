/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.junit.Test;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.MonthlyScheduleDetails;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.ScheduleData;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.StyleKey;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.YearlyScheduleDetails;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.committee.rule.event.CommitteeScheduleDayEvent;
import org.kuali.kra.committee.rule.event.CommitteeScheduleEventBase.ErrorType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;

public class CommitteeScheduleDayRuleTest {
    
    @Test
    public void testTrueMonthly() {    
        new  TemplateRuleTest<CommitteeScheduleDayEvent, CommitteeScheduleDayRule> (){            
            @Override
            protected void prerequisite() {            
                ScheduleData scheduleData = new ScheduleData();
                scheduleData.getMonthlySchedule().setDay(31);
                scheduleData.setRecurrenceType(StyleKey.MONTHLY.toString());
                scheduleData.getMonthlySchedule().setMonthOption(MonthlyScheduleDetails.optionValues.XDAYANDXMONTH.toString());               
                event = new CommitteeScheduleDayEvent(Constants.EMPTY_STRING, null, scheduleData, null, ErrorType.HARDERROR);
                rule = new CommitteeScheduleDayRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }
    
    @Test
    public void testMonthly() {
        new  TemplateRuleTest<CommitteeScheduleDayEvent, CommitteeScheduleDayRule> (){ 
            @Override
            protected void prerequisite() {
                ScheduleData scheduleData = new ScheduleData();
                scheduleData.getMonthlySchedule().setDay(32);
                scheduleData.setRecurrenceType(StyleKey.MONTHLY.toString());
                scheduleData.getMonthlySchedule().setMonthOption(MonthlyScheduleDetails.optionValues.XDAYANDXMONTH.toString());
                event = new CommitteeScheduleDayEvent(Constants.EMPTY_STRING, null, scheduleData, null, ErrorType.HARDERROR);
                rule = new CommitteeScheduleDayRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };
    }
    
    @Test
    public void testTrueYearly() {    
        new  TemplateRuleTest<CommitteeScheduleDayEvent, CommitteeScheduleDayRule> (){            
            @Override
            protected void prerequisite() {            
                ScheduleData scheduleData = new ScheduleData();
                scheduleData.getYearlySchedule().setDay(31);
                scheduleData.setRecurrenceType(StyleKey.YEARLY.toString());
                scheduleData.getYearlySchedule().setYearOption(YearlyScheduleDetails.yearOptionValues.XDAY.toString());               
                event = new CommitteeScheduleDayEvent(Constants.EMPTY_STRING, null, scheduleData, null, ErrorType.HARDERROR);
                rule = new CommitteeScheduleDayRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }
      
    @Test
    public void testFalseYearly() {    
        new  TemplateRuleTest<CommitteeScheduleDayEvent, CommitteeScheduleDayRule> (){            
            @Override
            protected void prerequisite() {            
                ScheduleData scheduleData = new ScheduleData();
                scheduleData.getYearlySchedule().setDay(33);
                scheduleData.setRecurrenceType(StyleKey.YEARLY.toString());
                scheduleData.getYearlySchedule().setYearOption(YearlyScheduleDetails.yearOptionValues.XDAY.toString());               
                event = new CommitteeScheduleDayEvent(Constants.EMPTY_STRING, null, scheduleData, null, ErrorType.HARDERROR);
                rule = new CommitteeScheduleDayRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };
    }    
}
