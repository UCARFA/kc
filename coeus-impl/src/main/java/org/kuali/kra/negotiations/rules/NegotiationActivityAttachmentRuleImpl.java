/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.rules;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.negotiations.bo.NegotiationActivity;
import org.kuali.kra.negotiations.bo.NegotiationActivityAttachment;
import org.kuali.kra.negotiations.document.NegotiationDocument;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * 
 * Validation class for activity attachments.
 */
public class NegotiationActivityAttachmentRuleImpl implements NegotiationActivityAttachmentAddRule {
    
    private final ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);

    @Override
    public boolean processAddAttachmentRule(NegotiationActivityAttachmentAddRuleEvent event) {
        boolean result = true;
        
        NegotiationDocument document = (NegotiationDocument) event.getDocument();
        Negotiation negotiation = document.getNegotiation();
        NegotiationActivity activity = event.getActivity();
        NegotiationActivityAttachment newAttachment = event.getNewAttachment();
        
        GlobalVariables.getMessageMap().addToErrorPath(event.getErrorPathPrefix());
        
        result &= this.validateAttachmentRule(negotiation, activity, newAttachment);
        if (!errorReporter.propertyHasErrorReported(GlobalVariables.getMessageMap().getKeyPath("newFile", true))
                && StringUtils.isBlank(newAttachment.getNewFile().getFileName())) {
            result = false;
            errorReporter.reportError("newFile", KeyConstants.ERROR_REQUIRED, "File (File)");
        }
        
        GlobalVariables.getMessageMap().removeFromErrorPath(event.getErrorPathPrefix());
        
        return result;
    }
    
    /**
     * 
     * Call this to validate individual attachments.
     * @param negotiation
     * @param activity
     * @param attachment
     * @return
     */
    public boolean validateAttachmentRule(Negotiation negotiation, NegotiationActivity activity, NegotiationActivityAttachment attachment) {
        boolean result = true;
        if (!errorReporter.propertyHasErrorReported(GlobalVariables.getMessageMap().getKeyPath("description", true))
                && StringUtils.isBlank(attachment.getDescription())) {
            result = false;
            errorReporter.reportError("description", KeyConstants.ERROR_REQUIRED, "Description (Description)");
        }
        return result;
    }

}
