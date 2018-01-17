/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notification;

import org.kuali.coeus.common.notification.impl.service.KcNotificationRoleQualifierService;
import org.kuali.kra.award.home.Award;

/**
 * Defines the service to fill in module role qualifier information for Award.
 */
public interface AwardNotificationRoleQualifierService extends KcNotificationRoleQualifierService {

    /**
     * Returns the Award.
     * 
     * @return the Award
     */
    Award getAward();
    
    /**
     * Sets the Award.
     *
     * @param award the Award to set
     */
    void setAward(Award award);
    
}
