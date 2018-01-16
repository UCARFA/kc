/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.controller.rest.audit;

import java.util.List;

import org.kuali.coeus.sys.framework.controller.rest.RestBeanWrapperFactory;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLogger;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLoggerDao;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLoggerFactory;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("restAuditLoggerFactory")
public class RestAuditLoggerFactoryImpl implements RestAuditLoggerFactory {

	@Autowired
	@Qualifier("restAuditLoggerDao")
	private RestAuditLoggerDao restAuditLoggerDao;
	
	@Autowired
	@Qualifier("globalVariableService")
	private GlobalVariableService globalVariableService;

	@Autowired
	@Qualifier("restBeanWrapperFactory")
	private RestBeanWrapperFactory restBeanWrapperFactory;
	
	@Override
	public RestAuditLogger getNewAuditLogger(Class<?> dataObjectClass, List<String> propertiesToLog) {
		return new RestAuditLoggerImpl(globalVariableService.getUserSession().getPrincipalName(),
				dataObjectClass, propertiesToLog, restAuditLoggerDao, restBeanWrapperFactory);
	}

	public RestAuditLoggerDao getRestAuditLoggerDao() {
		return restAuditLoggerDao;
	}

	public void setRestAuditLoggerDao(RestAuditLoggerDao restAuditLoggerDao) {
		this.restAuditLoggerDao = restAuditLoggerDao;
	}

	public GlobalVariableService getGlobalVariableService() {
		return globalVariableService;
	}

	public void setGlobalVariableService(GlobalVariableService globalVariableService) {
		this.globalVariableService = globalVariableService;
	}

	public RestBeanWrapperFactory getRestBeanWrapperFactory() {
		return restBeanWrapperFactory;
	}

	public void setRestBeanWrapperFactory(RestBeanWrapperFactory restBeanWrapperFactory) {
		this.restBeanWrapperFactory = restBeanWrapperFactory;
	}
}
