/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.notification;

import org.kuali.coeus.common.notification.impl.service.KcNotificationRoleQualifierService;
import org.kuali.kra.subaward.bo.SubAward;

/**
 * Defines the service to fill in module role qualifier information for Award.
 */
public interface SubAwardNotificationRoleQualifierService extends KcNotificationRoleQualifierService {

    /**
     * @return the Award
     */
    SubAward getSubAward();
    
    /**
     * @param award the SubAward to set
     */
    void setSubAward(SubAward subAward);
    
}
