/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.expeditedapprove;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.actions.approve.ProtocolApproveEvent;

/**
 * Encapsulates the event that the IRB Administrator approves a protocol.
 */
public class ProtocolExpeditedApproveEvent extends ProtocolApproveEvent {
        
    /**
     * Constructs a ProtocolExpeditedApproveEvent.
     * @param document the document to validate
     * @param protocolApproveBean the bean that keeps the comments and dates
     */
    public ProtocolExpeditedApproveEvent(ProtocolDocument document, ProtocolExpeditedApproveBean protocolApproveBean) {
        super(document, protocolApproveBean);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new ProtocolExpeditedApproveRule();
    }
    
}
