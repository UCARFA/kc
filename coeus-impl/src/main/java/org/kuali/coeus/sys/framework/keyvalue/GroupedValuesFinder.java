/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2017 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
