/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.home;

import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;

import java.io.Serializable;


public class InstitutionalProposalNotepadBean implements Serializable {

    private static final long serialVersionUID = -2409602626444019766L;

    private InstitutionalProposalForm parent;
    
    private InstitutionalProposalNotepad newInstitutionalProposalNotepad;
    
    /**
     * Constructs a CostShareFormHelper
     * @param parent
     */
    public InstitutionalProposalNotepadBean() {
        super();
        init();
    }
    /**
     * Constructs a CostShareFormHelper
     * @param parent
     */
    public InstitutionalProposalNotepadBean(InstitutionalProposalForm parent) {
        this();
        this.parent = parent;
    }
    
    /**
     * Initialize subform
     */
    public void init() {
        newInstitutionalProposalNotepad = new InstitutionalProposalNotepad(); 
    }


    /**
     * Gets the newInstitutionalProposalNotepad attribute. 
     * @return Returns the newInstitutionalProposalNotepad.
     */
    public InstitutionalProposalNotepad getNewInstitutionalProposalNotepad() {
        return newInstitutionalProposalNotepad;
    }

    /**
     * Sets the newInstitutionalProposalNotepad attribute value.
     * @param newInstitutionalProposalNotepad The newInstitutionalProposalNotepad to set.
     */
    public void setNewInstitutionalProposalNotepad(InstitutionalProposalNotepad newInstitutionalProposalNotepad) {
        this.newInstitutionalProposalNotepad = newInstitutionalProposalNotepad;
    }


    public InstitutionalProposalDocument getInstitutionalProposalDocument() {
        return parent.getInstitutionalProposalDocument();
    }
    

    public Object getData() {
        return getNewInstitutionalProposalNotepad();
    }
    
    /**
     * This method is called when adding a new AwardCostShare
     * @param formHelper
     * @return
     * @throws Exception
     */
    public boolean addNote(InstitutionalProposalNotepadBean proposalNotepadBean) throws Exception {
        
        //AwardCostShareRuleEvent event = new AwardCostShareRuleEvent(
                                                            //"newAwardCostShare",
                                                           // formHelper.getAwardDocument(),
                                                           // formHelper.getNewAwardCostShare());
        //boolean success = new AwardCostShareRuleImpl().processAddCostShareBusinessRules(event);
            //if(success){
        proposalNotepadBean.getInstitutionalProposalDocument().getInstitutionalProposal().add(proposalNotepadBean.getNewInstitutionalProposalNotepad());
        proposalNotepadBean.init();
            //}
            //return success;
        return true;
    }
}
