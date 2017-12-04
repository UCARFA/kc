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

package org.kuali.coeus.org.kuali.rice.krad.uif.element;

import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.field.InputFieldBase;
import org.kuali.rice.krad.uif.util.ObjectPropertyUtils;
import org.kuali.rice.krad.uif.view.View;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * KRAD InputField for holding multi-select values supplied by a {@link org.kuali.rice.krad.keyvalues.KeyValuesFinder},
 * which displays the descriptions of those KeyValues rather than the stored codes when read-only. Can be configured to
 * change the separator between the selected read-only descriptions as well (defaults to newlines).
 */
public class ValuesFinderDisplayInputField extends InputFieldBase {

    private String keySeparator = ",";
    private String valuesSeparator = "<br />";

    @Override
    protected void setAlternateAndAdditionalDisplayValue(View view, Object model) {
        if (getOptionsFinder() == null) {
            super.setAlternateAndAdditionalDisplayValue(view, model);
        } else {
            List<KeyValue> keyValues = getOptionsFinder().getKeyValues();
            Object fieldValue = ObjectPropertyUtils.getPropertyValue(model, getBindingInfo().getBindingPath());
            if (fieldValue != null && fieldValue instanceof String) {
                String optionDescriptions = Stream.of(((String) fieldValue).split(keySeparator))
                        .map(key -> keyValues.stream().filter(kv -> kv.getKey().equals(key))
                                    .findFirst()
                                    .map(KeyValue::getValue)
                                    .orElse(key))
                        .collect(Collectors.joining(valuesSeparator));
                setReadOnlyDisplayReplacement(optionDescriptions);
            }
        }
    }

    public String getValuesSeparator() {
        return valuesSeparator;
    }

    public void setValuesSeparator(String valuesSeparator) {
        this.valuesSeparator = valuesSeparator;
    }
}
