/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.controller.rest.audit;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import org.kuali.coeus.sys.framework.controller.rest.RestBeanWrapperFactory;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLog;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLogger;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLoggerDao;
import org.kuali.coeus.sys.framework.util.CollectionUtils;
import org.springframework.beans.BeanWrapper;

public class RestAuditLoggerImpl implements RestAuditLogger {

	private final Class<?> dataObjectClass;
	private final List<String> propertiesToTrack;
	private RestAuditLog restAuditLog;
	private final RestAuditLoggerDao restAuditLoggerDao;
	private final RestBeanWrapperFactory restBeanWrapperFactory;

	public RestAuditLoggerImpl(String username, Class<?> dataObjectClass, List<String> propertiesToTrack,
			RestAuditLoggerDao restAuditLoggerDao, RestBeanWrapperFactory restBeanWrapperFactory) {
		this.dataObjectClass = dataObjectClass;
		this.propertiesToTrack = propertiesToTrack;
		this.restAuditLoggerDao = restAuditLoggerDao;
		this.restAuditLog = new RestAuditLog(username, dataObjectClass.getCanonicalName());
		this.restBeanWrapperFactory = restBeanWrapperFactory;
	}

	@Override
	public void addModifiedItem(Object currentItem, Object updatedItem) {
		restAuditLog.getModified().add(getUpdatedAuditLogItem(currentItem, updatedItem));
	}
	
	Map<String, Object> getUpdatedAuditLogItem(Object current, Object updated) {
		BeanWrapper currentBean = restBeanWrapperFactory.newInstance(current);
		currentBean.setAutoGrowNestedPaths(true);

		BeanWrapper updatedBean = restBeanWrapperFactory.newInstance(updated);
		updatedBean.setAutoGrowNestedPaths(true);

		return propertiesToTrack.stream()
			.map(name -> {
				final Object currentValue = currentBean.getPropertyValue(name);
				final Object newValue = updatedBean.getPropertyValue(name);
				if (areValuesEqual(currentValue, newValue)) {
					return CollectionUtils.entry(name, currentValue);
				} else {
					Map<String, Object> diffs = Stream.of(CollectionUtils.entry("old", currentValue), CollectionUtils.entry("new", newValue)).collect(CollectionUtils.nullSafeEntriesToMap());
					return CollectionUtils.entry(name, (Object) diffs);
				}
			})
			.collect(CollectionUtils.nullSafeEntriesToMap());
	}

	protected boolean areValuesEqual(Object currentValue, Object newValue) {
			return Objects.equals(currentValue, newValue);
	}

	@Override
	public void addNewItem(Object newItem) {
		restAuditLog.getAdded().add(getAuditLogItem(newItem));
	}
	
	Map<String, Object> getAuditLogItem(Object current) {
		final BeanWrapper currentBean = restBeanWrapperFactory.newInstance(current);
		currentBean.setAutoGrowNestedPaths(true);
		return propertiesToTrack.stream()
			.map(name -> CollectionUtils.entry(name, currentBean.getPropertyValue(name)))
			.collect(CollectionUtils.nullSafeEntriesToMap());
	}

	@Override
	public void addDeletedItem(Object deletedItem) {
		restAuditLog.getDeleted().add(getAuditLogItem(deletedItem));
	}

	@Override
	public void saveAuditLog() {
		restAuditLog.setDate(Instant.now());
		restAuditLoggerDao.saveAuditLog(dataObjectClass, restAuditLog);
		restAuditLog = new RestAuditLog(restAuditLog.getUsername(), dataObjectClass.getCanonicalName());
	}

	public Class<?> getDataObjectClass() {
		return dataObjectClass;
	}

	public List<String> getPropertiesToTrack() {
		return propertiesToTrack;
	}

	public RestAuditLog getRestAuditLog() {
		return restAuditLog;
	}

	public RestAuditLoggerDao getRestAuditLoggerDao() {
		return restAuditLoggerDao;
	}

	public RestBeanWrapperFactory getRestBeanWrapperFactory() {
		return restBeanWrapperFactory;
	}

}
