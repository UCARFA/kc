/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.award.finance.timeAndMoney.api;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.coeus.sys.framework.rest.UnauthorizedAccessException;
import org.kuali.coeus.sys.framework.rest.UnprocessableEntityException;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.FeatureFlagConstants;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.beans.IntrospectionException;
import java.util.HashMap;
import java.util.UUID;

public class TimeAndMoneyControllerTest extends KcIntegrationTestBase {

    @Before
    public void beforeTest() {
        updateParameterForTesting(Constants.MODULE_NAMESPACE_SYSTEM, ParameterConstants.DOCUMENT_COMPONENT,
                FeatureFlagConstants.ENABLE_API_AUTHORIZATION, "true");
    }

    public void useAuthorizedUser() {
        GlobalVariables.setMessageMap(new MessageMap());
        GlobalVariables.setAuditErrorMap(new HashMap<>());
        final UserSession userSession = new UserSession("admin");
        userSession.setKualiSessionId(UUID.randomUUID().toString());
        GlobalVariables.setUserSession(userSession);

    }

    public void useUnauthorizedUser() {
        GlobalVariables.setMessageMap(new MessageMap());
        GlobalVariables.setAuditErrorMap(new HashMap<>());
        final UserSession userSession = new UserSession("quickstart");
        userSession.setKualiSessionId(UUID.randomUUID().toString());
        GlobalVariables.setUserSession(userSession);

    }

    @Test
    public void getTimeAndMoneyPosts() throws IntrospectionException {
        useAuthorizedUser();
        getTimeAndMoneyController().getTimeAndMoneyPosts();
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getPost() throws IntrospectionException {
        useAuthorizedUser();
        getTimeAndMoneyController().getPost(1L);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void putTimeAndMoneyPost() throws IntrospectionException {
        useAuthorizedUser();
        getTimeAndMoneyController().putTimeAndMoneyPost(null, 1L);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getTimeAndMoneydocument() throws IntrospectionException {
        useAuthorizedUser();
        getTimeAndMoneyController().getTimeAndMoneydocument("1");
    }

    @Test(expected = UnprocessableEntityException.class)
    public void createTimeAndMoneyDocument() throws Exception {
        useAuthorizedUser();
        getTimeAndMoneyController().createTimeAndMoneyDocument(null);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void submitDocument() throws Exception {
        useAuthorizedUser();
        getTimeAndMoneyController().submitDocument("1234");
    }

    @Test(expected = UnprocessableEntityException.class)
    public void versionTimeAndMoney() throws Exception {
        useAuthorizedUser();
        getTimeAndMoneyController().versionTimeAndMoney(null, "1234");
    }


    @Test(expected = UnauthorizedAccessException.class)
    public void submitDocumentWithoutAuthorization() throws Exception {
        useUnauthorizedUser();
        getTimeAndMoneyController().submitDocument("1234");
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void versionTimeAndMoneyWithoutAuthorization() throws Exception {
        useUnauthorizedUser();
        getTimeAndMoneyController().versionTimeAndMoney(null, "1234");
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void getTimeAndMoneyPostsWithoutAuthorization() throws IntrospectionException {
        useUnauthorizedUser();
        getTimeAndMoneyController().getTimeAndMoneyPosts();
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void getPostWithoutAuthorization() throws IntrospectionException {
        useUnauthorizedUser();
        getTimeAndMoneyController().getPost(1L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void putTimeAndMoneyPostWithoutAuthorization() throws IntrospectionException {
        useUnauthorizedUser();
        getTimeAndMoneyController().putTimeAndMoneyPost(null, 1L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void getTimeAndMoneydocumentWithoutAuthorization() throws IntrospectionException {
        useUnauthorizedUser();
        getTimeAndMoneyController().getTimeAndMoneydocument("1");
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void createTimeAndMoneyDocumentWithoutAuthorization() throws Exception {
        useUnauthorizedUser();
        getTimeAndMoneyController().createTimeAndMoneyDocument(null);
    }

    public TimeAndMoneyController getTimeAndMoneyController() throws IntrospectionException {
        return KcServiceLocator.getService(TimeAndMoneyController.class);
    }
}
