/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.medusa;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.rice.kns.web.struts.action.KualiDocumentActionBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MedusaAjaxAction extends KualiDocumentActionBase {

    private MedusaService medusaService;
    protected  MedusaService getMedusaService (){
        if (medusaService == null)
            medusaService = KcServiceLocator.getService(MedusaService.class);
        return medusaService;
    }
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        MedusaForm medusaForm = (MedusaForm)form;
        medusaForm.getMedusaBean().setCurrentNode(getMedusaService().getMedusaNode(medusaForm.getMedusaBean().getModuleName(), medusaForm.getMedusaBean().getModuleIdentifier()));
        
        return super.execute(mapping, medusaForm, request, response);
    }
    
    @Override
    public ActionForward docHandler(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        MedusaForm medusaForm = (MedusaForm)form;
        medusaForm.setCommand("displayDocSearchView");

        MedusaNode node = getMedusaService().getMedusaNode(medusaForm.getMedusaBean().getModuleName(), medusaForm.getMedusaBean().getModuleIdentifier());
        
        if (StringUtils.equals(node.getType(), "IP")) {
            InstitutionalProposal proposal = (InstitutionalProposal)node.getBo();
            medusaForm.setDocId(proposal.getInstitutionalProposalDocument().getDocumentNumber());
        } else if (StringUtils.equals(node.getType(), "award")) {
            Award award = (Award)node.getBo();
            medusaForm.setDocId(award.getAwardDocument().getDocumentNumber());
        } else if (StringUtils.equals(node.getType(), "DP")) {
            DevelopmentProposal devProposal = (DevelopmentProposal)node.getBo();
            medusaForm.setDocId(devProposal.getProposalDocument().getDocumentNumber());
        }else if (StringUtils.equals(node.getType(), "subaward")) {
            SubAward subAward = (SubAward)node.getBo();
            medusaForm.setDocId(subAward.getSubAwardDocument().getDocumentNumber());
        }
            
        return super.docHandler(mapping, form, request, response);
    }
}
