/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.web.struts.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.common.notification.impl.bo.NotificationTypeRecipient;
import org.kuali.coeus.common.notification.impl.rule.event.AddNotificationRecipientEvent;
import org.kuali.coeus.common.notification.impl.rule.event.SendNotificationEvent;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.infrastructure.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AwardNotificationEditorAction extends AwardAction {
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = super.execute(mapping, form, request, response);
        
        AwardForm awardForm = (AwardForm) form;
        
        awardForm.getNotificationHelper().prepareView();
        
        return actionForward;
    }
    
    /**
     * Adds a Notification Recipient.
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward addNotificationRecipient(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
        throws Exception {
        
        AwardForm awardForm = (AwardForm) form;
        AwardDocument document = awardForm.getAwardDocument();
        NotificationTypeRecipient notificationRecipient = awardForm.getNotificationHelper().getNewNotificationRecipient();
        List<NotificationTypeRecipient> notificationRecipients = awardForm.getNotificationHelper().getNotificationRecipients();
        
        if (applyRules(new AddNotificationRecipientEvent(document, notificationRecipient, notificationRecipients))) {
            awardForm.getNotificationHelper().getNotificationRecipients().add(notificationRecipient);
            awardForm.getNotificationHelper().setNewNotificationRecipient(new NotificationTypeRecipient());
            awardForm.getNotificationHelper().setNewRoleId(null);
            awardForm.getNotificationHelper().setNewPersonId(null);
            awardForm.getNotificationHelper().setNewRolodexId(null);
        }
        
        return mapping.findForward(Constants.MAPPING_BASIC);
    }
    
    /**
     * Deletes a Notification Recipient.
     * 
     * @param mapping the action mapping
     * @param form the action form
     * @param request the request
     * @param response the response
     * @return the action forward
     * @throws Exception
     */
    public ActionForward deleteNotificationRecipient(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        AwardForm awardForm = (AwardForm) form;
        
        awardForm.getNotificationHelper().getNotificationRecipients().remove(getLineToDelete(request));
        
        return mapping.findForward(Constants.MAPPING_BASIC);
    }
    
    /**
     * Sends a Notification.
     * 
     * @param mapping the action mapping
     * @param form the action form
     * @param request the request
     * @param response the response
     * @return the action forward
     * @throws Exception
     */
    public ActionForward sendNotification(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = mapping.findForward(Constants.MAPPING_BASIC);
        
        AwardForm awardForm = (AwardForm) form;
        AwardDocument document = awardForm.getAwardDocument();
        KcNotification notification = awardForm.getNotificationHelper().getNotification();
        List<NotificationTypeRecipient> notificationRecipients = awardForm.getNotificationHelper().getNotificationRecipients();
        
        if (applyRules(new SendNotificationEvent(document, notification, notificationRecipients))) {
            awardForm.getNotificationHelper().sendNotification();
            
            String forwardName = awardForm.getNotificationHelper().getNotificationContext().getForwardName();
            if (StringUtils.isNotBlank(forwardName)) {
                actionForward = mapping.findForward(forwardName);
            }
            
        }

        return actionForward;
    }

    /**
     * Cancels a Notification.
     * 
     * @param mapping the action mapping
     * @param form the action form
     * @param request the request
     * @param response the response
     * @return the action forward
     * @throws Exception
     */
    public ActionForward cancelNotification(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        AwardForm awardForm = (AwardForm) form;
        
        awardForm.getNotificationHelper().setNotificationContext(null);
        
        return mapping.findForward(Constants.MAPPING_AWARD_ACTIONS_PAGE);
    }
    
}
