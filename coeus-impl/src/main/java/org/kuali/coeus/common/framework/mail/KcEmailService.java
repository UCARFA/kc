/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.mail;


import java.util.List;
import java.util.Set;


public interface KcEmailService {

    public void sendEmail(String from, Set<String> toAddresses, String subject, Set<String> ccAddresses,
            Set<String> bccAddresses, String body, boolean htmlMessage);
    
    public void sendEmailWithAttachments(String from, Set<String> toAddresses, String subject, Set<String> ccAddresses,
            Set<String> bccAddresses, String body, boolean htmlMessage, List<EmailAttachment> attachments);
    
    public String getDefaultFromAddress();
}
