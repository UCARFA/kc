/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.subaward;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.ruleengine.KcBusinessRulesEngine;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

public class BudgetSubAwardsRuleTest extends KcIntegrationTestBase {

	public KcBusinessRulesEngine kcBusinessRuleEngine;
	
	@Before
	public void setup() {
		kcBusinessRuleEngine = KcServiceLocator.getService(KcBusinessRulesEngine.class);
	}
	
	@Test
	public void testRunningBudgetSubAwardsRule() {
		BudgetSubAwards subAward = new BudgetSubAwards();
		subAward.setSubAwardXmlFileData("123");
		kcBusinessRuleEngine.applyRules(new BudgetSubAwardsEvent(subAward, new ProposalDevelopmentBudgetExt(), ""));
	}

	public KcBusinessRulesEngine getKcBusinessRuleEngine() {
		return kcBusinessRuleEngine;
	}

	public void setKcBusinessRuleEngine(KcBusinessRulesEngine kcBusinessRuleEngine) {
		this.kcBusinessRuleEngine = kcBusinessRuleEngine;
	}
}
