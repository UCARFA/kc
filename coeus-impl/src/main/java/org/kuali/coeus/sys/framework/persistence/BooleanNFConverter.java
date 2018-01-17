/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.persistence;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanNFConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean objectValue) {
        if (objectValue == null) {
            return "F";
        }
        return objectValue ? "N" : "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String dataValue) {
        if (dataValue == null) {
            return Boolean.FALSE;
        }
        return dataValue.equals("N");
    }
}
