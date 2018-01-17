/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.instprop.impl.api.customSerializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomSqlDateSerializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        SimpleDateFormat source = new SimpleDateFormat(JsonFormats.DESERIALIZED_SQL_DATE_FORMAT);

        String dateText = jp.getText();
        try {
            return new Date(source.parse(dateText).getTime());
        } catch (ParseException e) {
            throw new RuntimeException("Cannot convert date " + dateText, e);
        }
    }
}
