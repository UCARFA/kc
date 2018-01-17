/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.award;

import org.kuali.kra.external.award.impl.AccountCreationClientImpl;
import org.kuali.kra.external.award.impl.AccountCreationKSBClientImpl;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;
import org.springframework.beans.factory.FactoryBean;

public class AccountCreationClientFactoryBean implements FactoryBean<AccountCreationClient> {

	private boolean sharedRice;
	private DocumentService documentService;
    private BusinessObjectService businessObjectService;
    private ParameterService parameterService;
    private ConfigurationService configurationService;

    @Override
	public AccountCreationClient getObject() throws Exception {
	    final AccountCreationClient object;
		if(sharedRice) {
            object = (AccountCreationKSBClientImpl.getInstance());
        } else {
            object = (AccountCreationClientImpl.getInstance());
        }
		object.setDocumentService(documentService);
		object.setBusinessObjectService(businessObjectService);
        object.setParameterService(parameterService);
        object.setConfigurationService(configurationService);

		return object;
	}

    @Override
	public Class<? extends AccountCreationClient> getObjectType() {
		return AccountCreationClient.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

    public boolean isSharedRice() {
        return sharedRice;
    }

    public void setSharedRice(boolean sharedRice) {
        this.sharedRice = sharedRice;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    
    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }
}
