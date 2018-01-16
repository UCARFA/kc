/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.onlinereview.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.kra.irb.ProtocolOnlineReviewDocument;
import org.kuali.kra.irb.onlinereview.rules.RejectOnlineReviewCommentRule;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class RejectProtocolOnlineReviewCommentEvent extends KcDocumentEventBase {
    
    private static final Log LOG = LogFactory.getLog(RejectProtocolOnlineReviewCommentEvent.class);
    private String reason = null;
    private int maxLength;
       
    public RejectProtocolOnlineReviewCommentEvent(final ProtocolOnlineReviewDocument document,
                                                         final String rejectReason,
                                                         final int reasonMaxLength) {
        super("return protocol online review comment to reviewer", "DocReject", document);
        this.reason = rejectReason;
        this.maxLength = reasonMaxLength;
    }
 
    @Override
    protected void logEvent() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("disapprove protocol online review comment event reason=" + reason);
        }
    }

    @Override
    public Class<RejectOnlineReviewCommentRule> getRuleInterfaceClass() {
        return RejectOnlineReviewCommentRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return this.getRuleInterfaceClass().cast(rule).processRejectOnlineReviewComment(this); 

    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
    
    
}
