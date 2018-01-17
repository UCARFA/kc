/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */package org.kuali.coeus.common.impl.custom;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.kra.award.customdata.AwardCustomData;
import org.kuali.kra.award.home.Award;

import java.util.*;

public class CustomDataResolverTest {

    private static final String CUSTOM_ATTRIBUTE_ID = "Custom Attribute Id";

    class MockCustomDataResolver extends CustomDataResolver {

        public MockCustomDataResolver(String outputName, Set<String> params, String moduleNamePrereq) {
            super(outputName, params, moduleNamePrereq);
        }
    }

    @Test
    public void customDataResolverTest() {
        Set<String> params = new HashSet<>();
        params.add("8");
        Map<String, Object> resolvedPrereqs = new HashMap<>();
        final Award award = new Award();
        List<AwardCustomData> awardCustomDataList = new ArrayList<>();
        AwardCustomData awardCustomData = new AwardCustomData();
        awardCustomData.setCustomAttributeId(8L);
        awardCustomData.setValue("billing element");
        awardCustomDataList.add(awardCustomData);

        AwardCustomData awardCustomData1 = new AwardCustomData();
        awardCustomData1.setCustomAttributeId(9L);
        awardCustomData1.setValue("test");
        awardCustomDataList.add(awardCustomData1);
        award.setAwardCustomDataList(awardCustomDataList);

        resolvedPrereqs.put("award", award);
        MockCustomDataResolver mock = new MockCustomDataResolver("outputName", params, "award");

        Map<String, String> parameters = new HashMap<>();
        parameters.put(CUSTOM_ATTRIBUTE_ID, "8");
        Assert.assertTrue(mock.resolve(resolvedPrereqs, parameters).equals("billing element"));

        parameters = new HashMap<>();
        parameters.put(CUSTOM_ATTRIBUTE_ID, "10");
        Assert.assertTrue(mock.resolve(resolvedPrereqs, parameters) == null);

    }
}
