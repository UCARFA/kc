/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl;

import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.rice.kns.lookup.KualiLookupableImpl;

public class NotificationLookupableImpl extends KualiLookupableImpl {

    private KcNotificationAuthorizationService kcNotificationAuthorizationService;
    
    @Override
    public String getCreateNewUrl() {
        String url = "";
        if (getKcNotificationAuthorizationService().hasPermission(PermissionConstants.MODIFY_NOTIFICATION)) {
            url =  super.getCreateNewUrl();
        }
        return url;
    }

    public KcNotificationAuthorizationService getKcNotificationAuthorizationService() {
        return kcNotificationAuthorizationService;
    }

    public void setKcNotificationAuthorizationService(KcNotificationAuthorizationService kcNotificationAuthorizationService) {
        this.kcNotificationAuthorizationService = kcNotificationAuthorizationService;
    }
    
}
