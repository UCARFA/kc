/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.web.struts.action;

import org.kuali.kra.award.commitments.AwardCostShareRuleEvent;
import org.kuali.kra.award.commitments.AwardCostShareRuleImpl;
import org.kuali.kra.award.commitments.CostShareFormHelper;

import java.io.Serializable;


public class CostShareActionHelper implements Serializable {
    
    private static final long serialVersionUID = 8927780321198666093L;
    public static final String AWARD_COST_SHARE_FIELD = "costShareFormHelper.newAwardCostShare.source";

    /**
     * This method is called when adding a new AwardCostShare
     * @param formHelper
     * @return
     * @throws Exception
     */
    public boolean addCostShare(CostShareFormHelper formHelper) throws Exception {
        
        AwardCostShareRuleEvent event = new AwardCostShareRuleEvent(
                                                            "newAwardCostShare",
                                                            formHelper.getAwardDocument(),
                                                            formHelper.getNewAwardCostShare());
        boolean success = new AwardCostShareRuleImpl().processAddCostShareBusinessRules(event);
        event.setFieldName(AWARD_COST_SHARE_FIELD);
            if(success){
                formHelper.getAwardDocument().getAward().add(formHelper.getNewAwardCostShare());
                formHelper.init();
            }
            return success;
    }
}
