/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.util.GlobalVariables;

public class MinimalAwardTest extends KcIntegrationTestBase {

    private Award award;
    private DocumentService docService;
    private AwardDocument awardDocument;

    @Before
    public void setUp() throws Exception {
        award = AwardFixtureFactory.createAwardFixture();
        docService = KcServiceLocator.getService(DocumentService.class);
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSavingAward() throws Exception {
        awardDocument = (AwardDocument) docService.getNewDocument(AwardDocument.class);
        awardDocument.getDocumentHeader().setDocumentDescription("A description");
        awardDocument.setAward(award);
        docService.saveDocument(awardDocument);
        
        Assert.assertNotNull("Award ID was null", award.getAwardId());
    }
}
