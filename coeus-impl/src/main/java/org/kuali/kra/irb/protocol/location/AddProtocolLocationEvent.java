/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.location;

import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.rice.krad.document.Document;

/**
 * This class represents the AddProtocolLocationEvent
 */
public class AddProtocolLocationEvent extends org.kuali.kra.protocol.protocol.location.AddProtocolLocationEvent {

    public AddProtocolLocationEvent(String errorPathPrefix, ProtocolDocument document, ProtocolLocation protocolLocation) {
        super(errorPathPrefix, document, protocolLocation);
    }
    
    public AddProtocolLocationEvent(String errorPathPrefix, Document document, ProtocolLocation protocolLocation) {
        this(errorPathPrefix, (ProtocolDocument) document, protocolLocation);
    }

}
