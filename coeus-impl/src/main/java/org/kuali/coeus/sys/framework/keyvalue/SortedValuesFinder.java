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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * A {@link KeyValuesFinder KeyValuesFinder} that sort the {@link KeyValue KeyValue} returned from
 * {@link #getKeyValues()}.
 * 
 * <p>
 * This class is designed to wrap other KeyValuesFinders in order to add behavior.
 * </p>
 * for example:
 * <pre>
        PersistableBusinessObjectValuesFinder boFinder = new PersistableBusinessObjectValuesFinder();
        boFinder.setBusinessObjectClass(Foo.class);
        boFinder.setKeyAttributeName("foo");
        boFinder.setLabelAttributeName("bar");
        this.finder = new PrefixValuesFinder(new SortedValuesFinder(boFinder));
        .
        .
        .
        boFinder.getKeyValues();
   </pre>
 * 
 * Then just use the wrapped KeyValuesFinder within a custom finder.
 */
public final class SortedValuesFinder implements KeyValuesFinder {

    private static final Comparator<KeyValue> DEFAULT_COMPARATOR = KeyValueComparator.getInstance();
    
    private final KeyValuesFinder finder;
    private final Comparator<KeyValue> comparator; 
    
    /**
     * Wraps a {@link KeyValuesFinder KeyValuesFinder} and using the default {@link Comparator Comparator}.
     * @param finder the finder.
     * @see #getDefaultComparator()
     * @throws NullPointerException if the finder is null.
     */
    public SortedValuesFinder(final KeyValuesFinder finder) {
        this(finder, DEFAULT_COMPARATOR);
    }
    
    /**
     * Wraps a {@link KeyValuesFinder KeyValuesFinder} and using the passed in prefix value.
     * @param finder the finder.
     * @param comparator the comparator to use for sorting.
     * @throws NullPointerException if the finder or the comparator value is null.
     */
    public SortedValuesFinder(final KeyValuesFinder finder, final Comparator<KeyValue> comparator) {
        
        if (finder == null) {
            throw new NullPointerException("the finder is null");
        }
        
        if (comparator == null) {
            throw new NullPointerException("the comparator is null");
        }
        
        this.finder = finder;
        this.comparator = comparator;
    }

    @Override
    public String getKeyLabel(final String key) {
        return this.finder.getKeyLabel(key);
    }

    @Override
    public Map<String, String> getKeyLabelMap() {
        @SuppressWarnings("unchecked")
        final Map<String, String> map = this.finder.getKeyLabelMap();
        return map;
    }

    @Override
    public List<KeyValue> getKeyValues() {
        @SuppressWarnings("unchecked")
        final List<KeyValue> list = this.finder.getKeyValues();
        Collections.sort(list, this.comparator);
        return list;
    }
    
    /**
     * Gets the default {@link Comparator Comparator}.
     * @return the default {@link Comparator Comparator}
     */
    public static Comparator<KeyValue> getDefaultComparator() {
        return DEFAULT_COMPARATOR;
    }

    @Override
    public List<KeyValue> getKeyValues(boolean includeActiveOnly) {
        @SuppressWarnings("unchecked")
        final List<KeyValue> list = this.finder.getKeyValues(includeActiveOnly);
        Collections.sort(list, this.comparator);
        return list;
    }

    @Override
    public void clearInternalCache() {
        this.finder.clearInternalCache();
    }
}
