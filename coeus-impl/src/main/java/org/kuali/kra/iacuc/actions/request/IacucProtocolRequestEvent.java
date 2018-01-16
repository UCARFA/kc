/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.request;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.iacuc.IacucProtocolDocument;

/**
 * This event is generated whenever a user makes a request to 
 * close the protocol, suspend it, close enrollment, re-open enrollment,
 * or request data analysis.
 */
@SuppressWarnings("unchecked")
public class IacucProtocolRequestEvent<T extends KcBusinessRule> extends KcDocumentEventBaseExtension {

    private IacucProtocolRequestBean requestBean;
    private String propertyKey;

    public IacucProtocolRequestEvent(IacucProtocolDocument document, String propertyKey, IacucProtocolRequestBean requestBean) {
        super("Iacuc Protocol Request", "", document);
        this.propertyKey = propertyKey;
        this.requestBean = requestBean;
    }
    
    public IacucProtocolDocument getProtocolDocument() {
        return (IacucProtocolDocument) getDocument();
    }
    
    public String getPropertyKey() {
        return propertyKey;
    }
    
    public IacucProtocolRequestBean getRequestBean() {
        return requestBean;
    }

    @Override
    public KcBusinessRule getRule() {
        return new IacucProtocolRequestRule();
    }
}
