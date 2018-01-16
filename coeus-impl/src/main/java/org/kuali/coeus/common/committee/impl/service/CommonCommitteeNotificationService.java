/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.service;

import org.kuali.coeus.common.committee.impl.meeting.CommScheduleMinuteDocBase;
import org.kuali.coeus.common.committee.impl.meeting.ScheduleAgendaBase;


/**
 * 
 * This class generates committee-based notifications.
 */
public interface CommonCommitteeNotificationService {
    
    /**
     * 
     * These methods generate committee notifications
     * @throws Exception 
     */
    public void generateNotification(String notificationType, ScheduleAgendaBase agenda);
    public void generateNotification(String notificationType, CommScheduleMinuteDocBase minuteDoc);
 
}
