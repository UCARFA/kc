/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.web.struts.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.infrastructure.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * This class represents the Struts Action for Medusa page(AwardMedusa.jsp)
 */
public class AwardMedusaAction extends AwardAction {    
    @Override
    public ActionForward docHandler(ActionMapping mapping, ActionForm form
            , HttpServletRequest request, HttpServletResponse response) throws Exception { AwardForm awardForm = (AwardForm) form;
            if (awardForm.getDocument().getDocumentNumber() == null) {
                //if we are entering this from the search results
                loadDocumentInForm(request, awardForm);
            }
            awardForm.getMedusaBean().setMedusaViewRadio("0");
            awardForm.getMedusaBean().setModuleName("award");
            awardForm.getMedusaBean().setModuleIdentifier(awardForm.getAwardDocument().getAward().getAwardId());
            awardForm.getMedusaBean().generateParentNodes();
            return mapping.findForward(Constants.MAPPING_AWARD_MEDUSA_PAGE);}
    public ActionForward refreshView(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        return mapping.findForward(Constants.MAPPING_AWARD_BASIC);
    }
}
