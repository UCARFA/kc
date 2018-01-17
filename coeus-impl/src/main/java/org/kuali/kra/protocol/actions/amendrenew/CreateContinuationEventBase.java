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

public abstract class CreateContinuationEventBase extends KcDocumentEventBaseExtension {

    private String continuationSummary;
    private String propertyName;

    public CreateContinuationEventBase(ProtocolDocumentBase document, String propertyName, String continuationSummary) {
        super("Create Continuation", "", document);
        this.propertyName = propertyName;
        this.continuationSummary = continuationSummary;
    }
    
    public ProtocolDocumentBase getProtocolDocument() {
        return (ProtocolDocumentBase) getDocument();
    }
    
    public String getPropertyName() {
        return propertyName;
    }
    
    public String getContinuationSummary() {
        return continuationSummary;
    }

    @Override
    public abstract KcBusinessRule getRule();

}
