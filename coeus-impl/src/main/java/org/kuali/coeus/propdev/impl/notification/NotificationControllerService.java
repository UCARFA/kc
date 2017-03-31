/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
