/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.committee.document.CommitteeDocument;
import org.kuali.kra.committee.lookup.CommitteeLookupableHelperServiceImpl;
import org.kuali.kra.irb.ResearchArea;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.kns.lookup.HtmlData;
import org.kuali.rice.kns.web.ui.Field;
import org.kuali.rice.kns.web.ui.Row;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
public class CommitteeLookupHelperServiceTest extends KcIntegrationTestBase {
    
    private static final int NUMBER_LOOKUP_CRITERIA_FIELDS = 9;
    private static final String EDIT_URL = "DocHandler.do?command=displayDocSearchView&docId=101";
    
    private CommitteeLookupableHelperServiceImpl committeeLookupableHelperServiceImpl;

    @Before
    public void setUp() throws Exception {

        committeeLookupableHelperServiceImpl = new CommitteeLookupableHelperServiceImpl();
        committeeLookupableHelperServiceImpl.setBusinessObjectClass(Committee.class);
    }

    @After
    public void tearDown() throws Exception {

        committeeLookupableHelperServiceImpl = null;
    }

    /**
     * 
     * This method is to test getrows.  The lookup fields will be updated and make sure 
     * a few of the drop down fields are sert as dropdown_refresh 
     */
    @Test
    public void testGetRows() {
        List<Row> rows = committeeLookupableHelperServiceImpl.getRows();
        assertEquals(rows.size(), NUMBER_LOOKUP_CRITERIA_FIELDS);
        for (Row row : rows) {
            for (Field field : row.getFields()) {
                if (field.getPropertyName().equals("researchAreaCode")) {
                    assertDropDownField(field, "researchAreaCode", ResearchArea.class.getName());
                } else if (field.getPropertyName().equals("memberName")) {
                     assertDropDownField(field, "personName", CommitteeMembership.class.getName());
                }
            }
        }
    }

    /**
     * 
     * This method to check the 'edit' link is correct
     */
    @Test
    public void testGetCustomActionUrl() {
        List pkNames = new ArrayList();
        pkNames.add("committeeId");
        Committee committee = new Committee();
        committee.setCommitteeId("100");
        committee.setHomeUnitNumber("000001");
        CommitteeDocument document = new CommitteeDocument();
        document.setDocumentNumber("101");
        committee.setCommitteeDocument(document);
        List<HtmlData> actionUrls = committeeLookupableHelperServiceImpl.getCustomActionUrls(committee,pkNames);
        assertTrue(((HtmlData.AnchorHtmlData) actionUrls.get(0)).getHref().endsWith(EDIT_URL));
    }

    /*
     * 
     * This method is to set up protocol for get inquiry url test
     * @return
     */
    private void assertDropDownField(Field field, String keyName, String className) {
        assertEquals(field.getFieldConversions(), keyName + ":" + field.getPropertyName());
        assertEquals(field.getLookupParameters(), field.getPropertyName() + ":" + keyName);
        assertEquals(field.getInquiryParameters(), field.getPropertyName() + ":" + keyName);
        assertEquals(field.getQuickFinderClassNameImpl(), className);

    }

}
