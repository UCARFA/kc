/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.notifyiacuc;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.notification.IacucProtocolNotificationRenderer;

import java.util.Map;

/**
 * Renders additional fields for the Notify IRB notification.
 */
public class NotifyIacucNotificationRenderer extends IacucProtocolNotificationRenderer {

    private String actionComments;

    /**
     * Constructs a Notify IRB notification renderer.
     * @param protocol
     * @param actionComments
     */
    public NotifyIacucNotificationRenderer(IacucProtocol protocol, String actionComments) {
        super(protocol);
        
        this.actionComments = actionComments;
    }
    
    public String getActionComments() {
        return actionComments;
    }

    public void setActionComments(String actionComments) {
        this.actionComments = actionComments;
    }
    
    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{ACTION_COMMENTS}", getSafeMessage("{ACTION_COMMENTS}", actionComments));

        return params;
    }

}
