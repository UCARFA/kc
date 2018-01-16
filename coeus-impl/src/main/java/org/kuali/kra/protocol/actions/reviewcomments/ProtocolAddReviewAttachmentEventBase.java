/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.reviewcomments;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.onlinereview.ProtocolReviewAttachmentBase;

/**
 * 
 * This class is validate the new review attachment when 'add' is clicked
 */
public abstract class ProtocolAddReviewAttachmentEventBase<PRA extends ProtocolReviewAttachmentBase> extends KcDocumentEventBaseExtension {
    
    // TODO : technically, this can be refactored to share with ProtocolAddReviewCommentEventBase/rule
    // Since, we are waiting for KRMS, so probably just live with this for now.
    private String propertyName;
    private PRA reviewAttachment;

    /**
     * Constructs a ProtocolAddReviewAttachmentEventBase.
     * 
     * @param document The document to validate
     * @param propertyName The error path property prefix
     * @param reviewAttachment The added Reviewer Attachment
     */
    public ProtocolAddReviewAttachmentEventBase(ProtocolDocumentBase document, String propertyName, PRA reviewAttachment) {
        super("Enter reviewer attachment", "", document);
        this.propertyName = propertyName;
        this.reviewAttachment = reviewAttachment;
    }
    
    public ProtocolDocumentBase getProtocolDocument() {
        return (ProtocolDocumentBase) getDocument();
    }
    
    public String getPropertyName() {
        return propertyName;
    }
    
    public PRA getReviewAttachment() {
        return reviewAttachment;
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return getNewProtocolAddReviewAttachmentRuleInstancehook();
    }

    protected abstract ProtocolAddReviewAttachmentRule<?> getNewProtocolAddReviewAttachmentRuleInstancehook();


}
