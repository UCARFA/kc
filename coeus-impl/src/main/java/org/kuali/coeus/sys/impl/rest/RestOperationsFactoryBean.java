/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.rest;

import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.web.client.RestOperations;

public class RestOperationsFactoryBean implements FactoryBean<RestOperations> {
	
	private static final String TRUST_SELFSIGNED_CONFIG = "kc.rest.ssl.trust.selfsigned";

	private ConfigurationService configurationService;
	private RestOperations restOperations;
	private RestOperations devRestOperations;

	@Override
	public RestOperations getObject() throws Exception {
		if (trustSelfSignedCerts()) {
			return devRestOperations;
		} else {
			return restOperations;
		}
		
	}

	protected boolean trustSelfSignedCerts() {
		return configurationService.getPropertyValueAsBoolean(TRUST_SELFSIGNED_CONFIG);
	}

	@Override
	public Class<? extends RestOperations> getObjectType() {
		return RestOperations.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public ConfigurationService getConfigurationService() {
		return configurationService;
	}

	public void setConfigurationService(ConfigurationService configurationService) {
		this.configurationService = configurationService;
	}

	public RestOperations getRestOperations() {
		return restOperations;
	}

	public void setRestOperations(RestOperations restOperations) {
		this.restOperations = restOperations;
	}

	public RestOperations getDevRestOperations() {
		return devRestOperations;
	}

	public void setDevRestOperations(RestOperations devRestOperations) {
		this.devRestOperations = devRestOperations;
	}
}
