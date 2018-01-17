/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is to set up the 'Alternate For' drop down list for members who have 'Alternate' role.
 */
public class AlternateForValuesFinder extends UifKeyValuesFinderBase {

    private static final String MEMBER_SEPARATOR = "#m#";
    private static final String FIELD_SEPARATOR = "#f#";
    private String absenteeList;

    @Override
    public List<KeyValue> getKeyValues() {

        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        for (String idName : absenteeList.split(MEMBER_SEPARATOR)) {
            String[] valuePair = idName.split(FIELD_SEPARATOR);
            keyValues.add(new ConcreteKeyValue(valuePair[0], valuePair[1]));
        }
        keyValues.add(0, ValuesFinderUtils.getSelectOption());
        return keyValues;
    }

    public String getAbsenteeList() {
        return absenteeList;
    }

    public void setAbsenteeList(String absenteeList) {
        this.absenteeList = absenteeList;
    }

}
