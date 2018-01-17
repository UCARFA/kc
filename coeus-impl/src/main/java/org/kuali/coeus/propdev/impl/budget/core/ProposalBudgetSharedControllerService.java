/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.core;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.rice.krad.document.authorization.PessimisticLock;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.springframework.web.servlet.ModelAndView;

public interface ProposalBudgetSharedControllerService {
	public ModelAndView addBudget(String budgetName, Boolean summaryBudget, Boolean modularBudget, DevelopmentProposal developmentProposal, UifFormBase form) throws Exception;
	public ModelAndView copyBudget(String budgetName, Long originalBudgetId, Boolean allPeriods, DevelopmentProposal developmentProposal, UifFormBase form) throws Exception;
	public ModelAndView openBudget(String budgetId, boolean viewOnly, UifFormBase form) throws Exception;
    public boolean isAllowedToCompleteBudget(ProposalDevelopmentBudgetExt budget, String errorPath);
    public boolean isBudgetLocked(int budgetVersion, List<PessimisticLock> locks, String errorPath);
    public ProposalDevelopmentBudgetExt getSelectedBudget(Long budgetId, List<ProposalDevelopmentBudgetExt> budgets);
    public void markBudgetVersionStatus(ProposalDevelopmentBudgetExt budget, String status);
	public <T extends UifFormBase & SelectableBudget> ModelAndView populateBudgetSummary(Long budgetId, List<ProposalDevelopmentBudgetExt> budgets, T form) throws Exception;
	public <T extends UifFormBase & SelectableBudget> ModelAndView populatePrintForms(Long budgetId, List<ProposalDevelopmentBudgetExt> budgets, T form) throws Exception;
	public <T extends UifFormBase & SelectableBudget> ModelAndView printBudgetForms(ProposalDevelopmentBudgetExt selectedBudget, T form, HttpServletResponse response) throws Exception;
}
