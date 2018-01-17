/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.protocol.drools.brms.FactBean;

/**
 * Defines the Drools mapping for determining whether a certain action should be opened as a followup action to a previously submitted action.
 */
public class ProtocolActionFollowupMapping implements FactBean {
    
    private String protocolActionTypeCode;
    
    private String committeeDecisionMotionTypeCode;
    
    private boolean isOpenForFollowup;
    
    /**
     * Constructs a ProtocolActionFollowupMapping.
     * @param protocolActionTypeCode The code for the protocol action
     * @param committeeDecisionMotionTypeCode The code for the committee decision motion type
     */
    public ProtocolActionFollowupMapping(String protocolActionTypeCode, String committeeDecisionMotionTypeCode) {
        this.protocolActionTypeCode = protocolActionTypeCode;
        this.committeeDecisionMotionTypeCode = committeeDecisionMotionTypeCode;
    }

    public String getProtocolActionTypeCode() {
        return protocolActionTypeCode;
    }

    public void setProtocolActionTypeCode(String protocolActionTypeCode) {
        this.protocolActionTypeCode = protocolActionTypeCode;
    }

    public String getCommitteeDecisionMotionTypeCode() {
        return committeeDecisionMotionTypeCode;
    }

    public void setCommitteeDecisionMotionTypeCode(String committeeDecisionMotionTypeCode) {
        this.committeeDecisionMotionTypeCode = committeeDecisionMotionTypeCode;
    }

    public boolean getIsOpenForFollowup() {
        return isOpenForFollowup;
    }

    public void setIsOpenForFollowup(boolean isOpenForFollowup) {
        this.isOpenForFollowup = isOpenForFollowup;
    }

}
