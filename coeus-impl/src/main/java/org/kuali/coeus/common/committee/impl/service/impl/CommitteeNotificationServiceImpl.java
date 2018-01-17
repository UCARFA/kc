/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.common.committee.impl.meeting.CommScheduleMinuteDocBase;
import org.kuali.coeus.common.committee.impl.meeting.ScheduleAgendaBase;
import org.kuali.coeus.common.committee.impl.notification.AgendaCreatedNotificationRenderer;
import org.kuali.coeus.common.committee.impl.notification.CommitteeNotificationContext;
import org.kuali.coeus.common.committee.impl.notification.MinutesCreatedNotificationRenderer;
import org.kuali.coeus.common.committee.impl.service.CommonCommitteeNotificationService;
import org.kuali.coeus.common.notification.impl.service.KcNotificationService;
import org.kuali.kra.infrastructure.Constants;

/**
 * 
 * This class generates the notifications for committees.
 */
public class CommitteeNotificationServiceImpl implements CommonCommitteeNotificationService {

    private String committeeNotificationType;

    private KcNotificationService kcNotificationService;
    
    public String getCommitteeNotificationType() {
        return committeeNotificationType;
    }

    public void setCommitteeNotificationType(String committeeNotificationType) {
        this.committeeNotificationType = committeeNotificationType;
    }

    /**
     * This method generates Agenda Generated notifications for a committee.
     * @throws Exception 
     */
    @Override
    public void generateNotification(String notificationType, ScheduleAgendaBase agenda) {
        
        if (StringUtils.equals(notificationType, Constants.COMMITTEE_AGENDA_NOTIFICATION)) {
            CommitteeScheduleBase committeeSchedule = agenda.getCommitteeSchedule();
            AgendaCreatedNotificationRenderer renderer = new AgendaCreatedNotificationRenderer(agenda, "action taken");
            CommitteeNotificationContext context = new CommitteeNotificationContext(committeeSchedule, 
                                                    notificationType, "Agenda Generated Notification", renderer);
            kcNotificationService.sendNotification(context);
        } else {
            throw new IllegalArgumentException(committeeNotificationType);
        }
        
    }
    
    /**
     * This method generates Minutes Generated notifications for a committee.
     * @throws Exception 
     */
    @Override
    public void generateNotification(String notificationType, CommScheduleMinuteDocBase minuteDoc) {
        
        if (StringUtils.equals(notificationType, Constants.COMMITTEE_MINUTES_NOTIFICATION)) {
            CommitteeScheduleBase committeeSchedule = minuteDoc.getCommitteeSchedule();
            MinutesCreatedNotificationRenderer renderer = new MinutesCreatedNotificationRenderer(minuteDoc, "action taken");
            CommitteeNotificationContext context = new CommitteeNotificationContext(committeeSchedule, 
                                                    notificationType, "Minutes Generated Notification", renderer);
            kcNotificationService.sendNotification(context);
        } else {
            throw new IllegalArgumentException(committeeNotificationType);
        }
        
    }
    
    /**
     * Populated by Spring Beans.
     * @param kcNotificationService
     */
    public void setKcNotificationService(KcNotificationService kcNotificationService) {
        this.kcNotificationService = kcNotificationService;
    }

}
