/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.framework.person;

import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.sys.framework.keyvalue.EnumValuesFinder;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.Comparator;
import java.util.List;

public class UnitPopulationBehaviorValuesFinder extends EnumValuesFinder {

    @Override
    protected Class<UnitPopulationBehavior> getEnumClass() {
        return UnitPopulationBehavior.class;
    }

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = super.getKeyValues();
        keyValues.sort(Comparator.comparing(kv -> StringUtils.isBlank(kv.getKey()) ? -1 : UnitPopulationBehavior.fromCode(kv.getKey()).getOrder()));
        return keyValues;
    }

}
