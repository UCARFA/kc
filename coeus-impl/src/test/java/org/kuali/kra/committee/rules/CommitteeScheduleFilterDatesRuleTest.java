/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.ScheduleData;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.committee.rule.event.CommitteeScheduleEventBase.ErrorType;
import org.kuali.kra.committee.rule.event.CommitteeScheduleFilterEvent;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;

import java.util.Date;

public class CommitteeScheduleFilterDatesRuleTest { 
    
    @Test
    public void testTrue() {
    
        new  TemplateRuleTest<CommitteeScheduleFilterEvent, CommitteeScheduleFilterDatesRule> (){
            
            @Override
            protected void prerequisite() {
                
                ScheduleData scheduleData = new ScheduleData();  
                Date dt = DateUtils.addDays(new Date(), 1);  
                scheduleData.setFilterStartDate(new java.sql.Date(new Date().getTime()));
                scheduleData.setFilerEndDate(new java.sql.Date(dt.getTime()));
                
                event = new CommitteeScheduleFilterEvent(Constants.EMPTY_STRING, null, scheduleData, null, ErrorType.HARDERROR);
                rule = new CommitteeScheduleFilterDatesRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }

    @Test
    public void testFalse() {
    
        new  TemplateRuleTest<CommitteeScheduleFilterEvent, CommitteeScheduleFilterDatesRule> (){
            
            @Override
            protected void prerequisite() {
                
                ScheduleData scheduleData = new ScheduleData();   
                scheduleData.setFilterStartDate(new java.sql.Date(new Date().getTime()));
                Date endDate = DateUtils.addDays(new Date(), -1);
                scheduleData.setFilerEndDate(new java.sql.Date(endDate.getTime()));
                
                event = new CommitteeScheduleFilterEvent(Constants.EMPTY_STRING, null, scheduleData, null, ErrorType.HARDERROR);
                rule = new CommitteeScheduleFilterDatesRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };
    }
}
