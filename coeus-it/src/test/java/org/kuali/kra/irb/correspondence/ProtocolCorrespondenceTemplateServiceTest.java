/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import org.apache.struts.upload.FormFile;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ProtocolCorrespondenceTemplateServiceTest extends KcIntegrationTestBase {
    private static final String  COMMITTEE_ID = "commid";
    private static final String  AGENDA_TYPE = "9";
    private static final String  AGENDA_FILE_NAME = "agenda.xml";

    Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
    FormFile mockedFile = null;

    @Before
    public void setUp() throws Exception {
        mockedFile = this.context.mock(FormFile.class);
    }
    
    @After
    public void tearDown() throws Exception {
        mockedFile = null;
    }
    
    @Test
    public void addDefaultProtocolCorrespondenceTemplateTest() throws Exception {
        simulateValidMockedFileBehavior();

        ProtocolCorrespondenceType correspondenceType = new ProtocolCorrespondenceType();
        ProtocolCorrespondenceTemplate newCorrespondenceTemplate = new ProtocolCorrespondenceTemplate();
        newCorrespondenceTemplate.setProtoCorrespTypeCode("5");
        newCorrespondenceTemplate.setTemplateFile(mockedFile);

        getProtocolCorrespondenceTemplateService().addDefaultProtocolCorrespondenceTemplate(correspondenceType, newCorrespondenceTemplate);

        assertEquals(newCorrespondenceTemplate.getProtoCorrespTypeCode(), correspondenceType.getDefaultProtocolCorrespondenceTemplate().getProtoCorrespTypeCode());
        assertEquals("DEFAULT", correspondenceType.getDefaultProtocolCorrespondenceTemplate().getCommitteeId());
        assertEquals(newCorrespondenceTemplate.getFileName(), correspondenceType.getDefaultProtocolCorrespondenceTemplate().getFileName());
        assertTrue(correspondenceType.getCommitteeProtocolCorrespondenceTemplates().isEmpty());
    }
    
    @Test
    public void addCommitteeProtocolCorrespondenceTemplateTest() throws Exception {
        simulateValidMockedFileBehavior();
        
        ProtocolCorrespondenceType correspondenceType = new ProtocolCorrespondenceType();
        ProtocolCorrespondenceTemplate newCorrespondenceTemplate = new ProtocolCorrespondenceTemplate();
        newCorrespondenceTemplate.setProtoCorrespTypeCode("5");
        newCorrespondenceTemplate.setCommitteeId("Committee1");
        newCorrespondenceTemplate.setTemplateFile(mockedFile);

        getProtocolCorrespondenceTemplateService().addCommitteeProtocolCorrespondenceTemplate(correspondenceType, newCorrespondenceTemplate);

        assertEquals(1, correspondenceType.getCommitteeProtocolCorrespondenceTemplates().size());
        assertEquals(newCorrespondenceTemplate.getProtoCorrespTypeCode(), correspondenceType.getCommitteeProtocolCorrespondenceTemplates().get(0).getProtoCorrespTypeCode());
        assertEquals(newCorrespondenceTemplate.getCommitteeId(), correspondenceType.getCommitteeProtocolCorrespondenceTemplates().get(0).getCommitteeId());
        assertEquals(newCorrespondenceTemplate.getFileName(), correspondenceType.getCommitteeProtocolCorrespondenceTemplates().get(0).getFileName());
        assertTrue(correspondenceType.getDefaultProtocolCorrespondenceTemplate() == null);
    }
    
    /**
     * This method is to get the protocol correspondence template service.
     * @return ProtocolCorrespondenceTemplateService
     */
    private ProtocolCorrespondenceTemplateService getProtocolCorrespondenceTemplateService() {
        return (ProtocolCorrespondenceTemplateService) KcServiceLocator.getService("protocolCorrespondenceTemplateService");
    }

    private void simulateValidMockedFileBehavior() throws IOException {
        this.context.checking(new Expectations() {{
            allowing(mockedFile).getFileName();
            will(returnValue("template.xml"));
            
            allowing(mockedFile).getFileData();
            will(returnValue(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
        }});
    }

    @Test
    public void testGetProtocolCorrespondenceTemplate() throws Exception {
        ProtocolCorrespondenceTemplateServiceImpl templateService = new ProtocolCorrespondenceTemplateServiceImpl();
        final BusinessObjectService businessObjectService = context.mock(BusinessObjectService.class);
        ProtocolCorrespondenceTemplate template = new ProtocolCorrespondenceTemplate();
        template.setCommitteeId(COMMITTEE_ID);
        template.setProtoCorrespTypeCode(AGENDA_TYPE);
        template.setFileName(AGENDA_FILE_NAME);
        final List<ProtocolCorrespondenceTemplate> templates = new ArrayList<ProtocolCorrespondenceTemplate>();
        templates.add(template);
        context.checking(new Expectations() {
            {
                Map fieldValues = new HashMap();
                fieldValues.put("committeeId", COMMITTEE_ID);
                fieldValues.put("protoCorrespTypeCode", AGENDA_TYPE);
                oneOf(businessObjectService).findMatching(ProtocolCorrespondenceTemplate.class, fieldValues);
                will(returnValue(templates));


            }
        });
        templateService.setBusinessObjectService(businessObjectService);
        ProtocolCorrespondenceTemplate protocolTemplate = (ProtocolCorrespondenceTemplate) templateService.getProtocolCorrespondenceTemplate(COMMITTEE_ID, AGENDA_TYPE);
        Assert.assertEquals(protocolTemplate.getCommitteeId(), COMMITTEE_ID);
        Assert.assertEquals(protocolTemplate.getProtoCorrespTypeCode(), AGENDA_TYPE);
        Assert.assertEquals(protocolTemplate.getFileName(), AGENDA_FILE_NAME);

    }


}
