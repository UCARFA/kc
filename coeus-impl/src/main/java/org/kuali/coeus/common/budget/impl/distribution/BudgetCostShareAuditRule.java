/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.distribution;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetAuditEvent;
import org.kuali.coeus.common.budget.framework.core.BudgetConstants;
import org.kuali.coeus.common.budget.framework.core.BudgetAuditRuleEvent;
import org.kuali.coeus.common.budget.framework.distribution.BudgetCostShare;
import org.kuali.coeus.common.framework.costshare.CostShareRuleResearchDocumentBase;
import org.kuali.coeus.common.framework.ruleengine.KcBusinessRule;
import org.kuali.coeus.common.framework.ruleengine.KcEventMethod;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;

import java.util.ArrayList;
import java.util.List;

import static org.kuali.rice.krad.util.GlobalVariables.getAuditErrorMap;


@KcBusinessRule("budgetCostShareAuditRule")
public class BudgetCostShareAuditRule extends CostShareRuleResearchDocumentBase {
    public static final String BUDGET_COST_SHARE_ERROR_KEY = "budgetCostShareAuditErrors";

    private static final String[] PARAMS = { "Cost Sharing" };

    @KcEventMethod
    public boolean processCostShareAuditRules(BudgetAuditEvent event) {
        Budget budget = event.getBudget();

        // Returns if cost sharing is not applicable
        if (!budget.isCostSharingApplicable()) {
            return true;
        }

        List<BudgetCostShare> costShares = budget.getBudgetCostShares();
        boolean retval = true;

        // Forces full allocation of cost sharing
        if (budget.getUnallocatedCostSharing().isNonZero() && budget.isCostSharingEnforced()) {
            retval = false;
            if (costShares.size() == 0) {
                getAuditErrors(BUDGET_COST_SHARE_ERROR_KEY, Constants.BUDGET_COST_SHARE_PANEL_NAME)
                        .add(
                                new AuditError("document.budget.budgetCostShare",
                                    KeyConstants.AUDIT_ERROR_BUDGET_DISTRIBUTION_UNALLOCATED_NOT_ZERO,
                                    Constants.BUDGET_DISTRIBUTION_AND_INCOME_PAGE + "." + Constants.BUDGET_COST_SHARE_PANEL_ANCHOR,
                                        PARAMS));

            }
            getAuditErrors(BUDGET_COST_SHARE_ERROR_KEY, Constants.BUDGET_COST_SHARE_PANEL_NAME)
                    .add(
                            new AuditError("document.budget.budgetCostShare",
                                KeyConstants.AUDIT_ERROR_BUDGET_DISTRIBUTION_UNALLOCATED_NOT_ZERO,
                                Constants.BUDGET_DISTRIBUTION_AND_INCOME_PAGE + "." + Constants.BUDGET_COST_SHARE_PANEL_ANCHOR,
                                    PARAMS));
        }

        int i = 0;
        // Forces inclusion of source account
        for (BudgetCostShare costShare : costShares) {
            String source = costShare.getSourceAccount();
            Integer fiscalYear = costShare.getProjectPeriod();
            if (null == source || source.length() == 0) {
                retval = false;
                getAuditErrors(BUDGET_COST_SHARE_ERROR_KEY, Constants.BUDGET_COST_SHARE_PANEL_NAME)
                        .add(
                                new AuditError("document.budget.budgetCostShares[" + i + "].sourceAccount",
                                    KeyConstants.AUDIT_ERROR_BUDGET_DISTRIBUTION_SOURCE_MISSING,
                                    Constants.BUDGET_DISTRIBUTION_AND_INCOME_PAGE + "." + Constants.BUDGET_COST_SHARE_PANEL_ANCHOR,
                                        getParamsForMissingSourceEntry(i)));
            }
            int numberOfProjectPeriods = -1;
            if (budget.getBudgetPeriods() != null) {
                numberOfProjectPeriods = budget.getBudgetPeriods().size();
            }
            validateProjectPeriod(fiscalYear, "document.budget.budgetCostShares[" + i + "].projectPeriod", numberOfProjectPeriods);
            if (getCostShareService().validateProjectPeriodAsProjectPeriod()) {
                List<AuditError> errors = new ArrayList<>();
                validatePeriodNumber(costShare, "document.budget.budgetCostShares[" + i + "].projectPeriod", numberOfProjectPeriods, errors);
                if (!errors.isEmpty()) {
                    getAuditErrors(BUDGET_COST_SHARE_ERROR_KEY, Constants.BUDGET_COST_SHARE_PANEL_NAME).addAll(errors);
                }
            }
            i++;
        }
        return retval;
    }

    @KcEventMethod
    public boolean processCostShareAuditRules(BudgetAuditRuleEvent event) {
        Budget budget = event.getBudget();
        boolean retval = true;
        if (budget.isCostSharingApplicable() && budget.isCostSharingEnforced()) {
            List<BudgetCostShare> costShares = budget.getBudgetCostShares();
            retval &= verifyCostSharingAllocation(budget, costShares);
            retval &= verifySourceAccount(budget, costShares);
        }
        return retval;
    }
    
