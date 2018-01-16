/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.risklevel;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.test.ProtocolFactory;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.sql.Date;
import java.util.List;
import static org.junit.Assert.*;
public class ProtocolRiskLevelServiceTest extends KcIntegrationTestBase {
    
    private static final String LOW_RISK_CODE = "1";
    private static final String HIGH_RISK_CODE = "5";
    private static final String LOW_RISK_LEVEL_COMMENTS = "Very low risk.";
    private static final String HIGH_RISK_LEVEL_COMMENTS = "Very high risk.";
    private static final String ACTIVE_STATUS = "A";
    private static final String INACTIVE_STATUS = "I";
    private static final Date ASSIGNED_DATE = org.kuali.coeus.sys.framework.util.DateUtils.convertToSqlDate(DateUtils.addDays(new Date(System.currentTimeMillis()), -1));
    private static final Date INACTIVATED_DATE = new Date(System.currentTimeMillis());
    
    private ProtocolRiskLevelServiceImpl service;
    
    @Before
    public void setUp() throws Exception {

        service = new ProtocolRiskLevelServiceImpl();
    }
    
    @After
    public void tearDown() throws Exception {
        service = null;
        
    }
    
    @Test
    public void testAddRiskLevel() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        service.addRiskLevel(getLowProtocolRiskLevel(), protocolDocument.getProtocol());
        service.addRiskLevel(getHighProtocolRiskLevel(), protocolDocument.getProtocol());
        
        verifyPersistRiskLevel(protocolDocument.getProtocol(), 0, LOW_RISK_CODE, ASSIGNED_DATE, LOW_RISK_LEVEL_COMMENTS, ACTIVE_STATUS);
        verifyPersistRiskLevel(protocolDocument.getProtocol(), 1, HIGH_RISK_CODE, ASSIGNED_DATE, HIGH_RISK_LEVEL_COMMENTS, INACTIVE_STATUS, INACTIVATED_DATE);
    }
    
    @Test
    public void testUpdateRiskLevel() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        ProtocolRiskLevel currentRiskLevel = getLowProtocolRiskLevel();
        ProtocolRiskLevel newProtocolRiskLevel = new ProtocolRiskLevel();
        service.addRiskLevel(currentRiskLevel, protocolDocument.getProtocol());
        currentRiskLevel.setDateInactivated(INACTIVATED_DATE);
        service.updateRiskLevel(currentRiskLevel, newProtocolRiskLevel);
        service.addRiskLevel(newProtocolRiskLevel, protocolDocument.getProtocol());
        
        verifyPersistRiskLevel(protocolDocument.getProtocol(), 0, LOW_RISK_CODE, ASSIGNED_DATE, LOW_RISK_LEVEL_COMMENTS, INACTIVE_STATUS, INACTIVATED_DATE);
        verifyPersistRiskLevel(protocolDocument.getProtocol(), 1, LOW_RISK_CODE, ASSIGNED_DATE, LOW_RISK_LEVEL_COMMENTS, ACTIVE_STATUS);
    }
    
    @Test
    public void testDeleteRiskLevel() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();
        
        service.addRiskLevel(getLowProtocolRiskLevel(), protocolDocument.getProtocol());
        service.deleteRiskLevel(0, protocolDocument.getProtocol());
        assertEquals(0, protocolDocument.getProtocol().getProtocolRiskLevels().size());
    }
    
    private ProtocolRiskLevel getLowProtocolRiskLevel() {
        ProtocolRiskLevel protocolRiskLevel = new ProtocolRiskLevel();
        protocolRiskLevel.setRiskLevelCode(LOW_RISK_CODE);
        protocolRiskLevel.setDateAssigned(ASSIGNED_DATE);
        protocolRiskLevel.setComments(LOW_RISK_LEVEL_COMMENTS);
        protocolRiskLevel.setStatus(ACTIVE_STATUS);
        return protocolRiskLevel;
    }
    
    private ProtocolRiskLevel getHighProtocolRiskLevel() {
        ProtocolRiskLevel protocolRiskLevel = new ProtocolRiskLevel();
        protocolRiskLevel.setRiskLevelCode(HIGH_RISK_CODE);
        protocolRiskLevel.setDateAssigned(ASSIGNED_DATE);
        protocolRiskLevel.setComments(HIGH_RISK_LEVEL_COMMENTS);
        protocolRiskLevel.setStatus(INACTIVE_STATUS);
        protocolRiskLevel.setDateInactivated(INACTIVATED_DATE);
        return protocolRiskLevel;
    }
    
    private void verifyPersistRiskLevel(Protocol protocol, int index, String expectedRiskLevelCode, Date expectedDateAssigned, String expectedComments, 
            String expectedStatus) {
        verifyPersistRiskLevel(protocol, index, expectedRiskLevelCode, expectedDateAssigned, expectedComments, expectedStatus, null);
    }
    
    private void verifyPersistRiskLevel(Protocol protocol, int index, String expectedRiskLevelCode, Date expectedDateAssigned, String expectedComments, 
            String expectedStatus, Date expectedDateUpdated) {
        ProtocolRiskLevel protocolRiskLevel = findProtocolRiskLevel(protocol, index);
        assertEquals(protocolRiskLevel.getProtocolId(), protocol.getProtocolId());
        assertEquals(expectedRiskLevelCode, protocolRiskLevel.getRiskLevelCode());
        assertEquals(expectedDateAssigned, protocolRiskLevel.getDateAssigned());
        assertEquals(expectedComments, protocolRiskLevel.getComments());
        assertEquals(expectedStatus, protocolRiskLevel.getStatus());
        assertEquals(expectedDateUpdated, protocolRiskLevel.getDateInactivated());
    }
    
    private ProtocolRiskLevel findProtocolRiskLevel(Protocol protocol, int index) {
        List<ProtocolRiskLevel> riskLevels = protocol.getProtocolRiskLevels();
        assertTrue(index + 1 <= riskLevels.size());
        return riskLevels.get(index);
    }

}
