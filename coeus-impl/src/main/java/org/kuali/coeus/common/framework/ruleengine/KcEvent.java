/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.ruleengine;

/**
 * KcEvents are used to pass data to KcBusinessRule classes declaring
 * KcEventMethod methods. Eventname is required as this is the key
 * to determine what rules to execute.
 */
public interface KcEvent {

	/**
	 * The events name that will be used to register rules and
	 * later determine which rules to be run. Should be namespaced in
	 * some fashion to avoid conflicts. Similar to KC-PD:saveDocument or
	 * KC-B:addPeriod
	 */
	public String getEventName();
}
