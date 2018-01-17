/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.common.notification;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRole;
import org.kuali.coeus.common.notification.impl.service.KcNotificationModuleRoleService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
public class KcNotificationModuleRoleServiceTest extends KcIntegrationTestBase {

    protected KcNotificationModuleRoleService kcNotificationModuleRoleService;
    
    @Before
    public void setUp() throws Exception {
        kcNotificationModuleRoleService = KcServiceLocator.getService(KcNotificationModuleRoleService.class);
    }

    @After
    public void tearDown() throws Exception {
        kcNotificationModuleRoleService = null;
    }
    
    @Test
    public void testGetNotifications() {
        List<NotificationModuleRole> moduleRoles =
            kcNotificationModuleRoleService.getNotificationModuleRoles(CoeusModule.IRB_MODULE_CODE);
        
        assertTrue(moduleRoles.size() > 0);
    }
    
    @Test
    public void testGetModuleRoleForAjaxCall() throws Exception {
        String result = kcNotificationModuleRoleService.getNotificationModuleRolesString(CoeusModule.IRB_MODULE_CODE);
        
        assertNotNull(result);
    }
    
}
