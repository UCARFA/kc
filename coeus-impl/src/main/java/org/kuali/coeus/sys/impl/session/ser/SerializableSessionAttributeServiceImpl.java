/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.session.ser;

import com.google.common.collect.Iterators;
import com.google.common.collect.Streams;
import org.kuali.coeus.sys.impl.session.SessionHoldingListener;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.kuali.coeus.sys.framework.util.CollectionUtils.entry;

@Component("serializableSessionAttributeService")
public class SerializableSessionAttributeServiceImpl implements SerializableSessionAttributeService {

    @Override
    public List<SerializableSessionAttribute> getAttributes() {
        return SessionHoldingListener.getSessions().stream()
                .map(session ->
                        Streams.stream(Iterators.forEnumeration(session.getAttributeNames()))
                                .map (attrName -> entry(attrName, session.getValue(attrName)))
                                .filter(attr -> attr.getValue() != null)
                                .map(attr -> {
                                    final SerializableUtils.SerInfo info = SerializableUtils.getSerializationInfo(attr.getValue());
                                    return new SerializableSessionAttribute(session.getId(), attr.getKey(), attr.getValue().getClass().getName(), attr.getValue().toString(), info.isSerializable(), info.getSize(), info.getFailurePath());
                                })
                                .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
