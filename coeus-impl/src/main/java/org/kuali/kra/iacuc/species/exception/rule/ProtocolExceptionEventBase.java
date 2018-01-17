/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.species.exception.rule;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.species.exception.IacucProtocolException;

/**
 * This class is abstract base class for Event Notification
 */
public abstract class ProtocolExceptionEventBase extends KcDocumentEventBase implements ProtocolExceptionEvent {
    
    private IacucProtocolException protocolException;
    
    protected ProtocolExceptionEventBase(String description, String errorPathPrefix, IacucProtocolDocument document, IacucProtocolException protocolException) {
        super(description, errorPathPrefix, document);
        this.protocolException = protocolException;
    }

    @Override
    protected void logEvent() {
    }
    
    @Override
    public IacucProtocolException getProtocolException() {
        return this.protocolException;
    }

}
