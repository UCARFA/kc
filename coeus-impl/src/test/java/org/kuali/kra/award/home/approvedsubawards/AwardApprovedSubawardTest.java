/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.approvedsubawards;

import org.kuali.kra.bo.AbstractBoTest;

public class AwardApprovedSubawardTest extends AbstractBoTest<AwardApprovedSubaward> {
    private static final int AWARD_APPROVED_SUBAWARD_ATTRIBUTES_COUNT = 6;

    @Override
    protected Class<AwardApprovedSubaward> getBoClass() {
        return AwardApprovedSubaward.class;
    }

    @Override
    protected int getAttributeCount() {
        return AWARD_APPROVED_SUBAWARD_ATTRIBUTES_COUNT;
    }
}
