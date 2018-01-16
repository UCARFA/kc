/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal;

import org.kuali.kra.bo.AbstractBoTest;

public class ProposalCommentTest extends AbstractBoTest<ProposalComment> {
    private static final int PROPOSAL_COMMENT_ATTRIBUTES_COUNT = 7;

    @Override
    protected Class<ProposalComment> getBoClass() {
        return ProposalComment.class;
    }

    @Override
    protected int getAttributeCount() {
        return PROPOSAL_COMMENT_ATTRIBUTES_COUNT;
    }
}
