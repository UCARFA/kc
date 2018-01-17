/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.reviewcomments;

import org.kuali.coeus.common.committee.impl.meeting.CommitteeScheduleMinuteBase;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.protocol.actions.reviewcomments.ProtocolAddReviewCommentEventBase;

public class IacucProtocolAddReviewCommentEvent extends ProtocolAddReviewCommentEventBase {

    public IacucProtocolAddReviewCommentEvent(IacucProtocolDocument document, String propertyName, CommitteeScheduleMinuteBase reviewComment) {
        super(document, propertyName, reviewComment);
    }

    @Override
    protected  IacucProtocolAddReviewCommentRule getNewProtocolAddReviewCommentRuleInstanceHook() {
        return new IacucProtocolAddReviewCommentRule();
    }

}
