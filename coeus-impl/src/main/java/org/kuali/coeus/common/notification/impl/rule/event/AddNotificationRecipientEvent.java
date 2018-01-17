/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.rule.event;

import org.kuali.coeus.common.notification.impl.bo.NotificationTypeRecipient;
import org.kuali.coeus.common.notification.impl.rule.AddNotificationRecipientRule;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * Represents the event for adding a Notification Type Recipient.
 */
public class AddNotificationRecipientEvent extends KcDocumentEventBaseExtension {
    
    private static final String NEW_NOTIFICATION_RECIPIENT_FIELD = "notificationHelper.newNotificationRecipient.";
    
    private NotificationTypeRecipient notificationTypeRecipient;
    
    private List<NotificationTypeRecipient> notificationTypeRecipients;
    
    /**
     * Constructs an AddNotificationRecipientEvent.
     * 
     * @param document The parent document
     * @param notificationTypeRecipient The Notification Type Recipient object to validate
     * @param notificationTypeRecipients The existing Notification Type Recipient objects
     */
    public AddNotificationRecipientEvent(Document document, NotificationTypeRecipient notificationTypeRecipient, 
                                         List<NotificationTypeRecipient> notificationTypeRecipients) {
        super("adding notification type recipient", NEW_NOTIFICATION_RECIPIENT_FIELD, document);
        this.notificationTypeRecipient = notificationTypeRecipient;
        this.notificationTypeRecipients = notificationTypeRecipients;
    }
    
    public NotificationTypeRecipient getNotificationTypeRecipient() {
        return notificationTypeRecipient;
    }

    public void setNotificationTypeRecipient(NotificationTypeRecipient notificationTypeRecipient) {
        this.notificationTypeRecipient = notificationTypeRecipient;
    }

    public List<NotificationTypeRecipient> getNotificationTypeRecipients() {
        return notificationTypeRecipients;
    }

    public void setNotificationTypeRecipients(List<NotificationTypeRecipient> notificationTypeRecipients) {
        this.notificationTypeRecipients = notificationTypeRecipients;
    }

    @Override
    public KcBusinessRule<AddNotificationRecipientEvent> getRule() {
        return new AddNotificationRecipientRule();
    }

}
