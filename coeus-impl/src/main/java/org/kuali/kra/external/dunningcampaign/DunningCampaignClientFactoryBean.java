/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.dunningcampaign;

import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.springframework.beans.factory.FactoryBean;

public class DunningCampaignClientFactoryBean implements FactoryBean<DunningCampaignClient> {

	private boolean sharedRice;
    private ParameterService parameterService;

    @Override
	public DunningCampaignClient getObject() throws Exception {
	    final DunningCampaignClient object;
		if(sharedRice)
		    object = (DunningCampaignKSBClientImpl.getInstance());
		else
		    object = (DunningCampaignClientImpl.getInstance());

        object.setParameterService(parameterService);

		return object;
	}

	@Override
	public Class<? extends DunningCampaignClient> getObjectType() {
		return DunningCampaignClient.class;
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
}
