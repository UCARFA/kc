/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget.document;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetDocumentRule;
import org.kuali.coeus.common.budget.framework.distribution.BudgetCostShare;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.KRADConstants;

public class AwardBudgetDocumentRule extends BudgetDocumentRule {

    @Override
    protected boolean processCustomSaveDocumentBusinessRules(Document document) {
        boolean valid = Boolean.TRUE;
        Budget budget = ((AwardBudgetDocument) document).getBudget();
        for (BudgetCostShare budgetCostShare : budget.getBudgetCostShares()) {
            if (budgetCostShare.getUnitNumber() != null) {
                valid &= validateUnit(budgetCostShare.getUnitNumber(), KRADConstants.GLOBAL_ERRORS);
            }
        }

        return valid && super.processCustomSaveDocumentBusinessRules(document);
    }
}
