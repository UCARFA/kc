/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notification;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.notification.IRBNotificationRenderer;

import java.util.Map;

/**
 * Renders additional fields for the Assign Reviewer notification.
 */
public class AssignReviewerNotificationRenderer extends IRBNotificationRenderer {

    private static final long serialVersionUID = -6019679826378390076L;
    
    private String actionTaken;
    
    /**
     * Constructs an Assign Reviewer notification renderer.
     * 
     * @param protocol
     * @param actionTaken
     */
    public AssignReviewerNotificationRenderer(Protocol protocol, String actionTaken) {
        super(protocol);
        
        this.actionTaken = actionTaken;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{ACTION_TAKEN}", actionTaken);
        return params;
    }    

}
