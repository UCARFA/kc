/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.web.struts.action;

import org.kuali.kra.award.AwardDocumentRule;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.approvedsubawards.ApprovedSubawardFormHelper;
import org.kuali.kra.award.home.approvedsubawards.AwardApprovedSubawardRuleEvent;
import org.kuali.kra.award.home.approvedsubawards.AwardApprovedSubawardRuleImpl;

import java.io.Serializable;


public class ApprovedSubawardActionHelper implements Serializable {
    
    private static final long serialVersionUID = -6683397794718075987L;

    /**
     * This method is called when adding a new AwardApprovedSubaward
     * @param formHelper
     * @return
     * @throws Exception
     */
    public boolean addApprovedSubaward(ApprovedSubawardFormHelper formHelper) throws Exception {
        
        AwardApprovedSubawardRuleEvent event = new AwardApprovedSubawardRuleEvent(
                                                            "newAwardCostShare",
                                                            formHelper.getAwardDocument(),
                                                            formHelper.getNewAwardApprovedSubaward(),
                                                            formHelper.getAwardDocument().
                                                                getAward().getAwardApprovedSubawards());
        boolean success = new AwardApprovedSubawardRuleImpl().processAddApprovedSubawardBusinessRules(event);
            if(success){
                formHelper.getAwardDocument().getAward().add(formHelper.getNewAwardApprovedSubaward());
                formHelper.init();
            }
            return success;
    }

    /**
    /**
     * This method is called when recalculating the total subawards amount
     * @param formHelper
     * @return
     * @throws Exception
     */
    public boolean recalculateSubawardTotal(ApprovedSubawardFormHelper formHelper) throws Exception {
        AwardDocumentRule rule = new AwardDocumentRule();
        AwardDocument document = formHelper.getAwardDocument();
        boolean success = rule.processApprovedSubawardBusinessRules(document);
        return success;
    }
}
