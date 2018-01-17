/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.service;

import org.kuali.coeus.common.notification.impl.NotificationContext;
import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.common.notification.impl.bo.NotificationType;
import org.kuali.coeus.common.notification.impl.bo.NotificationTypeRecipient;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.ken.api.notification.NotificationRecipient;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Defines methods for creating and sending KC Notifications.
 */
public interface KcNotificationService {
    
    /**
     * Returns the Notification Type based on a Notification Context.
     * 
     * @param context
     * @return The Notification Type
     */
    NotificationType getNotificationType(NotificationContext context);
    
    /**
     * Returns the Notification Type based on a Module Code and Action Code.
     * 
     * @param moduleCode
     * @param actionCode
     * @return The Notification Type
     */
    NotificationType getNotificationType(String moduleCode, String actionCode);


    boolean isNotificationTypeActive(NotificationContext context);

    boolean isNotificationTypeActive(String moduleCode, String actionTypeCode);

    /**
     * Creates a KC Notification based on the Notification Context.  The Notification Type associated with the Module Code and Action Code is 
     * retrieved from persistent storage and translated into a context-specific KC Notification instance based on the Notification Context.
     * 
     * @param notificationContext
     * @return The KC Notification
     */
    KcNotification createNotificationObject(NotificationContext notificationContext);
    
    /**
     * Saves a KC Notifications.
     * 
     * @param notification
     */
    void saveNotification(KcNotification notification);
    
    /**
     * Sends notification, completes notification object, and persists it.
     * 
     * @param notificationContext
     * @return The KC Notification
     */
    public void sendNotificationAndPersist(NotificationContext context, KcNotification notification, KcPersistableBusinessObjectBase object);
    public void sendNotificationAndPersist(NotificationContext context, KcNotification notification, List<NotificationTypeRecipient> notificationTypeRecipients, KcPersistableBusinessObjectBase object);
        
    /**
     * Retrieves a list of KC Notifications based on a Document Number, a Module Code, and a set of Action Codes.
     * 
     * @param documentNumber
     * @param moduleCode
     * @param actionCodes
     * @return The list of KC Notifications
     */
    List<KcNotification> getNotifications(String documentNumber, String moduleCode, Set<String> actionCodes);
    
    /**
     * Send an unedited KC Notification, using the context to populate context-specific role qualifiers within the Role-based Recipients.
     * 
     * @param notificationContext
     */
    void sendNotification(NotificationContext notificationContext);
    
    /**
     * Send a previously saved or edited KC Notification, using the context to populate context-specific role qualifiers within the Role-based Recipients and 
     * additionally sending the notification to other non-role users.
     * 
     * @param notificationContext
     * @param notification
     * @param notificationRecipients
     */
    void sendNotification(NotificationContext notificationContext, KcNotification notification, List<NotificationTypeRecipient> notificationRecipients);

    /**
     * Send an unedited KC Notification to {@code principalNames} using the given {@code subject} and {@code message}.
     * 
     * @param contextName
     * @param subject
     * @param message
     * @param principalNames
     */
    void sendNotification(String contextName, String subject, String message, List<String> principalNames);
    
    /**
     * Send an unedited KC Notification Email, using the context to populate context-specific role qualifiers within the Role-based Recipients.
     * 
     * @param notificationContext
     */
    void sendEmailNotification(NotificationContext notificationContext);
    
    /**
     * Return the notification recipients for this notification context.
     * @param context
     * @return
     */
    Set<NotificationRecipient.Builder> getNotificationRecipients(NotificationContext context);
    
    /**
     * Send a notification to the specified recipients.
     * @param contextName
     * @param subject
     * @param message
     * @param notificationRecipients
     */
    void sendNotification(String contextName, String subject, String message, Collection<NotificationRecipient.Builder> notificationRecipients);


    public List<NotificationTypeRecipient> addRecipient(List<Object> results);


}
