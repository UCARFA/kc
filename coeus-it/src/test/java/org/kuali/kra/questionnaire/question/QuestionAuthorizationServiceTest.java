/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.questionnaire.question;

import org.junit.Test;
import org.kuali.coeus.common.questionnaire.impl.question.QuestionAuthorizationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class QuestionAuthorizationServiceTest extends KcIntegrationTestBase {

    @Test
    public void permissionModifyQuestionTest() {
 
        GlobalVariables.setUserSession(new UserSession("quickstart"));
        assertTrue(KcServiceLocator.getService(QuestionAuthorizationService.class).hasPermission(PermissionConstants.MODIFY_QUESTION));
        GlobalVariables.setUserSession(new UserSession("jtester"));
        assertFalse(KcServiceLocator.getService(QuestionAuthorizationService.class).hasPermission(PermissionConstants.MODIFY_QUESTION));

    }
    @Test
    public void permissionViewQuestionTest() {
 
        GlobalVariables.setUserSession(new UserSession("jtester"));
        assertTrue(KcServiceLocator.getService(QuestionAuthorizationService.class).hasPermission(PermissionConstants.VIEW_QUESTION));
        GlobalVariables.setUserSession(new UserSession("rrabbit"));
        assertFalse(KcServiceLocator.getService(QuestionAuthorizationService.class).hasPermission(PermissionConstants.VIEW_QUESTION));

    }
    
}
