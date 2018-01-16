/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.ynq;

import org.kuali.coeus.common.framework.ynq.Ynq;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.GlobalVariables;

public class YnqMaintenanceDocumentRule  extends KcMaintenanceDocumentRuleBase {


    public YnqMaintenanceDocumentRule() {
        super();
    }
    
    @Override
    public boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return checkYNQ(document);
    }
    
    @Override
    public boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return checkYNQ(document);
    }

    /**
     * 
     * This method to check Ynq's explanation and review date is required field based on answer.
     * @param maintenanceDocument
     * @return
     */
    private boolean checkYNQ(MaintenanceDocument maintenanceDocument) {

        boolean valid = true;
        if (LOG.isDebugEnabled()) {
            LOG.debug("new maintainable is: " + maintenanceDocument.getNewMaintainableObject().getClass());
        }
        Ynq newYnq = (Ynq) maintenanceDocument.getNewMaintainableObject().getDataObject();
        
        /* check if answer is YES / NO and explanation / date required for NA */
        
        if(newYnq.getNoOfAnswers() < Constants.ANSWER_YES_NO_NA) {
            if(newYnq.getExplanationRequiredFor() != null && newYnq.getExplanationRequiredFor().contains(Constants.ANSWER_NA)) {
                GlobalVariables.getMessageMap().putError("document.newMaintainableObject.explanationRequiredFor", KeyConstants.INVALID_EXPLANATION_REQUIRED_FOR);
                valid = false;
            }
            if(newYnq.getDateRequiredFor() != null && newYnq.getDateRequiredFor().contains(Constants.ANSWER_NA)) {
                GlobalVariables.getMessageMap().putError("document.newMaintainableObject.dateRequiredFor", KeyConstants.INVALID_DATE_REQUIRED_FOR);
                valid = false;
            }
        }
        return valid;
    }

}
