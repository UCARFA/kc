/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notification;

import org.apache.struts.upload.FormFile;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProtocolNotificationTemplateRuleTest {
    Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
    FormFile mockedFile = null;

    @Before
    public void setUp() throws Exception {

        mockedFile = this.context.mock(FormFile.class);

        // Clear any error messages that may have been created in prior tests.
        MessageMap messageMap = GlobalVariables.getMessageMap();
        messageMap.clearErrorMessages();
    }

    @After
    public void tearDown() throws Exception {
        mockedFile = null;
    }

    /**
     * 
     * This test simulates a correspondence template being added whose committee is not specified.
     * 
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testReplaceNotificationTemplateOK() throws Exception {
        simulateValidMockedFileBehavior(Constants.CORRESPONDENCE_TEMPLATE_CONTENT_TYPE_1);

        ProtocolNotificationTemplate template = new ProtocolNotificationTemplate();
        template.setActionTypeCode("116");
        template.setFileName("notifyirb.xsl");
        template.setNotificationTemplate(new byte[] { (byte) 1, (byte) 2, (byte) 3 });
        template.setTemplateFile(mockedFile);
        int index = 2;

        boolean rulePassed = new ProtocolNotificationTemplateRule()
                .processReplaceProtocolNotificationTemplateRules(template, index);
        assertTrue(rulePassed);

        /*
         * There should be no errors.
         */
        MessageMap messageMap = GlobalVariables.getMessageMap();
        assertEquals(0, messageMap.getErrorCount());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testReplaceNotificationTemplateNotOK() throws Exception {
        simulateValidMockedFileBehavior("pdf");

        ProtocolNotificationTemplate template = new ProtocolNotificationTemplate();
        template.setActionTypeCode("116");
        template.setFileName("test.pdf");
        template.setNotificationTemplate(new byte[] {});
        template.setTemplateFile(mockedFile);
        int index = 2;

        boolean rulePassed = new ProtocolNotificationTemplateRule()
                .processReplaceProtocolNotificationTemplateRules(template, index);
        Assert.assertFalse(rulePassed);

        /*
         * There should be no errors.
         */
        MessageMap messageMap = GlobalVariables.getMessageMap();
        assertEquals(1, messageMap.getErrorCount());
    }

    private void simulateValidMockedFileBehavior(final String contentType) throws IOException {
        this.context.checking(new Expectations() {
            {
                allowing(mockedFile).getContentType();
                will(returnValue(contentType));

                allowing(mockedFile).getFileData();
                will(returnValue(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
            }
        });
    }


}
