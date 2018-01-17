/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;


public class BudgetSaveEvent extends BudgetEventBase {

	public BudgetSaveEvent(Budget budget) {
		super(budget);
	}
	
	public BudgetSaveEvent(Budget budget, String path) {
		super(budget, path);
	}
}
