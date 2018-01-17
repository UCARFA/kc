/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.sponsor.term.SponsorTerm;
import org.kuali.kra.award.service.impl.AwardSponsorTermServiceImpl;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * This class tests AwardSponsorTermService methods.
 */
public class AwardSponsorTermServiceImplTest extends AwardSponsorTermServiceImpl {

    private static final String ONE = "1";
    private static final String TWO= "2";

    private static final String TEST_STRING_ONE = "test1";
    private static final String TEST_STRING_TWO = "test2";
    
    AwardSponsorTermServiceImpl awardSponsorTermServiceImpl;
    List<KeyValue> keyValueList;
    List<SponsorTerm> sponsorTerms;
    
    @Before
    public void setUp() throws Exception {
        awardSponsorTermServiceImpl = new AwardSponsorTermServiceImpl();
        keyValueList = new ArrayList<KeyValue>();
        keyValueList.add(new ConcreteKeyValue(ONE, TEST_STRING_ONE));
        keyValueList.add(new ConcreteKeyValue(TWO, TEST_STRING_TWO));
    }

    @After
    public void tearDown() throws Exception {
        awardSponsorTermServiceImpl = null;
        keyValueList = null;
    }

    @Test
    public final void testAddEmptyNewSponsorTerms() {
        sponsorTerms = awardSponsorTermServiceImpl.getEmptyNewSponsorTerms(keyValueList);
        Assert.assertEquals(Integer.parseInt(TWO), sponsorTerms.size());
    }
}
