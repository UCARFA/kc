/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.budget.AwardBudgetService;
import org.kuali.kra.award.home.Award;
import org.kuali.coeus.propdev.impl.budget.ProposalBudgetService;

/**
 * Creates a BudgetCommonService instance.
 */
public final class BudgetCommonServiceFactory {
    
    private BudgetCommonServiceFactory() {
        throw new UnsupportedOperationException("do not instantiate");
    }
    
    /**
     * Creates an instance of BudgetCommonService by looking at the classname.
     * @return
     */
    public static BudgetCommonService createInstance(BudgetParent parentBudget) {
        if (parentBudget.getClass().equals(Award.class)) {
            return KcServiceLocator.getService(AwardBudgetService.class);
        } else {
            return KcServiceLocator.getService(ProposalBudgetService.class);
        }
    }

}
