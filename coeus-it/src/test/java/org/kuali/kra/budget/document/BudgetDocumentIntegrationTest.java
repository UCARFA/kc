/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.budget.document;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BudgetDocumentIntegrationTest extends KcIntegrationTestBase {
    private static final int MILLIS_PER_SECOND = 1000;
    
    private Budget budget;
    
    @Before
    public void setUp() {
        budget = new ProposalDevelopmentBudgetExt();
    }
    
    @After
    public void tearDown() {
        budget = null;
    }
    
    @Test
    public void testLoadingFiscalYearStart() {
        Date fiscalYearStart = budget.loadFiscalYearStart();
        
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(2000, Calendar.JULY, 1, 0, 0, 0);
        
        // a small delta has resulted during testing, but always less than a second. Why? I have no idea.
        Assert.assertTrue(Math.abs(cal.getTimeInMillis() - fiscalYearStart.getTime()) < MILLIS_PER_SECOND); 
    }
}
