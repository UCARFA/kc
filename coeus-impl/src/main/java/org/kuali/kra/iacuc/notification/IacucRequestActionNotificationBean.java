/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.notification;

import org.kuali.kra.iacuc.IacucProtocol;

public class IacucRequestActionNotificationBean extends IacucProtocolNotificationRequestBean {

    private static final long serialVersionUID = 7021594436424194360L;

    private String reason;
    
    public IacucRequestActionNotificationBean(IacucProtocol protocol, String actionType, String description, String reason) {
        super(protocol, actionType, description);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
