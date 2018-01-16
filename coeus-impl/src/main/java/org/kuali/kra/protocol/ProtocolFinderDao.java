/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol;

import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

import java.util.List;


/**
 * The ProtocolFinderDao is used to find protocols.
 */
public interface ProtocolFinderDao {

    /**
     * Find the current protocol given a protocolNumber.  The
     * current protocol is the one with the highest sequence number.
     * @param protocolNumber
     * @return the protocol or null if not found
     */
    ProtocolBase findCurrentProtocolByNumber(String protocolNumber);
    
    /**
     * 
     * This method all protocol submission belong to this protocolNumber.  also include amendment and renewal of this protocol.
     * @param protocolNumber
     * @param submissionNumber
     * @return
     */
    List<ProtocolSubmissionBase> findProtocolSubmissions(String protocolNumber, int submissionNumber);

    /**
     * 
     * This method is to find all the versioned protocols, amendments, renewals with this protocolNumber.
     * @param protocolNumber
     * @return
     */
    List<ProtocolBase> findProtocols(String protocolNumber);
}
