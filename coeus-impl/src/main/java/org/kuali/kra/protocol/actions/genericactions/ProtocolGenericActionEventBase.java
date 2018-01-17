/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.genericactions;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * Encapsulates the event that the user performs a generic action.
 */
public abstract class ProtocolGenericActionEventBase extends KcDocumentEventBaseExtension {
    
    private ProtocolGenericActionBean protocolGenericActionBean;

    /**
     * Constructs a ProtocolGenericActionEventBase.
     * @param document the document to validate
     * @param protocolGenericActionBean the bean that keeps the comments and dates
     */
    public ProtocolGenericActionEventBase(ProtocolDocumentBase document, ProtocolGenericActionBean protocolGenericActionBean) {
        super("Performing generic action on document " + getDocumentId(document), protocolGenericActionBean.getErrorPropertyKey(), document);
        
        this.protocolGenericActionBean = protocolGenericActionBean;
    }
    
    public ProtocolGenericActionBean getProtocolGenericActionBean() {
        return protocolGenericActionBean;
    }

}
