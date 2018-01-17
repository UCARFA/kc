/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.model;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.model.KcDataObject;
import org.kuali.coeus.sys.framework.model.KcDataObjectService;
import org.kuali.rice.kim.api.identity.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.UUID;

@Component("kcDataObjectService")
public class KcDataObjectServiceImpl implements KcDataObjectService {

    @Autowired
    @Qualifier("identityService")
    private IdentityService identityService;

    @Autowired
    @Qualifier("globalVariableService")
    private GlobalVariableService globalVariableService;

    @Override
    public void initVersionNumberForPersist(KcDataObject kcDataObject) {
        kcDataObject.setVersionNumber(0L);
    }

    @Override
    public void initUpdateFieldsForPersist(KcDataObject kcDataObject) {
        setUpdateFields(kcDataObject);
    }

    @Override
    public void initObjectIdForPersist(KcDataObject kcDataObject) {
        if (StringUtils.isBlank(kcDataObject.getObjectId())) {
            kcDataObject.setObjectId(UUID.randomUUID().toString());
        }
    }

    @Override
    public void initVersionNumberForUpdate(KcDataObject kcDataObject) {
        // Optimistic Locking has been disabled so adding null check and setting version number to 0
        // If we ever turn Optimistic Locking back on, we need to remove this code
        if (kcDataObject.getVersionNumber() == null) {
            kcDataObject.setVersionNumber(0L);
        }
    }

    @Override
    public void initUpdateFieldsForUpdate(KcDataObject kcDataObject) {
        setUpdateFields(kcDataObject);
    }

    @Override
    public void initObjectIdForUpdate(KcDataObject kcDataObject) {
        if (StringUtils.isBlank(kcDataObject.getObjectId())) {
            kcDataObject.setObjectId(UUID.randomUUID().toString());
        }
    }

    private void setUpdateFields(KcDataObject kcDataObject) {
        if (!kcDataObject.isUpdateUserSet() && globalVariableService.getUserSession() != null) {
            kcDataObject.setUpdateUser(globalVariableService.getUserSession().getPrincipalName());
        }

        kcDataObject.setUpdateTimestamp(new Timestamp(new java.util.Date().getTime()));

        if (kcDataObject.getUpdateUser() != null) {
            kcDataObject.setUpdateUser(StringUtils.substring(kcDataObject.getUpdateUser(), 0, KcDataObject.UPDATE_USER_LENGTH));
        }
    }

    public IdentityService getIdentityService() {
        return identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    public GlobalVariableService getGlobalVariableService() {
        return globalVariableService;
    }

    public void setGlobalVariableService(GlobalVariableService globalVariableService) {
        this.globalVariableService = globalVariableService;
    }
}
