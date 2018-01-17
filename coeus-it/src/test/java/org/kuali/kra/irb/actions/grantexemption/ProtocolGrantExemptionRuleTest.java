/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.grantexemption;

import org.apache.commons.lang3.time.DateUtils;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Test;
import org.kuali.coeus.org.jmock.lib.legacy.ClassImposteriser;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.irb.test.ProtocolRuleTestBase;
import org.kuali.kra.rules.TemplateRuleTest;

import java.sql.Date;

/**
 * Test the business rules for granting an exemption on a Protocol.
 */
public class ProtocolGrantExemptionRuleTest extends ProtocolRuleTestBase {
    
    private static final Date ACTION_DATE = new Date(System.currentTimeMillis());
    private static final Date APPROVAL_DATE = org.kuali.coeus.sys.framework.util.DateUtils.convertToSqlDate(DateUtils.addWeeks(ACTION_DATE, -1));
    
    private static final String APPROVAL_DATE_FIELD = "approvalDate";
    private static final String ACTION_DATE_FIELD = "actionDate";
    
    private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
        setThreadingPolicy(new Synchroniser());
    }};

    /**
     * Tests a valid Approval.
     * @throws Exception
     */
    @Test
    public void testOk() {
        new TemplateRuleTest<ProtocolGrantExemptionEvent, ProtocolGrantExemptionRule>() {

            @Override
            protected void prerequisite() {
                ProtocolGrantExemptionBean bean = getMockProtocolGrantExemptionBean(APPROVAL_DATE, ACTION_DATE);
                event = new ProtocolGrantExemptionEvent(null, bean);
                rule = new ProtocolGrantExemptionRule();
                expectedReturnValue = true;
            }
            
        };
    }

    /**
     * Tests an invalid Response Approval with no approval date.
     * @throws Exception
     */
    @Test
    public void testNoApprovalDate() {
        new TemplateRuleTest<ProtocolGrantExemptionEvent, ProtocolGrantExemptionRule>() {

            @Override
            protected void prerequisite() {
                ProtocolGrantExemptionBean bean = getMockProtocolGrantExemptionBean(null, ACTION_DATE);
                event = new ProtocolGrantExemptionEvent(null, bean);
                rule = new ProtocolGrantExemptionRule();
                expectedReturnValue = false;
            }
            
            @Override
            public void checkRuleAssertions() {
                assertError(APPROVAL_DATE_FIELD, KeyConstants.ERROR_PROTOCOL_APPROVAL_DATE_REQUIRED);
            }
            
        };
    }
    
    /**
     * Tests an invalid Response Approval with no action date.
     * @throws Exception
     */
    @Test
    public void testNoActionDate() {
        new TemplateRuleTest<ProtocolGrantExemptionEvent, ProtocolGrantExemptionRule>() {

            @Override
            protected void prerequisite() {
                ProtocolGrantExemptionBean bean = getMockProtocolGrantExemptionBean(APPROVAL_DATE, null);
                event = new ProtocolGrantExemptionEvent(null, bean);
                rule = new ProtocolGrantExemptionRule();
                expectedReturnValue = false;
            }
            
            @Override
            public void checkRuleAssertions() {
                assertError(ACTION_DATE_FIELD, KeyConstants.ERROR_PROTOCOL_GENERIC_ACTION_DATE_REQUIRED);
            }
            
        };
    }
    
    private ProtocolGrantExemptionBean getMockProtocolGrantExemptionBean(final Date approvalDate, final Date actionDate) {
        final ProtocolGrantExemptionBean bean = context.mock(ProtocolGrantExemptionBean.class);
        
        context.checking(new Expectations() {{
            allowing(bean).getApprovalDate();
            will(returnValue(approvalDate));
            
            allowing(bean).getActionDate();
            will(returnValue(actionDate));
            
            allowing(bean).getErrorPropertyKey();
            will(returnValue(Constants.PROTOCOL_GRANT_EXEMPTION_ACTION_PROPERTY_KEY));
        }});
        
        return bean;
    }
    
}
