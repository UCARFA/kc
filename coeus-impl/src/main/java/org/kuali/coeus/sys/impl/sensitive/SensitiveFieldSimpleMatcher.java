/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.sensitive;

import org.kuali.coeus.sys.framework.sensitive.SensitiveFieldMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is simple implementation of SensitiveFieldMatcher, where sorted
 * TreeSet is populated with sensitive fields (ignoring wild card entries) and
 * matched against searchString. 
 */
@Component("sensitiveFieldSimpleMatcher")
public class SensitiveFieldSimpleMatcher implements SensitiveFieldMatcher {
    
    public static final String STAR_CONSTANT = "*";
    
    //Provides log(n) time for search and add operation
    private Set<String> fields = new TreeSet<String>(new Comparator<String>(){
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });

    @Autowired
    public SensitiveFieldSimpleMatcher(@Qualifier("sensitiveFieldResourceLoader") SensitiveFields sensitiveFields) {
        addToSortedSet(sensitiveFields.getSensitiveFields());
    }

    /**
     * Private helper method to populate sensitive fields from resource.
     * @param listOfStrings
     */
    private void addToSortedSet(List<String> listOfStrings) {
        for(String str: listOfStrings) {
            if(str.contains(STAR_CONSTANT))
                continue;
            fields.add(str);
        }
    }
    
    @Override
    public boolean match(String searchString) {        
        return fields.contains(searchString);
    }
    
}
