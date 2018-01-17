/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.print.watermark;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class for storing the details of watermark Color.
 */
public class WatermarkColorValuesFinder extends UifKeyValuesFinderBase {
    /**
     * This method for storing lookup keyvalues of watermark font Color.
     * 
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue("LIGHT_GRAY", "LIGHT_GRAY"));
        keyValues.add(new ConcreteKeyValue("BLACK", "BLACK"));
        keyValues.add(new ConcreteKeyValue("BLUE", "BLUE"));
        keyValues.add(new ConcreteKeyValue("MAGENTA", "MAGENTA"));
        keyValues.add(new ConcreteKeyValue("CYAN", "CYAN"));
        keyValues.add(new ConcreteKeyValue("ORANGE", "ORANGE"));
        keyValues.add(new ConcreteKeyValue("DARK_GRAY", "DARK_GRAY"));
        keyValues.add(new ConcreteKeyValue("PINK", "PINK"));
        keyValues.add(new ConcreteKeyValue("GRAY", "GRAY"));
        keyValues.add(new ConcreteKeyValue("RED", "RED"));
        keyValues.add(new ConcreteKeyValue("GREEN", "GREEN"));
        keyValues.add(new ConcreteKeyValue("WHITE", "WHITE"));
        keyValues.add(new ConcreteKeyValue("YELLOW", "YELLOW"));

        return keyValues;
    }


}
