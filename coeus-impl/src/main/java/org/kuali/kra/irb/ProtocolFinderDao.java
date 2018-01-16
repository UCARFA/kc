/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb;

/**
 * The ProtocolFinderDao is used to find protocols.
 */
public interface ProtocolFinderDao extends org.kuali.kra.protocol.ProtocolFinderDao {

    /**
     * This method is invoking the super, opened this to reduce the number of cast in
     * individual class files.
     * Find the current protocol given a protocolNumber.  The
     * current protocol is the one with the highest sequence number.
     * @param protocolNumber
     * @return the protocol or null if not found
     */
    @Override
    Protocol findCurrentProtocolByNumber(String protocolNumber);
}
