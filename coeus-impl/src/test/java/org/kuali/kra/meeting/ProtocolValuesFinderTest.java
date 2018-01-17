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
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionLite;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(JMock.class)
public class ProtocolValuesFinderTest {
    /*
     * TODO : this is probably not a good practice to increase the visibility of 'getBusinessObjectService'
     * from private to protected; just for simplifying test.
     * There is a need to set up protocolsubmissions, and need to run web test to create these.
     * It will overkill to add webtest and then test this values finder.
     * Is it  ok to add this test as part of MeetingWebTest, then it will make this much easier.
     */
    
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};

    @Test
    public void testGetKeyValues() throws Exception {
        
        final BusinessObjectService businessObjectService = context.mock(BusinessObjectService.class);
        ProtocolValuesFinder protocolValuesFinder = new ProtocolValuesFinder() { 
            @Override 
            protected BusinessObjectService getBusinessObjectService() {return businessObjectService;} 
                         
         }; 
         final List<ProtocolSubmissionLite> protocolSubmissions = new ArrayList<ProtocolSubmissionLite>();
         ProtocolSubmissionLite protocolSubmission = new ProtocolSubmissionLite();
         protocolSubmission.setScheduleIdFk(1L);
         protocolSubmission.setProtocolId(1L);
         protocolSubmission.setProtocolNumber("1001");
         protocolSubmissions.add(protocolSubmission);
         protocolSubmission = new ProtocolSubmissionLite();
         protocolSubmission.setScheduleIdFk(1L);
         protocolSubmission.setProtocolId(2L);
         protocolSubmission.setProtocolNumber("1002");
         protocolSubmissions.add(protocolSubmission);
         context.checking(new Expectations() {{
             Map fieldValues = new HashMap();
             fieldValues.put("scheduleIdFk", "1");
             one(businessObjectService).findMatching(ProtocolSubmissionLite.class, fieldValues);
             will(returnValue(protocolSubmissions));
             
         }});
         protocolValuesFinder.setScheduleId("1");
         List<KeyValue> keyValues = protocolValuesFinder.getKeyValues();
         Assert.assertEquals(keyValues.size(), 3);
         Assert.assertEquals(keyValues.get(1).getKey().toString(), "1");
         Assert.assertEquals(keyValues.get(1).getValue(), "1001");
         Assert.assertEquals(keyValues.get(2).getKey().toString(), "2");
         Assert.assertEquals(keyValues.get(2).getValue(), "1002");

    }

}