    protected boolean verifySourceAccount(Budget budget, List<BudgetCostShare> costShares) {
        BudgetConstants.BudgetAuditRules budgetCostSharingRule = BudgetConstants.BudgetAuditRules.COST_SHARING;

        boolean isValid = true;
        // Forces inclusion of source account
        for (int i = 0; i < costShares.size(); i++) {
            BudgetCostShare costShare = costShares.get(i);
            String source = costShare.getSourceAccount();
            Integer fiscalYear = costShare.getProjectPeriod();
            if (StringUtils.isEmpty(source) || source.length() == 0) {
                getAuditErrors(budgetCostSharingRule.getErrorKey(), budgetCostSharingRule.getLabel()).add(new AuditError(budgetCostSharingRule.getPageId(),
                                    KeyConstants.AUDIT_ERROR_BUDGET_DISTRIBUTION_SOURCE_MISSING,
                                    budgetCostSharingRule.getPageId(), getParamsForMissingSourceEntry(i)));
                isValid = false;
            }
            int numberOfProjectPeriods = budget.getBudgetPeriods() != null ? budget.getBudgetPeriods().size() : -1;
            validateProjectPeriod(fiscalYear, budgetCostSharingRule.getPageId(), numberOfProjectPeriods);
            if (getCostShareService().validateProjectPeriodAsProjectPeriod()) {
                isValid &= verifyPeriodNumber(costShare, budgetCostSharingRule.getPageId(), numberOfProjectPeriods);
            }
        }
        return isValid;
    }
    
    public boolean verifyPeriodNumber(BudgetCostShare costShare, String projectPeriodField, int numberOfProjectPeriods) {
        int projectPeriodInt = Integer.parseInt(costShare.getProjectPeriod().toString().trim());
        BudgetConstants.BudgetAuditRules budgetCostSharingRule = BudgetConstants.BudgetAuditRules.COST_SHARING;
       if (projectPeriodInt <= 0 || projectPeriodInt > numberOfProjectPeriods) {
            AuditError auditError = new AuditError(projectPeriodField, KeyConstants.ERROR_PROJECT_PERIOD_RANGE,
                    Constants.BUDGET_DISTRIBUTION_AND_INCOME_PAGE + "." + Constants.BUDGET_COST_SHARE_PANEL_ANCHOR,
                    new String[] {Integer.toString(projectPeriodInt), Integer.toString(numberOfProjectPeriods), Integer.toString(numberOfProjectPeriods)});
            getAuditErrors(budgetCostSharingRule.getErrorKey(), budgetCostSharingRule.getLabel()).add(auditError);
            return false;
        }
        return true;
    }
    
    protected boolean verifyCostSharingAllocation(Budget budget, List<BudgetCostShare> costShares) {
        BudgetConstants.BudgetAuditRules budgetCostSharingRule = BudgetConstants.BudgetAuditRules.COST_SHARING;
        // Forces full allocation of cost sharing
        if (budget.getUnallocatedCostSharing().isNonZero()) {
            if (costShares.isEmpty()) {
                getAuditErrors(budgetCostSharingRule.getErrorKey(), budgetCostSharingRule.getLabel()).add(new AuditError("budget.budgetCostShare", 
                		KeyConstants.AUDIT_ERROR_BUDGET_DISTRIBUTION_UNALLOCATED_NOT_ZERO, budgetCostSharingRule.getPageId(), PARAMS));
            }else {
                for (int i = 0; i < costShares.size(); i++) {
                    getAuditErrors(budgetCostSharingRule.getErrorKey(), budgetCostSharingRule.getLabel()).add(new AuditError("budget.budgetCostShares[" + i + "].shareAmount",
                                        KeyConstants.AUDIT_ERROR_BUDGET_DISTRIBUTION_UNALLOCATED_NOT_ZERO,
                                        budgetCostSharingRule.getPageId(), PARAMS));
                }
            }
            return false;
        }
        return true;
    }

    private String[] getParamsForMissingSourceEntry(int i) {
        return new String[] { String.format("%s entry #%d", PARAMS[0], i + 1) };
    }

    /**
     * This method is a convenience method for obtaining audit errors.
     * 
     * @return List of AuditError instances
     */
    private List<AuditError> getAuditErrors(String costShareKey, String costShareLabel) {
        return getAuditProblems(Constants.AUDIT_ERRORS, costShareKey, costShareLabel);
    }

    /**
     * This method is a convenience method for obtaining audit warnings.
     * 
     * @return List of AuditError instances
     */
    private List<AuditError> getAuditWarnings(String costShareKey, String costShareLabel) {
        return getAuditProblems(Constants.AUDIT_WARNINGS, costShareKey, costShareLabel);
    }

    /**
     * This method should only be called if an audit error is intending to be added because it will actually add a
     * <code>{@link List&lt;AuditError&gt;}</code> to the auditErrorMap.
     * 
     * @return List of AuditError instances
     */
    private List<AuditError> getAuditProblems(String problemType, String costShareKey, String costShareLabel) {
        List<AuditError> auditErrors = new ArrayList<>();
        if (!getAuditErrorMap().containsKey(costShareKey)) {
            getAuditErrorMap().put(costShareKey,
                    new AuditCluster(costShareLabel, auditErrors, problemType));
        }else {
            auditErrors = getAuditErrorMap().get(costShareKey).getAuditErrorList();
        }

        return auditErrors;
    }

}
