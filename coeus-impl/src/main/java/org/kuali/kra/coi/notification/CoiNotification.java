/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notification;

import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.rice.krad.service.BusinessObjectService;

// class used to satisfy java bean convention
public class CoiNotification extends KcNotification {

    private static final long serialVersionUID = 5124828394114551463L;

    public CoiNotification() {
        super();
    }

    @Override
    public void persistOwningObject(KcPersistableBusinessObjectBase object) {
        if (object instanceof CoiDisclosure) {
            CoiDisclosure disclosure = (CoiDisclosure)object;
            disclosure.addNotification(this);
            KcServiceLocator.getService(BusinessObjectService.class).save(disclosure);
            KcServiceLocator.getService(BusinessObjectService.class).save(this);
        } else {
            //TODO how to persist notification for FE
        }
    }

}
