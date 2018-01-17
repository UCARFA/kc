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
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.ipreview.IntellectualPropertyReview;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;
import org.kuali.rice.core.api.util.RiceConstants;
import org.kuali.rice.krad.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InstitutionalProposalIntellectualPropertyReviewAction extends InstitutionalProposalAction {
    
    /**
     * @see org.kuali.coeus.sys.framework.controller.KcTransactionalDocumentActionBase#save(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * 
     * There's nothing editable on this page, so skip saving the whole object graph.
     */
    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // reload so the new inp comment can be refreshed from DB
        super.reload(mapping, form, request, response);
        return mapping.findForward(RiceConstants.MAPPING_BASIC);
    }
    
    public ActionForward editIntellectualPropertyReview(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        InstitutionalProposalForm institutionalProposalForm = (InstitutionalProposalForm) form;
        InstitutionalProposalDocument institutionalProposalDocument = (InstitutionalProposalDocument) institutionalProposalForm.getDocument();
        institutionalProposalDocument.getInstitutionalProposal().getProposalIpReviewJoin().refreshReferenceObject("intellectualPropertyReview");
        
        if (ObjectUtils.isNotNull(institutionalProposalDocument.getInstitutionalProposal().getProposalIpReviewJoin().getIntellectualPropertyReview())) {
            response.sendRedirect("kr/maintenance.do?businessObjectClassName=" + IntellectualPropertyReview.class.getName() + "&methodToCall=copy&ipReviewId="
                    + institutionalProposalDocument.getInstitutionalProposal().getProposalIpReviewJoin().getIntellectualPropertyReview().getIpReviewId()
                    + "&proposalId=" + institutionalProposalDocument.getInstitutionalProposal().getProposalId());
        }
        
        return null;
    }

}
