/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.home;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.common.framework.costshare.CostShareFunctions;
import org.kuali.coeus.common.framework.costshare.CostShareService;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.rules.InstitutionalProposalAddCostShareRuleEvent;
import org.kuali.kra.institutionalproposal.rules.InstitutionalProposalAddCostShareRuleImpl;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;

import java.io.Serializable;


public class InstitutionalProposalCostShareBean implements Serializable, CostShareFunctions {

    private static final long serialVersionUID = -7837407094828925591L;

    private InstitutionalProposalForm parent;
    
    private InstitutionalProposalCostShare newInstitutionalProposalCostShare;
    
    /**
     * Constructs a InstitutionalProposalCostshareBean
     * @param parent
     */
    public InstitutionalProposalCostShareBean() {
        super();
    }
    /**
     * Constructs a InstitutionalProposalCostShareBean
     * @param parent
     */
    public InstitutionalProposalCostShareBean(InstitutionalProposalForm parent) {
        this.parent = parent;
        init(); 
    }
    
    /**
     * Initialize subform
     */
    public void init() {
        newInstitutionalProposalCostShare = new InstitutionalProposalCostShare(); 
    }


    /**
     * Gets the newInstitutionalProposalCostShare attribute. 
     * @return Returns the newInstitutionalProposalCostShare.
     */
    public InstitutionalProposalCostShare getNewInstitutionalProposalCostShare() {
        return newInstitutionalProposalCostShare;
    }

    /**
     * Sets the newInstitutionalProposalCostShare attribute value.
     * @param newInstitutionalProposalCostShare The newInstitutionalProposalCostShare to set.
     */
    public void setNewInstitutionalProposalCostShare(InstitutionalProposalCostShare newInstitutionalProposalCostShare) {
        this.newInstitutionalProposalCostShare = newInstitutionalProposalCostShare;
    }


    public InstitutionalProposalDocument getInstitutionalProposalDocument() {
        return parent.getInstitutionalProposalDocument();
    }
    

    public Object getData() {
        return getNewInstitutionalProposalCostShare();
    }
    
    /**
     * This method is called when adding a new AwardCostShare
     * @param formHelper
     * @return
     * @throws Exception
     */
    public boolean addCostShare(InstitutionalProposalCostShareBean formBean) throws Exception {
        
        InstitutionalProposalAddCostShareRuleEvent event = new InstitutionalProposalAddCostShareRuleEvent(
                                                            "newInstitutionalProposalCostShare",
                                                            formBean.getInstitutionalProposalDocument(),
                                                            formBean.getNewInstitutionalProposalCostShare());
        event.setFieldName("institutionalProposalCostShareBean.newInstitutionalProposalCostShare.sourceAccount");
        boolean success = new InstitutionalProposalAddCostShareRuleImpl().processAddInstitutionalProposalCostShareBusinessRules(event);
            if(success){
                formBean.getInstitutionalProposalDocument().getInstitutionalProposal().add(formBean.getNewInstitutionalProposalCostShare());
                formBean.init();
            }
            return success;
    }
    
    @Override
    public String getProjectPeriodLabel() {
        String label = KcServiceLocator.getService(CostShareService.class).getCostShareLabel();
        return label;
    }
}
