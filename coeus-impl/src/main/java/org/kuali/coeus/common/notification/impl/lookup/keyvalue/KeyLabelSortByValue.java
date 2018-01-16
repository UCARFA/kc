/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.lookup.keyvalue;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.kuali.rice.core.api.util.AbstractKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

/**
 * Provides a value finder for the Notification Type Recipient Role Namespace and Role name combination.  Has different
 * Comparator to sort by label instead of by key.
 */
public class KeyLabelSortByValue extends AbstractKeyValue implements Comparable<KeyValue> {
    

    private static final long serialVersionUID = 1L;

    public KeyLabelSortByValue(String key, String label) {
         super(key, label);
    }

    @Override
    public int compareTo(KeyValue o) {
        if (o == null) {
            throw new NullPointerException("the object to compare to is null");
        }
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(this.getValue(), o.getValue(), String.CASE_INSENSITIVE_ORDER);

        if ((this.getKey() instanceof String) && (o.getKey() instanceof String))
            builder.append(this.getKey(), o.getKey(), String.CASE_INSENSITIVE_ORDER);
        else {
            builder.append(this.getKey(), o.getKey());
        }

        return builder.toComparison();

    }
}
