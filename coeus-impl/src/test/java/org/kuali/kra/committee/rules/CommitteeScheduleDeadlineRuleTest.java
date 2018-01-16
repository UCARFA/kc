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
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.rule.event.CommitteeScheduleDeadlineEvent;
import org.kuali.kra.committee.rule.event.CommitteeScheduleEventBase.ErrorType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommitteeScheduleDeadlineRuleTest {
    
    @Test
    public void testTrue() {
    
        new  TemplateRuleTest<CommitteeScheduleDeadlineEvent, CommitteeScheduleDeadlineDateRule> (){
            
            @Override
            protected void prerequisite() {
                
                List<CommitteeSchedule> committeeSchedules = new ArrayList<CommitteeSchedule>();
                CommitteeSchedule temp  = new CommitteeSchedule();
                temp.setScheduledDate(new java.sql.Date(new Date().getTime()));        
                Date dt = DateUtils.addDays(new Date(), -1);
                temp.setProtocolSubDeadline(new java.sql.Date(dt.getTime()));
                committeeSchedules.add(temp);
                
                event = new CommitteeScheduleDeadlineEvent(Constants.EMPTY_STRING, null, null, committeeSchedules, ErrorType.HARDERROR);
                rule = new CommitteeScheduleDeadlineDateRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }
    
    @Test
    public void testFalse() {
        new  TemplateRuleTest<CommitteeScheduleDeadlineEvent, CommitteeScheduleDeadlineDateRule> (){
            @Override
            protected void prerequisite() {
                
                List<CommitteeSchedule> committeeSchedules = new ArrayList<CommitteeSchedule>();
                CommitteeSchedule temp  = new CommitteeSchedule();
                temp.setScheduledDate(new java.sql.Date(new Date().getTime()));        
                Date dt = DateUtils.addDays(new Date(), 1);
                temp.setProtocolSubDeadline(new java.sql.Date(dt.getTime()));
                committeeSchedules.add(temp);
                
                event = new CommitteeScheduleDeadlineEvent(Constants.EMPTY_STRING, null, null, committeeSchedules, ErrorType.HARDERROR);
                rule = new CommitteeScheduleDeadlineDateRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };
    }
}
