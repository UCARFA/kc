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

public class OjbBlobClobFieldConversion implements FieldConversion {

    @Override
    public Object javaToSql(Object source) throws ConversionException {
        byte[] sourceBytes = (byte[])source;
        return sourceBytes==null?null:new String(sourceBytes);
    }

    @Override
    public Object sqlToJava(Object source) throws ConversionException {
        if(source==null) return null;
        byte[] sourceBytes = null;
        if(source instanceof String){
            sourceBytes = source.toString().getBytes();
        }else if(source instanceof char[]){
            sourceBytes = new String((char[])source).getBytes();
        }
        return sourceBytes;
    }
}
