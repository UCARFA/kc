/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol;

/**
 * The ProtocolBase Version Service.
 */
public interface ProtocolVersionService {

    /**
     * Create a new version of a protocol document. 
     * @param protocolDocument the protocol document to version
     * @return the new versioned protocol document
     * @throws Exception
     */
    public ProtocolDocumentBase versionProtocolDocument(ProtocolDocumentBase protocolDocument) throws Exception;
    
    /**
     * Get a particular version of a protocol.
     * @param protocolNumber
     * @param sequenceNumber
     * @return
     */
    public ProtocolBase getProtocolVersion(String protocolNumber, Integer sequenceNumber);
}
