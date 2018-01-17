/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.coeus.common.framework.version.history.VersionHistory;
import org.kuali.coeus.common.framework.version.history.VersionHistoryService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;

public class VersionHistoryServiceImplTest extends KcIntegrationTestBase {
    private static final String PROTOCOL_VERSION_NAME = "2001";
    private static final String AWARD_VERSION_NAME = "1001-001";
    private VersionHistoryService versioningHistoryService;
    
    @Before
    public void setUp() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));
        versioningHistoryService = KcServiceLocator.getService(VersionHistoryService.class);
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testSavingAVersionHistory() {
        Award award = createAward(AWARD_VERSION_NAME, 1);
        VersionHistory vh = versioningHistoryService.updateVersionHistory(award, VersionStatus.ACTIVE, "jtester");
        Assert.assertNotNull("VersionHistory was null", vh);
    }

    @Test
    public void testSavingVersionHistories() {
        versioningHistoryService.updateVersionHistory(createAward(AWARD_VERSION_NAME, 1), VersionStatus.ACTIVE, "u1");
        versioningHistoryService.updateVersionHistory(createProtocol(PROTOCOL_VERSION_NAME, 1), VersionStatus.ACTIVE, "u2");
        
        List<VersionHistory> list = versioningHistoryService.loadVersionHistory(Award.class, AWARD_VERSION_NAME); 
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(VersionStatus.ACTIVE, list.get(0).getStatus());
        
        list = versioningHistoryService.loadVersionHistory(Protocol.class, PROTOCOL_VERSION_NAME); 
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(VersionStatus.ACTIVE, list.get(0).getStatus());
        
        VersionHistory activeVersion = versioningHistoryService.findActiveVersion(Award.class, AWARD_VERSION_NAME);
        Assert.assertEquals("u1", activeVersion.getUserId());
        
        activeVersion = versioningHistoryService.findActiveVersion(Protocol.class, PROTOCOL_VERSION_NAME);
        Assert.assertEquals("u2", activeVersion.getUserId());        
    }
    
    private Award createAward(String versionName, Integer versionNumber) {
        Award award = new Award();
        award.setAwardNumber(versionName);
        award.setSequenceNumber(versionNumber);
        return award;
    }
    
    private Protocol createProtocol(String versionName, Integer versionNumber) {
        Protocol protocol = new Protocol();
        protocol.setProtocolNumber(versionName);
        protocol.setSequenceNumber(versionNumber);
        return protocol;
    }
}
