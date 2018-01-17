/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.mq.rest;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.coi.framework.Project;
import org.kuali.coeus.coi.framework.ProjectRetrievalService;
import org.kuali.coeus.common.api.document.service.CommonApiService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.test.IacucProtocolFactory;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.document.Document;

import javax.jms.ObjectMessage;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ProjectPushIacucTest extends ProjectPushTestBase {

    private ProjectRetrievalService irbProjectRetrievalService;
    final String IACUC_PROJECT_RETRIEVAL_SERVICE = "iacucProjectRetrievalService";
    ProjectRetrievalService iacucProjectRetrievalService;

    private IacucProtocolDocument iacucProtocolDocument;

    @Before
    public void setUp() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        iacucProtocolDocument = IacucProtocolFactory.createProtocolDocument();
        Document iacucDoc = getCommonApiService().getDocumentFromDocId(Long.parseLong(iacucProtocolDocument.getDocumentNumber()));
    }

    @Test
	public void test() throws Exception {
        final Project iacucProject = getProjectRetrievalService().retrieveProject(getDocumentIdentifier());
        if(isCoiEnabled()) {
            ObjectMessage message = getMessageFromProject(iacucProject);
            getRestMessageConsumer().onMessage(message);
        }
    }

    protected CommonApiService getCommonApiService() {
        return KcServiceLocator.getService(CommonApiService.class);
    }

    @Override
    public String getDocumentIdentifier() {
        return iacucProtocolDocument.getProtocol().getProtocolNumber();
    }

    @Override
    public ProjectRetrievalService getProjectRetrievalService() {
        if (iacucProjectRetrievalService == null) {
            iacucProjectRetrievalService = KcServiceLocator.getService(IACUC_PROJECT_RETRIEVAL_SERVICE);
        }
        return iacucProjectRetrievalService;
    }

}
