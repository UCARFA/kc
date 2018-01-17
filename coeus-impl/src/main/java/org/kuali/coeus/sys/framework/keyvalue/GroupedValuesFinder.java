/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.framework.keyvalue;

import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.uif.util.UifOptionGroupLabel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * {@link KeyValuesFinder} that derives its values from a map of other {@link KeyValuesFinder} instances, automatically
 * adding &lt;optgroup&gt; tags between them based on their associated key in the supplied map.
 */
public class GroupedValuesFinder extends UifKeyValuesFinderBase {

    private Map<String, KeyValuesFinder> subValuesFinders;

    public GroupedValuesFinder() {
        super();
        setAddBlankOption(false);
    }

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> combinedKeyValues = new ArrayList<>();
        for (Map.Entry<String, KeyValuesFinder> entry : subValuesFinders.entrySet()) {
            combinedKeyValues.add(new UifOptionGroupLabel(entry.getKey()));
            combinedKeyValues.addAll(entry.getValue().getKeyValues());
        }
        return combinedKeyValues;
    }

    public Map<String, KeyValuesFinder> getSubValuesFinders() {
        return subValuesFinders;
    }

    public void setSubValuesFinders(Map<String, KeyValuesFinder> subValuesFinders) {
        this.subValuesFinders = subValuesFinders;
    }
}
