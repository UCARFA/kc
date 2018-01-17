/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.onlinereview.event;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolOnlineReviewDocumentBase;
import org.kuali.kra.protocol.onlinereview.ProtocolReviewAttachmentBase;
import org.kuali.kra.protocol.onlinereview.rules.AddOnlineReviewAttachmentRule;

/**
 * 
 * This class implements the add OLR review attachment event for new attachment validation.
 */
public class AddProtocolOnlineReviewAttachmentEvent extends KcDocumentEventBaseExtension {
    
    private String propertyName;
    private ProtocolReviewAttachmentBase reviewAttachment;

    /**
     * Constructs a AddProtocolOnlineReviewAttachmentEvent.
     * 
     * @param document The document to validate
     * @param propertyName The error path property prefix
     * @param reviewComment The added Reviewer Attachment
     */
    public AddProtocolOnlineReviewAttachmentEvent(ProtocolOnlineReviewDocumentBase document, String propertyName, ProtocolReviewAttachmentBase reviewAttachment) {
        super("Enter reviewer attachment", "", document);
        this.propertyName = propertyName;
        this.reviewAttachment = reviewAttachment;
    }
    
    public ProtocolOnlineReviewDocumentBase getProtocolDocument() {
        return (ProtocolOnlineReviewDocumentBase) getDocument();
    }
    
    public String getPropertyName() {
        return propertyName;
    }
    
    public ProtocolReviewAttachmentBase getReviewAttachment() {
        return reviewAttachment;
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new AddOnlineReviewAttachmentRule();
    }
}
