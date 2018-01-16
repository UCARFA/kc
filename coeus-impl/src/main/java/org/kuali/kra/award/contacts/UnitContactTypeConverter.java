/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.apache.ojb.broker.accesslayer.conversions.ConversionException;
import org.apache.ojb.broker.accesslayer.conversions.FieldConversion;
import org.kuali.coeus.common.framework.unit.UnitContactType;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorType;

/**
 * This class converts the UnitType type
 */
public class UnitContactTypeConverter implements FieldConversion {
    private static final long serialVersionUID = -3298305889586306843L;
    
    private static final String JAVA_TYPE_ERROR = "Java type not a UnitContactType";
    private static final String SQL_TYPE_ERROR = "SQL type not a String";
    

    @Override
    public Object javaToSql(Object source) {
        if(!(source instanceof UnitContactType || source instanceof UnitAdministratorType)) {
            throw new ConversionException(JAVA_TYPE_ERROR);
        }
        
        return ((UnitContactType)source).name();
    }

    @Override
    public Object sqlToJava(Object source) {
        if(!(source instanceof String)) {
            throw new ConversionException(SQL_TYPE_ERROR);
        }
        
        UnitContactType unitContactType;
        try {
            unitContactType = UnitContactType.valueOf((String) source);
        } catch(IllegalArgumentException e) {
            throw new ConversionException(e.getMessage(), e);
        }
         
        return unitContactType;
    }

}
