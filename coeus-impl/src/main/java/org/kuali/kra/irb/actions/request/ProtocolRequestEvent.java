/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.request;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.irb.ProtocolDocument;

/**
 * This event is generated whenever a user makes a request to 
 * close the protocol, suspend it, close enrollment, re-open enrollment,
 * or request data analysis.
 */
@SuppressWarnings("unchecked")
public class ProtocolRequestEvent<T extends KcBusinessRule> extends KcDocumentEventBaseExtension {

    private ProtocolRequestBean requestBean;
    private String propertyKey;

    public ProtocolRequestEvent(ProtocolDocument document, String propertyKey, ProtocolRequestBean requestBean) {
        super("Protocol Request", "", document);
        this.propertyKey = propertyKey;
        this.requestBean = requestBean;
    }
    
    public ProtocolDocument getProtocolDocument() {
        return (ProtocolDocument) getDocument();
    }
    
    public String getPropertyKey() {
        return propertyKey;
    }
    
    public ProtocolRequestBean getRequestBean() {
        return requestBean;
    }

    @Override
    public KcBusinessRule getRule() {
        return new ProtocolRequestRule();
    }
}
