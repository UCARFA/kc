/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.document;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;
/**
 * This class tests ResearchDocumentBase.
 */
public class ResearchDocumentBaseTest extends KcIntegrationTestBase {

    @Before
    public void setUp() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }

    @After
    public void tearDown() throws Exception {
        GlobalVariables.setUserSession(null);
    }

    @Test public void testPrepareForSaveQuickstart() throws Exception {
        KcTransactionalDocumentBase researchDocumentBase = (KcTransactionalDocumentBase) KcServiceLocator.getService(DocumentService.class).getNewDocument(ProposalDevelopmentDocument.class);
        assertNull(researchDocumentBase.getUpdateTimestamp());
        assertNull(researchDocumentBase.getUpdateUser());
        prePersist(researchDocumentBase);

        assertEquals("quickstart", researchDocumentBase.getUpdateUser());
        Timestamp updateTimestamp = researchDocumentBase.getUpdateTimestamp();
        assertNotNull(researchDocumentBase.getUpdateTimestamp());

        Date currentDate = new Date(System.currentTimeMillis());
        long diff = updateTimestamp.getTime() - currentDate.getTime();

        assertTrue("Should be less than one second difference between dates", diff < 1000);
    }

    @Test public void testPrepareForSaveJtester() throws Exception {
        GlobalVariables.setUserSession(new UserSession("jtester"));

        KcTransactionalDocumentBase researchDocumentBase = (KcTransactionalDocumentBase) KcServiceLocator.getService(DocumentService.class).getNewDocument(ProposalDevelopmentDocument.class);
        assertNull(researchDocumentBase.getUpdateTimestamp());
        assertNull(researchDocumentBase.getUpdateUser());
        prePersist(researchDocumentBase);

        assertEquals("jtester", researchDocumentBase.getUpdateUser());
        Timestamp updateTimestamp = researchDocumentBase.getUpdateTimestamp();
        assertNotNull(researchDocumentBase.getUpdateTimestamp());

        Date currentDate = new Date(System.currentTimeMillis());
        long diff = updateTimestamp.getTime() - currentDate.getTime();

        assertTrue("Should be less than one second difference between dates", diff < 1000);
    }

    private void prePersist(KcTransactionalDocumentBase o) {
        final Method prePersist  = ReflectionUtils.findMethod(o.getClass(), "prePersist");
        prePersist.setAccessible(true);
        ReflectionUtils.invokeMethod(prePersist, o);
    }
}
