/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.timeandmoney;

import org.kuali.kra.bo.AbstractBoTest;

public class AwardDirectFandADistributionTest extends AbstractBoTest<AwardDirectFandADistribution> {
    private static final int AWARD_DIRECT_F_AND_A_DISTRIBUTION_ATTRIBUTES_COUNT = 9;

    @Override
    protected Class<AwardDirectFandADistribution> getBoClass() {
        return AwardDirectFandADistribution.class;
    }

    @Override
    protected int getAttributeCount() {
        return AWARD_DIRECT_F_AND_A_DISTRIBUTION_ATTRIBUTES_COUNT;
    }
}
