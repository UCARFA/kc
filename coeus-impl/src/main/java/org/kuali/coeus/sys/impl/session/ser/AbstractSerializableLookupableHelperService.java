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
