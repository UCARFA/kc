/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.customdata;

import org.kuali.coeus.common.framework.custom.CustomDataHelperBase;
import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocument;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.kew.api.WorkflowDocument;

import java.util.List;
import java.util.Map;

/**
 * The CustomDataHelper is used to manage the Custom Data tab web page.
 * It contains the data, forms, and methods needed to render the page.
 */

public class CustomDataHelper extends CustomDataHelperBase<AwardCustomData> {


    private static final long serialVersionUID = -2308402022153534376L;   
    
    /**
     * Each Helper must contain a reference to its document form
     * so that it can access the document.
     */
    private AwardForm awardForm;
    
    /**
     * Constructs a CustomDataHelper.
     * @param from the awardForm
     */
    public CustomDataHelper(AwardForm awardForm) {
        this.awardForm = awardForm;
    }
    
    /**
     * Get the Award.
     */
    private Award getAward() {
        AwardDocument document = awardForm.getAwardDocument();
        if (document == null || document.getAward() == null) {
            throw new IllegalArgumentException("invalid (null) AwardDocument in AwardForm");
        }
        return document.getAward();
    }

    @Override
    protected AwardCustomData getNewCustomData() {
        return new AwardCustomData();
    }

    @Override
    public List<AwardCustomData> getCustomDataList() {
        return getAward().getAwardCustomDataList();
    }

    @Override
    public Map<String, CustomAttributeDocument> getCustomAttributeDocuments() {
        return awardForm.getAwardDocument().getCustomAttributeDocuments();
    }

    @Override
    public boolean documentNotRouted() {
        WorkflowDocument doc = awardForm.getAwardDocument().getDocumentHeader().getWorkflowDocument();
        return doc.isSaved() || doc.isInitiated();
    }

}
