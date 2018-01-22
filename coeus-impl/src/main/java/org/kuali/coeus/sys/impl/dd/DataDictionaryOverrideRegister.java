/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.impl.dd;


import org.kuali.coeus.sys.framework.dd.DataDictionaryOverride;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DataDictionaryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.util.InMemoryResource;

import java.util.Collections;
import java.util.List;

public class DataDictionaryOverrideRegister implements InitializingBean {

    private static final String ACTIVE = "active";
    private static final String ID = "id";
    private BusinessObjectService businessObjectService;
    private DataDictionaryService dataDictionaryService;

    @Override
    public void afterPropertiesSet() throws Exception {

        final List<String> previousLoadOrder = getDataDictionaryService().getDataDictionary().getModuleLoadOrder();
        if (!previousLoadOrder.contains(DataDictionaryOverrideConstants.OVERRIDE)) {
            previousLoadOrder.add(DataDictionaryOverrideConstants.OVERRIDE);
        }

        getBusinessObjectService().findMatchingOrderBy(DataDictionaryOverride.class, Collections.singletonMap(ACTIVE, true), ID, true).forEach(override ->
                getDataDictionaryService().getDataDictionary().addModuleDictionaryFile(DataDictionaryOverrideConstants.OVERRIDE,
                        new InMemoryResource(override.getAttachmentContent(), override.getId()))
        );
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public DataDictionaryService getDataDictionaryService() {
        return dataDictionaryService;
    }

    public void setDataDictionaryService(DataDictionaryService dataDictionaryService) {
        this.dataDictionaryService = dataDictionaryService;
    }
}
