/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.rule.event;

import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.common.notification.impl.bo.NotificationTypeRecipient;
import org.kuali.coeus.common.notification.impl.rule.SendNotificationRule;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * Represents the event for sending a Notification.
 */
public class SendNotificationEvent extends KcDocumentEventBaseExtension {
    
    private static final String NEW_NOTIFICATION_RECIPIENT_FIELD = "notificationHelper.newNotificationRecipient.";
    
    private KcNotification notification;
    
    private List<NotificationTypeRecipient> notificationTypeRecipients;
    
    /**
     * Constructs a SendNotificationEvent.
     * 
     * @param errorPathPrefix
     * @param document
     * @param specialReview
     */
    public SendNotificationEvent(Document document, KcNotification notification, List<NotificationTypeRecipient> notificationTypeRecipients) {
        super("sending notification", NEW_NOTIFICATION_RECIPIENT_FIELD, document);
        this.notification = notification;
        this.notificationTypeRecipients = notificationTypeRecipients;
    }

    public KcNotification getNotification() {
        return notification;
    }

    public void setNotification(KcNotification notification) {
        this.notification = notification;
    }

    public List<NotificationTypeRecipient> getNotificationTypeRecipients() {
        return notificationTypeRecipients;
    }

    public void setNotificationTypeRecipients(List<NotificationTypeRecipient> notificationTypeRecipients) {
        this.notificationTypeRecipients = notificationTypeRecipients;
    }

    @Override
    public KcBusinessRule<SendNotificationEvent> getRule() {
        return new SendNotificationRule();
    }

}
