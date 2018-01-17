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
import org.kuali.kra.award.home.AwardAmountInfo;

import java.util.ArrayList;
import java.util.List;

public class AwardAmountInfoServiceImplTest {

    AwardAmountInfoServiceImpl awardAmountInfoServiceImpl;
    
    @Before
    public void setUp() throws Exception {
        awardAmountInfoServiceImpl = new AwardAmountInfoServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
        awardAmountInfoServiceImpl = null;
    }

    @Test
    public void testFetchAwardAmountInfoWithHighestTransactionId(){
        List<AwardAmountInfo> awardAmountInfos = new ArrayList<AwardAmountInfo>();
        addAwardAmountInfos(awardAmountInfos, 1);
        addAwardAmountInfos(awardAmountInfos, 4);
        addAwardAmountInfos(awardAmountInfos, 3);
        addAwardAmountInfos(awardAmountInfos, 13);
        addAwardAmountInfos(awardAmountInfos, 32);
        addAwardAmountInfos(awardAmountInfos, 115);
        Assert.assertEquals(new Long(115), awardAmountInfoServiceImpl.fetchAwardAmountInfoWithHighestTransactionId(awardAmountInfos).getAwardAmountInfoId());
    }
    
    private void addAwardAmountInfos(List<AwardAmountInfo> awardAmountInfos, int awardAmountInfoId) {
        AwardAmountInfo newAwardAmountInfo = new AwardAmountInfo();
        newAwardAmountInfo.setAwardAmountInfoId(new Long(awardAmountInfoId));
        awardAmountInfos.add(newAwardAmountInfo);
    }

}
