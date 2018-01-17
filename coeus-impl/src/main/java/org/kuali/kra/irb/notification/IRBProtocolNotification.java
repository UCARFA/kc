/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.notification;

import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.protocol.notification.ProtocolNotification;
import org.kuali.rice.krad.service.BusinessObjectService;

// class used to satisfy java bean convention
public class IRBProtocolNotification extends ProtocolNotification {

    private static final long serialVersionUID = 8034971407079669736L;

    private ProtocolAction protocolAction;
    
    public IRBProtocolNotification() {
        super();
    }
    
    public ProtocolAction getProtocolAction() {
        return protocolAction;
    }

    public void setProtocolAction(ProtocolAction protocolAction) {
        this.protocolAction = protocolAction;
    }

    @Override
    public void persistOwningObject(KcPersistableBusinessObjectBase object) {
        Protocol protocol = (Protocol)object;
        this.setOwningDocumentIdFk(protocol.getLastProtocolAction().getProtocolActionId());
        protocol.getLastProtocolAction().addNotification(this);
        KcServiceLocator.getService(BusinessObjectService.class).save(this);
    }

    public static IRBProtocolNotification copy(KcNotification notification) {
        IRBProtocolNotification newNotification = new IRBProtocolNotification();
        copy(notification, newNotification);
        return newNotification;
    }

}
