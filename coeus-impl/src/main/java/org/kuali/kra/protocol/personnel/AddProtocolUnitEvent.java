/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class represents the AddProtocolPersonnelEventBase
 */
public class AddProtocolUnitEvent extends ProtocolUnitEventBase {
    
    public AddProtocolUnitEvent(String errorPathPrefix, ProtocolDocumentBase document, 
            ProtocolUnitBase protocolUnit, int personIndex) {
        super("adding ProtocolUnitBase to document " + getDocumentId(document), errorPathPrefix, document, 
                protocolUnit, personIndex);
    }

    public AddProtocolUnitEvent(String errorPathPrefix, Document document, 
            ProtocolUnitBase protocolUnit, int personIndex) {
        this(errorPathPrefix, (ProtocolDocumentBase) document, protocolUnit, personIndex);
    }
    
    @Override
    public Class getRuleInterfaceClass() {
        return AddProtocolUnitRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddProtocolUnitRule) rule).processAddProtocolUnitBusinessRules(this);
    }

}
