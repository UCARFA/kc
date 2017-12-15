/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
