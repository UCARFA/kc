/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.rules;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.negotiations.bo.NegotiationFixtureFactory;
import org.kuali.kra.negotiations.service.NegotiationServiceImpl;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class NegotiationDocumentRuleTest extends KcIntegrationTestBase {

    protected Negotiation negotiation;
    protected NegotiationDocumentRule rule;
    
    @Before
    public void setUp() {
        negotiation = NegotiationFixtureFactory.createNegotiationFixture();
        rule = new NegotiationDocumentRule();
        rule.setNegotiationService(new NegotiationServiceMock());
    }
    
    @After
    public void tearDown() {
        negotiation = null;
    }

    @Test
    public void testEndDateRule_inProgress() {
        negotiation.setNegotiationEndDate(null);
        assertTrue(rule.validateEndDate(negotiation));
    }
    
    @Test
    public void testEndDateRule_inProgressFailure() {
        assertFalse(rule.validateEndDate(negotiation));
    }
    
    @Test
    public void testEndDateRule_CompletedFailure() {
        negotiation.setNegotiationEndDate(null);
        negotiation.getNegotiationStatus().setCode("COM");
        assertFalse(rule.validateEndDate(negotiation));
    }
    
    @Test
    public void testEndDateRule_Completed() {
        negotiation.getNegotiationStatus().setCode("COM");
        assertTrue(rule.validateEndDate(negotiation));        
    }
    
    @Test
    public void testEndDateRule_EndDateBeforeStart() {
        negotiation.setNegotiationEndDate(new java.sql.Date(2005, 1, 1));
        negotiation.getNegotiationStatus().setCode("COM");
        assertFalse(rule.validateEndDate(negotiation));        
    }
    
    class NegotiationServiceMock extends NegotiationServiceImpl {
        @Override
        public List<String> getInProgressStatusCodes() {
            return Arrays.asList(new String[]{"IP", "TESTIP"});
        }
        @Override
        public List<String> getCompletedStatusCodes() {
            return Arrays.asList(new String[]{"SUP", "COM"});
        }
    }
}
