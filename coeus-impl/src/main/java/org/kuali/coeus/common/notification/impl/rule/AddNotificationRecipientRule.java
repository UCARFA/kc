/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.rule;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.notification.impl.bo.NotificationTypeRecipient;
import org.kuali.coeus.common.notification.impl.rule.event.AddNotificationRecipientEvent;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;

/**
 * Runs the rule processing for adding a Notification Type Recipient.
 */
public class AddNotificationRecipientRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<AddNotificationRecipientEvent> {

    private static final String FULL_NAME_FIELD = "fullName";
    
    @Override
    public boolean processRules(AddNotificationRecipientEvent addNotificationRecipientEvent) {
        boolean rulePassed = true;
        
        NotificationTypeRecipient notificationTypeRecipient = addNotificationRecipientEvent.getNotificationTypeRecipient();
        List<NotificationTypeRecipient> notificationTypeRecipients = addNotificationRecipientEvent.getNotificationTypeRecipients();
        
        getDictionaryValidationService().validateBusinessObject(notificationTypeRecipient);
        rulePassed &= GlobalVariables.getMessageMap().hasNoErrors();
        rulePassed &= validateRecipient(notificationTypeRecipient);
        rulePassed &= validateUniqueRecipients(notificationTypeRecipient, notificationTypeRecipients);
        
        return rulePassed;
    }
    
    private boolean validateRecipient(NotificationTypeRecipient notificationTypeRecipient) {
        boolean isValid = true;
        
        if (StringUtils.isBlank(notificationTypeRecipient.getRoleName()) && StringUtils.isBlank(notificationTypeRecipient.getPersonId()) 
                                                                         && StringUtils.isBlank(notificationTypeRecipient.getRolodexId())) {
            isValid = false;
            reportError(FULL_NAME_FIELD, KeyConstants.ERROR_NOTIFICATION_EMPTY_NOTIFICATION_RECIPIENT);
        }

        return isValid;
    }
    
    private boolean validateUniqueRecipients(NotificationTypeRecipient newNotificationTypeRecipient, 
                                             List<NotificationTypeRecipient> existingNotificationTypeRecipients) {
        boolean isValid = true;

        for (NotificationTypeRecipient existingNotificationTypeRecipient : existingNotificationTypeRecipients) {
            if (isIdentifierEqual(newNotificationTypeRecipient.getRoleName(), existingNotificationTypeRecipient.getRoleName()) 
                    || isIdentifierEqual(newNotificationTypeRecipient.getPersonId(), existingNotificationTypeRecipient.getPersonId()) 
                    || isIdentifierEqual(newNotificationTypeRecipient.getRolodexId(), existingNotificationTypeRecipient.getRolodexId())) {
                isValid = false;
                reportError(FULL_NAME_FIELD, KeyConstants.ERROR_NOTIFICATION_DUPLICATE_NOTIFICATION_RECIPIENT);
            }
        }
        
        return isValid;
    }
    
    private static boolean isIdentifierEqual(String newIdentifier, String existingIdentifier) {
        return (StringUtils.isNotBlank(newIdentifier) || StringUtils.isNotBlank(existingIdentifier)) && StringUtils.equals(newIdentifier, existingIdentifier);
    }
    
}
