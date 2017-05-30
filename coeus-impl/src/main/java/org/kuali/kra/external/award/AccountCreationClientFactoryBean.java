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
