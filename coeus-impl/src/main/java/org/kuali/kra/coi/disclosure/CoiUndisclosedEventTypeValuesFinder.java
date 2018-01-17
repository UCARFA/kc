/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.infrastructure.DisclosureEventTypeConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class creates a drop down list for Event type for undisclosed events criteria.
 */
public class CoiUndisclosedEventTypeValuesFinder extends UifKeyValuesFinderBase {


    private static final long serialVersionUID = -2596141537553819058L;

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        for (DisclosureEventTypeConstants eventType : DisclosureEventTypeConstants.values()) {
            keyValues.add(new ConcreteKeyValue(eventType.code(), eventType.description()));
        }
        return keyValues;
    }
}
