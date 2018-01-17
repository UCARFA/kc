/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;

import org.kuali.coeus.common.framework.ruleengine.KcEventBase;

public class BudgetAuditEvent extends KcEventBase {

	public static final String EVENT_NAME = "KC-B:budgetAuditEvent";
	
	private Budget budget;
	
	public BudgetAuditEvent(Budget budget) {
		super(EVENT_NAME);
		this.budget = budget;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
}
