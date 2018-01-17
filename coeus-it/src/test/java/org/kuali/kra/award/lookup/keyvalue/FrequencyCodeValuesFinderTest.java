/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.award.paymentreports.ValidClassReportFrequency;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
    
public class FrequencyCodeValuesFinderTest extends KcIntegrationTestBase {
    
    FrequencyCodeValuesFinder frequencyCodeValuesFinder;
    List<KeyValue> frequencyCodes;
    Collection<ValidClassReportFrequency> validClassReportFrequencies;
    
    @Before
    public void setUp() throws Exception {        
        frequencyCodeValuesFinder = new FrequencyCodeValuesFinder("4","9");
        frequencyCodes = new ArrayList<KeyValue>();        
        validClassReportFrequencies = new ArrayList<ValidClassReportFrequency>();        
    }

    @After
    public void tearDown() throws Exception {
        frequencyCodeValuesFinder = null;
        frequencyCodes = null;
    }

    @Test
    public final void testGetKeyValues() {
        frequencyCodes = frequencyCodeValuesFinder.getKeyValues();
        Assert.assertEquals(5,frequencyCodes.size());
        
        for(KeyValue KeyValue:frequencyCodes){
            Assert.assertNotNull(KeyValue.getKey());
            Assert.assertNotNull(KeyValue.getValue());
        }
    }
    
    @Test
    public final void testThis(){
        frequencyCodeValuesFinder.setReportClassCode("1");
        frequencyCodeValuesFinder.setReportCode("27");
        frequencyCodes = frequencyCodeValuesFinder.getKeyValues();
        Assert.assertEquals(3,frequencyCodes.size());
        for(KeyValue KeyValue:frequencyCodes){
            Assert.assertNotNull(KeyValue.getKey());
            Assert.assertNotNull(KeyValue.getValue());
        }
    }
    
}

