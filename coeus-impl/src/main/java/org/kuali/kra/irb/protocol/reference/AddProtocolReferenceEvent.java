/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.reference;

import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.protocol.protocol.reference.AddProtocolReferenceEventBase;
import org.kuali.rice.krad.document.Document;

/**
 * This class hooks Rule to Event in KNS
 */
public class AddProtocolReferenceEvent extends AddProtocolReferenceEventBase {

    
    /**
     * 
     * Constructs a AddProtocolReferenceEvent.java.
     * @param errorPathPrefix
     * @param document
     * @param protocolReferenceBean
     */
    public AddProtocolReferenceEvent(String errorPathPrefix, ProtocolDocument document, ProtocolReferenceBean protocolReferenceBean) {
        super(errorPathPrefix, document, protocolReferenceBean);
    }
    
    /**
     * 
     * Constructs a AddProtocolReferenceEvent.java.
     * @param errorPathPrefix
     * @param document
     * @param protocolReferenceBean
     */
    public AddProtocolReferenceEvent(String errorPathPrefix, Document document, ProtocolReferenceBean protocolReferenceBean) {
        this(errorPathPrefix, (ProtocolDocument)document, protocolReferenceBean);
    } 
}
