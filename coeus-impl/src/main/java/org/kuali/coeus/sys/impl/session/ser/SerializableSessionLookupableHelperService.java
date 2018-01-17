/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.session.ser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("serializableSessionLookupableHelperService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SerializableSessionLookupableHelperService extends AbstractSerializableLookupableHelperService  {

    @Autowired
    @Qualifier("serializableSessionAttributeService")
    private SerializableSessionAttributeService serializableSessionAttributeService;

    @Override
    public SerializableSessionAttributeService getSerializableSessionAttributeService() {
        return serializableSessionAttributeService;
    }

    public void setSerializableSessionAttributeService(SerializableSessionAttributeService serializableSessionAttributeService) {
        this.serializableSessionAttributeService = serializableSessionAttributeService;
    }
}
