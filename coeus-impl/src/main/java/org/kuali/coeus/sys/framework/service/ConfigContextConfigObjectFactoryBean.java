/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.service;

import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.core.api.config.ConfigurationException;
import org.kuali.rice.core.api.config.property.ConfigContext;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Exports services in the {@link org.kuali.rice.core.api.config.property.ConfigContext#getCurrentContextConfig()} as beans available to Spring.
 *
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public class ConfigContextConfigObjectFactoryBean implements FactoryBean<Object>, InitializingBean {

	private String objectName;
	private boolean singleton;
	private boolean mustExist;

	public ConfigContextConfigObjectFactoryBean() {
		this.mustExist = true;
	}

	@Override
    public Object getObject() throws Exception {
		Object o =  ConfigContext.getCurrentContextConfig().getObject(this.getObjectName());

		if (mustExist && o == null) {
			throw new IllegalStateException("Service must exist and no service could be located with name='" + this.getObjectName() + "'");
		}

		return o;
	}

    @Override
    public Class<?> getObjectType() {
        if (getObjectName() == null) {
            return null;
        } else {
            try {
                // getObject throws java.lang.Exception
                return getObject().getClass();
            } catch (Exception e) {
                return null;
            }
        }
    }

	@Override
    public boolean isSingleton() {
		return singleton;
	}

    public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}

	public boolean isMustExist() {
		return mustExist;
	}

	public void setMustExist(boolean mustExist) {
		this.mustExist = mustExist;
	}

	@Override
    public void afterPropertiesSet() throws Exception {
		if (StringUtils.isBlank(this.getObjectName())) {
			throw new ConfigurationException("No objectName given.");
		}
	}

}
