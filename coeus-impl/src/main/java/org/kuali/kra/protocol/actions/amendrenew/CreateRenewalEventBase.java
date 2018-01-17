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
 * Rule Event for creating renewal without amendment.
 */
@SuppressWarnings("unchecked")
public abstract class CreateRenewalEventBase extends KcDocumentEventBaseExtension {

    private String renewalSummary;
    private String propertyName;

    public CreateRenewalEventBase(ProtocolDocumentBase document, String propertyName, String renewalSummary) {
        super("Create Renewal", "", document);
        this.propertyName = propertyName;
        this.renewalSummary = renewalSummary;
    }
    
    public ProtocolDocumentBase getProtocolDocument() {
        return (ProtocolDocumentBase) getDocument();
    }
    
    public String getPropertyName() {
        return propertyName;
    }
    
    public String getRenewalSummary() {
        return renewalSummary;
    }

    @Override
    public abstract KcBusinessRule getRule();

}

