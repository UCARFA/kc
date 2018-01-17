/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Report RegenerationType values finder class.
 */
public class ReportRegenerationTypeValuesFinder extends UifKeyValuesFinderBase {
   
    /**
     * Get the report regeneration types and use the name as the key in the label.
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> labels = new ArrayList<KeyValue>();
        for (ReportRegenerationType type : ReportRegenerationType.values()) {
            labels.add(new ConcreteKeyValue(type.name(), type.getDescription()));
        }
        return labels;
    }
}
