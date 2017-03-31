/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.budget.dataoverride;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetControllerBase;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetForm;
import org.kuali.coeus.propdev.impl.budget.editable.BudgetChangedData;
import org.kuali.coeus.propdev.impl.budget.editable.BudgetColumnsToAlter;
import org.kuali.coeus.propdev.impl.budget.editable.BudgetDataOverrideEvent;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.dataovveride.common.CommonDataOverrideService;
import org.kuali.coeus.propdev.impl.notification.NotificationControllerService;
import org.kuali.coeus.propdev.impl.notification.ProposalDevelopmentNotificationContext;
import org.kuali.coeus.propdev.impl.notification.ProposalDevelopmentNotificationRenderer;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.service.KualiRuleService;
import org.kuali.rice.krad.uif.UifConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ProposalBudgetDataOverrideController extends ProposalBudgetControllerBase {

    @Autowired
    @Qualifier("kualiRuleService")
    private KualiRuleService kualiRuleService;

    @Autowired
    @Qualifier("notificationControllerService")
    private NotificationControllerService notificationControllerService;

    @Autowired
    @Qualifier("commonDataOverrideService")
    private CommonDataOverrideService commonDataOverrideService;

    @Transactional @RequestMapping(value = "/proposalBudget", params="methodToCall=prepareDataOverride")
    public ModelAndView prepareDataOverride(@ModelAttribute("KualiForm") ProposalBudgetForm form)
            throws Exception {

        String columnName = form.getNewBudgetChangedData().getColumnName();
        if (StringUtils.isNotEmpty(columnName)){
            form.getNewBudgetChangedData().setEditableColumn(getDataObjectService().find(BudgetColumnsToAlter.class,
                    columnName));

            String propertyValue = getCommonDataOverrideService().getChangedValue(form.getBudget(), form.getNewBudgetChangedData().getAttributeName());
            form.getNewBudgetChangedData().setDisplayValue(propertyValue);
            form.getNewBudgetChangedData().setOldDisplayValue(propertyValue);
        } else {
            form.setNewBudgetChangedData(new BudgetChangedData());
        }
        form.setUpdateComponentId("PropBudget-DataOverride-Dialog");
        form.setAjaxReturnType(UifConstants.AjaxReturnTypes.UPDATECOMPONENT.getKey());
        return getRefreshControllerService().refresh(form);
    }

    @Transactional @RequestMapping(value = "/proposalBudget", params="methodToCall=createOverride")
    public ModelAndView createOverride(@ModelAttribute("KualiForm") ProposalBudgetForm form)
            throws Exception {
        Budget budget = form.getBudget();
        BudgetChangedData newBudgetChangedData = form.getNewBudgetChangedData();

        int changeNumber = budget.getBudgetParent().getDocument().getDocumentNextValue("proposalDevelopment.budgetChangedDataList.changeNumber");
        newBudgetChangedData.setProposalNumber(budget.getBudgetParent().getParentNumber());
        newBudgetChangedData.setChangeNumber(changeNumber);
        newBudgetChangedData.setDisplayValue(newBudgetChangedData.getChangedValue());

        if(getKualiRuleService().applyRules(new BudgetDataOverrideEvent((ProposalDevelopmentDocument) budget.getBudgetParent().getDocument(), newBudgetChangedData))){
            getCommonDataOverrideService().setChangedValue(budget,newBudgetChangedData.getAttributeName(), newBudgetChangedData.getChangedValue());
            growProposalChangedHistory(budget, newBudgetChangedData);
            List<BudgetChangedData> budgetChangedDataList= new ArrayList<>();

            //super.save(form) does not save BOs on DevelopmentProposal only budget
            budgetChangedDataList.add(getDataObjectService().save(newBudgetChangedData));
            budgetChangedDataList.addAll(form.getDevelopmentProposal().getBudgetChangedDataList().stream()
                    .map(b -> getDataObjectService().save(b))
                    .collect(Collectors.toList()));
            form.getDevelopmentProposal().setBudgetChangedDataList(budgetChangedDataList);

            super.saveBudget(form);

            String s = getCommonDataOverrideService().getDisplayReferenceValue(budget, newBudgetChangedData.getAttributeName(), Budget.class);
            if (s != null) {
                newBudgetChangedData.setDisplayValue(s);
            }
            form.setNewBudgetChangedData(new BudgetChangedData());

            ProposalDevelopmentNotificationContext context =
                    new ProposalDevelopmentNotificationContext((DevelopmentProposal) budget.getBudgetParent(), Constants.PROPOSAL_DATA_OVVERRIDE_ACTION_TYPE_CODE, Constants.DATA_OVERRIDE_CONTEXT);
            ((ProposalDevelopmentNotificationRenderer) context.getRenderer()).setBudgetChangedData(newBudgetChangedData);
            ((ProposalDevelopmentNotificationRenderer) context.getRenderer()).setDevelopmentProposal((DevelopmentProposal) budget.getBudgetParent());

            getNotificationControllerService().sendNotificationIfNoErrors(form, context);

        }

       return getRefreshControllerService().refresh(form);
    }

    @Transactional @RequestMapping(value = "/proposalBudget", params="methodToCall=sendOverrideNotification")
    public ModelAndView sendOverrideNotification(@ModelAttribute("KualiForm") ProposalBudgetForm form) {
        return getNotificationControllerService().sendNotification(form);
    }

    @Transactional @RequestMapping(value = "/proposalBudget", params="methodToCall=performRecipientSearch")
    public ModelAndView performRecipientSearch(@ModelAttribute("KualiForm") ProposalBudgetForm form) throws Exception {
        return getNotificationControllerService().performRecipientSearch(form);
    }

    @Transactional @RequestMapping(value = "/proposalBudget", params="methodToCall=addRecipients")
    public ModelAndView addRecipients(@ModelAttribute("KualiForm") ProposalBudgetForm form) {
        return getNotificationControllerService().addRecipients(form);
    }

    @Transactional @RequestMapping(value = "/proposalBudget", params="methodToCall=sendNotifications")
    public ModelAndView sendNotifications(@ModelAttribute("KualiForm") ProposalBudgetForm form) {

        ProposalDevelopmentNotificationRenderer renderer = new ProposalDevelopmentNotificationRenderer(form.getDevelopmentProposal());
        ProposalDevelopmentNotificationContext context = new ProposalDevelopmentNotificationContext(form.getDevelopmentProposal(), null, "Ad-Hoc Notification", renderer);

        return getNotificationControllerService().sendNotifications(form, context);
    }

    @Transactional @RequestMapping(value = "/proposalBudget", params="methodToCall=prepareNotificationWizard")
    public ModelAndView prepareNotificationWizard(@ModelAttribute("KualiForm") ProposalBudgetForm form) {
        return getNotificationControllerService().prepareNotificationWizard(form);
    }

    private void growProposalChangedHistory(Budget budget, BudgetChangedData newBudgetChangedData) {
        Map<String, List<BudgetChangedData>> changeHistory = ((DevelopmentProposal)budget.getBudgetParent()).getBudgetChangeHistory();
        changeHistory.computeIfAbsent(newBudgetChangedData.getEditableColumn().getColumnLabel(), k -> new ArrayList<>());
        changeHistory.get(newBudgetChangedData.getEditableColumn().getColumnLabel()).add(0, newBudgetChangedData);
    }

    public KualiRuleService getKualiRuleService() {
        return kualiRuleService;
    }

    public void setKualiRuleService(KualiRuleService kualiRuleService) {
        this.kualiRuleService = kualiRuleService;
    }

    public NotificationControllerService getNotificationControllerService() {
        return notificationControllerService;
    }

    public void setNotificationControllerService(NotificationControllerService notificationControllerService) {
        this.notificationControllerService = notificationControllerService;
    }

    public CommonDataOverrideService getCommonDataOverrideService() {
        return commonDataOverrideService;
    }

    public void setCommonDataOverrideService(CommonDataOverrideService commonDataOverrideService) {
        this.commonDataOverrideService = commonDataOverrideService;
    }
}
