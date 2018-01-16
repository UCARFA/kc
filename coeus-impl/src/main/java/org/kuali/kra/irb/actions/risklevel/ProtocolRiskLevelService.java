/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.risklevel;

import org.kuali.kra.irb.Protocol;

/**
 * Provides services to add, update, and delete <code>ProtocolRiskLevel</code>s.
 */
public interface ProtocolRiskLevelService {

    /**
     * Adds the newProtocolRiskLevel to the list of protocolRiskLevels in the given protocol.
     * 
     * @param newProtocolRiskLevel the new protocol risk level to add
     * @param protocol the current protocol
     */
    void addRiskLevel(ProtocolRiskLevel newProtocolRiskLevel, Protocol protocol);

    /**
     * Sets the currentProtocolRiskLevel's status to inactive and creates an identical newProtocolRiskLevel for the user to add.
     * @param currentProtocolRiskLevel the current protocol risk level to update
     * @param newProtocolRiskLevel the new protocol risk level to create
     */
    void updateRiskLevel(ProtocolRiskLevel currentProtocolRiskLevel, ProtocolRiskLevel newProtocolRiskLevel);

    /**
     * Removes the protocolRiskLevel at index from the list of protocolRiskLevels in the given protocol.
     * @param index the index of the protocol risk level to remove
     * @param protocol the current protocol
     */
    void deleteRiskLevel(int index, Protocol protocol);

}
