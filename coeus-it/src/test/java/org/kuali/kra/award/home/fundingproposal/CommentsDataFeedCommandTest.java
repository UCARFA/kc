/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.award.home.AwardComment;
import org.kuali.kra.award.home.AwardCommentFactory;
import org.kuali.kra.bo.CommentType;

public class CommentsDataFeedCommandTest extends BaseDataFeedCommandTest {
    private static final String TEST_COMMENT = "Test Comment";
    private ProposalDataFeedCommandBase command;
    MockAwardCommentFactory awardCommentFactory;
    
    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        command = new CommentsDataFeedCommand(award, proposal, FundingProposalMergeType.REPLACE);
        awardCommentFactory = new MockAwardCommentFactory();
    }
    
    @After
    @Override
    public void tearDown() throws Exception {
        command = null;
        super.tearDown();
    }
    
    @Test
    public void testAddingComment() {
        proposal.getDeliveryComment().setComments(TEST_COMMENT);
        command.performDataFeed();
        AwardComment comment = award.findCommentOfSpecifiedType(awardCommentFactory.createProposalComment());
        Assert.assertNotNull(comment);
        Assert.assertEquals(TEST_COMMENT, comment.getComments());
    }

    class MockAwardCommentFactory extends AwardCommentFactory {
        @Override
        public CommentType findCommentType(String commentTypeCode) {
            CommentType commentType = new CommentType();
            commentType.setCommentTypeCode(commentTypeCode);
            commentType.setDescription("mock description");
            return commentType;
        }
    };
}
