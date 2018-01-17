/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.kuali.kra.bo.AbstractBoTest;

public class AwardFandaRateTest extends AbstractBoTest<AwardFandaRate> {
    private static final int AWARD_FANDA_RATE_COUNT = 11;

    @Override
    protected Class<AwardFandaRate> getBoClass() {
        return AwardFandaRate.class;
    }

    @Override
    protected int getAttributeCount() {
        return AWARD_FANDA_RATE_COUNT;
    }
}
