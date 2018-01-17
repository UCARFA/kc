/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.expeditedapprove;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.irb.actions.approve.ProtocolApproveEvent;
import org.kuali.kra.irb.actions.approve.ProtocolApproveRule;

/**
 * Encapsulates the rules for approving a Protocol.
 */
public class ProtocolExpeditedApproveRule extends ProtocolApproveRule {
    
    private static final String SCHEDULE_FIELD = "scheduleId";

    @Override
    public boolean processRules(ProtocolApproveEvent event) {
        boolean isValid = true;
        
        if (event.getProtocolApproveBean().getApprovalDate() == null) {
            isValid = false;
            reportError(APPROVAL_DATE_FIELD, KeyConstants.ERROR_PROTOCOL_APPROVAL_DATE_REQUIRED);  
        }
        
        if (event.getProtocolApproveBean().getActionDate() == null) {
            isValid = false;
            reportError(ACTION_DATE_FIELD, KeyConstants.ERROR_PROTOCOL_GENERIC_ACTION_DATE_REQUIRED);  
        }
        
        ProtocolExpeditedApproveBean expeditedBean = (ProtocolExpeditedApproveBean)event.getProtocolApproveBean();
        if (expeditedBean.isAssignToAgenda() && StringUtils.isBlank(expeditedBean.getScheduleId())) {
            isValid = false;
            reportError(SCHEDULE_FIELD, KeyConstants.ERROR_PROTOCOL_SCHEDULE_NOT_SELECTED);
        }
        return isValid;
    }
}
