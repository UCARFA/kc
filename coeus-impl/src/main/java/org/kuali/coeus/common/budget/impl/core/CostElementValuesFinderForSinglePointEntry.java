/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core;

import org.kuali.coeus.common.budget.framework.core.CostElement;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component("costElementValuesFinderForSinglePointEntry")
public class CostElementValuesFinderForSinglePointEntry extends CostElementValuesFinder {

    @Override
    protected List<KeyValue> getDropDownDisplay(List<CostElement> costElements) {
        List<KeyValue> keyValues = new ArrayList<>();
        for (CostElement costElement : costElements) {
            keyValues.add(new ConcreteKeyValue(costElement.getCostElement(), costElement.getCostElement() + " - " + costElement.getDescription()));
        }
        Collections.sort(keyValues, new KeyValueComparator());
        keyValues.add(0, ValuesFinderUtils.getSelectOption());
        return keyValues;
    }

}
