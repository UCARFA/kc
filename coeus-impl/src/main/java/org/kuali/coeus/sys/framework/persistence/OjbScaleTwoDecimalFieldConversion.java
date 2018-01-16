/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.persistence;

import org.apache.ojb.broker.accesslayer.conversions.ConversionException;
import org.apache.ojb.broker.accesslayer.conversions.FieldConversion;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.math.BigDecimal;


public class OjbScaleTwoDecimalFieldConversion implements FieldConversion {

    @Override
    public Object javaToSql(Object source) throws ConversionException {
        Object converted = source;

        if (source instanceof ScaleTwoDecimal) {
            converted = ((ScaleTwoDecimal) source).bigDecimalValue();
        }

        return converted;
    }

    @Override
    public Object sqlToJava(Object source) throws ConversionException {
        Object converted = source;

        if (source instanceof BigDecimal) {
            converted = new ScaleTwoDecimal((BigDecimal) source);
        }

        return converted;
    }

    
    
    
}
