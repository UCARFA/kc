/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notification;


import org.kuali.coeus.common.framework.mail.EmailAttachment;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.notification.impl.NotificationContextBase;
import org.kuali.coeus.common.notification.impl.NotificationRenderer;
import org.kuali.coeus.common.notification.impl.service.KcNotificationRoleQualifierService;
import org.kuali.coeus.common.notification.impl.service.KcNotificationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.coi.personfinancialentity.PersonFinIntDisclosure;

import java.util.List;

/**
 * This class extends the notification context base and provides some helpful functions for
 * any IRB specific events.
 */
public class FinancialEntityNotificationContext extends NotificationContextBase {

    private String entityNumber;
    private String actionTypeCode;
    private String contextName;
    
    /**
     * Constructs a COI notification context and sets the necessary services.
     * @param coiDisclosure
     * @param actionTypeCode
     * @param contextName
     */
    public FinancialEntityNotificationContext(PersonFinIntDisclosure disclosure, String actionTypeCode, String contextName, NotificationRenderer renderer) {
        super(renderer);

        this.entityNumber = disclosure.getEntityNumber();
        this.actionTypeCode = actionTypeCode;
        this.contextName = contextName;
        setNotificationService(KcServiceLocator.getService(KcNotificationService.class));
    }
    
    @Override
    public String getModuleCode() {
        return CoeusModule.COI_DISCLOSURE_MODULE_CODE;
    }
    
    public String getEntityNumber() {
        return entityNumber;
    }
    
    @Override
    public String getActionTypeCode() {
        return actionTypeCode;
    }
    
    @Override
    public String getContextName() {
        return contextName;
    }

    @Override
    public List<EmailAttachment> getEmailAttachments() {

        return null;
    }

    @Override
    public String getDocumentNumber() {

        return null;
    }
 
    @Override
    public KcNotificationRoleQualifierService getNotificationRoleQualifierService() {
        if (super.getNotificationRoleQualifierService() == null) {
            setNotificationRoleQualifierService(KcServiceLocator.getService(CoiNotificationRoleQualifierService.class));
        }
        return super.getNotificationRoleQualifierService();
    }

    
}
