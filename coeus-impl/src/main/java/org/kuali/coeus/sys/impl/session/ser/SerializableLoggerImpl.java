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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component("serializableLogger")
public class SerializableLoggerImpl implements SerializableLogger {

    private Log LOG = LogFactory.getLog(SerializableLoggerImpl.class);

    @Autowired
    @Qualifier("serializableKradFormService")
    private SerializableSessionAttributeService serializableKradFormService;

    @Autowired
    @Qualifier("serializableSessionAttributeService")
    private SerializableSessionAttributeService serializableSessionAttributeService;

    @Autowired
    @Qualifier("serializableUserSessionAttributeService")
    private SerializableSessionAttributeService serializableUserSessionAttributeService;

    @Override
    public void log() {
        if (LOG.isWarnEnabled()) {
            Stream.concat(Stream.concat(serializableSessionAttributeService.getAttributes().stream(),
                    serializableUserSessionAttributeService.getAttributes().stream()),
                    serializableKradFormService.getAttributes().stream())
                    .filter(attr -> !attr.isSerializable())
                    .forEach(attr ->  LOG.warn("Serialization failed: " + attr));
        }
    }

    public SerializableSessionAttributeService getSerializableKradFormService() {
        return serializableKradFormService;
    }

    public void setSerializableKradFormService(SerializableSessionAttributeService serializableKradFormService) {
        this.serializableKradFormService = serializableKradFormService;
    }

    public SerializableSessionAttributeService getSerializableSessionAttributeService() {
        return serializableSessionAttributeService;
    }

    public void setSerializableSessionAttributeService(SerializableSessionAttributeService serializableSessionAttributeService) {
        this.serializableSessionAttributeService = serializableSessionAttributeService;
    }

    public SerializableSessionAttributeService getSerializableUserSessionAttributeService() {
        return serializableUserSessionAttributeService;
    }

    public void setSerializableUserSessionAttributeService(SerializableSessionAttributeService serializableUserSessionAttributeService) {
        this.serializableUserSessionAttributeService = serializableUserSessionAttributeService;
    }
}
