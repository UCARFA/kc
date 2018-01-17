/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.keyvalue;

import org.kuali.rice.core.api.util.KeyValue;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Compares two {@link KeyValue KeyValue} instances. Useful when sorting a list of for 
 *  a values finder
 *  
 *  @author $Author: gmcgrego $
 *  @version $Revision: 1.2 $
 */
public final class KeyValueComparator implements Comparator<KeyValue>, Serializable {
    
    private static final long serialVersionUID = -6968793748825904116L;
    private static final Comparator<KeyValue> INSTANCE = new KeyValueComparator();
    
    /**
     * Compares the label of <code>o1</code> to the label of </code>o2</code>.
     * 
     * {@inheritDoc}
     */
    @Override
    public int compare(KeyValue o1, KeyValue o2) {
        return o1.getValue().compareTo(o2.getValue());
    }

    /**
     * Gets an instance of a {@link KeyValueComparator KeyValueComparator}.
     * @return an instance
     */
    public static Comparator<KeyValue> getInstance() {
        return INSTANCE;
    }
}

