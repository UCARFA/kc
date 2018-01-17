/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.kuali.kra.bo.AbstractBoTest;

public class AwardCostShareTest extends AbstractBoTest<AwardCostShare> {
    private static final int AWARD_COST_SHARE_ATTRIBUTES_COUNT = 13;

    @Override
    protected Class<AwardCostShare> getBoClass() {
        return AwardCostShare.class;
    }

    @Override
    protected int getAttributeCount() {
        return AWARD_COST_SHARE_ATTRIBUTES_COUNT;
    }
}
