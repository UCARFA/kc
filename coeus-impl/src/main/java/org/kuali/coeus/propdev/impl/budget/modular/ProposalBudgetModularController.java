/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.budget.modular;


import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetControllerBase;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetForm;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetSharedControllerService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProposalBudgetModularController extends ProposalBudgetControllerBase  {

    @Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService;

    @Transactional @RequestMapping(value = "/proposalBudget", params={"methodToCall=navigate", "actionParameters[navigateToPageId]=PropBudget-ModularPage"})
    public ModelAndView navigateToModular(@ModelAttribute("KualiForm") ProposalBudgetForm form) throws Exception {
        Budget budget = form.getBudget();
        for (BudgetPeriod budgetPeriod: budget.getBudgetPeriods()){
            if (budgetPeriod.getBudgetModular() == null)
                getBudgetModularService().generateModularPeriod(budgetPeriod);
        }
        form.setBudgetModularSummary(getBudgetModularService().processModularSummary(budget,true));
        return super.navigate(form);
    }

    @Transactional @RequestMapping(value = "/proposalBudget", params={"methodToCall=synchModular"})
    public ModelAndView synchModular (@ModelAttribute("KualiForm") ProposalBudgetForm form)
            throws Exception{
        Budget budget = form.getBudget();
        getBudgetModularService().synchModularBudget(budget, false);
        form.setBudgetModularSummary(getBudgetModularService().processModularSummary(budget,true));
        super.saveBudget(form);
        return getRefreshControllerService().refresh(form);
    }

    @Transactional @RequestMapping(value = "/proposalBudget", params={"methodToCall=recalculateModular"})
    public ModelAndView recalculateModular (@ModelAttribute("KualiForm") ProposalBudgetForm form)
            throws Exception{
        Budget budget = form.getBudget();
        if (!roundFandAbase()) {
            for (BudgetPeriod budgetPeriod: budget.getBudgetPeriods()){
                getBudgetModularService().generateModularPeriod(budgetPeriod);
            }
        } else {
            getBudgetModularService().synchModularBudget(budget, true);
        }

        form.setBudgetModularSummary(getBudgetModularService().processModularSummary(budget,true));
        return getRefreshControllerService().refresh(form);
    }

    public boolean roundFandAbase() {
        return parameterService.getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT,
                ParameterConstants.DOCUMENT_COMPONENT,
                Constants.ROUND_F_AND_A_BASE);
    }

}
