/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;

public class CostShareTypeTest extends AbstractBoTest<CostShareType> {
    private static final int COST_SHARE_TYPE_ATTRIBUTES_COUNT = 4;

    @Override
    protected Class<CostShareType> getBoClass() {
        return CostShareType.class;
    }

    @Override
    protected int getAttributeCount() {
        return COST_SHARE_TYPE_ATTRIBUTES_COUNT;
    }
}

