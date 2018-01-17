/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.home;

import org.kuali.kra.bo.AbstractBoTest;

public class InstitutionalProposalCostShareTest extends AbstractBoTest<InstitutionalProposalCostShare> {
    private static final int IP_COST_SHARE_ATTRIBUTES_COUNT = 10;

    @Override
    protected Class<InstitutionalProposalCostShare> getBoClass() {
        return InstitutionalProposalCostShare.class;
    }

    @Override
    protected int getAttributeCount() {
        return IP_COST_SHARE_ATTRIBUTES_COUNT;
    }
}
