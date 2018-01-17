/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.reviewcomments;

import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.onlinereview.ProtocolReviewAttachment;
import org.kuali.kra.protocol.actions.reviewcomments.ProtocolManageReviewAttachmentEventBase;

import java.util.List;

/**
 * 
 * This class is for the rule event of 'manage review attachment'
 */
@SuppressWarnings("unchecked")
public class ProtocolManageReviewAttachmentEvent extends ProtocolManageReviewAttachmentEventBase<ProtocolReviewAttachment> {

    public ProtocolManageReviewAttachmentEvent(ProtocolDocument document, String propertyName, List<ProtocolReviewAttachment> reviewAttachments) {
        super(document, propertyName, reviewAttachments);
    }

    @Override
    protected ProtocolManageReviewAttachmentRule getNewProtocolManageReviewAttachmentRuleInstaceHook() {
        return new ProtocolManageReviewAttachmentRule(); 
    }
}
