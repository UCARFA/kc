/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.lookup.keyvalue;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AMPMValuesFinder extends UifKeyValuesFinderBase {
    
    public static final String AM = "AM";
    public static final String PM = "PM";

    private static final List<KeyValue> KEY_VALUES;
    static {
        final List<KeyValue> temp = new ArrayList<>();
        temp.add(new ConcreteKeyValue(AM, AM));
        temp.add(new ConcreteKeyValue(PM, PM));
        KEY_VALUES = Collections.unmodifiableList(temp);
    }

    @Override
    public List<KeyValue> getKeyValues() {
        return KEY_VALUES;
    }

}
