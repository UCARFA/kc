/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.meeting;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.committee.impl.meeting.AlternateForValuesFinder;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.List;

public class AlternateForValuesFinderTest {


    @Test
    public void testGetKeyValues() throws Exception {
        AlternateForValuesFinder alternateForValuesFinder = new AlternateForValuesFinder();
        alternateForValuesFinder.setAbsenteeList("001#f#Test 1#m#002#f#Test 2");
        List<KeyValue> keyValues = alternateForValuesFinder.getKeyValues();
        Assert.assertEquals(keyValues.size(), 3);
        Assert.assertEquals(keyValues.get(1).getKey(), "001");
        Assert.assertEquals(keyValues.get(1).getValue(), "Test 1");
        Assert.assertEquals(keyValues.get(2).getKey(), "002");
        Assert.assertEquals(keyValues.get(2).getValue(), "Test 2");
    }


}
