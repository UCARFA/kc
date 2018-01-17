/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget.service.impl;

import org.kuali.kra.award.budget.AwardBudgetExt;
import org.kuali.kra.award.budget.document.AwardBudgetDocument;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.coeus.common.impl.krms.KcKrmsFactBuilderServiceHelper;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krms.api.engine.Facts;
import org.kuali.rice.krms.api.engine.Facts.Builder;

public class AwardBudgetFactBuilderServiceImpl extends KcKrmsFactBuilderServiceHelper {
    private DocumentService documentService;
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, String docContent) {
        String documentNumber = getElementValue(docContent, "//documentNumber");
        try {
            AwardBudgetDocument budgetDocument = (AwardBudgetDocument)getDocumentService().getByDocumentHeaderId(documentNumber);
            addFacts(factsBuilder, budgetDocument);
        }catch (WorkflowException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, KrmsRulesContext document) {
        AwardBudgetDocument budgetDocument = (AwardBudgetDocument)document;
        AwardBudgetExt budget = (AwardBudgetExt)budgetDocument.getBudget();
        addBudgetFacts(factsBuilder,budget);
    }
    
    private void addBudgetFacts(Builder factsBuilder, Budget budget) {
        addObjectMembersAsFacts(factsBuilder,budget,KcKrmsConstants.AwardBudget.BUDGET_CONTEXT_ID,Constants.MODULE_NAMESPACE_AWARD_BUDGET);
        factsBuilder.addFact(KcKrmsConstants.AwardBudget.BUDGET, budget);
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    

}
