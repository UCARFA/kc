/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public abstract class SendCorrespondenceValuesFinderBase extends UifKeyValuesFinderBase {


    private static final long serialVersionUID = -9029045379411708867L;

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue(BatchCorrespondenceBase.SEND_CORRESPONDENCE_BEFORE_EVENT, "Before"));
        keyValues.add(new ConcreteKeyValue(BatchCorrespondenceBase.SEND_CORRESPONDENCE_AFTER_EVENT, "After"));
        return keyValues;
    }

}
