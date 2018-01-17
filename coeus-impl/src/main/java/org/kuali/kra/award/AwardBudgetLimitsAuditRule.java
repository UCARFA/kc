/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.DocumentAuditRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Checks the budget limits on the Budgets tab to make sure they are valid.
 */
public class AwardBudgetLimitsAuditRule implements DocumentAuditRule {

    protected String AWARD_BUDGET_LIMITS_AUDIT_ERRORS = "awardBudgetLimitAuditErrors";
    
    @Override
    @SuppressWarnings("unchecked")
    public boolean processRunAuditBusinessRules(Document document) {
        boolean result = true;
        Award award = ((AwardDocument) document).getAward();
        List<AuditError> auditWarnings = new ArrayList<AuditError>(); 
        if (award.getTotalCostBudgetLimit() != null) {
            if (!award.getTotalCostBudgetLimit().equals(award.getObligatedDistributableTotal())) {
                result = false;
                auditWarnings.add(new AuditError("document.award.totalCostBudgetLimit.limit",
                        KeyConstants.WARNING_AWARD_BUDGET_COSTLIMIT_NOTEQUAL_OBLIGATED,
                        Constants.MAPPING_AWARD_BUDGET_VERSIONS_PAGE + "." + "BudgetLimits",
                        new String[]{award.getAwardNumber()}));                
            }
        }
        reportAndCreateAuditCluster(auditWarnings);
        return result;
    }
    
    /**
     * This method creates and adds the AuditCluster to the Global AuditErrorMap.
     */
    @SuppressWarnings("unchecked")
    protected void reportAndCreateAuditCluster( List<AuditError> auditErrors ) {
        if (auditErrors.size() > 0) {
            GlobalVariables.getAuditErrorMap().put(AWARD_BUDGET_LIMITS_AUDIT_ERRORS, new AuditCluster("Budget Limits",
                                                                                          auditErrors, Constants.AUDIT_WARNINGS));
        }
    }
}
