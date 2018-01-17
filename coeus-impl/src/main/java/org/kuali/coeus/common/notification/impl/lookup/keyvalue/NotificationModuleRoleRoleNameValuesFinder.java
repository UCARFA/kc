/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.lookup.keyvalue;

import org.kuali.coeus.sys.framework.keyvalue.PrefixValuesFinder;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kim.framework.role.RoleEbo;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Provides a value finder for the Notification Module Role, Role Namespace and Role name combination.
 */
public class NotificationModuleRoleRoleNameValuesFinder extends UifKeyValuesFinderBase {
    
    private KeyValuesService keyValuesService;

    @Override
    public List<KeyValue> getKeyValues() {
        Collection<RoleEbo> roles = getKeyValuesService().findAll(RoleEbo.class);
        
        List<KeyLabelSortByValue> keyValues = new ArrayList<KeyLabelSortByValue>();
        keyValues.add(new KeyLabelSortByValue(PrefixValuesFinder.getPrefixKey(), PrefixValuesFinder.getDefaultPrefixValue()));
        for (RoleEbo role : roles) {
            String roleKey = role.getNamespaceCode() + ":" + role.getName();
            keyValues.add(new KeyLabelSortByValue(roleKey, roleKey));                            
        }
        // sort values for usability
        Collections.sort(keyValues);
        List<KeyValue> returnKeyValues = new ArrayList<KeyValue>();
        returnKeyValues.addAll(keyValues);
        
        return returnKeyValues;
    }
    
    public KeyValuesService getKeyValuesService() {
        if (keyValuesService == null) {
            keyValuesService = (KeyValuesService) KcServiceLocator.getService(KeyValuesService.class);
        }
        return keyValuesService;
    }
    
    public void setKeyValuesService(KeyValuesService keyValuesService) {
        this.keyValuesService = keyValuesService;
    }

}
