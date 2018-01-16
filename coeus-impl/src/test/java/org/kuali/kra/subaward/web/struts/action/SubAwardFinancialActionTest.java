/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.web.struts.action;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.kra.subaward.bo.SubAwardAmountInfo;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.sql.Date;

public class SubAwardFinancialActionTest {

    SubAwardFinancialAction subAwardFinancialAction; 
    SubAward subAward;
    SubAwardAmountInfo amountInfo;  

    @Before
    public void setUp() throws Exception {

        subAwardFinancialAction = new SubAwardFinancialAction() {
        	@Override
        	public void saveSubAwardAmountInfo(SubAwardAmountInfo subAwardAmountInfo) { }
        };
        subAward = new SubAward();
        amountInfo = new SubAwardAmountInfo();
        amountInfo.setAnticipatedAmount(new ScaleTwoDecimal(5));
        amountInfo.setAnticipatedChange(new ScaleTwoDecimal(8));
        amountInfo.setEffectiveDate(new Date(System.currentTimeMillis()));
        amountInfo.setObligatedAmount(new ScaleTwoDecimal(7));
        amountInfo.setObligatedChange(new ScaleTwoDecimal(6));
        amountInfo.setComments("Test Comments");
    }
    @After
    public void tearDown() throws Exception {

        subAwardFinancialAction = null;
        subAward = null;
        amountInfo = null;
    }

    @Test
    public void testAddAmountInfoToSubAward(){
        Assert.assertTrue(subAwardFinancialAction.addAmountInfoToSubAward(subAward, amountInfo));
    }

}
