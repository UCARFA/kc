/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.approve;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * Encapsulates the event that the protocol Administrator approves a protocol.
 */
public abstract class ProtocolApproveEventBase extends KcDocumentEventBaseExtension {
        
    private ProtocolApproveBean protocolApproveBean;
    
    /**
     * Constructs a ProtocolApproveEventBase.
     * @param document the document to validate
     * @param protocolApproveBean the bean that keeps the comments and dates
     */
    public ProtocolApproveEventBase(ProtocolDocumentBase document, ProtocolApproveBean protocolApproveBean) {
        super("Approving document " + getDocumentId(document), protocolApproveBean.getErrorPropertyKey(), document);
        
        this.protocolApproveBean = protocolApproveBean;
    }
    
    public ProtocolApproveBean getProtocolApproveBean() {
        return protocolApproveBean;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ProtocolApproveRuleBase getRule() {
        return getNewProtocolApproveRuleInstanceHook();
    }

    protected abstract ProtocolApproveRuleBase getNewProtocolApproveRuleInstanceHook();
    
}
