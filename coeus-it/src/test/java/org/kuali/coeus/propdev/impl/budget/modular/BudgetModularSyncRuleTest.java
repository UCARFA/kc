/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.modular;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.common.framework.ruleengine.KcBusinessRulesEngine;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

public class BudgetModularSyncRuleTest extends KcIntegrationTestBase {
	
	public KcBusinessRulesEngine rulesEngine;
	
	@Before
	public void init() {
		rulesEngine = KcServiceLocator.getService(KcBusinessRulesEngine.class);
	}
	
	@Test
	public void testBudgetSyncModularNoPeriods() {
		ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
		assertFalse(rulesEngine.applyRules(new SyncModularBudgetKcEvent(budget)));
	}
	
	@Test
	public void testBudgetSyncModularEmptyPeriod() {
		ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
		budget.add(new BudgetPeriod());
		assertFalse(rulesEngine.applyRules(new SyncModularBudgetKcEvent(budget)));
	}
	
	@Test
	public void testBudgetSyncModularPeriodWithLineItem() {
		ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
		budget.add(new BudgetPeriod());
		budget.getBudgetPeriod(0).getBudgetLineItems().add(new BudgetLineItem());
		assertTrue(rulesEngine.applyRules(new SyncModularBudgetKcEvent(budget)));
	}
}
