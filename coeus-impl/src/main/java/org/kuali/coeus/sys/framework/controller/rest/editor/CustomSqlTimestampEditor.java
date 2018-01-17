/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller.rest.editor;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;

public class CustomSqlTimestampEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) {
        setValue(value);
    }

    @Override
    public Object getValue() {
        if (super.getValue() == null || StringUtils.isBlank(super.getValue().toString())) {
            return null;
        }

        return Timestamp.valueOf(super.getValue().toString());
    }


}
