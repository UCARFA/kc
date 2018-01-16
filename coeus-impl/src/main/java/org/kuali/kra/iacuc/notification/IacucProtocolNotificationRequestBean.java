/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.notification;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.onlinereview.IacucProtocolOnlineReview;
import org.kuali.kra.protocol.notification.ProtocolNotificationRequestBeanBase;

public class IacucProtocolNotificationRequestBean extends ProtocolNotificationRequestBeanBase {


    private static final long serialVersionUID = 539022630037045456L;

    public IacucProtocol getIacucProtocol() {
        return (IacucProtocol)getProtocol();
    }

    public IacucProtocolOnlineReview getIacucProtocolOnlineReview() {
        return (IacucProtocolOnlineReview)getProtocolOnlineReview();
    }

    public IacucProtocolNotificationRequestBean(IacucProtocol protocol, String actionType, String description) {
        super(protocol, actionType, description);
    }

    
    public IacucProtocolNotificationRequestBean(IacucProtocol protocol, IacucProtocolOnlineReview protocolOnlineReview, String actionType,
            String description, String docNumber, String olrEvent) {
        super(protocol, protocolOnlineReview, actionType, description, docNumber, olrEvent);
    }
 
        
}
