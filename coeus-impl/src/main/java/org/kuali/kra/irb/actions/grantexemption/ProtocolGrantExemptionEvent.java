/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.grantexemption;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.irb.ProtocolDocument;

/**
 * Encapsulates the event that the IRB Administrator grants an exemption on a protocol.
 */
public class ProtocolGrantExemptionEvent extends KcDocumentEventBaseExtension {
        
    private ProtocolGrantExemptionBean protocolGrantExemptionBean;
    
    /**
     * Constructs a ProtocolApproveEvent.
     * @param document the document to validate
     * @param protocolGrantExemptionBean the bean that keeps the comments and dates
     */
    public ProtocolGrantExemptionEvent(ProtocolDocument document, ProtocolGrantExemptionBean protocolGrantExemptionBean) {
        super("Granting exemption on document " + getDocumentId(document), protocolGrantExemptionBean.getErrorPropertyKey(), document);
        
        this.protocolGrantExemptionBean = protocolGrantExemptionBean;
    }
    
    public ProtocolGrantExemptionBean getProtocolGrantExemptionBean() {
        return protocolGrantExemptionBean;
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new ProtocolGrantExemptionRule();
    }
    
}
