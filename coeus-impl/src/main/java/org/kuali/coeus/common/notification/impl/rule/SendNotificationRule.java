/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.rule;

import org.kuali.coeus.common.notification.impl.bo.NotificationTypeRecipient;
import org.kuali.coeus.common.notification.impl.rule.event.SendNotificationEvent;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

import java.util.List;

/**
 * Runs the rule processing for saving a Notification.
 */
public class SendNotificationRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<SendNotificationEvent> {
    
    private static final String FULL_NAME_FIELD = "fullName";
    
    @Override
    public boolean processRules(SendNotificationEvent sendNotificationEvent) {
        boolean rulePassed = true;
        
        List<NotificationTypeRecipient> notificationTypeRecipients = sendNotificationEvent.getNotificationTypeRecipients();

        rulePassed &= validateNonEmptyRecipients(notificationTypeRecipients);
        
        return rulePassed;
    }
    
    private boolean validateNonEmptyRecipients(List<NotificationTypeRecipient> notificationTypeRecipients) {
        boolean isValid = true;
        
        if (notificationTypeRecipients.isEmpty()) {
            isValid = false;
            reportError(FULL_NAME_FIELD, KeyConstants.ERROR_NOTIFICATION_RECIPIENTS_REQUIRED);
        }
        
        return isValid;
    }

}
