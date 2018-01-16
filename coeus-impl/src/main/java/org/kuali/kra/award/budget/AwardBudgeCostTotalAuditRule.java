/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;

import org.kuali.kra.award.budget.document.AwardBudgetDocument;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.DocumentAuditRule;

import java.util.ArrayList;
import java.util.List;

import static org.kuali.rice.krad.util.GlobalVariables.getAuditErrorMap;

public class AwardBudgeCostTotalAuditRule implements DocumentAuditRule {
    public static final String AWARD_BUDGET_TOTAL_COST_ERROR_KEY = "awardBudgetTotalCostAuditErrors";

    @Override
    public boolean processRunAuditBusinessRules(Document document) {
        AwardBudgetExt budget = (AwardBudgetExt)((AwardBudgetDocument)document).getBudget();
        
        boolean valid = true;
        String[] params = { "Budget Overview Cost Total" };
        if (!budget.getTotalCost().equals(budget.getTotalCostLimit())) {
            getAuditErrors().add(new AuditError("document.budget.totalCost",
                    KeyConstants.AUDIT_ERROR_TOTAL_COST,
                    Constants.BUDGET_PERIOD_PAGE + "." + "BudgetPeriodsTotals",
                    params));
            valid = false;
        }

        return valid;
    }
    
    /**
     * This method is a convenience method for obtaining audit errors.
     * @return List of AuditError instances
     */    
    private List<AuditError> getAuditErrors() {
        return getAuditProblems(Constants.AUDIT_ERRORS);
    }
    
    
    /**
     * This method should only be called if an audit error is intending to be added because it will actually 
     * add a <code>{@link List&lt;AuditError&gt;}</code> to the auditErrorMap.
     * @return List of AuditError instances
     */
    private List<AuditError> getAuditProblems(String problemType) {
        List<AuditError> auditErrors = new ArrayList<AuditError>();
        
        if (!getAuditErrorMap().containsKey(AWARD_BUDGET_TOTAL_COST_ERROR_KEY)) {
            getAuditErrorMap().put(AWARD_BUDGET_TOTAL_COST_ERROR_KEY, new AuditCluster(Constants.BUDGET_PERIOD_PANEL_NAME, auditErrors, problemType));
        }
        else {
            auditErrors = ((AuditCluster) getAuditErrorMap().get(AWARD_BUDGET_TOTAL_COST_ERROR_KEY)).getAuditErrorList();
        }
        
        return auditErrors;
    }



}
