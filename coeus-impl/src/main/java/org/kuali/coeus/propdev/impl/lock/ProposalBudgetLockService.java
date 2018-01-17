/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.lock;

import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;

public interface ProposalBudgetLockService {
    public void establishBudgetLock(ProposalDevelopmentBudgetExt budget);
    public void deleteBudgetLock(ProposalDevelopmentBudgetExt budget);
    public boolean doesBudgetVersionMatchDescriptor(String lockDescriptor, int budgetVersionNumber);
}
