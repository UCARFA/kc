/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.notification;

import org.kuali.coeus.common.notification.impl.service.KcNotificationRoleQualifierService;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;

/**
 * Defines the service to fill in module role qualifier information for Protocol.
 */
public interface IRBNotificationRoleQualifierService extends KcNotificationRoleQualifierService {

    /**
     * Returns the Protocol.
     * 
     * @return the Protocol
     */
    Protocol getProtocol();
    
    /**
     * Sets the Protocol.
     *
     * @param protocol the Protocol to set
     */
    void setProtocol(Protocol protocol);

    /**
     * Returns the Protocol Online Review.
     * 
     * @return the Protocol Online Review
     */
    ProtocolOnlineReview getProtocolOnlineReview();
    
    /**
     * Sets the Protocol Online Review.
     *
     * @param protocolOnlineReview the Protocol Online Review to set
     */
    void setProtocolOnlineReview(ProtocolOnlineReview protocolOnlineReview);
    
}
