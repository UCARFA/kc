/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.risklevel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.test.ProtocolFactory;
import org.kuali.kra.irb.test.ProtocolRuleTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import java.sql.Date;
import static org.junit.Assert.*;
public class ProtocolRiskLevelRuleTest extends ProtocolRuleTestBase {
    
    private static final String RISK_LEVEL_PROPERTY_NAME = Constants.PROTOCOL_FULL_APPROVAL_ACTION_PROPERTY_KEY + ".protocolRiskLevelBean";
    
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }
    
    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
        GlobalVariables.clear();
    }
    
    @Test
    public void testAddOK() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        ProtocolRiskLevel protocolRiskLevel = new ProtocolRiskLevel();
        protocolRiskLevel.setProtocol(protocolDocument.getProtocol());
        protocolRiskLevel.setRiskLevelCode("1");
        
        ProtocolAddRiskLevelEvent event = new ProtocolAddRiskLevelEvent(protocolDocument, RISK_LEVEL_PROPERTY_NAME, protocolRiskLevel);
        ProtocolAddRiskLevelRule rule = new ProtocolAddRiskLevelRule();
        assertTrue(rule.processRules(event));
    }
    
    @Test
    public void testAddAbsentRiskLevel() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        ProtocolRiskLevel protocolRiskLevel = new ProtocolRiskLevel();
        protocolRiskLevel.setProtocol(protocolDocument.getProtocol());
        
        ProtocolAddRiskLevelEvent event = new ProtocolAddRiskLevelEvent(protocolDocument, RISK_LEVEL_PROPERTY_NAME, protocolRiskLevel);
        ProtocolAddRiskLevelRule rule = new ProtocolAddRiskLevelRule();
        assertFalse(rule.processRules(event));
        assertError(RISK_LEVEL_PROPERTY_NAME + ".newProtocolRiskLevel.riskLevelCode", KeyConstants.ERROR_REQUIRED);
    }
    
    @Test
    public void testAddAbsentDateAssigned() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        ProtocolRiskLevel protocolRiskLevel = new ProtocolRiskLevel();
        protocolRiskLevel.setProtocol(protocolDocument.getProtocol());
        protocolRiskLevel.setRiskLevelCode("1");
        protocolRiskLevel.setDateAssigned(null);
        
        ProtocolAddRiskLevelEvent event = new ProtocolAddRiskLevelEvent(protocolDocument, RISK_LEVEL_PROPERTY_NAME, protocolRiskLevel);
        ProtocolAddRiskLevelRule rule = new ProtocolAddRiskLevelRule();
        assertFalse(rule.processRules(event));
        assertError(RISK_LEVEL_PROPERTY_NAME + ".newProtocolRiskLevel.dateAssigned", KeyConstants.ERROR_REQUIRED);
    }
    
    @Test
    public void testAddDuplicateRiskLevels() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        ProtocolRiskLevel protocolRiskLevel = new ProtocolRiskLevel();
        protocolRiskLevel.setProtocol(protocolDocument.getProtocol());
        protocolRiskLevel.setRiskLevelCode("1");
        protocolRiskLevel.setComments("Original");
        
        protocolDocument.getProtocol().getProtocolRiskLevels().add(protocolRiskLevel);
        
        ProtocolRiskLevel duplicateProtocolRiskLevel = new ProtocolRiskLevel();
        duplicateProtocolRiskLevel.setProtocol(protocolDocument.getProtocol());
        duplicateProtocolRiskLevel.setRiskLevelCode("1");
        duplicateProtocolRiskLevel.setComments("Duplicate");
        
        ProtocolAddRiskLevelEvent event = new ProtocolAddRiskLevelEvent(protocolDocument, RISK_LEVEL_PROPERTY_NAME, duplicateProtocolRiskLevel);
        ProtocolAddRiskLevelRule rule = new ProtocolAddRiskLevelRule();
        assertFalse(rule.processRules(event));
        assertError(RISK_LEVEL_PROPERTY_NAME + ".newProtocolRiskLevel.riskLevelCode", KeyConstants.ERROR_PROTOCOL_DUPLICATE_RISK_LEVEL);
    }
    
    @Test
    public void testAddActiveInactiveStatus() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        ProtocolRiskLevel protocolRiskLevel = new ProtocolRiskLevel();
        protocolRiskLevel.setProtocol(protocolDocument.getProtocol());
        protocolRiskLevel.setRiskLevelCode("1");
        protocolRiskLevel.setStatus("A");
        protocolRiskLevel.setComments("Original");
        
        protocolDocument.getProtocol().getProtocolRiskLevels().add(protocolRiskLevel);
        
        ProtocolRiskLevel duplicateProtocolRiskLevel = new ProtocolRiskLevel();
        duplicateProtocolRiskLevel.setProtocol(protocolDocument.getProtocol());
        duplicateProtocolRiskLevel.setRiskLevelCode("1");
        duplicateProtocolRiskLevel.setStatus("I");
        duplicateProtocolRiskLevel.setComments("Duplicate");
        
        ProtocolAddRiskLevelEvent event = new ProtocolAddRiskLevelEvent(protocolDocument, RISK_LEVEL_PROPERTY_NAME, duplicateProtocolRiskLevel);
        ProtocolAddRiskLevelRule rule = new ProtocolAddRiskLevelRule();
        assertTrue(rule.processRules(event));
    }
    
    @Test
    public void testUpdateOK() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        ProtocolRiskLevel protocolRiskLevel = new ProtocolRiskLevel();
        protocolRiskLevel.setProtocol(protocolDocument.getProtocol());
        protocolRiskLevel.setRiskLevelCode("1");
        protocolRiskLevel.setStatus("A");
        protocolRiskLevel.setComments("Original");
        
        protocolDocument.getProtocol().getProtocolRiskLevels().add(protocolRiskLevel);
        
        protocolRiskLevel.setStatus("I");
        protocolRiskLevel.setDateInactivated(new Date(System.currentTimeMillis()));
        
        ProtocolUpdateRiskLevelEvent event = new ProtocolUpdateRiskLevelEvent(protocolDocument, 0);
        ProtocolUpdateRiskLevelRule rule = new ProtocolUpdateRiskLevelRule();
        assertTrue(rule.processRules(event));
    }
    
    @Test
    public void testUpdateAbsentDateUpdated() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        ProtocolRiskLevel protocolRiskLevel = new ProtocolRiskLevel();
        protocolRiskLevel.setProtocol(protocolDocument.getProtocol());
        protocolRiskLevel.setRiskLevelCode("1");
        protocolRiskLevel.setStatus("A");
        protocolRiskLevel.setComments("Original");
        
        protocolDocument.getProtocol().getProtocolRiskLevels().add(protocolRiskLevel);
        
        protocolRiskLevel.setStatus("I");
        
        ProtocolUpdateRiskLevelEvent event = new ProtocolUpdateRiskLevelEvent(protocolDocument, 0);
        ProtocolUpdateRiskLevelRule rule = new ProtocolUpdateRiskLevelRule();
        assertFalse(rule.processRules(event));
        assertError(Constants.PROTOCOL_UPDATE_RISK_LEVEL_KEY + "[" + event.getIndex() + "].dateInactivated", KeyConstants.ERROR_PROTOCOL_DATE_INACTIVATED_REQUIRED);
    }
    
}
