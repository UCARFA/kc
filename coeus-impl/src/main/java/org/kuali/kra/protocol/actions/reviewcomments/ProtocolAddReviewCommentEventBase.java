/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.reviewcomments;


import org.kuali.coeus.common.committee.impl.meeting.CommitteeScheduleMinuteBase;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * Encapsulates a validation event for a Reviewer Comment add action.
 */
public abstract class ProtocolAddReviewCommentEventBase extends KcDocumentEventBaseExtension {
    
    private String propertyName;
    private CommitteeScheduleMinuteBase reviewComment;

    /**
     * Constructs a ProtocolAddReviewerCommentEvent.
     * 
     * @param document The document to validate
     * @param propertyName The error path property prefix
     * @param reviewComment The added Reviewer Comment
     */
    public ProtocolAddReviewCommentEventBase(ProtocolDocumentBase document, String propertyName, CommitteeScheduleMinuteBase reviewComment) {
        super("Enter reviewer comment", "", document);
        this.propertyName = propertyName;
        this.reviewComment = reviewComment;
    }
    
    public ProtocolDocumentBase getProtocolDocument() {
        return (ProtocolDocumentBase) getDocument();
    }
    
    public String getPropertyName() {
        return propertyName;
    }
    
    public CommitteeScheduleMinuteBase getReviewComment() {
        return reviewComment;
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return getNewProtocolAddReviewCommentRuleInstanceHook();
    }

    protected abstract ProtocolAddReviewCommentRuleBase<?> getNewProtocolAddReviewCommentRuleInstanceHook();

}
