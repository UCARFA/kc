/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.service.impl;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.coeus.common.impl.krms.KcKrmsFactBuilderServiceHelper;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krms.api.engine.Facts;
import org.kuali.rice.krms.api.engine.Facts.Builder;

public class SubAwardFactBuilderServiceImpl extends KcKrmsFactBuilderServiceHelper {
    private DocumentService documentService;
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, String docContent) {
        String documentNumber = getElementValue(docContent, "//documentNumber");
        try {
            SubAwardDocument subAwardDocument = (SubAwardDocument)getDocumentService().getByDocumentHeaderId(documentNumber);
            addFacts(factsBuilder, subAwardDocument);
        }catch (WorkflowException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, KrmsRulesContext document) {
        SubAwardDocument subAwardDocument = (SubAwardDocument)document;
        SubAward subAward = subAwardDocument.getSubAward();
        addSubAwardFacts(factsBuilder,subAward);
    }
    
    private void addSubAwardFacts(Builder factsBuilder, SubAward subAward) {
        addObjectMembersAsFacts(factsBuilder,subAward,KcKrmsConstants.SubAward.SUBAWARD_CONTEXT_ID,Constants.MODULE_NAMESPACE_SUBAWARD);
        factsBuilder.addFact(KcKrmsConstants.SubAward.SUBAWARD, subAward);
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

}
