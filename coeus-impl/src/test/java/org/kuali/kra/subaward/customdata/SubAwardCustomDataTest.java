/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.customdata;

import org.kuali.kra.bo.AbstractBoTest;

public class SubAwardCustomDataTest extends AbstractBoTest<SubAwardCustomData> {
    private static final int SUBAWARD_PROPOSAL_CUSTOM_DATA_ATTRIBUTES_COUNT = 6;

    @Override
    protected Class<SubAwardCustomData> getBoClass() {
        return SubAwardCustomData.class;
    }

    @Override
    protected int getAttributeCount() {
        return SUBAWARD_PROPOSAL_CUSTOM_DATA_ATTRIBUTES_COUNT;
    }
}
