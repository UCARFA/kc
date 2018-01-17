/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.reviewcomments;

import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.meeting.CommitteeScheduleMinute;
import org.kuali.kra.protocol.actions.reviewcomments.ProtocolAddReviewCommentEventBase;
import org.kuali.kra.protocol.actions.reviewcomments.ProtocolAddReviewCommentRuleBase;

/**
 * Encapsulates a validation event for a Reviewer Comment add action.
 */

@SuppressWarnings("unchecked")
public class ProtocolAddReviewCommentEvent extends ProtocolAddReviewCommentEventBase {

    public ProtocolAddReviewCommentEvent(ProtocolDocument document, String propertyName, CommitteeScheduleMinute reviewComment) {
        super(document, propertyName, reviewComment);
    }

    @Override
    protected ProtocolAddReviewCommentRuleBase<?> getNewProtocolAddReviewCommentRuleInstanceHook() {
        return new ProtocolAddReviewCommentRule();
    }
}
