/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.sorting;

import java.util.Comparator;

/**
 * Comparator that takes a list of comparators and uses each in turn and returns the first non-zero comparison.
 * @param <T>
 */
public class MultiComparator<T> implements Comparator<T> {
    
    private final Comparator<T>[] comparators;
    
    public MultiComparator(Comparator<T>[] comparators) {
        this.comparators = comparators;
    }
    
    @Override
    public int compare(T o1, T o2) {
        for (Comparator<T> comparator : comparators) {
            int comparison = comparator.compare(o1, o2);
            if (comparison != 0) {
                return comparison;
            }
        }
        return 0;        
    }
}
