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
import org.kuali.kra.award.paymentreports.ValidFrequencyBase;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
    
public class FrequencyBaseCodeValuesFinderTest extends KcIntegrationTestBase {
    
    FrequencyBaseCodeValuesFinder frequencyBaseCodeValuesFinder;
    List<KeyValue> frequencyBaseCodes;
    Collection<ValidFrequencyBase> validFrequencyBases;
    
    @Before
    public void setUp() throws Exception {
        frequencyBaseCodeValuesFinder = new FrequencyBaseCodeValuesFinder("13");
        frequencyBaseCodes = new ArrayList<KeyValue>();
        validFrequencyBases = new ArrayList<ValidFrequencyBase>();
        
    }

    @After
    public void tearDown() throws Exception {
        frequencyBaseCodeValuesFinder = null;
        frequencyBaseCodes = null;
        validFrequencyBases = null;
    }

    @Test
    public final void testGetKeyValues() {
        frequencyBaseCodes = frequencyBaseCodeValuesFinder.getKeyValues();
        Assert.assertEquals(3,frequencyBaseCodes.size());
        
        for(KeyValue KeyValue:frequencyBaseCodes){
            Assert.assertNotNull(KeyValue.getKey());
            Assert.assertNotNull(KeyValue.getValue());
        }
    }
    
}

