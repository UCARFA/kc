/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.citi;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component("personTrainingCitiRecordStatusFinder")
public class PersonTrainingCitiRecordStatusFinder extends UifKeyValuesFinderBase {
    private static final List<KeyValue> VALUES;
    static {
        VALUES = Stream.of(PersonTrainingCitiRecordStatus.values()).map(v -> new ConcreteKeyValue(v.getCode(), v.getDescription())).collect(Collectors.toList());
    }

    @Override
    public List<KeyValue> getKeyValues() {
        return VALUES;
    }
}
