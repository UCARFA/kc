/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.personnel;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.protocol.personnel.AddProtocolPersonnelEventBase;

/**
 * Represents the event to add a ProtocolPersonnel.
 */
public class AddProtocolPersonnelEvent extends AddProtocolPersonnelEventBase {
    
    /**
     * Constructs a AddProtocolPersonnelEvent.
     * 
     * @param errorPathPrefix The error path prefix
     * @param document The document to validate
     * @param protocolPerson the person to add
     */
    public AddProtocolPersonnelEvent(String errorPathPrefix, ProtocolDocument document, ProtocolPerson protocolPerson) {
        super(errorPathPrefix, document, protocolPerson);
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new AddProtocolPersonnelRule();
    }

}
