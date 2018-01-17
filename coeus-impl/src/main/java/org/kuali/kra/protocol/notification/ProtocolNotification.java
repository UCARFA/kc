/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.notification;

import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.rice.krad.service.BusinessObjectService;

/**
 * Defines a document-specific instance of a Notification Type.
 */
public class ProtocolNotification extends KcNotification {

    private static final long serialVersionUID = -8718347978876523074L;

    @Override
    public void persistOwningObject(KcPersistableBusinessObjectBase object) {
        ProtocolBase protocol = (ProtocolBase)object;
        protocol.getLastProtocolAction().addNotification(this);
        KcServiceLocator.getService(BusinessObjectService.class).save(protocol);
        KcServiceLocator.getService(BusinessObjectService.class).save(this);
    }

    public static void copy(KcNotification source, KcNotification target) {
        target.setNotificationId(source.getNotificationId());
        target.setNotificationTypeId(source.getNotificationTypeId());
        target.setDocumentNumber(source.getDocumentNumber());
        target.setRecipients(source.getRecipients());
        target.setSubject(source.getSubject());
        target.setMessage(source.getMessage());
        target.setNotificationType(source.getNotificationType());
        target.setNotificationTypeId(source.getNotificationTypeId());
    }

}
