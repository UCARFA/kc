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
import org.kuali.coeus.common.impl.custom.CustomDataRule;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;
import org.kuali.coeus.common.framework.custom.SaveCustomDataEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InstitutionalProposalCustomDataAction extends InstitutionalProposalAction {

    
    /**
     * 
     * @see org.kuali.core.web.struts.action.KualiDocumentActionBase#reload(
     * org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, 
     * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings("all")
    public ActionForward reload(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception { 
        InstitutionalProposalForm institutionalProposalForm = (InstitutionalProposalForm) form;
        super.reload(mapping, form, request, response);
        institutionalProposalForm.getCustomDataHelper().prepareCustomData();
        return mapping.findForward(Constants.MAPPING_INSTITUTIONAL_PROPOSAL_CUSTOM_DATA_PAGE);
    }

    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception { 
        InstitutionalProposalForm institutionalProposalForm = (InstitutionalProposalForm) form;
        //have to do the custom data validation here, separate from the document save, as invalid default values could cause the
        //document to be unusable.
        if (new CustomDataRule().processRules(new SaveCustomDataEvent(institutionalProposalForm.getInstitutionalProposalDocument()))) {
            return super.save(mapping, form, request, response);   
        } else {
            return mapping.findForward(Constants.MAPPING_BASIC);
        }
    }
    
}
