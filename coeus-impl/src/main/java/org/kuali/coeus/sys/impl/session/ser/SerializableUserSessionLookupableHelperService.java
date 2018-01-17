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
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("serializableUserSessionLookupableHelperService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SerializableUserSessionLookupableHelperService extends AbstractLookupableHelperServiceImpl  {

    @Autowired
    @Qualifier("serializableUserSessionAttributeService")
    private SerializableSessionAttributeService serializableSessionAttributeService;

    @Override
    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {
         return serializableSessionAttributeService.getAttributes();
    }

    public SerializableSessionAttributeService getSerializableSessionAttributeService() {
        return serializableSessionAttributeService;
    }

    public void setSerializableSessionAttributeService(SerializableSessionAttributeService serializableSessionAttributeService) {
        this.serializableSessionAttributeService = serializableSessionAttributeService;
    }
}
