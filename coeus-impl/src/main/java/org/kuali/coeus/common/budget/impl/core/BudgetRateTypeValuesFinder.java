/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.budget.framework.rate.RateClass;
import org.kuali.coeus.sys.framework.keyvalue.KeyValueFinderService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BudgetRateTypeValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        KeyValueFinderService keyValueFinderService= (KeyValueFinderService) KcServiceLocator.getService("keyValueFinderService");
        Map<String,String> queryMap = new HashMap<String,String>();
        queryMap.put("rateClassType", "O");
        List<KeyValue> keyValueList = keyValueFinderService.getKeyValues(RateClass.class, "code", "description", queryMap);
        KeyValue KeyValueSelect = ValuesFinderUtils.getSelectOption();
        for (KeyValue KeyValue : keyValueList) {
            if (StringUtils.isBlank(KeyValue.getKey().toString())) {
                KeyValueSelect = KeyValue;
            }            
        }
        keyValueList.remove(KeyValueSelect);
        return keyValueList;
        
    }
}
