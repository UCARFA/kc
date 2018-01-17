/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.rice.krad.util.ObjectUtils;

/**
 * Represents the event to add a ProtocolPersonnel.
 */
public abstract class AddProtocolPersonnelEventBase extends KcDocumentEventBaseExtension {
    
    protected ProtocolPersonBase protocolPerson;
    
    /**
     * Constructs a AddProtocolPersonnelEventBase.
     * @param errorPathPrefix The error path prefix
     * @param document The document to validate
     * @param protocolPerson the person to add
     */
    protected AddProtocolPersonnelEventBase(String errorPathPrefix, ProtocolDocumentBase document, ProtocolPersonBase protocolPerson) {
        super("Adding ProtocolPersonBase to document " + getDocumentId(document), errorPathPrefix, document);
    
        this.protocolPerson = (ProtocolPersonBase) ObjectUtils.deepCopy(protocolPerson);
    }
    
    public ProtocolPersonBase getProtocolPerson() {
        return protocolPerson;
    }

}
