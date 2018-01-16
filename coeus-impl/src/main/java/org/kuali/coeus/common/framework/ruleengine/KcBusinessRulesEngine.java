/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.ruleengine;

import java.lang.reflect.Method;

/**
 * Event based business rules engine. Each rule and event must be registered with this
 * class prior to being called.
 */
public interface KcBusinessRulesEngine {

	/**
	 * Using the events class type, applyRules determines and executes all registered rule methods and returns
	 * a single boolean result which is the ANDing of all method return values.
	 * @param event
	 * @return
	 */
	public Boolean applyRules(Object event);
	
	/**
	 * Similar to {@link #applyRules(Object)} but returns a single KcEventResult containing
	 * the success of all associated rules and all messages and audit results.
	 * @param event
	 * @return
	 */
	public KcEventResult applyRulesWithResult(Object event);
	
	/**
	 * A class with methods annotated with KcEventMethod and accepting a KcEvent will
	 * be automatically registered with this engine.
	 * @param businessRuleClass
	 */
	public void registerBusinessRuleClass(String ruleName, Object businessRuleClass);
	
	/**
	 * Register the rule method with the eventName provided.
	 * @param eventName
	 * @param rule
	 * @param method
	 */
	public void registerEvent(String ruleName, Object rule, Method method);
}
