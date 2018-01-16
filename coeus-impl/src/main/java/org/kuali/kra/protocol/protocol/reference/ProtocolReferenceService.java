/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.reference;

import org.kuali.kra.protocol.ProtocolBase;


public interface ProtocolReferenceService {

    /**
     * This method adds ProtocolReferenceBase to the List of ProtocolReferences along with 
     * appropriate ProtocolReferenceType.
     * @param protocol which contains list of ProtocolReferences.
     * @param protocolReference object is added to ProtocolReferences list after setting ProtocolReferenceType.
     */
    public abstract void addProtocolReference(ProtocolBase protocol, ProtocolReferenceBase protocolReference);
    
}
