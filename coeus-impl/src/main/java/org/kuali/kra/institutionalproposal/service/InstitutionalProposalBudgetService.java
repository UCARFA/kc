package org.kuali.kra.institutionalproposal.service;


import org.kuali.coeus.common.budget.framework.core.CostShare;

public interface InstitutionalProposalBudgetService {

    boolean isValidSourceAccountCostShareType(String validationMessageType, CostShare budgetCostShare, String costShareField);

}
