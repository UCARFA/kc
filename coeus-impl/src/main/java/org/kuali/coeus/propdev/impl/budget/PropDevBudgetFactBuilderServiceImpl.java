/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.coeus.common.impl.krms.KcKrmsFactBuilderServiceHelper;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krms.api.engine.Facts;
import org.kuali.rice.krms.api.engine.Facts.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("propDevBudgetFactBuilderService")
public class PropDevBudgetFactBuilderServiceImpl extends KcKrmsFactBuilderServiceHelper {

    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, String docContent) {
    	throw new UnsupportedOperationException();
    }
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, KrmsRulesContext context) {
        Budget budget = (Budget) context;
        addBudgetFacts(factsBuilder,budget);
    }
    
    private void addBudgetFacts(Builder factsBuilder, Budget budget) {
        addObjectMembersAsFacts(factsBuilder,budget,KcKrmsConstants.PropDevBudget.BUDGET_CONTEXT_ID,Constants.MODULE_NAMESPACE_BUDGET);
        factsBuilder.addFact(KcKrmsConstants.PropDevBudget.BUDGET, budget);
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    

}
