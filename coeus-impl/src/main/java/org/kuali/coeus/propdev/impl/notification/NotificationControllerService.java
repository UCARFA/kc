/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.notification;

import org.kuali.coeus.common.notification.impl.NotificationAwareForm;
import org.kuali.coeus.common.notification.impl.NotificationContext;
import org.springframework.web.servlet.ModelAndView;

public interface NotificationControllerService {

    <T extends NotificationContext> ModelAndView sendNotification(NotificationAwareForm<T> form);
    <T extends NotificationContext> ModelAndView performRecipientSearch(NotificationAwareForm<T> form);
    <T extends NotificationContext> ModelAndView addRecipients(NotificationAwareForm<T> form);
    <T extends NotificationContext> ModelAndView sendNotifications(NotificationAwareForm<T> form, T context);
    <T extends NotificationContext> void sendNotificationIfNoErrors(NotificationAwareForm<T> form, T context);
    <T extends NotificationContext> ModelAndView prepareNotificationWizard(NotificationAwareForm<T> form);
    <T extends NotificationContext> ModelAndView cancelNotifications(NotificationAwareForm<T> form);
}
