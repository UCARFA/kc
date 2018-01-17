/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.notification;

import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.protocol.notification.ProtocolNotification;
import org.kuali.rice.krad.service.BusinessObjectService;

// class used to satisfy java bean convention
public class IacucProtocolNotification extends ProtocolNotification {

    private static final long serialVersionUID = -41490937286230774L;

    public IacucProtocolNotification() {
        super();
    }

    @Override
    public void persistOwningObject(KcPersistableBusinessObjectBase object) {
        IacucProtocol protocol = (IacucProtocol)object;
        this.setOwningDocumentIdFk(protocol.getLastProtocolAction().getProtocolActionId());
        protocol.getLastProtocolAction().addNotification(this);
        KcServiceLocator.getService(BusinessObjectService.class).save(this);
    }

    public static IacucProtocolNotification copy(KcNotification notification) {
        IacucProtocolNotification newNotification = new IacucProtocolNotification();
        copy(notification, newNotification);
        return newNotification;
    }
}
