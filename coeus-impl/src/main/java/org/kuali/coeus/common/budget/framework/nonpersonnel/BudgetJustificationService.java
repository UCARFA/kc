/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.nonpersonnel;

import org.kuali.coeus.common.budget.framework.core.BudgetException;
import org.kuali.coeus.common.budget.framework.core.Budget;

public interface BudgetJustificationService {

    public void consolidateExpenseJustifications(Budget budget, BudgetJustificationWrapper budgetJustificationWrapper) throws BudgetException;
    
    public void preSave(Budget budget, BudgetJustificationWrapper budgetJustificationWrapper);
  
}
