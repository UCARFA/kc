/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;
import org.kuali.rice.krad.util.MessageMap;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class AwardFandARateAuditRuleTest {
    private AwardFandARateAuditRule rule; 
    AwardFandaRate awardFandaRate1;
    AwardFandaRate awardFandaRate2;
    private Award award;
    
    @Before
    public void setUp() throws Exception {
        GlobalVariables.setAuditErrorMap(new HashMap<String, AuditCluster>());
        rule = new AwardFandARateAuditRule();
        rule.setFinder(new KeyValuesBase() {
            @Override
            public String getKeyLabel(String key) {
                return key.equals("5") ? "A" : "B";
            }

            @Override
            public List<KeyValue> getKeyValues() {
                return null;
            }
        });
        
        award = new Award();
        
        awardFandaRate1 = new AwardFandaRate();
        awardFandaRate1.setApplicableFandaRate(new ScaleTwoDecimal(5));
        awardFandaRate1.setFiscalYear("2008");
        awardFandaRate1.setFandaRateTypeCode("5");
        awardFandaRate1.setOnCampusFlag("N");
        awardFandaRate1.setUnderrecoveryOfIndirectCost(new ScaleTwoDecimal(1000));
        awardFandaRate1.setStartDate(new Date(new Long("1183316613046")));        
        awardFandaRate1.setEndDate(new Date(new Long("1214852613046")));
        
        awardFandaRate2 = new AwardFandaRate();
        awardFandaRate2.setApplicableFandaRate(new ScaleTwoDecimal(5));
        awardFandaRate2.setFiscalYear("2008");
        awardFandaRate2.setFandaRateTypeCode("5");
        awardFandaRate2.setOnCampusFlag("F");
        awardFandaRate2.setUnderrecoveryOfIndirectCost(new ScaleTwoDecimal(1000));
        awardFandaRate2.setStartDate(new Date(new Long("1183316613046")));        
        awardFandaRate2.setEndDate(new Date(new Long("1214852613046")));
        award.add(awardFandaRate1);
        award.add(awardFandaRate2);
        
        
        GlobalVariables.setMessageMap(new MessageMap());
    }
    
    @Test
    public final void testIsFandaRateInputInPairs() {
        List<AwardFandaRate> awardFandaRateList = award.getAwardFandaRate();
        
        awardFandaRateList.add(new AwardFandaRate());
        awardFandaRateList.add(new AwardFandaRate());
        awardFandaRateList.get(2).setFandaRateTypeCode("6");
        awardFandaRateList.get(2).setOnCampusFlag("F");
        awardFandaRateList.get(3).setFandaRateTypeCode("6");        
        awardFandaRateList.get(3).setOnCampusFlag("N");
        
        Assert.assertTrue(rule.isFandaRateInputInPairs(awardFandaRateList));
        awardFandaRateList.get(0).setOnCampusFlag("F");
        awardFandaRateList.get(1).setOnCampusFlag("F");
        awardFandaRateList.get(2).setOnCampusFlag("F");        
        awardFandaRateList.get(3).setOnCampusFlag("F");
        Assert.assertFalse(rule.isFandaRateInputInPairs(awardFandaRateList));
    }
}
