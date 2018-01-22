/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.lookup.keyvalue;


import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.bo.NsfCode;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component("nsfCodeFinder")
public class NsfCodeFinder extends UifKeyValuesFinderBase {

    @Autowired
    @Qualifier("businessObjectService")
    private transient BusinessObjectService businessObjectService;

    @Override
    public List<KeyValue> getKeyValues() {
        return Stream.concat(Stream.of(ValuesFinderUtils.getSelectOption()), getBusinessObjectService().findAll(NsfCode.class).stream()
                .map(nsfCode -> new ConcreteKeyValue(nsfCode.getNsfSequenceNumber().toString(), nsfCode.getDescription())))
                .collect(Collectors.toList());
    }

    public BusinessObjectService getBusinessObjectService() {
        if (businessObjectService == null) {
            businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        }

        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
}
