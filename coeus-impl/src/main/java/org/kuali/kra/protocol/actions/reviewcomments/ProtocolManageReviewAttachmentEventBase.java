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

import java.util.List;

/**
 * 
 * This class is for the rule event of 'manage review attachment'
 */
public abstract class ProtocolManageReviewAttachmentEventBase<PRA extends ProtocolReviewAttachmentBase> extends KcDocumentEventBaseExtension {
    
    private String propertyName;
    private List<PRA> reviewAttachments;

    /**
     * Constructs a ProtocolManageReviewAttachmentEventBase.
     * 
     * @param document The document to validate
     * @param propertyName The error path property prefix
     * @param reviewAttachments The manage Reviewer Attachment
     */
    public ProtocolManageReviewAttachmentEventBase(ProtocolDocumentBase document, String propertyName, List<PRA> reviewAttachments) {
        super("Enter reviewer attachment", "", document);
        this.propertyName = propertyName;
        this.reviewAttachments = reviewAttachments;
    }
    
    public ProtocolDocumentBase getProtocolDocument() {
        return (ProtocolDocumentBase) getDocument();
    }
    
    public String getPropertyName() {
        return propertyName;
    }
    
 
    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return getNewProtocolManageReviewAttachmentRuleInstaceHook();
    }

    protected abstract ProtocolManageReviewAttachmentRule<?> getNewProtocolManageReviewAttachmentRuleInstaceHook();

    
    public List<PRA> getReviewAttachments() {
        return reviewAttachments;
    }


}
