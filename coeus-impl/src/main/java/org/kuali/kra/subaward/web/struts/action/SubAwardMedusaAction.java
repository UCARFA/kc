/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.web.struts.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.subaward.SubAwardForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**.
 *
 * This class represents the Struts Action for Medusa page(AwardMedusa.jsp)
 */
public class SubAwardMedusaAction extends SubAwardAction {

    @Override
    public ActionForward docHandler(ActionMapping mapping, ActionForm form
           , HttpServletRequest request, HttpServletResponse response)
        throws Exception { SubAwardForm subAwardForm = (SubAwardForm) form;
            if (subAwardForm.getDocument().getDocumentNumber() == null) {
                loadDocumentInForm(request, subAwardForm);
            }
            subAwardForm.getMedusaBean().setMedusaViewRadio("0");
            subAwardForm.getMedusaBean().setModuleName("subaward");
            subAwardForm.getMedusaBean().
            setModuleIdentifier(subAwardForm.getSubAwardDocument().
            getSubAward().getSubAwardId());
            subAwardForm.getMedusaBean().generateParentNodes();
            return mapping.findForward(Constants.MAPPING_AWARD_MEDUSA_PAGE); }
    /**.
     * This method is for refreshView
     * @param mapping the ActionMapping
     * @param form the ActionForm
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws Exception
     * @return mapping
     */
    public ActionForward refreshView(ActionMapping mapping,
    	ActionForm form, HttpServletRequest request,
    	HttpServletResponse response) throws Exception {

        return mapping.findForward(Constants.MAPPING_AWARD_MEDUSA_PAGE);
    }
}
