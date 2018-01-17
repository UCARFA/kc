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

import java.sql.Timestamp;
import java.util.Calendar;

public class OjbCalendarSqlTimestampConversion implements FieldConversion{

    @Override
    public Timestamp javaToSql(Object source) throws ConversionException {
        if (source == null) {
            return null;
        }

        return new Timestamp(((Calendar) source).getTime().getTime());
    }

    @Override
    public Calendar sqlToJava(Object source) throws ConversionException {
        if (source == null) {
            return null;
        }

        final Calendar c = Calendar.getInstance();
        c.setTime(new java.util.Date(((Timestamp) source).getTime()));
        return c;
    }
}
