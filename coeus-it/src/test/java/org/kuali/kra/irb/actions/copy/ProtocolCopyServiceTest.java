/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.copy;


import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.test.ProtocolFactory;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.service.DocumentService;

public class ProtocolCopyServiceTest extends KcIntegrationTestBase {

    private DocumentService documentService;
    private ProtocolCopyService protocolCopyService;

    @Before
    public void setUpServices() {
        documentService = KcServiceLocator.getService(DocumentService.class);
        protocolCopyService = KcServiceLocator.getService(ProtocolCopyService.class);
    }

    @After
    public void tearDownServices() {
        documentService = null;
        protocolCopyService = null;
    }

    @Test
    public void test_basic_copy() throws Exception {
        ProtocolDocument protocolDocument = ProtocolFactory.createProtocolDocument();

        ProtocolDocument copyProtocolDocument = protocolCopyService.copyProtocol(protocolDocument);
        documentService.saveDocument(protocolDocument);

        Assert.assertTrue(protocolDocument.getProtocol().getProtocolId() < copyProtocolDocument.getProtocol().getProtocolId());
    }
}
