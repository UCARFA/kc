/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.institutionalproposal.service.impl;

import org.kuali.coeus.common.budget.framework.core.CostShare;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.budget.AwardBudgetService;
import org.kuali.kra.institutionalproposal.service.InstitutionalProposalBudgetService;

public class InstitutionalProposalBudgetServiceImpl implements InstitutionalProposalBudgetService {


    private GlobalVariableService globalVariableService;
    private AwardBudgetService awardBudgetService;

    // This cannot be injected with Spring because Award loads after IP
    public AwardBudgetService getAwardBudgetService() {
        if (awardBudgetService == null) {
            awardBudgetService = KcServiceLocator.getService(AwardBudgetService.class);
        }
        return awardBudgetService;
    }

    @Override
    public boolean isValidSourceAccountCostShareType(String validationMessageType, CostShare budgetCostShare, String costShareField) {
        return getAwardBudgetService().isValidSourceAccountCostShareType(validationMessageType, budgetCostShare, costShareField);
    }

    public void setGlobalVariableService(GlobalVariableService globalVariableService) {
        this.globalVariableService = globalVariableService;
    }

    public GlobalVariableService getGlobalVariableService() {
        return globalVariableService;
    }

}
