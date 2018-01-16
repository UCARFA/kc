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
import org.kuali.kra.award.commitments.AwardFandaRate;
import org.kuali.kra.award.paymentreports.awardreports.AwardReportTerm;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class tests the <code>AwardDocumentRule</code> class
 */
public class AwardDocumentRuleTest extends AwardDocumentRule{
    List<AwardFandaRate> awardFandaRateList;
    AwardFandaRate awardFandaRate1;
    AwardFandaRate awardFandaRate2;
    AwardDocumentRule awardDocumentRule;
    AwardReportTerm awardReportTerm;

    @Before
    public void setUp() throws Exception {
        awardFandaRateList = new ArrayList<>();
        awardDocumentRule = new AwardDocumentRule();
        awardFandaRate1 = new AwardFandaRate();
        awardFandaRate2 = new AwardFandaRate();
        awardReportTerm = new AwardReportTerm();
        
        awardFandaRate1.setApplicableFandaRate(new ScaleTwoDecimal(5));
        awardFandaRate1.setFiscalYear("2008");
        awardFandaRate1.setFandaRateTypeCode("5");
        awardFandaRate1.setOnCampusFlag("N");
        awardFandaRate1.setUnderrecoveryOfIndirectCost(new ScaleTwoDecimal(1000));
        awardFandaRate1.setStartDate(new Date(new Long("1183316613046")));        
        awardFandaRate1.setEndDate(new Date(new Long("1214852613046")));
        awardFandaRate2.setApplicableFandaRate(new ScaleTwoDecimal(5));
        awardFandaRate2.setFiscalYear("2008");
        awardFandaRate2.setFandaRateTypeCode("5");
        awardFandaRate2.setOnCampusFlag("F");
        awardFandaRate2.setUnderrecoveryOfIndirectCost(new ScaleTwoDecimal(1000));
        awardFandaRate2.setStartDate(new Date(new Long("1183316613046")));        
        awardFandaRate2.setEndDate(new Date(new Long("1214852613046")));
        awardFandaRateList.add(awardFandaRate1);
        awardFandaRateList.add(awardFandaRate2);
        
        
        GlobalVariables.setMessageMap(new MessageMap());
    }

    @After
    public void tearDown() throws Exception {
        awardFandaRateList = null;
        awardDocumentRule = null;
        awardFandaRate1 = null;
        awardFandaRate2 = null;
    }
    
    
    @Test
    public final void testEvaluateBusinessRuleForReportCodeField(){

        awardReportTerm.setReportClassCode("1");
        awardReportTerm.setReportCode("5");        
        Assert.assertTrue(awardDocumentRule.isValidReportCode(awardReportTerm, getReportCodes()));
        
        awardReportTerm.setReportClassCode("1");
        awardReportTerm.setReportCode("36");
        Assert.assertFalse(awardDocumentRule.isValidReportCode(awardReportTerm, getReportCodes()));
    }
    
    @Test
    public final void testIsValidFrequencyBase(){
        awardReportTerm.setFrequencyBaseCode("5");
        Assert.assertTrue(awardDocumentRule.isValidFrequencyBase(awardReportTerm, getFrequencyBaseCodes()));
        awardReportTerm.setFrequencyBaseCode("6");
        Assert.assertFalse(awardDocumentRule.isValidFrequencyBase(awardReportTerm, getFrequencyBaseCodes()));
    }
    
    protected List<KeyValue> getReportCodes(){
        List<KeyValue> reportCodes = new ArrayList<>();
        reportCodes.add(new ConcreteKeyValue("5", "Final"));
        reportCodes.add(new ConcreteKeyValue("39", "SF Something"));
        return reportCodes;
    }
    
    protected List<KeyValue> getFrequencyBaseCodes(){
        List<KeyValue> frequencyBaseCodes = new ArrayList<>();
        frequencyBaseCodes.add(new ConcreteKeyValue("5", "Final"));
        return frequencyBaseCodes;
    }
   

}
