/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.lookup;

import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.core.api.encryption.EncryptionService;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kns.lookup.KualiLookupableHelperServiceImpl;
import org.kuali.rice.kns.lookup.LookupResultsService;
import org.kuali.rice.kns.service.BusinessObjectDictionaryService;
import org.kuali.rice.kns.service.BusinessObjectMetaDataService;
import org.kuali.rice.kns.service.MaintenanceDocumentDictionaryService;
import org.kuali.rice.krad.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * This is a convenient abstract class that autowires all the dependencies in the parent classes.
 */
public abstract class KcKualiLookupableHelperServiceImpl extends KualiLookupableHelperServiceImpl {

    @Autowired
    @Qualifier("businessObjectDictionaryService")
    @Override
    public void setBusinessObjectDictionaryService(BusinessObjectDictionaryService businessObjectDictionaryService) {
        super.setBusinessObjectDictionaryService(businessObjectDictionaryService);
    }

    @Autowired
    @Qualifier("businessObjectService")
    @Override
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        super.setBusinessObjectService(businessObjectService);
    }

    @Autowired
    @Qualifier("businessObjectMetaDataService")
    @Override
    public void setBusinessObjectMetaDataService(BusinessObjectMetaDataService businessObjectMetaDataService) {
        super.setBusinessObjectMetaDataService(businessObjectMetaDataService);
    }

    @Autowired
    @Qualifier("dataDictionaryService")
    @Override
    public void setDataDictionaryService(DataDictionaryService dataDictionaryService) {
        super.setDataDictionaryService(dataDictionaryService);
    }

    @Autowired
    @Qualifier("encryptionService")
    @Override
    public void setEncryptionService(EncryptionService encryptionService) {
        super.setEncryptionService(encryptionService);
    }

    @Autowired
    @Qualifier("lookupResultsService")
    @Override
    public void setLookupResultsService(LookupResultsService lookupResultsService) {
        super.setLookupResultsService(lookupResultsService);
    }

    @Autowired
    @Qualifier("lookupService")
    @Override
    public void setLookupService(LookupService lookupService) {
        super.setLookupService(lookupService);
    }

    @Autowired
    @Qualifier("persistenceStructureService")
    @Override
    public void setPersistenceStructureService(PersistenceStructureService persistenceStructureService) {
        super.setPersistenceStructureService(persistenceStructureService);
    }

    @Autowired
    @Qualifier("sequenceAccessorService")
    @Override
    public void setSequenceAccessorService(SequenceAccessorService sequenceAccessorService) {
        super.setSequenceAccessorService(sequenceAccessorService);
    }

    @Autowired
    @Qualifier("maintenanceDocumentDictionaryService")
    @Override
    public void setMaintenanceDocumentDictionaryService(MaintenanceDocumentDictionaryService maintenanceDocumentDictionaryService) {
        super.setMaintenanceDocumentDictionaryService(maintenanceDocumentDictionaryService);
    }

    @Autowired
    @Qualifier("kualiConfigurationService")
    @Override
    public void setParameterService(ConfigurationService configurationService) {
        super.setParameterService(configurationService);
    }

    @Autowired
    @Qualifier("parameterService")
    @Override
    public void setParameterService(ParameterService parameterService) {
        super.setParameterService(parameterService);
    }
}
