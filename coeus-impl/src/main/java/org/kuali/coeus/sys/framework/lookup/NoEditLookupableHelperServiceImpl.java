/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.lookup;

import org.kuali.rice.krad.bo.BusinessObject;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * This class is to set the allowsMaintenanceEditAction to false, so the 'edit' action
 * will not be created in search result list.  currently Budget5categorymapping &amp; validceratetype are
 * using this as lookupable.
 */
@Component("noEditLookupableHelperService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NoEditLookupableHelperServiceImpl extends KcKualiLookupableHelperServiceImpl {

    @Override
    protected boolean allowsMaintenanceEditAction(BusinessObject businessObject) {
        return false;
    }

}
