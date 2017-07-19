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

import com.google.common.collect.Iterators;
import com.google.common.collect.Streams;
import org.kuali.coeus.sys.impl.session.SessionHoldingListener;
import org.kuali.rice.krad.UserSession;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.kuali.coeus.sys.framework.util.CollectionUtils.entry;

@Component("serializableUserSessionAttributeService")
public class SerializableUserSessionAttributeServiceImpl implements SerializableSessionAttributeService {

    @Override
    public List<SerializableUserSessionAttribute> getAttributes() {
        return SessionHoldingListener.getSessions().stream()
                .map(session ->
                        Streams.stream(Iterators.forEnumeration(session.getAttributeNames()))
                                .map (attrName -> entry(attrName, session.getValue(attrName)))
                                .filter(attr -> attr.getValue() instanceof UserSession)
                                .flatMap(attr -> ((UserSession) attr.getValue()).getObjectMap().entrySet().stream())
                                .map(attr -> {
                                    final SerializableUtils.SerInfo info = SerializableUtils.getSerializationInfo(attr.getValue());
                                    return new SerializableUserSessionAttribute(session.getId(), attr.getKey(), attr.getValue().getClass().getName(), attr.getValue().toString(), info.isSerializable(), info.getSize(), info.getFailurePath());
                                })
                                .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
