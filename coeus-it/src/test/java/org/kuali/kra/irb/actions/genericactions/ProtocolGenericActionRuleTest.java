/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.genericactions;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Test;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.irb.test.ProtocolRuleTestBase;
import org.kuali.kra.rules.TemplateRuleTest;
import  org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean;

import java.sql.Date;

/**
 * Test the business rules for running a generic action on a Protocol.  Since all actions are using the same rule, 
 * we only need to test the rule for a Close action.
 */
public class ProtocolGenericActionRuleTest extends ProtocolRuleTestBase {
    
    private static final Date ACTION_DATE = new Date(System.currentTimeMillis());
    
    private static final String ACTION_DATE_FIELD = "actionDate";
    
    private Mockery context = new JUnit4Mockery() {{
        setThreadingPolicy(new Synchroniser());
    }};

    /**
     * Tests a valid Approval.
     * @throws Exception
     */
    @Test
    public void testOk() {
        new TemplateRuleTest<ProtocolGenericActionEvent, ProtocolGenericActionRule>() {

            @Override
            protected void prerequisite() {
                ProtocolGenericActionBean bean = getMockProtocolGenericActionBean(ACTION_DATE);
                event = new ProtocolGenericActionEvent(null, bean);
                rule = new ProtocolGenericActionRule();
                expectedReturnValue = true;
            }
            
        };
    }
    
    /**
     * Tests an invalid Response Approval with no action date.
     * @throws Exception
     */
    @Test
    public void testNoActionDate() {
        new TemplateRuleTest<ProtocolGenericActionEvent, ProtocolGenericActionRule>() {

            @Override
            protected void prerequisite() {
                ProtocolGenericActionBean bean = getMockProtocolGenericActionBean(null);
                event = new ProtocolGenericActionEvent(null, bean);
                rule = new ProtocolGenericActionRule();
                expectedReturnValue = false;
            }
            
            @Override
            public void checkRuleAssertions() {
                assertError(ACTION_DATE_FIELD, KeyConstants.ERROR_PROTOCOL_GENERIC_ACTION_DATE_REQUIRED);
            }
            
        };
    }
    
    private ProtocolGenericActionBean getMockProtocolGenericActionBean(final Date actionDate) {
        final ProtocolGenericActionBean bean = context.mock(ProtocolGenericActionBean.class);
        
        context.checking(new Expectations() {{
            allowing(bean).getActionDate();
            will(returnValue(actionDate));
            
            allowing(bean).getErrorPropertyKey();
            will(returnValue(Constants.PROTOCOL_CLOSE_ACTION_PROPERTY_KEY));
        }});
        
        return bean;
    }

}
