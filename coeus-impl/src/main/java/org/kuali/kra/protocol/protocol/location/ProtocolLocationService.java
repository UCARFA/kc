/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.location;

import org.kuali.kra.protocol.ProtocolBase;


public interface ProtocolLocationService {

    /**
     * This method adds ProtocolLocationBase to the List of ProtocolLocations.
     * @param protocol which contains list of ProtocolLocations.
     * @param ProtocolLocationBase object is added to ProtocolLocations list.
     */
    public abstract void addProtocolLocation(ProtocolBase protocol, ProtocolLocationBase protocolLocation);
    
    /**
     * This method adds a default ProtocolLocationBase to the List of ProtocolLocations.
     * i.e. Initialize protocol location with a default organization
     * @param protocol which contains list of ProtocolLocations.
     */
    public abstract void addDefaultProtocolLocation(ProtocolBase protocol);

    /**
     * This method will clear ProtocolLocationBase address from the List at specified position(lineNumber)
     * @param protocol which contains list of ProtocolLocations
     * @param lineNumber to clear location address
     */
    public abstract void clearProtocolLocationAddress(ProtocolBase protocol, int lineNumber);

}
