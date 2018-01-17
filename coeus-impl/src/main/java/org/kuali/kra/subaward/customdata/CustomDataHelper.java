/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.customdata;

import org.kuali.coeus.common.framework.custom.CustomDataHelperBase;
import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocument;
import org.kuali.kra.subaward.SubAwardForm;
import org.kuali.rice.kew.api.WorkflowDocument;

import java.util.List;
import java.util.Map;

/**
 * This class is using for CustomDataHelper...
 */
public class CustomDataHelper extends CustomDataHelperBase<SubAwardCustomData> {
    private static final long serialVersionUID = -2308402022153534376L;
   
    /**
     * Each Helper must contain a reference to its document form
     * so that it can access the document.
     */
    private SubAwardForm subAwardForm;

    /**
     * Constructs a CustomDataHelper.
     * @param from the subAwardForm
     */
    public CustomDataHelper(SubAwardForm subAwardForm) {
        this.subAwardForm = subAwardForm;
    }

    @Override
    public boolean canModifyCustomData() {

        return false;
    }

    @Override
    protected SubAwardCustomData getNewCustomData() {
        return new SubAwardCustomData(); 
    }

    @Override
    public List<SubAwardCustomData> getCustomDataList() {
        return subAwardForm.getSubAward().getSubAwardCustomDataList();
    }

    @Override
    public Map<String, CustomAttributeDocument> getCustomAttributeDocuments() {
        return subAwardForm.getSubAwardDocument().getCustomAttributeDocuments();
    }

    @Override
    public boolean documentNotRouted() {
        WorkflowDocument doc = subAwardForm.getSubAwardDocument().getDocumentHeader().getWorkflowDocument();
        return doc.isSaved() || doc.isInitiated();
    }
}
