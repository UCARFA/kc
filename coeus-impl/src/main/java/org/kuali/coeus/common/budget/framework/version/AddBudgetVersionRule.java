/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.version;

import org.kuali.coeus.common.budget.framework.core.BudgetDocumentRule;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * A composited rule of the {@link BudgetDocumentRule}. It is expected that the {@link BudgetDocumentRule} will call this rule directly on save,
 * so it does not use or require an event.
 * 
 **/
public interface AddBudgetVersionRule  extends BusinessRule {

    /**
     * Entry method for the business rule. 
     *
     * @param event The {@link org.kuali.coeus.common.budget.framework.version.AddBudgetVersionEvent} triggering the rule
     * @return true if it passed, false if it failed
     */
    public boolean processAddBudgetVersionName(AddBudgetVersionEvent event);
    
    public boolean processAddBudgetVersion(AddBudgetVersionEvent event) throws WorkflowException;
    
 }
