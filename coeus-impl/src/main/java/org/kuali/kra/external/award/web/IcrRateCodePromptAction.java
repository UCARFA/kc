/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.award.web;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.web.struts.action.AwardActionsAction;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.util.GlobalVariables;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * For Account Creation, if there is more than one possible ICR Rate Code mapping, prompt the user to select the correct one. 
 */
public class IcrRateCodePromptAction extends AwardActionsAction {
    
    private static final String NO_OPTION_SELECTED_ERROR_KEY = "error.award.createAccount.noIcrSelected";
    
    /**
     * Proceed with account creation using the selected ICR Rate Code.
     */
    public ActionForward proceed(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        AwardForm awardForm = (AwardForm) form;
        if (awardForm.getAccountCreationHelper().getSelectedIcrRateCode() == null) {
            GlobalVariables.getMessageMap().putError("accountCreationHelper.selectedIcrRateCode", NO_OPTION_SELECTED_ERROR_KEY, "");
            return mapping.findForward(Constants.MAPPING_BASIC);
        } else {
            awardForm.getAwardDocument().getAward().setIcrRateCode(awardForm.getAccountCreationHelper().getSelectedIcrRateCode());
        }
        return super.createAccount(mapping, form, request, response);
    }
    
    /**
     * Return to Award Actions and cancel the account creation.
     */
    @Override
    public ActionForward cancel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(Constants.MAPPING_AWARD_ACTIONS_PAGE);
    }

}
