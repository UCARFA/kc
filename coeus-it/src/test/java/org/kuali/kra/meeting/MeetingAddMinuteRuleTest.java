/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.meeting;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.common.committee.impl.meeting.MeetingEventBase.ErrorType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.HashMap;
import java.util.Map;

@RunWith(JMock.class)
public class MeetingAddMinuteRuleTest extends KcIntegrationTestBase {
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};

    @Test
    public void testMissingProtocol() {    
        new  TemplateRuleTest<MeetingAddMinuteEvent, MeetingAddMinuteRule> (){            
            @Override
            protected void prerequisite() {   
                CommitteeScheduleMinute committeeScheduleMinute = new CommitteeScheduleMinute();
                committeeScheduleMinute.setMinuteEntryTypeCode("3");
                committeeScheduleMinute.setMinuteEntry("Text");
                
                MeetingHelper meetingHelper = new MeetingHelper(new MeetingForm());
                meetingHelper.setNewCommitteeScheduleMinute(committeeScheduleMinute);
                event = new MeetingAddMinuteEvent(Constants.EMPTY_STRING, null, meetingHelper, ErrorType.HARDERROR);
                rule = new MeetingAddMinuteRule();
                expectedReturnValue = false;
            }
       };
 
    
    }

    @Test
    public void testOK() {    
        new  TemplateRuleTest<MeetingAddMinuteEvent, MeetingAddMinuteRule> (){            
            @Override
            protected void prerequisite() {   
                CommitteeScheduleMinute committeeScheduleMinute = new CommitteeScheduleMinute();
                committeeScheduleMinute.setMinuteEntryTypeCode("3");
                committeeScheduleMinute.setMinuteEntry("Text");
                committeeScheduleMinute.setProtocolIdFk(1L);
                
                MeetingHelper meetingHelper = new MeetingHelper(new MeetingForm());
                meetingHelper.setNewCommitteeScheduleMinute(committeeScheduleMinute);
                event = new MeetingAddMinuteEvent(Constants.EMPTY_STRING, null, meetingHelper, ErrorType.HARDERROR);
                rule = new MeetingAddMinuteRule();
                expectedReturnValue = true;
            }
       };
 
    
    }

    @Test
    public void testInvalidReviewCode() {    
        new  TemplateRuleTest<MeetingAddMinuteEvent, MeetingAddMinuteRule> (){            
            @Override
            protected void prerequisite() {   
                CommitteeScheduleMinute committeeScheduleMinute = new CommitteeScheduleMinute();
                committeeScheduleMinute.setMinuteEntryTypeCode("3");
                committeeScheduleMinute.setMinuteEntry("Text");
                committeeScheduleMinute.setProtocolIdFk(1L);
                ProtocolContingency protocolContingency= new ProtocolContingency();
                protocolContingency.setProtocolContingencyCode("111");
                committeeScheduleMinute.setProtocolContingency(protocolContingency);
                committeeScheduleMinute.setProtocolContingencyCode("111");
                final BusinessObjectService businessObjectService = context.mock(BusinessObjectService.class);
                context.checking(new Expectations() {{
                    Map<String, String> queryMap = new HashMap<String, String>();
                    queryMap.put("protocolContingencyCode", "111");
                    one(businessObjectService).findByPrimaryKey(ProtocolContingency.class, queryMap);
                    will(returnValue(null));
                    
                }});
                
                MeetingHelper meetingHelper = new MeetingHelper(new MeetingForm());
                meetingHelper.setNewCommitteeScheduleMinute(committeeScheduleMinute);
                event = new MeetingAddMinuteEvent(Constants.EMPTY_STRING, null, meetingHelper, ErrorType.HARDERROR);
                rule = new MeetingAddMinuteRule();
                rule.setBusinessObjectService(businessObjectService);
                expectedReturnValue = false;
            }
       };
 
    
    }

}
