/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.location;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class represents the AddProtocolLocationEvent
 */
public class AddProtocolLocationEvent extends ProtocolLocationEventBase {
    
    public AddProtocolLocationEvent(String errorPathPrefix, ProtocolDocumentBase document, ProtocolLocationBase protocolLocation) {
        super("adding ProtocolLocationBase to document " + getDocumentId(document), errorPathPrefix, document, protocolLocation);
    }

    public AddProtocolLocationEvent(String errorPathPrefix, Document document, ProtocolLocationBase protocolLocation) {
        this(errorPathPrefix, (ProtocolDocumentBase) document, protocolLocation);
    }
    
    @Override
    public Class getRuleInterfaceClass() {
        return AddProtocolLocationRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddProtocolLocationRule) rule).processAddProtocolLocationBusinessRules(this);
    }

}
