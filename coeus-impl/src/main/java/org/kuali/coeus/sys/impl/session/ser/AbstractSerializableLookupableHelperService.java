/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.session.ser;

import org.kuali.rice.kns.lookup.AbstractLookupableHelperServiceImpl;
import org.kuali.rice.krad.bo.BusinessObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public abstract class AbstractSerializableLookupableHelperService extends AbstractLookupableHelperServiceImpl  {

    private static final String Y = "Y";
    private static final String N = "N";

    @Override
    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {
        final String serializable = fieldValues.get("serializable");

        if (Y.equals(serializable)) {
            return getSerializableSessionAttributeService().getAttributes().stream().filter(SerializableSessionAttribute::isSerializable).collect(Collectors.toList());
        } else if (N.equals(serializable)) {
            return getSerializableSessionAttributeService().getAttributes().stream().filter(attr -> !attr.isSerializable()).collect(Collectors.toList());
        }
        return getSerializableSessionAttributeService().getAttributes();
    }

    public abstract SerializableSessionAttributeService getSerializableSessionAttributeService();
}
