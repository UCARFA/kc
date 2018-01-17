/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class provides a values finder for the fields used to sort
 * attachment tables.  
 */
public class SortByValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue("", "None"));
        keyValues.add(new ConcreteKeyValue("ATTP", new String("Attachment Type")));
        keyValues.add(new ConcreteKeyValue("DESC", new String("Description")));
        keyValues.add(new ConcreteKeyValue("LAUP", new String("Last Updated")));
        keyValues.add(new ConcreteKeyValue("UPBY", new String("Last Updated By")));
        
        return keyValues;
    }

    
}
