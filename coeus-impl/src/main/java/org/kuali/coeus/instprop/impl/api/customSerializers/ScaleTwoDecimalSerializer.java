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
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.io.IOException;

public class ScaleTwoDecimalSerializer extends JsonDeserializer<ScaleTwoDecimal> {
    @Override
    public ScaleTwoDecimal deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String value = jp.getText();
        return new ScaleTwoDecimal(value);
    }
}
