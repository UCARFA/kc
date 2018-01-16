/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public class CfdaMaintenanceTypeValuesFinder extends UifKeyValuesFinderBase {


    private static final long serialVersionUID = -2607882482226239633L;

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> labels = new ArrayList<KeyValue>();
        labels.add(new ConcreteKeyValue(Constants.CFDA_MAINT_TYP_ID_AUTOMATIC, Constants.CFDA_MAINT_TYP_ID_AUTOMATIC));
        labels.add(new ConcreteKeyValue(Constants.CFDA_MAINT_TYP_ID_MANUAL, Constants.CFDA_MAINT_TYP_ID_MANUAL));


        return labels;
    }

}
