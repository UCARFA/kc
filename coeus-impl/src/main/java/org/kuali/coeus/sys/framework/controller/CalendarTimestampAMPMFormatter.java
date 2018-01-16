/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller;

import org.kuali.rice.core.web.format.Formatter;
import org.kuali.rice.core.web.format.TimestampAMPMFormatter;

import java.sql.Timestamp;
import java.util.Calendar;

@Deprecated
public class CalendarTimestampAMPMFormatter extends Formatter {

    private TimestampAMPMFormatter formatter = new TimestampAMPMFormatter();

    @Override
    public Object convertToObject(String target) {
        if (target == null) {
            return null;
        }
        final Calendar c = Calendar.getInstance();
        c.setTime((Timestamp) formatter.convertToObject(target));
        return c;
    }

    @Override
    public Object format(Object value) {
        if (value == null) {
            return "";
        }
        return formatter.format(new Timestamp(((Calendar) value).getTime().getTime()));
    }
}
