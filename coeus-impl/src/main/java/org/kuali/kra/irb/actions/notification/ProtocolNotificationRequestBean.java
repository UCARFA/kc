/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notification;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;
import org.kuali.kra.protocol.notification.ProtocolNotificationRequestBeanBase;

public class ProtocolNotificationRequestBean extends ProtocolNotificationRequestBeanBase {
    

    private static final long serialVersionUID = -4383148548571108022L;
    
    public ProtocolNotificationRequestBean(Protocol protocol, String actionType, String description) {
        super(protocol, actionType, description);
    }

    
    public ProtocolNotificationRequestBean(Protocol protocol, ProtocolOnlineReview protocolOnlineReview, String actionType, String description, String docNumber, String olrEvent) {
        super(protocol, protocolOnlineReview, actionType, description, docNumber, olrEvent);
    }
 
    @Override
    public Protocol getProtocol() {
        return (Protocol)super.getProtocol();
    }
    
    @Override
    public ProtocolOnlineReview getProtocolOnlineReview() {
        return (ProtocolOnlineReview)super.getProtocolOnlineReview();
    }
}
