/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.keyvalue;


import org.kuali.coeus.sys.api.model.Coded;
import org.kuali.coeus.sys.api.model.Describable;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class EnumValuesFinder<T extends Enum & Coded & Describable> extends KeyValuesBase {

    protected abstract Class<? extends T> getEnumClass();

    @Override
    public List<KeyValue> getKeyValues() {

        final List<KeyValue> keyValues = new ArrayList<>();

        //unable to use the stream api and complex generics due to a bug in java
        for (T t : getEnumClass().getEnumConstants()) {
            keyValues.add(new ConcreteKeyValue(t.getCode(), t.getDescription()));
        }

        keyValues.sort(Comparator.comparing(KeyValue::getValue));
        keyValues.add(0, ValuesFinderUtils.getSelectOption());

        return keyValues;
    }
}
