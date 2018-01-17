/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.reference;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class hooks Rule to Event in KNS
 */
public abstract class AddProtocolReferenceEventBase extends ProtocolReferenceEventBase {

    /**
     * 
     * Constructs a AddProtocolReferenceEventBase.java.
     * @param errorPathPrefix
     * @param document
     * @param protocolReferenceBean
     */
    public AddProtocolReferenceEventBase(String errorPathPrefix, ProtocolDocumentBase document, ProtocolReferenceBeanBase protocolReferenceBean) {
        super("adding ProtocolReferenceBase to document " + getDocumentId(document), errorPathPrefix, document, protocolReferenceBean);
    }
    
    /**
     * 
     * Constructs a AddProtocolReferenceEventBase.java.
     * @param errorPathPrefix
     * @param document
     * @param protocolReferenceBean
     */
    public AddProtocolReferenceEventBase(String errorPathPrefix, Document document, ProtocolReferenceBeanBase protocolReferenceBean) {
        this(errorPathPrefix, (ProtocolDocumentBase)document, protocolReferenceBean);
    } 
    
    @Override
    public Class getRuleInterfaceClass() {
        return AddProtocolReferenceRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddProtocolReferenceRule)rule).processAddProtocolReferenceBusinessRules(this);
    }

}
