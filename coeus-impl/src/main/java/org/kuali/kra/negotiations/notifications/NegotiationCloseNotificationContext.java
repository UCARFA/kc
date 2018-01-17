/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.notifications;

import org.kuali.coeus.common.framework.mail.EmailAttachment;
import org.kuali.coeus.common.notification.impl.NotificationContextBase;
import org.kuali.coeus.common.notification.impl.service.KcNotificationModuleRoleService;
import org.kuali.coeus.common.notification.impl.service.KcNotificationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.negotiations.document.NegotiationDocument;

import java.util.List;

/**
 * Notification Context for Negotiation Closed action.
 */
public class NegotiationCloseNotificationContext extends NotificationContextBase {
    
    private static final long serialVersionUID = 70308097840555645L;
    private static final String NEGOTIATION_NOTIFICATION_MODULE_CODE = "5";
    private static final String NEGOTIATION_CLOSE_NOTIFICATION_ACTION_CODE = "100";
    
    private NegotiationDocument negotiationDocument;
    private List<EmailAttachment> emailAttachments;
    
    public NegotiationCloseNotificationContext(NegotiationDocument negotiationDocument) {
        super(KcServiceLocator.getService(NegotiationNotificationRenderer.class));
        ((NegotiationNotificationRenderer) getRenderer()).setNegotiation(negotiationDocument.getNegotiation());
        this.negotiationDocument = negotiationDocument;
        setNotificationService(KcServiceLocator.getService(KcNotificationService.class));
        setNotificationModuleRoleService(KcServiceLocator.getService(KcNotificationModuleRoleService.class));
        setNotificationRoleQualifierService(KcServiceLocator.getService(NegotiationNotificationRoleQualifierService.class));
    
        ((NegotiationNotificationRoleQualifierService) getNotificationRoleQualifierService()).setNegotiation(negotiationDocument.getNegotiation());
    }
    
    @Override
    public String getModuleCode() {
        return NEGOTIATION_NOTIFICATION_MODULE_CODE;
    }

    @Override
    public String getActionTypeCode() {
        return NEGOTIATION_CLOSE_NOTIFICATION_ACTION_CODE;
    }

    @Override
    public String getDocumentNumber() {
        return negotiationDocument.getDocumentNumber();
    }

    @Override
    public String getContextName() {
        return "Close Notification";
    }

    public NegotiationDocument getNegotiationDocument() {
        return negotiationDocument;
    }

    public void setNegotiationDocument(NegotiationDocument negotiationDocument) {
        this.negotiationDocument = negotiationDocument;
    }

    @Override
    public List<EmailAttachment> getEmailAttachments() {
        return emailAttachments;
    }

    public void setEmailAttachments(List<EmailAttachment> emailAttachments) {
        this.emailAttachments = emailAttachments;
    }

}
