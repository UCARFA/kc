/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions;

import org.kuali.kra.protocol.actions.reviewcomments.ReviewAttachmentsBeanBase;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsBeanBase;

public interface ProtocolOnlineReviewCommentable {
    /**
     * Gets the <code>ReviewCommentsBeanBase</code>.
     * @return the <code>ReviewCommentsBeanBase</code>
     */
    ReviewCommentsBeanBase getReviewCommentsBean();
    
    /**
     * 
     * This method is to get the review attachment bean for OLR
     * @return the <code>ReviewAttachmentsBeanBase</code>
     */
    ReviewAttachmentsBeanBase getReviewAttachmentsBean();

}
