/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.correction;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * Validate the assignment of a protocol to a agenda.
 */
public class ProtocolAdminCorrectionRule extends KcTransactionalDocumentRuleBase implements ExecuteProtocolAdminCorrectionRule {
   
    @Override
    public boolean processAdminCorrectionRule(ProtocolDocument document, AdminCorrectionBean actionBean) {
        boolean valid = true;
        if (StringUtils.isBlank(actionBean.getComments())) {
            valid = false;
            GlobalVariables.getMessageMap().putError(Constants.PROTOCOL_ADMIN_CORRECTION_PROPERTY_KEY + ".comments", 
                                                   KeyConstants.ERROR_PROTOCOL_ADMIN_CORRECTION_COMMENTS_REQUIRED);  
        }
        return valid;
    }
}
