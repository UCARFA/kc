/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.scheduling.quartz;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.sys.framework.scheduling.KcCronTriggerBean;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.core.impl.datetime.DateTimeServiceImpl;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.quartz.impl.JobDetailImpl;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the KcCronTriggerBean class.
 */
@RunWith(JMock.class)
public class KcCronTriggerBeanTest {
    
    private static final String CRON_EXPRESSION = "1 3 22 * * ?";
    
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
    
    /**
     * The KC Cron Trigger needs to be tested to simply verify that it is getting the
     * correct cron expression.
     * @throws ParseException 
     */
    @Test
    public void testCronExpression() throws Exception {
        KcCronTriggerBean cronTrigger = new KcCronTriggerBean();
        
        /*
         * The configuration service will be invoked once to get the Cron Expression.
         */
        final ParameterService parameterService = context.mock(ParameterService.class);
        context.checking(new Expectations() {
            {
                one(parameterService).parameterExists("KC-PD", "Document",
                        KeyConstants.PESSIMISTIC_LOCKING_CRON_EXPRESSION);
                will(returnValue(true));
                one(parameterService).getParameterValueAsString("KC-PD", "Document",
                        KeyConstants.PESSIMISTIC_LOCKING_CRON_EXPRESSION);
                will(returnValue(CRON_EXPRESSION));
            }
        });
        cronTrigger.setParameterService(parameterService);

        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setName("test");
        cronTrigger.setBeanName("test");
        cronTrigger.setJobDetail(jobDetail);
        cronTrigger.setParameterNamespace("KC-PD");
        cronTrigger.setParameterComponent("Document");
        cronTrigger.setCronExpressionParameterName(KeyConstants.PESSIMISTIC_LOCKING_CRON_EXPRESSION);
        cronTrigger.setDateTimeService(new DateTimeServiceImpl());
        cronTrigger.afterPropertiesSet();
        
        assertEquals(CRON_EXPRESSION, cronTrigger.getObject().getCronExpression());
    }
}
