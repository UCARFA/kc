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
package org.kuali.coeus.propdev.impl.notification;


import org.kuali.coeus.common.notification.impl.NotificationAwareForm;
import org.kuali.coeus.common.notification.impl.NotificationContext;
import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.common.notification.impl.bo.NotificationTypeRecipient;
import org.kuali.coeus.common.notification.impl.rule.event.SendNotificationEvent;
import org.kuali.coeus.common.notification.impl.service.KcNotificationService;
import org.kuali.coeus.common.view.wizard.framework.WizardControllerService;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.service.KualiRuleService;
import org.kuali.rice.krad.util.MessageMap;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.rice.krad.web.service.ModelAndViewService;
import org.kuali.rice.krad.web.service.RefreshControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component("notificationControllerService")
public class NotificationControllerServiceImpl implements NotificationControllerService {

    @Autowired
    @Qualifier("kualiRuleService")
    private KualiRuleService kualiRuleService;

    @Autowired
    @Qualifier("refreshControllerService")
    private RefreshControllerService refreshControllerService;

    @Autowired
    @Qualifier("globalVariableService")
    private GlobalVariableService globalVariableService;

    @Autowired
    @Qualifier("kcNotificationService")
    private KcNotificationService kcNotificationService;

    @Autowired
    @Qualifier("wizardControllerService")
    private WizardControllerService wizardControllerService;

    @Autowired
    @Qualifier("modelAndViewService")
    private ModelAndViewService modelAndViewService;

    @Override
    public <T extends NotificationContext> ModelAndView sendNotification(NotificationAwareForm<T> form) {
        if (form.isSendNotification()) {
            return getModelAndViewService().showDialog("Kc-SendNotification-Wizard",true, (UifFormBase) form);
        }
        form.setSendNotification(false);
        return getModelAndViewService().getModelAndView((UifFormBase) form);
    }

    @Override
    public <T extends NotificationContext> ModelAndView performRecipientSearch(NotificationAwareForm<T> form) {
        form.getAddRecipientHelper().getResults().clear();
        form.getAddRecipientHelper().setResults(getWizardControllerService().performWizardSearch(form.getAddRecipientHelper().getLookupFieldValues(), form.getAddRecipientHelper().getLineType()));
        return getRefreshControllerService().refresh((UifFormBase) form);
    }

    @Override
    public <T extends NotificationContext> ModelAndView addRecipients(NotificationAwareForm<T> form) {
        form.getNotificationHelper().getNotificationRecipients().addAll(getKcNotificationService().addRecipient(form.getAddRecipientHelper().getResults()));
        return getRefreshControllerService().refresh((UifFormBase) form);
    }

    @Override
    public <T extends NotificationContext> ModelAndView sendNotifications(NotificationAwareForm<T> form, T context) {
        Document document = form.getDocument();
        KcNotification notification = form.getNotificationHelper().getNotification();
        List<NotificationTypeRecipient> notificationRecipients = form.getNotificationHelper().getNotificationRecipients();

        if (getKualiRuleService().applyRules(new SendNotificationEvent(document, notification, notificationRecipients))) {
            form.getNotificationHelper().sendNotification();
        }

        form.getNotificationHelper().initializeDefaultValues(context);
        form.getAddRecipientHelper().reset();
        populateDeferredMessages(form);
        return getRefreshControllerService().refresh((UifFormBase) form);
    }

    @Override
    public <T extends NotificationContext> void sendNotificationIfNoErrors(NotificationAwareForm<T> form, T context) {
        if (getGlobalVariableService().getMessageMap().hasNoErrors()) {
            if (form.getNotificationHelper().getPromptUserForNotificationEditor(context)) {
                form.getNotificationHelper().initializeDefaultValues(context);
                form.setSendNotification(true);
            } else {
                getKcNotificationService().sendNotification(context);
            }
        } else {
            form.setSendNotification(false);
        }
    }

    @Override
    public <T extends NotificationContext> ModelAndView prepareNotificationWizard(NotificationAwareForm<T> form) {
        final String step = form.getNotificationHelper().getNotificationRecipients().isEmpty() ? "0" : "2";
        form.getActionParameters().put("Kc-SendNotification-Wizard.step", step);
        return getRefreshControllerService().refresh((UifFormBase) form);
    }

    @Override
    public <T extends NotificationContext> ModelAndView cancelNotifications(NotificationAwareForm<T> form) {
        populateDeferredMessages(form);
        return getRefreshControllerService().refresh((UifFormBase) form);
    }

    private void populateDeferredMessages(NotificationAwareForm<?> form){
        if (form.getDeferredMessages() != null
                && form.getDeferredMessages().hasMessages()){
            MessageMap messageMap = form.getDeferredMessages();
            MessageMap currentMessageMap = getGlobalVariableService().getMessageMap();
            messageMap.getErrorMessages().putAll(currentMessageMap.getErrorMessages());
            messageMap.getInfoMessages().putAll(currentMessageMap.getInfoMessages());
            messageMap.getWarningMessages().putAll(currentMessageMap.getWarningMessages());
            getGlobalVariableService().setMessageMap(messageMap);
        }
        form.setDeferredMessages(null);
    }

    public KualiRuleService getKualiRuleService() {
        return kualiRuleService;
    }

    public void setKualiRuleService(KualiRuleService kualiRuleService) {
        this.kualiRuleService = kualiRuleService;
    }

    public RefreshControllerService getRefreshControllerService() {
        return refreshControllerService;
    }

    public void setRefreshControllerService(RefreshControllerService refreshControllerService) {
        this.refreshControllerService = refreshControllerService;
    }

    public GlobalVariableService getGlobalVariableService() {
        return globalVariableService;
    }

    public void setGlobalVariableService(GlobalVariableService globalVariableService) {
        this.globalVariableService = globalVariableService;
    }

    public KcNotificationService getKcNotificationService() {
        return kcNotificationService;
    }

    public void setKcNotificationService(KcNotificationService kcNotificationService) {
        this.kcNotificationService = kcNotificationService;
    }

    public WizardControllerService getWizardControllerService() {
        return wizardControllerService;
    }

    public void setWizardControllerService(WizardControllerService wizardControllerService) {
        this.wizardControllerService = wizardControllerService;
    }

    public ModelAndViewService getModelAndViewService() {
        return modelAndViewService;
    }

    public void setModelAndViewService(ModelAndViewService modelAndViewService) {
        this.modelAndViewService = modelAndViewService;
    }
}
