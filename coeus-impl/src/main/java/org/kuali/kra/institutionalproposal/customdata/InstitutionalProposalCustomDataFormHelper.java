/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.customdata;

import org.kuali.coeus.common.framework.custom.CustomDataHelperBase;
import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocument;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;
import org.kuali.rice.kew.api.WorkflowDocument;

import java.util.List;
import java.util.Map;

public class InstitutionalProposalCustomDataFormHelper extends CustomDataHelperBase<InstitutionalProposalCustomData> {


    private static final long serialVersionUID = -716264183914346452L;
    
    private InstitutionalProposalForm institutionalProposalForm;
    
    /**
     * Constructs a CustomDataHelper.
     * @param from the awardForm
     */
    public InstitutionalProposalCustomDataFormHelper(InstitutionalProposalForm institutionalProposalForm) {
        this.institutionalProposalForm = institutionalProposalForm;
    }
    

    @Override
    public boolean canModifyCustomData() {

        return false;
    }


    @Override
    protected InstitutionalProposalCustomData getNewCustomData() {
        return new InstitutionalProposalCustomData();
    }

    @Override
    public List<InstitutionalProposalCustomData> getCustomDataList() {
        return institutionalProposalForm.getInstitutionalProposalDocument().getInstitutionalProposal().getInstitutionalProposalCustomDataList();
    }


    @Override
    public Map<String, CustomAttributeDocument> getCustomAttributeDocuments() {
        return institutionalProposalForm.getInstitutionalProposalDocument().getCustomAttributeDocuments();
    }

    @Override
    public boolean documentNotRouted() {
        WorkflowDocument doc = institutionalProposalForm.getInstitutionalProposalDocument().getDocumentHeader().getWorkflowDocument();
        return doc.isSaved() || doc.isInitiated();
    }

}
