/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.custom;

import org.kuali.coeus.common.framework.custom.CustomDataHelperBase;
import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocValue;
import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocument;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.kew.api.WorkflowDocument;
import java.util.List;
import java.util.Map;

public class ProposalDevelopmentCustomDataHelper extends CustomDataHelperBase<CustomAttributeDocValue> {
    
    private static final long serialVersionUID = 4399783400354474904L;
    private ProposalDevelopmentDocument document;
    
    public ProposalDevelopmentCustomDataHelper(ProposalDevelopmentDocument document) {
        this.document = document;
    }

    @Override
    protected CustomAttributeDocValue getNewCustomData() {
       CustomAttributeDocValue customAttributeDocValue = new  CustomAttributeDocValue();
       customAttributeDocValue.setDocumentNumber(document.getDocumentNumber());
       return customAttributeDocValue;
    }

    @Override
    public List<CustomAttributeDocValue> getCustomDataList() {
        return document.getCustomDataList();
    }

    @Override
    public Map<String, CustomAttributeDocument> getCustomAttributeDocuments() {
        return document.getCustomAttributeDocuments();
    }

    @Override
    public boolean documentNotRouted() {
        WorkflowDocument doc = document.getDocumentHeader().getWorkflowDocument();
        return doc.isSaved() || doc.isInitiated();
    }

}
