/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.risklevel;

import java.io.Serializable;

/**
 * Encapsulates the actions that can be performed on a ProtocolRiskLevel.
 */
public class ProtocolRiskLevelBean implements Serializable {

    private static final long serialVersionUID = -3726620115307425457L;

    private String errorPropertyKey;
    
    private ProtocolRiskLevel newProtocolRiskLevel;
    

    public ProtocolRiskLevelBean(String errorPropertyKey) {
        this.errorPropertyKey = errorPropertyKey + ".protocolRiskLevelBean";
        
        newProtocolRiskLevel = new ProtocolRiskLevel();
    }

    public String getErrorPropertyKey() {
        return errorPropertyKey;
    }
    
    public ProtocolRiskLevel getNewProtocolRiskLevel() {
        return newProtocolRiskLevel;
    }
    
    public void setNewProtocolRiskLevel(ProtocolRiskLevel newProtocolRiskLevel) {
        this.newProtocolRiskLevel = newProtocolRiskLevel;
    }

}
