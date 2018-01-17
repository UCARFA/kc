/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.web.struts.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.rice.kns.web.struts.form.KualiDocumentFormBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple action class to handle the case of pressing cancel during the proposal log search
 */
public class InstitutionalProposalCreateAction extends InstitutionalProposalHomeAction {
    
    /**
     * Called when cancel is pressed on the proposal log search. Should return user to portal in this case
     */
    @Override
    public ActionForward refresh(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        KualiDocumentFormBase kualiForm = (KualiDocumentFormBase) form;
        return returnToSender(request, mapping, kualiForm);
    }  
    
}
