package org.kuali.kra.subaward.lookup;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubAwardDocumentStatusValuesFinder extends KeyValuesBase {

    private static final long serialVersionUID = -3074955977161691637L;

    public List<KeyValue> getKeyValues() {
        return Arrays.stream(SubAwardDocumentStatusConstants.values())
                .map(status -> new ConcreteKeyValue(status.code(), status.description()))
                .collect(Collectors.toList());
    }

}
