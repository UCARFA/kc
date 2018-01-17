/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.customercreation;

import org.kuali.coeus.common.framework.sponsor.Sponsor;
import org.kuali.kra.external.service.KcDtoService;
import org.kuali.kra.external.sponsor.SponsorDTO;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.springframework.beans.factory.FactoryBean;

public class CustomerCreationClientFactoryBean implements FactoryBean<CustomerCreationClient> {

	private boolean sharedRice;
	private ParameterService parameterService;
	private KcDtoService<SponsorDTO, Sponsor> sponsorDtoService;
    
	@Override
	public CustomerCreationClient getObject() throws Exception {
		final CustomerCreationClient object;
		if(sharedRice)
		    object = (CustomerCreationKSBClientImpl.getInstance());
		else
		    object = (CustomerCreationClientImpl.getInstance());

		object.setParameterService(parameterService);
        object.setSponsorDtoService(sponsorDtoService);

		return object;
	}

	@Override
	public Class<? extends CustomerCreationClient> getObjectType() {
		return CustomerCreationClient.class;
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
    
    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

	public KcDtoService<SponsorDTO, Sponsor> getSponsorDtoService() {
		return sponsorDtoService;
	}

	public void setSponsorDtoService(
			KcDtoService<SponsorDTO, Sponsor> sponsorDtoService) {
		this.sponsorDtoService = sponsorDtoService;
	}

	public ParameterService getParameterService() {
		return parameterService;
	}
}
