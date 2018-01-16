/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.copy;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.test.IacucProtocolFactory;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.service.DocumentService;

public class IacucProtocolCopyServiceTest extends KcIntegrationTestBase {
    private DocumentService documentService;
    private IacucProtocolCopyService protocolCopyService;

    @Before
    public void setUpServices() {
        documentService = KcServiceLocator.getService(DocumentService.class);
        protocolCopyService = KcServiceLocator.getService(IacucProtocolCopyService.class);
    }

    @After
    public void tearDownServices() {
        documentService = null;
        protocolCopyService = null;
    }

    @Test
    public void test_basic_copy() throws Exception {
        IacucProtocolDocument protocolDocument = IacucProtocolFactory.createProtocolDocument();

        IacucProtocolDocument copyProtocolDocument = protocolCopyService.copyProtocol(protocolDocument);
        documentService.saveDocument(protocolDocument);

        Assert.assertTrue(protocolDocument.getProtocol().getProtocolId() < copyProtocolDocument.getProtocol().getProtocolId());
    }
}
