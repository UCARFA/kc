/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kuali.kra.subaward.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.kra.subaward.bo.SubAwardAmountInfo;
import org.kuali.kra.subaward.service.SubAwardService;

import java.util.ArrayList;

public class SubAwardServiceImplTest {

    @Test
    public void testCalculationNoCostSplit() {
        SubAwardService service = new SubAwardServiceImpl() {

            @Override
            protected boolean isCostSplitEnabled() {
                return false;
            }
        };

        SubAward subaward = new SubAward();
        subaward.setSubAwardAmountReleasedList(new ArrayList<>());
        SubAwardAmountInfo subAwardAmountInfo1 = new SubAwardAmountInfo();
        subAwardAmountInfo1.setObligatedChange(ScaleTwoDecimal.ONE_HUNDRED);
        subAwardAmountInfo1.setAnticipatedChange(ScaleTwoDecimal.ONE_HUNDRED);

        SubAwardAmountInfo subAwardAmountInfo2 = new SubAwardAmountInfo();
        subAwardAmountInfo2.setObligatedChange(new ScaleTwoDecimal(100.1));
        subAwardAmountInfo2.setAnticipatedChange(new ScaleTwoDecimal(200.5));

        subaward.getAllSubAwardAmountInfos().add(subAwardAmountInfo1);
        subaward.getAllSubAwardAmountInfos().add(subAwardAmountInfo2);
        service.calculateAmountInfo(subaward);

        Assert.assertTrue(subaward.getTotalObligatedAmount().compareTo(new ScaleTwoDecimal(200.1)) == 0);
        Assert.assertTrue(subaward.getTotalAnticipatedAmount().compareTo(new ScaleTwoDecimal(300.5)) == 0);

        SubAwardAmountInfo subAwardAmountInfo3 = new SubAwardAmountInfo();
        subAwardAmountInfo3.setObligatedChange(new ScaleTwoDecimal(-100));
        subAwardAmountInfo3.setAnticipatedChange(new ScaleTwoDecimal(-100));

        subaward.getAllSubAwardAmountInfos().add(subAwardAmountInfo3);
        service.calculateAmountInfo(subaward);

        Assert.assertTrue(subaward.getTotalObligatedAmount().compareTo(new ScaleTwoDecimal(100.1)) == 0);
        Assert.assertTrue(subaward.getTotalAnticipatedAmount().compareTo(new ScaleTwoDecimal(200.5)) == 0);

    }

    @Test
    public void testCalculationWithCostSplit() {
        SubAwardService service = new SubAwardServiceImpl() {

            @Override
            protected boolean isCostSplitEnabled() {
                return true;
            }
        };

        SubAward subaward = new SubAward();
        subaward.setSubAwardAmountReleasedList(new ArrayList<>());
        SubAwardAmountInfo subAwardAmountInfo1 = new SubAwardAmountInfo();
        subAwardAmountInfo1.setObligatedChangeDirect(ScaleTwoDecimal.ONE_HUNDRED);
        subAwardAmountInfo1.setObligatedChangeIndirect(ScaleTwoDecimal.ONE_HUNDRED);

        subAwardAmountInfo1.setAnticipatedChangeDirect(ScaleTwoDecimal.ONE_HUNDRED);
        subAwardAmountInfo1.setAnticipatedChangeIndirect(ScaleTwoDecimal.ONE_HUNDRED);

        SubAwardAmountInfo subAwardAmountInfo2 = new SubAwardAmountInfo();
        subAwardAmountInfo2.setObligatedChangeDirect(new ScaleTwoDecimal(100.1));
        subAwardAmountInfo2.setObligatedChangeIndirect(new ScaleTwoDecimal(100.1));

        subAwardAmountInfo2.setAnticipatedChangeDirect(new ScaleTwoDecimal(200.5));
        subAwardAmountInfo2.setAnticipatedChangeIndirect(new ScaleTwoDecimal(200.5));

        subaward.getAllSubAwardAmountInfos().add(subAwardAmountInfo1);
        subaward.getAllSubAwardAmountInfos().add(subAwardAmountInfo2);
        service.calculateAmountInfo(subaward);

        Assert.assertTrue(subaward.getTotalObligatedAmount().compareTo(new ScaleTwoDecimal(400.2)) == 0);
        Assert.assertTrue(subaward.getTotalObligatedDirectAmount().compareTo(new ScaleTwoDecimal(200.1)) == 0);
        Assert.assertTrue(subaward.getTotalObligatedIndirectAmount().compareTo(new ScaleTwoDecimal(200.1)) == 0);

        Assert.assertTrue(subaward.getTotalAnticipatedAmount().compareTo(new ScaleTwoDecimal(601)) == 0);
        Assert.assertTrue(subaward.getTotalAnticipatedDirectAmount().compareTo(new ScaleTwoDecimal(300.5)) == 0);
        Assert.assertTrue(subaward.getTotalAnticipatedIndirectAmount().compareTo(new ScaleTwoDecimal(300.5)) == 0);

        SubAwardAmountInfo subAwardAmountInfo3 = new SubAwardAmountInfo();
        subAwardAmountInfo3.setObligatedChangeDirect(new ScaleTwoDecimal(-100));
        subAwardAmountInfo3.setObligatedChangeIndirect(new ScaleTwoDecimal(-100));
        subAwardAmountInfo3.setAnticipatedChangeDirect(new ScaleTwoDecimal(-100));
        subAwardAmountInfo3.setAnticipatedChangeIndirect(new ScaleTwoDecimal(-100));

        subaward.getAllSubAwardAmountInfos().add(subAwardAmountInfo3);
        service.calculateAmountInfo(subaward);

        Assert.assertTrue(subaward.getTotalObligatedAmount().compareTo(new ScaleTwoDecimal(200.2)) == 0);
        Assert.assertTrue(subaward.getTotalObligatedDirectAmount().compareTo(new ScaleTwoDecimal(100.1)) == 0);
        Assert.assertTrue(subaward.getTotalObligatedIndirectAmount().compareTo(new ScaleTwoDecimal(100.1)) == 0);

        Assert.assertTrue(subaward.getTotalAnticipatedAmount().compareTo(new ScaleTwoDecimal(401)) == 0);
        Assert.assertTrue(subaward.getTotalAnticipatedDirectAmount().compareTo(new ScaleTwoDecimal(200.5)) == 0);
        Assert.assertTrue(subaward.getTotalAnticipatedIndirectAmount().compareTo(new ScaleTwoDecimal(200.5)) == 0);

        Assert.assertTrue(subaward.getTotalAvailableAmount().compareTo(new ScaleTwoDecimal(200.2)) == 0);

    }
}
