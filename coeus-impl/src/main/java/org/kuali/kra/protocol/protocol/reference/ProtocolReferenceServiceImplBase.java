/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.reference;


import org.kuali.kra.protocol.ProtocolBase;


public abstract class ProtocolReferenceServiceImplBase implements ProtocolReferenceService {
    
    @Override
    public void addProtocolReference(ProtocolBase protocol, ProtocolReferenceBase protocolReference) {
        
        protocolReference.refreshReferenceObject("protocolReferenceType");
        
        //TODO Framework problem of 2 saves, protocolNumber & SequenceNumber are not null fields and they are only available after one saves new protocol.
        protocolReference.setProtocolNumber("0");
        protocolReference.setSequenceNumber(0);
        
        protocol.getProtocolReferences().add(protocolReference);
    }

}
