/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.infrastructure;

import org.apache.ojb.broker.accesslayer.conversions.ConversionException;
import org.apache.ojb.broker.accesslayer.conversions.FieldConversion;


public class OjbOnOffCampusFlagFieldConversion implements FieldConversion {

    @Override
    public Object javaToSql(Object source) throws ConversionException {
        if (source instanceof Boolean) {
            if (source != null) {
                Boolean b = (Boolean) source;
                return b.booleanValue() ? "N" : "F";
            }
            else {
                return null;
            }
        }
        else if (source instanceof String) {
            if ("true".equals(source)) {
                return "N";
            }
            else if ("false".equals(source)) {
                return "F";
            }
        }
        return source;
    }

    /**
     * @see org.apache.ojb.broker.accesslayer.conversions.FieldConversion#sqlToJava(java.lang.Object)
     * 'N' means 'ON', returns true, 'F' means 'OFF' returns false
     */
    @Override
    public Object sqlToJava(Object source) throws ConversionException {
        try {
            if (source instanceof String) {
                if (source != null) {
                    String s = (String) source;
                    return s.equalsIgnoreCase("N");
                }
                else {
                    return null;
                }
            }
            return source;
        }
        catch (Throwable t) {
            throw new RuntimeException("I have exploded converting types", t);
        }
    }

    
    
    
}
