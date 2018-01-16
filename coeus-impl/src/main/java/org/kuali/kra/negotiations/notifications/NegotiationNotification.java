/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.notifications;

import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.rice.krad.service.BusinessObjectService;

public class NegotiationNotification extends KcNotification {

    private static final long serialVersionUID = -305741736132165017L;

    public NegotiationNotification() {
        super();
    }

    @Override
    public void persistOwningObject(KcPersistableBusinessObjectBase object) {
        Negotiation negotiation = (Negotiation)object;
        this.setOwningDocumentIdFk(negotiation.getNegotiationId());
        negotiation.addNotification(this);
        KcServiceLocator.getService(BusinessObjectService.class).save(this);
    }

}
