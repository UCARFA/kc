/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.person;

import java.util.ArrayList;
import java.util.List;

import org.kuali.coeus.sys.framework.keyvalue.PrefixValuesFinder;
import org.kuali.coeus.common.framework.person.PersonTypeConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.springframework.stereotype.Component;

/**
 * Values finder that includes key and labels from the Person Type enum.
 */
@Component("personTypeValuesFinder")
public class PersonTypeValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> values = new ArrayList<KeyValue>();
        values.add(new ConcreteKeyValue(PrefixValuesFinder.getPrefixKey(), PrefixValuesFinder.getDefaultPrefixValue()));
        for (PersonTypeConstants type : PersonTypeConstants.values()) {
            values.add(new ConcreteKeyValue(type.getCode(), type.getDescription()));
        }
        return values;
    }

    
}
