/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.questionnaire;

import org.junit.Test;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireAuthorizationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class QuestionnaireAuthorizationServiceTest extends KcIntegrationTestBase {

    @Test
    public void permissionModifyQuestionnaireTest() {
 
        GlobalVariables.setUserSession(new UserSession("quickstart"));
        assertTrue(KcServiceLocator.getService(QuestionnaireAuthorizationService.class).hasPermission(PermissionConstants.MODIFY_QUESTIONNAIRE));
        GlobalVariables.setUserSession(new UserSession("jtester"));
        assertFalse(KcServiceLocator.getService(QuestionnaireAuthorizationService.class).hasPermission(PermissionConstants.MODIFY_QUESTIONNAIRE));

    }
    
    @Test
    public void permissionViewQuestionnaireTest() {
 
        GlobalVariables.setUserSession(new UserSession("jtester"));
        assertTrue(KcServiceLocator.getService(QuestionnaireAuthorizationService.class).hasPermission(PermissionConstants.VIEW_QUESTIONNAIRE));
        GlobalVariables.setUserSession(new UserSession("woods"));
        assertFalse(KcServiceLocator.getService(QuestionnaireAuthorizationService.class).hasPermission(PermissionConstants.VIEW_QUESTIONNAIRE));

    }
    
}
