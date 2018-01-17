/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.helpers;


import org.junit.After;
import org.junit.Before;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.awardhierarchy.sync.service.AwardSyncHelpersService;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

public abstract class AwardSyncHelperTestBase extends KcIntegrationTestBase {

    protected AwardSyncHelpersService awardSyncHelpersService;
    protected String className;
    protected Award award;
    protected AwardSyncHelper awardSyncHelper;
    
    protected AwardSyncHelperTestBase(String className) {
        this.className = className;
    }
    
    @Before
    public void setUp() throws Exception {
        awardSyncHelpersService = KcServiceLocator.getService(AwardSyncHelpersService.class);
        awardSyncHelper = awardSyncHelpersService.getSyncHelper(className);
        award = new Award();
        award.setSponsorCode("000340");
    }

    @After
    public void tearDown() throws Exception {
    }

}
