/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.budget.nonpersonnel;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetJustificationWrapper;

import java.sql.Date;

public class BudgetJustificationWrapperTest {
    private static final String JUSTIFICATION_TEXT_WITH_XML_MARKUP = "A justification with <xml> markup";
    private static final Date TEST_DATE = new Date(System.currentTimeMillis());
    
    @Test
    public void testParsingBudgetJustification() throws Exception {
        BudgetJustificationWrapper budgetDocumentWrapper = new BudgetJustificationWrapper(TEST_DATE, "testUser", JUSTIFICATION_TEXT_WITH_XML_MARKUP);
        String xmlSerialization = budgetDocumentWrapper.toString();
        
        BudgetJustificationWrapper testBudgetDocumentWrapper = new BudgetJustificationWrapper(xmlSerialization);
        Assert.assertEquals(JUSTIFICATION_TEXT_WITH_XML_MARKUP, testBudgetDocumentWrapper.getJustificationText());
        
        
        Assert.assertEquals(xmlSerialization, testBudgetDocumentWrapper.toString());
    }
}
