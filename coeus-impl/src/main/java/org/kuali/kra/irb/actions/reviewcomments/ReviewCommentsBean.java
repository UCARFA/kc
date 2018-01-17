/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.reviewcomments;

import org.kuali.coeus.common.committee.impl.meeting.CommitteeScheduleMinuteBase;
import org.kuali.kra.meeting.CommitteeScheduleMinute;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsBeanBase;

/**
 * This class defines functions that need to be implemented in a "bean" that needs to provide support for reviewer comments.
 */
public class ReviewCommentsBean extends ReviewCommentsBeanBase {

    private static final long serialVersionUID = 1020677422739490270L;

    public ReviewCommentsBean(String errorPropertyKey) {
        super(errorPropertyKey);
    }

    @Override
    protected CommitteeScheduleMinuteBase getNewCommitteeScheduleMinuteInstanceHook() {
        return new CommitteeScheduleMinute();
    }

    @Override
    protected Class<? extends org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsService> getReviewCommentsServiceClassHook() {
        return ReviewCommentsService.class;
    }
}
