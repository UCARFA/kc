/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.history;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.irb.test.ProtocolRuleTestBase;
import org.kuali.kra.rules.TemplateRuleTest;

import java.util.Date;

public class ProtocolHistoryFilterDatesRuleTest extends ProtocolRuleTestBase { 
    
    @Test
    public void testOK() {
        new TemplateRuleTest<ProtocolHistoryFilterDatesEvent, ProtocolHistoryFilterDatesRule> () {
            
            @Override
            protected void prerequisite() {
                Date startDate = new Date(System.currentTimeMillis());
                Date endDate = new Date(System.currentTimeMillis());
                
                event = new ProtocolHistoryFilterDatesEvent(null, startDate, endDate);
                rule = new ProtocolHistoryFilterDatesRule();
                expectedReturnValue = true;
            }
        };
    }

    @Test
    public void testStartDateNull() {
        new TemplateRuleTest<ProtocolHistoryFilterDatesEvent, ProtocolHistoryFilterDatesRule> (){
            
            @Override
            protected void prerequisite() {
                Date startDate = null;
                Date endDate = new Date(System.currentTimeMillis());
                
                event = new ProtocolHistoryFilterDatesEvent(null, startDate, endDate);
                rule = new ProtocolHistoryFilterDatesRule();
                expectedReturnValue = false;
            }
            
            @Override
            public void checkRuleAssertions() {
                assertError(Constants.PROTOCOL_HISTORY_DATE_RANGE_FILTER_START_DATE_KEY, 
                        KeyConstants.ERROR_REQUIRED);
            }
        };
    }
    
    @Test
    public void testEndDateNull() {
        new TemplateRuleTest<ProtocolHistoryFilterDatesEvent, ProtocolHistoryFilterDatesRule> (){
            
            @Override
            protected void prerequisite() {
                Date startDate = new Date(System.currentTimeMillis());
                Date endDate = null;
                
                event = new ProtocolHistoryFilterDatesEvent(null, startDate, endDate);
                rule = new ProtocolHistoryFilterDatesRule();
                expectedReturnValue = false;
            }
            
            @Override
            public void checkRuleAssertions() {
                assertError(Constants.PROTOCOL_HISTORY_DATE_RANGE_FILTER_END_DATE_KEY, 
                        KeyConstants.ERROR_REQUIRED);
            }
        };
    }
    
    @Test
    public void testEndDateBeforeStartDate() {
        new TemplateRuleTest<ProtocolHistoryFilterDatesEvent, ProtocolHistoryFilterDatesRule> (){
            
            @Override
            protected void prerequisite() {
                Date startDate = new Date(System.currentTimeMillis());
                Date endDate = DateUtils.addDays(startDate, -1);
                
                event = new ProtocolHistoryFilterDatesEvent(null, startDate, endDate);
                rule = new ProtocolHistoryFilterDatesRule();
                expectedReturnValue = false;
            }
            
            @Override
            public void checkRuleAssertions() {
                assertError(Constants.PROTOCOL_HISTORY_DATE_RANGE_FILTER_START_DATE_KEY, 
                        KeyConstants.ERROR_START_DATE_AFTER_END_DATE);
            }
        };
    }
    
}
