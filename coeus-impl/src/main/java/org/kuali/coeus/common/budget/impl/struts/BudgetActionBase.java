/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.struts;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.propdev.impl.lock.ProposalLockService;
import org.kuali.coeus.sys.framework.controller.KcTransactionalDocumentActionBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.authorization.KraAuthorizationConstants;
import org.kuali.kra.award.budget.document.AwardBudgetDocument;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetCommonService;
import org.kuali.coeus.common.budget.framework.core.BudgetCommonServiceFactory;
import org.kuali.coeus.common.budget.framework.core.BudgetParent;
import org.kuali.coeus.common.budget.framework.core.BudgetParentDocument;
import org.kuali.coeus.common.budget.framework.core.BudgetVersionFormBase;
import org.kuali.coeus.common.framework.ruleengine.KcBusinessRulesEngine;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kns.util.WebUtils;
import org.kuali.rice.kns.web.struts.form.KualiForm;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.document.authorization.PessimisticLock;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.service.PessimisticLockService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * This class contains methods common to ProposalDevelopment and Budget actions.
 */
public class BudgetActionBase extends KcTransactionalDocumentActionBase {
    
	private KcBusinessRulesEngine kcBusinessRulesEngine;
	
    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        final BudgetVersionFormBase proposalForm = (BudgetVersionFormBase) form;
        ActionForward forward = super.save(mapping, form, request, response);
        
        return forward;
    }

    protected static final String COPY_BUDGET_PERIOD_QUESTION = "copyBudgetQuestion";
    protected static final String QUESTION_TYPE = "copyPeriodsQuestion";
    protected static final String QUESTION_TEXT = "A new version of the budget will be created based on version ";
    
    /**
     * Copy the given budget version and add it to the given proposal.
     *
     * @param copyPeriodOneOnly if only the first budget period is to be copied
     */
    protected void copyBudget(BudgetParentDocument budgetParentDocument, Budget budgetToCopy, boolean copyPeriodOneOnly) 
    throws WorkflowException {
        DocumentService documentService = KcServiceLocator.getService(DocumentService.class);
        AwardBudgetDocument budgetDocToCopy = (AwardBudgetDocument) documentService.getByDocumentHeaderId(budgetToCopy.getDocumentNumber());
        Budget budget = budgetDocToCopy.getBudget();
        BudgetCommonService<BudgetParent> budgetService = getBudgetCommonService(budget.getBudgetParent());
        Budget newBudget = budgetService.copyBudgetVersion(budget, copyPeriodOneOnly);
        newBudget.setNameUpdatable(true);
        newBudget.setName(budgetToCopy.getName() + " " + budgetToCopy.getBudgetVersionNumber() + " copy");
    }

    protected BudgetCommonService<BudgetParent> getBudgetCommonService(BudgetParent budgetParent) {
        return BudgetCommonServiceFactory.createInstance(budgetParent);
    }

    protected void populateTabState(KualiForm form, String tabTitle) {
        form.getTabStates().put(WebUtils.generateTabKey(tabTitle), "OPEN");
    }
    
    @Override
    protected PessimisticLockService getPessimisticLockService() {
        return KcServiceLocator.getService(ProposalLockService.class);
    }
    
    @Override
    protected void setupPessimisticLockMessages(Document document, HttpServletRequest request) {
        super.setupPessimisticLockMessages(document, request);
        List<String> lockMessages = (List<String>)request.getAttribute(KRADConstants.PESSIMISTIC_LOCK_MESSAGES);
        AwardBudgetDocument budgetDoc = (AwardBudgetDocument)document;
        for (PessimisticLock lock : budgetDoc.getBudget().getBudgetParent().getDocument().getPessimisticLocks()) {
            if (StringUtils.contains(lock.getLockDescriptor(), KraAuthorizationConstants.LOCK_DESCRIPTOR_BUDGET) 
                    && !lock.isOwnedByUser(GlobalVariables.getUserSession().getPerson())) {
                String message = generatePessimisticLockMessage(lock);
                if (!lockMessages.contains(message)) {
                    lockMessages.add(message);
                }
            }
        }
        request.setAttribute(KRADConstants.PESSIMISTIC_LOCK_MESSAGES, lockMessages);
    }

	public KcBusinessRulesEngine getKcBusinessRulesEngine() {
		if (kcBusinessRulesEngine == null) {
			kcBusinessRulesEngine = KcServiceLocator.getService(KcBusinessRulesEngine.class);
		}
		return kcBusinessRulesEngine;
	}

	public void setKcBusinessRulesEngine(KcBusinessRulesEngine kcBusinessRulesEngine) {
		this.kcBusinessRulesEngine = kcBusinessRulesEngine;
	}  
}
