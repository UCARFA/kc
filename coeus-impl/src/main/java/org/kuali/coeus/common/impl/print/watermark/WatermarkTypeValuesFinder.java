/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.print.watermark;

import org.kuali.coeus.common.framework.print.watermark.WatermarkConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class for storing the details of watermark type.
 */
public class WatermarkTypeValuesFinder extends UifKeyValuesFinderBase {
    /**
     * This method for storing lookup keyvalues of watermark type.
     * Watermark Type: TEXT , IMAGE.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue("TEXT", WatermarkConstants.WATERMARK_TYPE_TEXT));
        keyValues.add(new ConcreteKeyValue("IMAGE", WatermarkConstants.WATERMARK_TYPE_IMAGE));
        return keyValues;
    }
}
