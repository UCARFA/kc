/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.kra.award.lookup.AwardDocumentStatusConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;

import java.util.ArrayList;
import java.util.List;

public class AwardDocumentStatusValuesFinder extends KeyValuesBase {

    private static List<KeyValue> values;

    static {
        values = new ArrayList<KeyValue>();

        for (AwardDocumentStatusConstants documentStatus : AwardDocumentStatusConstants.values()) {
            values.add(new ConcreteKeyValue(documentStatus.code(), documentStatus.description()));
        }
    }

    @Override
    public List<KeyValue> getKeyValues() {
        return values;
    }

}
