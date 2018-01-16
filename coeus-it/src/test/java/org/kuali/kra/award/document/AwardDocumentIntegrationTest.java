/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.document;

import org.junit.Test;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.GlobalVariables;
import static org.junit.Assert.*;
public class AwardDocumentIntegrationTest extends KcIntegrationTestBase {
    
    @Test
    public void testSavingDocument() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));

        AwardDocument doc = (AwardDocument) KRADServiceLocatorWeb.getDocumentService().getNewDocument(AwardDocument.class);
        assertNotNull(doc);
    }
}
