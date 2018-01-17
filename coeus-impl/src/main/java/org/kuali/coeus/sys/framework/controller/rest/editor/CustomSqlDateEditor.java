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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomSqlDateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) {
        setValue(value);
    }

    @Override
    public Object getValue() {
        SimpleDateFormat source = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat target = new SimpleDateFormat("yyyy-MM-dd");

        String oldDate = super.getValue().toString();
        if (super.getValue() == null || StringUtils.isBlank(oldDate)) {
            return null;
        }

        try {
            String newDate = target.format(source.parse(oldDate));
            return Date.valueOf(newDate);
        } catch (ParseException e) {
            try {
                return new Date(target.parse(oldDate).getTime());
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
