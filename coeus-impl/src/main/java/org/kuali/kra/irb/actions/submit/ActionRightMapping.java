/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.protocol.drools.brms.FactBean;

/*
 * This is the condition attributes to decide whether user has permission to perform an action
 */
public class ActionRightMapping implements FactBean {
    
    private String actionTypeCode;
    private String rightId;
    private String unitIndicator;
    private String committeeId;
    private String scheduleId;  
    private boolean allowed;
    
    public String getActionTypeCode() {
        return actionTypeCode;
    }
    public void setActionTypeCode(String actionTypeCode) {
        this.actionTypeCode = actionTypeCode;
    }
    public String getRightId() {
        return rightId;
    }
    public void setRightId(String rightId) {
        this.rightId = rightId;
    }
    public String getUnitIndicator() {
        return unitIndicator;
    }
    public void setUnitIndicator(String unitIndicator) {
        this.unitIndicator = unitIndicator;
    }
    public String getCommitteeId() {
        return committeeId;
    }
    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
    }
    public String getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
    public boolean isAllowed() {
        return allowed;
    }
    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }    
}
