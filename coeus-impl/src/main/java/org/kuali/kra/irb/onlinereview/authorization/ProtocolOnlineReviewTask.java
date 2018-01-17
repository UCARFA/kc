/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.onlinereview.authorization;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.irb.ProtocolOnlineReviewDocument;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;

/**
 * A Protocol Online Review Task is a task that performs an action against a
 * Protocol Online Review.  To assist authorization, the ProtocolOnlineReview is available.
 */
public final class ProtocolOnlineReviewTask extends Task {
    
    private ProtocolOnlineReview protocolOnlineReview;
    private ProtocolOnlineReviewDocument protocolOnlineReviewDocument;
    
    /**
     * Constructs a ProtocolOnlineReviewTask.
     * @param taskName the name of the task
     * @param protocolOnlineReview the Protocol
     */
    public ProtocolOnlineReviewTask(String taskName, ProtocolOnlineReview protocolOnlineReview) {
        super(TaskGroupName.PROTOCOL_ONLINEREVIEW, taskName);
        this.protocolOnlineReview = protocolOnlineReview;
    }
    
    public ProtocolOnlineReviewTask(String taskName, ProtocolOnlineReviewDocument protocolOnlineReviewDocument) {
        super(TaskGroupName.PROTOCOL_ONLINEREVIEW, taskName);
        this.protocolOnlineReview = (ProtocolOnlineReview) protocolOnlineReviewDocument.getProtocolOnlineReview();
        this.protocolOnlineReviewDocument = protocolOnlineReviewDocument;
    }
    
    public ProtocolOnlineReviewTask(String taskName, ProtocolOnlineReview protocolOnlineReview, String genericTaskName) {
        super(TaskGroupName.PROTOCOL_ONLINEREVIEW, taskName, genericTaskName);
        this.protocolOnlineReview = protocolOnlineReview;
    }

    public ProtocolOnlineReviewTask(String taskName, ProtocolOnlineReviewDocument protocolOnlineReviewDocument, String genericTaskName) {
        super(TaskGroupName.PROTOCOL_ONLINEREVIEW, taskName, genericTaskName);
        this.protocolOnlineReview = (ProtocolOnlineReview) protocolOnlineReviewDocument.getProtocolOnlineReview();
        this.protocolOnlineReviewDocument = protocolOnlineReviewDocument;
    }

    /**
     * Get the ProtocolOnlineReview.
     * @return the ProtocolOnlineReview
     */
    public ProtocolOnlineReview getProtocolOnlineReview() {
        return protocolOnlineReview;
    }

    /**
     * Gets the protocolOnlineReviewDocument attribute. 
     * @return Returns the protocolOnlineReviewDocument.
     */
    public ProtocolOnlineReviewDocument getProtocolOnlineReviewDocument() {
        return protocolOnlineReviewDocument;
    }

}    
