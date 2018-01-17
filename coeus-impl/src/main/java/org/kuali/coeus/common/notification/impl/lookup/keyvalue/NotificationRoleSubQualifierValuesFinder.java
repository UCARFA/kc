/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.lookup.keyvalue;

import org.kuali.coeus.common.notification.impl.service.NotificationRoleSubQualifierFinders;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.List;

public class NotificationRoleSubQualifierValuesFinder extends UifKeyValuesFinderBase {
    
    private static final long serialVersionUID = 8109336340804375108L;
    private NotificationRoleSubQualifierFinders finders;

    @Override
    public List<KeyValue> getKeyValues() {
        return getFinders().getKeyValuesForAllRoles();
    }

    protected NotificationRoleSubQualifierFinders getFinders() {
        if (finders == null) {
            finders = KcServiceLocator.getService(NotificationRoleSubQualifierFinders.class);
        }
        return finders;
    }

    public void setFinders(NotificationRoleSubQualifierFinders finders) {
        this.finders = finders;
    }
    
    

}
