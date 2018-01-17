/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.maintenance;

import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.model.KcDataObject;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.krad.maintenance.MaintainableImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("kcMaintainableBase")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class KcMaintainableBase extends MaintainableImpl {

    @Autowired
    @Qualifier("globalVariableService")
    private GlobalVariableService globalVariableService;

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        if (getDataObject() instanceof KcDataObject) {
            ((KcDataObject) getDataObject()).setUpdateUser(getGlobalVariableService().getUserSession().getPrincipalName());
            ((KcDataObject) getDataObject()).setUpdateUserSet(true);
        }
    }

    public GlobalVariableService getGlobalVariableService() {
        if (globalVariableService == null) {
            globalVariableService = KcServiceLocator.getService(GlobalVariableService.class);
        }

        return globalVariableService;
    }

    public void setGlobalVariableService(GlobalVariableService globalVariableService) {
        this.globalVariableService = globalVariableService;
    }
}
