/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.reference;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * This class is abstract base class for Event Notification
 */
public abstract class ProtocolReferenceEventBase extends KcDocumentEventBase implements ProtocolReferenceEvent {
    
    private ProtocolReferenceBeanBase protocolReferenceBean;
    
    protected ProtocolReferenceEventBase(String description, String errorPathPrefix, ProtocolDocumentBase document, ProtocolReferenceBeanBase protocolReferenceBean) {
        super(description, errorPathPrefix, document);
        this.protocolReferenceBean = protocolReferenceBean;
    }

    @Override
    protected void logEvent() {
    }
    
    @Override
    public ProtocolReferenceBeanBase getProtocolReferenceBean() {
        return this.protocolReferenceBean;
    }

}
