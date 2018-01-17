/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.specialapproval.approvedequipment;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.kra.award.home.Award;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.util.ArrayList;
import java.util.List;

/**
 * This class tests the AwardApprovedEquipment BO
 */
public class AwardApprovedEquipmentTest {

    private static final double DELTA = 0.001;
    
    @Test
    public void testGettingTotal() {
        final double AMOUNT1 = 100.00;
        final double AMOUNT2 = 200.00;
        final double AMOUNT3 = 300.00;
        Award award = new Award();
        List<AwardApprovedEquipment> items = new ArrayList<AwardApprovedEquipment>();
        items.add(createApprovedEquipmentItem(AMOUNT1));
        items.add(createApprovedEquipmentItem(AMOUNT2));
        items.add(createApprovedEquipmentItem(AMOUNT3));
        award.setApprovedEquipmentItems(items);
        Assert.assertEquals(AMOUNT1 + AMOUNT2 + AMOUNT3, award.getTotalApprovedEquipmentAmount().doubleValue(), DELTA);
    }
    
    private AwardApprovedEquipment createApprovedEquipmentItem(double amount) {
        AwardApprovedEquipment item = new AwardApprovedEquipment();
        item.setAmount(new ScaleTwoDecimal(amount));
        return item;
    }
    
}
