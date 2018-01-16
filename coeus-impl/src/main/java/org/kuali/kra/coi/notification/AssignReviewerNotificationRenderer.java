/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notification;

import org.kuali.kra.coi.CoiDisclosure;

import java.util.Map;

/**
 * Renders additional fields for the Disclosure Certified notification.
 */
public class AssignReviewerNotificationRenderer extends CoiNotificationRenderer {


    private static final long serialVersionUID = 8779177260177014284L;
    private String actionTaken;
    
    /**
     * Constructs an Agenda Created notification renderer.
     * 
     * @param protocol
     * @param actionTaken
     */
    public AssignReviewerNotificationRenderer(CoiDisclosure coiDisclosure, String actionTaken) {
        super(coiDisclosure);
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
