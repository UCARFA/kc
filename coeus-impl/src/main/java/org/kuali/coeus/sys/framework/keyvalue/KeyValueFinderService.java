/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.keyvalue;

import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.List;
import java.util.Map;

public interface KeyValueFinderService{
    List<KeyValue> getKeyValues(Class<? extends BusinessObject> keyValClass, String codePropName, String valPropName);

    /**
     *
     * This method is to get key values pair by providing additional query map as retrieving criteria.
     */
    List<KeyValue> getKeyValues(Class<? extends BusinessObject> keyValClass, String codePropName, String valPropName, Map<String, ?> queryMap);
}
