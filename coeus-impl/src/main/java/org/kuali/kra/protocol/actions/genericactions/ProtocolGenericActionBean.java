/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.genericactions;

import org.kuali.kra.protocol.actions.ProtocolActionBean;
import org.kuali.kra.protocol.actions.ProtocolOnlineReviewCommentable;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewAttachmentsBeanBase;

import java.io.Serializable;
import java.sql.Date;

/**
 * This interface is really just a "form" for generic actions.
 */
public interface ProtocolGenericActionBean extends ProtocolActionBean, ProtocolOnlineReviewCommentable, Serializable {

    public String getComments();
    
    public void setComments(String comments);
    
    public Date getActionDate();
    
    public void setActionDate(Date actionDate);
    
    public String getErrorPropertyKey();

    public void setReviewAttachmentsBean(ReviewAttachmentsBeanBase reviewAttachmentsBean);
    
}
