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
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.rice.krad.web.form.UifFormManager;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.kuali.coeus.sys.framework.util.CollectionUtils.entry;

@Component("serializableKradFormService")
public class SerializableKradFormServiceImpl implements SerializableSessionAttributeService {

    private static final String SESSION_FORMS = "sessionForms";

    @Override
    public List<SerializableUserSessionAttribute> getAttributes() {
        return SessionHoldingListener.getSessions().stream()
                .map(session ->
                        Streams.stream(Iterators.forEnumeration(session.getAttributeNames()))
                                .map (attrName -> entry(attrName, session.getValue(attrName)))
                                .filter(attr -> attr.getValue() instanceof UifFormManager)
                                .flatMap(attr -> getSessionForms((UifFormManager) attr.getValue()).entrySet().stream())
                                .map(attr -> {
                                    final SerializableUtils.SerInfo info = SerializableUtils.getSerializationInfo(attr.getValue());
                                    return new SerializableUserSessionAttribute(session.getId(), attr.getKey(), attr.getValue().getClass().getName(), attr.getValue().toString(), info.isSerializable(), info.getSize(), info.getFailurePath());
                                })
                                .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    private Map<String, UifFormBase> getSessionForms(UifFormManager manager) {
        try {
            final Field sessionForms = UifFormManager.class.getDeclaredField(SESSION_FORMS);
            sessionForms.setAccessible(true);
            return (Map<String, UifFormBase>) sessionForms.get(manager);
        } catch (NoSuchFieldException|IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
