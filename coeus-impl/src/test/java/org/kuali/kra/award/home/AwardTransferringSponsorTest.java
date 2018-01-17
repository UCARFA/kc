/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.kuali.kra.bo.AbstractBoTest;

public class AwardTransferringSponsorTest extends AbstractBoTest<AwardTransferringSponsor> {
    private static final int AWARD_TRANSFERRING_SPONSOR_ATTRIBUTES_COUNT = 4;

    @Override
    protected Class<AwardTransferringSponsor> getBoClass() {
        return AwardTransferringSponsor.class;
    }

    @Override
    protected int getAttributeCount() {
        return AWARD_TRANSFERRING_SPONSOR_ATTRIBUTES_COUNT;
    }
}
