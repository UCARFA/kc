/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.service.impl;

import org.kuali.coeus.common.notification.impl.service.NotificationRoleSubQualifierFinders;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationRoleSubQualifierFindersImpl implements NotificationRoleSubQualifierFinders {

    private Map<String, KeyValuesFinder> finders;

    public Map<String, KeyValuesFinder> getFinders() {
        return finders;
    }
    
    public void setFinders(Map<String, KeyValuesFinder> finders) {
        this.finders = finders;
    }
    
    @Override
    public List<KeyValue> getKeyValuesForRole(String roleName) {
        KeyValuesFinder finder = getFinders().get(roleName);
        if (finder != null) {
            return asKeyValueList(finder.getKeyLabelMap());
        } else {
            return new ArrayList<KeyValue>();
        }
    }
    
    @Override
    public List<KeyValue> getKeyValuesForAllRoles() {
        Map<String, String> result = new HashMap<String, String>();
        for (Map.Entry<String, KeyValuesFinder> entry : getFinders().entrySet()) {
            result.putAll(entry.getValue().getKeyLabelMap());
        }

        return asKeyValueList(result);
    }
    
    protected List<KeyValue> asKeyValueList(Map<String, String> values) {
        values.remove("");
        values.put("", "All");
        List<KeyValue> asList = new ArrayList<KeyValue>();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            asList.add(new ConcreteKeyValue(entry.getKey(), entry.getValue()));
        }
        return asList;
    }
}
