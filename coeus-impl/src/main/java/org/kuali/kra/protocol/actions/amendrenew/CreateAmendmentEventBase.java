/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.amendrenew;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * When an amendment is created, this event is generated.
 */
@SuppressWarnings("unchecked")
public abstract class CreateAmendmentEventBase extends KcDocumentEventBaseExtension {

    private ProtocolAmendmentBean amendmentBean;
    private String propertyName;

    public CreateAmendmentEventBase(ProtocolDocumentBase document, String propertyName, ProtocolAmendmentBean amendmentBean) {
        super("Create Amendment", "", document);
        this.propertyName = propertyName;
        this.amendmentBean = amendmentBean;
    }
    
    public ProtocolDocumentBase getProtocolDocument() {
        return (ProtocolDocumentBase) getDocument();
    }
    
    public String getPropertyName() {
        return propertyName;
    }
    
    public ProtocolAmendmentBean getAmendmentBean() {
        return amendmentBean;
    }

    @Override
    public abstract KcBusinessRule getRule();
    
}
