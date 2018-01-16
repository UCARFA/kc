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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * This class for storing the details of watermark Font.
 */
public class WatermarkPositionFontValuesFinder extends UifKeyValuesFinderBase {

    private static final List<KeyValue> KEY_VALUES = IntStream.rangeClosed(2, 30)
            .filter(i -> i % 2 == 0)
            .mapToObj(i -> new ConcreteKeyValue(String.valueOf(i), String.valueOf(i).concat(" %")))
            .collect(Collectors.toList());

    @Override
    public List<KeyValue> getKeyValues() {
        return KEY_VALUES;
    }
     

}
