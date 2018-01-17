/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.notification;

import org.kuali.coeus.common.notification.impl.service.KcNotificationRoleQualifierService;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewBase;

/**
 * Defines the service to fill in module role qualifier information for ProtocolBase.
 */
public interface ProtocolNotificationRoleQualifierService extends KcNotificationRoleQualifierService {

    /**
     * Returns the ProtocolBase.
     * 
     * @return the ProtocolBase
     */
    ProtocolBase getProtocol();
    
    /**
     * Sets the ProtocolBase.
     *
     * @param protocol the ProtocolBase to set
     */
    void setProtocol(ProtocolBase protocol);

    /**
     * Returns the ProtocolBase Online Review.
     * 
     * @return the ProtocolBase Online Review
     */
    ProtocolOnlineReviewBase getProtocolOnlineReview();
    
    /**
     * Sets the ProtocolBase Online Review.
     *
     * @param protocolOnlineReview the ProtocolBase Online Review to set
     */
    void setProtocolOnlineReview(ProtocolOnlineReviewBase protocolOnlineReview);
    
}
