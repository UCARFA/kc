/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.keyvalue;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;

import java.util.List;
import java.util.Map;

/**
 * A {@link KeyValuesFinder KeyValuesFinder} that adds a prefix {@link KeyValue KeyValue}.
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
public final class PrefixValuesFinder implements KeyValuesFinder {

    private static final String PREFIX_KEY = "";
    private static final String DEFAULT_PREFIX_VALUE = "select";
    
    private final KeyValuesFinder finder;
    private final String prefixValue; 
    
    /**
     * Wraps a {@link KeyValuesFinder KeyValuesFinder} using the default prefix value.
     * @param finder the finder.
     * @see #getDefaultPrefixValue()
     * @throws NullPointerException if the finder is null.
     */
    public PrefixValuesFinder(final KeyValuesFinder finder) {
        this(finder, DEFAULT_PREFIX_VALUE);
    }
    
    /**
     * Wraps a {@link KeyValuesFinder KeyValuesFinder} and using the passed in prefix value.
     * @param finder the finder.
     * @param prefixValue the prefix value. This value can be an empty string.
     * @throws NullPointerException if the finder or the prefix value is null.
     */
    public PrefixValuesFinder(final KeyValuesFinder finder, final String prefixValue) {
        
        if (finder == null) {
            throw new NullPointerException("the finder is null");
        }
        
        if (prefixValue == null) {
            throw new NullPointerException("the comparator is null");
        }
        
        this.finder = finder;
        this.prefixValue = prefixValue;
    }

    @Override
    public String getKeyLabel(final String key) {
        if (PREFIX_KEY.equals(key)) {
            return this.prefixValue;
        }
        
        return this.finder.getKeyLabel(key);
    }

    @Override
    public Map<String, String> getKeyLabelMap() {
        @SuppressWarnings("unchecked")
        final Map<String, String> map = this.finder.getKeyLabelMap();
        map.put(PREFIX_KEY, this.prefixValue);
        return map;
    }

    @Override
    public List<KeyValue> getKeyValues() {
        final List<KeyValue> list = this.finder.getKeyValues();
        list.add(0, new ConcreteKeyValue(PREFIX_KEY, this.prefixValue));
        return list;
    }
    
    /**
     * Gets the prefix key. {@value #PREFIX_KEY}
     * @return the prefix key
     */
    public static String getPrefixKey() {
        return PREFIX_KEY;
    }

    /**
     * Gets the default prefix value. {@value #DEFAULT_PREFIX_VALUE}
     * @return the default prefix value
     */
    public static String getDefaultPrefixValue() {
        return DEFAULT_PREFIX_VALUE;
    }

    @Override
    public List<KeyValue> getKeyValues(boolean includeActiveOnly) {
        @SuppressWarnings("unchecked")
        final List<KeyValue> list = this.finder.getKeyValues(includeActiveOnly);
        list.add(0, new ConcreteKeyValue(PREFIX_KEY, this.prefixValue));
        return list;
    }

    @Override
    public void clearInternalCache() {
        this.finder.clearInternalCache();
    }
}
