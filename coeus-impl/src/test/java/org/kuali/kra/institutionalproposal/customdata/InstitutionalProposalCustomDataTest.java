/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.customdata;

import org.kuali.kra.bo.AbstractBoTest;

public class InstitutionalProposalCustomDataTest extends AbstractBoTest<InstitutionalProposalCustomData> {
    private static final int INSTITUTIONAL_PROPOSAL_CUSTOM_DATA_ATTRIBUTES_COUNT = 5;

    @Override
    protected Class<InstitutionalProposalCustomData> getBoClass() {
        return InstitutionalProposalCustomData.class;
    }

    @Override
    protected int getAttributeCount() {
        return INSTITUTIONAL_PROPOSAL_CUSTOM_DATA_ATTRIBUTES_COUNT;
    }
}
