/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.sys.impl.session.ser;


import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SerializableSessionListener implements HttpSessionAttributeListener {

    private static final Log LOG = LogFactory.getLog(SerializableSessionListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (LOG.isWarnEnabled()) {
            final SerializableUtils.SerInfo info = SerializableUtils.getSerializationInfo(event.getValue());
            if (!info.isSerializable()) {
                LOG.warn("Attribute added to session " + getMessage(event, info));
            }
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        //no op
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if (LOG.isWarnEnabled()) {
            final SerializableUtils.SerInfo info = SerializableUtils.getSerializationInfo(event.getValue());
            if (!info.isSerializable()) {
                LOG.warn("Attribute replaced in session " + getMessage(event, info));
            }
        }
    }

    private String getMessage(HttpSessionBindingEvent event, SerializableUtils.SerInfo info) {
        return "name: " + event.getName() + ", type: " + event.getValue().getClass().getName() +
                ", value: " + event.getValue().toString() + ", source: " + event.getSource().getClass().getName() +
                ", failure path: " + info.getFailurePath()
                + " is not Serializable. Location of violation:\n" + getStackTrace();
    }

    private static String getStackTrace() {
        return Arrays.stream(Thread.currentThread().getStackTrace())
                .map(elem -> "\tat " + elem + SystemUtils.LINE_SEPARATOR)
                .collect(Collectors.joining());
    }
}
