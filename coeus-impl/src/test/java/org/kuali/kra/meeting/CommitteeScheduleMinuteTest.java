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
import org.kuali.coeus.common.committee.impl.meeting.MinuteEntryType;
import org.kuali.coeus.common.committee.impl.meeting.ScheduleActItemType;


/**
 * TODO This class currently tests only the static comparator, could be extended to test other methods.
 */
public class CommitteeScheduleMinuteTest {

    @Test
    public void testEntryTypeComparator() {        
        
        CommitteeScheduleMinute csm1 = new CommitteeScheduleMinute();
        CommitteeScheduleMinute csm2 = new CommitteeScheduleMinute();
        csm1.setMinuteEntryType(new MinuteEntryType());
        csm2.setMinuteEntryType(new MinuteEntryType());

        //test case 1
        csm1.getMinuteEntryType().setSortId(4);
        csm2.getMinuteEntryType().setSortId(5);        
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) < 0);
        
        csm1.getMinuteEntryType().setSortId(4);
        csm2.getMinuteEntryType().setSortId(4);        
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) == 0);
        
        csm1.getMinuteEntryType().setSortId(5);
        csm2.getMinuteEntryType().setSortId(4);        
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) > 0);
        
        // test case 2
        csm1.getMinuteEntryType().setSortId(4);
        csm2.getMinuteEntryType().setSortId(5);
        
        csm1.setProtocolIdFk(0L);
        csm2.setProtocolIdFk(0L);        
       
        csm1.setProtocolNumber("bbb");
        csm2.setProtocolNumber("aaa");
        // check that entry type gets precedence in sorting
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) > 0); 
        
        // test case 3
        csm1.getMinuteEntryType().setSortId(4);
        csm2.getMinuteEntryType().setSortId(4);
               
        csm1.setProtocolNumber("aaa");
        csm2.setProtocolNumber("bbb");
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) < 0);
        
        csm1.setProtocolNumber("aaa");
        csm2.setProtocolNumber("aaa");
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) == 0);
        
        csm1.setProtocolNumber("bbb");
        csm2.setProtocolNumber("aaa");
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) > 0);
        
        
        // test case 4
               
        csm1.setProtocolNumber("aaa");
        csm2.setProtocolNumber("bbb");
        
        csm1.setCommScheduleActItemsIdFk(0L);
        csm2.setCommScheduleActItemsIdFk(0L);       
        
        csm1.setCommScheduleActItem(new CommScheduleActItem());
        csm2.setCommScheduleActItem(new CommScheduleActItem());
        csm1.getCommScheduleActItem().setScheduleActItemType(new ScheduleActItemType());
        csm2.getCommScheduleActItem().setScheduleActItemType(new ScheduleActItemType());
        csm1.getCommScheduleActItem().getScheduleActItemType().setScheduleActItemTypeCode("bbb");
        csm2.getCommScheduleActItem().getScheduleActItemType().setScheduleActItemTypeCode("aaa");
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) < 0);
        
        
        // test case 5
        csm1.setProtocolIdFk(null);
        csm1.setProtocolNumber(null);
        csm2.setProtocolIdFk(null);
        csm2.setProtocolNumber(null);
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) == 0);
        
        csm1.getCommScheduleActItem().getScheduleActItemType().setScheduleActItemTypeCode("aaa");
        csm2.getCommScheduleActItem().getScheduleActItemType().setScheduleActItemTypeCode("aaa");
        Assert.assertTrue(CommitteeScheduleMinute.entryTypeComparator.compare(csm1, csm2) == 0);
    }
}
