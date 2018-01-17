/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl;

import org.kuali.coeus.propdev.impl.core.AddLineHelper;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.kuali.rice.krad.util.MessageMap;

public interface NotificationAwareForm<T extends NotificationContext> extends ViewModel {

    NotificationHelper<T> getNotificationHelper();
    AddLineHelper getAddRecipientHelper();
    boolean isSendNotification();
    void setSendNotification(boolean sendNotification);
    Document getDocument();
    MessageMap getDeferredMessages();
    void setDeferredMessages(MessageMap deferredMessages);
}
