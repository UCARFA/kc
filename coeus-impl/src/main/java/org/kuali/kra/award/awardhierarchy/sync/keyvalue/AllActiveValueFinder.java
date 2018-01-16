/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.keyvalue;

import org.kuali.kra.award.awardhierarchy.sync.AwardSyncDescendantValues;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public class AllActiveValueFinder extends UifKeyValuesFinderBase {
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> activeLabels = new ArrayList<KeyValue>();

        activeLabels.add(new ConcreteKeyValue("", ""));
        activeLabels.add(new ConcreteKeyValue(AwardSyncDescendantValues.SYNC_ALL.getSyncValue(), "All"));
        activeLabels.add(new ConcreteKeyValue(AwardSyncDescendantValues.SYNC_ACTIVE.getSyncValue(), "Active"));

        return activeLabels;
    }
}
