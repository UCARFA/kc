/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.research;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.test.ProtocolRuleTestBase;

import static org.kuali.rice.krad.util.GlobalVariables.getAuditErrorMap;
import static org.junit.Assert.*;
/*
 * WARNING: Please do not move this test.  It does not like to pass with the entire suite unless it is further up the testing chain.
 *          If moved it will complain that its Transaction status is rolled back.  I'm not sure why.
 */
public class ProtocolResearchAreaAuditRuleTest extends ProtocolRuleTestBase {
    
    private ProtocolResearchAreaAuditRule auditRule;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        auditRule = new ProtocolResearchAreaAuditRule();
    }
    
    @Override
    @After
    public void tearDown() throws Exception {
        auditRule = null;
        super.tearDown();
    }
    
    
    /**
     * This method is to test the Research Area audit rule.  That is, a protocol cannot be submitted without specifying at least one area of research.
     * Since this only runs at submission, any default document will throw this error at submission.
     * 
     * @throws Exception
     */
    @Test
    public void testMissingResearchArea() throws Exception {
        ProtocolDocument document = getNewProtocolDocument();
        setProtocolRequiredFields(document);
        
        assertFalse("Audit Rule should produce audit errors", auditRule.processRunAuditBusinessRules(document));
        assertEquals(1, getAuditErrorMap().size());

    }

}
