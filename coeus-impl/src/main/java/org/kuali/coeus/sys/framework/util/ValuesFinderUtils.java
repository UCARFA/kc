/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.util;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.List;

public class ValuesFinderUtils {

    /** private ctor. */
    private ValuesFinderUtils() {
        throw new UnsupportedOperationException("do not call");
    }

    private static final KeyValue SELECT = new ConcreteKeyValue("", "select");
    private static final String SEMICOLON_AS_DELIMITOR = ";";
    private static final String COMMA_AS_DELIMITOR = ",";
    
    /**
     * 
     * This method processes a list of KeyValue and converts them to a string separated
     * by semi-colons and comas.
     * This is used in both getFrequencyCodes and getFrequencyBaseCodes services.
     */
    public static String processKeyValueList(List<KeyValue> KeyValueList){
        
        StringBuilder strBuilder = new StringBuilder();
        
        int lastElementIndex = KeyValueList.size()-1;
        
        for(int i = 0; i < lastElementIndex; i++){
            strBuilder.append(KeyValueList.get(i).getKey());
            strBuilder.append(SEMICOLON_AS_DELIMITOR);
            strBuilder.append(KeyValueList.get(i).getValue());
            strBuilder.append(COMMA_AS_DELIMITOR);
        }
        
        strBuilder.append(KeyValueList.get(lastElementIndex).getKey());
        strBuilder.append(SEMICOLON_AS_DELIMITOR);
        strBuilder.append(KeyValueList.get(lastElementIndex).getValue());
        
        return strBuilder.toString();
    }

    /**
     * This method returns a "select" option with a blank key for use in various
     */
    public static KeyValue getSelectOption() {
        return SELECT;
    }
}
