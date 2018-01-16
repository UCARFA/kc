/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * This class is to get minute entry type code and sorted by sortid
 */
public class MinuteEntryTypeValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {

        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        for (MinuteEntryType minuteEntryType : getMinuteEntryTypes()) {
            if (!MinuteEntryType.PROTOCOL_REVIEWER_COMMENT.equals(minuteEntryType.getMinuteEntryTypeCode())) {
                keyValues.add(new ConcreteKeyValue(minuteEntryType.getMinuteEntryTypeCode(), minuteEntryType.getDescription()));
            }
        }
        keyValues.add(0, ValuesFinderUtils.getSelectOption());
        return keyValues;
    }

    private List<MinuteEntryType> getMinuteEntryTypes() {
        List<MinuteEntryType> entryTypes = (List<MinuteEntryType>) KcServiceLocator.getService(BusinessObjectService.class)
                .findAll(MinuteEntryType.class);
        Collections.sort(entryTypes);
        return entryTypes;
    }
}
