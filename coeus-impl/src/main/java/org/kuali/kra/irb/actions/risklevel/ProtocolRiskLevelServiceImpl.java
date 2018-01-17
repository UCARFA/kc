/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.risklevel;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.irb.Protocol;

/**
 * Implements the <code>ProtocolRiskLevelService</code>.
 */
public class ProtocolRiskLevelServiceImpl implements ProtocolRiskLevelService {
    
    @Override
    public void addRiskLevel(ProtocolRiskLevel newProtocolRiskLevel, Protocol protocol) {
        newProtocolRiskLevel.setProtocolId(protocol.getProtocolId());
        newProtocolRiskLevel.setProtocol(protocol);
        protocol.getProtocolRiskLevels().add(newProtocolRiskLevel);
    }
    
    @Override
    public void updateRiskLevel(ProtocolRiskLevel currentProtocolRiskLevel, ProtocolRiskLevel newProtocolRiskLevel) {
        currentProtocolRiskLevel.setStatus(Constants.STATUS_INACTIVE);
        
        newProtocolRiskLevel.setRiskLevelCode(currentProtocolRiskLevel.getRiskLevelCode());
        newProtocolRiskLevel.setDateAssigned(currentProtocolRiskLevel.getDateAssigned());
        newProtocolRiskLevel.setComments(currentProtocolRiskLevel.getComments());
    }
    
    @Override
    public void deleteRiskLevel(int index, Protocol protocol) {
        if (index >= 0 && index < protocol.getProtocolRiskLevels().size()) {
            protocol.getProtocolRiskLevels().remove(index);
        }
    }

}
