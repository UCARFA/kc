/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.web.struts.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.personmasschange.web.struts.form.PersonMassChangeForm;
import org.kuali.kra.personmasschange.web.struts.form.PersonMassChangeViewHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonMassChangeViewAction extends PersonMassChangeAction {
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = super.execute(mapping, form, request, response);
        
        PersonMassChangeForm personMassChangeForm = (PersonMassChangeForm) form;
        PersonMassChangeViewHelper personMassChangeViewHelper = personMassChangeForm.getPersonMassChangeViewHelper();
        personMassChangeViewHelper.prepareView();
        
        return forward;
    }
    
    @Override
    public ActionForward approve(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.approve(mapping, form, request, response);
        
        return routeToHoldingPage(mapping, form, request, response, Constants.MAPPING_PMC_VIEW_PAGE);
    }
    
    @Override
    public ActionForward blanketApprove(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.blanketApprove(mapping, form, request, response);
        
        return routeToHoldingPage(mapping, form, request, response, Constants.MAPPING_PMC_VIEW_PAGE);
    }

}
